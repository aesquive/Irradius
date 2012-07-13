package guardadores.Proyecto;

import Beans.Bean;
import Beans.General.LoginBean;
import Beans.Proyecto.Cetes;
import Beans.Proyecto.CreditoPuente;
import Beans.Proyecto.Inflacion;
import Beans.Proyecto.ProyectoEtapas;
import Beans.Proyecto.ProyectoFechas;
import Beans.Proyecto.ProyectosGeneradoresBean;
import Beans.Proyecto.ProyectosInfoBasica;
import Beans.Proyecto.Terreno;
import base.Catalogueador;
import base.Dao;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.DatPryInd;
import pojos.EtpMatPryInd;
import pojos.EtpPryInd;
import pojos.MatPryInd;
import pojos.PryPryInd;
import pojos.TipMatPryInd;
import pojos.VarPryInd;
import util.Espejo;
import util.EtapaProyecto;
import util.Funciones;
import util.ParametroGenerador;
import util.Parametros;
import util.RegistroFecha;

/**
 * Clase que se dedica a guardar los beans de la creacion de Proyectos.
 *
 * @author Galindo Martinez Jose Cruz
 * @author Gonzalez Teran Hector Daniel
 * @version 1.2
 * 
 */
public class GuardadorProyecto extends Bean {

    private LoginBean loginbean;
    private ProyectoEtapas etapas;
    private ProyectoFechas fechas;
    private ProyectosGeneradoresBean generadores;
    private ProyectosInfoBasica infoBasica;
    private Terreno terreno;
    private Cetes cetes;
    private CreditoPuente creditoPuente;
    private Inflacion inflacion;
    private Map<String, Object> mapeo;
    private LinkedList<Bean> listaBeans;
    /**
     * Dao para poder accesar a la base.
     */
    private final Dao dao;
    private PryPryInd proyectoInd;

    /**
     * Se encarga de crear un objeto que se encarga del guardado de 
     * los proyectos individuales.
     * @param loginbean
     * @param etapas
     * @param fechas
     * @param elementosVenta
     * @param estadosResultados
     * @param generadores
     * @param infoBasica 
     */
    public GuardadorProyecto(LoginBean loginbean, ProyectoEtapas etapas,
            ProyectoFechas fechas, ProyectosGeneradoresBean generadores,
            ProyectosInfoBasica infoBasica, Cetes argCetes,
            CreditoPuente argCreditoPuente, Inflacion argInflacion, Terreno argTerreno) {
        this.loginbean = loginbean;
        this.etapas = etapas;
        this.fechas = fechas;
        this.generadores = generadores;
        this.infoBasica = infoBasica;
        this.cetes = argCetes;
        this.creditoPuente = argCreditoPuente;
        this.inflacion = argInflacion;
        this.terreno = argTerreno;
        mapeo = new HashMap<String, Object>();
        dao = new Dao();
        llenarLista();
        llenarMapeo();
    }

    private void llenarLista() {
        listaBeans = new LinkedList<Bean>();
        listaBeans.add(infoBasica);
        listaBeans.add(generadores);
    }

    private void llenarMapeo() {
        Catalogueador catalogador = new Catalogueador();
        List<VarPryInd> variables = catalogador.getCatalogo(VarPryInd.class.getName());
        for (VarPryInd var : variables) {
            System.out.println("La Variable es: " + var.getDesLar());//>>>>>>>>>>>>>>>>>>>>>
            mapeo.put(var.getDesLar(), var);
            System.out.println("si hizo el mapeo bien, pasamos al siguiente metodo");//>>>>>>>>>>>
        }
        List<TipMatPryInd> tiposMatriz = catalogador.getCatalogo(TipMatPryInd.class.getName());
        for (TipMatPryInd tipMat : tiposMatriz) {
            System.out.println("La matriz es de tipo : " + tipMat.getDesTipMat());//>>>>>>>>>>>>>>>>>>>>>
            mapeo.put(tipMat.getDesTipMat(), tipMat);
            System.out.println("Si se hizo bien el mapeo");
        }
    }

    /**
     * Nos regresa una variable del mapeo
     * @param llave
     * @return una variable de proyecto
     */
    public VarPryInd getVariableProyectoIndividual(String llave) {
        System.out.println(">>>>> El nombre recibido es " + llave);
        return (VarPryInd) mapeo.get(llave);
    }

