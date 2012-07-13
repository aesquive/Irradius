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
 * Clase que representa un ManagedBean para el llenado
 * de matrices de tiempo.
 * @author Galindo Martinez Jose Cruz
 */
public class VentaBean extends Bean {

    /**
     * Lista que contiene los registros con la fecha y el monto.
     */
    private LinkedList<RegistroFecha> listaVenta;

    /** Crea un nuevo objeto de la clase VentaBean */
    public VentaBean() {
        llenarLista();

    }

    public VentaBean(Object object) {
        
    }

    /**
     * Obtenemos la lista que contiene los registros.
     * @return La lista de registros con la fecha y el monto.
     */
    public LinkedList<RegistroFecha> getListaVenta() {
       return this.listaVenta;
    }

    public void llenarLista(){
        FechasBean bean=(FechasBean) Bean.getBean("fechasBean");
        Date original1 = bean.getFechaInicioVenta();
        Date fechaInicioEdificacion=(Date) original1.clone();
        Date original2 = bean.getFechaFinVenta();
        Date fechaFinEdificacion=(Date) original2.clone();
        listaVenta=new LinkedList<RegistroFecha>();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMMM-yyyy");
        while(fechaInicioEdificacion.compareTo(fechaFinEdificacion)<0){
                String cad = sdf.format(fechaInicioEdificacion);
                RegistroFecha registro = new RegistroFecha(cad);
                listaVenta.add(registro);
                fechaInicioEdificacion.setMonth(fechaInicioEdificacion.getMonth()+1);
        }
        RegistroFecha last = listaVenta.getLast();
        if(!last.getFecha().equals(sdf.format(fechaFinEdificacion))){
            listaVenta.add(new RegistroFecha(sdf.format(fechaFinEdificacion)));
        }
    }
    /**
     * Nos permite modificar la lista de registros.
     * @param listaVenta La nueva lista de registros.
     */
    public void setListaVenta(LinkedList<RegistroFecha> listaVenta) {
        this.listaVenta = listaVenta;
    }

    /**
     * Dadas las fechas de entrada se encarga de calcular
     * el numero de meses entre ellas, tomando en cuenta el mes
     * de la fecha de inicio.
     *@return El numero de meses que hay entre fechas.
     */
    private int getNumeroRenglones() {
        FechasBean bean=(FechasBean) Bean.getBean("fechasBean");
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
    
    
    public String pasarTitulacion(){
        double suma=0;
        for(RegistroFecha r:listaVenta){
            String valor =r.getPorcentaje().substring(0, r.getPorcentaje().length()-1);
            suma+=Double.parseDouble(valor);
        }
        suma=Funciones.redondearDecimales(suma, 1);
        if(suma==100.0){
            return "inversion";
        }
         FacesContext.getCurrentInstance().addMessage("ventas:boton", new FacesMessage("La suma de los valores debe ser 100%"));
        return "";
    }
}
