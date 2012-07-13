package Beans.Proyecto.Pantallas;

import Beans.Bean;
import calculador.proyecto.ElementosVentas;
import java.io.Serializable;
import java.util.LinkedList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.CeldaFechaValor;
import util.Funciones;

/**
 *
 * @author RUMA
 */
public class modeloGeneradores extends Bean implements Serializable {

  private String pry_val_com_ter_imp_viv;
  private String pry_val_tot_con_imp_tot;
  private String pry_val_tot_con_imp_viv;
  private String pry_esc_ava_fid_isr_imp_tot;
  private String pry_esc_ava_fid_isr_imp_viv;
  private String pry_adm_fid_imp_viv;
  private String pry_imp_tot_ter_esc;
  private String pry_pro_arq_imp_tot;
  private String pry_pro_arq_imp_viv;
  private String pry_dro_fir_imp_tot;
  private String pry_dro_fir_imp_viv;
  private String pry_cal_est_ins_imp_tot;
  private String pry_cal_est_ins_imp_viv;
  private String pry_mec_sue_top_imp_tot;
  private String pry_mec_sue_top_imp_viv;
  private String pry_imp_tot_pro;
  private String pry_ges_vec_ter_imp_tot;
  private String pry_ges_vec_ter_imp_viv;
  private String pry_tram_lic_imp_tot;
  private String pry_tram_lic_imp_viv;
  private String pry_con_vec_imp_tot;
  private String pry_con_vec_imp_viv;
  private String pry_poz_agu_imp_tot;
  private String pry_poz_agu_imp_viv;
  private String pry_sol_pre_luz_fue_imp_tot;
  private String pry_sol_pre_luz_fue_imp_viv;
  private String pry_reg_pro_con_imp_tot;
  private String pry_reg_pro_con_imp_viv;
  private String pry_imp_tot_tra_lic_der;
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
  private String pry_sup_obr_imp_viv;
  private String pry_inf_imp_viv;
  private String pry_com_ven_imp_tot;
  private String pry_com_ven_imp_viv;
  private String pry_com_ven_con_imp_tot;
  private String pry_com_ven_con_imp_viv;
  private String pry_com_ven_tit_imp_tot;
  private String pry_com_ven_tit_imp_viv;
  private String pry_pub_cor_imp_tot;
  private String pry_pub_cor_imp_viv;
  private String pry_pub_pro_une_imp_tot;
  private String pry_pub_pro_une_imp_viv;
  private String pry_esc_pro_man_vig_imp_tot;
  private String pry_esc_pro_man_vig_imp_viv;
  private String pry_amu_dec_dep_ofi_imp_tot;
  private String pry_amu_dec_dep_ofi_imp_viv;
  private String pry_imp_tot_ven;
  private String pry_ame_imp_tot;
  private String pry_ame_imp_viv;
  private String pry_otr_2_imp_tot;
  private String pry_otr_2_imp_viv;
  private String pry_otr_3_imp_tot;
  private String pry_otr_3_imp_viv;
  private String pry_imp_tot_otr;
  private String pry_gas_ope_adm_une_imp_tot;
  private String pry_gas_ope_adm_une_imp_viv;
  private String pry_gas_ope_adm_cor_imp_tot;
  private String pry_gas_ope_adm_cor_imp_viv;
  private String pry_cre_pue_sol_imp_tot;
  private String pry_cre_pue_sol_imp_viv;
  private String pry_ape_cre_imp_tot;
  private String pry_ape_cre_imp_viv;
  private String pry_seg_fia_gas_not_imp_tot;
  private String pry_seg_fia_gas_not_imp_viv;
  private String pry_sup_obr_adm_rec_imp_tot;
  private String pry_sup_obr_adm_rec_imp_viv;
  
