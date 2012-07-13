/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.Vehiculo.Pantallas;

import Beans.Bean;
import Beans.General.LoginBean;
import base.Dao;
import calculador.vehiculo.DistribuidorModeloVehiculo;
import guardadores.Vehiculo.GuardadorModeloVehiculo;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import pojos.MdlVeh;
import pojos.PryVeh;
import pojos.RelMdlVeh;
import util.Funciones;

/**
 *
 * @author alberto
 */
public class AltaModelo extends Bean {

    private DistribuidorModeloVehiculo distribuidorModeloVehiculo;
    private String nombreModelo;
    private List<PryVeh> proyectosIzquierda;
    private List<PryVeh> proyectosDerecha;
    private Dao dao;
    private int proyectoActualIzquierda;
    private int proyectoActualDerecha;
    private PryVeh proyectoSeleccionadoIzquierda;
    private PryVeh proyectoSeleccionadoDerecha;
    private LoginBean log;

    public AltaModelo() {
        proyectosDerecha = new LinkedList<PryVeh>();
        dao = new Dao();
        //dao.reiniciarSesion();
        log = (LoginBean) Bean.getBean("loginBean");
        checarProyectos(log);
    }

    public void checarProyectos(LoginBean log) {
        Object o = Funciones.sacarAttFaces("proyectos");
        if (o == null) {
            Funciones.ponerAtributo("proyectos", dao.getProyectos(dao.getUsu(log.getUsuario().getId())));
        }
        Funciones.ponerAtributo("copiaProyectos", Funciones.sacarAttFaces("proyectos"));
        proyectosIzquierda = (List<PryVeh>) Funciones.sacarAttFaces("proyectos");
    }

    public void cambioProyectoIzquierda(AjaxBehaviorEvent vc) {
        UIComponent component = vc.getComponent();
        Object valor = sacarValor(component, "value");
        this.setProyectoActualIzquierda(valor == null ? 0 : (Integer) valor);
        System.out.println("el valor del proyecto actual es " + this.getProyectoActualIzquierda());
        if (getProyectoActualIzquierda() != 0) {
            this.setProyectoSeleccionadoIzquierda(buscarEnLista(proyectosIzquierda, getProyectoActualIzquierda()));
            return;
        }
        this.setProyectoSeleccionadoIzquierda(null);
    }

    public void cambioProyectoDerecha(AjaxBehaviorEvent vc) {
        UIComponent component = vc.getComponent();
        Object valor = sacarValor(component, "value");
        this.setProyectoActualDerecha(valor == null ? 0 : (Integer) valor);
        System.out.println("el valor del proyecto actual es " + this.getProyectoActualDerecha());
        if (getProyectoActualDerecha() != 0) {
            this.setProyectoSeleccionadoDerecha(buscarEnLista(proyectosDerecha, getProyectoActualDerecha()));
            return;
        }
        this.setProyectoSeleccionadoDerecha(null);
    }

    public Object sacarValor(UIComponent component, String atributo) {
        return component.getAttributes().get(atributo);
    }

    private PryVeh buscarEnLista(List<PryVeh> lista, int comparacion) {
        for (PryVeh veh : lista) {
            if (veh.getId() == comparacion) {
                return veh;
            }
        }
        return null;
    }

    public String limpiaBeans() {
        this.proyectosIzquierda = (List<PryVeh>) Funciones.sacarAttFaces("proyectos");
        this.proyectosDerecha = new LinkedList<PryVeh>();
        this.nombreModelo = "";
//        dao.reiniciarSesion();
        Bean.limpiaBeans("generalSimulacionBean", "consolidadoBean",
                "generalModeloVehiculoBean", "etapasModeloVehiculoBean");
        return "seleccionProyecto";
    }

    /**
     * @return the proyectosIzquierda
     */
    public List<PryVeh> getProyectosIzquierda() {
        return proyectosIzquierda;
    }

    /**
     * @param proyectosIzquierda the proyectosIzquierda to set
     */
    public void setProyectosIzquierda(List<PryVeh> proyectosIzquierda) {
        this.proyectosIzquierda = proyectosIzquierda;
    }

    /**
     * @return the proyectosDerecha
     */
    public List<PryVeh> getProyectosDerecha() {
        return proyectosDerecha;
    }

