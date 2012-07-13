package calculador.vehiculo;

import Beans.Bean;
import Beans.Vehiculo.Pantallas.ConsolidadoBean;
import Beans.Vehiculo.Pantallas.EtapasModeloVehiculoBean;
import base.Dao;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.MeterGaugeChartModel;
import pojos.DatVeh;
import pojos.EtpTirVeh;
import pojos.MdlVeh;
import pojos.PryVeh;
import pojos.RelMdlVeh;
import util.Eneada;
import util.Espejo;
import util.Funciones;
import util.MatrizBidimensional;
import util.MatrizBidimensionalIndice;
import util.Parametros;
import util.vehiculo.Coordenada;
import util.vehiculo.EtapaCapturaVehiculo;
import util.vehiculo.ListaEtapasVehiculo;
import variables.ManejadorVariablesVehiculo;

/**
 *Clase que se encarga de distribuir el calculo de modelo de vehiculo en diferentes clases , repartiendo
 * por pestanas del excel de modelo espana
 * 
 * @author Alberto Emmanuel Esquivel Vega
 */
public class DistribuidorModeloVehiculo {

    /**
     * Manejador de las variables de vehiculo
     */
    private ManejadorVariablesVehiculo manejador;
    /**
     * Lista de proyectos que seran evaluados en el modelo
     */
    private List<PryVeh> proyectos;
    private boolean procesarIndividuales;
    private int tiempoMinistracion;
    private int tiempoPago;

    private double probabilidadIncumplimiento;
    private double porcentajeRecuperacion;
    
    
    public DistribuidorModeloVehiculo(int indiceProyecto ,List<PryVeh> proyectos , boolean procesarIndividuales , ManejadorVariablesVehiculo manejador , 
               int tiempoMinistracion , int tiempoPago){
        probabilidadIncumplimiento=-1;
        porcentajeRecuperacion=-1;
        this.tiempoMinistracion = tiempoMinistracion;
        this.tiempoPago = tiempoPago;
        this.procesarIndividuales = procesarIndividuales;
        this.proyectos = proyectos;
      //  this.manejador = Funciones.generarCopiaManejador(manejador,indiceProyecto);
    }
    /**
     * COnstructor
     * @param proyectos 
     */
    public DistribuidorModeloVehiculo(List<PryVeh> proyectos, boolean procesarIndividuales,int tiempoMinistracion , int tiempoPago) {
        probabilidadIncumplimiento=-1;
        porcentajeRecuperacion=-1;
        this.tiempoMinistracion = tiempoMinistracion;
        this.tiempoPago = tiempoPago;
        this.procesarIndividuales = procesarIndividuales;
        this.proyectos = proyectos;
        this.manejador = new ManejadorVariablesVehiculo(proyectos);
    }
    
    
     public void llenarBeanConsolidado() {
        ConsolidadoBean consolidado = new ConsolidadoBean();
        List<Method> getters = Espejo.getGetters(consolidado.getClass());
        for (Method m : getters) {
            if (!m.getName().equals("getVeh_cet_ptj_tir_pry")) {
                MatrizBidimensional matriz = (MatrizBidimensional) getManejador().obtenerVariable(m.getName().substring(3, m.getName().length()).toLowerCase());
                Espejo.invocarSetterMatriz(m.getName().substring(3, m.getName().length()), consolidado, matriz);
            }
        }

        ponerTirs(consolidado);

        Bean.ponerSesion("consolidadoBean", consolidado);

    }
     
     
    private void ponerTirs(ConsolidadoBean consolidado) {
        List<Parametros> lista = new LinkedList<Parametros>();
        Double valor = (Double) manejador.obtenerVariable("veh_cet_ptj_tir_pry") * 100;
        String cadena = String.valueOf(Funciones.redondearDecimales(valor, 2));

        for (int t = 0; t < proyectos.size(); t++) {
            DistribuidorModeloVehiculo dis = (DistribuidorModeloVehiculo) manejador.obtenerVariable("dis" + t);
            Double valor2 = (Double) dis.getManejador().obtenerVariable("veh_cet_ptj_tir_pry") * 100;
            String cadena2 = String.valueOf(Funciones.redondearDecimales(valor2, 2));
            lista.add(new Parametros("TIR DE " + proyectos.get(t).getNomPry(), cadena2));
        }
        Collections.sort(lista);
        lista.add(0, new Parametros("TIR DE VEHICULO", cadena));
        consolidado.setVeh_cet_ptj_tir_pry(lista);
    }
     
