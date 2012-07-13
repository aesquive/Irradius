package calculador.proyecto;

import base.Dao;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import util.CeldaFechaValor;
import util.MatrizBidimensional;
import variables.ManejadorVariablesProyectos;

/**
 *
 * @author Galindo Martinez Jose Cruz
 * @author Gonzalez Teran Daniel
 */
public class tablaErogaciones {

  private String TERRENO = "pry_arr_gen_ter";
  private String PREDIAL = "pry_arr_gen_pre";
  private String ESCRITURAS = "pry_arr_gen_esc";
  private String ADMINISTRACION = "pry_arr_gen_adm";
  private String PROYECTO_ARQUITECTONICO = "pry_arr_gen_pro";
  private String DROS_Y_FIRMAS = "pry_arr_gen_dro";
  private String CALCULO_ESTRUCTURAL = "pry_arr_gen_cal";
  private String MECANICA_SUELOS = "pry_arr_gen_mec";
  private String GESTIONES_VECINALES = "pry_arr_gen_ges";
  private String TRAMITES_Y_LICENCIAS = "pry_arr_gen_tra";
  private String CONCERTACIONES_VECINALES = "pry_arr_gen_con";
  private String POZO = "pry_arr_gen_poz";
  private String SOLICITUD_LUZ = "pry_arr_gen_sol";
  private String REGIMEN_PROPIEDAD = "pry_arr_gen_reg";
  private String EDI_CASAS = "pry_arr_gen_edi";
  private String URBANIZACION = "pry_arr_gen_urb";
  private String URB_ACCESO = "pry_arr_gen_urb_acc";
  private String EDI_DEPTOS = "pry_arr_gen_depto";
  private String AREA_EXTERIOR = "pry_arr_gen_are";
  private String GTOS_GRALES = "pry_arr_gen_gts";
  private String OBL_PATRONALES = "pry_arr_gen_obl";
  private String PAQ_ACABADOS = "pry_arr_gen_paq";
  private String IMPREVISTOS = "pry_arr_gen_imp";
  private String MANTENIMIENTO = "pry_arr_gen_man_vig";
  private String SUP_OBRA = "pry_arr_gen_sup";
  private String INFRAESTRUCTURA = "pry_arr_gen_inf";
  private String COM_VNT_CONTRATO = "pry_arr_gen_com_con";
  private String COM_VNT_TITULACION = "pry_arr_gen_com_tit";
  private String PUBLICIDAD_COORPORATIVO = "pry_arr_gen_urb_pub";
  private String PUBLICIDAD_UNE = "pry_arr_gen_urb_une";
  private String ESCENARIO = "pry_arr_gen_esc_man";
  private String AMUEBLADO = "pry_arr_gen_amu_dec";
  private String AMENIDADES = "pry_arr_gen_ame";
  private String OTROS_2 = "pry_arr_gen_otr_2";
  private String OTROS_3 = "pry_arr_gen_otr_3";
  private String CAD_PRODUCTIVAS = "pry_arr_gen_cad_fin";
  private String APERTURA_CREDITO = "pry_arr_gen_ape";
  private String SEGUROS_FIANZAS = "pry_arr_gen_seg_fin";
  private String SUP_OBRA_ADMON_RECURSOS = "pry_arr_gen_sup_adm";
  private String INTERES_CREDITO = "pry_arr_gen_int_cre";
  private String GTS_OPERACION_UNE = "pry_arr_gen_gas_une";
  private String GTS_OPERACION_COO = "pry_arr_gen_gas_coo";
  private String PARTICIPACION_SOCIOS = "pry_arr_por_soc_uti";

  /*
   * Estan son las tablas que estaban en celdas 95
   *
   */
  private ManejadorVariablesProyectos manejadorVariables;

  /**
   * Se encarga de crear una instancia de tabla de erogaciones
   * que se encarga de calcular los calculos con matrices.
   */
  public tablaErogaciones(ManejadorVariablesProyectos manejador) {
    this.manejadorVariables = manejador;
    //quitar este despues
    ElementosVentas elem = new ElementosVentas(manejadorVariables);
    InformacionBasica inf = new InformacionBasica(manejador);
    //Generadores gen = new Generadores(manejadorVariables);
    elem.procesar();
    inf.procesar();
    //gen.procesar();

    calcularMatrices();
  }

