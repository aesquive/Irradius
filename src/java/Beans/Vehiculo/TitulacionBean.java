package Beans.Vehiculo;

import Beans.Bean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import util.RegistroFecha;

/**
 * Clase que representa un ManagedBean para el llenado
 * de matrices de tiempo.
 * @author Galindo Martinez Jose Cruz
 */
public class TitulacionBean extends Bean {

    /**
     * Lista que contiene los registros con la fecha y el monto.
     */
    private LinkedList<RegistroFecha> listaTitulacion;

    /** Crea un nuevo objeto de la clase TitulacionBean */
    public TitulacionBean() {
        llenarLista();

    }

    public TitulacionBean(Object object) {
        
    }

    /**
     * Obtenemos la lista que contiene los registros.
     * @return La lista de registros con la fecha y el monto.
     */
    public LinkedList<RegistroFecha> getListaTitulacion() {
        return listaTitulacion;
    }
    
    public void llenarLista(){
        FechasBean bean=(FechasBean) Bean.getBean("fechasBean");
        Date original1 = bean.getFechaInicioTitulacion();
        Date original2 = bean.getFechaFinTitutlacion();
        Date fechaInicioEdificacion=(Date) original1.clone();
        Date fechaFinEdificacion=(Date) original2.clone();
        listaTitulacion=new LinkedList<RegistroFecha>();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMMM-yyyy");
        while(fechaInicioEdificacion.compareTo(fechaFinEdificacion)<0){
                String cad = sdf.format(fechaInicioEdificacion);
                RegistroFecha registro = new RegistroFecha(cad);
                listaTitulacion.add(registro);
                fechaInicioEdificacion.setMonth(fechaInicioEdificacion.getMonth()+1);
        }
        listaTitulacion.add(new RegistroFecha(sdf.format(fechaFinEdificacion)));  
        fechaInicioEdificacion.setMonth(original1.getMonth());
        fechaFinEdificacion.setYear(original1.getYear());
    }

    /**
     * Nos permite modificar la lista de registros.
     * @param listaTitulacion La nueva lista con registros.
     */
    public void setListaTitulacion(LinkedList<RegistroFecha> listaTitulacion) {
        this.listaTitulacion = listaTitulacion;
    }

    /**
     * Dadas las fechas de entrada se encarga de calcular
     * el numero de meses entre ellas, tomando en cuenta el mes
     * de la fecha de inicio.
     *@return El numero de meses que hay entre fechas.
     */
    private int getNumeroRenglones() {
        FechasBean bean=(FechasBean) Bean.getBean("fechasBean");
        int mesInicial = bean.getFechaInicioTitulacion().getMonth();
        int mesFinal = bean.getFechaFinTitutlacion().getMonth();
        int anioInicial = bean.getFechaInicioTitulacion().getYear();
        int anioFinal = bean.getFechaFinTitutlacion().getYear();
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
    
    public String pasarInversion(){
        int suma=0;
        for(RegistroFecha r:listaTitulacion){
            String valor =r.getPorcentaje().substring(0, r.getPorcentaje().length()-1);
            suma+=Double.parseDouble(valor);
        }
        if(suma==100.0){
            return "inversion";
        }
         FacesContext.getCurrentInstance().addMessage("titulacion:boton", new FacesMessage("La suma de los valores debe ser 100%"));
        return "";
    }
}
