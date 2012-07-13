package Beans.Proyecto.Pantallas;

import Beans.Bean;
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
public class modeloElemVenta extends Bean implements Serializable {
 
  private String pry_uni_viv;
  private LinkedList<Double> pry_por_cre;
  private LinkedList<Double> pry_val_ven;
  private String pry_ing_eng_viv; 
  private String pry_ing_tit_viv;
  private String pry_ing_tot_viv;
  private String pry_val_prom_ven_viv;
  private String pry_ing_tot_val_ven;
  private String pry_ing_tot_sbpr;
  private LinkedList<Double> pry_val_eng_eta;
  private LinkedList<Double> pry_val_cre_eta;
  
  public modeloElemVenta(){
    
  }
  
  /**
   * @return the pry_por_cre
   */
  public LinkedList<Double> getPry_por_cre() {
    return pry_por_cre;
  }

  /**
   * @param pry_por_cre the pry_por_cre to set
   */
  public void setPry_por_cre(LinkedList<Double> pry_por_cre) {
    this.pry_por_cre = pry_por_cre;
  }

  /**
   * @return the pry_val_ven
   */
  public LinkedList<Double> getPry_val_ven() {
    return pry_val_ven;
  }

  /**
   * @param pry_val_ven the pry_val_ven to set
   */
  public void setPry_val_ven(LinkedList<Double> pry_val_ven) {
    this.pry_val_ven = pry_val_ven;
  }
 
  /**
   * @return the pry_val_eng_eta
   */
  public LinkedList<Double> getPry_val_eng_eta() {
    return pry_val_eng_eta;
  }

  /**
   * @param pry_val_eng_eta the pry_val_eng_eta to set
   */
  public void setPry_val_eng_eta(LinkedList<Double> pry_val_eng_eta) {
    this.pry_val_eng_eta = pry_val_eng_eta;
  }

  /**
   * @return the pry_val_cre_eta
   */
  public LinkedList<Double> getPry_val_cre_eta() {
    return pry_val_cre_eta;
  }

  /**
   * @param pry_val_cre_eta the pry_val_cre_eta to set
   */
  public void setPry_val_cre_eta(LinkedList<Double> pry_val_cre_eta) {
    this.pry_val_cre_eta = pry_val_cre_eta;
  }

  /**
   * @return the pry_val_prom_ven_viv
   */
  public String getPry_val_prom_ven_viv() {
    return Funciones.redondear(pry_val_prom_ven_viv, 0);
  }

  /**
   * @param pry_val_prom_ven_viv the pry_val_prom_ven_viv to set
   */
  public void setPry_val_prom_ven_viv(String pry_val_prom_ven_viv) {
    this.pry_val_prom_ven_viv = pry_val_prom_ven_viv;
  }

  /**
   * @return the pry_ing_tot_val_ven
   */
  public String getPry_ing_tot_val_ven() {

    return Funciones.redondear(pry_ing_tot_val_ven, 0);
  }

  /**
   * @param pry_ing_tot_val_ven the pry_ing_tot_val_ven to set
   */
  public void setPry_ing_tot_val_ven(String pry_ing_tot_val_ven) {
    this.pry_ing_tot_val_ven = pry_ing_tot_val_ven;
  }

  /**
   * @return the pry_uni_viv
   */
  public String getPry_uni_viv() {
    return Funciones.redondear(pry_uni_viv, 0);
  }

  /**
   * @param pry_uni_viv the pry_uni_viv to set
   */
  public void setPry_uni_viv(String pry_uni_viv) {
    this.pry_uni_viv = pry_uni_viv;
  }

  /**
   * @return the pry_ing_eng_viv
   */
  public String getPry_ing_eng_viv() {
    return Funciones.redondear(pry_ing_eng_viv, 0);
  }

  /**
   * @param pry_ing_eng_viv the pry_ing_eng_viv to set
   */
  public void setPry_ing_eng_viv(String pry_ing_eng_viv) {
    this.pry_ing_eng_viv = pry_ing_eng_viv;
  }

  /**
   * @return the pry_ing_tit_viv
   */
  public String getPry_ing_tit_viv() {
    return Funciones.redondear(pry_ing_tit_viv, 0);
  }

  /**
   * @param pry_ing_tit_viv the pry_ing_tit_viv to set
   */
  public void setPry_ing_tit_viv(String pry_ing_tit_viv) {
    this.pry_ing_tit_viv = pry_ing_tit_viv;
  }

  /**
   * @return the pry_ing_tot_viv
   */
  public String getPry_ing_tot_viv() {
    return Funciones.redondear(pry_ing_tot_viv, 0);
  }

  /**
   * @param pry_ing_tot_viv the pry_ing_tot_viv to set
   */
  public void setPry_ing_tot_viv(String pry_ing_tot_viv) {
    this.pry_ing_tot_viv = pry_ing_tot_viv;
  }

  /**
   * @return the pry_ing_tot_sbpr
   */
  public String getPry_ing_tot_sbpr() {
    return Funciones.redondear(pry_ing_tot_sbpr, 0);
  }

  /**
   * @param pry_ing_tot_sbpr the pry_ing_tot_sbpr to set
   */
  public void setPry_ing_tot_sbpr(String pry_ing_tot_sbpr) {
    this.pry_ing_tot_sbpr = pry_ing_tot_sbpr;
  }
}
