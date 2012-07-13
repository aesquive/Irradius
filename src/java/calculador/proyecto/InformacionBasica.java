package calculador.proyecto;

import base.Dao;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import variables.ManejadorVariablesProyectos;
import util.MatrizBidimensional;
import util.CeldaFechaValor;
import java.util.LinkedList;

/**
 *
 * @author Galindo Martinez Jose Cruz
 */
public class InformacionBasica {

  /**
   * Cada entrada esta acompanada de su costo por metros cuadrados 
   */
  private final String SUP_TERRENO = "pry_sup_ter";
  private final String COSTO_SUP_TERRENO = "pry_cos_met";
  private final String EDIFICACION_CASAS = "pry_edi_cas";
  private final String COSTO_EDIFICACION_CASAS = "pry_cos_edi_cas";
  private final String URBANIZACION = "pry_urb";
  private final String COSTO_URBANIZACION = "pry_cos_urb";
  private final String URB_ACCESO = "pry_urb_acc";
  private final String COSTO_URB_ACCESO = "pry_cos_urb_acc";
  private final String EDI_DEPARTAMENTO = "pry_edi_depto";
  private final String COSTO_EDI_DEPARTAMENTO = "pry_cos_edi_depto";
  private final String ORNATO = "pry_orn";
  private final String COSTO_ORNATO = "pry_cos_orn";
  private final String GTOS_GENERALES = "pry_gts_gral";
  private final String COSTO_GTOS_GENERALES = "pry_cos_gts_gral";
  private final String IMPREVISTOS = "pry_imp";
  private final String COSTO_IMPREVISTOS = "pry_cos_imp";
  private final String OBL_PATRONALES = "pry_obl_pat";
  private final String COSTO_OBL_PATRONALES = "pry_cos_obl_pat";
  private final String PAQ_ACABADOS = "pry_paq_aca";
  private final String COSTO_PAQ_ACABADOS = "pry_cos_paq_aca";
  private final String MANTENIMIENTO = "pry_man_vig_esc";
  private final String COSTO_MANTENIMIENTO = "pry_cos_man_vig_esc";
  private final String SUP_OBRA = "pry_sup_obr";
  private final String COSTO_SUP_OBRA = "pry_cos_sup_obr";
  private final String INFRAESTRUCTURA = "pry_infra";
  private final String COSTO_INFRAESTRUCTURA = "pry_cos_infra";
  /**
   * El numero de entradas de esta pestana
   */
  private final int NUM_ELEMENTOS = 12;
  //IDENTIFICADORES
  private final int ID_EDIFICACION_CASAS = 0;
  private final int ID_URBANIZACION = 1;
  private final int ID_URB_ACCESO = 2;
  private final int ID_EDI_DEPARTAMENTO = 3;
  private final int ID_ORNATO = 4;
  private final int ID_GTOS_GENERALES = 5;
  private final int ID_IMPREVISTOS = 6;
  private final int ID_OBL_PATRONALES = 7;
  private final int ID_PAQ_ACABADOS = 8;
  private final int ID_MANTENIMIENTO = 9;
  private final int ID_SUP_OBRA = 10;
  private final int ID_INFRAESTRUCTURA = 11;
  /*
   * Arreglos auxiliares en el proceso de construccion.
   */
  private double[] arregloElementosDeConstruccion;         //pry_arr_cons
  private double[] arregloDeCostosConstruccion;            //pry_cos_arr_cons
  /**
   * Manejador de variables que nos ayuda a comunicarnos
   * con la base de datos
   */
  private ManejadorVariablesProyectos manejadorVariables;
  /**
   * Numero de etapas del proyecto.
   */
  private int numeroEtapas;

  /**
   * Crea una instancia de la pestana de informacion basica
   * para ejecutar las operaciones en esta.
   * @param mane El manejador de variables que se encarga de conectar
   * a la base de datos.
   */
  public InformacionBasica(ManejadorVariablesProyectos mane) {
    this.manejadorVariables = mane;
    this.arregloElementosDeConstruccion = llenaArregloConstruccion();
    this.arregloDeCostosConstruccion = llenaArregloCostosConstruccion();
    Object obj = manejadorVariables.obtenerVariable("pry_num_eta");
    double aux = (Double) obj;
    this.numeroEtapas = (int) aux;
  }

  /**
   * Se encarga de calcular el valor total del terreno dependiendo
   * de la superficie y el valor por metro cuadrado.
   * @return El valor total del terreno
   */
  public Double obtenerValorTotalTerreno() {
    double superficieTerreno;
    superficieTerreno = (Double) manejadorVariables.obtenerVariable(SUP_TERRENO);
    double costoTerreno;
    costoTerreno = (Double) manejadorVariables.obtenerVariable(COSTO_SUP_TERRENO);
    // Mandamos la variable a la base de datos
    double valorTotal = superficieTerreno * costoTerreno;
    manejadorVariables.guardarVariable("pry_val_ter", valorTotal);
    return valorTotal;
  }