  private String pry_ant_cre_sol_imp_tot;
  private LinkedList<String> pry_ant_eta_imp_tot;
  private String pry_dis_rec_cre_sol_imp_tot;
  private LinkedList<String> pry_dis_rec_eta_imp_tot;
  private String pry_amo_cre_cre_sol_imp_tot;
  private LinkedList<String> pry_amo_cre_eta_imp_tot;
  private String pry_ant_cre_sol_imp_viv;
  private String pry_dis_rec_cre_sol_imp_viv;
  private String pry_amo_cre_cre_sol_imp_viv;

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
        return pry_adm_fid_imp_viv;
    }

    /**
     * @param pry_adm_fid_imp_viv the pry_adm_fid_imp_viv to set
     */
    public void setPry_adm_fid_imp_viv(String pry_adm_fid_imp_viv) {
        this.pry_adm_fid_imp_viv = pry_adm_fid_imp_viv;
    }

    /**
     * @return the pry_imp_tot_ter_esc
     */
    public String getPry_imp_tot_ter_esc() {
        return Funciones.redondear(pry_imp_tot_ter_esc, 0);
    }

    /**
     * @param pry_imp_tot_ter_esc the pry_imp_tot_ter_esc to set
     */
    public void setPry_imp_tot_ter_esc(String pry_imp_tot_ter_esc) {
        this.pry_imp_tot_ter_esc = pry_imp_tot_ter_esc;
    }

    /**
     * @return the pry_pro_arq_imp_tot
     */
    public String getPry_pro_arq_imp_tot() {
        return Funciones.redondear(pry_pro_arq_imp_tot, 0);
    }

    /**
     * @param pry_pro_arq_imp_tot the pry_pro_arq_imp_tot to set
     */
    public void setPry_pro_arq_imp_tot(String pry_pro_arq_imp_tot) {
        this.pry_pro_arq_imp_tot = pry_pro_arq_imp_tot;
    }

    /**
     * @return the pry_pro_arq_imp_viv
     */
    public String getPry_pro_arq_imp_viv() {
        return Funciones.redondear(pry_pro_arq_imp_viv, 0);
    }

    /**
     * @param pry_pro_arq_imp_viv the pry_pro_arq_imp_viv to set
     */
    public void setPry_pro_arq_imp_viv(String pry_pro_arq_imp_viv) {
        this.pry_pro_arq_imp_viv = pry_pro_arq_imp_viv;
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
     * @return the pry_cal_est_ins_imp_tot
     */
    public String getPry_cal_est_ins_imp_tot() {
        return Funciones.redondear(pry_cal_est_ins_imp_tot, 0);
    }

    /**
     * @param pry_cal_est_ins_imp_tot the pry_cal_est_ins_imp_tot to set
     */
    public void setPry_cal_est_ins_imp_tot(String pry_cal_est_ins_imp_tot) {
        this.pry_cal_est_ins_imp_tot = pry_cal_est_ins_imp_tot;
    }

    /**
     * @return the pry_cal_est_ins_imp_viv
     */
    public String getPry_cal_est_ins_imp_viv() {
        return Funciones.redondear(pry_cal_est_ins_imp_viv, 0);
    }

    /**
     * @param pry_cal_est_ins_imp_viv the pry_cal_est_ins_imp_viv to set
     */
    public void setPry_cal_est_ins_imp_viv(String pry_cal_est_ins_imp_viv) {
        this.pry_cal_est_ins_imp_viv = pry_cal_est_ins_imp_viv;
    }

    /**
     * @return the pry_mec_sue_top_imp_tot
     */
    public String getPry_mec_sue_top_imp_tot() {
        return Funciones.redondear(pry_mec_sue_top_imp_tot, 0);
    }

    /**
     * @param pry_mec_sue_top_imp_tot the pry_mec_sue_top_imp_tot to set
     */
    public void setPry_mec_sue_top_imp_tot(String pry_mec_sue_top_imp_tot) {
        this.pry_mec_sue_top_imp_tot = pry_mec_sue_top_imp_tot;
    }

    /**
     * @return the pry_mec_sue_top_imp_viv
     */
    public String getPry_mec_sue_top_imp_viv() {
        return Funciones.redondear(pry_mec_sue_top_imp_viv, 0);
    }

    /**
     * @param pry_mec_sue_top_imp_viv the pry_mec_sue_top_imp_viv to set
     */
    public void setPry_mec_sue_top_imp_viv(String pry_mec_sue_top_imp_viv) {
        this.pry_mec_sue_top_imp_viv = pry_mec_sue_top_imp_viv;
    }

    /**
     * @return the pry_imp_tot_pro
     */
    public String getPry_imp_tot_pro() {
        return Funciones.redondear(pry_imp_tot_pro, 0);
    }

    /**
     * @param pry_imp_tot_pro the pry_imp_tot_pro to set
     */
    public void setPry_imp_tot_pro(String pry_imp_tot_pro) {
        this.pry_imp_tot_pro = pry_imp_tot_pro;
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
     * @return the pry_tram_lic_imp_tot
     */
    public String getPry_tram_lic_imp_tot() {
        return Funciones.redondear(pry_tram_lic_imp_tot, 0);
    }

    /**
     * @param pry_tram_lic_imp_tot the pry_tram_lic_imp_tot to set
     */
    public void setPry_tram_lic_imp_tot(String pry_tram_lic_imp_tot) {
        this.pry_tram_lic_imp_tot = pry_tram_lic_imp_tot;
    }

    /**
     * @return the pry_tram_lic_imp_viv
     */
    public String getPry_tram_lic_imp_viv() {
        return Funciones.redondear(pry_tram_lic_imp_viv, 0);
    }

    /**
     * @param pry_tram_lic_imp_viv the pry_tram_lic_imp_viv to set
     */
    public void setPry_tram_lic_imp_viv(String pry_tram_lic_imp_viv) {
        this.pry_tram_lic_imp_viv = pry_tram_lic_imp_viv;
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
     * @return the pry_sol_pre_luz_fue_imp_tot
     */
    public String getPry_sol_pre_luz_fue_imp_tot() {
        return Funciones.redondear(pry_sol_pre_luz_fue_imp_tot, 0);
    }

    /**
     * @param pry_sol_pre_luz_fue_imp_tot the pry_sol_pre_luz_fue_imp_tot to set
     */
    public void setPry_sol_pre_luz_fue_imp_tot(String pry_sol_pre_luz_fue_imp_tot) {
        this.pry_sol_pre_luz_fue_imp_tot = pry_sol_pre_luz_fue_imp_tot;
    }

    /**
     * @return the pry_sol_pre_luz_fue_imp_viv
     */
    public String getPry_sol_pre_luz_fue_imp_viv() {
        return Funciones.redondear(pry_sol_pre_luz_fue_imp_viv, 0);
    }

    /**
     * @param pry_sol_pre_luz_fue_imp_viv the pry_sol_pre_luz_fue_imp_viv to set
     */
    public void setPry_sol_pre_luz_fue_imp_viv(String pry_sol_pre_luz_fue_imp_viv) {
        this.pry_sol_pre_luz_fue_imp_viv = pry_sol_pre_luz_fue_imp_viv;
    }

    /**
     * @return the pry_reg_pro_con_imp_tot
     */
    public String getPry_reg_pro_con_imp_tot() {
        return Funciones.redondear(pry_reg_pro_con_imp_tot, 0);
    }

    /**
     * @param pry_reg_pro_con_imp_tot the pry_reg_pro_con_imp_tot to set
     */
    public void setPry_reg_pro_con_imp_tot(String pry_reg_pro_con_imp_tot) {
        this.pry_reg_pro_con_imp_tot = pry_reg_pro_con_imp_tot;
    }

    /**
     * @return the pry_reg_pro_con_imp_viv
     */
    public String getPry_reg_pro_con_imp_viv() {
        return Funciones.redondear(pry_reg_pro_con_imp_viv, 0);
    }

    /**
     * @param pry_reg_pro_con_imp_viv the pry_reg_pro_con_imp_viv to set
     */
    public void setPry_reg_pro_con_imp_viv(String pry_reg_pro_con_imp_viv) {
        this.pry_reg_pro_con_imp_viv = pry_reg_pro_con_imp_viv;
    }

    /**
     * @return the pry_imp_tot_tra_lic_der
     */
    public String getPry_imp_tot_tra_lic_der() {
        return Funciones.redondear(pry_imp_tot_tra_lic_der, 0);
    }

    /**
     * @param pry_imp_tot_tra_lic_der the pry_imp_tot_tra_lic_der to set
     */
    public void setPry_imp_tot_tra_lic_der(String pry_imp_tot_tra_lic_der) {
        this.pry_imp_tot_tra_lic_der = pry_imp_tot_tra_lic_der;
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
     * @return the pry_sup_obr_imp_viv
     */
    public String getPry_sup_obr_imp_viv() {
        return Funciones.redondear(pry_sup_obr_imp_viv, 0);
    }

    /**
     * @param pry_sup_obr_imp_viv the pry_sup_obr_imp_viv to set
     */
    public void setPry_sup_obr_imp_viv(String pry_sup_obr_imp_viv) {
        this.pry_sup_obr_imp_viv = pry_sup_obr_imp_viv;
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
     * @return the pry_com_ven_imp_tot
     */
    public String getPry_com_ven_imp_tot() {
        return Funciones.redondear(pry_com_ven_imp_tot, 0);
    }

    /**
     * @param pry_com_ven_imp_tot the pry_com_ven_imp_tot to set
     */
    public void setPry_com_ven_imp_tot(String pry_com_ven_imp_tot) {
        this.pry_com_ven_imp_tot = pry_com_ven_imp_tot;
    }

    /**
     * @return the pry_com_ven_imp_viv
     */
    public String getPry_com_ven_imp_viv() {
        return Funciones.redondear(pry_com_ven_imp_viv, 0);
    }

    /**
     * @param pry_com_ven_imp_viv the pry_com_ven_imp_viv to set
     */
    public void setPry_com_ven_imp_viv(String pry_com_ven_imp_viv) {
        this.pry_com_ven_imp_viv = pry_com_ven_imp_viv;
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
     * @return the pry_imp_tot_ven
     */
    public String getPry_imp_tot_ven() {
        return Funciones.redondear(pry_imp_tot_ven, 0);
    }

    /**
     * @param pry_imp_tot_ven the pry_imp_tot_ven to set
     */
    public void setPry_imp_tot_ven(String pry_imp_tot_ven) {
        this.pry_imp_tot_ven = pry_imp_tot_ven;
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
     * @return the pry_imp_tot_otr
     */
    public String getPry_imp_tot_otr() {
        return Funciones.redondear(pry_imp_tot_otr, 0);
    }

    /**
     * @param pry_imp_tot_otr the pry_imp_tot_otr to set
     */
    public void setPry_imp_tot_otr(String pry_imp_tot_otr) {
        this.pry_imp_tot_otr = pry_imp_tot_otr;
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
     * @return the pry_cre_pue_sol_imp_tot
     */
    public String getPry_cre_pue_sol_imp_tot() {
        return Funciones.redondear(pry_cre_pue_sol_imp_tot, 0);
    }

    /**
     * @param pry_cre_pue_sol_imp_tot the pry_cre_pue_sol_imp_tot to set
     */
    public void setPry_cre_pue_sol_imp_tot(String pry_cre_pue_sol_imp_tot) {
        this.pry_cre_pue_sol_imp_tot = pry_cre_pue_sol_imp_tot;
    }

    /**
     * @return the pry_cre_pue_sol_imp_viv
     */
    public String getPry_cre_pue_sol_imp_viv() {
        return Funciones.redondear(pry_cre_pue_sol_imp_viv, 0);
    }

    /**
     * @param pry_cre_pue_sol_imp_viv the pry_cre_pue_sol_imp_viv to set
     */
    public void setPry_cre_pue_sol_imp_viv(String pry_cre_pue_sol_imp_viv) {
        this.pry_cre_pue_sol_imp_viv = pry_cre_pue_sol_imp_viv;
    }

    /**
     * @return the pry_ape_cre_imp_tot
     */
    public String getPry_ape_cre_imp_tot() {
        return Funciones.redondear(pry_ape_cre_imp_tot, 0);
    }

    /**
     * @param pry_ape_cre_imp_tot the pry_ape_cre_imp_tot to set
     */
    public void setPry_ape_cre_imp_tot(String pry_ape_cre_imp_tot) {
        this.pry_ape_cre_imp_tot = pry_ape_cre_imp_tot;
    }

    /**
     * @return the pry_ape_cre_imp_viv
     */
    public String getPry_ape_cre_imp_viv() {
        return Funciones.redondear(pry_ape_cre_imp_viv, 0);
    }

    /**
     * @param pry_ape_cre_imp_viv the pry_ape_cre_imp_viv to set
     */
    public void setPry_ape_cre_imp_viv(String pry_ape_cre_imp_viv) {
        this.pry_ape_cre_imp_viv = pry_ape_cre_imp_viv;
    }

    /**
     * @return the pry_seg_fia_gas_not_imp_tot
     */
    public String getPry_seg_fia_gas_not_imp_tot() {
        return Funciones.redondear(pry_seg_fia_gas_not_imp_tot, 0);
    }

    /**
     * @param pry_seg_fia_gas_not_imp_tot the pry_seg_fia_gas_not_imp_tot to set
     */
    public void setPry_seg_fia_gas_not_imp_tot(String pry_seg_fia_gas_not_imp_tot) {
        this.pry_seg_fia_gas_not_imp_tot = pry_seg_fia_gas_not_imp_tot;
    }

    /**
     * @return the pry_seg_fia_gas_not_imp_viv
     */
    public String getPry_seg_fia_gas_not_imp_viv() {
        return Funciones.redondear(pry_seg_fia_gas_not_imp_viv, 0);
    }

    /**
     * @param pry_seg_fia_gas_not_imp_viv the pry_seg_fia_gas_not_imp_viv to set
     */
    public void setPry_seg_fia_gas_not_imp_viv(String pry_seg_fia_gas_not_imp_viv) {
        this.pry_seg_fia_gas_not_imp_viv = pry_seg_fia_gas_not_imp_viv;
    }

    /**
     * @return the pry_sup_obr_adm_rec_imp_tot
     */
    public String getPry_sup_obr_adm_rec_imp_tot() {
        return Funciones.redondear(pry_sup_obr_adm_rec_imp_tot, 0);
    }

    /**
     * @param pry_sup_obr_adm_rec_imp_tot the pry_sup_obr_adm_rec_imp_tot to set
     */
    public void setPry_sup_obr_adm_rec_imp_tot(String pry_sup_obr_adm_rec_imp_tot) {
        this.pry_sup_obr_adm_rec_imp_tot = pry_sup_obr_adm_rec_imp_tot;
    }

    /**
     * @return the pry_sup_obr_adm_rec_imp_viv
     */
    public String getPry_sup_obr_adm_rec_imp_viv() {
        return Funciones.redondear(pry_sup_obr_adm_rec_imp_viv, 0);
    }

    /**
     * @param pry_sup_obr_adm_rec_imp_viv the pry_sup_obr_adm_rec_imp_viv to set
     */
    public void setPry_sup_obr_adm_rec_imp_viv(String pry_sup_obr_adm_rec_imp_viv) {
        this.pry_sup_obr_adm_rec_imp_viv = pry_sup_obr_adm_rec_imp_viv;
    }

    /**
     * @return the pry_ant_cre_sol_imp_tot
     */
    public String getPry_ant_cre_sol_imp_tot() {
        return Funciones.redondear(pry_ant_cre_sol_imp_tot, 0);
    }

    /**
     * @param pry_ant_cre_sol_imp_tot the pry_ant_cre_sol_imp_tot to set
     */
    public void setPry_ant_cre_sol_imp_tot(String pry_ant_cre_sol_imp_tot) {
        this.pry_ant_cre_sol_imp_tot = pry_ant_cre_sol_imp_tot;
    }

    /**
     * @return the pry_ant_eta_imp_tot
     */
    public LinkedList<String> getPry_ant_eta_imp_tot() {
        return pry_ant_eta_imp_tot;
    }

    /**
     * @param pry_ant_eta_imp_tot the pry_ant_eta_imp_tot to set
     */
    public void setPry_ant_eta_imp_tot(LinkedList<String> pry_ant_eta_imp_tot) {
        this.pry_ant_eta_imp_tot = pry_ant_eta_imp_tot;
    }

    /**
     * @return the pry_dis_rec_cre_sol_imp_tot
     */
    public String getPry_dis_rec_cre_sol_imp_tot() {
        return Funciones.redondear(pry_dis_rec_cre_sol_imp_tot, 0);
    }

    /**
     * @param pry_dic_rec_cre_sol_imp_tot the pry_dic_rec_cre_sol_imp_tot to set
     */
    public void setPry_dis_rec_cre_sol_imp_tot(String pry_dis_rec_cre_sol_imp_tot) {
        this.pry_dis_rec_cre_sol_imp_tot = pry_dis_rec_cre_sol_imp_tot;
    }

    /**
     * @return the pry_dis_rec_eta_imp_tot
     */
    public LinkedList<String> getPry_dis_rec_eta_imp_tot() {
        return pry_dis_rec_eta_imp_tot;
    }

    /**
     * @param pry_dis_rec_eta_imp_tot the pry_dis_rec_eta_imp_tot to set
     */
    public void setPry_dis_rec_eta_imp_tot(LinkedList<String> pry_dis_rec_eta_imp_tot) {
        this.pry_dis_rec_eta_imp_tot = pry_dis_rec_eta_imp_tot;
    }

    /**
     * @return the pry_amo_cre_cre_sol_imp_tot
     */
    public String getPry_amo_cre_cre_sol_imp_tot() {
        return Funciones.redondear(pry_amo_cre_cre_sol_imp_tot, 0);
    }

    /**
     * @param pry_amo_cre_cre_sol_imp_tot the pry_amo_cre_cre_sol_imp_tot to set
     */
    public void setPry_amo_cre_cre_sol_imp_tot(String pry_amo_cre_cre_sol_imp_tot) {
        this.pry_amo_cre_cre_sol_imp_tot = pry_amo_cre_cre_sol_imp_tot;
    }

    /**
     * @return the pry_amo_cre_eta_imp_tot
     */
    public LinkedList<String> getPry_amo_cre_eta_imp_tot() {
        return pry_amo_cre_eta_imp_tot;
    }

    /**
     * @param pry_amo_cre_eta_imp_tot the pry_amo_cre_eta_imp_tot to set
     */
    public void setPry_amo_cre_eta_imp_tot(LinkedList<String> pry_amo_cre_eta_imp_tot) {
        this.pry_amo_cre_eta_imp_tot = pry_amo_cre_eta_imp_tot;
    }

    /**
     * @return the pry_ant_cre_sol_imp_viv
     */
    public String getPry_ant_cre_sol_imp_viv() {
        return Funciones.redondear(pry_ant_cre_sol_imp_viv, 0);
    }

    /**
     * @param pry_ant_cre_sol_imp_viv the pry_ant_cre_sol_imp_viv to set
     */
    public void setPry_ant_cre_sol_imp_viv(String pry_ant_cre_sol_imp_viv) {
        this.pry_ant_cre_sol_imp_viv = pry_ant_cre_sol_imp_viv;
    }

    /**
     * @return the pry_dis_rec_cre_sol_imp_viv
     */
    public String getPry_dis_rec_cre_sol_imp_viv() {
        return Funciones.redondear(pry_dis_rec_cre_sol_imp_viv, 0);
    }

    /**
     * @param pry_dis_rec_cre_sol_imp_viv the pry_dis_rec_cre_sol_imp_viv to set
     */
    public void setPry_dis_rec_cre_sol_imp_viv(String pry_dis_rec_cre_sol_imp_viv) {
        this.pry_dis_rec_cre_sol_imp_viv = pry_dis_rec_cre_sol_imp_viv;
    }

    /**
     * @return the pry_amo_cre_cre_sol_imp_viv
     */
    public String getPry_amo_cre_cre_sol_imp_viv() {
        return Funciones.redondear(pry_amo_cre_cre_sol_imp_viv, 0);
    }

    /**
     * @param pry_amo_cre_cre_sol_imp_viv the pry_amo_cre_cre_sol_imp_viv to set
     */
    public void setPry_amo_cre_cre_sol_imp_viv(String pry_amo_cre_cre_sol_imp_viv) {
        this.pry_amo_cre_cre_sol_imp_viv = pry_amo_cre_cre_sol_imp_viv;
    }

}
