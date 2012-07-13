package calculador.proyecto;

import base.Dao;
import java.lang.reflect.Method;
import java.util.LinkedList;
import util.Espejo;
import util.Funciones;
import util.proyecto.GeneradoresAux;
import variables.ManejadorVariablesProyectos;

/**
 *
 * @author daniel
 */
public class Generadores {

  /**
   * id de terrenos y escrituras
   */
  private final int IDT_PREDIAL_AGUA_FC = 0;
  private final int IDT_ESCRUTURA_AVALUO_FC = 1;
  private final int IDT_ADMON_FIDEICOMISO_TOT = 2;
  /**
   * id de proyecto
   */
  private final int IDP_PROY_ARQUI_FORMA_FC = 0;
  private final int IDP_PROY_ARQUI_MON = 1;
  private final int IDP_DRO_FIRMAS_FC = 2;
  private final int IDP_CALC_EST_INST_FC = 3;
  private final int IDP_CALC_EST_INST_MON = 4;
  private final int IDP_MEC_SUE_TOP_FC = 5;
  private final int IDP_MEC_SUE_TOP_MON = 6;
  /**
   * id de tramites, licencias y derechos
   */
  private final int IDL_GES_VEC_TERCEROS_FC = 0;
  private final int IDL_GES_VEC_TERCEROS_MON = 1;
  private final int IDL_TRAM_LIC_FC = 2;
  private final int IDL_TRAM_LIC_MON = 3;
  private final int IDL_CONS_VEC_FC = 4;
  private final int IDL_CONS_VEC_MON = 5;
  private final int IDL_POZO_AGUA_FC = 6;
  private final int IDL_POZO_AGUA_MON = 7;
  private final int IDL_PRE_LUZ_FUE_FC = 8;
  private final int IDL_PRE_LUZ_FUE_MON = 9;
  private final int IDL_REG_PROPIEDAD_CON_FC = 10;
  private final int IDL_REG_PROPIEDAD_CON_MON = 11;
  /**
   * id de ventas
   */
  private final int IDV_COMISIONES_VENTA_FC = 0;
  private final int IDV_COMISION_VENTA_CONTRATO_FC = 1;
  private final int IDV_COMISION_VENTA_TITULACION_FC = 2;
  private final int IDV_PUBLICIDAD_CORP_FC = 3;
  private final int IDV_PUBLICIDAD_PROMO_FC = 4;
  private final int IDV_ESCENARIO_MANTO_VIGILANCIA_FC = 5;
  private final int IDV_AMUEBLADO_DECORADO_FC = 6;
  /**
   * id de otros
   */
  private final int IDO_AMENIDADES_FC = 0;
  private final int IDO_AMENIDADES_MON = 1;
  private final int IDO_OTROS2_FC = 2;
  private final int IDO_OTROS2_MON = 3;
  private final int IDO_OTROS3_FC = 4;
  private final int IDO_OTROS3_MON = 5;
  /**
   * id de socios y gastos de admon
   */
  private final int IDS_GTOS_OP_ADMON_UNE_FC = 0;
  private final int IDS_GTOS_OP_ADMON_COR_FC = 1;
  /**
   * id de credito puente
   */
  private final int IDC_CREDI_PUENTE_PORCENTAJE = 0;
  private final int IDC_APERTURA_CREDI_PUENTE_PORCENTAJE = 1;
  private final int IDC_SEGUROS_FINANZAS_PORCENTAJE = 2;
  private final int IDC_SUP_OBRAS_PORCENTAJE = 3;
  /**
   * id de anticipo
   */
  private final int IDA_ANTICIPO_CREDI_PUENTE_FC = 0;
  private final int IDA_DISPOSICION_RECURSOS_FC = 1;
  private final int IDA_AMORTIZACION_CREDITO_FC = 2;
  /**
   * Objeto de la clase auxiliar de Generadores
   */
  private GeneradoresAux aux;
  private ManejadorVariablesProyectos manejador;
  private double numUni;
  private double valorTotal;
  private Double numEtapas;
  private Object[] unidadesXEtapa;

  public Generadores(ManejadorVariablesProyectos manejadorVariables) {
    aux = new GeneradoresAux(manejadorVariables);
    this.manejador = manejadorVariables;
    consigueNumUni();
    consigueValorTotal();
    consigueNumeroEtapas();
    consigueUnidadesEtapas();
  }
  
  /**
   * ejecuta el todos lo metodos de Generadores
   */
  public void procesar()
  {
    valorCompraTerrenoVivienda();
    predialAguaTotal();
    predialAguaVivienda();
    escriturasAvaluoTotal();
    escriturasAvaluoVivienda();
    admonFideicomisoVivienda();
    totalTerrenoEscrituras();
    
    proyectoArquiTotal();
    proyectoArquiVivienda();
    droFirmasTotal();
    droFirmasViviendas();
    calculoEstructuralTotal();
    calculoEstructuralVivienda();
    mecanicaTopoTotal();
    mecanicaTopoVivienda();
    totalProyecto();
    
    gestionesVecinalesTotal();
    gestionesVecinalesVivienda();
    tramitesLicenciosTotal();
    tramitesLicenciosVivienda();
    consertacionesVecinalesTotal();
    consertacionesVecinalesVivienda();
    pozoAguaTotal();
    pozoAguaVivienda();
    luzFuerzaTotal();
    luzFuerzaVivienda();
    regimenPropCondTotal();
    regimenPropCondVivienda();
    totalTramitesLicencias();

    edificacionCasasVivienda();
    urbVivienda();
    urbAccesoVivienda();
    ediDepVivienda();
    areaExtVivienda();
    gtosGralVivienda();
    imprevistosVivienda();
    obliPatVivienda();
    paqueteAcabadosVivienda();
    mantenimientoVigEscVivienda();
    supervicionObraVivienda();
    infraestructuraVivienda();
    
    comisionVentasTotal();
    comisionVentasVivienda();
    comisionVenConTotal();
    comisionVenConVivienda();
    comisionVenTitTotal();
    comisionVenTitVivienda();
    publicidadCoorpTotal();
    publicidadCoorpVivienda();
    publicidadPromocionTotal();
    publicidadPromocionVivienda();
    escenarioVigilanciaTotal();
    escenarioVigilanciaVivienda();
    amuebladoDecoradoTotal();
    amuebladoDecoradoVivienda();
    totalVentas();
    
    amenidadesTotal();
    amenidadesVivienda();
    otros2Total();
    otros2Vivienda();
    otros3Total();
    otros3Vivienda();
    totalOtros();

    gtosAdmonOpUNETotal();
    gtosAdmonOpUNEVivienda();
    gtosAdmonOpCORTotal();
    gtosAdmonOpCORVivienda();
    
    creditoPuenteSolTotal();
    creditoPuenteSolVivienda();
    aperturaCreditoPuenteTotal();
    aperturaCreditoPuenteVivienda();
    segurosFianzasGtosTotal();
    segurosFianzasGtosVivienda();
    supervicionObrAdmonRecTotal();
    supervicionObrAdmonRecVivienda();
    
    anticipoCreditoPuenteTotal();
    anticipoCreditoPuenteVivienda();
    anticipoCreditoPuenteEtapa();
    disposicionRecCreditoPuenteTotal();
    disposicionRecCreditoPuenteVivienda();
    disposicionRecCreditoPuenteEtapa();
    amortizacionCreditoPuenteTotal();
    amortizacionCreditoPuenteVivienda();
    amortizacionCreditoPuenteEtapa();
  }

  //se calcula de elementoventa
  private void consigueNumUni() {
    numUni = (Double) manejador.obtenerVariable("pry_uni_viv");
  }

  private void consigueValorTotal() {
    valorTotal = (Double) manejador.obtenerVariable("pry_ing_tot_viv");
      System.out.println("\n\n\nESTOY EN GENERADORES: " + valorTotal);
  }

  private void consigueNumeroEtapas() {
    numEtapas = (Double)manejador.obtenerVariable("pry_num_eta");
  }

  private void consigueUnidadesEtapas() {
    unidadesXEtapa = (Object[]) manejador.obtenerVariable("pry_edi_num_viv_eta");
  }
  ///////////TERRENOS Y ESCRITURAS

  /**
   * calcula el valor de compra del terreno por vivienda
   * @return valor de compre del terreno por vivienda
   */
  public double valorCompraTerrenoVivienda() {
    double valorCompra = 0.0;
    if (numUni != 0) {
      valorCompra = (Double) manejador.obtenerVariable("pry_val_ter") / numUni;
      System.out.println("pry_val_ter: " + (Double) manejador.obtenerVariable("pry_val_ter"));
      manejador.guardarVariable("pry_val_com_ter_imp_viv", valorCompra);
      return valorCompra;
    } else {
      manejador.guardarVariable("pry_val_com_ter_imp_viv", valorCompra);
      return valorCompra;
    }
  }

  /**
   * calcula el valor total del predial, agua, areas comunes importe total
   */
  public double predialAguaTotal() {
    double predial = (Double) manejador.obtenerVariable("pry_cos_cons") * aux.getTerrenosEsc()[IDT_PREDIAL_AGUA_FC] * 0.01;
    System.out.println("en predial agua: " + (Double) manejador.obtenerVariable("pry_cos_cons"));
    System.out.println("el numero del arreglo: " + aux.getTerrenosEsc()[IDT_PREDIAL_AGUA_FC] * 0.01);
    manejador.guardarVariable("pry_val_tot_con_imp_tot", (predial));
    return predial;
  }

