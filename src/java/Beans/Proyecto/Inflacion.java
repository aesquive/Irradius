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
public class Inflacion extends Bean {

  private LinkedList<RegistroFecha> listaInflacion;

  /**
   *
   */
  public Inflacion() {
    llenarLista();
  }

   public Inflacion(Object object){
   } 
  
  public LinkedList<RegistroFecha> getLista() {
    return listaInflacion;
  }

  public final void llenarLista() {
    listaInflacion = new LinkedList<RegistroFecha>();
    ProyectoFechas bean = (ProyectoFechas) Bean.getBean("proyectoFechas");
    Date original1 = bean.getFechaInicioInflacion();
    Date original2 = bean.getFechaFinInflacion();
    Date fechaInicioEdificacion = original1;
    Date fechaFinEdificacion = original2;
    SimpleDateFormat sdf = new SimpleDateFormat(  "MMMMM-yyyy");
//    if (fechaInicioEdificacion.equals(fechaFinEdificacion)) {
    if (fechaInicioEdificacion.getMonth() == fechaFinEdificacion.getMonth() &&
            fechaInicioEdificacion.getYear() == fechaFinEdificacion.getYear()) {
      String cad = sdf.format(fechaInicioEdificacion);
      RegistroFecha registro = new RegistroFecha(cad);
      listaInflacion.add(registro);
      fechaInicioEdificacion.setMonth(fechaInicioEdificacion.getMonth() + 1);
    } 
      
      listaInflacion.add(new RegistroFecha(sdf.format(fechaFinEdificacion)));
      fechaInicioEdificacion.setMonth(original1.getMonth());
      fechaFinEdificacion.setYear(original1.getYear());
    }
  
  public void setLista(LinkedList<RegistroFecha> lista) {
    this.listaInflacion = lista;
  }

  private int getNumeroRenglones() {
    ProyectoFechas bean = (ProyectoFechas) Bean.getBean("proyectoFechas");
    int mesInicial = bean.getFechaInicioInflacion().getMonth();
    int mesFinal = bean.getFechaFinInflacion().getMonth();
    int anioInicial = bean.getFechaInicioInflacion().getYear();
    int anioFinal = bean.getFechaFinInflacion().getYear();
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
}
