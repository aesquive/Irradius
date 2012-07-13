package Beans.Vehiculo;

import Beans.Bean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import util.Funciones;
import util.RegistroFecha;

/**
 * Clase que representa un managedBean para el llenado de
 * la Matriz de Edificacion para los vehiculos.
 * 
 * @author Galindo Martinez Jose Cruz
 */
public class EdificacionBean extends Bean {

    /**
     * Lista que contiene los registros con la fecha y el monto.
     */
    private LinkedList<RegistroFecha> lista;
    

    /** Crea un nuevo objeto de la clase EdificacionBean */
    public EdificacionBean() {
        
        llenarLista();
    }

    public EdificacionBean(Object object) {
        
    }

    /**
     * Obtenemos la lista que contiene los registros.
     * @return La lista de registros con la fecha y el monto.
     */
    public LinkedList<RegistroFecha> getLista() {
        
        
        return lista;
    }
    
    public void llenarLista(){
        
        FechasBean bean=(FechasBean) Bean.getBean("fechasBean");
        Date original1 = bean.getFechaInicioEdificacion();
        Date fechaInicioEdificacion=(Date) original1.clone();
        Date original2 = bean.getFechaFinEdificacion();
        Date fechaFinEdificacion=(Date) original2.clone();
        lista=new LinkedList<RegistroFecha>();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMMM-yyyy");
        while(fechaInicioEdificacion.compareTo(fechaFinEdificacion)<0){
                String cad = sdf.format(fechaInicioEdificacion);
                RegistroFecha registro = new RegistroFecha(cad);
                lista.add(registro);
                fechaInicioEdificacion.setMonth(fechaInicioEdificacion.getMonth()+1);
        }
        RegistroFecha last = lista.getLast();
        if(!last.getFecha().equals(sdf.format(fechaFinEdificacion))){
            lista.add(new RegistroFecha(sdf.format(fechaFinEdificacion)));
        }
    }

    /**
     * Nos permite modificar la lista de registros.
     * @param lista La nueva lista con registros.
     */
    public void setLista(LinkedList<RegistroFecha> lista) {
        this.lista = lista;
    }

    /**
     * Dadas las fechas de entrada se encarga de calcular
     * el numero de meses entre ellas, tomando en cuenta el mes
     * de la fecha de inicio.
     *@return El numero de meses que hay entre fechas.
     */
    private int getNumeroRenglones() {
        FechasBean bean=(FechasBean) Bean.getBean("fechasBean");
        int mesInicial = bean.getFechaInicioEdificacion().getMonth();
        int mesFinal = bean.getFechaFinEdificacion().getMonth();
        int anioInicial = bean.getFechaInicioEdificacion().getYear();
        int anioFinal = bean.getFechaFinEdificacion().getYear();
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
    
    public String pasarVentas(){
        double suma=0;
        for(RegistroFecha r:lista){
            String valor =r.getPorcentaje().substring(0, r.getPorcentaje().length()-1);
            suma+=Double.parseDouble(valor);
        }
        suma=Funciones.redondearDecimales(suma, 1);
        System.out.println("la suma de los valores es de edificacion es de "+suma);
        if(suma==100.0){
            return "ventas";
        }
         FacesContext.getCurrentInstance().addMessage("edificacion:boton", new FacesMessage("La suma de los valores debe ser 100%"));
        return "";
    }
}