  /**
   * calcula el valor del predial, agua, areas comunes por vivienda
   * @return el valor del predial, agua, areas comunes por vivienda
   */
  public double predialAguaVivienda() {
    double predial = 0.0;
    if (numUni != 0) {
      predial = predialAguaTotal() / numUni;
      manejador.guardarVariable("pry_val_tot_con_imp_viv", predial);
      System.out.println("numUni" + numUni);
      return predial;
    } else {
      manejador.guardarVariable("pry_val_tot_con_imp_viv", predial);
      return predial;
    }
  }

  /**
   * calcula el valor de las escrituras, avaluo, isr, terreno importe total
   * @return el valor de las escrituras, avaluo, isr, terreno importe total
   */
  public double escriturasAvaluoTotal() {
    double escrituras = (Double) aux.getTerrenosEsc()[IDT_ESCRUTURA_AVALUO_FC] * (Double) manejador.obtenerVariable("pry_val_ter") * 0.01;
    System.out.println("escrituras valor del terreno: " + (Double) manejador.obtenerVariable("pry_val_ter"));
    manejador.guardarVariable("pry_esc_ava_fid_isr_imp_tot", escrituras);
    return escrituras;
  }

  /**
   * calcula el valor de las escrituras, avaluo, isr, terreno por vivienda
   * @return el valor de las escrituras, avaluo, isr, terreno por vivienda
   */
  public double escriturasAvaluoVivienda() {
    double escrituras = 0.0;
    if (numUni != 0) {
      escrituras = escriturasAvaluoTotal() / numUni;
      manejador.guardarVariable("pry_esc_ava_fid_isr_imp_viv", escrituras);
      return escrituras;
    } else {
      manejador.guardarVariable("pry_esc_ava_fid_isr_imp_viv", escrituras);
      return escrituras;
    }
  }

  /**
   * calcula el valor de la admon del fideicomiso por vivienda
   * @return el valor de la admon del fideicomiso por vivienda
   */
  public double admonFideicomisoVivienda() {
    double admon = 0.0;
    if (numUni != 0) {
      admon = (Double) aux.getTerrenosEsc()[IDT_ADMON_FIDEICOMISO_TOT] / numUni;
      manejador.guardarVariable("pry_adm_fid_imp_viv", admon);
      return admon;
    } else {
      manejador.guardarVariable("pry_adm_fid_imp_viv", admon);
      return admon;
    }
  }

  /**
   * calcula valor total del modulo de Terreno y Escrituras
   * @return la suma de todos los conceptos de Terrenos y Escrituras
   */
  public double totalTerrenoEscrituras() {
    double total = (Double) manejador.obtenerVariable("pry_val_ter") + predialAguaTotal() + escriturasAvaluoTotal() + (Double) aux.getTerrenosEsc()[IDT_ADMON_FIDEICOMISO_TOT];
    manejador.guardarVariable("pry_imp_tot_ter_esc", total);
    return total;
  }

  
  ///////////PROYECTO
  /**
   * calcula el valor de el proyecto arquitectonico importe total
   * @return el valor de el proyecto arquitectonico importe total 
   */
  public double proyectoArquiTotal() {
    double arqui = (Double) aux.getProyecto()[IDP_PROY_ARQUI_FORMA_FC] * (Double) aux.getProyecto()[IDP_PROY_ARQUI_MON];
    manejador.guardarVariable("pry_pro_arq_imp_tot", arqui);
    return arqui;
  }

  /**
   * calcula el valor de el proyecto arquitectonico por vivienda
   * @return el valor de el proyecto arquitectonico por vivienda 
   */
  public double proyectoArquiVivienda() {
    double arqui = 0.0;
    if (numUni != 0) {
      arqui = proyectoArquiTotal() / numUni;
      manejador.guardarVariable("pry_pro_arq_imp_viv", arqui);
      return arqui;
    } else {
      manejador.guardarVariable("pry_pro_arq_imp_viv", arqui);
      return arqui;
    }
  }

  /**
   * calcula el valor de las firmas y dro importe total
   * @return el valor de las firmas y dro importe total
   */
  public double droFirmasTotal() {
    double dro = (Double) aux.getProyecto()[IDP_DRO_FIRMAS_FC] * (Double) manejador.obtenerVariable("pry_dro_fir_mon");
    System.out.println("dro forma de calculo " + (Double) aux.getProyecto()[IDP_DRO_FIRMAS_FC]);
    System.out.println("monto de dro " + (Double) manejador.obtenerVariable("pry_dro_fir_mon"));
    manejador.guardarVariable("pry_dro_fir_imp_tot", dro);
    return dro;
  }

  /**
   * calcula el valor de las firmas y dro por vivienda
   * @return el valor de las firmas y dro por vivienda
   */
  public double droFirmasViviendas() {
    double dro = 0.0;
    if (numUni != 0) {
      dro = droFirmasTotal() / numUni;
      manejador.guardarVariable("pry_dro_fir_imp_viv", dro);
      return dro;
    } else {
      manejador.guardarVariable("pry_dro_fir_imp_viv", dro);
      return 0.0;
    }
  }

  /**
   * calcula el valor del calculo estructural importe total
   * @return el valor del calculo estructural importe total
   */
  public double calculoEstructuralTotal() {
    double estru = (Double) aux.getProyecto()[IDP_CALC_EST_INST_FC] * (Double) aux.getProyecto()[IDP_CALC_EST_INST_MON];
    manejador.guardarVariable("pry_cal_est_ins_imp_tot", estru);
    return estru;
  }

  /**
   * calcula el valor del calculo estructural por vivienda
   * @return el valor del calculo estructural por vivienda
   */
  public double calculoEstructuralVivienda() {
    double estru = 0.0;
    if (numUni != 0) {
      estru = calculoEstructuralTotal() / numUni;
      manejador.guardarVariable("pry_cal_est_ins_imp_viv", estru);
      return estru;
    } else {
      manejador.guardarVariable("pry_cal_est_ins_imp_viv", estru);
      return estru;
    }
  }

  /**
   * calcula el valor de la mecanica de suelos y topografia importe total
   * @return el valor de la mecanica de suelos y topografia importe total
   */
  public double mecanicaTopoTotal() {
    double mecanica = (Double) aux.getProyecto()[IDP_MEC_SUE_TOP_FC] * (Double) aux.getProyecto()[IDP_MEC_SUE_TOP_MON];
    manejador.guardarVariable("pry_mec_sue_top_imp_tot", mecanica);
    return mecanica;
  }

  /**
   * calcula el valor de la mecanica de suelos y topografia por vivienda
   * @return el valor de la mecanica de suelos y topografia por vivienda
   */
  public double mecanicaTopoVivienda() {
    double mecanica = 0.0;
    if (numUni != 0) {
      mecanica = mecanicaTopoTotal() / numUni;
      manejador.guardarVariable("pry_mec_sue_top_imp_viv", mecanica);
      return mecanica;
    } else {
      manejador.guardarVariable("pry_mec_sue_top_imp_viv", mecanica);
      return mecanica;
    }
  }

  /**
   * calcula el valor del modulo Proyecto
   * @return el valor del modulo Proyecto
   */
  public double totalProyecto() {
    double total = proyectoArquiTotal() + droFirmasTotal() + calculoEstructuralTotal() + mecanicaTopoTotal();
    manejador.guardarVariable("pry_imp_tot_pro", total);
    return total;
  }

  ///////////Tramites, Licencias y Derechos
  /**
   * calcula el valor de las gestiones vecinales importe total
   * @return el valor de las gestiones vecinales importe total
   */
  public double gestionesVecinalesTotal() {
    double gestiones = (Double) aux.getTraLicDer()[IDL_GES_VEC_TERCEROS_FC] * (Double) aux.getTraLicDer()[IDL_GES_VEC_TERCEROS_MON];
    manejador.guardarVariable("pry_ges_vec_ter_imp_tot", gestiones);
    return gestiones;
  }

  /**
   * calcula el valor de las gestiones vecinales por vivienda
   * @return el valor de las gestiones vecinales por vivienda
   */
  public double gestionesVecinalesVivienda() {
    double gestiones = 0.0;
    if (numUni != 0) {
      gestiones = gestionesVecinalesTotal() / numUni;
      manejador.guardarVariable("pry_ges_vec_ter_imp_viv", gestiones);
      return gestiones;
    } else {
      manejador.guardarVariable("pry_ges_vec_ter_imp_viv", gestiones);
      return gestiones;
    }
  }

  /**
   * calcula el valor de los tramites y licencias importe total
   * @return el valor de los tramites y licencias importe total
   */
  public double tramitesLicenciosTotal() {
    double tramites = (Double) aux.getTraLicDer()[IDL_TRAM_LIC_FC] * (Double) aux.getTraLicDer()[IDL_TRAM_LIC_MON];
    manejador.guardarVariable("pry_tram_lic_imp_tot", tramites);
    return tramites;
  }

  /**
   * calcula el valor de los tramites y licencias por vivienda
   * @return el valor de los tramites y licencias por vivienda
   */
  public double tramitesLicenciosVivienda() {
    double tramites = 0.0;
    if (numUni != 0) {
      tramites = tramitesLicenciosTotal() / numUni;
      manejador.guardarVariable("pry_tram_lic_imp_viv", tramites);
      return tramites;
    } else {
      manejador.guardarVariable("pry_tram_lic_imp_viv", tramites);
      return tramites;
    }
  }

