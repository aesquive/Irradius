package llenadores.vehiculo;

import Beans.Bean;
import Beans.Vehiculo.*;
import base.Dao;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.faces.context.FacesContext;
import pojos.DatVeh;
import pojos.EtpTirVeh;
import pojos.EtpVeh;
import pojos.MatVeh;
import pojos.PryVeh;
import util.Espejo;
import util.vehiculo.EscalonTir;
import util.Funciones;
import util.Parametros;
import util.RegistroFecha;
import util.vehiculo.EtapaCapturaVehiculo;

/**
 * Clase que se encarga de llenar los beans necesarios para la modificacion o copia de proyectos del modelo de vehiculo
 * @author Alberto 
 */
public class LlenadorBeansCapturaVehiculo {

    /**
     * el proyecto con el cual llenaremos los beans de JSF
     */
    private final PryVeh proyecto;
    /**
     * los diferentes beans que debemos llenar para JSF
     */
    private VehiculoFamiliaParametricasBean parametricas;
    private VehiculoFamiliaPremisasFinancieras financieras;
    private EtapasVehiculo etapas;
    private FechasBean fechas;
    private EdificacionBean matrizEdificacion;
    private VentaBean matrizVenta;
    private TitulacionBean matrizTitulacion;
    private VehiculoFamiliaPremisasInversion inversion;
    private EscalonesTirBean escalonesTir;
    /**
     * mapeo donde guardaremos todos los datos del proyecto
     */
    private Map<String, DatVeh> mapeoDatos;
    /**
     * las listas de las que estan conformadas los beans
     */
    private static final String[] listaParametricas = {"veh_trr", "veh_urb", "veh_edf", "veh_gav", "veh_gts_ind", "veh_cif", "veh_ebt"};
    private static final String[] listaNumFinancieras = {"veh_cap_inv", "veh_mes_cnf_ant", "veh_val_pro_viv"};
    private static final String[] listaPorcentajesFinancieras = {"veh_por_apa", "veh_por_crd_pte", "veh_ant_crd_pte", "veh_tsa_anu_crd_pte",
        "veh_com_crd_pte", "veh_app", "veh_sapi", "veh_ant_vta"};
    private static final String[] listaInversion = {"veh_fac_cja_min", "veh_dis_uti_vid_pry"};
    /**
     * Indices de los tipos de matrices
     */
    private static int MATRIZ_EDIFICACION = 1;
    private static int MATRIZ_VENTA = 2;
    private static int MATRIZ_TITULACION = 3;

    /**
     * Constructor
     * @param proyecto 
     */
    public LlenadorBeansCapturaVehiculo(PryVeh proyecto) {
        this.parametricas = new VehiculoFamiliaParametricasBean(null);
        this.financieras = new VehiculoFamiliaPremisasFinancieras(null);
        this.etapas = new EtapasVehiculo(null);
        this.fechas = new FechasBean(null);
        this.matrizEdificacion = new EdificacionBean(null);
        this.matrizVenta = new VentaBean(null);
        this.matrizTitulacion = new TitulacionBean(null);
        this.inversion = new VehiculoFamiliaPremisasInversion(null);
        this.escalonesTir = new EscalonesTirBean(null);
        this.proyecto = proyecto;
        mapeoDatos = new HashMap<String, DatVeh>();
    }

    /**
     * metodo que se encarga de llenar los beans distribuyendo los procesos para cada uno
     */
    public void llenarBeans() {
        generarMapeoDatos(proyecto.getDatVehs());
        llenarParametricas();
        llenarFinancieras();
        llenarFechas();
        ponerSesionParaEditar(fechas);

        llenarInversion();
        matrizEdificacion.setLista(generarMatriz(proyecto.getMatVehs(), MATRIZ_EDIFICACION));
        matrizVenta.setListaVenta(generarMatriz(proyecto.getMatVehs(), MATRIZ_VENTA));
        matrizTitulacion.setListaTitulacion(generarMatriz(proyecto.getMatVehs(), MATRIZ_TITULACION));
        llenarEscalonesTIR(proyecto.getEtpTirVehs());
        llenarEtapasBean(proyecto.getEtpVehs());
        meterBeans();

    }

    /**
     * metodo que nos llena el bean de inversion
     */
    private void llenarInversion() {
        inversion.setLista(generarLista(listaInversion));
        inversion.setNumeroEscalonesTIR(Integer.parseInt(obtenerValorMapeo("veh_num_etp_tir")));
    }