     public void llenarBeansEtapas(int indiceProyecto) {
        EtapasModeloVehiculoBean generarEtapaModeloVehiculo = generarEtapaModeloVehiculo(indiceProyecto);
        llenarEtapasModelos(generarEtapaModeloVehiculo, indiceProyecto);
    }
     
     private void llenarEtapasModelos(EtapasModeloVehiculoBean modelo, int indice) {
        modelo.setIndiceActual(indice);
        modelo.setNumeroProyectos(getProyectos().size());
        Bean.ponerSesion("etapasModeloVehiculoBean", modelo);
    }
     
    private EtapasModeloVehiculoBean generarEtapaModeloVehiculo(int inProyecto) {
        EtapasModeloVehiculoBean etapa = new EtapasModeloVehiculoBean();
        etapa.setNombreProyecto(getProyectos().get(inProyecto).getNomPry());

        List<Method> getters = Espejo.getGetters(etapa.getClass());
        for (Method m : getters) {
            if (m.getReturnType().equals(List.class)) {
                List<MatrizBidimensional> actual = sacarValoresManejador(m.getName().substring(3, m.getName().length()), inProyecto);
                List<MatrizBidimensionalIndice> actInd=ponerIndices(actual);
                Espejo.invocaSetterVehiculoLista(m.getName().substring(3, m.getName().length()), etapa, actInd);
            }
        }
        return etapa;
    }

    private List<MatrizBidimensionalIndice> ponerIndices(List<MatrizBidimensional> actual) {
        List<MatrizBidimensionalIndice> matInd=new LinkedList<MatrizBidimensionalIndice>();
        int t=1;
        for(MatrizBidimensional ma:actual){
            if(ma!=null){
               MatrizBidimensionalIndice ind=new MatrizBidimensionalIndice();
            ind.setCeldas(ma.getCeldas());
            ind.setNombre(String.valueOf(t));
            matInd.add(ind);
            t++; 
            }
            
        }
        return matInd;
    }


    /**
     * metodo que modela individualmente los proyectos del vehiculo
     * @param respectivoManejador
     * @param proyecto 
     */
    protected void modelarIndividual(ManejadorVariablesVehiculo respectivoManejador, PryVeh proyecto) {
        System.out.println("inicio ind " + proyecto.getNomPry());
        CalculadorEtapas calculadorEtapas = new CalculadorEtapas(getProyectos(), respectivoManejador);
        calculadorEtapas.procesar();
        System.out.println("etapas ind " + proyecto.getNomPry());
        ConsolidadorEtapas consolidadorEtapas = new ConsolidadorEtapas(getTiempoMinistracion(), getTiempoPago(), getProyectos(), respectivoManejador);
        consolidadorEtapas.procesar();
        System.out.println("calctir ind " + proyecto.getNomPry());
        CalculadorTir calculadorTir = new CalculadorTir(tiempoMinistracion, tiempoPago, getProyectos(), respectivoManejador);
        calculadorTir.procesarIndividual();
        System.out.println("termino ind " + proyecto.getNomPry());
        System.out.println("la tir del proyecto " + proyecto.getNomPry() + "=" + manejador.obtenerVariable("veh_cet_ptj_tir_pry"));
    }

    /**
     * Metodo que mandara a hacer todos los calculos del modelo espana
     */
    public void modelarPrincipal() {
        Object[] capital = (Object[]) manejador.obtenerVariable("veh_cap_inv");
        for(int t=0;t<capital.length;t++){
            System.out.println("el capital al inicio de "+proyectos.get(t).getNomPry()+" es de "+capital[t]);
        }
        
        CalculadorEtapas calculadorEtapas = new CalculadorEtapas(getProyectos(), getManejador());
        calculadorEtapas.procesar();
        System.out.println("salio de aqui");
        ConsolidadorEtapas consolidadorEtapas = new ConsolidadorEtapas(getTiempoMinistracion(), getTiempoPago(), getProyectos(), getManejador());
        consolidadorEtapas.procesar();
        System.out.println("salio de aca");
        CalculadorTir calculadorTir = new CalculadorTir(tiempoMinistracion, tiempoPago, getProyectos(), getManejador());
        calculadorTir.procesarPrincipal(procesarIndividuales);

        System.out.println("la tir " + manejador.obtenerVariable("veh_cet_ptj_tir_pry"));
    
        Object[] capital2 = (Object[]) manejador.obtenerVariable("veh_cap_inv");
        for(int t=0;t<capital2.length;t++){
            System.out.println("el capital al final de "+proyectos.get(t).getNomPry()+" es de "+capital2[t]);
        }
    }

