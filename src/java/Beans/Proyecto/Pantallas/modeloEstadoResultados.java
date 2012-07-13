/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.Proyecto.Pantallas;

import Beans.Bean;
import calculador.proyecto.ElementosVentas;
import java.io.Serializable;
import java.util.LinkedList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.Funciones;

/**
 *
 * @author RUMA
 */
public class modeloEstadoResultados extends Bean implements Serializable{

  private String pry_val_com_ter_imp_viv;
  private String pry_val_tot_con_imp_viv;
  private String pry_esc_ava_fid_isr_imp_viv;
  private String pry_adm_fid_imp_viv;
  private String pry_pro_est_viv;
  private String pry_dro_fir_imp_viv;
  private String pry_tra_lic_der_viv;
  private String pry_ges_vec_ter_imp_viv;
  private String pry_con_vec_imp_viv;
  private String pry_edi_cas_imp_viv;
  private String pry_urb_imp_viv;
  private String pry_urb_acc_imp_viv;
  private String pry_edi_dep_imp_viv;
  private String pry_are_ext_imp_viv;
  private String pry_gas_gen_imp_viv;
  private String pry_imp_imp_viv;
  private String pry_obl_pat_imp_viv;
  private String pry_paq_aca_imp_viv;
  private String pry_man_vig_esc_imp_viv;
  private String pry_inf_imp_viv;
  private String pry_ame_imp_viv;
  private String pry_otr_2_imp_viv;
  private String pry_otr_3_imp_viv;
  private String pry_cost_tot_ven_viv;
  private String pry_utl_bru_viv;
  private String pry_val_ter;
  private String pry_val_tot_con_imp_tot;
  private String pry_esc_ava_fid_isr_imp_tot;  
  private String pry_adm_fid_imp_tot;
  private String pry_pro_est_tot;
  private String pry_dro_fir_imp_tot;
  private String pry_tra_lic_der_tot;
  private String pry_ges_vec_ter_imp_tot;
  private String pry_con_vec_imp_tot;
  private String pry_edi_cas_mon;
  private String pry_urb_mon;
  private String pry_urb_acc_mon;
  private String pry_edi_depto_mon;
  private String pry_orn_mon;
  private String pry_gts_gral_mon;
  private String pry_imp_mon;
  private String pry_obl_pat_mon;
  private String pry_paq_aca_mon;
  private String pry_man_vig_esc_mon;
  private String pry_inf_mon;
  private String pry_ame_imp_tot;
  private String pry_otr_2_imp_tot;
  private String pry_otr_3_imp_tot;
  private String pry_total_cost_ven_tot;
  private String pry_utl_bru_tot;
  private String pry_por_val_ter;
  private String pry_por_val_tot_con_imp_tot;
  private String pry_por_esc_ava_fid_isr_imp_tot;
  private String pry_por_adm_fid_imp_tot;  
  private String pry_por_pro_est_tot;
  private String pry_por_dro_fir_imp_tot;
  private String pry_por_tra_lic_der_tot;
  private String pry_por_con_vec_imp_tot;
  private String pry_por_poz_agu_imp_tot;
  private String pry_por_ges_vec_ter_imp_tot;
  private String pry_por_edi_cas_mon;
  private String pry_por_urb_mon;
  private String pry_por_urb_acc_mon;
  private String pry_por_edi_depto_mon;
  private String pry_por_orn_mon;
  private String pry_por_gts_gral_mon;
  private String pry_por_imp_mon;
  private String pry_por_obl_pat_mon;
  private String pry_por_paq_aca_mon;
  private String pry_por_man_vig_esc_mon;
  private String pry_por_infra_mon;
  private String pry_por_ame_imp_tot;
  private String pry_por_otr_2_imp_tot;
  private String pry_por_otr_3_imp_tot;
  private String pry_por_total_cost_ven_tot;
  private String pry_por_utl_bru_tot;
  private String pry_por_cto_val_ter;
  private String pry_por_cto_val_tot_con_imp_tot;
  private String pry_por_cto_esc_ava_fid_isr_imp_tot;
  private String pry_por_cto_adm_fid_imp_tot;
  private String pry_por_cto_pro_est_tot;
  private String pry_por_cto_dro_fir_imp_tot;
  private String pry_por_cto_tra_lic_der_tot;
  private String pry_por_cto_con_vec_imp_tot;
  private String pry_por_cto_poz_agu_imp_tot;
  private String pry_por_cto_ges_vec_ter_imp_tot;
  private String pry_por_cto_edi_cas_mon;
  private String pry_por_cto_urb_mon;
  private String pry_por_cto_urb_acc_mon;
  private String pry_por_cto_edi_depto_mon;
  private String pry_por_cto_orn_mon;
  private String pry_por_cto_gts_gral_mon;
  private String pry_por_cto_imp_mon;
  private String pry_por_cto_obl_pat_mon;
  private String pry_por_cto_paq_aca_mon;
  private String pry_por_cto_man_vig_esc_mon;
  private String pry_por_cto_infra_mon;
  private String pry_por_cto_ame_imp_tot;
  private String pry_por_cto_otr_2_imp_tot;
  private String pry_por_cto_otr_3_imp_tot;
  private String pry_por_cto_total_cost_ven_tot;
  private String pry_com_ven_con_imp_viv;
  private String pry_com_ven_tit_imp_viv;
  private String pry_pub_cor_imp_viv;
  private String pry_pub_pro_une_imp_viv;
  private String pry_amu_dec_dep_ofi_imp_viv;
  private String pry_gtos_ven_viv;
  private String pry_com_ven_con_imp_tot;
  private String pry_com_ven_tit_imp_tot;
  private String pry_pub_cor_imp_tot;
  private String pry_pub_pro_une_imp_tot;
  private String pry_amu_dec_dep_ofi_imp_tot;
  private String pry_gtos_ven_tot;
  private String pry_por_com_ven_con_imp_tot;
  private String pry_por_com_ven_tit_imp_tot;
  private String pry_por_pub_cor_imp_tot;
  private String pry_por_pub_pro_une_imp_tot;
  private String pry_por_esc_pro_man_vig_imp_tot;
  private String pry_por_amu_dec_dep_ofi_imp_tot;
  private String pry_por_gtos_ven_tot;
  private String pry_por_cto_com_ven_con_imp_tot;
  private String pry_por_cto_com_ven_tit_imp_tot;
  private String pry_por_cto_pub_cor_imp_tot;
  private String pry_por_cto_pub_pro_une_imp_tot;
  private String pry_por_cto_esc_pro_man_vig_imp_tot;
  private String pry_por_cto_amu_dec_dep_ofi_imp_tot;
  private String pry_por_cto_gtos_ven_tot;
  private String pry_gas_ope_adm_une_imp_viv;
  private String pry_gas_ope_adm_cor_imp_viv;
  private String pry_gtos_ope_adm_viv;
  private String pry_utl_ant_fin_viv;
  private String pry_gas_ope_adm_une_imp_tot;
  private String pry_gas_ope_adm_cor_imp_tot;
  private String pry_gtos_ope_adm_tot;
  private String pry_utl_ant_fin_tot;
  private String pry_por_gas_ope_adm_une_imp_tot;
  private String pry_por_gas_ope_adm_cor_imp_tot;
  private String pry_por_gtos_ope_adm_tot;
  private String pry_por_utl_ant_fin_tot;
  private String pry_por_cto_gas_ope_adm_une_imp_tot;
  private String pry_por_cto_gas_ope_adm_cor_imp_tot;
  private String pry_por_cto_gtos_ope_adm_tot;
  private String pry_cad_pro_cos_fin_alt_viv;
  private String pry_ape_fia_not_adm_viv;
  private String pry_int_cre_viv;
  private String pry_gtos_fin_viv;
  private String pry_utl_ant_imp_viv;
  private String pry_cad_pro_cos_fin_alt_tot;
  private String pry_int_cre_tot;
  private String pry_gtos_fin_tot;
  private String pry_utl_ant_imp_tot;
  private String pry_por_cad_pro_cos_fin_alt_tot;
  private String pry_por_ape_fia_not_adm_tot;
  private String pry_por_int_cre_tot;
  private String pry_por_gas_fin_tot;
  private String pry_por_cto_cad_pro_cos_fin_alt_tot;
  private String pry_por_cto_ape_fia_not_adm_tot;
  private String pry_por_cto_int_cre_tot;
  private String pry_por_cto_gas_fin_tot;
  private String pry_ape_fia_not_adm_tot;
  private String pry_por_utl_ant_imp_tot;
  private String pry_poz_agu_imp_viv; 
  private String pry_poz_agu_imp_tot;
  private String pry_esc_pro_man_vig_imp_viv;
  private String pry_esc_pro_man_vig_imp_tot;
  
  /**
   * @return the pry_val_com_ter_imp_viv
   */
  public String getPry_val_com_ter_imp_viv() {
    return Funciones.redondear(pry_val_com_ter_imp_viv, 0);
  }

  /**
   * @param pry_val_com_ter_imp_viv the pry_val_com_ter_imp_viv to set
   */
  public void setPry_val_com_ter_imp_viv(String pry_val_com_ter_imp_viv) {
    this.pry_val_com_ter_imp_viv = pry_val_com_ter_imp_viv;
  }

  /**
   * @return the pry_val_tot_con_imp_viv
   */
  public String getPry_val_tot_con_imp_viv() {
    return Funciones.redondear(pry_val_tot_con_imp_viv, 0);
  }

  /**
   * @param pry_val_tot_con_imp_viv the pry_val_tot_con_imp_viv to set
   */
  public void setPry_val_tot_con_imp_viv(String pry_val_tot_con_imp_viv) {
    this.pry_val_tot_con_imp_viv = pry_val_tot_con_imp_viv;
  }

  /**
   * @return the pry_esc_ava_fid_isr_imp_viv
   */
  public String getPry_esc_ava_fid_isr_imp_viv() {
    return Funciones.redondear(pry_esc_ava_fid_isr_imp_viv, 0);
  }

  /**
   * @param pry_esc_ava_fid_isr_imp_viv the pry_esc_ava_fid_isr_imp_viv to set
   */
  public void setPry_esc_ava_fid_isr_imp_viv(String pry_esc_ava_fid_isr_imp_viv) {
    this.pry_esc_ava_fid_isr_imp_viv = pry_esc_ava_fid_isr_imp_viv;
  }

  /**
   * @return the pry_adm_fid_imp_viv
   */
  public String getPry_adm_fid_imp_viv() {
    return Funciones.redondear(pry_adm_fid_imp_viv, 0);
  }

  /**
   * @param pry_adm_fid_imp_viv the pry_adm_fid_imp_viv to set
   */
  public void setPry_adm_fid_imp_viv(String pry_adm_fid_imp_viv) {
    this.pry_adm_fid_imp_viv = pry_adm_fid_imp_viv;
  }

  /**
   * @return the pry_pro_est_viv
   */
  public String getPry_pro_est_viv() {
    return Funciones.redondear(pry_pro_est_viv, 0);
  }