  /**
   * Se encargan del llenado de arreglos para hacer mas facil 
   * el calculo de variables.
   */
  private double[] llenaArregloConstruccion() {
    double[] arregloSalida = new double[NUM_ELEMENTOS];
    arregloSalida[ID_EDIFICACION_CASAS] = (Double) manejadorVariables.obtenerVariable(EDIFICACION_CASAS);
    arregloSalida[ID_URBANIZACION] = (Double) manejadorVariables.obtenerVariable(URBANIZACION);
    arregloSalida[ID_URB_ACCESO] = (Double) manejadorVariables.obtenerVariable(URB_ACCESO);
    arregloSalida[ID_EDI_DEPARTAMENTO] = (Double) manejadorVariables.obtenerVariable(EDI_DEPARTAMENTO);
    arregloSalida[ID_ORNATO] = (Double) manejadorVariables.obtenerVariable(ORNATO);
    arregloSalida[ID_GTOS_GENERALES] = (Double) manejadorVariables.obtenerVariable(GTOS_GENERALES);
    arregloSalida[ID_IMPREVISTOS] = (Double) manejadorVariables.obtenerVariable(IMPREVISTOS);
    arregloSalida[ID_OBL_PATRONALES] = (Double) manejadorVariables.obtenerVariable(OBL_PATRONALES);
    arregloSalida[ID_PAQ_ACABADOS] = (Double) manejadorVariables.obtenerVariable(PAQ_ACABADOS);
    arregloSalida[ID_MANTENIMIENTO] = (Double) manejadorVariables.obtenerVariable(MANTENIMIENTO);
    arregloSalida[ID_SUP_OBRA] = (Double) manejadorVariables.obtenerVariable(SUP_OBRA);
    arregloSalida[ID_INFRAESTRUCTURA] = (Double) manejadorVariables.obtenerVariable(INFRAESTRUCTURA);
    return arregloSalida;
  }

  /**
   * Se encargan del llenado de arreglos para hacer mas facil 
   * el calculo de variables.
   */
  private double[] llenaArregloCostosConstruccion() {
    double[] arregloSalida = new double[NUM_ELEMENTOS];
    arregloSalida[ID_EDIFICACION_CASAS] = (Double) manejadorVariables.obtenerVariable(COSTO_EDIFICACION_CASAS);
    arregloSalida[ID_URBANIZACION] = (Double) manejadorVariables.obtenerVariable(COSTO_URBANIZACION);
    arregloSalida[ID_URB_ACCESO] = (Double) manejadorVariables.obtenerVariable(COSTO_URB_ACCESO);
    arregloSalida[ID_EDI_DEPARTAMENTO] = (Double) manejadorVariables.obtenerVariable(COSTO_EDI_DEPARTAMENTO);
    arregloSalida[ID_ORNATO] = (Double) manejadorVariables.obtenerVariable(COSTO_ORNATO);
    arregloSalida[ID_GTOS_GENERALES] = (Double) manejadorVariables.obtenerVariable(COSTO_GTOS_GENERALES);
    arregloSalida[ID_IMPREVISTOS] = (Double) manejadorVariables.obtenerVariable(COSTO_IMPREVISTOS);
    arregloSalida[ID_OBL_PATRONALES] = (Double) manejadorVariables.obtenerVariable(COSTO_OBL_PATRONALES);
    arregloSalida[ID_PAQ_ACABADOS] = (Double) manejadorVariables.obtenerVariable(COSTO_PAQ_ACABADOS);
    arregloSalida[ID_MANTENIMIENTO] = (Double) manejadorVariables.obtenerVariable(COSTO_MANTENIMIENTO);
    arregloSalida[ID_SUP_OBRA] = (Double) manejadorVariables.obtenerVariable(COSTO_SUP_OBRA);
    arregloSalida[ID_INFRAESTRUCTURA] = (Double) manejadorVariables.obtenerVariable(COSTO_INFRAESTRUCTURA);
    return arregloSalida;
  }

  /**
   * Calculamos el monto total de los precios de contruccion por metro cuadrado
   */
  public Double obtenerEdificacionCasasTotal() {
    double costoTotal = arregloElementosDeConstruccion[ID_EDIFICACION_CASAS] * arregloDeCostosConstruccion[ID_EDIFICACION_CASAS];
    //lo mandamos a la base
    manejadorVariables.guardarVariable("pry_edi_cas_mon", costoTotal);
    return costoTotal;
  }