    public void generarEdoResultados() {
        EstadoResultados estadoResultados = new EstadoResultados(getProyectos(), getManejador());
        estadoResultados.procesar();

        Balance balance = new Balance(proyectos, getManejador());
        balance.procesar();
    }

    private List<MatrizBidimensional> sacarValoresManejador(String nombreLlave, int inProyecto) {
        int numEtapas = getProyectos().get(inProyecto).getEtpVehs().size() / 3;
        List<MatrizBidimensional> matrices = new LinkedList<MatrizBidimensional>();
        int contador = 0;
        while (contador < numEtapas) {
            MatrizBidimensional actual = (MatrizBidimensional) getManejador().obtenerVariable(nombreLlave.toLowerCase() + "[" + inProyecto + "][" + contador + "]");
            matrices.add(actual);
            contador++;
        }
        return matrices;
    }

    /**
     * @return the manejador
     */
    public ManejadorVariablesVehiculo getManejador() {
        return manejador;
    }

    /**
     * @param manejador the manejador to set
     */
    public void setManejador(ManejadorVariablesVehiculo manejador) {
        this.manejador = manejador;
    }

    /**
     * @return the proyectos
     */
    public List<PryVeh> getProyectos() {
        return proyectos;
    }

    /**
     * @param proyectos the proyectos to set
     */
    public void setProyectos(List<PryVeh> proyectos) {
        this.proyectos = proyectos;
    }

    private Object sacarValorEscalonTir(int idVar, int indice, Set<EtpTirVeh> etpTirVehs) {
        Iterator<EtpTirVeh> iterator = etpTirVehs.iterator();
        while (iterator.hasNext()) {
            EtpTirVeh next = iterator.next();
            if (next.getNumEta() == indice && next.getVarVeh().getId() == idVar) {
                return castearVAlor(next.getVal());
            }
        }
        return null;
    }

    private Object castearVAlor(String val) {
        Object regreso=null;
        if (val.contains("%")) {
            regreso = val.substring(0, val.length() - 1);
        }  else if (val.contains(",")) {
            regreso = regreso!=null ? regreso.toString().replace(",",""):val.replace(",", "");
        } else {
            regreso = val;
        }
        try {
            return Double.parseDouble(String.valueOf(regreso));

        } catch (NumberFormatException num) {
            DistribuidorModeloVehiculo dis = new DistribuidorModeloVehiculo(proyectos, false,tiempoMinistracion,tiempoPago);
            dis.modelarPrincipal();
            return val;
        }

    }

    private double sacarCrecimiento(String primerParametro) {
        if (primerParametro.equals("Precio Promedio")) {
            return .05;
        }
        if (primerParametro.equals("Tasa Interes")) {
            return .5;
        }
        if (primerParametro.equals("Porcentaje Apalancamiento")) {
            return 2;
        }
        return 0;
    }

   

    public static void main(String[] args) {
//        String cad="26,784";
//        String replace = cad.replace(",","");
//        System.out.println(replace);
//        Dao dao = new Dao();
//        List<PryVeh> proyectos = new LinkedList<PryVeh>();
//        MdlVeh mdl=dao.getModelo(55);
//        Set<RelMdlVeh> relMdlVehs = mdl.getRelMdlVehs();
//        for(RelMdlVeh rel:relMdlVehs){
//            System.out.println(rel.getPryVeh().getNomPry());
//            proyectos.add(rel.getPryVeh());
//        }
//        DistribuidorModeloVehiculo dis = new DistribuidorModeloVehiculo(proyectos, false,18,12);
//        
//        dis.modelarPrincipal();
//        System.out.println("aqui que pasa");
//        System.out.println(dis.obtenerVariable("veh_cet_uni_edf"));
//        dis.generarEdoResultados();
//                dis.modelarPrincipal();
//                System.out.println("-----------------------------");
//        double sacarValorVivienda = dis.sacarValorVivienda();
//                dis.llenarBeanMapa(null, "veh_val_pro_viv", "veh_tsa_anu_crd_pte", sacarValorVivienda, 11.5);
    }

