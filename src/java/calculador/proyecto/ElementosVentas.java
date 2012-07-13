package calculador.proyecto;

import base.Dao;
import java.util.LinkedList;
import util.Funciones;
import variables.ManejadorVariablesProyectos;

/**
 * Clase que Emula los elementos de venta de los proyectos individuales
 * @author Hector Daniel Gonzalez Teran
 */
public class ElementosVentas {

  private final String NUM_ETAPAS = "pry_num_eta";
  private final String NUM_UNIDADES_ETA = "pry_edi_num_viv_eta";
  private final String PRECIO_METRO_CUA = "pry_pre_mcua";
  private final String METRO_CUA_UNI = "pry_mcua_uni";
  private final String SOBREPRECIO = "pry_sbpr";
  private final String POR_ENG = "pry_por_eng";
  private final String NUM_MES_CONF_ENG = "pry_num_mes_ing_eng";
  private final String NUM_MES_CONF_TIT = "pry_num_mes_ing_tit";
  private int redondeo;
  /**
   * Manejador de variables que nos ayuda a comunicarnos
   * con la base de datos
   */
  private ManejadorVariablesProyectos manejadorVariables;
  /**
   * numero de etapas del proyecto
   */
  private Object numeroEta;
  /**
   * Arreglo de numero de viviendas por etapa
   */
  private Object unidadesEtapa[];
  /**
   * Numero total de unidades del proyecto
`   */
  private Object numeroUniProyecto;
  /**
   * Arreglo de precios por metro cuadrado por etapa
   */
  private Object precio_m2[];
  /**
   * Arreglo de metros cuadrados por unidad por etapa
   */
  private Object m2_unidad[];
  /**
   * Arreglo de sobreprecios por etapas
   */
  private Object sobreprecio[];
  /**
   * Arreglo de porcentajes de enganche por etapa
   */
  private Object porEng[];
  /**
   * Arreglo de porcentajes de credito por estapa
   */
  static private LinkedList<Double> porCre;
  /**
   * Arreglo de valor de venta de viviendas por etapa
   */
  private LinkedList<Double> valorViviendas;

  /**
   * Constructor de la clase Elementos de venta
   * @param manejador de variables que comunica a la base 
   */
  public ElementosVentas(ManejadorVariablesProyectos manejadorVariables) {
    this.manejadorVariables = manejadorVariables;
    this.redondeo = redondeo;
    consigueNumEtapa();
    consigueUnidadesEtapa();
    numeroUnidadesProyecto();
    consiguePrecio_m2();
    consigueM2_unidad();
    consigueSobreprecio();
    consiguePorEng();
    calculaCreditoProyectos();
  }
  
  /**
   * ejecuta todos los calculos de ElementosVentas
   */
  public void procesar()
  {
    valorXVivienda();
    ingresoXEnganchesProyecto();
    ingresoXTitulacionProyecto();
    System.out.println("estoy en procesar de elementos de venta");
    ingresoTotalProyecto();
    System.out.println("paso bien todo");
    valorPromedioVivienda();
    valorTotalViviendasProyecto();
    valorTotalSobrepreciosProyecto();
    valorPorEngEta();
    valorPorCreEta();
  }

  /**
   * Consigue el numero de etapas
   */
  private void consigueNumEtapa() {
    this.setNumeroEta((Double) manejadorVariables.obtenerVariable(NUM_ETAPAS));
  }

  /**
   * Consigue el arreglo de unidades de viviendas por etapa
   */
  private void consigueUnidadesEtapa() {
    this.setUnidadesEtapa((Object[]) manejadorVariables.obtenerVariable(NUM_UNIDADES_ETA));
  }

  /**
   * Consigue el arreglo de precios por metro cuadrado por etapa
   */
  private void consiguePrecio_m2() {
    this.setPrecio_m2((Object[]) manejadorVariables.obtenerVariable(PRECIO_METRO_CUA));
  }

  /**
   * Consigue el arreglo de todos el area en metros cuadrados de las viviendas por etapa
   */
  private void consigueM2_unidad() {
    this.setM2_unidad((Object[]) manejadorVariables.obtenerVariable(METRO_CUA_UNI));
  }

  /**
   * Consigue el arreglo de sobreprecios de las estapa
   */
  private void consigueSobreprecio() {
    this.setSobreprecio((Object[]) manejadorVariables.obtenerVariable(SOBREPRECIO));
  }

  /**
   * Consigue el arreglo de porcentajes de enganches por etapa
   */
  private void consiguePorEng() {
    porEng = ((Object[]) manejadorVariables.obtenerVariable(POR_ENG));
  }