  /**
   * @param pry_pro_est_viv the pry_por_est_viv to set
   */
  public void setPry_pro_est_viv(String pry_pro_est_viv) {
    this.pry_pro_est_viv = pry_pro_est_viv;
  }

  /**
   * @return the pry_dro_fir_imp_viv
   */
  public String getPry_dro_fir_imp_viv() {
    return Funciones.redondear(pry_dro_fir_imp_viv, 0);
  }

  /**
   * @param pry_dro_fir_imp_viv the pry_dro_fir_imp_viv to set
   */
  public void setPry_dro_fir_imp_viv(String pry_dro_fir_imp_viv) {
    this.pry_dro_fir_imp_viv = pry_dro_fir_imp_viv;
  }

  /**
   * @return the pry_tra_lic_der_viv
   */
  public String getPry_tra_lic_der_viv() {
    return Funciones.redondear(pry_tra_lic_der_viv, 0);
  }

  /**
   * @param pry_tra_lic_der_viv the pry_tra_lic_der_viv to set
   */
  public void setPry_tra_lic_der_viv(String pry_tra_lic_der_viv) {
    this.pry_tra_lic_der_viv = pry_tra_lic_der_viv;
  }

  /**
   * @return the pry_ges_vec_ter_imp_viv
   */
  public String getPry_ges_vec_ter_imp_viv() {
    return Funciones.redondear(pry_ges_vec_ter_imp_viv, 0);
  }

  /**
   * @param pry_ges_vec_ter_imp_viv the pry_ges_vec_ter_imp_viv to set
   */
  public void setPry_ges_vec_ter_imp_viv(String pry_ges_vec_ter_imp_viv) {
    this.pry_ges_vec_ter_imp_viv = pry_ges_vec_ter_imp_viv;
  }

  /**
   * @return the pry_con_vec_imp_viv
   */
  public String getPry_con_vec_imp_viv() {
    return Funciones.redondear(pry_con_vec_imp_viv, 0);
  }

  /**
   * @param pry_con_vec_imp_viv the pry_con_vec_imp_viv to set
   */
  public void setPry_con_vec_imp_viv(String pry_con_vec_imp_viv) {
    this.pry_con_vec_imp_viv = pry_con_vec_imp_viv;
  }

  /**
   * @return the pry_edi_cas_imp_viv
   */
  public String getPry_edi_cas_imp_viv() {
    return Funciones.redondear(pry_edi_cas_imp_viv, 0);
  }

  /**
   * @param pry_edi_cas_imp_viv the pry_edi_cas_imp_viv to set
   */
  public void setPry_edi_cas_imp_viv(String pry_edi_cas_imp_viv) {
    this.pry_edi_cas_imp_viv = pry_edi_cas_imp_viv;
  }

  /**
   * @return the pry_urb_imp_viv
   */
  public String getPry_urb_imp_viv() {
    return Funciones.redondear(pry_urb_imp_viv, 0);
  }

  /**
   * @param pry_urb_imp_viv the pry_urb_imp_viv to set
   */
  public void setPry_urb_imp_viv(String pry_urb_imp_viv) {
    this.pry_urb_imp_viv = pry_urb_imp_viv;
  }

  /**
   * @return the pry_urb_acc_imp_viv
   */
  public String getPry_urb_acc_imp_viv() {
    return Funciones.redondear(pry_urb_acc_imp_viv, 0);
  }

  /**
   * @param pry_urb_acc_imp_viv the pry_urb_acc_imp_viv to set
   */
  public void setPry_urb_acc_imp_viv(String pry_urb_acc_imp_viv) {
    this.pry_urb_acc_imp_viv = pry_urb_acc_imp_viv;
  }

  /**
   * @return the pry_edi_dep_imp_viv
   */
  public String getPry_edi_dep_imp_viv() {
    return Funciones.redondear(pry_edi_dep_imp_viv, 0);
  }

  /**
   * @param pry_edi_dep_imp_viv the pry_edi_dep_imp_viv to set
   */
  public void setPry_edi_dep_imp_viv(String pry_edi_dep_imp_viv) {
    this.pry_edi_dep_imp_viv = pry_edi_dep_imp_viv;
  }

  /**
   * @return the pry_are_ext_imp_viv
   */
  public String getPry_are_ext_imp_viv() {
    return Funciones.redondear(pry_are_ext_imp_viv, 0);
  }

  /**
   * @param pry_are_ext_imp_viv the pry_are_ext_imp_viv to set
   */
  public void setPry_are_ext_imp_viv(String pry_are_ext_imp_viv) {
    this.pry_are_ext_imp_viv = pry_are_ext_imp_viv;
  }

  /**
   * @return the pry_gas_gen_imp_viv
   */
  public String getPry_gas_gen_imp_viv() {
    return Funciones.redondear(pry_gas_gen_imp_viv, 0);
  }

  /**
   * @param pry_gas_gen_imp_viv the pry_gas_gen_imp_viv to set
   */
  public void setPry_gas_gen_imp_viv(String pry_gas_gen_imp_viv) {
    this.pry_gas_gen_imp_viv = pry_gas_gen_imp_viv;
  }

  /**
   * @return the pry_imp_imp_viv
   */
  public String getPry_imp_imp_viv() {
    return Funciones.redondear(pry_imp_imp_viv, 0);
  }

  /**
   * @param pry_imp_imp_viv the pry_imp_imp_viv to set
   */
  public void setPry_imp_imp_viv(String pry_imp_imp_viv) {
    this.pry_imp_imp_viv = pry_imp_imp_viv;
  }

  /**
   * @return the pry_obl_pat_imp_viv
   */
  public String getPry_obl_pat_imp_viv() {
    return Funciones.redondear(pry_obl_pat_imp_viv, 0);
  }

  /**
   * @param pry_obl_pat_imp_viv the pry_obl_pat_imp_viv to set
   */
  public void setPry_obl_pat_imp_viv(String pry_obl_pat_imp_viv) {
    this.pry_obl_pat_imp_viv = pry_obl_pat_imp_viv;
  }

  /**
   * @return the pry_paq_aca_imp_viv
   */
  public String getPry_paq_aca_imp_viv() {
    return Funciones.redondear(pry_paq_aca_imp_viv, 0);
  }

  /**
   * @param pry_paq_aca_imp_viv the pry_paq_aca_imp_viv to set
   */
  public void setPry_paq_aca_imp_viv(String pry_paq_aca_imp_viv) {
    this.pry_paq_aca_imp_viv = pry_paq_aca_imp_viv;
  }

  /**
   * @return the pry_man_vig_esc_imp_viv
   */
  public String getPry_man_vig_esc_imp_viv() {
    return Funciones.redondear(pry_man_vig_esc_imp_viv, 0);
  }

  /**
   * @param pry_man_vig_esc_imp_viv the pry_man_vig_esc_imp_viv to set
   */
  public void setPry_man_vig_esc_imp_viv(String pry_man_vig_esc_imp_viv) {
    this.pry_man_vig_esc_imp_viv = pry_man_vig_esc_imp_viv;
  }

  /**
   * @return the pry_inf_imp_viv
   */
  public String getPry_inf_imp_viv() {
    return Funciones.redondear(pry_inf_imp_viv, 0);
  }

  /**
   * @param pry_inf_imp_viv the pry_inf_imp_viv to set
   */
  public void setPry_inf_imp_viv(String pry_inf_imp_viv) {
    this.pry_inf_imp_viv = pry_inf_imp_viv;
  }

  /**
   * @return the pry_ame_imp_viv
   */
  public String getPry_ame_imp_viv() {
    return Funciones.redondear(pry_ame_imp_viv, 0);
  }

  /**
   * @param pry_ame_imp_viv the pry_ame_imp_viv to set
   */
  public void setPry_ame_imp_viv(String pry_ame_imp_viv) {
    this.pry_ame_imp_viv = pry_ame_imp_viv;
  }

  /**
   * @return the pry_otr_2_imp_viv
   */
  public String getPry_otr_2_imp_viv() {
    return Funciones.redondear(pry_otr_2_imp_viv, 0);
  }

  /**
   * @param pry_otr_2_imp_viv the pry_otr_2_imp_viv to set
   */
  public void setPry_otr_2_imp_viv(String pry_otr_2_imp_viv) {
    this.pry_otr_2_imp_viv = pry_otr_2_imp_viv;
  }

  /**
   * @return the pry_otr_3_imp_viv
   */
  public String getPry_otr_3_imp_viv() {
    return Funciones.redondear(pry_otr_3_imp_viv, 0);
  }

  /**
   * @param pry_otr_3_imp_viv the pry_otr_3_imp_viv to set
   */
  public void setPry_otr_3_imp_viv(String pry_otr_3_imp_viv) {
    this.pry_otr_3_imp_viv = pry_otr_3_imp_viv;
  }

  /**
   * @return the pry_cost_tot_ven_viv
   */
  public String getPry_cost_tot_ven_viv() {
    return Funciones.redondear(pry_cost_tot_ven_viv, 0);
  }

  /**
   * @param pry_cost_tot_ven_viv the pry_cost_tot_ven_viv to set
   */
  public void setPry_cost_tot_ven_viv(String pry_cost_tot_ven_viv) {
    this.pry_cost_tot_ven_viv = pry_cost_tot_ven_viv;
  }

  /**
   * @return the pry_utl_bru_viv
   */
  public String getPry_utl_bru_viv() {
    return Funciones.redondear(pry_utl_bru_viv, 0);
  }

  /**
   * @param pry_utl_bru_viv the pry_utl_bru_viv to set
   */
  public void setPry_utl_bru_viv(String pry_utl_bru_viv) {
    this.pry_utl_bru_viv = pry_utl_bru_viv;
  }

  /**
   * @return the pry_val_ter
   */
  public String getPry_val_ter() {
    return Funciones.redondear(pry_val_ter, 0);
  }

  /**
   * @param pry_val_ter the pry_val_ter to set
   */
  public void setPry_val_ter(String pry_val_ter) {
    this.pry_val_ter = pry_val_ter;
  }

  /**
   * @return the pry_val_tot_con_imp_tot
   */
  public String getPry_val_tot_con_imp_tot() {
    return Funciones.redondear(pry_val_tot_con_imp_tot, 0);
  }

  /**
   * @param pry_val_tot_con_imp_tot the pry_val_tot_con_imp_tot to set
   */
  public void setPry_val_tot_con_imp_tot(String pry_val_tot_con_imp_tot) {
    this.pry_val_tot_con_imp_tot = pry_val_tot_con_imp_tot;
  }

  /**
   * @return the pry_esc_ava_fid_isr_imp_tot
   */
  public String getPry_esc_ava_fid_isr_imp_tot() {
    return Funciones.redondear(pry_esc_ava_fid_isr_imp_tot, 0);
  }

  /**
   * @param pry_esc_ava_fid_isr_imp_tot the pry_esc_ava_fid_isr_imp_tot to set
   */
  public void setPry_esc_ava_fid_isr_imp_tot(String pry_esc_ava_fid_isr_imp_tot) {
    this.pry_esc_ava_fid_isr_imp_tot = pry_esc_ava_fid_isr_imp_tot;
  }