  /**
   * calcula el valor de las consertaciones vecinales importe total
   * @return el valor de las consertaciones vecinales importe total
   */
  public double consertacionesVecinalesTotal() {
    double consertaciones = (Double) aux.getTraLicDer()[IDL_CONS_VEC_FC] * (Double) aux.getTraLicDer()[IDL_CONS_VEC_MON];
    manejador.guardarVariable("pry_con_vec_imp_tot", consertaciones);
    return consertaciones;
  }

  /**
   * calcula el valor de las consertaciones vecinales por vivienda
   * @return el valor de las consertaciones vecinales por vivienda
   */
  public double consertacionesVecinalesVivienda() {
    double consertaciones = 0.0;
    if (numUni != 0) {
      consertaciones = consertacionesVecinalesTotal() / numUni;
      manejador.guardarVariable("pry_con_vec_imp_viv", consertaciones);
      return consertaciones;
    } else {
      manejador.guardarVariable("pry_con_vec_imp_viv", consertaciones);
      return consertaciones;
    }
  }

  /**
   * calcula el valor del pozo de agua importe total
   * @return el valor del pozo de agua importe total
   */
  public double pozoAguaTotal() {
    double pozo = (Double) aux.getTraLicDer()[IDL_POZO_AGUA_FC] * (Double) aux.getTraLicDer()[IDL_POZO_AGUA_MON];
    manejador.guardarVariable("pry_poz_agu_imp_tot", pozo);
    return pozo;
  }

  /**
   * calcula el valor del pozo de agua por vivienda
   * @return el valor del pozo de agua por vivienda
   */
  public double pozoAguaVivienda() {
    double pozo = 0.0;
    if (numUni != 0) {
      pozo = pozoAguaTotal() / numUni;
      manejador.guardarVariable("pry_poz_agu_imp_viv", pozo);
      return pozo;
    } else {
      manejador.guardarVariable("pry_poz_agu_imp_viv", pozo);
      return pozo;
    }
  }

  /**
   * calcula el valor de solicitud presupuesto luz y fuerza importe total
   * @return el valor de solicitud presupuesto luz y fuerza importe total
   */
  public double luzFuerzaTotal() {
    double luz = (Double) aux.getTraLicDer()[IDL_PRE_LUZ_FUE_FC] * (Double) aux.getTraLicDer()[IDL_PRE_LUZ_FUE_MON];
    manejador.guardarVariable("pry_sol_pre_luz_fue_imp_tot", luz);
    return luz;
  }

  /**
   * calcula el valor de solicitud presupuesto luz y fuerza por vivienda
   * @return el valor de solicitud presupuesto luz y fuerza por vivienda
   */
  public double luzFuerzaVivienda() {
    double luz = 0.0;
    if (numUni != 0) {
      luz = luzFuerzaTotal() / numUni;
      manejador.guardarVariable("pry_sol_pre_luz_fue_imp_viv", luz);
      return luz;
    } else {
      manejador.guardarVariable("pry_sol_pre_luz_fue_imp_viv", luz);
      return luz;
    }
  }

  /**
   * calcula el valor de regimen de propiedad de condominio importe total
   * @return el valor de regimen de propiedad de condominio importe total
   */
  public double regimenPropCondTotal() {
    double regimen = (Double) aux.getTraLicDer()[IDL_REG_PROPIEDAD_CON_FC] * (Double) aux.getTraLicDer()[IDL_REG_PROPIEDAD_CON_MON];
    manejador.guardarVariable("pry_reg_pro_con_imp_tot", regimen);
    return regimen;
  }

  /**
   * calcula el valor de regimen de propiedad de condominio por vivienda
   * @return el valor de regimen de propiedad de condominio por vivienda
   */
  public double regimenPropCondVivienda() {
    double regimen = 0.0;
    if (numUni != 0) {
      regimen = regimenPropCondTotal() / numUni;
      manejador.guardarVariable("pry_reg_pro_con_imp_viv", regimen);
      return regimen;
    } else {
      manejador.guardarVariable("pry_reg_pro_con_imp_viv", regimen);
      return regimen;
    }
  }

  /**
   * calcula el valor del modulo Tramites, Licencias y Derechos
   * @return el valor del modulo Tramites, Licencias y Derechos
   */
  public double totalTramitesLicencias() {
    double total = gestionesVecinalesTotal() + tramitesLicenciosTotal() + consertacionesVecinalesTotal()
                 + pozoAguaTotal() + luzFuerzaTotal() + regimenPropCondTotal();
    manejador.guardarVariable("pry_imp_tot_tra_lic_der", total);
    return total;
  }

  ///////////CONSTRUCCION
  /**
   * calcula el valor de edificacion de casas por vivienda
   * @return el valor de edificacion de casas por vivienda
   */
  public double edificacionCasasVivienda() {
    double edi = 0.0;
    if (numUni != 0) {
      edi = (Double) manejador.obtenerVariable("pry_edi_cas_mon") / numUni;
      System.out.println("edificacion monto " + (Double) manejador.obtenerVariable("pry_edi_cas_mon"));
      manejador.guardarVariable("pry_edi_cas_imp_viv", edi);
      return edi;
    } else {
      manejador.guardarVariable("pry_edi_cas_imp_viv", edi);
      return edi;
    }
  }

  /**
   * calcula el valor de urbanizacion por vivienda
   * @return el valor de urbanizacion por vivienda
   */
  public double urbVivienda() {
    double urb = 0.0;
    if (numUni != 0) {
      urb = (Double) manejador.obtenerVariable("pry_urb_mon") / numUni;
      System.out.println("urb mon " + (Double) manejador.obtenerVariable("pry_urb_mon"));
      manejador.guardarVariable("pry_urb_imp_viv", urb);
      return urb;
    } else {
      manejador.guardarVariable("pry_urb_imp_viv", urb);
      return urb;
    }
  }

  /**
   * calcula el valor de urbanizacion de acceso por vivienda
   * @return el valor de urbanizacion de acceso por vivienda
   */
  public double urbAccesoVivienda() {
    double urba = 0.0;
    if (numUni != 0) {
      urba = (Double) manejador.obtenerVariable("pry_urb_acc_mon") / numUni;
      System.out.println("urb acc mon " + (Double) manejador.obtenerVariable("pry_urb_acc_mon"));
      manejador.guardarVariable("pry_urb_acc_imp_viv", urba);
      return urba;
    } else {
      manejador.guardarVariable("pry_urb_acc_imp_viv", urba);
      return urba;
    }
  }

  /**
   * calcula el valor de edificacion de departamento por unidad
   * @return el valor de edificacion de departamento por unidad
   */
  public double ediDepVivienda() {
    double edif = 0.0;
    if (numUni != 0) {
      edif = (Double) manejador.obtenerVariable("pry_edi_depto_mon") / numUni;
      manejador.guardarVariable("pry_edi_dep_imp_viv", edif);
      System.out.println("edi dep mon " + (Double) manejador.obtenerVariable("pry_edi_depto_mon"));
      return edif;
    } else {
      manejador.guardarVariable("pry_edi_dep_imp_viv", edif);
      return edif;
    }
  }

  /**
   * calcula el valor de area exterior por vivienda
   * @return el valor de area exterior por vivienda
   */
  public double areaExtVivienda() {
    double area = 0.0;
    if (numUni != 0) {
      area = (Double) manejador.obtenerVariable("pry_orn_mon") / numUni;
      manejador.guardarVariable("pry_are_ext_imp_viv", area);
      System.out.println("area exterior mon " + (Double) manejador.obtenerVariable("pry_orn_mon"));
      return area;
    } else {
      manejador.guardarVariable("pry_are_ext_imp_viv", area);
      return area;
    }
  }

  /**
   * calcula el valor de gtos gral por vivienda
   * @return el valor de gtos gral por vivienda
   */
  public double gtosGralVivienda() {
    double gtos = 0.0;
    if (numUni != 0) {
      gtos = (Double) manejador.obtenerVariable("pry_gts_gral_mon") / numUni;
      manejador.guardarVariable("pry_gas_gen_imp_viv", gtos);
      System.out.println("gastos generales mon " + (Double) manejador.obtenerVariable("pry_gts_gral_mon"));
      return gtos;
    } else {
      manejador.guardarVariable("pry_gas_gen_imp_viv", gtos);
      return gtos;
    }
  }

  /**
   * calcula el valor de imprevistos por vivienda
   * @return el valor de imprevistos por vivienda
   */
  public double imprevistosVivienda() {
    double gtos = 0.0;
    if (numUni != 0) {
      gtos = (Double) manejador.obtenerVariable("pry_imp_mon") / numUni;
      manejador.guardarVariable("pry_imp_imp_viv", gtos);
      System.out.println("imprevistos mon " + (Double) manejador.obtenerVariable("pry_imp_mon"));
      return gtos;
    } else {
      manejador.guardarVariable("pry_imp_imp_viv", gtos);
      return gtos;
    }
  }

  /**
   * calcula el valor de obligaciones patronales por vivienda
   * @return el valor de obligaciones patronales por vivienda
   */
  public double obliPatVivienda() {
    double obl = 0.0;
    if (numUni != 0) {
      obl = (Double) manejador.obtenerVariable("pry_obl_pat_mon") / numUni;
      System.out.println("obligaciones mon " + (Double) manejador.obtenerVariable("pry_obl_pat_mon"));
      manejador.guardarVariable("pry_obl_pat_imp_viv", obl);
      return obl;
    } else {
      manejador.guardarVariable("pry_obl_pat_imp_viv", obl);
      return obl;
    }
  }