  private void calcularMatrices() {
    calcularValorCompraTerrenoMatriz();
    calcularPredialAguaAreasComunes();
    calcularEscriturasAvaluosConstruccion();
    calcularAdministracionFideicomiso();
    calcularProyectoArquitectonico();

    calcularDROsFirmas();
    calcularCalculoEstructuralInstalaciones();
    calcularMecanicaSuelosTopografia();
    calcularGestionesVecinalesTerceros();
    calcularTramitesLicencias();
    calcularConcertacionesVecinales();
    calcularPozoAgua();
    calcularSolicitudPresupuestoLuz();
    calcularRegimenPropiedadCondominio();
    calcularEdificacionCasas();
    calcularUrbanizacion();
    calcularUrbanizacionAcceso();
    calcularEdificacionDeptos();
    calcularAreaExterior();
    calcularGastosGenerales();
    calcularImprevistos();
    calcularObligacionesPatronales();
    calcularPaquetesAcabados();
    calcularMantenimientoVigilancia();
    calcularSupervisionObra();
    calcularInfraestructura();
  }

  /* TODOS LOS CALCULOS SON PRIVADOS YA QUE NUNCA LOS OCUPA OTRO OBJETO*/
  /**
   *
   */
  private void calcularValorCompraTerrenoMatriz() {
    //obtengo la matriz de porcentaje
    // aqui no iba este Object objeto = manejadorVariables.obtenerVariable("pry_arr_obr_con_tot");
    Object objeto = manejadorVariables.obtenerVariable("pry_arr_pro_pgo_ter");
    MatrizBidimensional matriz = (MatrizBidimensional) objeto;
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_val_ter");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 30345000.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(TERRENO, salida);
  }

  /**
   *
   */
  private void calcularPredialAguaAreasComunes() {
    //obtengo la matriz de porcentaje
    // aqui no iba este Object objeto = manejadorVariables.obtenerVariable("pry_arr_obr_con_tot");
    Object objeto = manejadorVariables.obtenerVariable("pry_arr_pro_pgo_ter");
    MatrizBidimensional matriz = (MatrizBidimensional) objeto;
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_val_tot_con_imp_tot");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 30345000.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(PREDIAL, salida);
  }

  /**
   *
   */
  private void calcularEscriturasAvaluosConstruccion() {
    //obtengo la matriz de porcentaje
    // aqui no iba este Object objeto = manejadorVariables.obtenerVariable("pry_arr_obr_con_tot");
    Object objeto = manejadorVariables.obtenerVariable("pry_arr_pro_pgo_ter");
    MatrizBidimensional matriz = (MatrizBidimensional) objeto;
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_esc_ava_fid_isr_imp_tot");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 30345000.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(ESCRITURAS, salida);
  }

  /**
   *
   */
  private void calcularAdministracionFideicomiso() {
    //obtengo la matriz de porcentaje
    // aqui no iba este Object objeto = manejadorVariables.obtenerVariable("pry_arr_obr_con_tot");
    Object objeto = manejadorVariables.obtenerVariable("pry_arr_pro_pgo_ter");
    MatrizBidimensional matriz = (MatrizBidimensional) objeto;
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_adm_fid_imp_tot");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 30345000.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(ADMINISTRACION, salida);
  }

  /**
   *
   */
  private void calcularProyectoArquitectonico() {
    //obtengo la matriz de porcentaje
    Object objeto = manejadorVariables.obtenerVariable("pry_arr_obr_con_tot");
    MatrizBidimensional matriz = (MatrizBidimensional) objeto;
    System.out.println(matriz.toString());
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_pro_arq_imp_tot");
    //Double impTotal = (Double) variableErogaciones;
    double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(PROYECTO_ARQUITECTONICO, salida);
  }