  /**
   * @return the pry_adm_fid_imp_tot
   */
  public String getPry_adm_fid_imp_tot() {
    return Funciones.redondear(pry_adm_fid_imp_tot, 0);
  }

  /**
   * @param pry_adm_fid_imp_tot the pry_adm_fid_imp_tot to set
   */
  public void setPry_adm_fid_imp_tot(String pry_adm_fid_imp_tot) {
    this.pry_adm_fid_imp_tot = pry_adm_fid_imp_tot;
  }

  /**
   * @return the pry_pro_est_tot
   */
  public String getPry_pro_est_tot() {
    return Funciones.redondear(pry_pro_est_tot, 0);
  }

  /**
   * @param pry_pro_est_tot the pry_pro_est_tot to set
   */
  public void setPry_pro_est_tot(String pry_pro_est_tot) {
    this.pry_pro_est_tot = pry_pro_est_tot;
  }

  /**
   * @return the pry_dro_fir_imp_tot
   */
  public String getPry_dro_fir_imp_tot() {
    return Funciones.redondear(pry_dro_fir_imp_tot, 0);
  }

  /**
   * @param pry_dro_fir_imp_tot the pry_dro_fir_imp_tot to set
   */
  public void setPry_dro_fir_imp_tot(String pry_dro_fir_imp_tot) {
    this.pry_dro_fir_imp_tot = pry_dro_fir_imp_tot;
  }

  /**
   * @return the pry_tra_lic_der_tot
   */
  public String getPry_tra_lic_der_tot() {
    return Funciones.redondear(pry_tra_lic_der_tot, 0);
  }

  /**
   * @param pry_tra_lic_der_tot the pry_tra_lic_der_tot to set
   */
  public void setPry_tra_lic_der_tot(String pry_tra_lic_der_tot) {
    this.pry_tra_lic_der_tot = pry_tra_lic_der_tot;
  }

  /**
   * @return the pry_ges_vec_ter_imp_tot
   */
  public String getPry_ges_vec_ter_imp_tot() {
    return Funciones.redondear(pry_ges_vec_ter_imp_tot, 0);
  }

  /**
   * @param pry_ges_vec_ter_imp_tot the pry_ges_vec_ter_imp_tot to set
   */
  public void setPry_ges_vec_ter_imp_tot(String pry_ges_vec_ter_imp_tot) {
    this.pry_ges_vec_ter_imp_tot = pry_ges_vec_ter_imp_tot;
  }

  /**
   * @return the pry_con_vec_imp_tot
   */
  public String getPry_con_vec_imp_tot() {
    return Funciones.redondear(pry_con_vec_imp_tot, 0);
  }

  /**
   * @param pry_con_vec_imp_tot the pry_con_vec_imp_tot to set
   */
  public void setPry_con_vec_imp_tot(String pry_con_vec_imp_tot) {
    this.pry_con_vec_imp_tot = pry_con_vec_imp_tot;
  }

  /**
   * @return the pry_edi_cas_mon
   */
  public String getPry_edi_cas_mon() {
    return Funciones.redondear(pry_edi_cas_mon, 0);
  }

  /**
   * @param pry_edi_cas_mon the pry_edi_cas_mon to set
   */
  public void setPry_edi_cas_mon(String pry_edi_cas_mon) {
    this.pry_edi_cas_mon = pry_edi_cas_mon;
  }

  /**
   * @return the pry_urb_mon
   */
  public String getPry_urb_mon() {
    return Funciones.redondear(pry_urb_mon, 0);
  }

  /**
   * @param pry_urb_mon the pry_urb_mon to set
   */
  public void setPry_urb_mon(String pry_urb_mon) {
    this.pry_urb_mon = pry_urb_mon;
  }

  /**
   * @return the pry_urb_acc_mon
   */
  public String getPry_urb_acc_mon() {
    return Funciones.redondear(pry_urb_acc_mon, 0);
  }

  /**
   * @param pry_urb_acc_mon the pry_urb_acc_mon to set
   */
  public void setPry_urb_acc_mon(String pry_urb_acc_mon) {
    this.pry_urb_acc_mon = pry_urb_acc_mon;
  }

  /**
   * @return the pry_edi_depto_mon
   */
  public String getPry_edi_depto_mon() {
    return Funciones.redondear(pry_edi_depto_mon, 0);
  }

  /**
   * @param pry_edi_depto_mon the pry_edi_depto_mon to set
   */
  public void setPry_edi_depto_mon(String pry_edi_depto_mon) {
    this.pry_edi_depto_mon = pry_edi_depto_mon;
  }

  /**
   * @return the pry_orn_mon
   */
  public String getPry_orn_mon() {
    return Funciones.redondear(pry_orn_mon, 0);
  }

  /**
   * @param pry_orn_mon the pry_orn_mon to set
   */
  public void setPry_orn_mon(String pry_orn_mon) {
    this.pry_orn_mon = pry_orn_mon;
  }

  /**
   * @return the pry_gts_gral_mon
   */
  public String getPry_gts_gral_mon() {
    return Funciones.redondear(pry_gts_gral_mon, 0);
  }

  /**
   * @param pry_gts_gral_mon the pry_gts_gral_mon to set
   */
  public void setPry_gts_gral_mon(String pry_gts_gral_mon) {
    this.pry_gts_gral_mon = pry_gts_gral_mon;
  }

  /**
   * @return the pry_imp_mon
   */
  public String getPry_imp_mon() {
    return Funciones.redondear(pry_imp_mon, 0);
  }

  /**
   * @param pry_imp_mon the pry_imp_mon to set
   */
  public void setPry_imp_mon(String pry_imp_mon) {
    this.pry_imp_mon = pry_imp_mon;
  }

  /**
   * @return the pry_obl_pat_mon
   */
  public String getPry_obl_pat_mon() {
    return Funciones.redondear(pry_obl_pat_mon, 0);
  }

  /**
   * @param pry_obl_pat_mon the pry_obl_pat_mon to set
   */
  public void setPry_obl_pat_mon(String pry_obl_pat_mon) {
    this.pry_obl_pat_mon = pry_obl_pat_mon;
  }

  /**
   * @return the pry_paq_aca_mon
   */
  public String getPry_paq_aca_mon() {
    return Funciones.redondear(pry_paq_aca_mon, 0);
  }

  /**
   * @param pry_paq_aca_mon the pry_paq_aca_mon to set
   */
  public void setPry_paq_aca_mon(String pry_paq_aca_mon) {
    this.pry_paq_aca_mon = pry_paq_aca_mon;
  }

  /**
   * @return the pry_man_vig_esc_mon
   */
  public String getPry_man_vig_esc_mon() {
    return Funciones.redondear(pry_man_vig_esc_mon, 0);
  }

  /**
   * @param pry_man_vig_esc_mon the pry_man_vig_esc_mon to set
   */
  public void setPry_man_vig_esc_mon(String pry_man_vig_esc_mon) {
    this.pry_man_vig_esc_mon = pry_man_vig_esc_mon;
  }

  /**
   * @return the pry_inf_mon
   */
  public String getPry_inf_mon() {
    return Funciones.redondear(pry_inf_mon, 0);
  }

  /**
   * @param pry_inf_mon the pry_inf_mon to set
   */
  public void setPry_inf_mon(String pry_inf_mon) {
    this.pry_inf_mon = pry_inf_mon;
  }

  /**
   * @return the pry_ame_imp_tot
   */
  public String getPry_ame_imp_tot() {
    return Funciones.redondear(pry_ame_imp_tot, 0);
  }

  /**
   * @param pry_ame_imp_tot the pry_ame_imp_tot to set
   */
  public void setPry_ame_imp_tot(String pry_ame_imp_tot) {
    this.pry_ame_imp_tot = pry_ame_imp_tot;
  }

  /**
   * @return the pry_otr_2_imp_tot
   */
  public String getPry_otr_2_imp_tot() {
    return Funciones.redondear(pry_otr_2_imp_tot, 0);
  }

  /**
   * @param pry_otr_2_imp_tot the pry_otr_2_imp_tot to set
   */
  public void setPry_otr_2_imp_tot(String pry_otr_2_imp_tot) {
    this.pry_otr_2_imp_tot = pry_otr_2_imp_tot;
  }

  /**
   * @return the pry_otr_3_imp_tot
   */
  public String getPry_otr_3_imp_tot() {
    return Funciones.redondear(pry_otr_3_imp_tot, 0);
  }

  /**
   * @param pry_otr_3_imp_tot the pry_otr_3_imp_tot to set
   */
  public void setPry_otr_3_imp_tot(String pry_otr_3_imp_tot) {
    this.pry_otr_3_imp_tot = pry_otr_3_imp_tot;
  }

  /**
   * @return the pry_total_cost_ven_tot
   */
  public String getPry_total_cost_ven_tot() {
    return Funciones.redondear(pry_total_cost_ven_tot, 0);
  }

  /**
   * @param pry_total_cost_ven_tot the pry_total_cost_ven_tot to set
   */
  public void setPry_total_cost_ven_tot(String pry_total_cost_ven_tot) {
    this.pry_total_cost_ven_tot = pry_total_cost_ven_tot;
  }

  /**
   * @return the pry_utl_bru_tot
   */
  public String getPry_utl_bru_tot() {
    return Funciones.redondear(pry_utl_bru_tot, 0);
  }

  /**
   * @param pry_bru_tot the pry_bru_tot to set
   */
  public void setPry_utl_bru_tot(String pry_utl_bru_tot) {
    this.pry_utl_bru_tot = pry_utl_bru_tot;
  }