  /**
   * calcula el valor de paquete de acabados por vivienda
   * @return el valor de paquete de acabados por vivienda
   */
  public double paqueteAcabadosVivienda() {
    double paq = 0.0;
    if (numUni != 0) {
      paq = (Double) manejador.obtenerVariable("pry_paq_aca_mon") / numUni;
      System.out.println("paquete acabadoa mon " + (Double) manejador.obtenerVariable("pry_paq_aca_mon"));
      manejador.guardarVariable("pry_paq_aca_imp_viv", paq);
      return paq;
    } else {
      manejador.guardarVariable("pry_paq_aca_imp_viv", paq);
      return paq;
    }
  }

  /**
   * calcula el valor de mantenimiento y vigilancia de escenario por vivienda
   * @return el valor de mantenimiento y vigilancia de escenario por vivienda
   */
  public double mantenimientoVigEscVivienda() {
    double man = 0.0;
    if (numUni != 0) {
      man = (Double) manejador.obtenerVariable("pry_man_vig_esc_mon") / numUni;
      System.out.println("mantenimiento y vigilancia monto " + (Double) manejador.obtenerVariable("pry_man_vig_esc_mon"));
      manejador.guardarVariable("pry_man_vig_esc_imp_viv", man);
      return man;
    } else {
      manejador.guardarVariable("pry_man_vig_esc_imp_viv", man);
      return man;
    }
  }

  /**
   * calcula el valor de supervicion de obra por vivienda
   * @return el valor de supervicion de obra por vivienda
   */
  public double supervicionObraVivienda() {
    double sup = 0.0;
    if (numUni != 0) {
      sup = (Double) manejador.obtenerVariable("pry_sup_obr_mon") / numUni;
      manejador.guardarVariable("pry_sup_obr_imp_viv", sup);
      System.out.println("sup de obra mon " + (Double) manejador.obtenerVariable("pry_sup_obr_mon"));
      return sup;
    } else {
      manejador.guardarVariable("pry_sup_obr_imp_viv", sup);
      return sup;
    }
  }

  /**
   * calcula el valor de infraestructura por vivienda
   * @return el valor de infraestructura por vivienda
   */
  public double infraestructuraVivienda() {
    double inf = 0.0;
    if (numUni != 0) {
      inf = (Double) manejador.obtenerVariable("pry_inf_mon") / numUni;
      manejador.guardarVariable("pry_inf_imp_viv", inf);
      System.out.println("infra monto " + (Double) manejador.obtenerVariable("pry_inf_mon"));
      return inf;
    } else {
      manejador.guardarVariable("pry_inf_imp_viv", inf);
      return inf;
    }
  }

  ///////////VENTAS
  /**
   * calcula el valor de los tramites y licencias importe total
   * @return el valor de los tramites y licencias importe total
   */
  public double comisionVentasTotal() {
    double tramites = (Double) aux.getVentas()[IDV_COMISIONES_VENTA_FC] * valorTotal * 0.01;
    manejador.guardarVariable("pry_com_ven_imp_tot", tramites);
    return tramites;
  }

  /**
   * calcula el valor de los tramites y licencias por vivienda
   * @return el valor de los tramites y licencias por vivienda
   */
  public double comisionVentasVivienda() {
    double com = 0.0;
    if (numUni != 0) {
      com = comisionVentasTotal() / numUni;
      manejador.guardarVariable("pry_com_ven_imp_viv", com);
      return com;
    } else {
      manejador.guardarVariable("pry_com_ven_imp_viv", com);
      return com;
    }
  }

  /**
   * calcula el valor de comision de venta (contrato) importe total
   * @return el valor de comision de venta (contrato) importe total
   */
  public double comisionVenConTotal() {
    double comision = (Double) aux.getVentas()[IDV_COMISION_VENTA_CONTRATO_FC] * comisionVentasTotal() * 0.01;
    manejador.guardarVariable("pry_com_ven_con_imp_tot", comision);
    return comision;
  }

  /**
   * calcula el valor de comision de venta (contrato) por vivienda
   * @return el valor de comision de venta (contrato) por vivienda
   */
  public double comisionVenConVivienda() {
    double com = 0.0;
    if (numUni != 0) {
      com = comisionVenConTotal() / numUni;
      manejador.guardarVariable("pry_com_ven_con_imp_viv", com);
      return com;
    } else {
      manejador.guardarVariable("pry_com_ven_con_imp_viv", com);
      return com;
    }
  }

  /**
   * calcula el valor de comision de venta (titulacion) importe total
   * @return el valor de comision de venta (titulacion) importe total
   */
  public double comisionVenTitTotal() {
    double comision = (Double) aux.getVentas()[IDV_COMISION_VENTA_TITULACION_FC] * comisionVentasTotal() * 0.01;
    manejador.guardarVariable("pry_com_ven_tit_imp_tot", comision);
    return comision;
  }

  /**
   * calcula el valor de comision de venta (titulacion) por vivienda
   * @return el valor de comision de venta (titulacion) por vivienda
   */
  public double comisionVenTitVivienda() {
    double com = 0.0;
    if (numUni != 0) {
      com = comisionVenTitTotal() / numUni;
      manejador.guardarVariable("pry_com_ven_tit_imp_viv", com);
      return com;
    } else {
      manejador.guardarVariable("pry_com_ven_tit_imp_viv", com);
      return com;
    }
  }

  /**
   * calcula el valor publicidad (corporativo) importe total
   * @return el valor publicidad (corporativo) importe total
   */
  public double publicidadCoorpTotal() {
    double publicidad = (Double) aux.getVentas()[IDV_PUBLICIDAD_CORP_FC] * valorTotal * 0.01;
    manejador.guardarVariable("pry_pub_cor_imp_tot", publicidad);
    return publicidad;
  }

  /**
   * calcula el valor publicidad (corporativo) por vivienda
   * @return el valor publicidad (corporativo) por vivienda
   */
  public double publicidadCoorpVivienda() {
    double pub = 0.0;
    if (numUni != 0) {
      pub = publicidadCoorpTotal() / numUni;
      manejador.guardarVariable("pry_pub_cor_imp_viv", pub);
      return pub;
    } else {
      manejador.guardarVariable("pry_pub_cor_imp_viv", pub);
      return pub;
    }
  }

  /**
   * calcula el valor publicidad promocion (UNE) importe total
   * @return el valor publicidad promocion (UNE) importe total
   */
  public double publicidadPromocionTotal() {
    double publicidad = (Double) aux.getVentas()[IDV_PUBLICIDAD_PROMO_FC] * valorTotal * 0.01;
    manejador.guardarVariable("pry_pub_pro_une_imp_tot", publicidad);
    return publicidad;
  }

  /**
   * calcula el valor publicidad (corporativo) por vivienda
   * @return el valor publicidad (corporativo) por vivienda
   */
  public double publicidadPromocionVivienda() {
    double pub = 0.0;
    if (numUni != 0) {
      pub = publicidadPromocionTotal() / numUni;
      manejador.guardarVariable("pry_pub_pro_une_imp_viv", pub);
      return pub;
    } else {
      manejador.guardarVariable("pry_pub_pro_une_imp_viv", pub);
      return pub;
    }
  }

  /**
   * calcula el valor de escenario provisional, manto, vigilanica importe total
   * @return el valor de escenario provisional, manto, vigilanica importe total
   */
  public double escenarioVigilanciaTotal() {
    double escenario = (Double) aux.getVentas()[IDV_ESCENARIO_MANTO_VIGILANCIA_FC] * valorTotal * 0.01;
    manejador.guardarVariable("pry_esc_pro_man_vig_imp_tot", escenario);
    return escenario;
  }

  /**
   * calcula el valor de escenario provisional, manto, vigilanica por vivienda
   * @return el valor de escenario provisional, manto, vigilanica por vivienda
   */
  public double escenarioVigilanciaVivienda() {
    double esc = 0.0;
    if (numUni != 0) {
      esc = escenarioVigilanciaTotal() / numUni;
      manejador.guardarVariable("pry_esc_pro_man_vig_imp_viv", esc);
      return esc;
    } else {
      manejador.guardarVariable("pry_esc_pro_man_vig_imp_viv", esc);
      return esc;
    }
  }

  /**
   * calcula el valor Amueblado y decorado de departamento y oficinas Importe Total
   * @return el valor Amueblado y decorado de departamento y oficinas Importe Total
   */
  public double amuebladoDecoradoTotal() {
    double decorado = (Double) aux.getVentas()[IDV_AMUEBLADO_DECORADO_FC] * valorTotal * 0.01;
    System.out.println("en amueblado total: " + (Double) aux.getVentas()[IDV_AMUEBLADO_DECORADO_FC]);
    manejador.guardarVariable("pry_amu_dec_dep_ofi_imp_tot", decorado);
    return decorado;
  }

  /**
   * calcula el valor Amueblado y decorado de departamento y oficinas por vivienda
   * @return el valor Amueblado y decorado de departamento y oficinas por vivienda
   */
  public double amuebladoDecoradoVivienda() {
    double dec = 0.0;
    if (numUni != 0) {
      dec = amuebladoDecoradoTotal() / numUni;
      manejador.guardarVariable("pry_amu_dec_dep_ofi_imp_viv", dec);
      return dec;
    } else {
      manejador.guardarVariable("pry_amu_dec_dep_ofi_imp_viv", dec);
      return dec;
    }
  }