    /**
     * metodo que nos llena el bean de fechas
     */
    private void llenarFechas() {
        if (obtenerValorMapeo("veh_mes_ini_tit") != null && obtenerValorMapeo("veh_mes_fin_tit") != null) {

            fechas.ponerFechas(Funciones.StringToDate(obtenerValorMapeo("veh_mes_ini_edf")), Funciones.StringToDate(obtenerValorMapeo("veh_mes_fin_edf")),
                    Funciones.StringToDate(obtenerValorMapeo("veh_mes_ini_com")), Funciones.StringToDate(obtenerValorMapeo("veh_mes_fin_com")),
                    Funciones.StringToDate(obtenerValorMapeo("veh_mes_ini_tit")),
                    Funciones.StringToDate(obtenerValorMapeo("veh_mes_fin_tit")));

        } else {
            fechas.ponerFechas(Funciones.StringToDate(obtenerValorMapeo("veh_mes_ini_edf")), Funciones.StringToDate(obtenerValorMapeo("veh_mes_fin_edf")),
                    Funciones.StringToDate(obtenerValorMapeo("veh_mes_ini_com")), Funciones.StringToDate(obtenerValorMapeo("veh_mes_fin_com")),
                    null,
                    null);
        }

    }

    /**
     * metodo que nos llena el bean de parametricas
     */
    private void llenarParametricas() {
        parametricas.setTipoMoneda(proyecto.getTipMon().getId());
        parametricas.setLista(generarLista(listaParametricas));
        parametricas.setNombreProyecto(obtenerValorMapeo("veh_nom_pry"));
        parametricas.setValor(obtenerValorMapeo("veh_val"));
    }

    /**
     * metodo que nos llena el bean de financieras
     */
    private void llenarFinancieras() {
        financieras.setNumeroEtapas(Integer.parseInt(obtenerValorMapeo("veh_num_eta")));
        financieras.setListaNum(generarLista(listaNumFinancieras));
        financieras.setListaPorcentaje(generarLista(listaPorcentajesFinancieras));
    }

    /**
     * metodo que nos obtiene algun valor dentro del mapeo de los datos de el proyecto de vehiculo
     * @param llave
     * @return 
     */
    private String obtenerValorMapeo(String llave) {
        DatVeh dato = mapeoDatos.get(llave);
        return dato == null ? null : dato.getVal();
    }

    /**
     * nos ayuda a generar una lista de objetos de tipo parametro para asignarla a los beans
     * @param listaParametricas
     * @return 
     */
    private LinkedList<Parametros> generarLista(String[] listaParametricas) {
        LinkedList<Parametros> lista = new LinkedList<Parametros>();
        for (String llave : listaParametricas) {
            System.out.println("llave " + llave);
            DatVeh dato = mapeoDatos.get(llave);
            String valor = dato.getVal().contains("%") ? Funciones.cambiarPorcentajes(dato.getVal()) : Funciones.ponerComasCantidades(Double.parseDouble(dato.getVal()));
            Parametros param = new Parametros(dato.getVarVeh().getDesLar(), valor);
            lista.add(param);
        }
        return lista;
    }

    /**
     * nos genera el mapeo de los datos del proyecto teniendo como llave la descripcion tecnica de cada variable
     * @param datos 
     */
    private void generarMapeoDatos(Set<DatVeh> datos) {
        Iterator<DatVeh> iterator = datos.iterator();
        while (iterator.hasNext()) {
            DatVeh dato = iterator.next();
            if (dato != null && dato.getVarVeh()!=null) {
                System.out.println("metiendo " + dato.getVarVeh().getDesTca() + " valor " + dato);
                mapeoDatos.put(dato.getVarVeh().getDesTca(), dato);
            }

        }
    }

    /**
     * Nos genera la lista de celdas que traera cada una de las matrices  bidimensionales
     * @param matrices
     * @param tipoDeMatriz
     * @return 
     */
    private LinkedList<RegistroFecha> generarMatriz(Set<MatVeh> matrices, int tipoDeMatriz) {
        LinkedList<RegistroFecha> lista = new LinkedList<RegistroFecha>();
        for (MatVeh renglonMatriz : matrices) {
            if (renglonMatriz.getTipMatVeh().getId() == tipoDeMatriz) {
                lista.add(new RegistroFecha(Funciones.castearMatrizMes(renglonMatriz.getFch().getTime()), renglonMatriz.getVal()));
            }
        }
        Collections.sort(lista);
        return lista;
    }

