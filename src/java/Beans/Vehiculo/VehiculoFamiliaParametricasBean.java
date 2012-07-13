package Beans.Vehiculo;

import Beans.Bean;
import util.Parametros;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import pojos.TipMon;
import util.Funciones;

/**
 * Clase que es un ManagedBean para el llenado de la familia de Parametricas
 * para los vehiculos
 * @author Daniel Gonzalez Teran
 */
public class VehiculoFamiliaParametricasBean extends Bean {

    private int tipoMoneda;
    
    private List<TipMon> monedas;
    
    private String nombreProyecto;
    /**
     * lista de elementos parametricos
     */
    private LinkedList<Parametros> lista;
    
    private String valor;
    /**
     * numero de elementos de la lista
     */
    private final int NUMPAR = 7;

    public VehiculoFamiliaParametricasBean() {
        llenarMonedas();
        valor="100.000%";
        lista = new LinkedList<Parametros>();
        for (int i = 0; i < NUMPAR; i++) {
            lista.add(new Parametros(nombreParametricas(i), ""));
        }
    }

    
    
    public VehiculoFamiliaParametricasBean(Object object) {
        llenarMonedas();
        
    }

    /**
     * regresa las cadenas que sera ocupadas en la tabla de parametricas
     * @param i el indice de la cadena solicitada
     * @return una cadena para el tabla
     */
    private String nombreParametricas(int i) {
        switch (i) {
            case 0:
                return "Tierra";
            case 1:
                return "Urbanizacion";
            case 2:
                return "Edificacion";
            case 3:
                return "GAV";
            case 4:
                return "Gastos por individualizacion";
            case 5:
                return "CIF";
            case 6:
                return "EBITDA";
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
        this.lista=lista;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
    public String pasarFinancieras(){
        String total=valor.substring(0, valor.length()-1);
        double suma=0;
        for(Parametros s:lista){
            String valor = s.getRegistroIngreso().substring(0, s.getRegistroIngreso().length()-1);
            suma+=Double.parseDouble(valor);
        }
        double resta=Double.parseDouble(total)-suma;
        if(resta==0.0 && !nombreProyecto.equals("")){
            return "financieras";
        }
        FacesContext.getCurrentInstance().addMessage("parametricas:boton", new FacesMessage("La suma debe dar "+valor));
        return "";
    }

    /**
     * @return the nombreProyecto
     */
    public String getNombreProyecto() {
        return nombreProyecto;
    }

    /**
     * @param nombreProyecto the nombreProyecto to set
     */
    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    /**
     * @return the tipoMoneda
     */
    public int getTipoMoneda() {
        return tipoMoneda;
    }

    /**
     * @param tipoMoneda the tipoMoneda to set
     */
    public void setTipoMoneda(int tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    /**
     * @return the monedas
     */
    public List<TipMon> getMonedas() {
        return monedas;
    }

    /**
     * @param monedas the monedas to set
     */
    public void setMonedas(List<TipMon> monedas) {
        this.monedas = monedas;
    }

    
    public void cambioMoneda(AjaxBehaviorEvent vc) {
        UIComponent component = vc.getComponent();
        Object valor = sacarValor(component, "value");
        this.tipoMoneda = valor == null ? 0 : (Integer) valor;
    }
    
    public Object sacarValor(UIComponent component, String atributo) {
        return component.getAttributes().get(atributo);
    }

    private void llenarMonedas() {
        monedas=Funciones.getTipMons();
    }
    
}
