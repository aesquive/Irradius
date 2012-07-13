/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.Configuracion;

import Beans.Bean;
import Beans.General.LoginBean;
import base.Dao;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import pojos.*;

/**
 *
 * @author alberto
 */
public class AsignacionModelo {

    private List<MdlVeh> proyectos;
    private Dao dao;
    private int proyectoActual;
    private LoginBean log;
    private int usuarioActual;
    private List<Usu> usuarios;

    public AsignacionModelo() {
        this.usuarioActual = this.proyectoActual = -1;
        dao = new Dao();
        log = (LoginBean) Bean.getBean("loginBean");
        checarProyectos(log);
        usuarios = checarUsuarios(log.getUsuario());
    }

    public void checarProyectos(LoginBean log) {
        proyectos = dao.getModelos(dao.getUsu(log.getUsuario().getId()));
    }

    private List<Usu> checarUsuarios(Usu usuario) {
        List<Usu> regreso = new LinkedList<Usu>();
        List<Usu> tablaUsuarios = dao.getTabla(Usu.class);
        for (Usu u : tablaUsuarios) {
            if (u.getTipUsu().getId() <= usuario.getTipUsu().getId()) {
                regreso.add(u);
            }
        }
        return regreso;
    }

    /**
     * @return the proyectos
     */
    public List<MdlVeh> getProyectos() {
        return proyectos;
    }

    /**
     * @param proyectos the proyectos to set
     */
    public void setProyectos(List<MdlVeh> proyectos) {
        this.proyectos = proyectos;
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
     * @return the proyectoActual
     */
    public int getProyectoActual() {
        return proyectoActual;
    }

    /**
     * @param proyectoActual the proyectoActual to set
     */
    public void setProyectoActual(int proyectoActual) {
        this.proyectoActual = proyectoActual;
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

    /**
     * @return the usuarioActual
     */
    public int getUsuarioActual() {
        return usuarioActual;
    }

    /**
     * @param usuarioActual the usuarioActual to set
     */
    public void setUsuarioActual(int usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    /**
     * @return the usuarios
     */
    public List<Usu> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<Usu> usuarios) {
        this.usuarios = usuarios;
    }

    public String asignarProyecto() {
        if (usuarioActual == -1 && proyectoActual == -1) {
            FacesContext.getCurrentInstance().addMessage("asignacionVehiculo:mensaje", new FacesMessage("Debe elegir un usuario y un modelo"));
            return "asignacionModelo";
        }
        Usu usuario = null;
        MdlVeh proyecto = null;
        for (Usu u : usuarios) {
            if (u.getId() == this.usuarioActual) {
                usuario = u;
                break;
            }
        }
        for (MdlVeh pr : proyectos) {
            if (pr.getId() == this.proyectoActual) {
                proyecto = pr;
                break;
            }
        }
        guardarProyectosUsuario(usuario,proyecto);
        UsuMdlVeh usuarioProyecto = new UsuMdlVeh( proyecto,usuario , dao.getEstatusProyecto(3));
        dao.guardar(usuarioProyecto);
        Bean.limpiaBeans("asignacionModelo");
        return "accionesConfiguracion";
    }

    private void guardarProyectosUsuario(Usu usuario, MdlVeh proyecto) {
        EstPryVeh estatus=dao.getEstatusProyecto(3);
        Set<RelMdlVeh> relMdlVehs = proyecto.getRelMdlVehs();
        for(RelMdlVeh rel:relMdlVehs){
            
            dao.guardar(new UsuPryVeh(usuario, rel.getPryVeh(),estatus));
        }
    }
}