    /**
     * metodo que guarda el proyecto individual en la base de datos
     * @return 
     */
    public PryPryInd guardar() {
        guardarProyecto();
        guardarFechas(fechas);
        guardarComunes();
        guardarEspeciales(this.cetes, this.creditoPuente, this.inflacion, this.terreno);
        guardarEtapasProyecto(etapas);
        //UsuPryPryInd usuPry = new UsuPryPryInd(proyectoInd, loginbean.getUsuario());
        //dao.guardar(usuPry);
        dao.reiniciarSesion();
        return proyectoInd;
    }

    /**
     * Metodo que guarda el atributo proyecto para poder hacer la relacion con las demas tablas
     */
    private void guardarProyecto() {
        proyectoInd = new PryPryInd();
        proyectoInd.setEstPryInd(dao.getEstatusProyectoInd(1));
        proyectoInd.setFch(Calendar.getInstance());
        proyectoInd.setNomPry(infoBasica.getNombre());
        dao.guardar(proyectoInd);
        System.out.println("Ya guardo al papa de los pollitos");
        dao.reiniciarSesion();
    }

    /**
     * Guarda los beans que tienen un valor comun , es decir no son matrices ni etapas de tir
     * @param beans 
     */
    private void guardarComunes() {
        for (Bean bean : listaBeans) {
            if (bean != null) {
                List<Method> ters = Espejo.getGetters(bean.getClass());
                inyectarPojo(ters, bean);
            }
        }
    }

    /**
     * Se encarga de guardar los objetos especiales, los cuales son las matrices
     * @param nCetes La matriz de cetes
     * @param nCreditoPuente La matriz de Credito Puente
     * @param nInflacion La matriz de inflacion
     * @param nTerreno La matriz de pago de terreno
     */
    private void guardarEspeciales(Cetes nCetes, CreditoPuente nCreditoPuente,
            Inflacion nInflacion, Terreno nTerreno) {
        guardarMatriz("pagoTerreno", nTerreno.getLista());
        guardarMatriz("tasasCetes", nCetes.getLista());
        guardarMatriz("tasaInteresCreditoPuente", nCreditoPuente.getListaCreditoPuente());
        guardarMatriz("inflacion", nInflacion.getLista());
    }