  /**
   * Calculamos el monto total de los precios de contruccion por metro cuadrado
   * @return El valor del costo total de el precio de construccion por los
   * metros cuadrados (pry_urb_mon) 
   */
  public Double obtenerUrbanizacionTotal() {
    double costoTotal = arregloElementosDeConstruccion[ID_URBANIZACION] * arregloDeCostosConstruccion[ID_URBANIZACION];
    //lo mandamos a la base
    manejadorVariables.guardarVariable("pry_urb_mon", costoTotal);
    return costoTotal;
  }

  /**
   * Calculamos el monto total de los precios de contruccion por metro cuadrado
   * @return El valor del costo total de el precio de construccion por los
   * metros cuadrados (pry_urb_acc_mon) 
   */
  public Double obtenerUrbanizacionAccesoTotal() {
    double costoTotal = arregloElementosDeConstruccion[ID_URB_ACCESO] * arregloDeCostosConstruccion[ID_URB_ACCESO];
    //lo mandamos a la base
    manejadorVariables.guardarVariable("pry_urb_acc_mon", costoTotal);
    return costoTotal;
  }

  /**
   * Calculamos el monto total de los precios de contruccion por metro cuadrado
   * @return El valor del costo total de el precio de construccion por los
   * metros cuadrados (pry_edi_depto_mon) 
   */
  public Double obtenerEdificacionDepartamentosTotal() {
    double costoTotal = arregloElementosDeConstruccion[ID_EDI_DEPARTAMENTO] * arregloDeCostosConstruccion[ID_EDI_DEPARTAMENTO];
    //lo mandamos a la base
    manejadorVariables.guardarVariable("pry_edi_depto_mon", costoTotal);
    return costoTotal;
  }

  /**
   * Calculamos el monto total de los precios de contruccion por metro cuadrado
   * @return El valor del costo total de el precio de construccion por los
   * metros cuadrados (pry_ornato_mon) 
   */
  public Double obtenerOrnatoTotal() {
    double costoTotal = arregloElementosDeConstruccion[ID_ORNATO] * arregloDeCostosConstruccion[ID_ORNATO];
    //lo mandamos a la base
    manejadorVariables.guardarVariable("pry_orn_mon", costoTotal);
    return costoTotal;
  }

  /**
   * Calculamos el monto total de los precios de contruccion por metro cuadrado
   * @return El valor del costo total de el precio de construccion por los
   * metros cuadrados (pry_gts_gral_mon) 
   */
  public Double obtenerGastosGeneralesTotal() {
    double gtosGen = arregloElementosDeConstruccion[ID_GTOS_GENERALES];
    double gtosGenM2 = arregloDeCostosConstruccion[ID_GTOS_GENERALES];
    System.out.println("Multiplica los gastos generales que son " + gtosGen + " y m2 " + gtosGenM2);
    double costoTotal = arregloElementosDeConstruccion[ID_GTOS_GENERALES] * arregloDeCostosConstruccion[ID_GTOS_GENERALES];
    //lo mandamos a la base
    manejadorVariables.guardarVariable("pry_gts_gral_mon", costoTotal);
    return costoTotal;
  }

  /**
   * Calculamos el monto total de los precios de contruccion por metro cuadrado
   * @return El valor del costo total de el precio de construccion por los
   * metros cuadrados (pry_imp_mon) 
   */
  public Double obtenerImprevistosTotal() {
    double costoTotal = arregloElementosDeConstruccion[ID_IMPREVISTOS] * arregloDeCostosConstruccion[ID_IMPREVISTOS];
    //lo mandamos a la base
    manejadorVariables.guardarVariable("pry_imp_mon", costoTotal);
    return costoTotal;
  }

  /**
   * Calculamos el monto total de los precios de contruccion por metro cuadrado
   * @return El valor del costo total de el precio de construccion por los
   * metros cuadrados (pry_obl_pat_mon) 
   */
  public Double obtenerObligacionesPatronalesTotal() {
    double costoTotal = arregloElementosDeConstruccion[ID_OBL_PATRONALES] * arregloDeCostosConstruccion[ID_OBL_PATRONALES];
    //lo mandamos a la base
    manejadorVariables.guardarVariable("pry_obl_pat_mon", costoTotal);
    return costoTotal;
  }

  /**
   * Calculamos el monto total de los precios de contruccion por metro cuadrado
   * @return El valor del costo total de el precio de construccion por los
   * metros cuadrados (pry_paq_aca_mon) 
   */
  public Double obtenerPaquetesAcabadosTotal() {
    double costoTotal = arregloElementosDeConstruccion[ID_PAQ_ACABADOS] * arregloDeCostosConstruccion[ID_PAQ_ACABADOS];
    //lo mandamos a la base
    manejadorVariables.guardarVariable("pry_paq_aca_mon", costoTotal);
    return costoTotal;
  }