    public String obtenerValorDistribuidor() {
        this.modelarPrincipal();
        Double obtenerVariable = (Double) manejador.obtenerVariable("veh_cet_ptj_tir_pry") * 100;
        String cadena2 = String.valueOf(Funciones.redondearDecimales(obtenerVariable, 2));
        return cadena2;
    }

    private void modificarProyectos(List<Double> proporcionesPrecio, String parametro, String valor) {
        String clave = parametro.equals("Precio Promedio") ? "veh_val_pro_viv" : parametro.equals("Tasa Interes") ? "veh_tsa_anu_crd_pte" : "veh_por_apa";
        if (clave.equals("veh_val_pro_viv")) {
            modificarPrecioCasas(proporcionesPrecio, clave, valor);
            return;
        }
        Object[] arreglo = (Object[]) manejador.obtenerVariable(clave);
        for (int t = 0; t < proyectos.size(); t++) {
            arreglo[t] = valor;
        }
        manejador.guardarVariable(clave, arreglo);
    }

    private void modificarPrecioCasas(List<Double> proporcionesPrecio, String clave, String valor) {
        for (int indiceProyecto = 0; indiceProyecto < proyectos.size(); indiceProyecto++) {
            valor = valor.replace(",", "");
            double nuevo = Double.parseDouble(valor) * proporcionesPrecio.get(indiceProyecto);
            guardarValorVivienda(indiceProyecto, nuevo);
        }
    }

    private double sacarPrecioPromedioViejo() {
        double suma = 0;
        for (int indiceProyecto = 0; indiceProyecto < proyectos.size(); indiceProyecto++) {
            Object[] valoresViviendas = (Object[]) manejador.obtenerVariable("veh_val_pro_viv");
            suma += Double.parseDouble(String.valueOf(valoresViviendas[indiceProyecto]));
        }
        return suma / proyectos.size();
    }

    private double sacarValorVivienda(int indiceProyecto) {
        Object[] valoresViviendas = (Object[]) manejador.obtenerVariable("veh_val_pro_viv");
        return Double.parseDouble(String.valueOf(valoresViviendas[indiceProyecto]));
    }

    private void guardarValorVivienda(int indiceProyecto, double nuevo) {

        Object[] valoresViviendas = (Object[]) manejador.obtenerVariable("veh_val_pro_viv");
        valoresViviendas[indiceProyecto] = nuevo;
    }

    private Date obtenerFechaInicial(int indiceProyecto) {
        ListaEtapasVehiculo[] listaEtapas = (ListaEtapasVehiculo[]) manejador.obtenerVariable("veh_eta");
        Date fechaMenor = null;
        int numeroEtapas = listaEtapas[indiceProyecto].getListaEtapas().size();
        for (int indiceEtapa = 0; indiceEtapa < numeroEtapas; indiceEtapa++) {
            Date fechaActual = (listaEtapas[indiceProyecto].getListaEtapas().get(indiceEtapa).getFechaInicioEtapa());
            fechaMenor = fechaMenor == null ? fechaActual : fechaMenor.compareTo(fechaActual) < 0 ? fechaMenor : fechaActual;
        }

        return (Date) fechaMenor.clone();
    }

    private Date obtenerFechaFinal(int indiceProyecto) {
        ListaEtapasVehiculo[] listaEtapas = (ListaEtapasVehiculo[]) manejador.obtenerVariable("veh_eta");
        Date fechaMayor = null;
        int numeroEtapas = listaEtapas[indiceProyecto].getListaEtapas().size();
        for (int indiceEtapa = 0; indiceEtapa < numeroEtapas; indiceEtapa++) {
            Date fechaActual = (listaEtapas[indiceProyecto].getListaEtapas().get(indiceEtapa).getFechaFinEtapa());
            fechaMayor = fechaMayor == null ? fechaActual : fechaMayor.compareTo(fechaActual) < 0 ? fechaActual : fechaMayor;
        }
        return (Date) fechaMayor.clone();
    }

