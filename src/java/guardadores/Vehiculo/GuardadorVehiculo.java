package guardadores.Vehiculo;

import util.vehiculo.EscalonTir;
import Beans.Bean;
import Beans.General.LoginBean;
import Beans.Vehiculo.*;
import base.*;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.*;
import util.*;
import util.vehiculo.EtapaCapturaVehiculo;

/**
 *Clase que se dedica a guardar los beans de la creacion de parametros del modelo de vehiculo
 * 
 * @author Alberto Emmanuel Esquivel Vega
 * 
 */
public class GuardadorVehiculo {

    /**
     * Beans de el proyecto de vehiculo 
     */
    private LoginBean loginBean;
    private GeneralVehiculoBean general;
    private VehiculoFamiliaParametricasBean parametricas;
    private VehiculoFamiliaPremisasFinancieras financieras;
    private EtapasVehiculo etapas;
    private FechasBean fechas;
    private EdificacionBean matrizEdificacion;
    private VentaBean matrizVenta;
    private TitulacionBean matrizTitulacion;
    private VehiculoFamiliaPremisasInversion inversion;
    private EscalonesTirBean escalonesTir;
    private Map<String, Object> mapeo;
    /**
     * Dao para acceder a base de datos
     */
    private final Dao dao;
    /**
     * Proyecto raiz en el cual se guardara la informacion
     */
    private PryVeh proyecto;
    
    private boolean esModificado;
    
    private int indiceModificado;

    /**
     * Constructor
     * @param login
     * @param general
     * @param parametricas
     * @param financieras
     * @param fechas
     * @param matrizEdificacion
     * @param matrizVenta
     * @param matrizTitulacion
     * @param inversion
     * @param escalonesTir 
     */
    public GuardadorVehiculo(boolean modificado , int indiceProyectoModificado,LoginBean login, GeneralVehiculoBean general, VehiculoFamiliaParametricasBean parametricas, VehiculoFamiliaPremisasFinancieras financieras, EtapasVehiculo etapas, FechasBean fechas, EdificacionBean matrizEdificacion, VentaBean matrizVenta, TitulacionBean matrizTitulacion, VehiculoFamiliaPremisasInversion inversion, EscalonesTirBean escalonesTir) {
        this.esModificado=modificado;
        this.indiceModificado=indiceProyectoModificado;
        this.loginBean = login;
        this.general = general;
        this.parametricas = parametricas;
        this.etapas = etapas;
        this.financieras = financieras;
        this.fechas = fechas;
        this.matrizEdificacion = matrizEdificacion;
        this.matrizVenta = matrizVenta;
        this.matrizTitulacion = matrizTitulacion;
        this.inversion = inversion;
        this.escalonesTir = escalonesTir;
        mapeo = new HashMap<String, Object>();
        dao = new Dao();
        llenarMapeo();
    }

    /**
     * Nos llega el mapeo para saber el nombre de las variables de vehiculo . 
     * Vease tabla VarVeh en base de datos
     */
    public final void llenarMapeo() {
        Catalogueador catalogueador = new Catalogueador();
        List<VarVeh> variables = catalogueador.getCatalogo(VarVeh.class.getName());
        for (VarVeh var : variables) {
            mapeo.put(var.getDesLar(), var);
        }
        List<TipMatVeh> tiposMatriz = catalogueador.getCatalogo(TipMatVeh.class.getName());
        for (TipMatVeh tipMat : tiposMatriz) {
            mapeo.put(tipMat.getDesTipMat(), tipMat);
        }

    }

    /**
     * Nos regresa una variable del mapeo
     * @param llave
     * @return January-2012
     */
    public VarVeh getVariableVehiculo(String llave) {
        return (VarVeh) mapeo.get(llave);
    }

    /**
     * metodo que guarda el proyecto de vehiculo en la base de datos
     * @return 
     */
    public PryVeh guardar() {
        guardarProyecto();
        guardarFechas(fechas);
        guardarComunes(this.parametricas, this.financieras, this.inversion);
        guardarEspeciales(this.matrizEdificacion, this.matrizVenta, this.matrizTitulacion);
        guardarEtapasTIR(this.escalonesTir.getEscalones());
        guardarEtapasVehiculo(this.etapas);
        EstPryVeh estatus=dao.getEstatusProyecto(1);
        UsuPryVeh usuPry = new UsuPryVeh(loginBean.getUsuario(), proyecto,estatus);
        dao.guardar(usuPry);
        checarModificacion();
        checarActualizacion();
        dao.reiniciarSesion();
        return proyecto;
    }