  /**
   * Calculamos el monto total de los precios de contruccion por metro cuadrado
   * @return El valor del costo total de el precio de construccion por los
   * metros cuadrados (pry_mon_vig_esc_mon) 
   */
  public Double obtenerMantenimientoVigilanciaTotal() {
    double costoTotal = arregloElementosDeConstruccion[ID_MANTENIMIENTO] * arregloDeCostosConstruccion[ID_MANTENIMIENTO];
    //lo mandamos a la base
    manejadorVariables.guardarVariable("pry_man_vig_esc_mon", costoTotal);
    return costoTotal;
  }

  /**
   * Calculamos el monto total de los precios de contruccion por metro cuadrado
   * @return El valor del costo total de el precio de construccion por los
   * metros cuadrados (pry_sup_obr_mon) 
   */
  public Double obtenerSupervisionObraTotal() {
    double costoTotal = arregloElementosDeConstruccion[ID_SUP_OBRA] * arregloDeCostosConstruccion[ID_SUP_OBRA];
    //lo mandamos a la base
    manejadorVariables.guardarVariable("pry_sup_obr_mon", costoTotal);
    return costoTotal;
  }

  /**
   * Calculamos el monto total de los precios de contruccion por metro cuadrado
   * @return El valor del costo total de el precio de construccion por los
   * metros cuadrados (pry_inf_mon) 
   */
  public Double obtenerInfraestructuraTotal() {
    double costoTotal = arregloElementosDeConstruccion[ID_INFRAESTRUCTURA] * arregloDeCostosConstruccion[ID_INFRAESTRUCTURA];
    //lo mandamos a la base
    manejadorVariables.guardarVariable("pry_inf_mon", costoTotal);
    return costoTotal;
  }

  /**
   * Se calcula el valor total de las construcciones (pry_dro_fir_mon)
   * @return El valor total de las construcciones
   */
  public Double obtenerValorTotalConstrucciones() {
    double valorTotal = 0;
    for (int i = 0; i < NUM_ELEMENTOS; i++) {
      valorTotal += arregloElementosDeConstruccion[i];
    }
    //lo mandamos a la base
    manejadorVariables.guardarVariable("pry_dro_fir_mon", valorTotal);
//    System.out.println("valor total de m2 de construcciones: " + valorTotal);
    return valorTotal;
  }

  /**
   * Calcula el costo total de la construccion (pry_cst_cons)
   * @return El valor total de la construccion.
   */
  public Double obtenerCostoTotalConstruccion() {
    double variableAuxiliar = 0;
    for (int i = 0; i < NUM_ELEMENTOS; i++) {
      if (arregloElementosDeConstruccion[i] != 0) {
        System.out.println("El valor es " + arregloElementosDeConstruccion[i]);
      }
      if (arregloDeCostosConstruccion[i] != 0) {
        System.out.println("Multiplicado por " + arregloDeCostosConstruccion[i]);
      }
      variableAuxiliar += arregloElementosDeConstruccion[i] * arregloDeCostosConstruccion[i];
    }
    // la mandamos a la base
    manejadorVariables.guardarVariable("pry_cos_cons", variableAuxiliar);
    return variableAuxiliar;
  }

  /**
   * Nos permite saber el porcentajedel programa de pago de terreno
   * @return El porcentaje de pago de terreno (pry_pro_pgo_ter).
   */
  public Double obtenerPorcentajePagoTerreno() {
    MatrizBidimensional arregloPagoTerreno = (MatrizBidimensional) manejadorVariables.obtenerVariable("pry_arr_pro_pgo_ter");
    double porcentaje = 0.0;
    List<CeldaFechaValor> celdas = arregloPagoTerreno.getCeldas();
    int tamanoArreglo = celdas.size();
    CeldaFechaValor cfv;
    for (int i = 0; i < tamanoArreglo; i++) {
      cfv = celdas.get(i);
      porcentaje += cfv.getValor();
    }
    //lo mandamos a la base;
    manejadorVariables.guardarVariable("pry_pro_pgo_ter", porcentaje);
    return porcentaje;
  }