  /**
   * Numero de unidades de vivienda del proyecto
   */
  public void numeroUnidadesProyecto() {
    /////PUEDE HABER COSAS COMO LAS QUE TE PASO AQUI
    numeroUniProyecto = 0.0;
    for (int i = 0; i < (Double) getNumeroEta(); i++) {
      setNumeroUniProyecto((Double) getNumeroUniProyecto() + (Double) getUnidadesEtapa()[i]);
    }
    manejadorVariables.guardarVariable("pry_uni_viv", getNumeroUniProyecto());
  }

  /**
   * Calcula los porcentaje de credito de las etapas
   * @param porcentajeEng el porccentaje de enganche de esa etapa
   * @return los porcentajes de titulacion por etapa 
   */
  public LinkedList<Double> calculaCreditoProyectos() {
    porCre = new LinkedList<Double>();
    for (int i = 0; i < (Double) getNumeroEta(); i++) {
      porCre.add(1 - ((Double) porEng[i] * 0.01));
    }
    manejadorVariables.guardarVariable("pry_por_cre", getPorCre());
    return getPorCre();
  }

  /**
   * Calcula el valor de las viviendas por etapas
   * @return el valor de las viviendas de todas las etapas del proyecto
   */
  public LinkedList<Double> valorXVivienda() {
    setValorViviendas(new LinkedList<Double>());
    for (int i = 0; i < (Double) getNumeroEta(); i++) {
      getValorViviendas().add((Double) getPrecio_m2()[i] * (Double) getM2_unidad()[i]);
    }
    manejadorVariables.guardarVariable("pry_val_ven", getValorViviendas());
    return getValorViviendas();
  }

  /**
   * Valor de todos los enganches de las viviendas por etapa
   * @param numViviendasEta el numero de viviendas en la etapa en cuestion
   * @param porEng el porcentaje de enganche de las viviendas 
   * @param valorVivienda el valor de comercialización de las casas
   * @param sobrepre el sobreprecio de las viviendas
   * @return el valor de los enganches de todas las viviendas por etapa
   */
  private double enganchesViviendasXEtapa(double numViviendasEta, double porEng, double valorVivienda, double sobrepre) {
//    System.out.println("viviendas etapa: " + numViviendasEta);
//    System.out.println("porEng: " + porEng*0.01);
//    System.out.println("valorVivienda: " + valorVivienda);
//    System.out.println("sobreprecio: " + sobrepre);
    Double aux = (numViviendasEta * porEng * 0.01 * valorVivienda) + (numViviendasEta * sobrepre);
//    System.out.println(aux);
    return aux;
  }

  /**
   * Valor de todos las titulaciones de las viviendas por etapa
   * @param numViviendasEta el numero de viviendas en la etapa en cuestion
   * @param porCre el porcentaje de titulacion de las viviendas 
   * @param valorVivienda el valor de comercialización de las casas
   * @return el valor de los titulaciones de todas las viviendas por etapa
   */
  private double titulacionesViviendasXEtapa(double numViviendasEta, double porCre, double valorVivienda) {
//    System.out.println("viviendas etapa: " + numViviendasEta);
//    System.out.println("porEng: " + porCre);
//    System.out.println("valorVivienda: " + valorVivienda);
//    System.out.println(numViviendasEta * porCre * valorVivienda);

    return numViviendasEta * porCre * valorVivienda;
  }

  /**
   * Suma de todos los enganches de todas las viviendas de todo el proyecto 
   * @return le valor de los enganches de todo el proyecto
   */
  public double ingresoXEnganchesProyecto() {
    double sumaEnganches = 0.0;
    for (int i = 0; i < (Double) getNumeroEta(); i++) {
      sumaEnganches += enganchesViviendasXEtapa((Double) getUnidadesEtapa()[i], (Double) getPorEng()[i], (Double) getValorViviendas().get(i), (Double) getSobreprecio()[i]);
      //System.out.println("en ingresos enganches indice " + i + ": " + sumaEnganches + "\n");
    }
    manejadorVariables.guardarVariable("pry_ing_eng_viv", sumaEnganches);
    return sumaEnganches;
  }

  /**
   * Suma de todos las titulaciones de todas las viviendas de todo el proyecto proyecto
   * @return le valor de los titulaciones de todo el proyecto
   */
  public double ingresoXTitulacionProyecto() {
    double sumaTitulaciones = 0.0;
    for (int i = 0; i < (Double) getNumeroEta(); i++) {
      sumaTitulaciones += titulacionesViviendasXEtapa((Double) getUnidadesEtapa()[i], (Double) getPorCre().get(i), (Double) getValorViviendas().get(i));
      //System.out.println("en ingresos titulacion indice " + i + ": " + sumaTitulaciones + "\n");
    }
    manejadorVariables.guardarVariable("pry_ing_tit_viv", sumaTitulaciones);
    System.out.println("paso por INGRESOTITULACION");
    return sumaTitulaciones;
  }

