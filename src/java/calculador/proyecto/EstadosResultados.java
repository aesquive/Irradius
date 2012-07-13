/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculador.proyecto;

import base.Dao;
import java.util.LinkedList;
import util.Funciones;
import variables.ManejadorVariablesProyectos;

/**
 *
 * @author daniel
 */
public class EstadosResultados {

  ManejadorVariablesProyectos manejador;
  private Double numUni;
  private double ingresoTotal;
  private double costosGastosTotales;

  public EstadosResultados(ManejadorVariablesProyectos manejador) {
    this.manejador = manejador;
    consigueNumUni();
    consigueIngresoTotal();
  }

  /**
   * ejecuta el todos lo metodos de EstadoResultados
   */
  public void procesar() {
    traLicDerProyTotal();
    traLicDerProyVivienda();
    valProyectoArqCalcTotal();
    valProyectoArqCalcVivienda();
    costosVentasViviendas();
    costosVentasTotal();
    compraTerrenoPor();
    predialAguaAreasPor();
    escriturasAvaluoFidPor();
    admonFidePor();
    valProyectoArqCalcTotalPor();
    drosFirmaPor();
    traLicDerProyTotalPor();
    consertacionesVecTotalPor();
    pozoAguaTotalPor();
    gestionesVecinalesTotalPor();
    valorEdificTotalPor();
    urbanizacionTotalPor();
    urbanizacionAccTotalPor();
    edificacionTotalPor();
    ornatoTotalPor();
    gastosGralTotalPor();
    imprevistosTotalPor();
    obligPatronalesTotalPor();
    paqueteAcabadosTotalPor();
    mantenimientoVigilanciaEscTotalPor();
    infraestructuraTotalPor();
    amenidadesTotalPor();
    otros2TotalPor();
    otros3TotalPor();
    costosVentasTotalPor();
    utilidadBrutaVivienda();
    utilidadBrutaTotal();
    utilidadBrutaTotalPor();
    gastosVentasVivienda();
    gastosVentasTotal();
    comisionVenConTotalPor();
    comisionVenTitTotalPor();
    publicidadCorTotalPor();
    publicidadUNETotalPor();
    escenarioProvVigTotalPor();
    amuebladoTotalPor();
    gastosVentasTotalPor();
    gastosAdmonVivienda();
    gastosAdmonTotal();
    gastosAdmonUNETotalPor();
    gastosAdmonCorTotalPor();
    gastosAdmonOperacionTotalPor();
    utilidadFinancierosVivienda();
    utilidadFinancierosTotal();
    utilidadFinancierosTotalPor();
    aperturaCreditoSeguroFianzasTotal();
    cadenasProductivasVivienda();
    aperturaCreditoSeguroFianzasVivienda();
    interesesCreditoVivienda();
    gastosFinancierosVivienda();
    gastosFinancierosTotal();
    cadenasProductivasTotalPor();
    aperturaCreditoSeguroFianzasTotalPor();
    interesesCreditoTotalPor();
    gastosFinancierosTotalPor();
    utilidadImpuestosVivienda();
    utilidadImpuestosTotal();
    utilidadImpuestosTotalPor();
    costosGastosTotales();
    compraTerrenoPorCosto();
    predialAguaAreasPorCosto();
    escriturasAvaluoFidPorCosto();
    admonFidePorCosto();
    valProyectoArqCalcTotalPorCosto();
    drosFirmaPorCosto();
    traLicDerProyTotalPorCosto();
    consertacionesVecTotalPorCosto();
    pozoAguaTotalPorCosto();
    gestionesVecinalesTotalPorCosto();
    valorEdificTotalPorCosto();
    urbanizacionTotalPorCosto();
    urbanizacionAccTotalPorCosto();
    edificacionTotalPorCosto();
    ornatoTotalPorCosto();
    gastosGralTotalPorCosto();
    imprevistosTotalPorCosto();
    obligPatronalesTotalPorCosto();
    paqueteAcabadosTotalPorCosto();
    mantenimientoVigilanciaEscTotalPorCosto();
    infraestructuraTotalPorCosto();
    amenidadesTotalPorCosto();
    otros2TotalPorCosto();
    otros3TotalPorCosto();
    costosVentasTotalPorCostos();
    comisionVenConTotalPorCosto();
    comisionVenTitTotalPorCosto();
    publicidadCorTotalPorCosto();
    publicidadUNETotalPorCosto();
    escenarioProvVigTotalPorCosto();
    amuebladoTotalPorCosto();
    gastosVentasTotalPorCosto();
    gastosAdmonUNETotalPorCosto();
    gastosAdmonCorTotalPorCosto();
    gastosAdmonOperacionTotalPorCosto();
    cadenasProductivasTotalPorCosto();
    aperturaCreditoSeguroFianzasTotalPorCosto();
    interesesCreditoTotalPorCosto();
    gastosFinancierosTotalPorCosto();
  }

  private void consigueNumUni() {
    numUni = (Double) manejador.obtenerVariable("pry_uni_viv");
  }

  private void consigueIngresoTotal() {
    ingresoTotal = (Double) manejador.obtenerVariable("pry_ing_tot_viv");
    System.out.println("\n\n\n\n\n\nen consigue: " + ingresoTotal);
  }

  /**
   * calcula el Valor de Total de tramites, licencias y derechos del Proyecto
   * @return el Valor de Total de tramites, licencias y derechos del Proyecto
   */
  private double traLicDerProyTotal() {
    double tra = (Double) manejador.obtenerVariable("pry_imp_tot_tra_lic_der") - (Double) manejador.obtenerVariable("pry_ges_vec_ter_imp_tot");
    manejador.guardarVariable("pry_tra_lic_der_tot", tra);
    return tra;
  }

  /**
   * calcula el Valor de Total de tramites, licencias y derechos del Proyecto por vivienda
   * @return el Valor de Total de tramites, licencias y derechos del Proyecto por vivienda
   */
  private double traLicDerProyVivienda() {
    double tra = 0.0;
    if (numUni != 0) {
      tra = traLicDerProyTotal() / numUni;
      manejador.guardarVariable("pry_tra_lic_der_viv", tra);
      return tra;
    } else {
      manejador.guardarVariable("pry_tra_lic_der_viv", tra);
      return 0.0;
    }
  }

  /**
   * calcula el Valor de Total del Proyecto arquitectónico, calculo estructural, instalaciones, mecánica de suelos y topografía 
   * @return el Valor de Total del Proyecto arquitectónico, calculo estructural, instalaciones, mecánica de suelos y topografía 
   */
  private double valProyectoArqCalcTotal() {
    double val = (Double) manejador.obtenerVariable("pry_imp_tot_pro") - (Double) manejador.obtenerVariable("pry_dro_fir_imp_tot");
    manejador.guardarVariable("pry_pro_est_tot", val);
    return val;
  }

  /**
   * calcula el Valor de Total del Proyecto arquitectónico, calculo estructural, instalaciones, mecánica de suelos y topografía por vivienda
   * @return el Valor de Total del Proyecto arquitectónico, calculo estructural, instalaciones, mecánica de suelos y topografía por vivienda 
   */
  private double valProyectoArqCalcVivienda() {
    double val = 0.0;
    if (numUni != 0) {
      val = valProyectoArqCalcTotal() / numUni;
      manejador.guardarVariable("pry_pro_est_viv", val);
      return val;
    } else {
      manejador.guardarVariable("pry_pro_est_viv", val);
      return 0.0;
    }
  }