  /**
   * Se encarga de calcular la lista de totales de venta por etapas
   */
  public LinkedList<CeldaFechaValor> listaTotalVentaEtapa() {
    LinkedList<CeldaFechaValor> salida = new LinkedList<CeldaFechaValor>();
    Object objeto = manejadorVariables.obtenerVariable("pry_arr_mat_pro_vnt_eta");
    MatrizBidimensional[] matrices = (MatrizBidimensional[]) objeto;
    MatrizBidimensional mb = matrices[0];// la primera va a ser la referencia
    List<CeldaFechaValor> lista = mb.getCeldas();
    double valor = 0.0;
    for (CeldaFechaValor cfv : lista) {
      System.out.println("El valor es " + cfv.getValor());
      valor = cfv.getValor();
      Calendar cal = cfv.getFecha();
      for (int e = 1; e < numeroEtapas; e++) { // por etapa
        MatrizBidimensional mat = matrices[e];
        List<CeldaFechaValor> celdas = mat.getCeldas();
        double aux = dameValorFecha(cal, celdas);
        valor = valor + aux;
        System.out.println("El valor real saliendo de la etapa " + e + " es " + valor);
      }
      CeldaFechaValor actual = cfv;
      actual.setValor(valor);
      salida.add(actual);
    }
    MatrizBidimensional base = new MatrizBidimensional();
    base.setCeldas(salida);
    //falta mandarlo a la base
    manejadorVariables.guardarVariable("pry_arr_vnt_tot", salida);
    return salida;
  }

  /**
   * Se encarga de calcular la lista de totales de titulacion por etapas
   */
  public LinkedList<CeldaFechaValor> listaTotalTitulacionEtapa() {
    LinkedList<CeldaFechaValor> salida = new LinkedList<CeldaFechaValor>();
    Object objeto = manejadorVariables.obtenerVariable("pry_arr_mat_pro_tit_eta");
    MatrizBidimensional[] matrices = (MatrizBidimensional[]) objeto;
    MatrizBidimensional mb = matrices[0];// la primera va a ser la referencia
    List<CeldaFechaValor> lista = mb.getCeldas();
    double valor = 0.0;
    for (CeldaFechaValor cfv : lista) {
      System.out.println("El valor es " + cfv.getValor());
      valor = cfv.getValor();
      Calendar cal = cfv.getFecha();
      for (int e = 1; e < numeroEtapas; e++) { // por etapa
        MatrizBidimensional mat = matrices[e];
        List<CeldaFechaValor> celdas = mat.getCeldas();
        double aux = dameValorFecha(cal, celdas);
        valor = valor + aux;
        System.out.println("El valor real saliendo de la etapa " + e + " es " + valor);
      }
      CeldaFechaValor actual = cfv;
      actual.setValor(valor);
      salida.add(actual);
    }
    MatrizBidimensional base = new MatrizBidimensional();
    base.setCeldas(salida);
    //falta mandarlo a la base
    manejadorVariables.guardarVariable("pry_arr_tit_tot", salida);
    return salida;
  }

  /**
   * Dada una lista de fechas y porcentajes se encarga de buscar una fecha
   * especifica y si la encuentra regresa el valor asociado a ella.
   */
  private double dameValorFecha(Calendar fechaBusqueda, List<CeldaFechaValor> lista) {
    int tamanoLista = lista.size();
    int mes = fechaBusqueda.get(Calendar.MONTH);
    int anhio = fechaBusqueda.get(Calendar.YEAR);
    int mesValor;
    int anhioValor;
    for (int i = 0; i < tamanoLista; i++) {
      CeldaFechaValor valor = lista.get(i);
      mesValor = valor.getFecha().get(Calendar.MONTH); //sacar estos
      anhioValor = valor.getFecha().get(Calendar.YEAR);
      if ((mes == mesValor) && (anhio == anhioValor)) {
        return valor.getValor();
      } else {
        continue;
      }
    }
    return 0.0;
  }

  /**
   * Se encarga de calcular los porcentajes anuales de la tasa de interes del credito 
   * puente.
   */
  public LinkedList<Double> listaInteresCreditoPuente() {
    MatrizBidimensional creditoPuente = (MatrizBidimensional) manejadorVariables.obtenerVariable("pry_arr_num_mes_cre_pue");
    LinkedList<Double> porcentajeSalida = new LinkedList<Double>();
    LinkedList<CeldaFechaValor> listaPorcentajes = (LinkedList) creditoPuente.getCeldas();
    double porcentajeAnual = 1.0;
    double auxiliar = 0.0;
    int tamano = listaPorcentajes.size();
    CeldaFechaValor celda;
    int i = 0;
    int guardador;
    double valor;
    for (; i < tamano; i++) {
      guardador = i + 1;
      celda = listaPorcentajes.get(i);
      valor = celda.getValor() / 100;  //sacar este fuera del for
      auxiliar = ((100 + valor) * .01);
      porcentajeAnual *= auxiliar;
      //si pasaron los 12 meses lo mandamos a la lista
      if (guardador % 12 == 0) {
        porcentajeAnual = (porcentajeAnual - 1.0) * 100;
        porcentajeSalida.add(porcentajeAnual);
        porcentajeAnual = 1.0;
      }
    }
    //Si no pasan anios exactos no se guarda el ultimo
    manejadorVariables.guardarVariable("pry_tas_int_cre_pue", porcentajeSalida);
    return porcentajeSalida;
  }