  private void calcularDROsFirmas() {
    //obtengo la matriz de porcentaje
    Object objeto = manejadorVariables.obtenerVariable("pry_arr_obr_con_tot");
    MatrizBidimensional matriz = (MatrizBidimensional) objeto;
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_dro_fir_imp_tot");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(DROS_Y_FIRMAS, salida);
  }

  /**
   *
   *
   */
  private void calcularCalculoEstructuralInstalaciones() {
    //obtengo la matriz de porcentaje
    Object objeto = manejadorVariables.obtenerVariable("pry_arr_obr_con_tot");
    MatrizBidimensional matriz = (MatrizBidimensional) objeto;
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_cal_est_ins_imp_tot");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(CALCULO_ESTRUCTURAL, salida);
  }

  /**
   *
   *
   */
  private void calcularMecanicaSuelosTopografia() {
    //obtengo la matriz de porcentaje
    Object objeto = manejadorVariables.obtenerVariable("pry_arr_obr_con_tot");
    MatrizBidimensional matriz = (MatrizBidimensional) objeto;
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_mec_sue_top_imp_tot");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(MECANICA_SUELOS, salida);
  }

  /**
   *
   *
   */
  private void calcularGestionesVecinalesTerceros() {
    //Esta matriz es una constante por lo que la voy a crear yo
    //obtengo la variable de erogaciones
    MatrizBidimensional matriz = new MatrizBidimensional();
    int[] valores = {15, 15, 10, 10, 10, 10, 10, 10, 10};
    Calendar calIn = Calendar.getInstance();
    calIn.set(Calendar.MONTH, Calendar.OCTOBER);
    calIn.set(Calendar.YEAR, 2011);
    Calendar calFi = Calendar.getInstance();
    calFi.set(Calendar.MONTH, Calendar.JUNE);
    calFi.set(Calendar.YEAR, 2012);
    List<Calendar> dates = generaFechas(calIn, calFi);
    for (int i = 0; i < valores.length; i++) {
      CeldaFechaValor cf = new CeldaFechaValor(dates.get(i), valores[i]);
      matriz.agregarCelda(cf);
    }
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_ges_vec_ter_imp_tot");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 7722720.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(GESTIONES_VECINALES, salida);
  }

  /**
   *
   *
   */
  private void calcularTramitesLicencias() {
    //Esta matriz es una constante por lo que la voy a crear yo
    MatrizBidimensional matriz = new MatrizBidimensional();
    int[] valores = {30, 20, 10, 10, 10, 10, 10};
    Calendar calIn = Calendar.getInstance();
    calIn.set(Calendar.MONTH, Calendar.NOVEMBER);
    calIn.set(Calendar.YEAR, 2011);
    Calendar calFi = Calendar.getInstance();
    calFi.set(Calendar.MONTH, Calendar.MAY);
    calFi.set(Calendar.YEAR, 2012);
    List<Calendar> dates = generaFechas(calIn, calFi);
    for (int i = 0; i < valores.length; i++) {
      CeldaFechaValor cf = new CeldaFechaValor(dates.get(i), valores[i]);
      matriz.agregarCelda(cf);
    }
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_tram_lic_imp_tot");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 15618777.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(TRAMITES_Y_LICENCIAS, salida);
  }

  /**
   *
   *
   */
  private void calcularConcertacionesVecinales() {
    //Esta matriz es una constante por lo que la voy a crear yo
    //obtengo la variable de erogaciones
    MatrizBidimensional matriz = new MatrizBidimensional();
    Calendar calIn = Calendar.getInstance();
    calIn.set(Calendar.MONTH, Calendar.APRIL);
    calIn.set(Calendar.YEAR, 2012);
    Calendar calFi = Calendar.getInstance();
    calFi.set(Calendar.MONTH, Calendar.NOVEMBER);
    calFi.set(Calendar.YEAR, 2013);
    List<Calendar> dates = generaFechas(calIn, calFi);
    for (int i = 0; i < dates.size(); i++) {
      CeldaFechaValor cf = new CeldaFechaValor(dates.get(i), 5);
      matriz.agregarCelda(cf);
    }
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_con_vec_imp_tot");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 0.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(CONCERTACIONES_VECINALES, salida);
  }

