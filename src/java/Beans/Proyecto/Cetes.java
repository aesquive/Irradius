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
import javax.faces.context.FacesContext;
import util.RegistroFecha;

public class Cetes extends Bean {

  private LinkedList<RegistroFecha> listaCetes;

  public Cetes() {
    llenarLista();
  }

  public Cetes(Object object) {
  }

  public LinkedList<RegistroFecha> getLista() {
    return listaCetes;
  }

  public final void llenarLista() {
    listaCetes = new LinkedList<RegistroFecha>();
    ProyectoFechas bean = (ProyectoFechas) Bean.getBean("proyectoFechas");
    Date original1 = bean.getFechaInicioCetes();
    Date original2 = bean.getFechaFinCetes();
    Date fechaInicioEdificacion = original1;
    Date fechaFinEdificacion = original2;
    SimpleDateFormat sdf = new SimpleDateFormat("MMMMM-yyyy");
//    if (fechaInicioEdificacion.equals(fechaFinEdificacion)) {
    if (fechaInicioEdificacion.getMonth() == fechaFinEdificacion.getMonth() &&
            fechaInicioEdificacion.getYear() == fechaFinEdificacion.getYear()) {
      String cad = sdf.format(fechaInicioEdificacion);
      RegistroFecha registro = new RegistroFecha(cad);
      listaCetes.add(registro);
      fechaInicioEdificacion.setMonth(fechaInicioEdificacion.getMonth() + 1);
    } 
      listaCetes.add(new RegistroFecha(sdf.format(fechaFinEdificacion)));
      fechaInicioEdificacion.setMonth(original1.getMonth());
      fechaFinEdificacion.setYear(original1.getYear());
    }

  public void setLista(LinkedList<RegistroFecha> lista) {
    this.listaCetes = lista;
  }

  private int getNumeroRenglones() {
    ProyectoFechas bean = (ProyectoFechas) Bean.getBean("proyectoFechas");
    int mesInicial = bean.getFechaInicioCetes().getMonth();
    int mesFinal = bean.getFechaFinCetes().getMonth();
    int anioInicial = bean.getFechaInicioCetes().getYear();
    int anioFinal = bean.getFechaFinCetes().getYear();
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

  public String pasarEtapas() {
    ProyectosInfoBasica info = (ProyectosInfoBasica) Bean.getBean("proyectosInfoBasica");
    if (Integer.parseInt(info.getNumEtapas()) > 0) {
      return "etapas";
    }
    return "";
  }
}