  /**
   * Se encarga de calcular los porcentajes anuales de la inflacion (INPC)
   */
  public LinkedList<Double> listaInflacion() {
    MatrizBidimensional creditoPuente = (MatrizBidimensional) manejadorVariables.obtenerVariable("pry_arr_num_mes_inf");
    LinkedList<Double> porcentajeSalida = new LinkedList<Double>();
    LinkedList<CeldaFechaValor> listaPorcentajes = (LinkedList) creditoPuente.getCeldas();
    double porcentajeAnual = 1.0;
    double auxiliar = 0.0;
    int tamano = listaPorcentajes.size();
    CeldaFechaValor celda;
    int i = 0;
    int guardador;
    double valor;
      System.out.println("******************************************************");
      System.out.println("el tamanazo es "+tamano);
      System.out.println("la matriz mes inf "+creditoPuente);
      System.out.println("*****************************************************");
    for (; i < tamano; i++) {
      guardador = i + 1;
      celda = listaPorcentajes.get(i);
      valor = celda.getValor() / 100;  //sacar este fuera del for
      auxiliar = ((100 + valor) * .01);
      porcentajeAnual *= auxiliar;
      //si pasaron los 12 meses lo mandamos a la lista
      if (guardador % 12 == 0) {
        porcentajeAnual = (porcentajeAnual - 1.0) * 100;
        porcentajeSalida.add(porcentajeAnual);
        porcentajeAnual = 1.0;
      }
    }
    //Si no pasan anios exactos no se guarda el ultimo
    manejadorVariables.guardarVariable("pry_inf", porcentajeSalida);
    return porcentajeSalida;
  }

  /**
   * Se encarga de calcular los porcentajes anuales de la Tasa de CETES
   */
  public LinkedList<Double> listaTasaCetes() {
    MatrizBidimensional creditoPuente = (MatrizBidimensional) manejadorVariables.obtenerVariable("pry_arr_num_mes_cet");
    LinkedList<Double> porcentajeSalida = new LinkedList<Double>();
    LinkedList<CeldaFechaValor> listaPorcentajes = (LinkedList) creditoPuente.getCeldas();
    double porcentajeAnual = 1.0;
    double auxiliar = 0.0;
    int tamano = listaPorcentajes.size();
    CeldaFechaValor celda;
    int i = 0;
    int guardador;
    double valor;
    for (; i < tamano; i++) {
      guardador = i + 1;
      celda = listaPorcentajes.get(i);
      valor = celda.getValor() / 100;  //sacar este fuera del for
      auxiliar = ((100 + valor) * .01);
      porcentajeAnual *= auxiliar;
      //si pasaron los 12 meses lo mandamos a la lista
      if (guardador % 12 == 0) {
        porcentajeAnual = (porcentajeAnual - 1.0) * 100;
        porcentajeSalida.add(porcentajeAnual);
        porcentajeAnual = 1.0;
      }
    }
    //Si no pasan anios exactos no se guarda el ultimo
    manejadorVariables.guardarVariable("pry_tas_cet", porcentajeSalida);
    return porcentajeSalida;
  }

  public LinkedList<MatrizBidimensional> tablaMatrizDeObraConstruccion() {
    MatrizBidimensional[] matrices = (MatrizBidimensional[]) manejadorVariables.obtenerVariable("pry_arr_mat_pro_vnt_eta");
    LinkedList<Double> lista = obtenerListaEtapas();
    List<CeldaFechaValor> salida = new LinkedList<CeldaFechaValor>();
    //**************************************************************************
    int desface = 1;
    CeldaFechaValor cfv;
    double numViviendas;
    double valor;
    LinkedList<MatrizBidimensional> matrizSalida = new LinkedList<MatrizBidimensional>();
    //MatrizBidimensional[] matrizSalida = new MatrizBidimensional[numeroEtapas];
    CeldaFechaValor nuePorcentaje;
    MatrizBidimensional maux;
    //System.out.println("Numero de etapas " + numeroEtapas);  
    for (int i = 0; i < numeroEtapas; i++) {
      maux = new MatrizBidimensional();
      MatrizBidimensional matriz = matrices[i];
      List<CeldaFechaValor> celdas = matriz.getCeldas();  // obtengo la etapa
      int tamano = celdas.size();
      numViviendas = lista.get(i);
      for (int j = 0; j < tamano; j++) {
        cfv = celdas.get(j);
        valor = cfv.getValor();
        Calendar cal = obtenerDesface(cfv.getFecha(), desface);
        //System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Date aux = cal.getTime();
        double porcentaje = valor / numViviendas;
        porcentaje = porcentaje * 100;
        double redondeado = Math.round(porcentaje);
        nuePorcentaje = new CeldaFechaValor(cal, redondeado);//antes proyecto
        maux.agregarCelda(nuePorcentaje);
      }
      matrizSalida.add(maux);
    }
    //lo mandamos a la base
    manejadorVariables.guardarVariable("pry_arr_mat_pro_obr_con", matrizSalida);
    return matrizSalida;
  }