  /**
   * calcula el valor del modulo Tramites, Licencias y Derechos
   * @return el valor del modulo Tramites, Licencias y Derechos
   */
  public double totalVentas() {
    double total = comisionVentasTotal() + publicidadCoorpTotal() + publicidadPromocionTotal() + escenarioVigilanciaTotal() + amuebladoDecoradoTotal();
    manejador.guardarVariable("pry_imp_tot_ven", total);
    return total;
  }

  ///////////OTROS
  /**
   * calcula el valor amenidades Importe Total
   * @return el valor amenidades Importe Total
   */
  public double amenidadesTotal() {
    double amenidades = (Double) aux.getOtros()[IDO_AMENIDADES_FC] * (Double) aux.getOtros()[IDO_AMENIDADES_MON] * 0.01;
    manejador.guardarVariable("pry_ame_imp_tot", amenidades);
    return amenidades;
  }

  /**
   * calcula el valor amenidades por vivienda
   * @return el valor amenidades por vivienda
   */
  public double amenidadesVivienda() {
    double ame = 0.0;
    if (numUni != 0) {
      ame = amenidadesTotal() / numUni;
      manejador.guardarVariable("pry_ame_imp_viv", ame);
      return ame;
    } else {
      manejador.guardarVariable("pry_ame_imp_viv", ame);
      return ame;
    }
  }

  /**
   * calcula el valor otros 2 Importe Total
   * @return el valor otros 2 Importe Total
   */
  public double otros2Total() {
    double otros = (Double) aux.getOtros()[IDO_OTROS2_FC] * (Double) aux.getOtros()[IDO_OTROS2_MON] * 0.01;
    manejador.guardarVariable("pry_otr_2_imp_tot", otros);
    return otros;
  }

  /**
   * calcula el valor otros 2 por vivienda
   * @return el valor otros 2 por vivienda
   */
  public double otros2Vivienda() {
    double otros = 0.0;
    if (numUni != 0) {
      otros = otros2Total() / numUni;
      manejador.guardarVariable("pry_otr_2_imp_viv", otros);
      return otros;
    } else {
      manejador.guardarVariable("pry_otr_2_imp_viv", otros);
      return otros;
    }
  }

  /**
   * calcula el valor otros 3 Importe Total
   * @return el valor otros 3 Importe Total
   */
  public double otros3Total() {
    double otros = (Double) aux.getOtros()[IDO_OTROS3_FC] * (Double) aux.getOtros()[IDO_OTROS3_MON] * 0.01;
    manejador.guardarVariable("pry_otr_3_imp_tot", otros);
    return otros;
  }

  /**
   * calcula el valor otros 3 por vivienda
   * @return el valor otros 3 por vivienda
   */
  public double otros3Vivienda() {
    double otros = 0.0;
    if (numUni != 0) {
      otros = otros3Total() / numUni;
      manejador.guardarVariable("pry_otr_3_imp_viv", otros);
      return otros;
    } else {
      manejador.guardarVariable("pry_otr_3_imp_viv", otros);
      return otros;
    }
  }

  /**
   * calcula el valor del modulo Otros
   * @return el valor del modulo Otros
   */
  public double totalOtros() {
    double total = amenidadesTotal() + otros2Total() + otros3Total();
    manejador.guardarVariable("pry_imp_tot_otr", total);
    return total;
  }

  
  
  ///////////SOCIOS Y GASTOS DE ADMINISTRACION
  /**
   * calcula el valor Gastos  de Operación y admon. (UNE) Importe Total
   * @return el valor Gastos  de Operación y admon. (UNE) Importe Total
   */
  public double gtosAdmonOpUNETotal() {
    double gtos = (Double) aux.getSocioAdmon()[IDS_GTOS_OP_ADMON_UNE_FC] * valorTotal * 0.01;
    manejador.guardarVariable("pry_gas_ope_adm_une_imp_tot", gtos);
    return gtos;
  }

  /**
   * calcula el valor Gastos  de Operación y admon. (UNE) por vivienda
   * @return el valor Gastos  de Operación y admon. (UNE) por vivienda
   */
  public double gtosAdmonOpUNEVivienda() {
    double gtos = 0.0;
    if (numUni != 0) {
      gtos = gtosAdmonOpUNETotal() / numUni;
      manejador.guardarVariable("pry_gas_ope_adm_une_imp_viv", gtos);
      return gtos;
    } else {
      manejador.guardarVariable("pry_gas_ope_adm_une_imp_viv", gtos);
      return gtos;
    }
  }

  /**
   * calcula el valor Gastos  de Operación y admon. (Coorporativo) Importe Total
   * @return el valor Gastos  de Operación y admon. (Coorporativo) Importe Total
   */
  public double gtosAdmonOpCORTotal() {
    double gtos = (Double) aux.getSocioAdmon()[IDS_GTOS_OP_ADMON_COR_FC] * valorTotal * 0.01;
    manejador.guardarVariable("pry_gas_ope_adm_cor_imp_tot", gtos);
    return gtos;
  }

  /**
   * calcula el valor Gastos  de Operación y admon. (Coorporativo) por vivienda
   * @return el valor Gastos  de Operación y admon. (Coorporativo) por vivienda
   */
  public double gtosAdmonOpCORVivienda() {
    double gtos = 0.0;
    if (numUni != 0) {
      gtos = gtosAdmonOpCORTotal() / numUni;
      manejador.guardarVariable("pry_gas_ope_adm_cor_imp_viv", gtos);
      return gtos;
    } else {
      manejador.guardarVariable("pry_gas_ope_adm_cor_imp_viv", gtos);
      return gtos;
    }
  }

  ///////////CREDITO PUENTE
  /**
   * calcula el valor credito puente solicitado Importe Total
   * @return el valor credito puente solicitado Importe Total
   */
  public double creditoPuenteSolTotal() {
    double cre = (Double) aux.getCreditoPuente()[IDC_CREDI_PUENTE_PORCENTAJE] * (Double) manejador.obtenerVariable("pry_ing_tot_val_ven") * 0.01;
    //System.out.println("(Double) manejador.obtenerVariable(pry_ing_tot_val_ven) " + (Double) manejador.obtenerVariable("pry_ing_tot_val_ven"));
    manejador.guardarVariable("pry_cre_pue_sol_imp_tot", cre);
    return cre;
  }

  /**
   * calcula el valor credito puente solicitado por vivienda
   * @return el valor credito puente solicitado por vivienda
   */
  public double creditoPuenteSolVivienda() {
    double cre = 0.0;
    if (numUni != 0) {
      cre = creditoPuenteSolTotal() / numUni;
      manejador.guardarVariable("pry_cre_pue_sol_imp_viv", cre);
      return cre;
    } else {
      manejador.guardarVariable("pry_cre_pue_sol_imp_viv", cre);
      return cre;
    }
  }

  /**
   * calcula el valor apertura de credito puente Importe Total
   * @return el valor apertura de credito puente Importe Total
   */
  public double aperturaCreditoPuenteTotal() {
    double ape = (Double) aux.getCreditoPuente()[IDC_APERTURA_CREDI_PUENTE_PORCENTAJE] * creditoPuenteSolTotal() * 0.01;
    manejador.guardarVariable("pry_ape_cre_imp_tot", ape);
    return ape;
  }

  /**
   * calcula el valor apertura credito puente solicitado por vivienda
   * @return el valor apertura credito puente solicitado por vivienda
   */
  public double aperturaCreditoPuenteVivienda() {
    double ape = 0.0;
    if (numUni != 0) {
      ape = aperturaCreditoPuenteTotal() / numUni;
      manejador.guardarVariable("pry_ape_cre_imp_viv", ape);
      return ape;
    } else {
      manejador.guardarVariable("pry_ape_cre_imp_viv", ape);
      return ape;
    }
  }

  /**
   * calcula el valor Seguros de Fianzas Notariales, Gastos notariales Importe Total
   * @return el valor Seguros de Fianzas Notariales, Gastos notariales Importe Total
   */
  public double segurosFianzasGtosTotal() {
    double seg = (Double) aux.getCreditoPuente()[IDC_SEGUROS_FINANZAS_PORCENTAJE] * creditoPuenteSolTotal() * 0.01;
    manejador.guardarVariable("pry_seg_fia_gas_not_imp_tot", seg);
    return seg;
  }

  /**
   * calcula el valor Seguros de Fianzas Notariales, Gastos notariales por vivienda
   * @return el valor Seguros de Fianzas Notariales, Gastos notariales por vivienda
   */
  public double segurosFianzasGtosVivienda() {
    double seg = 0.0;
    if (numUni != 0) {
      seg = segurosFianzasGtosTotal() / numUni;
      manejador.guardarVariable("pry_seg_fia_gas_not_imp_viv", seg);
      return seg;
    } else {
      manejador.guardarVariable("pry_seg_fia_gas_not_imp_viv", seg);
      return seg;
    }
  }

  /**
   * calcula el valor supervicion de obra y admon. de recursos Importe Total
   * @return el valor supervicion de obra y admon. de recursos Importe Total
   */
  public double supervicionObrAdmonRecTotal() {
    double sup = (Double) aux.getCreditoPuente()[IDC_SUP_OBRAS_PORCENTAJE] * creditoPuenteSolTotal() * 0.01;
    manejador.guardarVariable("pry_sup_obr_adm_rec_imp_tot", sup);
    return sup;
  }

  /**
   * calcula el valor supervicion de obra y admon. de recursos por vivienda
   * @return el valor supervicion de obra y admon. de recursos por vivienda
   */
  public double supervicionObrAdmonRecVivienda() {
    double sup = 0.0;
    if (numUni != 0) {
      sup = supervicionObrAdmonRecTotal() / numUni;
      manejador.guardarVariable("pry_sup_obr_adm_rec_imp_viv", sup);
      return sup;
    } else {
      manejador.guardarVariable("pry_sup_obr_adm_rec_imp_viv", sup);
      return sup;
    }
  }