    /**
     * Metodo que guarda el atributo proyecto para poder hacer la relacion con las demas tablas
     */
    private void guardarProyecto() {
        proyecto = new PryVeh();
        int moneda= parametricas.getTipoMoneda()>0 && parametricas.getTipoMoneda()<4 ? parametricas.getTipoMoneda() : 1;
        proyecto.setTipMon(dao.getTipMon(parametricas.getTipoMoneda()));
        proyecto.setFch(Calendar.getInstance());
        proyecto.setNomPry(parametricas.getNombreProyecto());
        dao.guardar(proyecto);
    }

    /**
     * Guarda los beans que tienen un valor comun , es decir no son matrices ni etapas de tir
     * @param beans 
     */
    private void guardarComunes(Bean... beans) {
        for (Bean bean : beans) {
            if (bean != null) {
                List<Method> ters = Espejo.getGetters(bean.getClass());
                inyectarPojo(ters, bean);
            }
        }
    }

    /**
     * Metodo que nos inyecta el pojo con cada uno de los valores del bean
     * @param ters
     * @param bean calendar
     */
    private void inyectarPojo(List<Method> ters, Bean bean) {
        for (Method m : ters) {
            Object valor = Espejo.invocarGetter(bean, m);
            if (valor != null) {
                guardarPorValores(valor, m.getName().substring(3, m.getName().length()));
            }
        }
    }

    /**
     * metodo que detecta el tipo de valor de la respuesta para ver la forma en la que se debe guardar
     * @param valor
     * @param nombre 
     */
    private void guardarPorValores(Object valor, String nombre) {
        Class clase = valor.getClass();
        if (clase.equals(String.class) || clase.equals(Integer.class)) {
            guardarValor(getVariableVehiculo(nombre), valor.toString());
        }
        if (clase.equals(Date.class)) {
            guardarValor(getVariableVehiculo(nombre), Funciones.DateToString(valor));
        }
        if (clase.equals(LinkedList.class)) {
            guardarLista((List) valor);
        }

    }

    /**
     * metodo que se encarga de guardar un dato con el nombre variable , haciendo ya la relacion con el proyecto
     * @param variable
     * @param dato 
     */
    private void guardarValor(VarVeh variable, String dato) {
        DatVeh datveh = new DatVeh(variable, proyecto, dato.replace(",", ""));
        dao.guardar(datveh);
    }

    /**
     * Cuando se recibe una lista , detectamos el tipo del que esta hecho y guardamos sus elementos
     * @param list 
     */
    private void guardarLista(List list) {
        for (Object o : list) {
            Class clase = o.getClass();
            if (clase.equals(Parametros.class)) {
                Parametros par = (Parametros) o;
                guardarValor(getVariableVehiculo(par.getRegistroDescripcion()), par.getRegistroIngreso());
            }

        }
    }

    /**
     * guardamos las matrices las cuales dependen del tiempo 
     * @param matrizEdificacion
     * @param matrizVenta
     * @param matrizTitulacion 
     */
    private void guardarEspeciales(EdificacionBean matrizEdificacion, VentaBean matrizVenta, TitulacionBean matrizTitulacion) {
        guardarMatriz("edificacion", matrizEdificacion.getLista());
        guardarMatriz("venta", matrizVenta.getListaVenta());
        if(matrizTitulacion!=null && matrizTitulacion.getListaTitulacion()!=null){
         
        guardarMatriz("titulacion", matrizTitulacion.getListaTitulacion());   
        }
    }

    /**
     * metodo que sabe guardar una matriz , ya sea edificacion , ventas o titulacion
     * @param clave
     * @param lista 
     */
    private void guardarMatriz(String clave, LinkedList<RegistroFecha> lista) {
        TipMatVeh tip = (TipMatVeh) mapeo.get(clave);
        for (RegistroFecha reg : lista) {
            MatVeh matriz = new MatVeh();
            matriz.setPryVeh(proyecto);
            Calendar c = Calendar.getInstance();
            c.setTime(generarFecha(reg.getFecha()));
            matriz.setFch(c);
            matriz.setTipMatVeh(tip);
            matriz.setVal(reg.getPorcentaje());
            dao.guardar(matriz);
        }
    }

