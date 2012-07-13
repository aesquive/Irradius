package Beans.Proyecto.Pantallas;

import Beans.Bean;
import java.io.Serializable;
import java.util.LinkedList;
import util.CeldaFechaValor;
import util.Funciones;
import util.MatrizBidimensional;

/**
 *
 * @author RUMA
 */
public class modeloInfoBasica extends Bean implements Serializable {

  private String pry_val_ter;
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
  private String pry_sup_obr_mon;
  private String pry_inf_mon;
  
  private String pry_dro_fir_mon; //Total de la construccion m2
  private String pry_cos_cons; 
  
  private String pry_pro_pgo_ter;
  private LinkedList<CeldaFechaValor> pry_arr_vnt_tot; //60
  private LinkedList<CeldaFechaValor> pry_arr_tit_tot; //70
  private LinkedList<String> pry_tas_int_cre_pue; //Lista de doubles 81
  private LinkedList<String> pry_inf; //double 86
  private LinkedList<String> pry_tas_cet;//double 91
  private LinkedList<MatrizBidimensional> pry_arr_mat_pro_obr_con; //44-48
  private LinkedList<MatrizBidimensional> pry_arr_obr_con_tot; //49
  
    /**
     * @return the pry_val_ter
     */
    public String getPry_val_ter() {
      System.out.println("el valor en el bean de getPry_val_ter() es: " + Funciones.redondear(pry_val_ter, 0));
        return Funciones.redondear(pry_val_ter, 0);
    }

    /**
     * @param pry_val_ter the pry_val_ter to set
     */
    public void setPry_val_ter(String pry_val_ter) {
        this.pry_val_ter = pry_val_ter;
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
     * @return the pry_gst_gral_mon
     */
    public String getPry_gts_gral_mon() {
        return Funciones.redondear(pry_gts_gral_mon, 0);
    }

    /**
     * @param pry_gst_gral_mon the pry_gst_gral_mon to set
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
     * @return the pry_sup_obr_mon
     */
    public String getPry_sup_obr_mon() {
        return Funciones.redondear(pry_sup_obr_mon, 0);
    }

    /**
     * @param pry_sup_obr_mon the pry_sup_obr_mon to set
     */
    public void setPry_sup_obr_mon(String pry_sup_obr_mon) {
        this.pry_sup_obr_mon = pry_sup_obr_mon;
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
     * @return the pry_dro_fir_mon
     */
    public String getPry_dro_fir_mon() {
        return Funciones.redondear(pry_dro_fir_mon, 0);
    }

    /**
     * @param pry_dro_fir_mon the pry_dro_fir_mon to set
     */
    public void setPry_dro_fir_mon(String pry_dro_fir_mon) {
        this.pry_dro_fir_mon = pry_dro_fir_mon;
    }

    /**
     * @return the pry_cos_cons
     */
    public String getPry_cos_cons() {
        return Funciones.redondear(pry_cos_cons, 0);
    }

    /**
     * @param pry_cos_cons the pry_cos_cons to set
     */
    public void setPry_cos_cons(String pry_cos_cons) {
        this.pry_cos_cons = pry_cos_cons;
    }

    /**
     * @return the pry_pro_pgo_ter
     */
    public String getPry_pro_pgo_ter() {
        return pry_pro_pgo_ter;
    }

    /**
     * @param pry_pro_pgo_ter the pry_pro_pgo_ter to set
     */
    public void setPry_pro_pgo_ter(String pry_pro_pgo_ter) {
        this.pry_pro_pgo_ter = pry_pro_pgo_ter;
    }

    /**
     * @return the pry_arr_vnt_tot
     */
    public LinkedList<CeldaFechaValor> getPry_arr_vnt_tot() {
        return pry_arr_vnt_tot;
    }

    /**
     * @param pry_arr_vnt_tot the pry_arr_vnt_tot to set
     */
    public void setPry_arr_vnt_tot(LinkedList<CeldaFechaValor> pry_arr_vnt_tot) {
        this.pry_arr_vnt_tot = pry_arr_vnt_tot;
    }

    /**
     * @return the pry_arr_tit_tot
     */
    public LinkedList<CeldaFechaValor> getPry_arr_tit_tot() {
        return pry_arr_tit_tot;
    }

    /**
     * @param pry_arr_tit_tot the pry_arr_tit_tot to set
     */
    public void setPry_arr_tit_tot(LinkedList<CeldaFechaValor> pry_arr_tit_tot) {
        this.pry_arr_tit_tot = pry_arr_tit_tot;
    }

    /**
     * @return the pry_tas_int_cre_pue
     */
    public LinkedList<String> getPry_tas_int_cre_pue() {
        return pry_tas_int_cre_pue;
    }

    /**
     * @param pry_tas_int_cre_pue the pry_tas_int_cre_pue to set
     */
    public void setPry_tas_int_cre_pue(LinkedList<String> pry_tas_int_cre_pue) {
        this.pry_tas_int_cre_pue = pry_tas_int_cre_pue;
    }

    /**
     * @return the pry_inf
     */
    public LinkedList<String> getPry_inf() {
        return pry_inf;
    }

    /**
     * @param pry_inf the pry_inf to set
     */
    public void setPry_inf(LinkedList<String> pry_inf) {
        this.pry_inf = pry_inf;
    }

    /**
     * @return the pry_tas_cet
     */
    public LinkedList<String> getPry_tas_cet() {
        return pry_tas_cet;
    }

    /**
     * @param pry_tas_cet the pry_tas_cet to set
     */
    public void setPry_tas_cet(LinkedList<String> pry_tas_cet) {
        this.pry_tas_cet = pry_tas_cet;
    }

  /**
   * @return the pry_arr_mat_pro_obr_con
   */
  public LinkedList<MatrizBidimensional> getPry_arr_mat_pro_obr_con() {
    return pry_arr_mat_pro_obr_con;
  }

  /**
   * @param pry_arr_mat_pro_obr_con the pry_arr_mat_pro_obr_con to set
   */
  public void setPry_arr_mat_pro_obr_con(LinkedList<MatrizBidimensional> pry_arr_mat_pro_obr_con) {
    this.pry_arr_mat_pro_obr_con = pry_arr_mat_pro_obr_con;
  }

  /**
   * @return the pry_arr_obr_con_tot
   */
  public LinkedList<MatrizBidimensional> getPry_arr_obr_con_tot() {
    return pry_arr_obr_con_tot;
  }

  /**
   * @param pry_arr_obr_con_tot the pry_arr_obr_con_tot to set
   */
  public void setPry_arr_obr_con_tot(LinkedList<MatrizBidimensional> pry_arr_obr_con_tot) {
    this.pry_arr_obr_con_tot = pry_arr_obr_con_tot;
  }

}