  /**
   * calcula el valor del costo de venta total por vivienda
   * @return el valor del costo de venta total por vivienda
   */
  private double costosVentasViviendas() {
    double val = (Double) manejador.obtenerVariable("pry_val_com_ter_imp_viv") + (Double) manejador.obtenerVariable("pry_val_tot_con_imp_viv")
            + (Double) manejador.obtenerVariable("pry_esc_ava_fid_isr_imp_viv") + (Double) manejador.obtenerVariable("pry_adm_fid_imp_viv")
            + valProyectoArqCalcVivienda() + (Double) manejador.obtenerVariable("pry_dro_fir_imp_viv")
            + traLicDerProyVivienda() + (Double) manejador.obtenerVariable("pry_ges_vec_ter_imp_viv")
            + (Double) manejador.obtenerVariable("pry_poz_agu_imp_viv") + (Double) manejador.obtenerVariable("pry_con_vec_imp_viv")
            + (Double) manejador.obtenerVariable("pry_edi_cas_imp_viv") + (Double) manejador.obtenerVariable("pry_urb_imp_viv") + (Double) manejador.obtenerVariable("pry_urb_acc_imp_viv")
            + (Double) manejador.obtenerVariable("pry_edi_dep_imp_viv") + (Double) manejador.obtenerVariable("pry_are_ext_imp_viv") + (Double) manejador.obtenerVariable("pry_gas_gen_imp_viv")
            + (Double) manejador.obtenerVariable("pry_imp_imp_viv") + (Double) manejador.obtenerVariable("pry_obl_pat_imp_viv") + (Double) manejador.obtenerVariable("pry_paq_aca_imp_viv")
            + (Double) manejador.obtenerVariable("pry_man_vig_esc_imp_viv") + (Double) manejador.obtenerVariable("pry_inf_imp_viv") + (Double) manejador.obtenerVariable("pry_ame_imp_viv")
            + (Double) manejador.obtenerVariable("pry_otr_2_imp_viv") + (Double) manejador.obtenerVariable("pry_otr_3_imp_viv");
           System.out.println("estoy en costosVentasViviendas en ESTADOS DE RESULTADOS " +(Double) manejador.obtenerVariable("pry_val_com_ter_imp_viv"));
//            System.out.println((Double) manejador.obtenerVariable("pry_val_tot_con_imp_viv"));
//            System.out.println((Double) manejador.obtenerVariable("pry_esc_ava_fid_isr_imp_viv"));
//            System.out.println((Double) manejador.obtenerVariable("pry_adm_fid_imp_viv"));
//            System.out.println(valProyectoArqCalcVivienda());
//            System.out.println((Double) manejador.obtenerVariable("pry_dro_fir_imp_viv"));
//            System.out.println(traLicDerProyVivienda());
//            System.out.println((Double) manejador.obtenerVariable("pry_ges_vec_ter_imp_viv"));
//            System.out.println((Double) manejador.obtenerVariable("pry_poz_agu_imp_viv"));
//            System.out.println((Double) manejador.obtenerVariable("pry_con_vec_imp_viv"));
//            System.out.println((Double) manejador.obtenerVariable("pry_edi_cas_imp_viv"));
//            System.out.println((Double) manejador.obtenerVariable("pry_urb_imp_viv"));
//            System.out.println((Double) manejador.obtenerVariable("pry_urb_acc_imp_viv"));
//            System.out.println((Double) manejador.obtenerVariable("pry_edi_dep_imp_viv"));
//            System.out.println((Double) manejador.obtenerVariable("pry_are_ext_imp_viv"));
//            System.out.println((Double) manejador.obtenerVariable("pry_gas_gen_imp_viv"));
//            System.out.println((Double) manejador.obtenerVariable("pry_imp_imp_viv"));
//            System.out.println((Double) manejador.obtenerVariable("pry_obl_pat_imp_viv"));
//            System.out.println((Double) manejador.obtenerVariable("pry_paq_aca_imp_viv"));
//            System.out.println((Double) manejador.obtenerVariable("pry_man_vig_esc_imp_viv"));
//            System.out.println((Double) manejador.obtenerVariable("pry_inf_imp_viv"));
//            System.out.println((Double) manejador.obtenerVariable("pry_ame_imp_viv"));
//            System.out.println((Double) manejador.obtenerVariable("pry_otr_2_imp_viv"));
//            System.out.println((Double) manejador.obtenerVariable("pry_otr_3_imp_viv"));

    manejador.guardarVariable("pry_cost_tot_ven_viv", val);
    return val;
  }

  /**
   * calcula el valor del costo de venta total
   * @return el valor del costo de venta total
   */
  private double costosVentasTotal() {
    double val = (Double) manejador.obtenerVariable("pry_val_ter") + (Double) manejador.obtenerVariable("pry_val_tot_con_imp_tot")
            + (Double) manejador.obtenerVariable("pry_esc_ava_fid_isr_imp_tot") + (Double) manejador.obtenerVariable("pry_adm_fid_imp_tot")
            + valProyectoArqCalcTotal() + (Double) manejador.obtenerVariable("pry_dro_fir_imp_tot")
            + traLicDerProyTotal() + (Double) manejador.obtenerVariable("pry_ges_vec_ter_imp_tot")
            + (Double) manejador.obtenerVariable("pry_poz_agu_imp_tot") + (Double) manejador.obtenerVariable("pry_con_vec_imp_tot")
            + (Double) manejador.obtenerVariable("pry_edi_cas_mon") + (Double) manejador.obtenerVariable("pry_urb_mon") + (Double) manejador.obtenerVariable("pry_urb_acc_mon")
            + (Double) manejador.obtenerVariable("pry_edi_depto_mon") + (Double) manejador.obtenerVariable("pry_orn_mon") + (Double) manejador.obtenerVariable("pry_gts_gral_mon")
            + (Double) manejador.obtenerVariable("pry_imp_mon") + (Double) manejador.obtenerVariable("pry_obl_pat_mon") + (Double) manejador.obtenerVariable("pry_paq_aca_mon")
            + (Double) manejador.obtenerVariable("pry_man_vig_esc_mon") + (Double) manejador.obtenerVariable("pry_inf_mon") + (Double) manejador.obtenerVariable("pry_ame_imp_tot")
            + (Double) manejador.obtenerVariable("pry_otr_2_imp_tot") + (Double) manejador.obtenerVariable("pry_otr_3_imp_tot");

    manejador.guardarVariable("pry_total_cost_ven_tot", val);
//    System.out.println((Double) manejador.obtenerVariable("pry_val_ter"));
//    System.out.println((Double) manejador.obtenerVariable("pry_val_tot_con_imp_tot"));
//    System.out.println((Double) manejador.obtenerVariable("pry_esc_ava_fid_isr_imp_tot"));
//    System.out.println((Double) manejador.obtenerVariable("pry_adm_fid_imp_tot"));
//    System.out.println(valProyectoArqCalcTotal());
//    System.out.println((Double) manejador.obtenerVariable("pry_dro_fir_imp_tot"));
//    System.out.println(traLicDerProyTotal());
//    System.out.println((Double) manejador.obtenerVariable("pry_ges_vec_ter_imp_tot"));
//    System.out.println((Double) manejador.obtenerVariable("pry_poz_agu_imp_tot"));
//    System.out.println((Double) manejador.obtenerVariable("pry_con_vec_imp_tot"));
//    System.out.println((Double) manejador.obtenerVariable("pry_edi_cas_mon"));
//    System.out.println((Double) manejador.obtenerVariable("pry_urb_mon"));
//    System.out.println((Double) manejador.obtenerVariable("pry_urb_acc_mon"));
//    System.out.println((Double) manejador.obtenerVariable("pry_edi_depto_mon"));
//    System.out.println((Double) manejador.obtenerVariable("pry_orn_mon"));
//    System.out.println((Double) manejador.obtenerVariable("pry_gts_gral_mon"));
//    System.out.println((Double) manejador.obtenerVariable("pry_imp_mon"));
//    System.out.println((Double) manejador.obtenerVariable("pry_obl_pat_mon"));
//    System.out.println((Double) manejador.obtenerVariable("pry_paq_aca_mon"));
//    System.out.println((Double) manejador.obtenerVariable("pry_man_vig_esc_mon"));
//    System.out.println((Double) manejador.obtenerVariable("pry_inf_mon"));
//    System.out.println((Double) manejador.obtenerVariable("pry_ame_imp_tot"));
//    System.out.println((Double) manejador.obtenerVariable("pry_otr_2_imp_tot"));
//    System.out.println((Double) manejador.obtenerVariable("pry_otr_3_imp_tot"));
    return val;
  }