  /**
   *
   *
   */
  private void calcularPozoAgua() {
    //obtengo la matriz de porcentaje
    Object objeto = manejadorVariables.obtenerVariable("pry_arr_obr_con_tot");
    MatrizBidimensional matriz = (MatrizBidimensional) objeto;
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_poz_agu_imp_tot");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(POZO, salida);
  }

  /**
   *
   *
   */
  private void calcularSolicitudPresupuestoLuz() {
    //obtengo la matriz de porcentaje
    Object objeto = manejadorVariables.obtenerVariable("pry_arr_obr_con_tot");
    MatrizBidimensional matriz = (MatrizBidimensional) objeto;
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_sol_pre_luz_fue_imp_tot");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(SOLICITUD_LUZ, salida);
  }

  /**
   *
   *
   */
  private void calcularRegimenPropiedadCondominio() {
    //obtengo la matriz de porcentaje
    Object objeto = manejadorVariables.obtenerVariable("pry_arr_obr_con_tot");
    MatrizBidimensional matriz = (MatrizBidimensional) objeto;
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_reg_pro_con_imp_tot");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(REGIMEN_PROPIEDAD, salida);
  }

  /**
   *
   *
   */
  private void calcularEdificacionCasas() {
    //obtengo la matriz de porcentaje
    Object objeto = manejadorVariables.obtenerVariable("pry_arr_obr_con_tot");
    MatrizBidimensional matriz = (MatrizBidimensional) objeto;
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_edi_cas_mon");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(EDI_CASAS, salida);
  }

  /**
   *
   *
   */
  private void calcularUrbanizacion() {
    //obtengo la matriz de porcentaje
    Object objeto = manejadorVariables.obtenerVariable("pry_arr_obr_con_tot");
    MatrizBidimensional matriz = (MatrizBidimensional) objeto;
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_urb_mon");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(URBANIZACION, salida);
  }

  /**
   *
   *
   */
  private void calcularUrbanizacionAcceso() {
    //La matriz la creo yo
    //Esta matriz es una constante por lo que la voy a crear yo
    //obtengo la variable de erogaciones
    MatrizBidimensional matriz = new MatrizBidimensional();
    int[] valores = {25, 25, 25, 25};
    Calendar calIn = Calendar.getInstance();
    calIn.set(Calendar.MONTH, Calendar.NOVEMBER);
    calIn.set(Calendar.YEAR, 2011);
    Calendar calFi = Calendar.getInstance();
    calFi.set(Calendar.MONTH, Calendar.FEBRUARY);
    calFi.set(Calendar.YEAR, 2012);
    List<Calendar> dates = generaFechas(calIn, calFi);
    for (int i = 0; i < valores.length; i++) {
      CeldaFechaValor cf = new CeldaFechaValor(dates.get(i), valores[i]);
      matriz.agregarCelda(cf);
    }
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_urb_acc_mon");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(URB_ACCESO, salida);
  }

  /**
   *
   *
   */
  private void calcularEdificacionDeptos() {
    //La matriz la creo yo
    //Esta matriz es una constante por lo que la voy a crear yo
    //obtengo la variable de erogaciones
    MatrizBidimensional matriz = new MatrizBidimensional();
    Calendar calIn = Calendar.getInstance();
    calIn.set(Calendar.MONTH, Calendar.OCTOBER);
    calIn.set(Calendar.YEAR, 2011);
    Calendar calFi = Calendar.getInstance();
    calFi.set(Calendar.MONTH, Calendar.JULY);
    calFi.set(Calendar.YEAR, 2014);
    List<Calendar> dates = generaFechas(calIn, calFi);
    for (int i = 0; i < dates.size(); i++) {
      CeldaFechaValor cf = new CeldaFechaValor(dates.get(i), 0.0);
      matriz.agregarCelda(cf);
    }
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_edi_depto_mon");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(EDI_DEPTOS, salida);
  }

