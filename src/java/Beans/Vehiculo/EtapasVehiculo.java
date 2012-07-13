package Beans.Vehiculo;

import Beans.Bean;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import util.vehiculo.EtapaCapturaVehiculo;

/**
 *
 * @author alberto
 */
public class EtapasVehiculo extends Bean {

    private List<EtapaCapturaVehiculo> etapas;
    private int viviendasEtapa;
//    private String vivet;
    private Date fechaInicioEtapa;
    private Date fechaFinEtapa;
    private int escalonActual;

    public EtapasVehiculo() {
        escalonActual = 1;
        etapas = new LinkedList<EtapaCapturaVehiculo>();
    }

    public EtapasVehiculo(Object object) {
        escalonActual = 1;
    }

    private void llenarValores(EtapaCapturaVehiculo etapa) {
        if(etapa==null){
            setViviendasEtapa(0);
            setFechaInicioEtapa(null);
            setFechaFinEtapa(null);
            return;
        }
        this.setViviendasEtapa(etapa.getViviendasEtapa());
        this.fechaInicioEtapa=etapa.getFechaInicioEtapa();
        this.fechaFinEtapa=etapa.getFechaFinEtapa();
    } 

    public String guardarEtapa() {
        VehiculoFamiliaPremisasFinancieras bean = (VehiculoFamiliaPremisasFinancieras) Bean.getBean("vehiculoFinancieras");
        int etapasReales = (bean.getNumeroEtapas());
        guardarBean();
        if (this.getEscalonActual() != etapasReales) {
            setEscalonActual(getEscalonActual() + 1);
            llenarBean(getEscalonActual());
            return "etapas";
        } else {
            return "fechas";
        }
    }

    public String regresarEtapa() {

        guardarBean();

        if (this.getEscalonActual() == 1) {
            return "financieras";
        } else {
            setEscalonActual(getEscalonActual() - 1);
            llenarBean(getEscalonActual());
            return "etapas";
        }

    }

    private void llenarBean(int numeroBean) {
        EtapaCapturaVehiculo etapa = null;
        try {
            etapa = getEtapas().get(numeroBean - 1);

        } catch (IndexOutOfBoundsException out) {
            llenarValores(etapa);
            return;
        }
        llenarValores(etapa);
        
    }

    private void guardarBean() {
        EtapaCapturaVehiculo etapa = new EtapaCapturaVehiculo(this.viviendasEtapa, this.fechaInicioEtapa,fechaFinEtapa);
        int tmp = getEscalonActual() - 1;
        try {
               getEtapas().get(tmp);
        } catch (IndexOutOfBoundsException out) {
            getEtapas().add(tmp, etapa);
            return;
        }
        getEtapas().set(tmp, etapa);
    }
    
//    private int  convertirviviendas(){
//       viviendasEtapa= Integer.parseInt(vivet);
//       return viviendasEtapa;
//    }

    /**
     * @return the etapas
     */
    public List<EtapaCapturaVehiculo> getEtapas() {
        return etapas;
    }

    /**
     * @param etapas the etapas to set
     */
    public void setEtapas(List<EtapaCapturaVehiculo> etapas) {
        this.etapas = etapas;
    }

    /**
     * @return the viviendasEtapa
     */
    public int getViviendasEtapa() {
        return viviendasEtapa;
    }

    /**
     * @param viviendasEtapa the viviendasEtapa to set
     */
    public void setViviendasEtapa(int viviendasEtapa) {
        this.viviendasEtapa = viviendasEtapa;
    }

    /**
     * @return the fechaInicioEtapa
     */
    public Date getFechaInicioEtapa() {
        return fechaInicioEtapa;
    }

    /**
     * @param fechaInicioEtapa the fechaInicioEtapa to set
     */
    public void setFechaInicioEtapa(Date fechaInicioEtapa) {
        this.fechaInicioEtapa = fechaInicioEtapa;
    }

    /**
     * @return the fechaFinEtapa
     */
    public Date getFechaFinEtapa() {
        return fechaFinEtapa;
    }

    /**
     * @param fechaFinEtapa the fechaFinEtapa to set
     */
    public void setFechaFinEtapa(Date fechaFinEtapa) {
        this.fechaFinEtapa = fechaFinEtapa;
    }

    /**
     * @return the escalonActual
     */
    public int getEscalonActual() {
        return escalonActual;
    }

    /**
     * @param escalonActual the escalonActual to set
     */
    public void setEscalonActual(int escalonActual) {
        this.escalonActual = escalonActual;
    }

//    /**
//     * @return the vivet
//     */
//    public String getVivet() {
//        return vivet;
//    }
//
//    /**
//     * @param vivet the vivet to set
//     */
//    public void setVivet(String vivet) {
//        this.vivet = vivet;
//    }


}