  //Dependiendo de el numero de meses de desface nos regresa esa fecha
  private Calendar obtenerDesface(Calendar actual, int desface) {
    Calendar salida = Calendar.getInstance();
    Date fechaActual = actual.getTime();
    for (int i = 0; i < desface; i++) {
      fechaActual.setMonth(fechaActual.getMonth() - 1);
    }
    salida.setTime(fechaActual);
    return salida;
  }

  private LinkedList<Double> obtenerListaEtapas() {
    Object[] objetos = (Object[]) manejadorVariables.obtenerVariable("pry_edi_num_viv_eta");
    LinkedList<Double> lista = new LinkedList<Double>();
    double tmp;
    for (Object o : objetos) {
      tmp = (Double) o;
      lista.add(tmp);
    }
    return lista;
  }

  //aqui la que calcula el total de la matriz de porcentajes de construccion
  public LinkedList<MatrizBidimensional> porcentajeObraConstruccion() {
    //MatrizBidimensional[] matrices = tablaMatrizDeObraConstruccion();
    LinkedList<MatrizBidimensional> tablaMatrizDeObraConstruccion = tablaMatrizDeObraConstruccion();
    int ttma = tablaMatrizDeObraConstruccion.size();
    MatrizBidimensional[] matrices = new MatrizBidimensional[ttma];
    for (int k = 0; k < ttma; k++) {
      matrices[k] = tablaMatrizDeObraConstruccion.get(k);
    }
    //LinkedList<MatrizBidimensional> autput = new LinkedList<MatrizBidimensional>();
    MatrizBidimensional[] matrizMultiplicada = multiplicaPorNumeroVivindas(matrices);
    System.out.println("Empieza el proceso de calcular");
    LinkedList<Double> listaEtapas = obtenerListaEtapas();
    MatrizBidimensional maBidi = new MatrizBidimensional();
    LinkedList<MatrizBidimensional> salida = new LinkedList<MatrizBidimensional>();
    double totalViviendas = 0.0;
    for (Double d : listaEtapas) {
      totalViviendas += d;
    }
    MatrizBidimensional aux = matrizMultiplicada[0]; //nos sirve como referencia
    List<CeldaFechaValor> celdas = aux.getCeldas();
    for (CeldaFechaValor cfv : celdas) {
      Calendar fecha = cfv.getFecha();
      double valor = cfv.getValor();
      double total = 0.0;
      for (int e = 1; e < numeroEtapas; e++) {
        MatrizBidimensional tmp = matrizMultiplicada[e];
        List<CeldaFechaValor> lista = tmp.getCeldas();
        double valorEncontrado = dameValorFecha(fecha, lista);
        total = valor + valorEncontrado;
        total = total / totalViviendas;
      }
      CeldaFechaValor nuevaCelda = cfv;
      nuevaCelda.setValor(total);
      maBidi.agregarCelda(nuevaCelda);
      if (salida.contains(maBidi)) {
       salida.add(maBidi);
      }
      //maBidi = new MatrizBidimensional();
    }
    //lo mandamos a la base
    manejadorVariables.guardarVariable("pry_arr_obr_con_tot", salida);
    return salida;
  }

  private MatrizBidimensional[] multiplicaPorNumeroVivindas(MatrizBidimensional[] matriz) {
    MatrizBidimensional[] matrices = matriz;
    LinkedList<Double> listaEtapas = obtenerListaEtapas();
    for (int e = 0; e < numeroEtapas; e++) {
      MatrizBidimensional mat = matrices[e];
      List<CeldaFechaValor> celdas = mat.getCeldas();
      for (int i = 0; i < celdas.size(); i++) {
        CeldaFechaValor cfv = celdas.get(i);
        double valor = cfv.getValor();
        double numViv = listaEtapas.get(e);
        double total = (valor / 100) * numViv;
        cfv.setValor(total);
        celdas.set(i, cfv);
      }
    }
    System.out.println("Matriz multiplicada por el num de vivi");
    for (MatrizBidimensional mb : matrices) {
      String c = mb.toString();
      System.out.println(c);
    }
    return matrices;
  }

