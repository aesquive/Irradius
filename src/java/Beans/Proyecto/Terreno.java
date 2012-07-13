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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import util.RegistroFecha;

/**
 * Clase obtiene los meses de inicio y fin de la pestaña de pagoTerrenoFechas
 *
 * @author Aida
 */
@ManagedBean
@SessionScoped
public class Terreno extends Bean {

  private LinkedList<RegistroFecha> listaTerreno;

  public Terreno() {
    llenarLista();
  }

  public Terreno(Object object) {
  }

  public LinkedList<RegistroFecha> getLista() {
    return listaTerreno;
  }

  /*Modificar estos algoritmos de fechas*/
  public final void llenarLista() {
    listaTerreno = new LinkedList<RegistroFecha>();
    ProyectoFechas bean = (ProyectoFechas) Bean.getBean("proyectoFechas");
    Date original1 = bean.getFechaInicioTerrenos();
    Date original2 = bean.getFechaFinTerrenos();
    Date fechaInicioEdificacion = original1;
    Date fechaFinEdificacion = original2;
    SimpleDateFormat sdf = new SimpleDateFormat("MMMMM-yyyy");
    if (fechaInicioEdificacion.getMonth() == fechaFinEdificacion.getMonth()
            && fechaInicioEdificacion.getYear() == fechaFinEdificacion.getYear()) {
      String cad = sdf.format(fechaInicioEdificacion);
      RegistroFecha registro = new RegistroFecha(cad);
      listaTerreno.add(registro);
    } else {
      while (fechaInicioEdificacion.compareTo(fechaFinEdificacion) < 0) {
        String cad = sdf.format(fechaInicioEdificacion);
        RegistroFecha registro = new RegistroFecha(cad);
        listaTerreno.add(registro);
        fechaInicioEdificacion.setMonth(fechaInicioEdificacion.getMonth() + 1);
      }
      listaTerreno.add(new RegistroFecha(sdf.format(fechaFinEdificacion)));
      fechaInicioEdificacion.setMonth(original1.getMonth());
      fechaFinEdificacion.setYear(original1.getYear());
    }
  }

  public void setLista(LinkedList<RegistroFecha> lista) {
    this.listaTerreno = lista;
  }

  private int getNumeroRenglones() {
    ProyectoFechas bean = (ProyectoFechas) Bean.getBean("proyectoFechas");
    int mesInicial = bean.getFechaInicioTerrenos().getMonth();
    int mesFinal = bean.getFechaFinTerrenos().getMonth();
    int anioInicial = bean.getFechaInicioTerrenos().getYear();
    int anioFinal = bean.getFechaFinTerrenos().getYear();
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

  public String pasarVenta() {
    int suma = 0;
    for (RegistroFecha r : listaTerreno) {
      String valor = r.getPorcentaje().substring(0, r.getPorcentaje().length() - 1);
      suma += Double.parseDouble(valor);
    }
    if (suma == 100.0) {
      return "venta";
    }
    FacesContext.getCurrentInstance().addMessage("terreno:boton", new FacesMessage("La suma de los valores debe ser 100%"));
    return "";
  }
}