  /**
   * @return the pry_por_val_ter
   */
  public String getPry_por_val_ter() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_val_ter) * 100), 2);
  }

  /**
   * @param pry_por_val_ter the pry_por_val_ter to set
   */
  public void setPry_por_val_ter(String pry_por_val_ter) {
    this.pry_por_val_ter = pry_por_val_ter;
  }

  /**
   * @return the pry_por_val_tot_con_imp_tot
   */
  public String getPry_por_val_tot_con_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_val_tot_con_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_val_tot_con_imp_tot the pry_por_val_tot_con_imp_tot to set
   */
  public void setPry_por_val_tot_con_imp_tot(String pry_por_val_tot_con_imp_tot) {
    this.pry_por_val_tot_con_imp_tot = pry_por_val_tot_con_imp_tot;
  }

  /**
   * @return the pry_por_esc_ava_fid_isr_imp_tot
   */
  public String getPry_por_esc_ava_fid_isr_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_esc_ava_fid_isr_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_esc_ava_fid_isr_imp_tot the pry_por_esc_ava_fid_isr_imp_tot to set
   */
  public void setPry_por_esc_ava_fid_isr_imp_tot(String pry_por_esc_ava_fid_isr_imp_tot) {
    this.pry_por_esc_ava_fid_isr_imp_tot = pry_por_esc_ava_fid_isr_imp_tot;
  }

  /**
   * @return the pry_por_pro_est_tot
   */
  public String getPry_por_pro_est_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_pro_est_tot) * 100), 2);
  }

  /**
   * @param pry_por_pro_est_tot the pry_por_pro_est_tot to set
   */
  public void setPry_por_pro_est_tot(String pry_por_pro_est_tot) {
    this.pry_por_pro_est_tot = pry_por_pro_est_tot;
  }

  /**
   * @return the pry_por_dro_fir_imp_tot
   */
  public String getPry_por_dro_fir_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_dro_fir_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_dro_fir_imp_tot the pry_por_dro_fir_imp_tot to set
   */
  public void setPry_por_dro_fir_imp_tot(String pry_por_dro_fir_imp_tot) {
    this.pry_por_dro_fir_imp_tot = pry_por_dro_fir_imp_tot;
  }

  /**
   * @return the pry_por_tra_lic_der_tot
   */
  public String getPry_por_tra_lic_der_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_tra_lic_der_tot) * 100), 2);
  }

  /**
   * @param pry_por_tra_lic_der_tot the pry_por_tra_lic_der_tot to set
   */
  public void setPry_por_tra_lic_der_tot(String pry_por_tra_lic_der_tot) {
    this.pry_por_tra_lic_der_tot = pry_por_tra_lic_der_tot;
  }

  /**
   * @return the pry_por_con_vec_imp_tot
   */
  public String getPry_por_con_vec_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_con_vec_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_con_vec_imp_tot the pry_por_con_vec_imp_tot to set
   */
  public void setPry_por_con_vec_imp_tot(String pry_por_con_vec_imp_tot) {
    this.pry_por_con_vec_imp_tot = pry_por_con_vec_imp_tot;
  }

  /**
   * @return the pry_por_poz_agu_imp_tot
   */
  public String getPry_por_poz_agu_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_poz_agu_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_poz_agu_imp_tot the pry_por_poz_agu_imp_tot to set
   */
  public void setPry_por_poz_agu_imp_tot(String pry_por_poz_agu_imp_tot) {
    this.pry_por_poz_agu_imp_tot = pry_por_poz_agu_imp_tot;
  }

  /**
   * @return the pry_por_ges_vec_ter_imp_tot
   */
  public String getPry_por_ges_vec_ter_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_ges_vec_ter_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_ges_vec_ter_imp_tot the pry_por_ges_vec_ter_imp_tot to set
   */
  public void setPry_por_ges_vec_ter_imp_tot(String pry_por_ges_vec_ter_imp_tot) {
    this.pry_por_ges_vec_ter_imp_tot = pry_por_ges_vec_ter_imp_tot;
  }

  /**
   * @return the pry_por_edi_cas_mon
   */
  public String getPry_por_edi_cas_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_edi_cas_mon) * 100), 2);
  }

  /**
   * @param pry_por_edi_cas_mon the pry_por_edi_cas_mon to set
   */
  public void setPry_por_edi_cas_mon(String pry_por_edi_cas_mon) {
    this.pry_por_edi_cas_mon = pry_por_edi_cas_mon;
  }

  /**
   * @return the pry_por_urb_mon
   */
  public String getPry_por_urb_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_urb_mon) * 100), 2);
  }

  /**
   * @param pry_por_urb_mon the pry_por_urb_mon to set
   */
  public void setPry_por_urb_mon(String pry_por_urb_mon) {
    this.pry_por_urb_mon = pry_por_urb_mon;
  }

  /**
   * @return the pry_por_urb_acc_mon
   */
  public String getPry_por_urb_acc_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_urb_acc_mon) * 100), 2);
  }

  /**
   * @param pry_por_urb_acc_mon the pry_por_urb_acc_mon to set
   */
  public void setPry_por_urb_acc_mon(String pry_por_urb_acc_mon) {
    this.pry_por_urb_acc_mon = pry_por_urb_acc_mon;
  }

  /**
   * @return the pry_por_edi_depto_mon
   */
  public String getPry_por_edi_depto_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_edi_depto_mon) * 100), 2);
  }

  /**
   * @param pry_por_edi_depto_mon the pry_por_edi_depto_mon to set
   */
  public void setPry_por_edi_depto_mon(String pry_por_edi_depto_mon) {
    this.pry_por_edi_depto_mon = pry_por_edi_depto_mon;
  }

  /**
   * @return the pry_por_orn_mon
   */
  public String getPry_por_orn_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_orn_mon)*100), 2);
  }

  /**
   * @param pry_por_orn_mon the pry_por_orn_mon to set
   */
  public void setPry_por_orn_mon(String pry_por_orn_mon) {
    this.pry_por_orn_mon = pry_por_orn_mon;
  }

  /**
   * @return the pry_por_gts_gral_mon
   */
  public String getPry_por_gts_gral_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_gts_gral_mon) * 100), 2);
  }

  /**
   * @param pry_por_gts_gral_mon the pry_por_gts_gral_mon to set
   */
  public void setPry_por_gts_gral_mon(String pry_por_gts_gral_mon) {
    this.pry_por_gts_gral_mon = pry_por_gts_gral_mon;
  }

  /**
   * @return the pry_por_imp_mon
   */
  public String getPry_por_imp_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_imp_mon) * 100), 2);
  }

  /**
   * @param pry_por_imp_mon the pry_por_imp_mon to set
   */
  public void setPry_por_imp_mon(String pry_por_imp_mon) {
    this.pry_por_imp_mon = pry_por_imp_mon;
  }

  /**
   * @return the pry_por_obl_pat_mon
   */
  public String getPry_por_obl_pat_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_obl_pat_mon) * 100), 2);
  }

  /**
   * @param pry_por_obl_pat_mon the pry_por_obl_pat_mon to set
   */
  public void setPry_por_obl_pat_mon(String pry_por_obl_pat_mon) {
    this.pry_por_obl_pat_mon = pry_por_obl_pat_mon;
  }

  /**
   * @return the pry_por_paq_aca_mon
   */
  public String getPry_por_paq_aca_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_paq_aca_mon) * 100), 2);
  }

  /**
   * @param pry_por_paq_aca_mon the pry_por_paq_aca_mon to set
   */
  public void setPry_por_paq_aca_mon(String pry_por_paq_aca_mon) {
    this.pry_por_paq_aca_mon = pry_por_paq_aca_mon;
  }

  /**
   * @return the pry_por_man_vig_esc_mon
   */
  public String getPry_por_man_vig_esc_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_man_vig_esc_mon) * 100), 2);
  }

  /**
   * @param pry_por_man_vig_esc_mon the pry_por_man_vig_esc_mon to set
   */
  public void setPry_por_man_vig_esc_mon(String pry_por_man_vig_esc_mon) {
    this.pry_por_man_vig_esc_mon = pry_por_man_vig_esc_mon;
  }

  /**
   * @return the pry_por_infra_mon
   */
  public String getPry_por_infra_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_infra_mon) * 100), 2);
  }

  /**
   * @param pry_por_infra_mon the pry_por_infra_mon to set
   */
  public void setPry_por_infra_mon(String pry_por_infra_mon) {
    this.pry_por_infra_mon = pry_por_infra_mon;
  }

  /**
   * @return the pry_por_ame_imp_tot
   */
  public String getPry_por_ame_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_ame_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_ame_imp_tot the pry_por_ame_imp_tot to set
   */
  public void setPry_por_ame_imp_tot(String pry_por_ame_imp_tot) {
    this.pry_por_ame_imp_tot = pry_por_ame_imp_tot;
  }

  /**
   * @return the pry_por_otr_2_imp_tot
   */
  public String getPry_por_otr_2_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_otr_2_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_otr_2_imp_tot the pry_por_otr_2_imp_tot to set
   */
  public void setPry_por_otr_2_imp_tot(String pry_por_otr_2_imp_tot) {
    this.pry_por_otr_2_imp_tot = pry_por_otr_2_imp_tot;
  }

  /**
   * @return the pry_por_otr_3_imp_tot
   */
  public String getPry_por_otr_3_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_otr_3_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_otr_3_imp_tot the pry_por_otr_3_imp_tot to set
   */
  public void setPry_por_otr_3_imp_tot(String pry_por_otr_3_imp_tot) {
    this.pry_por_otr_3_imp_tot = pry_por_otr_3_imp_tot;
  }

  /**
   * @return the pry_por_total_cost_ven_tot
   */
  public String getPry_por_total_cost_ven_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_total_cost_ven_tot) * 100), 2);
  }

  /**
   * @param pry_por_total_cost_ven_tot the pry_por_total_cost_ven_tot to set
   */
  public void setPry_por_total_cost_ven_tot(String pry_por_total_cost_ven_tot) {
    this.pry_por_total_cost_ven_tot = pry_por_total_cost_ven_tot;
  }

  /**
   * @return the pry_por_utl_bru_tot
   */
  public String getPry_por_utl_bru_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_utl_bru_tot) * 100), 2);
  }

  /**
   * @param pry_por_utl_bru_tot the pry_por_utl_bru_tot to set
   */
  public void setPry_por_utl_bru_tot(String pry_por_utl_bru_tot) {
    this.pry_por_utl_bru_tot = pry_por_utl_bru_tot;
  }

  /**
   * @return the pry_por_cto_val_ter
   */
  public String getPry_por_cto_val_ter() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_val_ter) * 100), 2);
  }

  /**
   * @param pry_por_cto_val_ter the pry_por_cto_val_ter to set
   */
  public void setPry_por_cto_val_ter(String pry_por_cto_val_ter) {
    this.pry_por_cto_val_ter = pry_por_cto_val_ter;
  }

  /**
   * @return the pry_por_cto_val_tot_con_imp_tot
   */
  public String getPry_por_cto_val_tot_con_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_val_tot_con_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_val_tot_con_imp_tot the pry_por_cto_val_tot_con_imp_tot to set
   */
  public void setPry_por_cto_val_tot_con_imp_tot(String pry_por_cto_val_tot_con_imp_tot) {
    this.pry_por_cto_val_tot_con_imp_tot = pry_por_cto_val_tot_con_imp_tot;
  }

  /**
   * @return the pry_por_cto_esc_ava_fid_isr_imp_tot
   */
  public String getPry_por_cto_esc_ava_fid_isr_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_esc_ava_fid_isr_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_esc_ava_fid_isr_imp_tot the pry_por_cto_esc_ava_fid_isr_imp_tot to set
   */
  public void setPry_por_cto_esc_ava_fid_isr_imp_tot(String pry_por_cto_esc_ava_fid_isr_imp_tot) {
    this.pry_por_cto_esc_ava_fid_isr_imp_tot = pry_por_cto_esc_ava_fid_isr_imp_tot;
  }

  /**
   * @return the pry_por_cto_pro_est_tot
   */
  public String getPry_por_cto_pro_est_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_pro_est_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_pro_est_tot the pry_por_cto_pro_est_tot to set
   */
  public void setPry_por_cto_pro_est_tot(String pry_por_cto_pro_est_tot) {
    this.pry_por_cto_pro_est_tot = pry_por_cto_pro_est_tot;
  }

  /**
   * @return the pry_por_cto_dro_fir_imp_tot
   */
  public String getPry_por_cto_dro_fir_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_dro_fir_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_dro_fir_imp_tot the pry_por_cto_dro_fir_imp_tot to set
   */
  public void setPry_por_cto_dro_fir_imp_tot(String pry_por_cto_dro_fir_imp_tot) {
    this.pry_por_cto_dro_fir_imp_tot = pry_por_cto_dro_fir_imp_tot;
  }

  /**
   * @return the pry_por_cto_tra_lic_der_tot
   */
  public String getPry_por_cto_tra_lic_der_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_tra_lic_der_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_tra_lic_der_tot the pry_por_cto_tra_lic_der_tot to set
   */
  public void setPry_por_cto_tra_lic_der_tot(String pry_por_cto_tra_lic_der_tot) {
    this.pry_por_cto_tra_lic_der_tot = pry_por_cto_tra_lic_der_tot;
  }

  /**
   * @return the pry_por_cto_con_vec_imp_tot
   */
  public String getPry_por_cto_con_vec_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_con_vec_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_con_vec_imp_tot the pry_por_cto_con_vec_imp_tot to set
   */
  public void setPry_por_cto_con_vec_imp_tot(String pry_por_cto_con_vec_imp_tot) {
    this.pry_por_cto_con_vec_imp_tot = pry_por_cto_con_vec_imp_tot;
  }

  /**
   * @return the pry_por_cto_poz_agu_imp_tot
   */
  public String getPry_por_cto_poz_agu_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_poz_agu_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_poz_agu_imp_tot the pry_por_cto_poz_agu_imp_tot to set
   */
  public void setPry_por_cto_poz_agu_imp_tot(String pry_por_cto_poz_agu_imp_tot) {
    this.pry_por_cto_poz_agu_imp_tot = pry_por_cto_poz_agu_imp_tot;
  }

  /**
   * @return the pry_por_cto_ges_vec_ter_imp_tot
   */
  public String getPry_por_cto_ges_vec_ter_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_ges_vec_ter_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_ges_vec_ter_imp_tot the pry_por_cto_ges_vec_ter_imp_tot to set
   */
  public void setPry_por_cto_ges_vec_ter_imp_tot(String pry_por_cto_ges_vec_ter_imp_tot) {
    this.pry_por_cto_ges_vec_ter_imp_tot = pry_por_cto_ges_vec_ter_imp_tot;
  }

  /**
   * @return the pry_por_cto_edi_cas_mon
   */
  public String getPry_por_cto_edi_cas_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_edi_cas_mon) * 100), 2);
  }

  /**
   * @param pry_por_cto_edi_cas_mon the pry_por_cto_edi_cas_mon to set
   */
  public void setPry_por_cto_edi_cas_mon(String pry_por_cto_edi_cas_mon) {
    this.pry_por_cto_edi_cas_mon = pry_por_cto_edi_cas_mon;
  }

  /**
   * @return the pry_por_cto_urb_mon
   */
  public String getPry_por_cto_urb_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_urb_mon) * 100), 2);
  }

  /**
   * @param pry_por_cto_urb_mon the pry_por_cto_urb_mon to set
   */
  public void setPry_por_cto_urb_mon(String pry_por_cto_urb_mon) {
    this.pry_por_cto_urb_mon = pry_por_cto_urb_mon;
  }

  /**
   * @return the pry_por_cto_urb_acc_mon
   */
  public String getPry_por_cto_urb_acc_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_urb_acc_mon) * 100), 2);
  }

  /**
   * @param pry_por_cto_urb_acc_mon the pry_por_cto_urb_acc_mon to set
   */
  public void setPry_por_cto_urb_acc_mon(String pry_por_cto_urb_acc_mon) {
    this.pry_por_cto_urb_acc_mon = pry_por_cto_urb_acc_mon;
  }

  /**
   * @return the pry_por_cto_edi_depto_mon
   */
  public String getPry_por_cto_edi_depto_mon() {
    return Funciones.redondear(pry_por_cto_edi_depto_mon, 4);
  }

  /**
   * @param pry_por_cto_edi_depto_mon the pry_por_cto_edi_depto_mon to set
   */
  public void setPry_por_cto_edi_depto_mon(String pry_por_cto_edi_depto_mon) {
    this.pry_por_cto_edi_depto_mon = pry_por_cto_edi_depto_mon;
  }

  /**
   * @return the pry_por_cto_orn_mon
   */
  public String getPry_por_cto_orn_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_orn_mon) *100), 2);
  }

  /**
   * @param pry_por_cto_orn_mon the pry_por_cto_orn_mon to set
   */
  public void setPry_por_cto_orn_mon(String pry_por_cto_orn_mon) {
    this.pry_por_cto_orn_mon = pry_por_cto_orn_mon;
  }

  /**
   * @return the pry_por_cto_gts_gral_mon
   */
  public String getPry_por_cto_gts_gral_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_gts_gral_mon)*100), 2);
  }

  /**
   * @param pry_por_cto_gts_gral_mon the pry_por_cto_gts_gral_mon to set
   */
  public void setPry_por_cto_gts_gral_mon(String pry_por_cto_gts_gral_mon) {
    this.pry_por_cto_gts_gral_mon = pry_por_cto_gts_gral_mon;
  }

  /**
   * @return the pry_por_cto_imp_mon
   */
  public String getPry_por_cto_imp_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_imp_mon) * 100 ), 2);
  }

  /**
   * @param pry_por_cto_imp_mon the pry_por_cto_imp_mon to set
   */
  public void setPry_por_cto_imp_mon(String pry_por_cto_imp_mon) {
    this.pry_por_cto_imp_mon = pry_por_cto_imp_mon;
  }

  /**
   * @return the pry_por_cto_obl_pat_mon
   */
  public String getPry_por_cto_obl_pat_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_obl_pat_mon) * 100), 2);
  }

  /**
   * @param pry_por_cto_obl_pat_mon the pry_por_cto_obl_pat_mon to set
   */
  public void setPry_por_cto_obl_pat_mon(String pry_por_cto_obl_pat_mon) {
    this.pry_por_cto_obl_pat_mon = pry_por_cto_obl_pat_mon;
  }

  /**
   * @return the pry_por_cto_paq_aca_mon
   */
  public String getPry_por_cto_paq_aca_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_paq_aca_mon) * 100), 2);
  }

  /**
   * @param pry_por_cto_paq_aca_mon the pry_por_cto_paq_aca_mon to set
   */
  public void setPry_por_cto_paq_aca_mon(String pry_por_cto_paq_aca_mon) {
    this.pry_por_cto_paq_aca_mon = pry_por_cto_paq_aca_mon;
  }

  /**
   * @return the pry_por_cto_man_vig_esc_mon
   */
  public String getPry_por_cto_man_vig_esc_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_man_vig_esc_mon) * 100), 2);
  }

  /**
   * @param pry_por_cto_man_vig_esc_mon the pry_por_cto_man_vig_esc_mon to set
   */
  public void setPry_por_cto_man_vig_esc_mon(String pry_por_cto_man_vig_esc_mon) {
    this.pry_por_cto_man_vig_esc_mon = pry_por_cto_man_vig_esc_mon;
  }

  /**
   * @return the pry_por_cto_infra_mon
   */
  public String getPry_por_cto_infra_mon() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_infra_mon) * 100), 2);
  }

  /**
   * @param pry_por_cto_infra_mon the pry_por_cto_infra_mon to set
   */
  public void setPry_por_cto_infra_mon(String pry_por_cto_infra_mon) {
    this.pry_por_cto_infra_mon = pry_por_cto_infra_mon;
  }

  /**
   * @return the pry_por_cto_ame_imp_tot
   */
  public String getPry_por_cto_ame_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_ame_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_ame_imp_tot the pry_por_cto_ame_imp_tot to set
   */
  public void setPry_por_cto_ame_imp_tot(String pry_por_cto_ame_imp_tot) {
    this.pry_por_cto_ame_imp_tot = pry_por_cto_ame_imp_tot;
  }

  /**
   * @return the pry_por_cto_otr_2_imp_tot
   */
  public String getPry_por_cto_otr_2_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_otr_2_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_otr_2_imp_tot the pry_por_cto_otr_2_imp_tot to set
   */
  public void setPry_por_cto_otr_2_imp_tot(String pry_por_cto_otr_2_imp_tot) {
    this.pry_por_cto_otr_2_imp_tot = pry_por_cto_otr_2_imp_tot;
  }

  /**
   * @return the pry_por_cto_otr_3_imp_tot
   */
  public String getPry_por_cto_otr_3_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_otr_3_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_otr_3_imp_tot the pry_por_cto_otr_3_imp_tot to set
   */
  public void setPry_por_cto_otr_3_imp_tot(String pry_por_cto_otr_3_imp_tot) {
    this.pry_por_cto_otr_3_imp_tot = pry_por_cto_otr_3_imp_tot;
  }

  /**
   * @return the pry_por_cto_total_cost_ven_tot
   */
  public String getPry_por_cto_total_cost_ven_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_total_cost_ven_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_total_cost_ven_tot the pry_por_cto_total_cost_ven_tot to set
   */
  public void setPry_por_cto_total_cost_ven_tot(String pry_por_cto_total_cost_ven_tot) {
    this.pry_por_cto_total_cost_ven_tot = pry_por_cto_total_cost_ven_tot;
  }

  /**
   * @return the pry_com_ven_con_imp_viv
   */
  public String getPry_com_ven_con_imp_viv() {
    return Funciones.redondear(pry_com_ven_con_imp_viv, 0);
  }

  /**
   * @param pry_com_ven_con_imp_viv the pry_com_ven_con_imp_viv to set
   */
  public void setPry_com_ven_con_imp_viv(String pry_com_ven_con_imp_viv) {
    this.pry_com_ven_con_imp_viv = pry_com_ven_con_imp_viv;
  }

  /**
   * @return the pry_com_ven_tit_imp_viv
   */
  public String getPry_com_ven_tit_imp_viv() {
    return Funciones.redondear(pry_com_ven_tit_imp_viv, 0);
  }

  /**
   * @param pry_com_ven_tit_imp_viv the pry_com_ven_tit_imp_viv to set
   */
  public void setPry_com_ven_tit_imp_viv(String pry_com_ven_tit_imp_viv) {
    this.pry_com_ven_tit_imp_viv = pry_com_ven_tit_imp_viv;
  }

  /**
   * @return the pry_pub_cor_imp_viv
   */
  public String getPry_pub_cor_imp_viv() {
    return Funciones.redondear(pry_pub_cor_imp_viv, 0);
  }

  /**
   * @param pry_pub_cor_imp_viv the pry_pub_cor_imp_viv to set
   */
  public void setPry_pub_cor_imp_viv(String pry_pub_cor_imp_viv) {
    this.pry_pub_cor_imp_viv = pry_pub_cor_imp_viv;
  }

  /**
   * @return the pry_pub_pro_une_imp_viv
   */
  public String getPry_pub_pro_une_imp_viv() {
    return Funciones.redondear(pry_pub_pro_une_imp_viv, 0);
  }

  /**
   * @param pry_pub_pro_une_imp_viv the pry_pub_pro_une_imp_viv to set
   */
  public void setPry_pub_pro_une_imp_viv(String pry_pub_pro_une_imp_viv) {
    this.pry_pub_pro_une_imp_viv = pry_pub_pro_une_imp_viv;
  }


  /**
   * @return the pry_amu_dec_dep_ofi_imp_viv
   */
  public String getPry_amu_dec_dep_ofi_imp_viv() {
    return Funciones.redondear(pry_amu_dec_dep_ofi_imp_viv, 0);
  }

  /**
   * @param pry_amu_dec_dep_ofi_imp_viv the pry_amu_dec_dep_ofi_imp_viv to set
   */
  public void setPry_amu_dec_dep_ofi_imp_viv(String pry_amu_dec_dep_ofi_imp_viv) {
    this.pry_amu_dec_dep_ofi_imp_viv = pry_amu_dec_dep_ofi_imp_viv;
  }

  /**
   * @return the pry_gtos_ven_viv
   */
  public String getPry_gtos_ven_viv() {
    return Funciones.redondear(pry_gtos_ven_viv, 0);
  }

  /**
   * @param pry_gtos_ven_viv the pry_gtos_ven_viv to set
   */
  public void setPry_gtos_ven_viv(String pry_gtos_ven_viv) {
    this.pry_gtos_ven_viv = pry_gtos_ven_viv;
  }

  /**
   * @return the pry_com_ven_con_imp_tot
   */
  public String getPry_com_ven_con_imp_tot() {
    return Funciones.redondear(pry_com_ven_con_imp_tot, 0);
  }

  /**
   * @param pry_com_ven_con_imp_tot the pry_com_ven_con_imp_tot to set
   */
  public void setPry_com_ven_con_imp_tot(String pry_com_ven_con_imp_tot) {
    this.pry_com_ven_con_imp_tot = pry_com_ven_con_imp_tot;
  }

  /**
   * @return the pry_com_ven_tit_imp_tot
   */
  public String getPry_com_ven_tit_imp_tot() {
    return Funciones.redondear(pry_com_ven_tit_imp_tot, 0);
  }

  /**
   * @param pry_com_ven_tit_imp_tot the pry_com_ven_tit_imp_tot to set
   */
  public void setPry_com_ven_tit_imp_tot(String pry_com_ven_tit_imp_tot) {
    this.pry_com_ven_tit_imp_tot = pry_com_ven_tit_imp_tot;
  }

  /**
   * @return the pry_pub_cor_imp_tot
   */
  public String getPry_pub_cor_imp_tot() {
    return Funciones.redondear(pry_pub_cor_imp_tot, 0);
  }

  /**
   * @param pry_pub_cor_imp_tot the pry_pub_cor_imp_tot to set
   */
  public void setPry_pub_cor_imp_tot(String pry_pub_cor_imp_tot) {
    this.pry_pub_cor_imp_tot = pry_pub_cor_imp_tot;
  }

  /**
   * @return the pry_pub_pro_une_imp_tot
   */
  public String getPry_pub_pro_une_imp_tot() {
    return Funciones.redondear(pry_pub_pro_une_imp_tot, 0);
  }

  /**
   * @param pry_pub_pro_une_imp_tot the pry_pub_pro_une_imp_tot to set
   */
  public void setPry_pub_pro_une_imp_tot(String pry_pub_pro_une_imp_tot) {
    this.pry_pub_pro_une_imp_tot = pry_pub_pro_une_imp_tot;
  }

  /**
   * @return the pry_amu_dec_dep_ofi_imp_tot
   */
  public String getPry_amu_dec_dep_ofi_imp_tot() {
    return Funciones.redondear(pry_amu_dec_dep_ofi_imp_tot, 0);
  }

  /**
   * @param pry_amu_dec_dep_ofi_imp_tot the pry_amu_dec_dep_ofi_imp_tot to set
   */
  public void setPry_amu_dec_dep_ofi_imp_tot(String pry_amu_dec_dep_ofi_imp_tot) {
    this.pry_amu_dec_dep_ofi_imp_tot = pry_amu_dec_dep_ofi_imp_tot;
  }

  /**
   * @return the pry_gtos_ven_tot
   */
  public String getPry_gtos_ven_tot() {
    return Funciones.redondear(pry_gtos_ven_tot, 0);
  }

  /**
   * @param pry_gtos_ven_tot the pry_gtos_ven_tot to set
   */
  public void setPry_gtos_ven_tot(String pry_gtos_ven_tot) {
    this.pry_gtos_ven_tot = pry_gtos_ven_tot;
  }

  /**
   * @return the pry_por_com_ven_con_imp_tot
   */
  public String getPry_por_com_ven_con_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_com_ven_con_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_com_ven_con_imp_tot the pry_por_com_ven_con_imp_tot to set
   */
  public void setPry_por_com_ven_con_imp_tot(String pry_por_com_ven_con_imp_tot) {
    this.pry_por_com_ven_con_imp_tot = pry_por_com_ven_con_imp_tot;
  }

  /**
   * @return the pry_por_com_ven_tit_imp_tot
   */
  public String getPry_por_com_ven_tit_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_com_ven_tit_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_com_ven_tit_imp_tot the pry_por_com_ven_tit_imp_tot to set
   */
  public void setPry_por_com_ven_tit_imp_tot(String pry_por_com_ven_tit_imp_tot) {
    this.pry_por_com_ven_tit_imp_tot = pry_por_com_ven_tit_imp_tot;
  }

  /**
   * @return the pry_por_pub_cor_imp_tot
   */
  public String getPry_por_pub_cor_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_pub_cor_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_pub_cor_imp_tot the pry_por_pub_cor_imp_tot to set
   */
  public void setPry_por_pub_cor_imp_tot(String pry_por_pub_cor_imp_tot) {
    this.pry_por_pub_cor_imp_tot = pry_por_pub_cor_imp_tot;
  }

  /**
   * @return the pry_por_pub_pro_une_imp_tot
   */
  public String getPry_por_pub_pro_une_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_pub_pro_une_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_pub_pro_une_imp_tot the pry_por_pub_pro_une_imp_tot to set
   */
  public void setPry_por_pub_pro_une_imp_tot(String pry_por_pub_pro_une_imp_tot) {
    this.pry_por_pub_pro_une_imp_tot = pry_por_pub_pro_une_imp_tot;
  }

  /**
   * @return the pry_por_esc_pro_man_vig_imp_tot
   */
  public String getPry_por_esc_pro_man_vig_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_esc_pro_man_vig_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_esc_pro_man_vig_imp_tot the pry_por_esc_pro_man_vig_imp_tot to set
   */
  public void setPry_por_esc_pro_man_vig_imp_tot(String pry_por_esc_pro_man_vig_imp_tot) {
    this.pry_por_esc_pro_man_vig_imp_tot = pry_por_esc_pro_man_vig_imp_tot;
  }

  /**
   * @return the pry_por_amu_dec_dep_ofi_imp_tot
   */
  public String getPry_por_amu_dec_dep_ofi_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_amu_dec_dep_ofi_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_amu_dec_dep_ofi_imp_tot the pry_por_amu_dec_dep_ofi_imp_tot to set
   */
  public void setPry_por_amu_dec_dep_ofi_imp_tot(String pry_por_amu_dec_dep_ofi_imp_tot) {
    this.pry_por_amu_dec_dep_ofi_imp_tot = pry_por_amu_dec_dep_ofi_imp_tot;
  }

  /**
   * @return the pry_por_gtos_ven_tot
   */
  public String getPry_por_gtos_ven_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_gtos_ven_tot) * 100), 2);
  }

  /**
   * @param pry_por_gtos_ven_tot the pry_por_gtos_ven_tot to set
   */
  public void setPry_por_gtos_ven_tot(String pry_por_gtos_ven_tot) {
    this.pry_por_gtos_ven_tot = pry_por_gtos_ven_tot;
  }

  /**
   * @return the pry_por_cto_com_ven_con_imp_tot
   */
  public String getPry_por_cto_com_ven_con_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_com_ven_con_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_com_ven_con_imp_tot the pry_por_cto_com_ven_con_imp_tot to set
   */
  public void setPry_por_cto_com_ven_con_imp_tot(String pry_por_cto_com_ven_con_imp_tot) {
    this.pry_por_cto_com_ven_con_imp_tot = pry_por_cto_com_ven_con_imp_tot;
  }

  /**
   * @return the pry_por_cto_com_ven_tit_imp_tot
   */
  public String getPry_por_cto_com_ven_tit_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_com_ven_tit_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_com_ven_tit_imp_tot the pry_por_cto_com_ven_tit_imp_tot to set
   */
  public void setPry_por_cto_com_ven_tit_imp_tot(String pry_por_cto_com_ven_tit_imp_tot) {
    this.pry_por_cto_com_ven_tit_imp_tot = pry_por_cto_com_ven_tit_imp_tot;
  }

  /**
   * @return the pry_por_cto_pub_cor_imp_tot
   */
  public String getPry_por_cto_pub_cor_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_pub_cor_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_pub_cor_imp_tot the pry_por_cto_pub_cor_imp_tot to set
   */
  public void setPry_por_cto_pub_cor_imp_tot(String pry_por_cto_pub_cor_imp_tot) {
    this.pry_por_cto_pub_cor_imp_tot = pry_por_cto_pub_cor_imp_tot;
  }

  /**
   * @return the pry_por_cto_pub_pro_une_imp_tot
   */
  public String getPry_por_cto_pub_pro_une_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_pub_pro_une_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_pub_pro_une_imp_tot the pry_por_cto_pub_pro_une_imp_tot to set
   */
  public void setPry_por_cto_pub_pro_une_imp_tot(String pry_por_cto_pub_pro_une_imp_tot) {
    this.pry_por_cto_pub_pro_une_imp_tot = pry_por_cto_pub_pro_une_imp_tot;
  }

  /**
   * @return the pry_por_cto_esc_pro_man_vig_imp_tot
   */
  public String getPry_por_cto_esc_pro_man_vig_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_esc_pro_man_vig_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_esc_pro_man_vig_imp_tot the pry_por_cto_esc_pro_man_vig_imp_tot to set
   */
  public void setPry_por_cto_esc_pro_man_vig_imp_tot(String pry_por_cto_esc_pro_man_vig_imp_tot) {
    this.pry_por_cto_esc_pro_man_vig_imp_tot = pry_por_cto_esc_pro_man_vig_imp_tot;
  }

  /**
   * @return the pry_por_cto_amu_dec_dep_ofi_imp_tot
   */
  public String getPry_por_cto_amu_dec_dep_ofi_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_amu_dec_dep_ofi_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_amu_dec_dep_ofi_imp_tot the pry_por_cto_amu_dec_dep_ofi_imp_tot to set
   */
  public void setPry_por_cto_amu_dec_dep_ofi_imp_tot(String pry_por_cto_amu_dec_dep_ofi_imp_tot) {
    this.pry_por_cto_amu_dec_dep_ofi_imp_tot = pry_por_cto_amu_dec_dep_ofi_imp_tot;
  }

  /**
   * @return the pry_por_cto_gtos_ven_tot
   */
  public String getPry_por_cto_gtos_ven_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_gtos_ven_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_gtos_ven_tot the pry_por_cto_gtos_ven_tot to set
   */
  public void setPry_por_cto_gtos_ven_tot(String pry_por_cto_gtos_ven_tot) {
    this.pry_por_cto_gtos_ven_tot = pry_por_cto_gtos_ven_tot;
  }

  /**
   * @return the pry_gas_ope_adm_une_imp_viv
   */
  public String getPry_gas_ope_adm_une_imp_viv() {
    return Funciones.redondear(pry_gas_ope_adm_une_imp_viv, 0);
  }

  /**
   * @param pry_gas_ope_adm_une_imp_viv the pry_gas_ope_adm_une_imp_viv to set
   */
  public void setPry_gas_ope_adm_une_imp_viv(String pry_gas_ope_adm_une_imp_viv) {
    this.pry_gas_ope_adm_une_imp_viv = pry_gas_ope_adm_une_imp_viv;
  }

  /**
   * @return the pry_gas_ope_adm_cor_imp_viv
   */
  public String getPry_gas_ope_adm_cor_imp_viv() {
    return Funciones.redondear(pry_gas_ope_adm_cor_imp_viv, 0);
  }

  /**
   * @param pry_gas_ope_adm_cor_imp_viv the pry_gas_ope_adm_cor_imp_viv to set
   */
  public void setPry_gas_ope_adm_cor_imp_viv(String pry_gas_ope_adm_cor_imp_viv) {
    this.pry_gas_ope_adm_cor_imp_viv = pry_gas_ope_adm_cor_imp_viv;
  }

  /**
   * @return the pry_gtos_ope_adm_viv
   */
  public String getPry_gtos_ope_adm_viv() {
    return Funciones.redondear(pry_gtos_ope_adm_viv, 0);
  }

  /**
   * @param pry_gtos_ope_adm_viv the pry_gtos_ope_adm_viv to set
   */
  public void setPry_gtos_ope_adm_viv(String pry_gtos_ope_adm_viv) {
    this.pry_gtos_ope_adm_viv = pry_gtos_ope_adm_viv;
  }

  /**
   * @return the pry_utl_ant_fin_viv
   */
  public String getPry_utl_ant_fin_viv() {
    return Funciones.redondear(pry_utl_ant_fin_viv, 0);
  }

  /**
   * @param pry_utl_ant_fin_viv the pry_utl_ant_fin_viv to set
   */
  public void setPry_utl_ant_fin_viv(String pry_utl_ant_fin_viv) {
    this.pry_utl_ant_fin_viv = pry_utl_ant_fin_viv;
  }

  /**
   * @return the pry_gas_ope_adm_une_imp_tot
   */
  public String getPry_gas_ope_adm_une_imp_tot() {
    return Funciones.redondear(pry_gas_ope_adm_une_imp_tot, 0);
  }

  /**
   * @param pry_gas_ope_adm_une_imp_tot the pry_gas_ope_adm_une_imp_tot to set
   */
  public void setPry_gas_ope_adm_une_imp_tot(String pry_gas_ope_adm_une_imp_tot) {
    this.pry_gas_ope_adm_une_imp_tot = pry_gas_ope_adm_une_imp_tot;
  }

  /**
   * @return the pry_gas_ope_adm_cor_imp_tot
   */
  public String getPry_gas_ope_adm_cor_imp_tot() {
    return Funciones.redondear(pry_gas_ope_adm_cor_imp_tot, 0);
  }

  /**
   * @param pry_gas_ope_adm_cor_imp_tot the pry_gas_ope_adm_cor_imp_tot to set
   */
  public void setPry_gas_ope_adm_cor_imp_tot(String pry_gas_ope_adm_cor_imp_tot) {
    this.pry_gas_ope_adm_cor_imp_tot = pry_gas_ope_adm_cor_imp_tot;
  }

  /**
   * @return the pry_gtos_ope_adm_tot
   */
  public String getPry_gtos_ope_adm_tot() {
    return Funciones.redondear(pry_gtos_ope_adm_tot, 0);
  }

  /**
   * @param pry_gtos_ope_adm_tot the pry_gtos_ope_adm_tot to set
   */
  public void setPry_gtos_ope_adm_tot(String pry_gtos_ope_adm_tot) {
    this.pry_gtos_ope_adm_tot = pry_gtos_ope_adm_tot;
  }

  /**
   * @return the pry_utl_ant_fin_tot
   */
  public String getPry_utl_ant_fin_tot() {
    return Funciones.redondear(pry_utl_ant_fin_tot, 0);
  }

  /**
   * @param pry_utl_ant_fin_tot the pry_utl_ant_fin_tot to set
   */
  public void setPry_utl_ant_fin_tot(String pry_utl_ant_fin_tot) {
    this.pry_utl_ant_fin_tot = pry_utl_ant_fin_tot;
  }

  /**
   * @return the pry_por_gas_ope_adm_une_imp_tot
   */
  public String getPry_por_gas_ope_adm_une_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_gas_ope_adm_une_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_gas_ope_adm_une_imp_tot the pry_por_gas_ope_adm_une_imp_tot to set
   */
  public void setPry_por_gas_ope_adm_une_imp_tot(String pry_por_gas_ope_adm_une_imp_tot) {
    this.pry_por_gas_ope_adm_une_imp_tot = pry_por_gas_ope_adm_une_imp_tot;
  }

  /**
   * @return the pry_por_gas_ope_adm_cor_imp_tot
   */
  public String getPry_por_gas_ope_adm_cor_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_gas_ope_adm_cor_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_gas_ope_adm_cor_imp_tot the pry_por_gas_ope_adm_cor_imp_tot to set
   */
  public void setPry_por_gas_ope_adm_cor_imp_tot(String pry_por_gas_ope_adm_cor_imp_tot) {
    this.pry_por_gas_ope_adm_cor_imp_tot = pry_por_gas_ope_adm_cor_imp_tot;
  }

  /**
   * @return the pry_por_gtos_ope_adm_tot
   */
  public String getPry_por_gtos_ope_adm_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_gtos_ope_adm_tot) * 100), 2);
  }

  /**
   * @param pry_por_gtos_ope_adm_tot the pry_por_gtos_ope_adm_tot to set
   */
  public void setPry_por_gtos_ope_adm_tot(String pry_por_gtos_ope_adm_tot) {
    this.pry_por_gtos_ope_adm_tot = pry_por_gtos_ope_adm_tot;
  }

  /**
   * @return the pry_por_utl_ant_fin_tot
   */
  public String getPry_por_utl_ant_fin_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_utl_ant_fin_tot) * 100), 2);
  }

  /**
   * @param pry_por_utl_ant_fin_tot the pry_por_utl_ant_fin_tot to set
   */
  public void setPry_por_utl_ant_fin_tot(String pry_por_utl_ant_fin_tot) {
    this.pry_por_utl_ant_fin_tot = pry_por_utl_ant_fin_tot;
  }

  /**
   * @return the pry_por_cto_gas_ope_adm_une_imp_tot
   */
  public String getPry_por_cto_gas_ope_adm_une_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_gas_ope_adm_une_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_gas_ope_adm_une_imp_tot the pry_por_cto_gas_ope_adm_une_imp_tot to set
   */
  public void setPry_por_cto_gas_ope_adm_une_imp_tot(String pry_por_cto_gas_ope_adm_une_imp_tot) {
    this.pry_por_cto_gas_ope_adm_une_imp_tot = pry_por_cto_gas_ope_adm_une_imp_tot;
  }

  /**
   * @return the pry_por_cto_gas_ope_adm_cor_imp_tot
   */
  public String getPry_por_cto_gas_ope_adm_cor_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_gas_ope_adm_cor_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_gas_ope_adm_cor_imp_tot the pry_por_cto_gas_ope_adm_cor_imp_tot to set
   */
  public void setPry_por_cto_gas_ope_adm_cor_imp_tot(String pry_por_cto_gas_ope_adm_cor_imp_tot) {
    this.pry_por_cto_gas_ope_adm_cor_imp_tot = pry_por_cto_gas_ope_adm_cor_imp_tot;
  }

  /**
   * @return the pry_por_cto_gtos_ope_adm_tot
   */
  public String getPry_por_cto_gtos_ope_adm_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_gtos_ope_adm_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_gtos_ope_adm_tot the pry_por_cto_gtos_ope_adm_tot to set
   */
  public void setPry_por_cto_gtos_ope_adm_tot(String pry_por_cto_gtos_ope_adm_tot) {
    this.pry_por_cto_gtos_ope_adm_tot = pry_por_cto_gtos_ope_adm_tot;
  }

  /**
   * @return the pry_cad_pro_cos_fin_alt_viv
   */
  public String getPry_cad_pro_cos_fin_alt_viv() {
    return Funciones.redondear(pry_cad_pro_cos_fin_alt_viv, 0);
  }

  /**
   * @param pry_cad_pro_cos_fin_alt_viv the pry_cad_pro_cos_fin_alt_viv to set
   */
  public void setPry_cad_pro_cos_fin_alt_viv(String pry_cad_pro_cos_fin_alt_viv) {
    this.pry_cad_pro_cos_fin_alt_viv = pry_cad_pro_cos_fin_alt_viv;
  }

  /**
   * @return the pry_ape_fia_not_adm_viv
   */
  public String getPry_ape_fia_not_adm_viv() {
    return Funciones.redondear(pry_ape_fia_not_adm_viv, 0);
  }

  /**
   * @param pry_ape_fia_not_adm_viv the pry_ape_fia_not_adm_viv to set
   */
  public void setPry_ape_fia_not_adm_viv(String pry_ape_fia_not_adm_viv) {
    this.pry_ape_fia_not_adm_viv = pry_ape_fia_not_adm_viv;
  }

  /**
   * @return the pry_int_cre_viv
   */
  public String getPry_int_cre_viv() {
    return Funciones.redondear(pry_int_cre_viv, 0);
  }

  /**
   * @param pry_int_cre_viv the pry_int_cre_viv to set
   */
  public void setPry_int_cre_viv(String pry_int_cre_viv) {
    this.pry_int_cre_viv = pry_int_cre_viv;
  }

  /**
   * @return the pry_gtos_fin_viv
   */
  public String getPry_gtos_fin_viv() {
    return Funciones.redondear(pry_gtos_fin_viv, 0);
  }

  /**
   * @param pry_gtos_fin_viv the pry_gtos_fin_viv to set
   */
  public void setPry_gtos_fin_viv(String pry_gtos_fin_viv) {
    this.pry_gtos_fin_viv = pry_gtos_fin_viv;
  }

  /**
   * @return the pry_utl_ant_imp_viv
   */
  public String getPry_utl_ant_imp_viv() {
    return Funciones.redondear(pry_utl_ant_imp_viv, 0);
  }

  /**
   * @param pry_utl_ant_imp_viv the pry_utl_ant_imp_viv to set
   */
  public void setPry_utl_ant_imp_viv(String pry_utl_ant_imp_viv) {
    this.pry_utl_ant_imp_viv = pry_utl_ant_imp_viv;
  }

  ///poner esto entre la linea 286 y 287 de modeloEstadoResultados.xhtml