    private Date obtenerFechaInicialTodo() {
        ListaEtapasVehiculo[] etapasProyectos = (ListaEtapasVehiculo[]) manejador.obtenerVariable("veh_eta");
        Date fechaMenor = null;
        for (ListaEtapasVehiculo listaEtapas : etapasProyectos) {
            int numeroEtapas = listaEtapas.getListaEtapas().size();
            for (int indiceEtapa = 0; indiceEtapa < numeroEtapas; indiceEtapa++) {
                Date fechaActual = (listaEtapas.getListaEtapas().get(indiceEtapa).getFechaInicioEtapa());
                fechaMenor = fechaMenor == null ? fechaActual : fechaMenor.compareTo(fechaActual) < 0 ? fechaMenor : fechaActual;
            }
        }
        return (Date) fechaMenor.clone();
    }

    private HashMap<String, String> generarMapeoGraficas() {
        String[] nombres = new String[]{"veh_bal_roe", "veh_bal_roa", "veh_bal_ebi", "veh_pal_ope", "veh_pal_apa", "veh_liq_anu", "veh_cap_tra_anu",
            "veh_cob_deu", "veh_rot_inv", "veh_dia_cta_por_cob", "veh_dia_cta_por_pag", "veh_cob_ser_deu", "veh_mar_ope", "veh_mar_ant_imp", "veh_mar_net",
            "veh_bal_efe_anu", "veh_bal_cta_cob_anu", "veh_bal_inv_viv_anu", "veh_bal_tot_act_anu", "veh_bal_cta_por_pag_anu", "veh_bal_deu_anu", "veh_bal_tot_pas_anu",
            "veh_bal_cap_anu", "veh_utl_per_anu", "veh_utl_ret_anu", "veh_bal_tot_pat_anu",
            "veh_cet_uni_edf_anu", "veh_cet_uni_edf_acu_anu", "veh_cet_uni_dis_anu",
            "veh_cet_uni_dis_acu_anu", "veh_cet_uni_ven_anu", "veh_cet_uni_ven_acu_anu",
            "veh_edo_vta_viv_anu", "veh_edo_cto_vta_anu", "veh_total_utl_oprt_anu",
            "veh_gst_opt_anu", "veh_cet_int_cre_pte_anu", "veh_utl_a_ipt_anu", "veh_imp_sob_rta_anu",
            "veh_utl_net_anu"};


        String[] valores = new String[]{"ROE", "ROA", "EBITDA", "Palanca de Operacion", "Apalancamiento", "Liquidez", "Capital de Trabajo",
            "Cobertura de Deuda", "Rotacion de Inventarios", "Dias de Cuentas por Cobrar", "Dias de Cuenta por Pagar", "Cobertura de Serivicio de Deuda", "Margen Operativo", "Margen Antes de Impuestos", "Margen Neto",
            "Efectivo", "Cuentas por Cobrar", "Inventario de Vivienda", "Total de Activos", "Cuentas por pagar", "Deuda Credito", "Total Pasivos",
            "Capital", "Utilidad del Periodo", "Utilidad Retenida", "Total Patrimonio",
            "Unidades Edificadas", "Unidades Edificadas Acumuladas", "Unidades Disponibles",
            "Unidades Disponibles Acumuladas", "Unidades Vendidas", "Unidades Vendidas Acumuladas",
            "Venta de Vivienda", "Costo de Venta", "Utilidad Operativa", "Gastos Operativos", "Intereses", "Utilidad Antes de Impuestos", "Impuestos Sobre la Renta", "Utilidad Neta"};

        HashMap<String, String> mapeo = new HashMap<String, String>();
        for (int t = 0; t < nombres.length; t++) {
            mapeo.put(nombres[t], valores[t]);
        }
        return mapeo;
    }

    /**
     * @return the tiempoMinistracion
     */
    public int getTiempoMinistracion() {
        return tiempoMinistracion;
    }

    /**
     * @param tiempoMinistracion the tiempoMinistracion to set
     */
    public void setTiempoMinistracion(int tiempoMinistracion) {
        this.tiempoMinistracion = tiempoMinistracion;
    }