  ///////////Anticipo
  /**
   * calcula el arreglo de monto por etapa de anticipos, disposicion y amortizacion de credito puente
   * @return el arreglo de monto por etapa de anticipos, disposicion y amortizacion de credito puente
   */
  private LinkedList<Double> anticipoMontoDispoRecuAmor() {
    LinkedList<Double> arr = new LinkedList<Double>();
    for (int i = 0; i < numEtapas; i++) {
      arr.add((creditoPuenteSolTotal() / numUni) * (Double)unidadesXEtapa[i]);
      System.out.println("en anticipoMontoDispoRecuAmor: (creditoPuenteSolTotal() / numUni) * (Double)unidadesXEtapa[i]: " + (creditoPuenteSolTotal() / numUni) * (Double)unidadesXEtapa[i]);
    }
    return arr;
  }

  /**
   * calcula el Anticipo Crédito Solicitado Importe Total
   * @return el Anticipo Crédito Solicitado Importe Total
   */
  public double anticipoCreditoPuenteTotal() {
    double ant = creditoPuenteSolTotal() * aux.getAnticipo()[IDA_ANTICIPO_CREDI_PUENTE_FC] * 0.01;
    System.out.println(" aux.getAnticipo()[IDA_ANTICIPO_CREDI_PUENTE_FC]: " + aux.getAnticipo()[IDA_ANTICIPO_CREDI_PUENTE_FC]);
    System.out.println(" creditoPuenteSolTotal(): " + creditoPuenteSolTotal());
    manejador.guardarVariable("pry_ant_cre_sol_imp_tot", ant);
    return ant;
  }

  /**
   * calcula el Anticipo Crédito Solicitado Importe Total por etapa
   * @return el Anticipo Crédito Solicitado Importe Total por atapa
   */
  public LinkedList<Double> anticipoCreditoPuenteEtapa() {
    LinkedList<Double> arrAnt = new LinkedList<Double>();
    for (int i = 0; i < numEtapas; i++) {
      arrAnt.add(aux.getAnticipo()[IDA_ANTICIPO_CREDI_PUENTE_FC] * anticipoMontoDispoRecuAmor().get(i) * 0.01);
    }
    manejador.guardarVariable("pry_ant_eta_imp_tot", arrAnt);
    return arrAnt;
  }

  /**
   * calcula el Disposición de Recursos Crédito Solicitado Importe Total
   * @return el Disposición de Recursos Crédito Solicitado Importe Total
   */
  public double disposicionRecCreditoPuenteTotal() {
    double dis = creditoPuenteSolTotal() * aux.getAnticipo()[IDA_DISPOSICION_RECURSOS_FC] * 0.01;
    manejador.guardarVariable("pry_dis_rec_cre_sol_imp_tot", dis);
    return dis;
  }

  /**
   * calcula el Disposición de Recursos Crédito Solicitado Importe Total por etapa
   * @return el Disposición de Recursos Crédito Solicitado Importe Total por atapa
   */
  public LinkedList<Double> disposicionRecCreditoPuenteEtapa() {
    LinkedList<Double> arrDis = new LinkedList<Double>();
    for (int i = 0; i < numEtapas; i++) {
      arrDis.add(aux.getAnticipo()[IDA_DISPOSICION_RECURSOS_FC] * anticipoMontoDispoRecuAmor().get(i) * 0.01);
    }
    manejador.guardarVariable("pry_dis_rec_eta_imp_tot", arrDis);
    return arrDis;
  }

  /**
   * calcula la Amortización del Crédito / Crédito Solicitado Etapa Importe Total
   * @return la Amortización del Crédito / Crédito Solicitado Etapa Importe Total
   */
  public double amortizacionCreditoPuenteTotal() {
    double amor = creditoPuenteSolTotal() * aux.getAnticipo()[IDA_AMORTIZACION_CREDITO_FC] * 0.01;
    manejador.guardarVariable("pry_amo_cre_cre_sol_imp_tot", amor);
    return amor;
  }

  /**
   * calcula la Amortización del Crédito / Crédito Solicitado Etapa Importe Total por etapa
   * @return la Amortización del Crédito / Crédito Solicitado Etapa Importe Total por atapa
   */
  public LinkedList<Double> amortizacionCreditoPuenteEtapa() {
    LinkedList<Double> arrAmor = new LinkedList<Double>();
    for (int i = 0; i < numEtapas; i++) {
      arrAmor.add(aux.getAnticipo()[IDA_AMORTIZACION_CREDITO_FC] * anticipoMontoDispoRecuAmor().get(i) * 0.01);
    }
    manejador.guardarVariable("pry_amo_cre_eta_imp_tot", arrAmor);
    return arrAmor;
  }

  /**
   * calcula el valor anticipo credito puente solicitado por vivienda
   * @return el valor anticipo credito puente solicitado por vivienda
   */
  public double anticipoCreditoPuenteVivienda() {
    double ant = 0.0;
    if (numUni != 0) {
      ant = anticipoCreditoPuenteTotal() / numUni;
      manejador.guardarVariable("pry_ant_cre_sol_imp_viv", ant);
      return ant;
    } else {
      manejador.guardarVariable("pry_ant_cre_sol_imp_viv", ant);
      return ant;
    }
  }

  /**
   * calcula el Disposición de Recursos Crédito Solicitado por vivienda
   * @return el Disposición de Recursos Crédito Solicitado por vivienda
   */
  public double disposicionRecCreditoPuenteVivienda() {
    double dis = 0.0;
    if (numUni != 0) {
      dis = disposicionRecCreditoPuenteTotal() / numUni;
      manejador.guardarVariable("pry_dis_rec_cre_sol_imp_viv", dis);
      return dis;
    } else {
      manejador.guardarVariable("pry_dis_rec_cre_sol_imp_viv", dis);
      return dis;
    }
  }

  /**
   * calcula la Amortización del Crédito / Crédito Solicitado Etapa por vivienda
   * @return la Amortización del Crédito / Crédito Solicitado Etapa por vivienda
   */
  public double amortizacionCreditoPuenteVivienda() {
    double amor = 0.0;
    if (numUni != 0) {
      amor = amortizacionCreditoPuenteTotal() / numUni;
      manejador.guardarVariable("pry_amo_cre_cre_sol_imp_viv", amor);
      return amor;
    } else {
      manejador.guardarVariable("pry_amo_cre_cre_sol_imp_viv", amor);
      return amor;
    }
  }

  //FIN =D=D=D=D=D
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

    /**
     * EMPIEZA INFOBASICA
     */
    System.out.println("\n\n\n\ninicializamos las prubas de infobasica");
    InformacionBasica info = new InformacionBasica(m);
    
    info.obtenerValorTotalTerreno();
    info.obtenerEdificacionCasasTotal();
    info.obtenerUrbanizacionTotal();
    info.obtenerUrbanizacionAccesoTotal();
    info.obtenerEdificacionDepartamentosTotal();
    info.obtenerOrnatoTotal();
    info.obtenerGastosGeneralesTotal();
    info.obtenerImprevistosTotal();
    info.obtenerObligacionesPatronalesTotal();
    info.obtenerPaquetesAcabadosTotal();
    info.obtenerMantenimientoVigilanciaTotal();
    info.obtenerSupervisionObraTotal();
    info.obtenerInfraestructuraTotal();
    info.obtenerValorTotalConstrucciones();
    info.obtenerCostoTotalConstruccion();
    //info.obtenerPorcentajePagoTerreno();
    
    /**
     * EMPIEZA GENERADORES
     */
    System.out.println("\n\n\n\nEmpieza Generadores");
    Generadores generadores = new Generadores(m);

    
    //////empieza el modulo de terrenos y escrituras
    System.out.println("\n\nMODULO DE TERRENOS Y ESCRITURAS");

    System.out.println("\ncalcula el valor de compra del terreno por vivienda - valorCompraTerrenoVivienda()");
    auxiliar = generadores.valorCompraTerrenoVivienda();
    System.out.println("valor de compre de terreno por vivienda: " + auxiliar);

    System.out.println("\ncalcula el valor total del predial, agua, areas comunes importe total");
    auxiliar = generadores.predialAguaTotal();
    System.out.println("valor de predial, agua etc. total: "+ auxiliar);
    
    System.out.println("\ncalcula el valor del predial, agua, areas comunes por vivienda");
    auxiliar = generadores.predialAguaVivienda();
    System.out.println("valor de predial y agua por vivienda: "+ auxiliar);
    
    System.out.println("\nvalor de las escrituras, avaluo, isr, terreno importe total");
    auxiliar = generadores.escriturasAvaluoTotal();
    System.out.println("valor de escrituras total: " + auxiliar);
    
    System.out.println("\nvalor de las escrituras, avaluo, isr, terreno importe vivienda");
    auxiliar = generadores.escriturasAvaluoVivienda();
    System.out.println("valor de escrituras por viviendas: " + auxiliar);
    
    System.out.println("\ncalcula el valor de la admon del fideicomiso por vivienda (este se calcula solo la vivienda)");
    auxiliar = generadores.admonFideicomisoVivienda();
    System.out.println("valor de admon fide vivienda" + auxiliar);
    