    /**
     * Nos llena el proceso de los escalones de tir
     * @param etpTirVehs 
     */
    private void llenarEscalonesTIR(Set<EtpTirVeh> etpTirVehs) {
        Set<EtpTirVeh> copia = etpTirVehs;
        LinkedList<EscalonTir> escalones = new LinkedList<EscalonTir>();
        int consecutivo = 0;
        int totalEscalones = etpTirVehs.size() / 2;
        while (consecutivo < totalEscalones) {
            LinkedList<Parametros> parametrosEscalon = new LinkedList<Parametros>();
            Parametros param = new Parametros(null, null);
            Iterator<EtpTirVeh> iterator = etpTirVehs.iterator();
            while (iterator.hasNext()) {
                EtpTirVeh fila = iterator.next();
                if (fila.getNumEta() == consecutivo) {
                    if (fila.getVarVeh().getDesTca().equals("veh_tir_etp")) {
                        System.out.println("cae aqui con el consec " + consecutivo);
                        param.setRegistroDescripcion("TIR de escalon");
                        param.setRegistroIngreso(fila.getVal());
                    }
                    if (fila.getVarVeh().getDesTca().equals("veh_dis_inv")) {
                        System.out.println("cae aca con el consec " + consecutivo);
                        param.setRegistroDescripcion("% de Distribucion al Inversionista");
                        param.setRegistroIngreso(fila.getVal());
                    }
                    if (param.getRegistroDescripcion() != null && param.getRegistroIngreso() != null) {

                        parametrosEscalon.add(param);
                        param = new Parametros(null, null);
                    }
                }
            }
            etpTirVehs = copia;
            escalones.add(new EscalonTir(parametrosEscalon));
            consecutivo++;
        }
        escalonesTir.setEscalones(escalones);
        escalonesTir.setValores(escalones.get(0).getValores());
    }

    /**
     * mete un bean a la sesion de jsf
     * @param nombre
     * @param bean 
     */
    private void meterAFaces(String nombre, Bean bean) {
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap();
        sessionMap.put(nombre, bean);
    }

    /**
     * metemos los beans a la sesion de jsf
     */
    private void meterBeans() {
        meterAFaces("vehiculoParametricas", parametricas);
        meterAFaces("vehiculoFinancieras", financieras);
        meterAFaces("vehiculoInversion", inversion);
        meterAFaces("fechasBean", fechas);
        meterAFaces("edificacionBean", matrizEdificacion);
        escalonesTir.asignarBoton();
        meterAFaces("escalonesTir", escalonesTir);
        meterAFaces("titulacionBean", matrizTitulacion);
        meterAFaces("ventaBean", matrizVenta);
        meterAFaces("etapasVehiculo", etapas);
    }

    /**
     * metodo de pruebas
     * @param args 
     */
    public static void main(String[] args) {
        Dao dao = new Dao();
        PryVeh proyectoVehiculo = dao.getProyectoVehiculo(13);
        LlenadorBeansCapturaVehiculo ll = new LlenadorBeansCapturaVehiculo(proyectoVehiculo);
        ll.llenarBeans();
    }

    private void llenarEtapasBean(Set<EtpVeh> etapasVehiculo) {
        Set<EtpVeh> copia = etapasVehiculo;
        List<EtapaCapturaVehiculo> listaEtapas = new LinkedList<EtapaCapturaVehiculo>();
        int consecutivo = 0;
        int totalEscalones = etapasVehiculo.size() / 3;
        while (consecutivo < totalEscalones) {
            EtapaCapturaVehiculo etapaVehiculo = new EtapaCapturaVehiculo(0, null, null);
            Iterator<EtpVeh> iterator = etapasVehiculo.iterator();
            while (iterator.hasNext()) {
                EtpVeh fila = iterator.next();
                if (fila.getNumEta() == consecutivo) {
                    if (fila.getVarVeh().getDesTca().equals("veh_viv_etp")) {
                        etapaVehiculo.setViviendasEtapa(Integer.parseInt(fila.getVal()));
                    }
                    if (fila.getVarVeh().getDesTca().equals("veh_fec_ini_eta")) {
                        etapaVehiculo.setFechaInicioEtapa(Funciones.StringToDate(fila.getVal()));
                    }
                    if (fila.getVarVeh().getDesTca().equals("veh_fec_fin_eta")) {
                        etapaVehiculo.setFechaFinEtapa(Funciones.StringToDate(fila.getVal()));
                    }
                }
            }
            etapasVehiculo = copia;
            listaEtapas.add(etapaVehiculo);
            consecutivo++;
        }
        etapas.setEtapas(listaEtapas);
        etapas.setViviendasEtapa(listaEtapas.get(0).getViviendasEtapa());
        etapas.setFechaInicioEtapa(listaEtapas.get(0).getFechaInicioEtapa());
        etapas.setFechaFinEtapa(listaEtapas.get(0).getFechaFinEtapa());
    }

    private void ponerSesionParaEditar(FechasBean fechas) {
        List<Method> ters = Espejo.getGetters(FechasBean.class);
        for (Method m : ters) {
            Funciones.ponerAtributo(m.getName(), Espejo.invocarGetter(fechas, m));
        }
    }
}
