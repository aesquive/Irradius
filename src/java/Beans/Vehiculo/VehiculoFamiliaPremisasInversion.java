package Beans.Vehiculo;

import Beans.Bean;
import java.beans.Beans;
import util.Parametros;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * Clase que es un ManagedBean para el llenado de la familia de Premisas
 * Financieras para los vehiculos
 * @author Daniel Gonzalez Teran
 */
public class VehiculoFamiliaPremisasInversion extends  Bean{

  /**
   * lista de premisas de inversion
   */
  private LinkedList<Parametros> lista;
  
  private int numeroEscalonesTIR;
  /**
   * numero de elementos de la lista
   */
  private final int NUMPRE = 2;
  
  public VehiculoFamiliaPremisasInversion() {
    lista = new LinkedList<Parametros>();
    for (int i = 0; i < NUMPRE; i++) {
      lista.add(new Parametros(nombreParametricas(i), ""));
    }
  }

    public VehiculoFamiliaPremisasInversion(Object object) {
        
    }

  /**
   * regresa las cadenas que sera ocupadas en la tabla de premisas de inversion
   * @param i el indice de la cadena solicitada
   * @return una cadena para la tabla
   */ 
  private String nombreParametricas(int i) {
    switch (i) {
      case 0:
        return "% de Factor de caja minima";
      case 1:
        return "% de Distribucion de Utilidades Durante la Vida del Proyecto";
      default:
        System.out.println("error");
        break;
    }
    return "";
  }

  

  /**
   * @return the lista
   */
  public LinkedList<Parametros> getLista() {
    return lista;
  }

  /**
   * @param lista the lista to set
   */
  public void setLista(LinkedList<Parametros> lista) {
    this.lista = lista;
  }

    private void resetearBeans() {
        Bean.limpiaBeans("vehiculoParametricas",
                "vehiculoFinancieras","vehiculoInversion","edificacionBean","generalVehiculoBean");
    }


    /**
     * @return the numeroEscalonesEtapas
     */
    public int getNumeroEscalonesTIR() {
        return numeroEscalonesTIR;
    }

    /**
     * @param numeroEscalonesEtapas the numeroEscalonesEtapas to set
     */
    public void setNumeroEscalonesTIR(int numeroEscalonesEtapas) {
        this.numeroEscalonesTIR = numeroEscalonesEtapas;
    }
    
    
    public String pasarEtapasTIR(){
        if(numeroEscalonesTIR>0){
            System.out.println("aqui vamonos a tir");
            return "escalonesTir";
        }
        FacesContext.getCurrentInstance().addMessage("inversion:boton", new FacesMessage("Los escalones de TIR debe ser mayor a 0"));
        return "";
    }
}