    System.out.println("\ncalcula valor total del modulo de Terreno y Escrituras");
    auxiliar = generadores.totalTerrenoEscrituras();
    System.out.println("valor de modulo Terreno Escrituras" + auxiliar);
    
    
    //////empieza el modulo de proyecto
    System.out.println("\n\nMODULO DE PROYECTO");
    
    System.out.println("\ncalcula el valor de el proyecto arquitectonico importe total");
    auxiliar = generadores.proyectoArquiTotal();
    System.out.println("proyecto arquitectonico total: " + auxiliar);
    
    System.out.println("\ncalcula el valor de el proyecto arquitectonico importe vivienda");
    auxiliar = generadores.proyectoArquiVivienda();
    System.out.println("proyecto arquitectonico vivienda: " + auxiliar);
    
    System.out.println("\ncalcula el valor de las firmas y dro importe total");
    auxiliar = generadores.droFirmasTotal();
    System.out.println("dros y firmas totales " + auxiliar);
    
    System.out.println("\ncalcula el valor de las firmas y dro importe vivienda");
    auxiliar = generadores.droFirmasViviendas();
    System.out.println("dros y firmas vivienda " + auxiliar);
    
    System.out.println("\ncalcula el valor del calculo estructural importe total");
    auxiliar = generadores.calculoEstructuralTotal();
    System.out.println("calculo estructural total " + auxiliar);
    
    System.out.println("\ncalcula el valor del calculo estructural importe vivienda");
    auxiliar = generadores.calculoEstructuralVivienda();
    System.out.println("calculo estructural viviendas " + auxiliar);
    
    System.out.println("\ncalcula el valor de la mecanica de suelos y topografia importe total");
    auxiliar = generadores.mecanicaTopoTotal();
    System.out.println("mecanica de suelos y topo total " + auxiliar);

    System.out.println("\ncalcula el valor de la mecanica de suelos y topografia importe vivienda");
    auxiliar = generadores.mecanicaTopoVivienda();
    System.out.println("mecanica de suelos y topo vivienda " + auxiliar);
    
    System.out.println("\ncalcula el valor del modulo Proyecto");
    auxiliar = generadores.totalProyecto();
    System.out.println("modulo proyecto " + auxiliar);
    
    
    //////empieza el modulo de tramites
    System.out.println("\n\nMODULO DE Tramites, Licencias y Derechos");
    
    System.out.println("\ncalcula el valor de las gestiones vecinales importe total");
    auxiliar = generadores.gestionesVecinalesTotal();
    System.out.println("gestiones vecinales total " + auxiliar);
    
    System.out.println("\ncalcula el valor de las gestiones vecinales importe vivienda");
    auxiliar = generadores.gestionesVecinalesVivienda();
    System.out.println("gestiones vecinales vivienda " + auxiliar);
    
    System.out.println("\ncalcula el valor de los tramites y licencias importe total");
    auxiliar = generadores.tramitesLicenciosTotal();
    System.out.println("tramites y licenias total " + auxiliar);
    
    System.out.println("\ncalcula el valor de los tramites y licencias importe vivienda");
    auxiliar = generadores.tramitesLicenciosVivienda();
    System.out.println("tramites y licenias vivienda " + auxiliar);
    
    System.out.println("\ncalcula el valor de las consertaciones vecinales importe total");
    auxiliar = generadores.consertacionesVecinalesTotal();
    System.out.println("consertaciones vecinales total " + auxiliar);
    
    System.out.println("\ncalcula el valor de las consertaciones vecinales importe viviendas");
    auxiliar = generadores.consertacionesVecinalesVivienda();
    System.out.println("consertaciones vecinales vivienda " + auxiliar);
    
    System.out.println("\ncalcula el valor del pozo de agua importe total");
    auxiliar = generadores.pozoAguaTotal();
    System.out.println("pozo total " + auxiliar);
    
    System.out.println("\ncalcula el valor del pozo de agua importe vivienda");
    auxiliar = generadores.pozoAguaVivienda();
    System.out.println("pozo vivienda  " + auxiliar);
    
    System.out.println("\ncalcula el valor de solicitud presupuesto luz y fuerza importe total");
    auxiliar = generadores.luzFuerzaTotal();
    System.out.println("luz y fuerza total " + auxiliar);
    
    System.out.println("\ncalcula el valor de solicitud presupuesto luz y fuerza importe vivieda");
    auxiliar = generadores.luzFuerzaVivienda();
    System.out.println("luz y fuerza vivienda " + auxiliar);
    
    System.out.println("\ncalcula el valor de regimen de propiedad de condominio importe total");
    auxiliar = generadores.regimenPropCondTotal();
    System.out.println("regimen de propiedades total " + auxiliar);
    
    System.out.println("\ncalcula el valor de regimen de propiedad de condominio importe vivienda");
    auxiliar = generadores.regimenPropCondVivienda();
    System.out.println("regimen de propiedades vivienda " + auxiliar);
  
    System.out.println("\ncalcula el valor del modulo Tramites, Licencias y Derechos");
    auxiliar = generadores.totalTramitesLicencias();
    System.out.println("total de modulo tramites, licencias y derechos " + auxiliar);
    
    
    
    //////empieza el modulo de construccion
    System.out.println("\n\nMODULO DE CONSTRUCCION");
    
    System.out.println("\ncalcula el valor de edificacion de casas por vivienda");
    auxiliar = generadores.edificacionCasasVivienda();
    System.out.println("valor edif viv " + auxiliar);
    
    System.out.println("\ncalcula el valor de urbanizacion por vivienda");
    auxiliar = generadores.urbVivienda();
    System.out.println("urbanizacion viv " + auxiliar);
    
    System.out.println("\ncalcula el valor de urbanizacion acceso por vivienda");
    auxiliar = generadores.urbAccesoVivienda();
    System.out.println("urbanizacion acceso viv " + auxiliar);
    
    //probado
    System.out.println("\ncalcula el valor de edificacion de departamento por unidad");
    auxiliar = generadores.ediDepVivienda();
    System.out.println("edifi depto viv " + auxiliar);
    
    System.out.println("\ncalcula el valor de area exterior por vivienda");
    auxiliar = generadores.areaExtVivienda();
    System.out.println("area exterior viv " + auxiliar);
    
    System.out.println("\ncalcula el valor de gtos gral por vivienda");
    auxiliar = generadores.gtosGralVivienda();
    System.out.println("gtos gral viv " + auxiliar);
    
    /////probado
    System.out.println("\ncalcula el valor de imprevistos por vivienda");
    auxiliar = generadores.imprevistosVivienda();
    System.out.println("imprevistos " + auxiliar);
    
    System.out.println("\ncalcula el valor de obligaciones patronales por vivienda");
    auxiliar = generadores.obliPatVivienda();
    System.out.println("obligaciones pat viv " + auxiliar);
    
    System.out.println("\ncalcula el valor de paquete de acabados por vivienda");
    auxiliar = generadores.paqueteAcabadosVivienda();
    System.out.println("paquete vivienda " + auxiliar);
    
    //////probado
    System.out.println("\ncalcula el valor de mantenimiento y vigilancia de escenario por vivienda");
    auxiliar = generadores.mantenimientoVigEscVivienda();
    System.out.println("matenimiento y vig por vivienda " + auxiliar);
    
    System.out.println("\ncalcula el valor de supervicion de obra por vivienda");
    auxiliar = generadores.supervicionObraVivienda();
    System.out.println("supervicion de obras vivienda " + auxiliar);
    
    System.out.println("\ncalcula el valor de infraestructura por vivienda");
    auxiliar = generadores.infraestructuraVivienda();
    System.out.println("infraestructura viv " + auxiliar);
    
    //////probado
    
    ////////EMPIEZA MODULO DE VENTAS
    System.out.println("\n\nMODULO DE VENTAS");
    
    System.out.println("\ncalcula el valor de los tramites y licencias importe total - comisionVentasTotal()");
    auxiliar = generadores.comisionVentasTotal();
    System.out.println("valor de los tramites total: " + auxiliar);
    
    System.out.println("\ncalcula el valor de los tramites y licencias importe vivienda - comisionVentasVivienda()");
    auxiliar = generadores.comisionVentasVivienda();
    System.out.println("valor de los tramites viv: " + auxiliar);
    
    System.out.println("\ncalcula el valor de comision de venta (contrato) importe total - comisionVenConTotal()");
    auxiliar = generadores.comisionVenConTotal();
    System.out.println("comision de venta (contrato) total: " + auxiliar);
    
    System.out.println("\ncalcula el valor de comision de venta (contrato) importe vivienda - comisionVenConVivienda()");
    auxiliar = generadores.comisionVenConVivienda();
    System.out.println("comision de venta (contrato) vivienda: " + auxiliar);
    
    System.out.println("\ncalcula el valor de comision de venta (titulacion) importe total - comisionVenTitTotal()");
    auxiliar = generadores.comisionVenTitTotal();
    System.out.println("comision de venta (titulacion) total: " + auxiliar);
    
    System.out.println("\ncalcula el valor de comision de venta (titulacion) importe vivienda - comisionVenTitVivienda()");
    auxiliar = generadores.comisionVenTitVivienda();
    System.out.println("comision de venta (titulacion) vivienda: " + auxiliar);
    
    System.out.println("\ncalcula el valor publicidad (corporativo) importe total - publicidadCoorpTotal()");
    auxiliar = generadores.publicidadCoorpTotal();
    System.out.println("publicidad corporativo total: " + auxiliar);
    
