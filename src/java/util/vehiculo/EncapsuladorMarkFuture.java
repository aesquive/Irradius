/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.vehiculo;

import java.util.List;
import pojos.MdlVeh;

/**
 *
 * @author alberto
 */
public class EncapsuladorMarkFuture {
    
    private int modeloSeleccionado;
    private MdlVeh modelo;
    private double WOE;
    private List<MdlVeh> modelosDisponibles;
    private int indiceEscenario;
   
    /**
     * @return the modelo
     */
    public MdlVeh getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(MdlVeh modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the WOE
     */
    public double getWOE() {
        return WOE;
    }

    /**
     * @param WOE the WOE to set
     */
    public void setWOE(double WOE) {
        this.WOE = WOE;
    }

    /**
     * @return the modeloSeleccionado
     */
    public int getModeloSeleccionado() {
        return modeloSeleccionado;
    }

    /**
     * @param modeloSeleccionado the modeloSeleccionado to set
     */
    public void setModeloSeleccionado(int modeloSeleccionado) {
        this.modeloSeleccionado = modeloSeleccionado;
    }

    /**
     * @return the modelosDisponibles
     */
    public List<MdlVeh> getModelosDisponibles() {
        return modelosDisponibles;
    }

    /**
     * @param modelosDisponibles the modelosDisponibles to set
     */
    public void setModelosDisponibles(List<MdlVeh> modelosDisponibles) {
        this.modelosDisponibles = modelosDisponibles;
    }

    /**
     * @return the indiceEscenario
     */
    public int getIndiceEscenario() {
        return indiceEscenario;
    }

    /**
     * @param indiceEscenario the indiceEscenario to set
     */
    public void setIndiceEscenario(int indiceEscenario) {
        this.indiceEscenario = indiceEscenario;
    }
    
}