    /**
     * @param proyectosDerecha the proyectosDerecha to set
     */
    public void setProyectosDerecha(List<PryVeh> proyectosDerecha) {
        this.proyectosDerecha = proyectosDerecha;
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
     * @return the proyectoActualIzquierda
     */
    public int getProyectoActualIzquierda() {
        return proyectoActualIzquierda;
    }

    /**
     * @param proyectoActualIzquierda the proyectoActualIzquierda to set
     */
    public void setProyectoActualIzquierda(int proyectoActualIzquierda) {
        this.proyectoActualIzquierda = proyectoActualIzquierda;
    }

    /**
     * @return the proyectoActualDerecha
     */
    public int getProyectoActualDerecha() {
        return proyectoActualDerecha;
    }

    /**
     * @param proyectoActualDerecha the proyectoActualDerecha to set
     */
    public void setProyectoActualDerecha(int proyectoActualDerecha) {
        this.proyectoActualDerecha = proyectoActualDerecha;
    }

    /**
     * @return the proyectoSeleccionadoIzquierda
     */
    public PryVeh getProyectoSeleccionadoIzquierda() {
        return proyectoSeleccionadoIzquierda;
    }

    /**
     * @param proyectoSeleccionadoIzquierda the proyectoSeleccionadoIzquierda to set
     */
    public void setProyectoSeleccionadoIzquierda(PryVeh proyectoSeleccionadoIzquierda) {
        this.proyectoSeleccionadoIzquierda = proyectoSeleccionadoIzquierda;
    }

    /**
     * @return the proyectoSeleccionadoDerecha
     */
    public PryVeh getProyectoSeleccionadoDerecha() {
        return proyectoSeleccionadoDerecha;
    }

    /**
     * @param proyectoSeleccionadoDerecha the proyectoSeleccionadoDerecha to set
     */
    public void setProyectoSeleccionadoDerecha(PryVeh proyectoSeleccionadoDerecha) {
        this.proyectoSeleccionadoDerecha = proyectoSeleccionadoDerecha;
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

    public String izquierdaDerecha() {
        if (this.proyectoSeleccionadoIzquierda != null) {
            this.proyectosDerecha.add(this.proyectoSeleccionadoIzquierda);
            this.proyectosIzquierda.remove(this.proyectoSeleccionadoIzquierda);
            this.proyectoSeleccionadoIzquierda = null;
            return "altaModelo";
        }
        FacesContext.getCurrentInstance().addMessage("altaModelo:mensaje", new FacesMessage("Debes seleccionar algun proyecto"));
        return "altaModelo";
    }

    public String derechaIzquierda() {

        if (this.proyectoSeleccionadoDerecha != null) {
            this.proyectosIzquierda.add(this.proyectoSeleccionadoDerecha);
            this.proyectosDerecha.remove(this.proyectoSeleccionadoDerecha);
            this.proyectoSeleccionadoDerecha = null;
            return "altaModelo";
        }
        FacesContext.getCurrentInstance().addMessage("altaModelo:mensaje", new FacesMessage("Debes seleccionar algun proyecto"));
        return "altaModelo";
    }

    public String guardar() {
        if (!nombreModelo.equals("") && proyectosDerecha.size() > 0) {
            GeneralModeloVehiculoBean bean = (GeneralModeloVehiculoBean) Bean.getBean("generalModeloVehiculoBean");
            Funciones.ponerAtributo("modelos", dao.getModelos(dao.getUsu(log.getUsuario().getId())));
            int id= bean.getModeloSeleccionado()!= null ? bean.getModeloSeleccionado().getId() : -1;
            GuardadorModeloVehiculo guardador = new GuardadorModeloVehiculo(bean.isEstaModificado(),id, proyectosDerecha, log.getUsuario(), nombreModelo);
            MdlVeh modelo = guardador.guardar();
            bean.setEstaModificado(false);
            bean.agregarModelo(modelo);
            Funciones.ponerAtributo("proyectos", dao.getProyectos(dao.getUsu(log.getUsuario().getId())));
            dao.reiniciarSesion();
            MdlVeh modeloSeleccionado = dao.getModeloVehiculo(modelo.getId());
            List<PryVeh> proyectos = new LinkedList<PryVeh>();
            Set<RelMdlVeh> relMdlVehs = modeloSeleccionado.getRelMdlVehs();
            for (RelMdlVeh relacion : relMdlVehs) {
                System.out.println("los proyectos para modelado son " + relacion.getPryVeh().getNomPry());
                proyectos.add(relacion.getPryVeh());
            }
            setDistribuidorModeloVehiculo(new DistribuidorModeloVehiculo(proyectos, true,modeloSeleccionado.getMesMin(),modeloSeleccionado.getMesPag()));
            getDistribuidorModeloVehiculo().modelarPrincipal();
            getDistribuidorModeloVehiculo().llenarBeansEtapas(0);
            return "menuModelo";
        }
        return "";
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


    public void agregarProyecto(PryVeh nuevo) {
        this.proyectosIzquierda.add(nuevo);
    }

    /**
     * @return the distribuidorModeloVehiculo
     */
    public DistribuidorModeloVehiculo getDistribuidorModeloVehiculo() {
        return distribuidorModeloVehiculo;
    }

    /**
     * @param distribuidorModeloVehiculo the distribuidorModeloVehiculo to set
     */
    public void setDistribuidorModeloVehiculo(DistribuidorModeloVehiculo distribuidorModeloVehiculo) {
        this.distribuidorModeloVehiculo = distribuidorModeloVehiculo;
    }
}