    /**
     * @return the tiempoPago
     */
    public int getTiempoPago() {
        return tiempoPago;
    }

    /**
     * @param tiempoPago the tiempoPago to set
     */
    public void setTiempoPago(int tiempoPago) {
        this.tiempoPago = tiempoPago;
    }

    private void generarTiempoProyectos(List<String> nombres, List<List<Coordenada>> valores) {
        Date inicialTodo = obtenerFechaInicialTodo();
        int consecutivo = 1;
        System.out.println("entre");
        for (int indiceProyecto = 0; indiceProyecto < proyectos.size(); indiceProyecto++) {
            List<Coordenada> lista = new LinkedList<Coordenada>();
            Date obtenerFechaInicial = obtenerFechaInicial(indiceProyecto);
            Date obtenerFechaFinal = obtenerFechaFinal(indiceProyecto);
            nombres.add(proyectos.get(indiceProyecto).getNomPry());
            int diferenciaPrincipio = Funciones.diferenciaMeses(inicialTodo, obtenerFechaInicial);
            int tiempo = Funciones.diferenciaMeses(obtenerFechaInicial, obtenerFechaFinal);
            Coordenada c1 = new Coordenada(diferenciaPrincipio - 1, consecutivo);
            Coordenada c2 = new Coordenada((diferenciaPrincipio - 1) + tiempo, consecutivo);
            lista.add(c1);
            lista.add(c2);
            consecutivo++;
            valores.add(lista);
        }
        System.out.println(valores);
    }

    private List<Parametros> obtenerTirsProyectos() {
        List<Parametros> lista = new LinkedList<Parametros>();
        lista.add(new Parametros("Nombre", "TIR"));
        for (int t = 0; t < proyectos.size(); t++) {
            ManejadorVariablesVehiculo mane = ((DistribuidorModeloVehiculo) manejador.obtenerVariable("dis" + t)).getManejador();
            Double tir = (Double) mane.obtenerVariable("veh_cet_ptj_tir_pry");
            lista.add(new Parametros(proyectos.get(t).getNomPry(), Funciones.redondear(String.valueOf(tir * 100), 2) + "%"));
            System.out.println("meti " + proyectos.get(t).getNomPry() + "  " + Funciones.redondear(String.valueOf(tir * 100), 2) + "%");
        }
        return lista;
    }


    public Object obtenerVariable(String variable) {
        return manejador.obtenerVariable(variable);
    }

    /**
     * @param procesarIndividuales the procesarIndividuales to set
     */
    public void setProcesarIndividuales(boolean procesarIndividuales) {
        this.procesarIndividuales = procesarIndividuales;
    }


    private List<Parametros> generarTirProyectos() {
        List<Parametros> lista = new LinkedList<Parametros>();
        for (int t = 0; t < proyectos.size(); t++) {
            DistribuidorModeloVehiculo distProye = (DistribuidorModeloVehiculo) manejador.obtenerVariable("dis" + t);
            double tir = ((Double) distProye.obtenerVariable("veh_cet_ptj_tir_pry")) * 100;
            lista.add(new Parametros(proyectos.get(t).getNomPry(), Funciones.redondear(String.valueOf(tir), 3) + "%"));
        }
        Collections.sort(lista);
        return lista;
    }

    private int[] ponerProyectos(CartesianChartModel carteSian) {
        int[] arreglo = new int[2];
        List<Double> tirs = new LinkedList<Double>();
        Date fechaInicialTodo = obtenerFechaInicialTodo();
        for (int t = 0; t < proyectos.size(); t++) {
            LineChartSeries series = new LineChartSeries(proyectos.get(t).getNomPry());
            DistribuidorModeloVehiculo distTmp = (DistribuidorModeloVehiculo) manejador.obtenerVariable("dis" + t);
            double tir = ((Double) distTmp.obtenerVariable("veh_cet_ptj_tir_pry")) * 100;
            tirs.add(tir);
            Date fechaInicial = obtenerFechaInicial(t);
            Date fechaFinal = obtenerFechaFinal(t);
            int mesesDuracion = Funciones.diferenciaMeses(fechaInicial, fechaFinal) - 1;
            int mesesPrincipio = Funciones.diferenciaMeses(fechaInicialTodo, fechaInicial) - 1;
            series.set(mesesPrincipio, tir);
            series.set(mesesPrincipio + mesesDuracion + 1, tir);
            carteSian.addSeries(series);
        }
        Collections.sort(tirs);
        arreglo[0] = tirs.get(0).intValue();
        arreglo[1] = tirs.get(tirs.size() - 1).intValue();
        return arreglo;
    }


