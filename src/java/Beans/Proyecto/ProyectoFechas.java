/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.Proyecto;

import Beans.Bean;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author RUMA
 */
@ManagedBean
@SessionScoped
public class ProyectoFechas extends Bean {

  private Date fechaInicioTerrenos;
  private Date fechaFinTerrenos;
  private Date fechaInicioVenta;
  private Date fechaFinVenta;
  private Date fechaInicioTitulacion;
  private Date fechaFinTitulacion;
  private Date fechaInicioCreditoPue;
  private Date fechaFinCreditoPue;
  private Date fechaInicioInflacion;
  private Date fechaFinInflacion;
  private Date fechaInicioCetes;
  private Date fechaFinCetes;
  private Date fechaInicioConstruccion;
  private Date fechaFinConstruccion;

  public ProyectoFechas() {
  }

  public ProyectoFechas(Object object) {
  }

  /**
   * @return the fechaInicioTerrenos
   */
  public Date getFechaInicioTerrenos() {
    return fechaInicioTerrenos;
  }

  /**
   * @param fechaInicioTerrenos the fechaInicioTerrenos to set
   */
  public void setFechaInicioTerrenos(Date fechaInicioTerrenos) {
    this.fechaInicioTerrenos = fechaInicioTerrenos;
  }

  /**
   * @return the fechaFinTerrenos
   */
  public Date getFechaFinTerrenos() {
    return fechaFinTerrenos;
  }

  /**
   * @param fechaFinTerrenos the fechaFinTerrenos to set
   */
  public void setFechaFinTerrenos(Date fechaFinTerrenos) {
    this.fechaFinTerrenos = fechaFinTerrenos;
  }

  /**
   * @return the fechaInicioVenta
   */
  public Date getFechaInicioVenta() {
    return fechaInicioVenta;
  }

  /**
   * @param fechaInicioVenta the fechaInicioVenta to set
   */
  public void setFechaInicioVenta(Date fechaInicioVenta) {
    this.fechaInicioVenta = fechaInicioVenta;
  }

  /**
   * @return the fechaFinVenta
   */
  public Date getFechaFinVenta() {
    return fechaFinVenta;
  }

  /**
   * @param fechaFinVenta the fechaFinVenta to set
   */
  public void setFechaFinVenta(Date fechaFinVenta) {
    this.fechaFinVenta = fechaFinVenta;
  }

  /**
   * @return the fechaInicioTitulacion
   */
  public Date getFechaInicioTitulacion() {
    return fechaInicioTitulacion;
  }

  /**
   * @param fechaInicioTitulacion the fechaInicioTitulacion to set
   */
  public void setFechaInicioTitulacion(Date fechaInicioTitulacion) {
    this.fechaInicioTitulacion = fechaInicioTitulacion;
  }

  /**
   * @return the fechaFinTitulacion
   */
  public Date getFechaFinTitulacion() {
    return fechaFinTitulacion;
  }

  /**
   * @param fechaFinTitulacion the fechaFinTitulacion to set
   */
  public void setFechaFinTitulacion(Date fechaFinTitulacion) {
    this.fechaFinTitulacion = fechaFinTitulacion;
  }

  /**
   * @return the fechaInicioCreditoPue
   */
  public Date getFechaInicioCreditoPue() {
    return fechaInicioCreditoPue;
  }

  /**
   * @param fechaInicioCreditoPue the fechaInicioCreditoPue to set
   */
  public void setFechaInicioCreditoPue(Date fechaInicioCreditoPue) {
    this.fechaInicioCreditoPue = fechaInicioCreditoPue;
  }

  /**
   * @return the fechaFinCreditoPue
   */
  public Date getFechaFinCreditoPue() {
    return fechaFinCreditoPue;
  }

  /**
   * @param fechaFinCreditoPue the fechaFinCreditoPue to set
   */
  public void setFechaFinCreditoPue(Date fechaFinCreditoPue) {
    this.fechaFinCreditoPue = fechaFinCreditoPue;
  }

  /**
   * @return the fechaInicioInflacion
   */
  public Date getFechaInicioInflacion() {
    return fechaInicioInflacion;
  }

  /**
   * @param fechaInicioInflacion the fechaInicioInflacion to set
   */
  public void setFechaInicioInflacion(Date fechaInicioInflacion) {
    this.fechaInicioInflacion = fechaInicioInflacion;
  }

  /**
   * @return the fechaFinInflacion
   */
  public Date getFechaFinInflacion() {
    return fechaFinInflacion;
  }

  /**
   * @param fechaFinInflacion the fechaFinInflacion to set
   */
  public void setFechaFinInflacion(Date fechaFinInflacion) {
    this.fechaFinInflacion = fechaFinInflacion;
  }

  /**
   * @return the fechaInicioCetes
   */
  public Date getFechaInicioCetes() {
    return fechaInicioCetes;
  }

  /**
   * @param fechaInicioCetes the fechaInicioCetes to set
   */
  public void setFechaInicioCetes(Date fechaInicioCetes) {
    this.fechaInicioCetes = fechaInicioCetes;
  }

  /**
   * @return the fechaFinCetes
   */
  public Date getFechaFinCetes() {
    return fechaFinCetes;
  }

  /**
   * @param fechaFinCetes the fechaFinCetes to set
   */
  public void setFechaFinCetes(Date fechaFinCetes) {
    this.fechaFinCetes = fechaFinCetes;
  }

  public void ponerFechas(Date inicioTerrenos, Date finTerrenos, Date inicioVenta,
          Date finVenta, Date inicioTitulacion, Date finTitulacion,
          Date inicioCreditoPue, Date finCreditoPue, Date inicioInflacion,
          Date finInflacion, Date inicioCetes, Date finCetes) {
    this.setFechaFinTitulacion(finTitulacion);
    this.setFechaInicioTerrenos(inicioTerrenos);
    this.setFechaFinTerrenos(finTerrenos);
    this.setFechaInicioVenta(inicioVenta);
    this.setFechaFinVenta(finVenta);
    this.setFechaInicioTitulacion(inicioTitulacion);
    this.setFechaFinTitulacion(finTitulacion);
    this.setFechaInicioCreditoPue(inicioCreditoPue);
    this.setFechaFinCreditoPue(finCreditoPue);
    this.setFechaInicioInflacion(inicioInflacion);
    this.setFechaFinInflacion(finInflacion);
    this.setFechaInicioCetes(inicioCetes);
    this.setFechaFinCetes(finCetes);
  }

  /**
   * @return the fechaInicioConstruccion
   */
  public Date getFechaInicioConstruccion() {
    return fechaInicioConstruccion;
  }

  /**
   * @param fechaInicioConstruccion the fechaInicioConstruccion to set
   */
  public void setFechaInicioConstruccion(Date fechaInicioConstruccion) {
    this.fechaInicioConstruccion = fechaInicioConstruccion;
  }

  /**
   * @return the fechaFinConstruccion
   */
  public Date getFechaFinConstruccion() {
    return fechaFinConstruccion;
  }

  /**
   * @param fechaFinConstruccion the fechaFinConstruccion to set
   */
  public void setFechaFinConstruccion(Date fechaFinConstruccion) {
    this.fechaFinConstruccion = fechaFinConstruccion;
  }
}