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
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import pojos.EstPryVeh;
import pojos.PryVeh;
import pojos.Usu;
import pojos.UsuPryVeh;

/**
 *
 * @author alberto
 */
public class AsignacionVehiculo {

    private List<PryVeh> proyectos;
    private Dao dao;
    private int proyectoActual;
    private final LoginBean log;
    
    
    private int usuarioActual;
    private List<Usu> usuarios;
    

    public AsignacionVehiculo() {
        this.usuarioActual=this.proyectoActual=-1;
        dao = new Dao();
        log = (LoginBean) Bean.getBean("loginBean");
        checarProyectos(log);
        usuarios=checarUsuarios(log.getUsuario());
    }

    public void checarProyectos(LoginBean log) {
        proyectos = dao.getProyectos(dao.getUsu(log.getUsuario().getId()));
    }

    public void agregarProyecto(PryVeh proyecto) {
        proyectos.add(proyecto);
    }

    public void quitarProyecto(PryVeh proyecto) {
        proyectos.remove(proyecto);
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


    public Object sacarValor(UIComponent component, String atributo) {
        return component.getAttributes().get(atributo);
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

    private PryVeh buscarEnLista() {
        for (PryVeh veh : proyectos) {
            if (veh.getId() == proyectoActual) {
                return veh;
            }
        }
        return null;
    }

    /**
     * @return the usuarioActual
     */
    public int getUsuarioActual() {
        return usuarioActual;
    }

    /**dao
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

    private List<Usu> checarUsuarios(Usu usuario) {
        List<Usu> regreso=new LinkedList<Usu>();
        List<Usu> tablaUsuarios = dao.getTabla(Usu.class);
        for(Usu u:tablaUsuarios){
            System.out.println("el usuario es "+u.getLogUsu()+" su permiso es "+u.getTipUsu().getId());
            System.out.println("comparando "+u.getTipUsu().getId()+" con "+usuario.getTipUsu().getId());
            if(u.getTipUsu().getId()<=usuario.getTipUsu().getId()){
                regreso.add(u);
            }
        }
        return regreso;
    }

    
    public String asignarProyecto(){
        if(usuarioActual==-1 && proyectoActual==-1 ){
            FacesContext.getCurrentInstance().addMessage("asignacionVehiculo:mensaje", new FacesMessage("Debe elegir un usuario y un proyecto"));
            return "asignacionVehiculo";
        }
        Usu usuario=null;
        PryVeh proyecto=null;
        for(Usu u:usuarios){
            if(u.getId()==this.usuarioActual){
                usuario=u;
                break;
            }
        }
        for(PryVeh  pr: proyectos){
            if(pr.getId()==this.proyectoActual){
                proyecto=pr;
                break;
            }
        }
        EstPryVeh estatus=dao.getEstatusProyecto(3);
        UsuPryVeh usuarioProyecto=new UsuPryVeh(usuario, proyecto,estatus);
        dao.guardar(usuarioProyecto);
        Bean.limpiaBeans("asignacionVehiculo");
        return "accionesConfiguracion";
    }
}