    /**
     *
     */
    private void guardarEtapasProyecto(ProyectoEtapas etapasPry) {
        int consecutivo = 0;
        String[] atributos = {"ListaParametrosNo", "ListaParametrosPorcentajes",
            "NomEta", "ListaFechasVenta", "ListaFechasTitulacion"};
        LinkedList<EtapaProyecto> etapasProyecto = etapasPry.getEtapas();
        int numeroEtapas = Integer.parseInt(infoBasica.getNumEtapas().trim());
        for (int i = 0; i < numeroEtapas; i++) {
            EtapaProyecto etaPro = etapasProyecto.get(i);
            for (String att : atributos) {

                Object valor = Espejo.invocarGetter(etaPro, Espejo.getMetodo(etaPro.getClass(), "get" + att));
                System.out.println(">>>>>>>>>>>>>>>>>> el atribruto es " + att);
                if (valor != null) {
                    if (valor.getClass().equals(LinkedList.class)) {
                        LinkedList casteado = (LinkedList) valor;
                        guardarListaEtapas(i, casteado, att);
                    }
                    if (valor.getClass().equals(String.class)) {
                        EtpPryInd fila = new EtpPryInd(proyectoInd, getVariableProyectoIndividual(att), i, String.valueOf(valor));
                        dao.guardar(fila);
                    }
                }

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
        System.out.println("buscamos la variable de " + nombre);
        Class clase = valor.getClass();

        if (clase.equals(String.class) || clase.equals(Integer.class)) {
            guardarValor(getVariableProyectoIndividual(nombre), valor.toString());
        }
        if (clase.equals(Date.class)) {
            guardarValor(getVariableProyectoIndividual(nombre), Funciones.DateToString(valor));
        }
        if (clase.equals(LinkedList.class)) {
            guardarLista((List) valor);
        }
    }

    /**
     * metodo que se encarga de guardar un dato con el nombre variable , 
     * haciendo ya la relacion con el proyecto
     * @param variable
     * @param dato 
     */
    private void guardarValor(VarPryInd variable, String dato) {
        if (variable != null) {
            System.out.println("guardando " + variable.getDesTca() + " " + dato);
            DatPryInd datpryind = new DatPryInd(proyectoInd, variable, dato);
            dao.guardar(datpryind);
        }
    }

    /**
     * Cuando se recibe una lista , detectamos el tipo del que esta hecho y 
     * guardamos sus elementos
     * @param list 
     */
    private void guardarLista(List list) {
        for (Object obj : list) {
            Class clase = obj.getClass();
            if (clase.equals(Parametros.class)) {
                Parametros par = (Parametros) obj;
                guardarValor(getVariableProyectoIndividual(par.getRegistroDescripcion()), par.getRegistroIngreso());
            }
            if (clase.equals(ParametroGenerador.class)) {
                ParametroGenerador casteado = (ParametroGenerador) obj;
                guardarValor(getVariableProyectoIndividual(casteado.getDescripcion() + " monto"), casteado.getMonto());
                guardarValor(getVariableProyectoIndividual(casteado.getDescripcion() + " valor"), casteado.getPorcentajeValor());
            }
        }
    }

    /**
     * metodo que sabe guardar una matriz , ya sea edificacion , ventas obj titulacion
     * @param clave
     * @param lista 
     */
    private void guardarMatriz(String clave, LinkedList<RegistroFecha> lista) {
        TipMatPryInd tip = (TipMatPryInd) mapeo.get(clave);
        System.out.println("tipo de matriz" + tip);
        for (RegistroFecha reg : lista) {
            MatPryInd matriz = new MatPryInd();
            matriz.setPryPryInd(this.proyectoInd);
            Calendar c = Calendar.getInstance();
            c.setTime(generarFecha(reg.getFecha()));
            matriz.setFch(c);
            matriz.setTipMatPryInd(tip);
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
            Logger.getLogger(GuardadorProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void guardarFechas(ProyectoFechas fechas) {
        guardarValor(getVariableProyectoIndividual("FechaInicioCreditoPue"), Funciones.DateToString(fechas.getFechaFinCreditoPue()));
        guardarValor(getVariableProyectoIndividual("FechaFinCreditoPue"), Funciones.DateToString(fechas.getFechaFinCreditoPue()));
        guardarValor(getVariableProyectoIndividual("FechaInicioInflacion"), Funciones.DateToString(fechas.getFechaFinInflacion()));
        guardarValor(getVariableProyectoIndividual("FechaFinInflacion"), Funciones.DateToString(fechas.getFechaFinInflacion()));
        guardarValor(getVariableProyectoIndividual("FechaInicioTitulacion"), Funciones.DateToString(fechas.getFechaInicioTitulacion()));
        guardarValor(getVariableProyectoIndividual("FechaFinTitutlacion"), Funciones.DateToString(fechas.getFechaFinTitulacion()));
        guardarValor(getVariableProyectoIndividual("FechaInicioCetes"), Funciones.DateToString(fechas.getFechaInicioCetes()));
        guardarValor(getVariableProyectoIndividual("FechaFinCetes"), Funciones.DateToString(fechas.getFechaFinCetes()));
    }

//  public static void main(String[] args) {
//
//
//    ProyectosInfoBasica pib = new ProyectosInfoBasica();
//    pib.setNombre("name");
//    pib.setNumEtapas("2");
//    ProyectosGeneradoresBean pgb = new ProyectosGeneradoresBean();
//
//    GuardadorProyecto gp = new GuardadorProyecto(null, null, null, pgb, pib, null, null, null, null);
//    gp.guardar();
//  }
    private void guardarListaEtapas(int indiceEtapa, LinkedList casteado, String att) {
        for (Object c : casteado) {
            if (c.getClass().equals(Parametros.class)) {
                Parametros pr = (Parametros) c;
                VarPryInd variableProyectoIndividual = getVariableProyectoIndividual(pr.getRegistroDescripcion());
                if (variableProyectoIndividual != null) {
                    EtpPryInd etapa = new EtpPryInd(proyectoInd, variableProyectoIndividual, indiceEtapa, pr.getRegistroIngreso());
                    dao.guardar(etapa);
                }

            }
            if (c.getClass().equals(RegistroFecha.class)) {
                RegistroFecha fec = (RegistroFecha) c;
                if (fec.getPorcentaje() != null && !fec.getPorcentaje().equals("")) {
                    String nombreTipo = att.equals("ListaFechasVenta") ? "ventaEtapa" : "titulacionEtapa";
                    TipMatPryInd tipo = dao.obtenerTipoMatriz(nombreTipo);
                    Date generarFecha = generarFecha(fec.getFecha());
                    Calendar ins = Calendar.getInstance();
                    ins.setTime(generarFecha);
                    EtpMatPryInd fila = new EtpMatPryInd(tipo, proyectoInd, indiceEtapa, ins, fec.getPorcentaje());
                    dao.guardar(fila);
                }

            }
        }

    }
}
