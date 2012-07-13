/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.Proyecto;

/**
 *
 * @author RUMA
 */
import Beans.Bean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import util.RegistroFecha;

@ManagedBean
@SessionScoped
public class CreditoPuente extends Bean {

  private LinkedList<RegistroFecha> listaCreditoPuente;

  public CreditoPuente() {
    llenarLista();
  }

  public CreditoPuente(Object object) {
  }

  public final void llenarLista() {
    listaCreditoPuente = new LinkedList<RegistroFecha>();
    ProyectoFechas bean = (ProyectoFechas) Bean.getBean("proyectoFechas");
    Date original1 = bean.getFechaInicioCreditoPue();
    Date original2 = bean.getFechaFinCreditoPue();
    Date fechaInicioEdificacion = original1;
    Date fechaFinEdificacion = original2;
    SimpleDateFormat sdf = new SimpleDateFormat("MMMMM-yyyy");
//    if (fechaInicioEdificacion.equals(fechaFinEdificacion)) {
    if (fechaInicioEdificacion.getMonth() == fechaFinEdificacion.getMonth() &&
            fechaInicioEdificacion.getYear() == fechaFinEdificacion.getYear()) {
      String cad = sdf.format(fechaInicioEdificacion);
      RegistroFecha registro = new RegistroFecha(cad);
      listaCreditoPuente.add(registro);
      fechaInicioEdificacion.setMonth(fechaInicioEdificacion.getMonth() + 1);
    }
      listaCreditoPuente.add(new RegistroFecha(sdf.format(fechaFinEdificacion)));
      fechaInicioEdificacion.setMonth(original1.getMonth());
      fechaFinEdificacion.setYear(original1.getYear());
  }

  public void setLista(LinkedList<RegistroFecha> lista) {
    this.setListaCreditoPuente(lista);
  }

  private int getNumeroRenglones() {
    ProyectoFechas bean = (ProyectoFechas) Bean.getBean("proyectoFechas");
    int mesInicial = bean.getFechaInicioCreditoPue().getMonth();
    int mesFinal = bean.getFechaFinCreditoPue().getMonth();
    int anioInicial = bean.getFechaInicioCreditoPue().getYear();
    int anioFinal = bean.getFechaFinCreditoPue().getYear();
    int contador = 1;
    while ((mesInicial != mesFinal) || (anioInicial != anioFinal)) {
      int aux = (mesInicial + 1);
      mesInicial = aux % 12;
      if (aux > 11) {
        anioInicial++;
      }
      contador++;
    }
    return contador;
  }

  /**
   * @return the listaCreditoPuente
   */
  public LinkedList<RegistroFecha> getListaCreditoPuente() {
    return listaCreditoPuente;
  }

  /**
   * @param listaCreditoPuente the listaCreditoPuente to set
   */
  public void setListaCreditoPuente(LinkedList<RegistroFecha> listaCreditoPuente) {
    this.listaCreditoPuente = listaCreditoPuente;
  }
}
