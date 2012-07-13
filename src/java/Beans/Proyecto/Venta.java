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
public class Venta extends Bean {

  private LinkedList<RegistroFecha> listaVenta;

  public Venta() {
    llenarLista();
  }

  public Venta(Object object) {
  }

  public LinkedList<RegistroFecha> getLista() {
    return listaVenta;
  }

  public final void llenarLista() {
    listaVenta = new LinkedList<RegistroFecha>();
    ProyectoFechas bean = (ProyectoFechas) Bean.getBean("proyectoFechas");
    Date original1 = bean.getFechaInicioVenta();
    Date original2 = bean.getFechaFinVenta();
    Date fechaInicioEdificacion = original1;
    Date fechaFinEdificacion = original2;
    SimpleDateFormat sdf = new SimpleDateFormat("MMMMM-yyyy");
    if (fechaInicioEdificacion.getMonth() == fechaFinEdificacion.getMonth() &&
            fechaInicioEdificacion.getYear() == fechaFinEdificacion.getYear()) {
      String cad = sdf.format(fechaInicioEdificacion);
      RegistroFecha registro = new RegistroFecha(cad);
      listaVenta.add(registro);
      fechaInicioEdificacion.setMonth(fechaInicioEdificacion.getMonth() + 1);
      }
      listaVenta.add(new RegistroFecha(sdf.format(fechaFinEdificacion)));
      fechaInicioEdificacion.setMonth(original1.getMonth());
      fechaFinEdificacion.setYear(original1.getYear());
    }

  public void setLista(LinkedList<RegistroFecha> lista) {
    this.listaVenta = lista;
  }

  private int getNumeroRenglones() {
    ProyectoFechas bean = (ProyectoFechas) Bean.getBean("proyectoFechas");
    int mesInicial = bean.getFechaInicioVenta().getMonth();
    int mesFinal = bean.getFechaFinVenta().getMonth();
    int anioInicial = bean.getFechaInicioVenta().getYear();
    int anioFinal = bean.getFechaFinVenta().getYear();
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

  public String pasarTitulacion() {
    int suma = 0;
    for (RegistroFecha r : listaVenta) {
      String valor = r.getPorcentaje().substring(0, r.getPorcentaje().length() - 1);
      suma += Double.parseDouble(valor);
    }
    if (suma == 100.0) {
      return "titulacion";
    }
    FacesContext.getCurrentInstance().addMessage("venta:boton", new FacesMessage("La suma de los valores debe ser 100%"));
    return "";
  }
}
