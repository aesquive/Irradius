/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.Proyecto;

import Beans.Bean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import util.RegistroFecha;

/**
 *
 * @author RUMA
 */
public class Titulacion extends Bean {

  private LinkedList<RegistroFecha> listaTitulacion;

  public Titulacion() {
    llenarLista();
  }

  public Titulacion(Object object) {
  }

  public LinkedList<RegistroFecha> getLista() {
    return listaTitulacion;
  }

  public final void llenarLista() {
    listaTitulacion = new LinkedList<RegistroFecha>();
    ProyectoFechas bean = (ProyectoFechas) Bean.getBean("proyectoFechas");
    Date original1 = bean.getFechaInicioTitulacion();
    Date original2 = bean.getFechaFinTitulacion();
    Date fechaInicioEdificacion = original1;
    Date fechaFinEdificacion = original2;
    SimpleDateFormat sdf = new SimpleDateFormat("MMMMM-yyyy");
//    if (fechaInicioEdificacion.equals(fechaFinEdificacion)) {
    if (fechaInicioEdificacion.getMonth() == fechaFinEdificacion.getMonth() &&
            fechaInicioEdificacion.getYear() == fechaFinEdificacion.getYear()) {
      String cad = sdf.format(fechaInicioEdificacion);
      RegistroFecha registro = new RegistroFecha(cad);
      listaTitulacion.add(registro);
      fechaInicioEdificacion.setMonth(fechaInicioEdificacion.getMonth() + 1);
      }
      listaTitulacion.add(new RegistroFecha(sdf.format(fechaFinEdificacion)));
      fechaInicioEdificacion.setMonth(original1.getMonth());
      fechaFinEdificacion.setYear(original1.getYear());
    }

  public void setLista(LinkedList<RegistroFecha> lista) {
    this.listaTitulacion = lista;
  }

  private int getNumeroRenglones() {
    ProyectoFechas bean = (ProyectoFechas) Bean.getBean("proyectoFechas");
    int mesInicial = bean.getFechaInicioTitulacion().getMonth();
    int mesFinal = bean.getFechaFinTitulacion().getMonth();
    int anioInicial = bean.getFechaInicioTitulacion().getYear();
    int anioFinal = bean.getFechaFinTitulacion().getYear();
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

  public String pasarGeneradores() {
    int suma = 0;
    for (RegistroFecha r : listaTitulacion) {
      String valor = r.getPorcentaje().substring(0, r.getPorcentaje().length() - 1);
      suma += Double.parseDouble(valor);
    }
    if (suma == 100.0) {
      return "generadores";
    }
    FacesContext.getCurrentInstance().addMessage("titulacion:boton", new FacesMessage("La suma de los valores debe ser 100%"));
    return "";
  }
}