  /**
   * Ingresos totales del proyecto
   * @return la suma de los ingresos por los enganches y titulaciones de todas las etapas del proyecto
   */
  public double ingresoTotalProyecto() {
    double ingresoTotalProyecto = ingresoXEnganchesProyecto() + ingresoXTitulacionProyecto();
    manejadorVariables.guardarVariable("pry_ing_tot_viv", ingresoTotalProyecto);
    System.out.println("en el metodo: " + manejadorVariables.obtenerVariable("pry_ing_tot_viv"));
    return ingresoTotalProyecto;
  }

  /**
   * Valor promedio de las viviendas del proyecto
   * @return el valor promedio de las viviendas
   */
  public double valorPromedioVivienda() {
    double promedio = ((Double) getNumeroUniProyecto() != 0) ? (ingresoTotalProyecto() / (Double) getNumeroUniProyecto()) : 0;
    manejadorVariables.guardarVariable("pry_val_prom_ven_viv", promedio);
    return promedio;
  }

  /**
   * Valor total de las viviendas por proyecto
   * @return la suma de las viviendas de todo el proyecto
   */
  public double valorTotalViviendasProyecto() {
    double valorTotalViviendas = 0.0;
    for (int i = 0; i < (Double) getNumeroEta(); i++) {
      valorTotalViviendas += (Double) getValorViviendas().get(i) * (Double) getUnidadesEtapa()[i];
    }
    manejadorVariables.guardarVariable("pry_ing_tot_val_ven", valorTotalViviendas);
    return valorTotalViviendas;
  }

  /**
   * Valor total de los sobreprecios de las viviendas por proyecto
   * @return la suma de los sobreprecios de todo el proyecto
   */
  public double valorTotalSobrepreciosProyecto() {
    double valorTotalSobreprecios = 0.0;
    for (int i = 0; i < (Double) getNumeroEta(); i++) {
      valorTotalSobreprecios += (Double) getSobreprecio()[i] * (Double) getUnidadesEtapa()[i];
    }
    manejadorVariables.guardarVariable("pry_ing_tot_sbpr", valorTotalSobreprecios);
    return valorTotalSobreprecios;
  }

  /**
   * Valores de la enganche de las viviendas por unidad de todas las etapas
   * @return una lista con los valores de porcentajes de enganche por etapas
   */
  public LinkedList<Double> valorPorEngEta() {
    LinkedList<Double> valEng = new LinkedList<Double>();
    for (int i = 0; i < (Double) getNumeroEta(); i++) {
      valEng.add((Double) getValorViviendas().get(i) * (Double) getPorEng()[i] * 0.01 + (Double) getSobreprecio()[i]);
    }
    manejadorVariables.guardarVariable("pry_val_eng_eta", valEng);
    return valEng;
  }

  /**
   * Valores de la credito de las viviendas por unidad de todas las etapas
   * @return una lista con los valores de porcentajes de credito por etapas
   */
  public LinkedList<Double> valorPorCreEta() {
    LinkedList<Double> valCre = new LinkedList<Double>();
    for (int i = 0; i < (Double) getNumeroEta(); i++) {
      valCre.add(getValorViviendas().get(i) * getPorCre().get(i));
    }
    manejadorVariables.guardarVariable("pry_val_cre_eta", valCre);
    return valCre;
  }

  /**
   * @return the numeroEta
   */
  public Object getNumeroEta() {
    return numeroEta;
  }

  /**
   * @param numeroEta the numeroEta to set
   */
  public void setNumeroEta(Object numeroEta) {
    this.numeroEta = numeroEta;
  }

  /**
   * @return the unidadesEtapa
   */
  public Object[] getUnidadesEtapa() {
    if (unidadesEtapa == null) {
      System.out.println("pasa por null");
    }
    return unidadesEtapa;
  }

  /**
   * @param unidadesEtapa the unidadesEtapa to set
   */
  public void setUnidadesEtapa(Object[] unidadesEtapa) {
    this.unidadesEtapa = unidadesEtapa;
  }

  /**
   * @return the numeroUniProyecto
   */
  public Object getNumeroUniProyecto() {
    return numeroUniProyecto;
  }

  /**
   * @param numeroUniProyecto the numeroUniProyecto to set
   */
  public void setNumeroUniProyecto(Object numeroUniProyecto) {
    this.numeroUniProyecto = numeroUniProyecto;
  }

  /**
   * @return the precio_m2
   */
  public Object[] getPrecio_m2() {
    return precio_m2;
  }