  /**
   *
   *
   */
  private void calcularAreaExterior() {
    //La matriz la creo yo
    //Esta matriz es una constante por lo que la voy a crear yo
    //obtengo la variable de erogaciones
    MatrizBidimensional matriz = new MatrizBidimensional();
    int[] valores = {5};
    Calendar calIn = Calendar.getInstance();
    calIn.set(Calendar.MONTH, Calendar.JUNE);
    calIn.set(Calendar.YEAR, 2012);
    Calendar calFi = Calendar.getInstance();
    calFi.set(Calendar.MONTH, Calendar.JANUARY);
    calFi.set(Calendar.YEAR, 2014);
    List<Calendar> dates = generaFechas(calIn, calFi);
    for (int i = 0; i < dates.size(); i++) {
      CeldaFechaValor cf = new CeldaFechaValor(dates.get(i), valores[0]);
      matriz.agregarCelda(cf);
    }
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_orn_mon");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(AREA_EXTERIOR, salida);
  }

  /**
   *
   */
  private void calcularGastosGenerales() {
    //obtengo la matriz de porcentaje
    Object objeto = manejadorVariables.obtenerVariable("pry_arr_obr_con_tot");
    MatrizBidimensional matriz = (MatrizBidimensional) objeto;
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_gas_gen_mon");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(GTOS_GRALES, salida);
  }

  /**
   *
   */
  private void calcularImprevistos() {
    //obtengo la matriz de porcentaje
    Object objeto = manejadorVariables.obtenerVariable("pry_arr_obr_con_tot");
    MatrizBidimensional matriz = (MatrizBidimensional) objeto;
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_imp_mon");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(IMPREVISTOS, salida);
  }

  /**
   *
   */
  private void calcularObligacionesPatronales() {
    //La matriz la creo yo
    //Esta matriz es una constante por lo que la voy a crear yo
    MatrizBidimensional matriz = new MatrizBidimensional();
    Calendar calIn = Calendar.getInstance();
    calIn.set(Calendar.MONTH, Calendar.JUNE);
    calIn.set(Calendar.YEAR, 2012);
    Calendar calFi = Calendar.getInstance();
    calFi.set(Calendar.MONTH, Calendar.JANUARY);
    calFi.set(Calendar.YEAR, 2014);
    List<Calendar> dates = generaFechas(calIn, calFi);
    for (int i = 0; i < dates.size(); i++) {
      CeldaFechaValor cf = new CeldaFechaValor(dates.get(i), 0.0);
      matriz.agregarCelda(cf);
    }
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_obl_pat_mon");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(OBL_PATRONALES, salida);
  }

  /**
   *
   */
  private void calcularPaquetesAcabados() {
    //La matriz la creo yo
    //Esta matriz es una constante por lo que la voy a crear yo
    MatrizBidimensional matriz = new MatrizBidimensional();
    Calendar calIn = Calendar.getInstance();
    calIn.set(Calendar.MONTH, Calendar.JUNE);
    calIn.set(Calendar.YEAR, 2012);
    Calendar calFi = Calendar.getInstance();
    calFi.set(Calendar.MONTH, Calendar.JANUARY);
    calFi.set(Calendar.YEAR, 2014);
    List<Calendar> dates = generaFechas(calIn, calFi);
    for (int i = 0; i < dates.size(); i++) {
      CeldaFechaValor cf = new CeldaFechaValor(dates.get(i), 0.0);
      matriz.agregarCelda(cf);
    }
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_pac_aca_mon");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(PAQ_ACABADOS, salida);
  }


  /**
   *
   */
  private void calcularMantenimientoVigilancia() {
    //obtengo la matriz de porcentaje
    Object objeto = manejadorVariables.obtenerVariable("pry_arr_obr_con_tot");
    MatrizBidimensional matriz = (MatrizBidimensional) objeto;
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_man_vig_esc_mon");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(MANTENIMIENTO, salida);
  }

  /**
   *
   */
  private void calcularSupervisionObra() {
    //obtengo la matriz de porcentaje
    Object objeto = manejadorVariables.obtenerVariable("pry_arr_obr_con_tot");
    MatrizBidimensional matriz = (MatrizBidimensional) objeto;
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_sup_obr_mon");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(SUP_OBRA, salida);
  }

