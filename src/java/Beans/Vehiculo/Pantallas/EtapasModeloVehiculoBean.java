package Beans.Vehiculo.Pantallas;

import Beans.Bean;
import calculador.vehiculo.DistribuidorModeloVehiculo;
import java.io.Serializable;
import java.util.List;
import util.CeldaFechaValor;
import util.MatrizBidimensionalIndice;
import util.MatrizBidimensionalIndice;


/**
 *
 * @author JOSELUIS
 */
public class EtapasModeloVehiculoBean extends Bean implements Serializable{
    
    private CeldaFechaValor celda;
    private int numeroProyectos;
    private int indiceActual;
    private String nombreProyecto;
    private List<MatrizBidimensionalIndice> veh_uni_edf_mes; 
    private List<MatrizBidimensionalIndice> veh_uni_edf_pry; 
    private List<MatrizBidimensionalIndice> veh_uni_edf_acu; 
    private List<MatrizBidimensionalIndice> veh_uni_dis; 
    private List<MatrizBidimensionalIndice> veh_uni_dis_acu; 
    private List<MatrizBidimensionalIndice> veh_uni_ven; 
    private List<MatrizBidimensionalIndice> veh_uni_ven_acu; 
    private List<MatrizBidimensionalIndice> veh_des_ini; 
    private List<MatrizBidimensionalIndice> veh_fir_ctr_cpr_vta; 
    private List<MatrizBidimensionalIndice> veh_cto_vta; 
    private List<MatrizBidimensionalIndice> veh_cto_gav; 
    private List<MatrizBidimensionalIndice> veh_cto_gas_ind; 
    private List<MatrizBidimensionalIndice> veh_mar_res;

    
    public EtapasModeloVehiculoBean(){
    }

    /**
     * @return the celda
     */
    public CeldaFechaValor getCelda() {
        return celda;
    }

    /**
     * @param celda the celda to set
     */
    public void setCelda(CeldaFechaValor celda) {
        this.celda = celda;
    }

    /**
     * @return the numeroProyectos
     */
    public int getNumeroProyectos() {
        return numeroProyectos;
    }

    /**
     * @param numeroProyectos the numeroProyectos to set
     */
    public void setNumeroProyectos(int numeroProyectos) {
        this.numeroProyectos = numeroProyectos;
    }

    /**
     * @return the indiceActual
     */
    public int getIndiceActual() {
        return indiceActual;
    }