//  /**
//   * @return the pry_cad_pro_cos_fin_alt_tot
//   */
//  public String getPry_cad_pro_cos_fin_alt_tot() {
//    return Funciones.redondear(pry_cad_pro_cos_fin_alt_tot, 0);
//  }
//
//  /**
//   * @param pry_cad_pro_cos_fin_alt_tot the pry_cad_pro_cos_fin_alt_tot to set
//   */
//  public void setPry_cad_pro_cos_fin_alt_tot(String pry_cad_pro_cos_fin_alt_tot) {
//    this.pry_cad_pro_cos_fin_alt_tot = pry_cad_pro_cos_fin_alt_tot;
//  }

  
  ///poner esto entre la linea 296 y 297 de modeloEstadoResultados.xhtml
//  /**
//   * @return the pry_int_cre_tot
//   */
//  public String getPry_int_cre_tot() {
//    return Funciones.redondear(pry_int_cre_tot, 0);
//  }
//
//  /**
//   * @param pry_int_cre_tot the pry_int_cre_tot to set
//   */
//  public void setPry_int_cre_tot(String pry_int_cre_tot) {
//    this.pry_int_cre_tot = pry_int_cre_tot;
//  }

  /**
   * @return the pry_gtos_fin_tot
   */
  public String getPry_gtos_fin_tot() {
    return Funciones.redondear(pry_gtos_fin_tot, 0);
  }

  /**
   * @param pry_gtos_fin_tot the pry_gtos_fin_tot to set
   */
  public void setPry_gtos_fin_tot(String pry_gtos_fin_tot) {
    this.pry_gtos_fin_tot = pry_gtos_fin_tot;
  }

  /**
   * @return the pry_utl_ant_imp_tot
   */
  public String getPry_utl_ant_imp_tot() {
    return Funciones.redondear(pry_utl_ant_imp_tot, 0);
  }

  /**
   * @param pry_utl_ant_imp_tot the pry_utl_ant_imp_tot to set
   */
  public void setPry_utl_ant_imp_tot(String pry_utl_ant_imp_tot) {
    this.pry_utl_ant_imp_tot = pry_utl_ant_imp_tot;
  }

  /**
   * @return the pry_por_cad_pro_cos_fin_alt_tot
   */
  public String getPry_por_cad_pro_cos_fin_alt_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cad_pro_cos_fin_alt_tot) * 100), 2);
  }

  /**
   * @param pry_por_cad_pro_cos_fin_alt_tot the pry_por_cad_pro_cos_fin_alt_tot to set
   */
  public void setPry_por_cad_pro_cos_fin_alt_tot(String pry_por_cad_pro_cos_fin_alt_tot) {
    this.pry_por_cad_pro_cos_fin_alt_tot = pry_por_cad_pro_cos_fin_alt_tot;
  }

  /**
   * @return the pry_por_ape_fia_not_adm_tot
   */
  public String getPry_por_ape_fia_not_adm_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_ape_fia_not_adm_tot) * 100), 2);
  }

  /**
   * @param pry_por_ape_fia_not_adm_tot the pry_por_ape_fia_not_adm_tot to set
   */
  public void setPry_por_ape_fia_not_adm_tot(String pry_por_ape_fia_not_adm_tot) {
    this.pry_por_ape_fia_not_adm_tot = pry_por_ape_fia_not_adm_tot;
  }

  /**
   * @return the pry_por_int_cre_tot
   */
  public String getPry_por_int_cre_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_int_cre_tot) * 100), 2);
  }

  /**
   * @param pry_por_int_cre_tot the pry_por_int_cre_tot to set
   */
  public void setPry_por_int_cre_tot(String pry_por_int_cre_tot) {
    this.pry_por_int_cre_tot = pry_por_int_cre_tot;
  }

  /**
   * @return the pry_por_gas_fin_tot
   */
  public String getPry_por_gas_fin_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_gas_fin_tot) * 100), 2);
  }

  /**
   * @param pry_por_gas_fin_tot the pry_por_gas_fin_tot to set
   */
  public void setPry_por_gas_fin_tot(String pry_por_gas_fin_tot) {
    this.pry_por_gas_fin_tot = pry_por_gas_fin_tot;
  }

  /**
   * @return the pry_por_cto_cad_pro_cos_fin_alt_tot
   */
  public String getPry_por_cto_cad_pro_cos_fin_alt_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_cad_pro_cos_fin_alt_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_cad_pro_cos_fin_alt_tot the pry_por_cto_cad_pro_cos_fin_alt_tot to set
   */
  public void setPry_por_cto_cad_pro_cos_fin_alt_tot(String pry_por_cto_cad_pro_cos_fin_alt_tot) {
    this.pry_por_cto_cad_pro_cos_fin_alt_tot = pry_por_cto_cad_pro_cos_fin_alt_tot;
  }

  /**
   * @return the pry_por_cto_ape_fia_not_adm_tot
   */
  public String getPry_por_cto_ape_fia_not_adm_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_ape_fia_not_adm_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_ape_fia_not_adm_tot the pry_por_cto_ape_fia_not_adm_tot to set
   */
  public void setPry_por_cto_ape_fia_not_adm_tot(String pry_por_cto_ape_fia_not_adm_tot) {
    this.pry_por_cto_ape_fia_not_adm_tot = pry_por_cto_ape_fia_not_adm_tot;
  }

  /**
   * @return the pry_por_cto_int_cre_tot
   */
  public String getPry_por_cto_int_cre_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_int_cre_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_int_cre_tot the pry_por_cto_int_cre_tot to set
   */
  public void setPry_por_cto_int_cre_tot(String pry_por_cto_int_cre_tot) {
    this.pry_por_cto_int_cre_tot = pry_por_cto_int_cre_tot;
  }

  /**
   * @return the pry_por_cto_gas_fin_tot
   */
  public String getPry_por_cto_gas_fin_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_gas_fin_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_gas_fin_tot the pry_por_cto_gas_fin_tot to set
   */
  public void setPry_por_cto_gas_fin_tot(String pry_por_cto_gas_fin_tot) {
    this.pry_por_cto_gas_fin_tot = pry_por_cto_gas_fin_tot;
  }

  /**
   * @return the pry_por_adm_fid_imp_tot
   */
  public String getPry_por_adm_fid_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_adm_fid_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_adm_fid_imp_tot the pry_por_adm_fid_imp_tot to set
   */
  public void setPry_por_adm_fid_imp_tot(String pry_por_adm_fid_imp_tot) {
    this.pry_por_adm_fid_imp_tot = pry_por_adm_fid_imp_tot;
  }

  /**
   * @return the pry_por_cto_adm_fid_imp_tot
   */
  public String getPry_por_cto_adm_fid_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_cto_adm_fid_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_cto_adm_fid_imp_tot the pry_por_cto_adm_fid_imp_tot to set
   */
  public void setPry_por_cto_adm_fid_imp_tot(String pry_por_cto_adm_fid_imp_tot) {
    this.pry_por_cto_adm_fid_imp_tot = pry_por_cto_adm_fid_imp_tot;
  }

  /**
   * @return the pry_ape_fia_not_adm_tot
   */
  public String getPry_ape_fia_not_adm_tot() {
    return Funciones.redondear(pry_ape_fia_not_adm_tot, 0);
  }

  /**
   * @param pry_ape_fia_not_adm_tot the pry_ape_fia_not_adm_tot to set
   */
  public void setPry_ape_fia_not_adm_tot(String pry_ape_fia_not_adm_tot) {
    this.pry_ape_fia_not_adm_tot = pry_ape_fia_not_adm_tot;
  }

  /**
   * @return the pry_por_utl_ant_imp_tot
   */
  public String getPry_por_utl_ant_imp_tot() {
    return Funciones.redondear(String.valueOf(Double.parseDouble(pry_por_utl_ant_imp_tot) * 100), 2);
  }

  /**
   * @param pry_por_utl_ant_imp_tot the pry_por_utl_ant_imp_tot to set
   */
  public void setPry_por_utl_ant_imp_tot(String pry_por_utl_ant_imp_tot) {
    this.pry_por_utl_ant_imp_tot = pry_por_utl_ant_imp_tot;
  }

  /**
   * @return the pry_poz_agu_imp_viv
   */
  public String getPry_poz_agu_imp_viv() {
    return Funciones.redondear(pry_poz_agu_imp_viv, 0);
  }

  /**
   * @param pry_poz_agu_imp_viv the pry_poz_agu_imp_viv to set
   */
  public void setPry_poz_agu_imp_viv(String pry_poz_agu_imp_viv) {
    this.pry_poz_agu_imp_viv = pry_poz_agu_imp_viv;
  }

  /**
   * @return the pry_poz_agu_imp_tot
   */
  public String getPry_poz_agu_imp_tot() {
    return Funciones.redondear(pry_poz_agu_imp_tot, 0);
  }

  /**
   * @param pry_poz_agu_imp_tot the pry_poz_agu_imp_tot to set
   */
  public void setPry_poz_agu_imp_tot(String pry_poz_agu_imp_tot) {
    this.pry_poz_agu_imp_tot = pry_poz_agu_imp_tot;
  }

  /**
   * @return the pry_esc_pro_man_vig_imp_viv
   */
  public String getPry_esc_pro_man_vig_imp_viv() {
    return Funciones.redondear(pry_esc_pro_man_vig_imp_viv, 0);
  }

  /**
   * @param pry_esc_pro_man_vig_imp_viv the pry_esc_pro_man_vig_imp_viv to set
   */
  public void setPry_esc_pro_man_vig_imp_viv(String pry_esc_pro_man_vig_imp_viv) {
    this.pry_esc_pro_man_vig_imp_viv = pry_esc_pro_man_vig_imp_viv;
  }

  /**
   * @return the pry_esc_pro_man_vig_imp_tot
   */
  public String getPry_esc_pro_man_vig_imp_tot() {
    return Funciones.redondear(pry_esc_pro_man_vig_imp_tot, 0);
  }

  /**
   * @param pry_esc_pro_man_vig_imp_tot the pry_esc_pro_man_vig_imp_tot to set
   */
  public void setPry_esc_pro_man_vig_imp_tot(String pry_esc_pro_man_vig_imp_tot) {
    this.pry_esc_pro_man_vig_imp_tot = pry_esc_pro_man_vig_imp_tot;
  }
}