  /**
   *
   */
  private void calcularInfraestructura() {
    //obtengo la matriz de porcentaje
    Object objeto = manejadorVariables.obtenerVariable("pry_arr_obr_con_tot");
    MatrizBidimensional matriz = (MatrizBidimensional) objeto;
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_inf_mon");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(INFRAESTRUCTURA, salida);
  }

  
  //vamos a hacer las matrices que no tienen sentido para despues hacer las **********************************************
  // que necesitan mas atencion
  //ventas amueblado
  
  /**
   *
   */
  private void calcularAmuebladoDecoradoDepartamento() {
    //La matriz la creo yo
    //Esta matriz es una constante por lo que la voy a crear yo
    MatrizBidimensional matriz = new MatrizBidimensional();
    Calendar calIn = Calendar.getInstance();
    calIn.set(Calendar.MONTH, Calendar.OCTOBER);
    calIn.set(Calendar.YEAR, 2011);
    Calendar calFi = Calendar.getInstance();
    calFi.set(Calendar.MONTH, Calendar.JULY);
    calFi.set(Calendar.YEAR, 2014);
    List<Calendar> dates = generaFechas(calIn, calFi);
    for (int i = 0; i < dates.size(); i++) {
      CeldaFechaValor cf = new CeldaFechaValor(dates.get(i), 0.0);
      matriz.agregarCelda(cf);
    }
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_amu_dec_dep_ofi_imp_tot");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(AMUEBLADO, salida);
  }
  
  /**
   *
   */
  private void calcularAmenidades() {
    //La matriz la creo yo
    //Esta matriz es una constante por lo que la voy a crear yo
    MatrizBidimensional matriz = new MatrizBidimensional();
    Calendar calIn = Calendar.getInstance();
    calIn.set(Calendar.MONTH, Calendar.OCTOBER);
    calIn.set(Calendar.YEAR, 2011);
    Calendar calFi = Calendar.getInstance();
    calFi.set(Calendar.MONTH, Calendar.JULY);
    calFi.set(Calendar.YEAR, 2014);
    List<Calendar> dates = generaFechas(calIn, calFi);
    for (int i = 0; i < dates.size(); i++) {
      CeldaFechaValor cf = new CeldaFechaValor(dates.get(i), 0.0);
      matriz.agregarCelda(cf);
    }
    //obtengo la variable de erogaciones
    Object variableErogaciones = manejadorVariables.obtenerVariable("pry_ame_imp_tot");
    Double impTotal = (Double) variableErogaciones;
    //double impTotal = 3861360.0;
    //creamos nuestra matriz bidimensional de salida
    MatrizBidimensional salida = new MatrizBidimensional();

    List<CeldaFechaValor> lista = matriz.getCeldas();
    for (CeldaFechaValor cfv : lista) {
      double total = cfv.getValor() * impTotal;
      CeldaFechaValor nuevaCelda = new CeldaFechaValor(cfv.getFecha(), total);
      salida.agregarCelda(nuevaCelda);
    }
    System.out.println(salida.toString());
    manejadorVariables.guardarVariable(AMENIDADES, salida);
  }
  
  
  //Me ayuda a crear las matrices que no tienen sentido
  private List<Calendar> generaFechas(Calendar fechaIni, Calendar fechaFinal) {
    List<Calendar> aut = new LinkedList<Calendar>();
    Date time = fechaIni.getTime();
    time.setDate(1);
    Date time1 = fechaFinal.getTime();
    time1.setDate(1);
    Calendar aux = Calendar.getInstance();
    aux.setTime(time);
    aut.add(aux);
    while (time.compareTo(time1) < 0) {
      aux = Calendar.getInstance();
      time.setMonth(time.getMonth() + 1);
      System.out.println("Es la fecha " + time.toString());
      aux.setTime(time);
      aut.add(aux);
    }
    return aut;
  }

  /*>>>>>>**********************************************************************/
  public static void main(String[] args) {
    Dao dao = new Dao();
    ManejadorVariablesProyectos m = new ManejadorVariablesProyectos(dao.getPryInd(46));
    tablaErogaciones te = new tablaErogaciones(m);


  }
}//end class