    /**
     * metodo que convierte una fecha a un objeto tipo Date
     * @param fecha
     * @return 
     */
    private Date generarFecha(String fecha) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MMMMM-yyyy");
            Date fechasa = sdf.parse(fecha);
            return fechasa;
        } catch (ParseException ex) {
            Logger.getLogger(GuardadorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * metodo que nos guarda los escalones de Tir del proyecto de vehiculo
     * @param valores 
     */
    private void guardarEtapasTIR(List<EscalonTir> valores) {
        int consecutivo = 0;
        for (int i = 0; i < inversion.getNumeroEscalonesTIR(); i++) {
            EscalonTir esc = valores.get(i);
            List<Parametros> pars = esc.getValores();
            for (Parametros p : pars) {
                VarVeh variableVehiculo = getVariableVehiculo(p.getRegistroDescripcion());
                EtpTirVeh etpTir = new EtpTirVeh(variableVehiculo, proyecto, consecutivo, p.getRegistroIngreso());
                dao.guardar(etpTir);
            }
            consecutivo++;
        }

    }

    /**
     * metodo que verifica si lo que estamos haciendo es una actualizacion o un guardado
     */
    private void checarActualizacion() {
        if (general.getEstadoGrabacion() == GeneralVehiculoBean.ACTUALIZAR) {
            PryVeh proyectoSeleccionado = general.getProyectoSeleccionado();
            
            dao.remove(proyectoSeleccionado);
        }
    }

    private void guardarEtapasVehiculo(EtapasVehiculo etapas) {
        int consecutivo = 0;
        String[] atributos = new String[]{"FechaInicioEtapa", "FechaFinEtapa", "ViviendasEtapa"};
        List<EtapaCapturaVehiculo> etapasVehiculo = etapas.getEtapas();
        for (int i=0;i<financieras.getNumeroEtapas();i++) {
            EtapaCapturaVehiculo etapa=etapasVehiculo.get(i);
            for(String atr:atributos){
                VarVeh variable=getVariableVehiculo(atr);
                Object valor = (Espejo.invocarGetter(etapa,Espejo.getMetodo(etapa.getClass(),"get"+atr)));
                String resultado= valor.getClass().equals(Date.class) ? Funciones.DateToString((Date) valor) : String.valueOf(valor);
                EtpVeh guardable=new EtpVeh(variable, proyecto, consecutivo,resultado);
                dao.guardar(guardable);
            }
            consecutivo++;
        }
    }

    private void guardarFechas(FechasBean fechas) {
        guardarValor(getVariableVehiculo("FechaInicioEdificacion"), Funciones.DateToString(fechas.getFechaInicioEdificacion()));
        guardarValor(getVariableVehiculo("FechaFinEdificacion"), Funciones.DateToString(fechas.getFechaFinEdificacion()));
        guardarValor(getVariableVehiculo("FechaInicioVenta"), Funciones.DateToString(fechas.getFechaInicioVenta()));
        guardarValor(getVariableVehiculo("FechaFinVenta"), Funciones.DateToString(fechas.getFechaFinVenta()));
        fechas.setFechaInicioTitulacion(Calendar.getInstance().getTime());
        fechas.setFechaFinTitutlacion(Calendar.getInstance().getTime());
        guardarValor(getVariableVehiculo("FechaInicioTitulacion"), Funciones.DateToString(fechas.getFechaInicioTitulacion()));
        guardarValor(getVariableVehiculo("FechaFinTitutlacion"), Funciones.DateToString(fechas.getFechaFinTitutlacion()));
    }

    private void checarModificacion() {
        if(esModificado){
            PryVeh proyectoVehiculo = dao.getProyectoVehiculo(indiceModificado);
            Set<RelMdlVeh> relMdlVehs = proyectoVehiculo.getRelMdlVehs();
            for(RelMdlVeh rel:relMdlVehs){
                dao.guardar(new RelMdlVeh(rel.getMdlVeh(), proyecto));
            }
            Set<UsuPryVeh> usuPryVehs = proyectoVehiculo.getUsuPryVehs();
            Usu u=dao.getUsu(loginBean.getUsuario().getId());
            for(UsuPryVeh us:usuPryVehs){
                dao.guardar(new UsuPryVeh(u, proyecto, us.getEstPryVeh()));
            }
        }
    }
}