  /**
   * calcula el Porcentaje de Valor de Compra del terreno
   * @return el Porcentaje de Valor de Compra del terreno
   */
  private double compraTerrenoPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_val_ter") / ingresoTotal;
      manejador.guardarVariable("pry_por_val_ter", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_val_ter", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Predial, Agua y Áreas Comunes, Vigilancia Importe Total
   * @return el Porcentaje de Predial, Agua y Áreas Comunes, Vigilancia Importe Total
   */
  private double predialAguaAreasPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_val_tot_con_imp_tot") / ingresoTotal;
      manejador.guardarVariable("pry_por_val_tot_con_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_val_tot_con_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Escrituras/Avalúo/constitución fideicomiso/terreno/ISR Importe Total
   * @return el Porcentaje de Escrituras/Avalúo/constitución fideicomiso/terreno/ISR Importe Total
   */
  private double escriturasAvaluoFidPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_esc_ava_fid_isr_imp_tot") / ingresoTotal;
      manejador.guardarVariable("pry_por_esc_ava_fid_isr_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_esc_ava_fid_isr_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Administración del fideicomiso Importe Total
   * @return el Porcentaje de Administración del fideicomiso Importe Total
   */
  private double admonFidePor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_adm_fid_imp_tot") / ingresoTotal;
      manejador.guardarVariable("pry_por_adm_fid_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_adm_fid_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Valor de Total del Proyecto arquitectónico, calculo estructural, instalaciones, mecánica de suelos y topografía
   * @return el Porcentaje de Valor de Total del Proyecto arquitectónico, calculo estructural, instalaciones, mecánica de suelos y topografía
   */
  private double valProyectoArqCalcTotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = valProyectoArqCalcTotal() / ingresoTotal;
      manejador.guardarVariable("pry_por_pro_est_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_pro_est_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de DROs y Firmas Importe Total
   * @return el Porcentaje de DROs y Firmas Importe Total
   */
  private double drosFirmaPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_dro_fir_imp_tot") / ingresoTotal;
      manejador.guardarVariable("pry_por_dro_fir_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_dro_fir_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Valor de Total de tramites, licencias y derechos del Proyecto
   * @return el Porcentaje de Valor de Total de tramites, licencias y derechos del Proyecto
   */
  private double traLicDerProyTotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = traLicDerProyTotal() / ingresoTotal;
      manejador.guardarVariable("pry_por_tra_lic_der_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_tra_lic_der_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Concertaciones vecinales Importe Total
   * @return el Porcentaje de Concertaciones vecinales Importe Total
   */
  private double consertacionesVecTotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_con_vec_imp_tot") / ingresoTotal;
      manejador.guardarVariable("pry_por_con_vec_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_con_vec_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Pozo de Agua Importe Total
   * @return el Porcentaje de Pozo de Agua Importe Total
   */
  private double pozoAguaTotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_poz_agu_imp_tot") / ingresoTotal;
      manejador.guardarVariable("pry_por_poz_agu_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_poz_agu_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Gestiones Vecinales y terceros Importe Total
   * @return el Porcentaje de Gestiones Vecinales y terceros Importe Total
   */
  private double gestionesVecinalesTotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_ges_vec_ter_imp_tot") / ingresoTotal;
      manejador.guardarVariable("pry_por_ges_vec_ter_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_ges_vec_ter_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Valor Total de la edificación de casas
   * @return el Porcentaje de Valor Total de la edificación de casas
   */
  private double valorEdificTotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_edi_cas_mon") / ingresoTotal;
      manejador.guardarVariable("pry_por_edi_cas_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_edi_cas_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Valor Total de urbanizacion
   * @return el Porcentaje de Valor Total de urbanizacion
   */
  private double urbanizacionTotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_urb_mon") / ingresoTotal;
      manejador.guardarVariable("pry_por_urb_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_urb_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Valor Total de urbanizacion de acceso
   * @return el Porcentaje de Valor Total de urbanizacion de acceso
   */
  private double urbanizacionAccTotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_urb_acc_mon") / ingresoTotal;
      manejador.guardarVariable("pry_por_urb_acc_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_urb_acc_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Valor Total de edificación departamentos
   * @return el Porcentaje de Valor Total de edificación departamentos
   */
  private double edificacionTotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_edi_depto_mon") / ingresoTotal;
      manejador.guardarVariable("pry_por_edi_depto_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_edi_depto_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Valor Total de ornato
   * @return el Porcentaje de Valor Total de ornato
   */
  private double ornatoTotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_orn_mon") / ingresoTotal;
      manejador.guardarVariable("pry_por_orn_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_orn_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Valor Total de Gastos generales
   * @return el Porcentaje de Valor Total de Gastos generales
   */
  private double gastosGralTotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_gts_gral_mon") / ingresoTotal;
      manejador.guardarVariable("pry_por_gts_gral_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_gts_gral_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Valor Total de imprevistos
   * @return el Porcentaje de Valor Total de imprevistos
   */
  private double imprevistosTotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_imp_mon") / ingresoTotal;
      manejador.guardarVariable("pry_por_imp_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_imp_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Valor Total de obligaciones patronales
   * @return el Porcentaje de Valor Total de obligaciones patronales
   */
  private double obligPatronalesTotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_obl_pat_mon") / ingresoTotal;
      manejador.guardarVariable("pry_por_obl_pat_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_obl_pat_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Valor Total de paquetes de acabados
   * @return el Porcentaje de Valor Total de paquetes de acabados
   */
  private double paqueteAcabadosTotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_paq_aca_mon") / ingresoTotal;
      manejador.guardarVariable("pry_por_paq_aca_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_paq_aca_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Valor Total de Mantenimiento y vigilancia de escenarios
   * @return el Porcentaje de Valor Total de Mantenimiento y vigilancia de escenarios
   */
  private double mantenimientoVigilanciaEscTotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_man_vig_esc_mon") / ingresoTotal;
      manejador.guardarVariable("pry_por_man_vig_esc_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_man_vig_esc_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Valor Total de infraestructura
   * @return el Porcentaje de Valor Total de infraestructura
   */
  private double infraestructuraTotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_inf_mon") / ingresoTotal;
      manejador.guardarVariable("pry_por_infra_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_infra_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Valor Total de amenidades
   * @return el Porcentaje de Valor Total de amenidades
   */
  private double amenidadesTotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_ame_imp_tot") / ingresoTotal;
      manejador.guardarVariable("pry_por_ame_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_ame_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Valor Total de otros 2
   * @return el Porcentaje de Valor Total de otros 2
   */
  private double otros2TotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_otr_2_imp_tot") / ingresoTotal;
      manejador.guardarVariable("pry_por_otr_2_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_otr_2_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Valor Total de otros 3
   * @return el Porcentaje de Valor Total de otros 3
   */
  private double otros3TotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = (Double) manejador.obtenerVariable("pry_otr_3_imp_tot") / ingresoTotal;
      manejador.guardarVariable("pry_por_otr_3_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_otr_3_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje del valor total del costo de venta 
   * @return el Porcentaje del valor total del costo de venta 
   */
  private double costosVentasTotalPor() {
    double total = compraTerrenoPor() + predialAguaAreasPor() + escriturasAvaluoFidPor()
            + admonFidePor() + valProyectoArqCalcTotalPor() + drosFirmaPor() + traLicDerProyTotalPor()
            + gestionesVecinalesTotalPor() + pozoAguaTotalPor() + consertacionesVecTotalPor() + valorEdificTotalPor()
            + urbanizacionTotalPor() + urbanizacionAccTotalPor() + ornatoTotalPor() + edificacionTotalPor()
            + gastosGralTotalPor() + imprevistosTotalPor() + obligPatronalesTotalPor() + paqueteAcabadosTotalPor()
            + mantenimientoVigilanciaEscTotalPor() + infraestructuraTotalPor() + amenidadesTotalPor() + otros2TotalPor() + otros3TotalPor();
    manejador.guardarVariable("pry_por_total_cost_ven_tot", total);

    System.out.println((Double) manejador.obtenerVariable("pry_por_val_ter"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_val_tot_con_imp_tot"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_esc_ava_fid_isr_imp_tot"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_adm_fid_imp_tot"));
    System.out.println(valProyectoArqCalcTotalPor());
    System.out.println((Double) manejador.obtenerVariable("pry_por_dro_fir_imp_tot"));
    System.out.println(traLicDerProyTotalPor());

    System.out.println((Double) manejador.obtenerVariable("pry_por_ges_vec_ter_imp_tot"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_poz_agu_imp_tot"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_con_vec_imp_tot"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_edi_cas_mon"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_urb_mon"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_urb_acc_mon"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_edi_depto_mon"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_orn_mon"));

    System.out.println((Double) manejador.obtenerVariable("pry_por_gts_gral_mon"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_imp_mon"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_obl_pat_mon"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_paq_aca_mon"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_man_vig_esc_mon"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_infra_mon"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_ame_imp_tot"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_otr_2_imp_tot"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_otr_3_imp_tot"));
    System.out.println("ingresoTotal: " + ingresoTotal);

    return total;
  }

  /**
   * calcula la Utilidad Bruta por Vivienda 
   * @return la Utilidad Bruta por Vivienda 
   */
  private double utilidadBrutaVivienda() {
    double val = (Double) manejador.obtenerVariable("pry_val_prom_ven_viv") - costosVentasViviendas();
    manejador.guardarVariable("pry_utl_bru_viv", val);
    return val;
  }

  /**
   * calcula la Utilidad Bruta Total
   * @return la Utilidad Bruta Total
   */
  private double utilidadBrutaTotal() {
    double val = ingresoTotal - costosVentasTotal();
    manejador.guardarVariable("pry_utl_bru_tot", val);
    return val;
  }

  /**
   * calcula el Porcentaje de la Utilidad Bruta Total
   * @return el Porcentaje de la Utilidad Bruta Total
   */
  private double utilidadBrutaTotalPor() {
    double val = utilidadBrutaTotal() / ingresoTotal;
    manejador.guardarVariable("pry_por_utl_bru_tot", val);
    return val;
  }

  ///////////GASTOS DE VENTA, OPERACION Y ADMINISTRACION
  /**
   * calcula el valor total del gasto de venta por vivienda 
   * @return el valor total del gasto de venta por vivienda
   */
  private double gastosVentasVivienda() {
    double total = (Double) manejador.obtenerVariable("pry_com_ven_con_imp_viv") + (Double) manejador.obtenerVariable("pry_com_ven_tit_imp_viv")
            + (Double) manejador.obtenerVariable("pry_pub_cor_imp_viv") + (Double) manejador.obtenerVariable("pry_pub_pro_une_imp_viv")
            + (Double) manejador.obtenerVariable("pry_esc_pro_man_vig_imp_viv") + (Double) manejador.obtenerVariable("pry_amu_dec_dep_ofi_imp_viv");
    manejador.guardarVariable("pry_gtos_ven_viv", total);
    return total;
  }

  /**
   * calcula el valor total del gasto de venta 
   * @return el valor total del gasto de venta 
   */
  private double gastosVentasTotal() {
    double total = (Double) manejador.obtenerVariable("pry_com_ven_con_imp_tot") + (Double) manejador.obtenerVariable("pry_com_ven_tit_imp_tot")
            + (Double) manejador.obtenerVariable("pry_pub_cor_imp_tot") + (Double) manejador.obtenerVariable("pry_pub_pro_une_imp_tot")
            + (Double) manejador.obtenerVariable("pry_esc_pro_man_vig_imp_tot") + (Double) manejador.obtenerVariable("pry_amu_dec_dep_ofi_imp_tot");
    manejador.guardarVariable("pry_gtos_ven_tot", total);
//    System.out.println((Double) manejador.obtenerVariable("pry_com_ven_con_imp_tot"));
//    System.out.println((Double) manejador.obtenerVariable("pry_com_ven_tit_imp_tot"));
//    System.out.println((Double) manejador.obtenerVariable("pry_pub_cor_imp_tot"));
//    System.out.println((Double) manejador.obtenerVariable("pry_pub_pro_une_imp_tot"));
//    System.out.println((Double) manejador.obtenerVariable("pry_esc_pro_man_vig_imp_tot"));
//    System.out.println((Double) manejador.obtenerVariable("pry_amu_dec_dep_ofi_imp_tot"));
    return total;
  }

  /**
   * calcula el Porcentaje de Comisiones de Venta (contrato) Importe Total
   * @return el Porcentaje de Comisiones de Venta (contrato) Importe Total
   */
  private double comisionVenConTotalPor() {
    double val = 0.0;
    if (numUni != 0) {
      val = (Double) manejador.obtenerVariable("pry_com_ven_con_imp_tot") / ingresoTotal;
      manejador.guardarVariable("pry_por_com_ven_con_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_com_ven_con_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Comisiones de Venta (titulacion) Importe Total
   * @return el Porcentaje de Comisiones de Venta (titulacion) Importe Total
   */
  private double comisionVenTitTotalPor() {
    double val = 0.0;
    if (numUni != 0) {
      val = (Double) manejador.obtenerVariable("pry_com_ven_tit_imp_tot") / ingresoTotal;
      manejador.guardarVariable("pry_por_com_ven_tit_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_com_ven_tit_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Publicidad (Corporativo) Importe Total
   * @return el Porcentaje de Publicidad (Corporativo) Importe Total
   */
  private double publicidadCorTotalPor() {
    double val = 0.0;
    if (numUni != 0) {
      val = (Double) manejador.obtenerVariable("pry_pub_cor_imp_tot") / ingresoTotal;
      manejador.guardarVariable("pry_por_pub_cor_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_pub_cor_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Publicidad (UNE) Importe Total
   * @return el Porcentaje de Publicidad (UNE) Importe Total
   */
  private double publicidadUNETotalPor() {
    double val = 0.0;
    if (numUni != 0) {
      val = (Double) manejador.obtenerVariable("pry_pub_pro_une_imp_tot") / ingresoTotal;
      manejador.guardarVariable("pry_por_pub_pro_une_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_pub_pro_une_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Escenario provisional/manto/vigilancia Importe Total
   * @return el Porcentaje de Escenario provisional/manto/vigilancia Importe Total
   */
  private double escenarioProvVigTotalPor() {
    double val = 0.0;
    if (numUni != 0) {
      val = (Double) manejador.obtenerVariable("pry_esc_pro_man_vig_imp_tot") / ingresoTotal;
      manejador.guardarVariable("pry_por_esc_pro_man_vig_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_esc_pro_man_vig_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Amueblado y decorado de departamento y oficinas Importe Total
   * @return el Porcentaje de Amueblado y decorado de departamento y oficinas Importe Total
   */
  private double amuebladoTotalPor() {
    double val = 0.0;
    if (numUni != 0) {
      val = (Double) manejador.obtenerVariable("pry_amu_dec_dep_ofi_imp_tot") / ingresoTotal;
      manejador.guardarVariable("pry_por_amu_dec_dep_ofi_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_amu_dec_dep_ofi_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de valor total del gasto de venta 
   * @return el Porcentaje de valor total del gasto de venta 
   */
  private double gastosVentasTotalPor() {
    double total = comisionVenConTotalPor() + comisionVenTitTotalPor() + publicidadCorTotalPor()
            + publicidadUNETotalPor() + escenarioProvVigTotalPor() + amuebladoTotalPor();
    manejador.guardarVariable("pry_por_gtos_ven_tot", total);
    return total;
  }

  /**
   * calcula la Suma de los Gastos de Administración y de Operación por Vivienda
   * @return la Suma de los Gastos de Administración y de Operación por Vivienda
   */
  private double gastosAdmonVivienda() {
    double total = (Double) manejador.obtenerVariable("pry_gas_ope_adm_une_imp_viv") + (Double) manejador.obtenerVariable("pry_gas_ope_adm_cor_imp_viv");
    manejador.guardarVariable("pry_gtos_ope_adm_viv", total);
    return total;
  }

  /**
   * calcula la Suma de los Gastos de Administración y de Operación Totales
   * @return la Suma de los Gastos de Administración y de Operación Totales
   */
  private double gastosAdmonTotal() {
    double total = (Double) manejador.obtenerVariable("pry_gas_ope_adm_une_imp_tot") + (Double) manejador.obtenerVariable("pry_gas_ope_adm_cor_imp_tot");
    manejador.guardarVariable("pry_gtos_ope_adm_tot", total);
    return total;
  }

  /**
   * calcula el Porcentaje de Gastos de Operación y Admon. (UNE)
   * @return el Porcentaje de Gastos de Operación y Admon. (UNE)
   */
  private double gastosAdmonUNETotalPor() {
    double val = 0.0;
    if (numUni != 0) {
      val = (Double) manejador.obtenerVariable("pry_gas_ope_adm_une_imp_tot") / ingresoTotal;
      manejador.guardarVariable("pry_por_gas_ope_adm_une_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_gas_ope_adm_une_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Gastos de Operación y Admon. (Coorporativo)
   * @return el Porcentaje de Gastos de Operación y Admon. (Coorporativo)
   */
  private double gastosAdmonCorTotalPor() {
    double val = 0.0;
    if (numUni != 0) {
      val = (Double) manejador.obtenerVariable("pry_gas_ope_adm_cor_imp_tot") / ingresoTotal;
      manejador.guardarVariable("pry_por_gas_ope_adm_cor_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_gas_ope_adm_cor_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de valor total del gasto de admon y operacion 
   * @return el Porcentaje de valor total del gasto de admon y operacion  
   */
  private double gastosAdmonOperacionTotalPor() {
    double total = gastosAdmonUNETotalPor() + gastosAdmonCorTotalPor();
    System.out.println(gastosAdmonUNETotalPor());
    System.out.println(gastosAdmonCorTotalPor());
    manejador.guardarVariable("pry_por_gtos_ope_adm_tot", total);
    return total;
  }

  /**
   * calcula la Utilidad Antes de Financieros por Vivienda
   * @return la Utilidad Antes de Financieros por Vivienda
   */
  private double utilidadFinancierosVivienda() {
    double val = utilidadBrutaVivienda() - (gastosVentasVivienda() + gastosAdmonVivienda());
    manejador.guardarVariable("pry_utl_ant_fin_viv", val);
    return val;
  }

  /**
   * calcula la Utilidad Antes de Financieros Total
   * @return la Utilidad Antes de Financieros Total
   */
  private double utilidadFinancierosTotal() {
    double val = utilidadBrutaTotal() - (gastosVentasTotal() + gastosAdmonTotal());
    manejador.guardarVariable("pry_utl_ant_fin_tot", val);
    return val;
  }

  /**
   * calcula el Porcentaje de la Utilidad Antes de Financieros Total
   * @return el Porcentaje de la Utilidad Antes de Financieros Total
   */
  private double utilidadFinancierosTotalPor() {
    double val = utilidadBrutaTotalPor() - (gastosVentasTotalPor() + gastosAdmonOperacionTotalPor());
    manejador.guardarVariable("pry_por_utl_ant_fin_tot", val);
    return val;
  }

  ///////////Gastos Financieros
  /**
   * calcula la Suma de los Totales de Apertura de Credito, Seguro, Fianzas, Notariales, Sup. de Obra y Admon. de Recursos
   * @return la Suma de los Totales de Apertura de Credito, Seguro, Fianzas, Notariales, Sup. de Obra y Admon. de Recursos
   */
  public double aperturaCreditoSeguroFianzasTotal() {
    double val = (Double) manejador.obtenerVariable("pry_ape_cre_imp_tot") + (Double) manejador.obtenerVariable("pry_seg_fia_gas_not_imp_tot") + (Double) manejador.obtenerVariable("pry_sup_obr_adm_rec_imp_tot");
//    System.out.println((Double) manejador.obtenerVariable("pry_ape_cre_imp_tot"));
//    System.out.println((Double) manejador.obtenerVariable("pry_seg_fia_gas_not_imp_tot"));
//    System.out.println((Double) manejador.obtenerVariable("pry_sup_obr_adm_rec_imp_tot"));
    manejador.guardarVariable("pry_ape_fia_not_adm_tot", val);
    return val;
  }

  //***///***///metodo que no se ha hecho de la pestaña de jose
  /**
   * calcula las Cadenas Productivas y Costos Financieros Alternos por Vivienda
   * @return las Cadenas Productivas y Costos Financieros Alternos por Vivienda
   */
  private double cadenasProductivasVivienda() {
    double val = 0.0;
    if (numUni != 0) {
      val = 0.0;
      //CAMBIAR AQUI!!!(Double) manejador.obtenerVariable("pry_cad_pro_cos_fin_alt_tot") / numUni;
      manejador.guardarVariable("pry_cad_pro_cos_fin_alt_viv", val);
      return val;
    } else {
      manejador.guardarVariable("pry_cad_pro_cos_fin_alt_viv", val);
      return 0.0;
    }
  }

  /**
   * calcula la Suma de los Totales de Apertura de Credito, Seguro, Fianzas, Notariales, Sup. de Obra y Admon. de Recursos por vivienda
   * @return la Suma de los Totales de Apertura de Credito, Seguro, Fianzas, Notariales, Sup. de Obra y Admon. de Recursos por vivienda
   */
  private double aperturaCreditoSeguroFianzasVivienda() {
    double val = 0.0;
    if (numUni != 0) {
      val = aperturaCreditoSeguroFianzasTotal() / numUni;
      manejador.guardarVariable("pry_ape_fia_not_adm_viv", val);
      return val;
    } else {
      manejador.guardarVariable("pry_ape_fia_not_adm_viv", val);
      return 0.0;
    }
  }

  //***///***///metodo que no se ha hecho de la pestaña de jose
  /**
   * calcula loa Intereses del Credito por Vivienda
   * @return loa Intereses del Credito por Vivienda
   */
  private double interesesCreditoVivienda() {
    double val = 0.0;
    if (numUni != 0) {
      val = 9038195 / numUni;
      //CAMBIAR AQUI!!!! (Double) manejador.obtenerVariable("pry_int_cre_tot") / numUni;
      manejador.guardarVariable("pry_int_cre_viv", val);
      return val;
    } else {
      manejador.guardarVariable("pry_int_cre_viv", val);
      return 0.0;
    }
  }

  /**
   * calcula la Suma de los Gastos Financieros por Vivienda
   * @return la Suma de los Gastos Financieros por Vivienda
   */
  private double gastosFinancierosVivienda() {
    double val = cadenasProductivasVivienda() + aperturaCreditoSeguroFianzasVivienda() + interesesCreditoVivienda();
    System.out.println(cadenasProductivasVivienda());
    System.out.println(aperturaCreditoSeguroFianzasVivienda());
    System.out.println(interesesCreditoVivienda());
    manejador.guardarVariable("pry_gtos_fin_viv", val);
    return val;
  }

  /**
   * calcula la Suma de los Gastos Financieros Total
   * @return la Suma de los Gastos Financieros Total
   */
  private double gastosFinancierosTotal() {
    double val = 0 + aperturaCreditoSeguroFianzasTotal() + 9038195;

    //CAMBIAR POR EL CERO!!!! (Double) manejador.obtenerVariable("pry_cad_pro_cos_fin_alt_tot") y este (Double) manejador.obtenerVariable("pry_int_cre_tot")
    manejador.guardarVariable("pry_gtos_fin_tot", val);
    return val;
  }

  /**
   * calcula el Porcentaje de las Cadenas Productivas y Costos Financieros Alternos 
   * @return el Porcentaje de las Cadenas Productivas y Costos Financieros Alternos 
   */
  private double cadenasProductivasTotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = 0.0;
      //CAMBIAR ESTO!!!!!!   (Double) manejador.obtenerVariable("pry_cad_pro_cos_fin_alt_tot") / ingresoTotal;
      manejador.guardarVariable("pry_por_cad_pro_cos_fin_alt_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cad_pro_cos_fin_alt_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de la Suma de los Totales de Apertura de Credito, Seguro, Fianzas, Notariales, Sup. de Obra y Admon. de Recursos
   * @return el Porcentaje de la Suma de los Totales de Apertura de Credito, Seguro, Fianzas, Notariales, Sup. de Obra y Admon. de Recursos
   */
  private double aperturaCreditoSeguroFianzasTotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = aperturaCreditoSeguroFianzasTotal() / ingresoTotal;
      manejador.guardarVariable("pry_por_ape_fia_not_adm_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_ape_fia_not_adm_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de Intereses del Crédito
   * @return el Porcentaje de Intereses del Crédito
   */
  private double interesesCreditoTotalPor() {
    double val = 0.0;
    if (ingresoTotal != 0) {
      val = 9038195 / ingresoTotal;
      //CAMBIAR ESTO!!!! (Double) manejador.obtenerVariable("pry_int_cre_tot") / ingresoTotal;
      manejador.guardarVariable("pry_por_int_cre_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_int_cre_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje de la Suma de los Gastos Financieros Total
   * @return el Porcentaje de la Suma de los Gastos Financieros Total
   */
  private double gastosFinancierosTotalPor() {
    double val = cadenasProductivasTotalPor() + aperturaCreditoSeguroFianzasTotalPor() + interesesCreditoTotalPor();
    System.out.println(cadenasProductivasTotalPor());
    System.out.println(aperturaCreditoSeguroFianzasTotalPor());
    System.out.println(interesesCreditoTotalPor());
    manejador.guardarVariable("pry_por_gas_fin_tot", val);
    return val;
  }

  /**
   * calcula la Utilidad antes Impuestos por Vivienda 
   * @return la Utilidad antes Impuestos por Vivienda 
   */
  private double utilidadImpuestosVivienda() {
    double val = utilidadFinancierosVivienda() - gastosFinancierosVivienda();
    manejador.guardarVariable("pry_utl_ant_imp_viv", val);
    return val;
  }

  /**
   * calcula la Utilidad antes Impuestos Total
   * @return la Utilidad antes Impuestos Total
   */
  private double utilidadImpuestosTotal() {
    double val = utilidadFinancierosTotal() - gastosFinancierosTotal();
    manejador.guardarVariable("pry_utl_ant_imp_tot", val);
    return val;
  }

  /**
   * calcula el Porcentaje de la Utilidad antes Impuestos Total
   * @return el Porcentaje de la Utilidad antes Impuestos Total
   */
  private double utilidadImpuestosTotalPor() {
    double val = utilidadFinancierosTotalPor() - gastosFinancierosTotalPor();
    manejador.guardarVariable("pry_por_utl_ant_imp_tot", val);
    return val;
  }

  ///////////CALCULO DE PORCENTAJES DE COSTO
  /**
   * calcula la Suma de Costos y Gastos de Venta, Admon. Operación y Financieros Totales
   * @return la Suma de Costos y Gastos de Venta, Admon. Operación y Financieros Totales
   */
  private double costosGastosTotales() {
    double val = costosVentasTotal() + gastosVentasTotal() + gastosAdmonTotal() + gastosFinancierosTotal();
    costosGastosTotales = val;
    return val;
  }

  /**
   * calcula el Porcentaje Costo de Valor de Compra del terreno
   * @return el Porcentaje Costo de Valor de Compra del terreno
   */
  private double compraTerrenoPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_val_ter") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_val_ter", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_val_ter", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Predial, Agua y Áreas Comunes, Vigilancia Importe Total
   * @return el Porcentaje Costo de Predial, Agua y Áreas Comunes, Vigilancia Importe Total
   */
  private double predialAguaAreasPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_val_tot_con_imp_tot") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_val_tot_con_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_val_tot_con_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Escrituras/Avalúo/constitución fideicomiso/terreno/ISR Importe Total
   * @return el Porcentaje Costo de Escrituras/Avalúo/constitución fideicomiso/terreno/ISR Importe Total
   */
  private double escriturasAvaluoFidPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_esc_ava_fid_isr_imp_tot") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_esc_ava_fid_isr_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_esc_ava_fid_isr_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Administración del fideicomiso Importe Total
   * @return el Porcentaje Costo de Administración del fideicomiso Importe Total
   */
  private double admonFidePorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_adm_fid_imp_tot") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_adm_fid_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_adm_fid_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Valor de Total del Proyecto arquitectónico, calculo estructural, instalaciones, mecánica de suelos y topografía
   * @return el Porcentaje Costo de Valor de Total del Proyecto arquitectónico, calculo estructural, instalaciones, mecánica de suelos y topografía
   */
  private double valProyectoArqCalcTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = valProyectoArqCalcTotal() / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_pro_est_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_pro_est_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de DROs y Firmas Importe Total
   * @return el Porcentaje Costo de DROs y Firmas Importe Total
   */
  private double drosFirmaPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_dro_fir_imp_tot") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_dro_fir_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_dro_fir_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Valor de Total de tramites, licencias y derechos del Proyecto
   * @return el Porcentaje Costo de Valor de Total de tramites, licencias y derechos del Proyecto
   */
  private double traLicDerProyTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = traLicDerProyTotal() / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_tra_lic_der_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_tra_lic_der_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Concertaciones vecinales Importe Total
   * @return el Porcentaje Costo de Concertaciones vecinales Importe Total
   */
  private double consertacionesVecTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_con_vec_imp_tot") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_con_vec_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_con_vec_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Pozo de Agua Importe Total
   * @return el Porcentaje Costo de Pozo de Agua Importe Total
   */
  private double pozoAguaTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_poz_agu_imp_tot") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_poz_agu_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_poz_agu_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Gestiones Vecinales y terceros Importe Total
   * @return el Porcentaje Costo de Gestiones Vecinales y terceros Importe Total
   */
  private double gestionesVecinalesTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_ges_vec_ter_imp_tot") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_ges_vec_ter_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_ges_vec_ter_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Valor Total de la edificación de casas
   * @return el Porcentaje Costo de Valor Total de la edificación de casas
   */
  private double valorEdificTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_edi_cas_mon") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_edi_cas_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_edi_cas_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Valor Total de urbanizacion
   * @return el Porcentaje Costo de Valor Total de urbanizacion
   */
  private double urbanizacionTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_urb_mon") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_urb_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_urb_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Valor Total de urbanizacion de acceso
   * @return el Porcentaje Costo de Valor Total de urbanizacion de acceso
   */
  private double urbanizacionAccTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_por_urb_acc_mon") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_urb_acc_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_urb_acc_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Valor Total de edificación departamentos
   * @return el Porcentaje Costo de Valor Total de edificación departamentos
   */
  private double edificacionTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_edi_depto_mon") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_edi_depto_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_edi_depto_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Valor Total de ornato
   * @return el Porcentaje Costo de Valor Total de ornato
   */
  private double ornatoTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_orn_mon") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_orn_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_orn_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Valor Total de Gastos generales
   * @return el Porcentaje Costo de Valor Total de Gastos generales
   */
  private double gastosGralTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_gts_gral_mon") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_gts_gral_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_gts_gral_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Valor Total de imprevistos
   * @return el Porcentaje Costo de Valor Total de imprevistos
   */
  private double imprevistosTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_imp_mon") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_imp_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_imp_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Valor Total de obligaciones patronales
   * @return el Porcentaje Costo de Valor Total de obligaciones patronales
   */
  private double obligPatronalesTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_obl_pat_mon") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_obl_pat_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_obl_pat_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Valor Total de paquetes de acabados
   * @return el Porcentaje Costo de Valor Total de paquetes de acabados
   */
  private double paqueteAcabadosTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_paq_aca_mon") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_paq_aca_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_paq_aca_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Valor Total de Mantenimiento y vigilancia de escenarios
   * @return el Porcentaje Costo de Valor Total de Mantenimiento y vigilancia de escenarios
   */
  private double mantenimientoVigilanciaEscTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_man_vig_esc_mon") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_man_vig_esc_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_man_vig_esc_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Valor Total de infraestructura
   * @return el Porcentaje Costo de Valor Total de infraestructura
   */
  private double infraestructuraTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_inf_mon") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_infra_mon", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_infra_mon", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Valor Total de amenidades
   * @return el Porcentaje Costo de Valor Total de amenidades
   */
  private double amenidadesTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_ame_imp_tot") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_ame_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_ame_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Valor Total de otros 2
   * @return el Porcentaje Costo de Valor Total de otros 2
   */
  private double otros2TotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_otr_2_imp_tot") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_otr_2_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_otr_2_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Valor Total de otros 3
   * @return el Porcentaje Costo de Valor Total de otros 3
   */
  private double otros3TotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_otr_3_imp_tot") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_otr_3_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_otr_3_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costos del valor total del costo de venta 
   * @return el Porcentaje Costos del valor total del costo de venta 
   */
  private double costosVentasTotalPorCostos() {
    double total = compraTerrenoPorCosto() + predialAguaAreasPorCosto() + escriturasAvaluoFidPorCosto()
            + admonFidePorCosto() + valProyectoArqCalcTotalPorCosto() + drosFirmaPorCosto() + traLicDerProyTotalPorCosto()
            + consertacionesVecTotalPorCosto() + pozoAguaTotalPorCosto() + gestionesVecinalesTotalPorCosto() + valorEdificTotalPorCosto()
            + urbanizacionTotalPorCosto() + urbanizacionAccTotalPorCosto() + ornatoTotalPorCosto() + edificacionTotalPorCosto()
            + gastosGralTotalPorCosto() + imprevistosTotalPorCosto() + obligPatronalesTotalPorCosto() + paqueteAcabadosTotalPorCosto()
            + mantenimientoVigilanciaEscTotalPorCosto() + infraestructuraTotalPorCosto() + amenidadesTotalPorCosto() + otros2TotalPorCosto() + otros3TotalPorCosto();

    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_val_ter"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_val_tot_con_imp_tot"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_esc_ava_fid_isr_imp_tot"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_adm_fid_imp_tot"));
    System.out.println(valProyectoArqCalcTotalPorCosto());
    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_dro_fir_imp_tot"));
    System.out.println(traLicDerProyTotalPorCosto());

    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_ges_vec_ter_imp_tot"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_poz_agu_imp_tot"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_con_vec_imp_tot"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_edi_cas_mon"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_urb_mon"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_urb_acc_mon"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_edi_depto_mon"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_orn_mon"));

    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_gts_gral_mon"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_imp_mon"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_obl_pat_mon"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_paq_aca_mon"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_man_vig_esc_mon"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_infra_mon"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_ame_imp_tot"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_otr_2_imp_tot"));
    System.out.println((Double) manejador.obtenerVariable("pry_por_cto_otr_3_imp_tot"));
    System.out.println("ingresoTotal: " + ingresoTotal);


    manejador.guardarVariable("pry_por_cto_total_cost_ven_tot", total);
    return total;
  }

  /**
   * calcula el Porcentaje Costo de Comisiones de Venta (contrato) Importe Total
   * @return el Porcentaje Costo de Comisiones de Venta (contrato) Importe Total
   */
  private double comisionVenConTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_com_ven_con_imp_tot") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_com_ven_con_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_com_ven_con_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Comisiones de Venta (titulacion) Importe Total
   * @return el Porcentaje Costo de Comisiones de Venta (titulacion) Importe Total
   */
  private double comisionVenTitTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_com_ven_tit_imp_tot") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_com_ven_tit_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_com_ven_tit_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Publicidad (Corporativo) Importe Total
   * @return el Porcentaje Costo de Publicidad (Corporativo) Importe Total
   */
  private double publicidadCorTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_pub_cor_imp_tot") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_pub_cor_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_pub_cor_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Publicidad (UNE) Importe Total
   * @return el Porcentaje Costo de Publicidad (UNE) Importe Total
   */
  private double publicidadUNETotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_pub_pro_une_imp_tot") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_pub_pro_une_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_pub_pro_une_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Escenario provisional/manto/vigilancia Importe Total
   * @return el Porcentaje Costo de Escenario provisional/manto/vigilancia Importe Total
   */
  private double escenarioProvVigTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_esc_pro_man_vig_imp_tot") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_esc_pro_man_vig_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_esc_pro_man_vig_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Amueblado y decorado de departamento y oficinas Importe Total
   * @return el Porcentaje Costo de Amueblado y decorado de departamento y oficinas Importe Total
   */
  private double amuebladoTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_amu_dec_dep_ofi_imp_tot") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_amu_dec_dep_ofi_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_amu_dec_dep_ofi_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de valor total del gasto de venta 
   * @return el Porcentaje Costo de valor total del gasto de venta 
   */
  private double gastosVentasTotalPorCosto() {
    double total = comisionVenConTotalPorCosto() + comisionVenTitTotalPorCosto() + publicidadCorTotalPorCosto()
            + publicidadUNETotalPorCosto() + escenarioProvVigTotalPorCosto() + amuebladoTotalPorCosto();
    manejador.guardarVariable("pry_por_cto_gtos_ven_tot", total);
    System.out.println(comisionVenConTotalPorCosto());
    System.out.println(comisionVenTitTotalPorCosto());
    System.out.println(publicidadCorTotalPorCosto());
    System.out.println(publicidadUNETotalPorCosto());
    System.out.println(escenarioProvVigTotalPorCosto());
    System.out.println(amuebladoTotalPorCosto());
    return total;
  }

  /**
   * calcula el Porcentaje de Gastos de Operación y Admon. (UNE)
   * @return el Porcentaje de Gastos de Operación y Admon. (UNE)
   */
  private double gastosAdmonUNETotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_gas_ope_adm_une_imp_tot") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_gas_ope_adm_une_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_gas_ope_adm_une_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Gastos de Operación y Admon. (Coorporativo)
   * @return el Porcentaje Costo de Gastos de Operación y Admon. (Coorporativo)
   */
  private double gastosAdmonCorTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = (Double) manejador.obtenerVariable("pry_gas_ope_adm_cor_imp_tot") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_gas_ope_adm_cor_imp_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_gas_ope_adm_cor_imp_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de valor total del gasto de admon y operacion 
   * @return el Porcentaje Costo de valor total del gasto de admon y operacion  
   */
  private double gastosAdmonOperacionTotalPorCosto() {
    double total = gastosAdmonUNETotalPorCosto() + gastosAdmonCorTotalPorCosto();
    System.out.println(gastosAdmonUNETotalPorCosto());
    System.out.println(gastosAdmonCorTotalPorCosto());
    manejador.guardarVariable("pry_por_cto_gtos_ope_adm_tot", total);
    return total;
  }

  /**
   * calcula el Porcentaje de las Cadenas Productivas y Costos Financieros Alternos 
   * @return el Porcentaje de las Cadenas Productivas y Costos Financieros Alternos 
   */
  private double cadenasProductivasTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = 0.0;
      //(Double) manejador.obtenerVariable("pry_cad_pro_cos_fin_alt_tot") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_cad_pro_cos_fin_alt_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_cad_pro_cos_fin_alt_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de la Suma de los Totales de Apertura de Credito, Seguro, Fianzas, Notariales, Sup. de Obra y Admon. de Recursos
   * @return el Porcentaje Costo de la Suma de los Totales de Apertura de Credito, Seguro, Fianzas, Notariales, Sup. de Obra y Admon. de Recursos
   */
  private double aperturaCreditoSeguroFianzasTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = aperturaCreditoSeguroFianzasTotal() / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_ape_fia_not_adm_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_ape_fia_not_adm_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de Intereses del Crédito
   * @return el Porcentaje Costo de Intereses del Crédito
   */
  private double interesesCreditoTotalPorCosto() {
    double val = 0.0;
    if (costosGastosTotales != 0) {
      val = 9038195 / costosGastosTotales;
      //(Double) manejador.obtenerVariable("pry_int_cre_tot") / costosGastosTotales;
      manejador.guardarVariable("pry_por_cto_int_cre_tot", val);
      return val;
    } else {
      manejador.guardarVariable("pry_por_cto_int_cre_tot", val);
      return 0.0;
    }
  }

  /**
   * calcula el Porcentaje Costo de la Suma de los Gastos Financieros Total
   * @return el Porcentaje Costo de la Suma de los Gastos Financieros Total
   */
  private double gastosFinancierosTotalPorCosto() {
    double val = cadenasProductivasTotalPorCosto() + aperturaCreditoSeguroFianzasTotalPorCosto() + interesesCreditoTotalPorCosto();
    manejador.guardarVariable("pry_por_cto_gas_fin_tot", val);
    System.out.println(cadenasProductivasTotalPorCosto());
    System.out.println(aperturaCreditoSeguroFianzasTotalPorCosto());
    System.out.println(interesesCreditoTotalPorCosto());
    return val;
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

    /**
     * EMPIEZA INFOBASICA
     */
    System.out.println("\n\n\n\nCALCULA LA INFORMACION BASICA");
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
    System.out.println("valor de predial, agua etc. total: " + auxiliar);

    System.out.println("\ncalcula el valor del predial, agua, areas comunes por vivienda");
    auxiliar = generadores.predialAguaVivienda();
    System.out.println("valor de predial y agua por vivienda: " + auxiliar);

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


    //////empieza el modulo de proyecto
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
    for (Double d : aux) {
      System.out.println("anticipo cred. solicitado por etapa: " + d);
    }

    System.out.println("\ncalcula el Disposición de Recursos Crédito Solicitado Importe Total");
    auxiliar = generadores.disposicionRecCreditoPuenteTotal();
    System.out.println("disposicion de recursos credito total: " + auxiliar);

    System.out.println("\ncalcula el Disposición de Recursos Crédito Solicitado Importe Total por etapa");
    aux = generadores.disposicionRecCreditoPuenteEtapa();
    for (Double d : aux) {
      System.out.println("disposicion de recursos por etapa: " + d);
    }

    System.out.println("\ncalcula la Amortización del Crédito / Crédito Solicitado Etapa Importe Total");
    auxiliar = generadores.amortizacionCreditoPuenteTotal();
    System.out.println("amortizacion de credito total: " + auxiliar);

    System.out.println("\ncalcula la Amortización del Crédito / Crédito Solicitado Etapa Importe Total por etapa");
    aux = generadores.amortizacionCreditoPuenteEtapa();
    for (Double d : aux) {
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


    /**
     * EMPIEZA ESTADOS RESULTADOS
     */
    System.out.println("\n\n\n\nEmpieza Estados Resultados");
    EstadosResultados estados = new EstadosResultados(m);


    System.out.println("\n\nMODULO DE COSTOS DE VENTAS");

    System.out.println("\ncalcula el Valor de Total de tramites, licencias y derechos del Proyecto");
    auxiliar = estados.traLicDerProyTotal();
    System.out.println("tramites, licencias, derechos totales: " + auxiliar);

    System.out.println("\ncalcula el Valor de Total de tramites, licencias y derechos del Proyecto por vivienda");
    auxiliar = estados.traLicDerProyVivienda();
    System.out.println("tramites, licencias, derechos totales vivienda: " + auxiliar);

    System.out.println("\ncalcula el Valor de Total del Proyecto arquitectónico, calculo estructural, instalaciones, mecánica de suelos y topografía");
    auxiliar = estados.valProyectoArqCalcTotal();
    System.out.println("proyecto arquitectonico, calculo estructural, etc total:" + auxiliar);

    System.out.println("\ncalcula el Valor de Total del Proyecto arquitectónico, calculo estructural, instalaciones, mecánica de suelos y topografía por vivienda");
    auxiliar = estados.valProyectoArqCalcVivienda();
    System.out.println("proyecto arquitectonico, calculo estructural, etc vivienda:" + auxiliar);

    System.out.println("\ncalcula el valor del costo de venta total por vivienda");
    auxiliar = estados.costosVentasViviendas();
    System.out.println("costos de venta total por vivienda: " + auxiliar);

    System.out.println("\ncalcula el valor del costo de venta total");
    auxiliar = estados.costosVentasTotal();
    System.out.println("costo de venta total: " + auxiliar);

    System.out.println("\nAQUI HAY REDONDEOOOOOOOOO =D=D=D calcula porcentaje del valor del costo de venta total");
    auxiliar = estados.costosVentasTotalPor();
    System.out.println("costo de venta total porcentaje: " + Funciones.redondear(String.valueOf(auxiliar), 4));

    System.out.println("\ncalcula la Utilidad Bruta por Vivienda");
    auxiliar = estados.utilidadBrutaVivienda();
    System.out.println("utilidad bruta por vivienda: " + auxiliar);

    System.out.println("\ncalcula la Utilidad Bruta total");
    auxiliar = estados.utilidadBrutaTotal();
    System.out.println("utilidad bruta por total: " + auxiliar);

    System.out.println("\ncalcula la Utilidad Bruta vivienda");
    auxiliar = estados.utilidadBrutaTotalPor();
    System.out.println("utilidad bruta porcentaje de ingresos: " + auxiliar);


    System.out.println("\n\nGASTOS DE VENTA, OPERACION Y ADMINISTRACION");

    System.out.println("\ncalcula el valor total del gasto de venta por vivienda");
    auxiliar = estados.gastosVentasVivienda();
    System.out.println("gastos de venta por vivienda: " + auxiliar);

    System.out.println("\ncalcula el valor total del gasto de venta total");
    auxiliar = estados.gastosVentasTotal();
    System.out.println("gastos de venta por total: " + auxiliar);

    System.out.println("\ncalcula el Porcentaje de Comisiones de Venta (contrato) Importe Total");
    auxiliar = estados.comisionVenConTotalPor();
    System.out.println("comisiones venta (contrato): " + auxiliar);

    System.out.println("\ncalcula el Porcentaje de Comisiones de Venta (titulacion) Importe Total");
    auxiliar = estados.comisionVenTitTotalPor();
    System.out.println("comisiones venta (titulacion): " + auxiliar);

    System.out.println("\ncalcula el Porcentaje de Publicidad (Corporativo) Importe Total");
    auxiliar = estados.publicidadCorTotalPor();
    System.out.println("publicidad (Corporativo) porcentaje: " + auxiliar);

    System.out.println("\ncalcula el Porcentaje de Publicidad (UNE) Importe Total");
    auxiliar = estados.publicidadUNETotalPor();
    System.out.println("publicidad (UNE) porcentaje: " + auxiliar);

    System.out.println("\ncalcula el Porcentaje de Escenario provisional/manto/vigilancia Importe Total");
    auxiliar = estados.escenarioProvVigTotalPor();
    System.out.println("escenario provisional/manto/vigilancia porcentaje: " + auxiliar);

    System.out.println("\ncalcula el Porcentaje de Amueblado y decorado de departamento y oficinas Importe Total");
    auxiliar = estados.amuebladoTotalPor();
    System.out.println("Amueblado y decorado porcentaje: " + auxiliar);
    /////
    System.out.println("\ncalcula el Porcentaje de valor total del gasto de venta");
    auxiliar = estados.gastosVentasTotalPor();
    System.out.println("valor total del gasto de venta porcentaje: " + auxiliar);

    System.out.println("\ncalcula la Suma de los Gastos de Administración y de Operación por Vivienda");
    auxiliar = estados.gastosAdmonVivienda();
    System.out.println("Suma de los Gastos de Administración y de Operación por Vivienda: " + auxiliar);

    System.out.println("\ncalcula la Suma de los Gastos de Administración y de Operación total");
    auxiliar = estados.gastosAdmonTotal();
    System.out.println("Suma de los Gastos de Administración y de Operación total: " + auxiliar);

    System.out.println("\ncalcula el Porcentaje de valor total del gasto de admon y operacion");
    auxiliar = estados.gastosAdmonOperacionTotalPor();
    System.out.println("valor total del gasto de admon y operacion porcentaje: " + auxiliar);

    System.out.println("\ncalcula la Utilidad Antes de Financieros por Vivienda");
    auxiliar = estados.utilidadFinancierosVivienda();
    System.out.println("Utilidad Antes de Financieros por Vivienda: " + auxiliar);

    System.out.println("\ncalcula la Utilidad Antes de Financieros Total");
    auxiliar = estados.utilidadFinancierosTotal();
    System.out.println("Utilidad Antes de Financieros Total: " + auxiliar);

    System.out.println("\ncalcula el Porcentaje de la Utilidad Antes de Financieros Total");
    auxiliar = estados.utilidadFinancierosTotalPor();
    System.out.println("Utilidad Antes de Financieros Total: " + auxiliar);


    System.out.println("\n\nMODULO DE GASTOS FINANCIEROS");

    System.out.println("\ncalcula la Suma de los Totales de Apertura de Credito, Seguro, Fianzas, Notariales, Sup. de Obra y Admon. de Recursos");
    auxiliar = estados.aperturaCreditoSeguroFianzasTotal();
    System.out.println("Suma de los Totales de Apertura de Credito, Seguro, Fianzas, Notariales, Sup. de Obra y Admon. de Recursos: " + auxiliar);

    System.out.println("\ncalcula la Suma de los Gastos Financieros por Vivienda");
    auxiliar = estados.gastosFinancierosVivienda();
    System.out.println("Suma de los Gastos Financieros por Vivienda:" + auxiliar);

    System.out.println("\ncalcula la Suma de los Gastos Financieros Total");
    auxiliar = estados.gastosFinancierosTotal();
    System.out.println("Suma de los Gastos Financieros total:" + auxiliar);

    System.out.println("\ncalcula el porcentaje de la Suma de los Gastos Financieros Total");
    auxiliar = estados.gastosFinancierosTotalPor();
    System.out.println("Suma de los Gastos Financieros total porcentaje:" + auxiliar);

    System.out.println("\ncalcula la Utilidad Impuestos por Vivienda");
    auxiliar = estados.utilidadImpuestosVivienda();
    System.out.println("Utilidad Impuestos por Vivienda: " + auxiliar);

    System.out.println("\ncalcula la Utilidad Impuestos Total");
    auxiliar = estados.utilidadImpuestosTotal();
    System.out.println("Utilidad Impuestos por total: " + auxiliar);

    System.out.println("\ncalcula el porcentaje de la Utilidad Impuestos Total");
    auxiliar = estados.utilidadImpuestosTotalPor();
    System.out.println("Utilidad Impuestos por total porcentaje: " + auxiliar);

    //EMPIEZAN LOS PORCENTAJES DE COSTO
    System.out.println("\n\nPORCENTAJES DE COSTO");
    System.out.println("\nESTE ES UN AUXILIAR calcula la Suma de Costos y Gastos de Venta, Admon. Operación y Financieros Totales: " + estados.costosGastosTotales());

    System.out.println("\ncalcula el Porcentaje Costos del valor total del costo de venta");
    auxiliar = estados.costosVentasTotalPorCostos();
    System.out.println("Porcentaje Costos del valor total del costo de venta: " + auxiliar);

    System.out.println("\ncalcula el Porcentaje Costo de valor total del gasto de venta");
    auxiliar = estados.gastosVentasTotalPorCosto();
    System.out.println("el Porcentaje Costo de valor total del gasto de venta: " + auxiliar);

    System.out.println("\ncalcula el Porcentaje Costo de valor total del gasto de admon y operacion");
    auxiliar = estados.gastosAdmonOperacionTotalPorCosto();
    System.out.println("el Porcentaje Costo de valor total del gasto de admon y operacion: " + auxiliar);

    System.out.println("\ncalcula el Porcentaje Costo de la Suma de los Gastos Financieros Total");
    auxiliar = estados.gastosFinancierosTotalPorCosto();
    System.out.println("el Porcentaje Costo de la Suma de los Gastos Financieros Total: " + auxiliar);
  }
}
