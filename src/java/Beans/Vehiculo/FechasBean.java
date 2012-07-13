/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.Vehiculo;

import Beans.Bean;
import com.sun.org.apache.xpath.internal.functions.FuncBoolean;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import util.Espejo;
import util.Funciones;

/**
 *
 * @author Alberto
 */
public class FechasBean extends Bean {

    private Date fechaInicioEdificacion;
    private Date fechaFinEdficacion;
    private Date fechaInicioVenta;
    private Date fechaFinVenta;
    private Date fechaInicioTitulacion;
    private Date fechaFinTitutlacion;

    public FechasBean() {
    }

    public String pasarEdificacion(){
        List<Method> ters = Espejo.getGetters(FechasBean.class);
        for(Method m:ters){
            Object ob = Funciones.sacarAttFaces(m.getName());
            if(ob!=null ){
                Date actual = (Date) Espejo.invocarGetter(this, m);
                Date casteado=(Date) ob;
                if(casteado.getYear()!=actual.getYear() || casteado.getMonth()!=actual.getMonth()){
                    String nombre=m.getName().contains("Edificacion")?"edificacionBean" :m.getName().contains("Venta")? "ventaBean" : "titulacionBean";
                    Bean.ponerSesion(nombre, null);
                }
            }
        }
        return "edificacion";
    }
    
    public FechasBean(Object object) {
        
    }

    /**
     * @return the fechaInicioEdificacion
     */
    public Date getFechaInicioEdificacion() {
        return fechaInicioEdificacion;
    }

    /**
     * @param fechaInicioEdificacion the fechaInicioEdificacion to set
     */
    public void setFechaInicioEdificacion(Date fechaInicioEdificacion) {

        this.fechaInicioEdificacion = fechaInicioEdificacion;
        GeneralVehiculoBean general = (GeneralVehiculoBean) Bean.getBean("generalVehiculoBean");
        EdificacionBean bean = (EdificacionBean) Bean.getBean("edificacionBean");
        if (fechaFinEdficacion != null && bean != null && !general.isCambioCopia()) {
            bean.llenarLista();
        }
    }

    /**
     * @return the fechaFinEdficacion
     */
    public Date getFechaFinEdificacion() {
        return fechaFinEdficacion;
    }

    /**
     * @param fechaFinEdficacion the fechaFinEdficacion to set
     */
    public void setFechaFinEdificacion(Date fechaFinEdficacion) {
        this.fechaFinEdficacion = fechaFinEdficacion;
        GeneralVehiculoBean general = (GeneralVehiculoBean) Bean.getBean("generalVehiculoBean");
        EdificacionBean bean = (EdificacionBean) Bean.getBean("edificacionBean");
        if (fechaInicioEdificacion != null && bean != null && !general.isCambioCopia()) {
            bean.llenarLista();
        }
    }

    /**
     * @return the fechaInicioVenta
     */
    public Date getFechaInicioVenta() {
        return fechaInicioVenta;
    }

    /**
     * @param fechaInicioVenta the fechaInicioVenta to set
     */
    public void setFechaInicioVenta(Date fechaInicioVenta) {
        this.fechaInicioVenta = fechaInicioVenta;
        GeneralVehiculoBean general = (GeneralVehiculoBean) Bean.getBean("generalVehiculoBean");
        VentaBean bean = (VentaBean) Bean.getBean("ventaBean");
        if (fechaFinVenta != null && bean != null && !general.isCambioCopia()) {
            bean.llenarLista();
        }
    }

    /**
     * @return the fechaFinVenta
     */
    public Date getFechaFinVenta() {
        return fechaFinVenta;
    }

    /**
     * @param fechaFinVenta the fechaFinVenta to set
     */
    public void setFechaFinVenta(Date fechaFinVenta) {
        this.fechaFinVenta = fechaFinVenta;
        GeneralVehiculoBean general = (GeneralVehiculoBean) Bean.getBean("generalVehiculoBean");
        VentaBean bean = (VentaBean) Bean.getBean("ventaBean");
        if (fechaInicioVenta != null && bean != null && !general.isCambioCopia()) {

            bean.llenarLista();
        }
    }

    /**
     * @return the fechaInicioTitulacion
     */
    public Date getFechaInicioTitulacion() {
        return fechaInicioTitulacion;
    }

    /**
     * @param fechaInicioTitulacion the fechaInicioTitulacion to set
     */
    public void setFechaInicioTitulacion(Date fechaInicioTitulacion) {
        this.fechaInicioTitulacion = fechaInicioTitulacion;
        GeneralVehiculoBean general = (GeneralVehiculoBean) Bean.getBean("generalVehiculoBean");
        TitulacionBean bean = (TitulacionBean) Bean.getBean("titulacionBean");
        if (fechaFinTitutlacion != null && bean != null && !general.isCambioCopia()) {
            bean.llenarLista();
        }
    }

    /**
     * @return the fechaFinTitutlacion
     */
    public Date getFechaFinTitutlacion() {
        return fechaFinTitutlacion;
    }

    /**
     * @param fechaFinTitutlacion the fechaFinTitutlacion to set
     */
    public void setFechaFinTitutlacion(Date fechaFinTitutlacion) {
        this.fechaFinTitutlacion = fechaFinTitutlacion;
        GeneralVehiculoBean general = (GeneralVehiculoBean) Bean.getBean("generalVehiculoBean");
        TitulacionBean bean = (TitulacionBean) Bean.getBean("titulacionBean");
        if (fechaInicioTitulacion != null && bean != null && !general.isCambioCopia()) {
            bean.llenarLista();
        }
    }

    public void ponerFechas(Date inicioEdificacion, Date finEdificacion, Date inicioVenta, Date finVenta,
            Date inicioTitulacion, Date finTitulacion) {
        this.fechaInicioEdificacion = inicioEdificacion;
        this.fechaFinEdficacion = finEdificacion;
        this.fechaInicioVenta = inicioVenta;
        this.fechaFinVenta = finVenta;
        this.fechaInicioTitulacion = inicioTitulacion;
        this.fechaFinTitutlacion = finTitulacion;
    }
}