    private void ponerCasaGrafica(int[] minimoMaximo, CartesianChartModel carteSian) {
        Double altura = (Double) obtenerVariable("veh_cet_ptj_tir_pry");
        LineChartSeries series = new LineChartSeries("Distribucion del Credito");
        series.set(0, 0);
        series.set(tiempoMinistracion, altura * 100);
        series.set(tiempoMinistracion + ((60) - (tiempoMinistracion + tiempoPago)), altura * 100);
        series.set(60, 0);
        carteSian.addSeries(series);
    }

    private CartesianChartModel generarCarte(CartesianChartModel carte, LineChartSeries series, String llave) {
        List<Double> obtenerVariable = (List<Double>) manejador.obtenerVariable(llave);
        for (int t = 1; t <= obtenerVariable.size(); t++) {
            if (llave.equals("veh_bal_ebi") && obtenerVariable.get(t - 1) < 0) {
            } else {

                series.set(t, obtenerVariable.get(t - 1));
            }
        }
        carte.addSeries(series);
        return carte;
    }

    private List<Double> obtenerNumeroCasas() {
        List<Double> lista = new LinkedList<Double>();
        ListaEtapasVehiculo[] etapasProyectos = (ListaEtapasVehiculo[]) obtenerVariable("veh_eta");
        for (int t = 0; t < getProyectos().size(); t++) {
            ListaEtapasVehiculo etapa = etapasProyectos[t];
            double numeroCasas = 0;
            List<EtapaCapturaVehiculo> listaEtapas = etapa.getListaEtapas();
            for (EtapaCapturaVehiculo etp : listaEtapas) {
                numeroCasas += etp.getViviendasEtapa();
            }
            lista.add(numeroCasas);
        }
        return lista;
    }

    private List<Double> obtenerPrecioCasas() {
        List<Double> precios = new LinkedList<Double>();
        for (int t = 0; t < getProyectos().size(); t++) {
            Object[] obtenerVariable = (Object[]) manejador.obtenerVariable("veh_val_pro_viv");
            precios.add(Double.parseDouble(obtenerVariable[t].toString()));

        }
        return precios;
    }

    private List<Double> sacarProporciones(List<Double> obtenerPrecioCasas, List<Double> obtenerNumeroCasas, double valorSumaProducto) {
        List<Double> proporciones = new LinkedList<Double>();
        for (int t = 0; t < obtenerPrecioCasas.size(); t++) {
            double multi = obtenerPrecioCasas.get(t);

            System.out.println("la suma producto es " + valorSumaProducto + " el valor de la casa " + multi);
            double prop = multi / valorSumaProducto;
            proporciones.add(prop);
        }
        System.out.println("las proporciones son " + proporciones);
        return proporciones;
    }

    private List<Double> sacarProporcionesCapital() {
        List<Double> precios = new LinkedList<Double>();
        for (int t = 0; t < getProyectos().size(); t++) {
            PryVeh proyecto = getProyectos().get(t);
            Set<DatVeh> datVehs = proyecto.getDatVehs();
            for (DatVeh dato : datVehs) {
                if (dato.getVarVeh()!=null && dato.getVarVeh().getDesTca().equals("veh_val_pro_viv")) {
                    String replace = dato.getVal().replace(",", "");
                    precios.add(Double.parseDouble(replace));
                }
            }
        }
        return precios;
    }


    private double sacarSuma(String llave) {
        Object[] obtenerVariable = (Object[]) obtenerVariable(llave);
        double suma = 0;
        for (Object o : obtenerVariable) {
            suma += (Double) o;
        }
        return suma;
    }

    private void modificarVariable(String variable, Object valor) {
        Object[] arreglo = (Object[]) manejador.obtenerVariable(variable);
        for (int t = 0; t < proyectos.size(); t++) {
            arreglo[t] = valor;
        }
        manejador.guardarVariable(variable, arreglo);
    }

}
