package Beans.Vehiculo;

import Beans.Bean;
import util.Parametros;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import util.Funciones;

/**
 * Clase que es un ManagedBean para el llenado de la familia de Premisas
 * de Inversion para los vehiculos
 * @author Daniel Gonzalez Teran
 */
public class VehiculoFamiliaPremisasFinancieras extends  Bean{

    private int numeroEtapas;
  /**
   * lista de premisas financieras (valores nuemericos)
   */
  private LinkedList<Parametros> listaNum;
  /**
   * lista de premisas financieras (porentajes)
   */
  private LinkedList<Parametros> listaPorcentaje;
  /**
   * numero de elementos de listaNum
   */
  private final int NUMFIN = 3;
  /**
   * numero de elementos de listaPorcentaje
   */
  private final int NUMFINPOR = 8;
  
  
  public VehiculoFamiliaPremisasFinancieras() {
    numeroEtapas=0;
    listaNum = new LinkedList<Parametros>();
    listaPorcentaje = new LinkedList<Parametros>();
    
    for (int j = 0; j < NUMFIN; j++) {
      listaNum.add(new Parametros(nombreParametricas(j), ""));
    }

    for (int i = 0; i < NUMFINPOR; i++) {
      listaPorcentaje.add(new Parametros(nombreParametricasPorcentajes(i), ""));
    }
  }

    public VehiculoFamiliaPremisasFinancieras(Object object) {
        
    }

    public String pasarParametricas(){
        Funciones.redireccionar("parametricas.xhtml");
        return "";
    }
    
  /**
   * regresa las cadenas que sera ocupadas en la tabla de premisas de financieras numericas
   * @param i el indice de la cadena solicitada
   * @return una cadena para la tabla
   */ 
  private String nombreParametricas(int i) {
    switch (i) {
      case 0:
        return "Capital del Inversionista (miles)";
      case 1:
        return "Meses para conformar el anticipo";
      case 2:
        return "Valor Promedio de Vivienda";
    }
    return "";
  }

  /**
   * regresa las cadenas que sera ocupadas en la tabla de premisas de financieras porcentajes
   * @param i el indice de la cadena solicitada
   * @return una cadena para el datatable
   */ 
  private String nombreParametricasPorcentajes(int i) {
    switch (i) {
      case 0:
        return "% de Apalancamiento";
      case 1:
        return "% de Credito puente";
      case 2:
        return "% de Anticipo credito puente";
      case 3:
        return "% de Tasa anual de credito puente";
      case 4:
        return "% de Comision credito puente";
      case 5:
        return "% de APP";
      case 6:
        return "% de SAPI";
      case 7:
        return "% de Anticipo venta";
      default:
        System.out.println("error");
        break;
    }
    return "";
  }

    /**
     * @return the listaNum
     */
    public LinkedList<Parametros> getListaNum() {
        return listaNum;
    }

    /**
     * @param listaNum the listaNum to set
     */
    public void setListaNum(LinkedList<Parametros> listaNum) {
        this.listaNum = listaNum;
    }

    /**
     * @return the listaPorcentaje
     */
    public LinkedList<Parametros> getListaPorcentaje() {
        return listaPorcentaje;
    }

    /**
     * @param listaPorcentaje the listaPorcentaje to set
     */
    public void setListaPorcentaje(LinkedList<Parametros> listaPorcentaje) {
        this.listaPorcentaje = listaPorcentaje;
    }

    
    public String pasarEtapas(){
        for(Parametros s :listaPorcentaje){
            String valor = s.getRegistroIngreso().substring(0, s.getRegistroIngreso().length()-1);
            if(Double.parseDouble(valor)>100.0 || getNumeroEtapas()==0){
                FacesContext.getCurrentInstance().addMessage("financieras:boton", new FacesMessage("Ningun porcentaje puede ser mayor a 100%"));
                return "";
            }
            
        }
        return "etapas";
    }

    /**
     * @return the numeroEtapas
     */
    public int getNumeroEtapas() {
        return numeroEtapas;
    }

    /**
     * @param numeroEtapas the numeroEtapas to set
     */
    public void setNumeroEtapas(int numeroEtapas) {
        this.numeroEtapas = numeroEtapas;
    }

    
 
}