    System.out.println("\ncalcula el valor publicidad (corporativo) importe vivienda - publicidadCoorpVivienda()");
    auxiliar = generadores.publicidadCoorpVivienda();
    System.out.println("publicidad corporativo total: " + auxiliar);
    
    System.out.println("\ncalcula el valor publicidad promocion (UNE) importe total - publicidadPromocionTotal()");
    auxiliar = generadores.publicidadPromocionTotal();
    System.out.println("publicidad UNE total: " + auxiliar);
    
    System.out.println("\ncalcula el valor publicidad promocion (UNE) importe vivienda - publicidadPromocionVivienda()");
    auxiliar = generadores.publicidadPromocionVivienda();
    System.out.println("publicidad UNE total: " + auxiliar);
    
    System.out.println("\ncalcula el valor de escenario provisional, manto, vigilanica importe total - escenarioVigilanciaTotal()");
    auxiliar = generadores.escenarioVigilanciaTotal();
    System.out.println("escenario provicional, vigilancia total: " + auxiliar);
    
    System.out.println("\ncalcula el valor de escenario provisional, manto, vigilanica por vivienda - escenarioVigilanciaVivienda()");
    auxiliar = generadores.escenarioVigilanciaVivienda();
    System.out.println("escenario provicional, vigilancia vivienda: " + auxiliar);
    
    System.out.println("\ncalcula el valor Amueblado y decorado de departamento y oficinas Importe Total - amuebladoDecoradoTotal()");
    auxiliar = generadores.amuebladoDecoradoTotal();
    System.out.println("amueblado y decorado total: " + auxiliar);
    
    System.out.println("\ncalcula el valor Amueblado y decorado de departamento y oficinas Importe vivienda - amuebladoDecoradoVivienda()");
    auxiliar = generadores.amuebladoDecoradoVivienda();
    System.out.println("amueblado y decorado vivienda: " + auxiliar);
    
    System.out.println("\ncalcula el valor del modulo Tramites, Licencias y Derechos - totalVentas()");
    auxiliar = generadores.totalVentas();
    System.out.println("modulo de tramites y licencias total: " + auxiliar);
    
    
    //////empieza el modulo de otros
    System.out.println("\n\nMODULO DE OTROS");
    
    System.out.println("\ncalcula el valor de amenidades importe total - amenidadesTotal()");
    auxiliar = generadores.amenidadesTotal();
    System.out.println("amenidades total: " + auxiliar);
    
    System.out.println("\ncalcula el valor de amenidades importe vivienda - amenidadesVivienda()");
    auxiliar = generadores.amenidadesVivienda();
    System.out.println("amenidades total: " + auxiliar);
    
    System.out.println("\ncalcula el valor de otros2 importe total - otros2Total()");
    auxiliar = generadores.otros2Total();
    System.out.println("amenidades total: " + auxiliar);
    
    System.out.println("\ncalcula el valor de otros2 importe vivienda - otros2Vivienda()");
    auxiliar = generadores.otros2Vivienda();
    System.out.println("amenidades total: " + auxiliar);
    
    System.out.println("\ncalcula el valor de otros3 importe total - otros3Total()");
    auxiliar = generadores.otros3Total();
    System.out.println("amenidades total: " + auxiliar);
    
    System.out.println("\ncalcula el valor de otros3 importe vivienda - otros3Vivienda()");
    auxiliar = generadores.otros3Vivienda();
    System.out.println("amenidades total: " + auxiliar);
    
    System.out.println("\ncalcula el valor del modulo Otros - totalOtros()");
    auxiliar = generadores.totalOtros();
    System.out.println("total modulo otros: " + auxiliar);
    
    
    //////empieza el modulo de socios y gastos de admon.
    System.out.println("\n\nMODULO DE SOCIOS Y GASTOS DE ADMON");
    
    System.out.println("\ncalcula el valor Gastos  de Operación y admon. (Coorporativo) Importe Total - gtosAdmonOpCORTotal()");
    auxiliar = generadores.gtosAdmonOpCORTotal();
    System.out.println("gastos de operacion y admon (coorporativo) total: " + auxiliar);
    
    System.out.println("\ncalcula el valor Gastos  de Operación y admon. (Coorporativo) Importe vivienda - gtosAdmonOpCORVivienda()");
    auxiliar = generadores.gtosAdmonOpCORVivienda();
    System.out.println("gastos de operacion y admon (coorporativo) vivienda: " + auxiliar);
    
    System.out.println("\ncalcula el valor Gastos  de Operación y admon. (UNE) Importe Total - gtosAdmonOpUNETotal()");
    auxiliar = generadores.gtosAdmonOpUNETotal();
    System.out.println("gastos de operacion y admon (UNE) total: " + auxiliar);
    
    System.out.println("\ncalcula el valor Gastos  de Operación y admon. (UNE) Importe vivienda - gtosAdmonOpUNEVivienda()");
    auxiliar = generadores.gtosAdmonOpUNEVivienda();
    System.out.println("gastos de operacion y admon (UNE) vivienda: " + auxiliar);
  
    
    //////empieza el modulo de credito puente
    System.out.println("\n\nMODULO DE CREDITO PUENTE");
    
    System.out.println("\ncalcula el valor credito puente solicitado Importe Total - creditoPuenteSolTotal()");
    auxiliar = generadores.creditoPuenteSolTotal();
    System.out.println("credito puente sol total: " + auxiliar);
    
    System.out.println("\ncalcula el valor credito puente solicitado Importe vivienda - creditoPuenteSolVivienda()");
    auxiliar = generadores.creditoPuenteSolVivienda();
    System.out.println("credito puente sol vivienda: " + auxiliar);
    
    System.out.println("\ncalcula el valor apertura de credito puente Importe Total - aperturaCreditoPuenteSolTotal()");
    auxiliar = generadores.aperturaCreditoPuenteTotal();
    System.out.println("apertura credito puente total: " + auxiliar);
    
    System.out.println("\ncalcula el valor apertura de credito puente Importe Total - aperturaCreditoPuenteSolVivienda()");
    auxiliar = generadores.aperturaCreditoPuenteVivienda();
    System.out.println("apertura credito puente vivienda: " + auxiliar);
    
    System.out.println("\ncalcula el valor Seguros de Fianzas Notariales, Gastos notariales Importe Total");
    auxiliar = generadores.segurosFianzasGtosTotal();
    System.out.println("seguros y gastos total: " + auxiliar);
    
    System.out.println("\ncalcula el valor Seguros de Fianzas Notariales, Gastos notariales Importe vivienda");
    auxiliar = generadores.segurosFianzasGtosVivienda();
    System.out.println("seguros y gastos vivienda: " + auxiliar);
    
    System.out.println("\ncalcula el valor supervicion de obra y admon. de recursos Importe Total");
    auxiliar = generadores.supervicionObrAdmonRecTotal();
    System.out.println("supervicion de obra y admon total: " + auxiliar);
    
    System.out.println("\ncalcula el valor supervicion de obra y admon. de recursos Importe vivienda");
    auxiliar = generadores.supervicionObrAdmonRecVivienda();
    System.out.println("supervicion de obra y admon vivienda: " + auxiliar);
    
    
    
    //////empieza el modulo de anticipo
    System.out.println("\n\nMODULO DE ANTICIPO");
    
    System.out.println("\ncalcula el Anticipo Crédito Solicitado Importe Total");
    auxiliar = generadores.anticipoCreditoPuenteTotal();
    System.out.println("anticipo cred. puente total: " + auxiliar);
    
    System.out.println("\ncalcula el Anticipo Crédito Solicitado Importe Total por etapa");
    aux = generadores.anticipoCreditoPuenteEtapa();
    for(Double d: aux)
    {
      System.out.println("anticipo cred. solicitado por etapa: " + d);
    }
    
    System.out.println("\ncalcula el Disposición de Recursos Crédito Solicitado Importe Total");
    auxiliar = generadores.disposicionRecCreditoPuenteTotal();
    System.out.println("disposicion de recursos credito total: " + auxiliar);
    
    System.out.println("\ncalcula el Disposición de Recursos Crédito Solicitado Importe Total por etapa");
    aux = generadores.disposicionRecCreditoPuenteEtapa();
    for(Double d: aux)
    {
      System.out.println("disposicion de recursos por etapa: " + d);
    }
    
    System.out.println("\ncalcula la Amortización del Crédito / Crédito Solicitado Etapa Importe Total");
    auxiliar = generadores.amortizacionCreditoPuenteTotal();
    System.out.println("amortizacion de credito total: " + auxiliar);
    
    System.out.println("\ncalcula la Amortización del Crédito / Crédito Solicitado Etapa Importe Total por etapa");
    aux = generadores.amortizacionCreditoPuenteEtapa();
    for(Double d: aux)
    {
      System.out.println("amortizacion de cred. por etapa: " + d);
    }
    
    System.out.println("\ncalcula el Anticipo Crédito Solicitado Importe vivienda");
    auxiliar = generadores.anticipoCreditoPuenteVivienda();
    System.out.println("anticipo cred. puente vivienda: " + auxiliar);
    
    System.out.println("\ncalcula el Disposición de Recursos Crédito Solicitado Importe vivienda");
    auxiliar = generadores.disposicionRecCreditoPuenteVivienda();
    System.out.println("disposicion de recursos credito total: " + auxiliar);
    
    System.out.println("\ncalcula la Amortización del Crédito / Crédito Solicitado Etapa Importe vivienda");
    auxiliar = generadores.amortizacionCreditoPuenteVivienda();
    System.out.println("amortizacion de credito vivienda: " + auxiliar);
  }
}

