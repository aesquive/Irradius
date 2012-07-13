/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.Vehiculo.Pantallas;

import Beans.Bean;
import Beans.General.LoginBean;
import base.Dao;
import guardadores.Vehiculo.GuardadorModeloVehiculo;
import java.util.List;
import pojos.MdlVeh;
import pojos.PryVeh;
import util.Funciones;

/**
 *
 * @author alberto
 */
public class BeanCopiador extends Bean{

    private String nombreModelo;
    private List<PryVeh> proyectos;
    private final Dao dao;
    private LoginBean log;
    
    /** Creates a new instance of BeanCopiador */
    public BeanCopiador() {
        dao=new Dao();
        log = (LoginBean) Bean.getBean("loginBean");
    }

    /**
     * @return the nombreModelo
     */
    public String getNombreModelo() {
        return nombreModelo;
    }

    /**
     * @param nombreModelo the nombreModelo to set
     */
    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    /**
     * @return the proyectos
     */
    public List<PryVeh> getProyectos() {
        return proyectos;
    }

    /**
     * @param proyectos the proyectos to set
     */
    public void setProyectos(List<PryVeh> proyectos) {
        this.proyectos = proyectos;
    }


    
    public String guardar(){
        Funciones.ponerAtributo("modelos", dao.getModelos(dao.getUsu(log.getUsuario().getId())));
        GuardadorModeloVehiculo guardador = new GuardadorModeloVehiculo(false , -1,proyectos, log.getUsuario(), nombreModelo);
        MdlVeh modelo = guardador.guardar();
        GeneralModeloVehiculoBean bean = (GeneralModeloVehiculoBean) Bean.getBean("generalModeloVehiculoBean");
        bean.agregarModelo(modelo);
        Funciones.ponerAtributo("proyectos", dao.getProyectos(dao.getUsu(log.getUsuario().getId())));
        dao.reiniciarSesion();
        return "seleccionProyectos";
    }
}