  /**
   * @param precio_m2 the precio_m2 to set
   */
  public void setPrecio_m2(Object[] precio_m2) {
    this.precio_m2 = precio_m2;
  }

  /**
   * @return the m2_unidad
   */
  public Object[] getM2_unidad() {
    return m2_unidad;
  }

  /**
   * @param m2_unidad the m2_unidad to set
   */
  public void setM2_unidad(Object[] m2_unidad) {
    this.m2_unidad = m2_unidad;
  }

  /**
   * @return the sobreprecio
   */
  public Object[] getSobreprecio() {
    return sobreprecio;
  }

  /**
   * @param sobreprecio the sobreprecio to set
   */
  public void setSobreprecio(Object[] sobreprecio) {
    this.sobreprecio = sobreprecio;
  }

  /**
   * @return the porEng
   */
  public Object[] getPorEng() {
    return porEng;
  }

  /**
   * @param porEng the porEng to set
   */
  public void setPorEng(Object[] porEng) {
    this.porEng = porEng;
  }

  /**
   * @return the porCre
   */
  public LinkedList<Double> getPorCre() {
    return porCre;
  }

  /**
   * @param porCre the porCre to set
   */
  public void setPorCre(LinkedList<Double> porCre) {
    this.porCre = porCre;
  }

  /**
   * @return the valorViviendas
   */
  public LinkedList<Double> getValorViviendas() {
    return valorViviendas;
  }

  /**
   * @param valorViviendas the valorViviendas to set
   */
  public void setValorViviendas(LinkedList<Double> valorViviendas) {
    this.valorViviendas = valorViviendas;
  }
  
  

  public static void main(String[] args) {
    Dao dao = new Dao();
    ManejadorVariablesProyectos m = new ManejadorVariablesProyectos(dao.getPryInd(46));
    ElementosVentas elementos = new ElementosVentas(m);
    
    LinkedList<Double> aux;
    Double auxiliar;
    System.out.println("unidades de proyecto - numeroUnidadesProyecto()");
    elementos.numeroUnidadesProyecto();
    System.out.println(elementos.getNumeroUniProyecto());

    System.out.println("\nporcentaje creditos por etapa - calculaCreditoProyectos()");
    aux = elementos.calculaCreditoProyectos();
    for (Object e : aux) {
      System.out.println("credito: " + e);
    }

    System.out.println("\nCalcula el valor de las viviendas por etapas - valorXVivienda()");
    aux = elementos.valorXVivienda();
    for (Object e : aux) {
      System.out.println("valor vivienda: " + e);
    }

    System.out.println("\nSuma de todos los enganches de todas las viviendas de todo el proyecto proyecto - ingresoXEnganchesProyecto()");
    auxiliar = elementos.ingresoXEnganchesProyecto();
    System.out.println("enganches: " + auxiliar);

    System.out.println("\nSuma de todos las titulaciones de todas las viviendas de todo el proyecto proyecto - ingresoXTitulacionProyecto()");
    auxiliar = elementos.ingresoXTitulacionProyecto();
    System.out.println("titulaciones: " + auxiliar);

    System.out.println("\nIngresos totales del proyecto - ingresoTotalProyecto()");
    auxiliar = elementos.ingresoTotalProyecto();
    System.out.println("ingresos totales: " + auxiliar);

    System.out.println("\nValor promedio de las viviendas del proyecto - valorPromedioVivienda()");
    auxiliar = elementos.valorPromedioVivienda();
    System.out.println("valor promedio: " + auxiliar);

    System.out.println("\nValor total de las viviendas por proyecto - valorTotalViviendasProyecto()");
    auxiliar = elementos.valorTotalViviendasProyecto();
    System.out.println("valor total de las viviendas: " + auxiliar);

    System.out.println("\nValor total de los sobreprecios de las viviendas por proyecto - valorTotalSobrepreciosProyecto()");
    auxiliar = elementos.valorTotalSobrepreciosProyecto();
    System.out.println("valor total sobreprecios: " + auxiliar);

    System.out.println("\nValores de la enganche de las viviendas por unidad de todas las etapas - valorPorEngEta()");
    aux = elementos.valorPorEngEta();
    for (Object o : aux) {
      System.out.println("valor enganches viviendas: " + o);
    }
    
    System.out.println("\nValores de la credito de las viviendas por unidad de todas las etapas - valorPorCreEta()");
    aux = elementos.valorPorCreEta();
    for (Object o : aux) {
      System.out.println("valor credito viviendas: " + o);
    }
    
    System.out.println("ya hasta el ultimo de elementos de ventas primero como metodo: " + elementos.ingresoTotalProyecto());
    System.out.println("como guarda en variable: " + (Double)m.obtenerVariable("pry_ing_tot_viv"));
    
  }
}
