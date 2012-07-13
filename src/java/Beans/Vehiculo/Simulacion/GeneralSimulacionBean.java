/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.Vehiculo.Simulacion;

import Beans.Bean;
import Beans.General.LoginBean;
import base.Dao;
import calculador.vehiculo.DistribuidorModeloVehiculo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import pojos.MdlVeh;
import pojos.PryVeh;
import pojos.RelMdlVeh;
import util.Funciones;

/**
 *
 * @author alberto
 */
public class GeneralSimulacionBean extends Bean {
    public final static String sufijo="/home/alberto/apache-tomcat-7.0.14/webapps/Faces/";
    private List<MdlVeh> modelos;
    private Dao dao;
    private int modeloActual;
    private MdlVeh modeloSeleccionado;
    private LoginBean log;
    private DistribuidorModeloVehiculo distribuidor;

    /** Creates a new instance of GeneralModeloVehiculoBean */
    public GeneralSimulacionBean() {
        this.modeloActual = -1;
        dao = new Dao();
        log = (LoginBean) Bean.getBean("loginBean");
        checarModelos(log);
    }

    public void checarModelos(LoginBean log) {
        Object mdls = Funciones.sacarAttFaces("modelos");
        if(mdls==null){
            System.out.println("los modelos eran nulos , entonces meto los del dao");
            Funciones.ponerAtributo("modelos", dao.getModelos(log.getUsuario()));
        }
        modelos=(List<MdlVeh>) Funciones.sacarAttFaces("modelos");
    }

    public void agregarModelo(MdlVeh proyecto) {
        getModelos().add(proyecto);
    }

    public void quitarModelo(MdlVeh proyecto) {
        getModelos().remove(proyecto);
    }

    /**
     * @return the modelos
     */
    public List<MdlVeh> getModelos() {
        return modelos;
    }

    /**
     * @param modelos the modelos to set
     */
    public void setModelos(List<MdlVeh> modelos) {
        this.modelos = modelos;
    }

    /**
     * @return the dao
     */
    public Dao getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(Dao dao) {
        this.dao = dao;
    }

    /**
     * @return the modeloActual
     */
    public int getModeloActual() {
        return modeloActual;
    }

    /**
     * @param modeloActual the modeloActual to set
     */
    public void setModeloActual(int modeloActual) {
        this.modeloActual = modeloActual;
    }

    /**
     * @return the modeloSeleccionado
     */
    public MdlVeh getModeloSeleccionado() {
        return modeloSeleccionado;
    }

    /**
     * @param modeloSeleccionado the modeloSeleccionado to set
     */
    public void setModeloSeleccionado(MdlVeh modeloSeleccionado) {
        this.modeloSeleccionado = modeloSeleccionado;
    }

    /**
     * @return the log
     */
    public LoginBean getLog() {
        return log;
    }

    /**
     * @param log the log to set
     */
    public void setLog(LoginBean log) {
        this.log = log;
    }

    public String simular() {
        if (modeloActual != 0) {
            this.modeloSeleccionado = bucarModelo(modeloActual);
            guardarArchivoSimulacion(log.getUsuario().getId(),modeloActual);
            Funciones.ponerAtributo("modelos",null);
            Funciones.ponerAtributo("proyectos",null);
            return "menuPrincipal";
        } else {
            FacesContext.getCurrentInstance().addMessage("form:mensaje", new FacesMessage("Debe seleccionarse algun modelo"));
            return "";
        }
    }

    private MdlVeh bucarModelo(int mod) {
        for (MdlVeh m : modelos) {
            if (m.getId().equals(mod)) {
                return m;
            }
        }
        return null;
    }

    /**
     * @return the distribuidor
     */
    public DistribuidorModeloVehiculo getDistribuidor() {
        return distribuidor;
    }

    /**
     * @param distribuidor the distribuidor to set
     */
    public void setDistribuidor(DistribuidorModeloVehiculo distribuidor) {
        this.distribuidor = distribuidor;
    }

    private List<PryVeh> jalarProyectos(MdlVeh modelo) {
        Set<RelMdlVeh> relMdlVehs = modelo.getRelMdlVehs();
        List<PryVeh> proyectos = new LinkedList<PryVeh>();
        for (RelMdlVeh r : relMdlVehs) {
            proyectos.add(r.getPryVeh());
        }
        return proyectos;
    }

    public String crearInformes() {
        if (modeloActual != 0) {
            System.out.println("el modelo actual es "+modeloActual);
            this.modeloSeleccionado = bucarModelo(modeloActual);
            escribirArchivo(modeloActual);
            
        }
        return "";
    }


    private void escribirArchivo(int numero) {
        try {
              
            BufferedWriter writer=new BufferedWriter(new FileWriter(sufijo+"Reportes/archivo.conf"));
            writer.write(String.valueOf(numero));
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(GeneralSimulacionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
    public String menuPrincipal(){
        Bean.limpiaBeans("generalSimulacionBean");
        return "menuPrincipal";
    }

    private void guardarArchivoSimulacion(int numeroLogin , int numeroModelo) {
        try {
            String rutaSimulacion=sufijo+"Simulacion/simulacion.conf";
            BufferedWriter writer = new BufferedWriter(new FileWriter(rutaSimulacion));
            writer.write(String.valueOf(numeroLogin+"-"+numeroModelo));
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(GeneralSimulacionBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
