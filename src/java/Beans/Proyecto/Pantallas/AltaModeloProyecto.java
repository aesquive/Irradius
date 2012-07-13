/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.Proyecto.Pantallas;

import Beans.Bean;
import Beans.General.LoginBean;
import Beans.Proyecto.GeneralProyecto;
import base.Dao;
import calculador.proyecto.DistribuidorModeloProyectoIndividual;
import guardadores.Proyecto.GuardadorAltaModeloProyecto;
import java.util.LinkedList;
import java.util.List;
import pojos.MdlPryInd;
import pojos.PryPryInd;

/**
 *
 * @author RUMA
 */
public class AltaModeloProyecto {

    private String nombreModeloProyecto;
    private List<PryPryInd> listaProyectos;
    private Dao dao;
    private int proyectoSeleccionado;
    private LoginBean log;

    public AltaModeloProyecto() {
        listaProyectos = new LinkedList<PryPryInd>();
        dao = new Dao();
        log = (LoginBean) Bean.getBean("loginBean");
        checarProyectos(log);
    }

    public void checarProyectos(LoginBean log) {
        setListaProyectos(getDao().getProyectosIndividual(log.getUsuario()));
    }

    public String guardar() {
        PryPryInd proyecto = sacarProyectoSeleccionado();
        if (proyecto != null) {
            GuardadorAltaModeloProyecto guardador = new GuardadorAltaModeloProyecto(nombreModeloProyecto, log.getUsuario(),proyecto);
            MdlPryInd guadarProyectoInd = guardador.guadarProyectoInd();
            GeneralProyecto bean=(GeneralProyecto) Bean.getBean("generalProyecto");
            bean.agregarProyector(guadarProyectoInd);
            bean.setDis(new DistribuidorModeloProyectoIndividual(proyecto));
            bean.getDis().modelar();
            bean.getDis().llenarBeans();
            return "modeloelemVenta";
        }
        return "modeloelemVenta";
    }

    public String limpiaBeans() {
        Bean.limpiaBeans("modeloEstadoResultados", "modeloElemVenta", "modeloGeneradores",
                "modeloInfoBasica");
        return "pantalla";
    }

    /**
     * @return the nombreModeloProyecto
     */
    public String getNombreModeloProyecto() {
        return nombreModeloProyecto;
    }

    /**
     * @param nombreModeloProyecto the nombreModeloProyecto to set
     */
    public void setNombreModeloProyecto(String nombreModeloProyecto) {
        this.nombreModeloProyecto = nombreModeloProyecto;
    }

    /**
     * @return the listaProyectos
     */
    public List<PryPryInd> getListaProyectos() {
        return listaProyectos;
    }

    /**
     * @param listaProyectos the listaProyectos to set
     */
    public void setListaProyectos(List<PryPryInd> listaProyectos) {
        this.listaProyectos = listaProyectos;
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
     * @return the proyectoSeleccionado
     */
    public int getProyectoSeleccionado() {
        return proyectoSeleccionado;
    }

    /**
     * @param proyectoSeleccionado the proyectoSeleccionado to set
     */
    public void setProyectoSeleccionado(int proyectoSeleccionado) {
        this.proyectoSeleccionado = proyectoSeleccionado;
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

    private PryPryInd sacarProyectoSeleccionado() {
        int indice=this.proyectoSeleccionado;
        for(PryPryInd ind:listaProyectos){
            if(ind.getId()==indice){
                return ind;
            }
        }
        return null;
    }
}