  /**
   * Se encarga de arrancar todos los metodos 
   */
  public void procesar() {
    listaInflacion();
    listaInteresCreditoPuente();
    listaTasaCetes();
    listaTotalTitulacionEtapa();
    listaTotalVentaEtapa();
    obtenerCostoTotalConstruccion();
    obtenerEdificacionCasasTotal();
    obtenerEdificacionDepartamentosTotal();
    obtenerGastosGeneralesTotal();
    obtenerImprevistosTotal();
    obtenerInfraestructuraTotal();
    obtenerMantenimientoVigilanciaTotal();
    obtenerObligacionesPatronalesTotal();
    obtenerOrnatoTotal();
    obtenerPaquetesAcabadosTotal();
    obtenerPorcentajePagoTerreno();
    obtenerSupervisionObraTotal();
    obtenerUrbanizacionTotal();
    obtenerUrbanizacionAccesoTotal();
    obtenerValorTotalTerreno();
    obtenerValorTotalConstrucciones();
    tablaMatrizDeObraConstruccion();
    porcentajeObraConstruccion();
  }
  public static void main(String[] args) {
    Dao dao = new Dao();
    ManejadorVariablesProyectos m = new ManejadorVariablesProyectos(dao.getPryInd(46));
    InformacionBasica ib = new InformacionBasica(m);
  //LinkedList<Double> listaInteresCreditoPuente = ib.listaInteresCreditoPuente();
  //    System.out.println("Valor total del terreno");
  //    Double obtenerValorTotalTerreno = ib.obtenerValorTotalTerreno();
  //    System.out.println(obtenerValorTotalTerreno);
  //
  //    System.out.println("total de superficie");
  //    Double obtenerValorTotalConstrucciones = ib.obtenerValorTotalConstrucciones();
  //    System.out.println(obtenerValorTotalConstrucciones);
  //
  //    System.out.println("Costo total de la construccion");
  //    Double obtenerCostoTotalConstruccion = ib.obtenerCostoTotalConstruccion();
  //    System.out.println(obtenerCostoTotalConstruccion);
  //
  //    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
  //    //System.out.println("******El valor de credito puente es *************");
  //    //for (double d : listaInteresCreditoPuente) {
  //    //System.out.println("***** el valor es " + d);
  //    //}
  //    LinkedList<CeldaFechaValor> listaTotalVentaEtapa = ib.listaTotalVentaEtapa();
  //    LinkedList<CeldaFechaValor> lista2 = ib.listaTotalTitulacionEtapa();
  //    Double obtenerPorcentajePagoTerreno = ib.obtenerPorcentajePagoTerreno();lor
  //    System.out.println("*********************************************");
  //    System.out.println(obtenerPorcentajePagoTerreno);
  //    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
  //    for (CeldaFechaValor cd : listaTotalVentaEtapa) {
  //      System.out.println("fecha " + cd.getFechaTexto() + " valor " + cd.getValor());
  //    }
  //
  //    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
  //    for (CeldaFechaValor cl : lista2) {
  //      System.out.println("fecha "+ cl.getFechaTexto() + " Valor "+ cl.getValor());
  //    }
  //  ib.tablaMatrizDeObraConstruccion();
//    MatrizBidimensional[] tablaMatrizDeObraConstruccion = ib.tablaMatrizDeObraConstruccion();
//    System.out.println("\n");
  // ib.porcentajeObraConstruccion();
  //    MatrizBidimensional[] tablaMatrizDeObraConstruccion = ib.tablaMatrizDeObraConstruccion();
  //    for (MatrizBidimensional mb : tablaMatrizDeObraConstruccion) {
  //      List<CeldaFechaValor> celdas = mb.getCeldas();
  //      for (CeldaFechaValor cfv : celdas) {
  //        System.out.println("Fecha " + cfv.getFechaTexto() + "   Valor " + cfv.getValor());
  //      }
  //
  //      //System.out.println(sb.toString());
  //    }
//    MatrizBidimensional porcentajeObraConstruccion = ib.porcentajeObraConstruccion();
//    String ole = porcentajeObraConstruccion.toString();
//    System.out.println(ole);
//    LinkedList<MatrizBidimensional> tablaMatrizDeObraConstruccion = ib.tablaMatrizDeObraConstruccion();
//    for (MatrizBidimensional m6 : tablaMatrizDeObraConstruccion) {
//      System.out.println(
//      m6.toString());
//    }
//    LinkedList<MatrizBidimensional> porcentajeObraConstruccion = ib.porcentajeObraConstruccion();
//    for (MatrizBidimensional mv : porcentajeObraConstruccion) {
//      System.out.println(mv.toString());
//    }
    ib.obtenerGastosGeneralesTotal();
    System.out.println("gtos " + ib.obtenerGastosGeneralesTotal().toString());
  }//end main
}//end informacion basica