    /**
     * @param indiceActual the indiceActual to set
     */
    public void setIndiceActual(int indiceActual) {
        this.indiceActual = indiceActual;
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
     * @return the veh_uni_edf_mes
     */
    public List<MatrizBidimensionalIndice> getVeh_uni_edf_mes() {
        return veh_uni_edf_mes;
    }

    /**
     * @param veh_uni_edf_mes the veh_uni_edf_mes to set
     */
    public void setVeh_uni_edf_mes(List<MatrizBidimensionalIndice> veh_uni_edf_mes) {
        this.veh_uni_edf_mes = veh_uni_edf_mes;
    }

    /**
     * @return the veh_uni_edf_pry
     */
    public List<MatrizBidimensionalIndice> getVeh_uni_edf_pry() {
        return veh_uni_edf_pry;
    }

    /**
     * @param veh_uni_edf_pry the veh_uni_edf_pry to set
     */
    public void setVeh_uni_edf_pry(List<MatrizBidimensionalIndice> veh_uni_edf_pry) {
        this.veh_uni_edf_pry = veh_uni_edf_pry;
    }

    /**
     * @return the veh_uni_edf_acu
     */
    public List<MatrizBidimensionalIndice> getVeh_uni_edf_acu() {
        return veh_uni_edf_acu;
    }

    /**
     * @param veh_uni_edf_acu the veh_uni_edf_acu to set
     */
    public void setVeh_uni_edf_acu(List<MatrizBidimensionalIndice> veh_uni_edf_acu) {
        this.veh_uni_edf_acu = veh_uni_edf_acu;
    }

    /**
     * @return the veh_uni_dis
     */
    public List<MatrizBidimensionalIndice> getVeh_uni_dis() {
        return veh_uni_dis;
    }

    /**
     * @param veh_uni_dis the veh_uni_dis to set
     */
    public void setVeh_uni_dis(List<MatrizBidimensionalIndice> veh_uni_dis) {
        this.veh_uni_dis = veh_uni_dis;
    }

    /**
     * @return the veh_uni_dis_acu
     */
    public List<MatrizBidimensionalIndice> getVeh_uni_dis_acu() {
        return veh_uni_dis_acu;
    }

    /**
     * @param veh_uni_dis_acu the veh_uni_dis_acu to set
     */
    public void setVeh_uni_dis_acu(List<MatrizBidimensionalIndice> veh_uni_dis_acu) {
        this.veh_uni_dis_acu = veh_uni_dis_acu;
    }

    /**
     * @return the veh_uni_ven
     */
    public List<MatrizBidimensionalIndice> getVeh_uni_ven() {
        return veh_uni_ven;
    }

    /**
     * @param veh_uni_ven the veh_uni_ven to set
     */
    public void setVeh_uni_ven(List<MatrizBidimensionalIndice> veh_uni_ven) {
        this.veh_uni_ven = veh_uni_ven;
    }

    /**
     * @return the veh_uni_ven_acu
     */
    public List<MatrizBidimensionalIndice> getVeh_uni_ven_acu() {
        return veh_uni_ven_acu;
    }

    /**
     * @param veh_uni_ven_acu the veh_uni_ven_acu to set
     */
    public void setVeh_uni_ven_acu(List<MatrizBidimensionalIndice> veh_uni_ven_acu) {
        this.veh_uni_ven_acu = veh_uni_ven_acu;
    }

    /**
     * @return the veh_des_ini
     */
    public List<MatrizBidimensionalIndice> getVeh_des_ini() {
        return veh_des_ini;
    }

    /**
     * @param veh_des_ini the veh_des_ini to set
     */
    public void setVeh_des_ini(List<MatrizBidimensionalIndice> veh_des_ini) {
        this.veh_des_ini = veh_des_ini;
    }

    /**
     * @return the veh_fir_ctr_cpr_vta
     */
    public List<MatrizBidimensionalIndice> getVeh_fir_ctr_cpr_vta() {
        return veh_fir_ctr_cpr_vta;
    }

    /**
     * @param veh_fir_ctr_cpr_vta the veh_fir_ctr_cpr_vta to set
     */
    public void setVeh_fir_ctr_cpr_vta(List<MatrizBidimensionalIndice> veh_fir_ctr_cpr_vta) {
        this.veh_fir_ctr_cpr_vta = veh_fir_ctr_cpr_vta;
    }

    /**
     * @return the veh_cto_vta
     */
    public List<MatrizBidimensionalIndice> getVeh_cto_vta() {
        return veh_cto_vta;
    }

    /**
     * @param veh_cto_vta the veh_cto_vta to set
     */
    public void setVeh_cto_vta(List<MatrizBidimensionalIndice> veh_cto_vta) {
        this.veh_cto_vta = veh_cto_vta;
    }

    /**
     * @return the veh_cto_gav
     */
    public List<MatrizBidimensionalIndice> getVeh_cto_gav() {
        return veh_cto_gav;
    }

    /**
     * @param veh_cto_gav the veh_cto_gav to set
     */
    public void setVeh_cto_gav(List<MatrizBidimensionalIndice> veh_cto_gav) {
        this.veh_cto_gav = veh_cto_gav;
    }

    /**
     * @return the veh_cto_gas
     */
    public List<MatrizBidimensionalIndice> getVeh_cto_gas_ind() {
        return veh_cto_gas_ind;
    }

    /**
     * @param veh_cto_gas the veh_cto_gas to set
     */
    public void setVeh_cto_gas_ind(List<MatrizBidimensionalIndice> veh_cto_gas) {
        this.veh_cto_gas_ind = veh_cto_gas;
    }

    /**
     * @return the veh_mar_res
     */
    public List<MatrizBidimensionalIndice> getVeh_mar_res() {
        return veh_mar_res;
    }

    /**
     * @param veh_mar_res the veh_mar_res to set
     */
    public void setVeh_mar_res(List<MatrizBidimensionalIndice> veh_mar_res) {
        this.veh_mar_res = veh_mar_res;
    }
    
    
    public String mandarSiguiente(){
        indiceActual++;
        if(indiceActual==numeroProyectos){
            return "seleccionProyectos";
        }
        else{
            AltaModelo bean = (AltaModelo) Bean.getBean("altaModelo");
            DistribuidorModeloVehiculo dis = bean.getDistribuidorModeloVehiculo();
            dis.llenarBeansEtapas(indiceActual);
            return "unidadesEdificadas";
        }
    }
      
}
