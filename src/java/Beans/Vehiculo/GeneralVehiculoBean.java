/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.Vehiculo;

import Beans.Bean;
import Beans.General.LoginBean;
import base.Dao;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import llenadores.vehiculo.LlenadorBeansCapturaVehiculo;
import pojos.PryVeh;
import pojos.Usu;
import pojos.UsuPryVeh;
import util.Funciones;

/**
 *
 * @author Alberto
 */
public class GeneralVehiculoBean extends Bean {

    public final static int GUARDAR = 1;
    public final static int ACTUALIZAR = 2;
    private List<PryVeh> proyectos;
    private Dao dao;
    private String busqueda;
    private int proyectoActual;
    private PryVeh proyectoSeleccionado;
    private int estadoGrabacion;
    private boolean cambioCopia;
    private boolean cambioCopiarapida;
    private boolean ver;
    public boolean modificar;
    private final LoginBean log;
    private List<PryVeh> copiaProyectos;

    public GeneralVehiculoBean() {
        ver=false;
        cambioCopia = false;
        modificar = true;
        cambioCopiarapida = false;
        this.proyectoActual = -1;
        this.estadoGrabacion = GUARDAR;
        dao = new Dao();
        dao.reiniciarSesion();
        log = (LoginBean) Bean.getBean("loginBean");
        checarProyectos(log);
    }

    public void checarProyectos(LoginBean log) {
        Object listaProyectos = Funciones.sacarAttFaces("proyectos");
        if (listaProyectos == null) {
            Funciones.ponerAtributo("proyectos", dao.getProyectos(dao.getUsu(log.getUsuario().getId())));
        }
        proyectos = (List<PryVeh>) Funciones.sacarAttFaces("proyectos");
    }

    public void agregarProyecto(PryVeh proyecto) {
        proyectos.add(proyecto);
        Funciones.ponerAtributo("proyectos", proyectos);
    }

    public void quitarProyecto(PryVeh proyecto) {
        proyectos.remove(proyecto);
    }

    /**
     * @return the proyectos
     */
    public List<PryVeh> getProyectos() {
        Object prys = Funciones.sacarAttFaces("proyectosBusqueda");
        proyectos =prys==null ?(List<PryVeh>) Funciones.sacarAttFaces("proyectos") : 
                (List<PryVeh>) Funciones.sacarAttFaces("proyectosBusqueda");
        return proyectos;
    }

    /**
     * @param proyectos the proyectos to set
     */
    public void setProyectos(List<PryVeh> proyectos) {
        this.proyectos = proyectos;
    }

    /**
     * @return the busqueda
     */
    public String getBusqueda() {
        return busqueda;
    }

    /**
     * @param busqueda the busqueda to set
     */
    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public void cambioProyecto(AjaxBehaviorEvent vc) {
        UIComponent component = vc.getComponent();
        Object valor = sacarValor(component, "value");
        this.proyectoActual = valor == null ? 0 : (Integer) valor;
        System.out.println("el valor del proyecto actual es " + this.proyectoActual);
        if (proyectoActual != 0) {
            this.proyectoSeleccionado = buscarEnLista();
            return;
        }
        this.proyectoSeleccionado = null;
        System.out.println("el proyecto seleccionado es " + getProyectoSeleccionado());
    }

    public void busquedaSeleccionada(AjaxBehaviorEvent event) {
        UIComponent component = event.getComponent();

        this.busqueda = (String) sacarValor(component, "value");
        System.out.println("la busqueda es " + busqueda);
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
        return dao.getPryVeh(proyectoActual);
    }

    public String baja() {
        Funciones.ponerAtributo("proyectosBusqueda", null);
        if (this.getProyectoSeleccionado() != null) {
            UsuPryVeh usuProyecto = obtenerUsuPry(log.getUsuario(), proyectoSeleccionado);
            usuProyecto.setEstPryVeh(dao.getEstatusProyecto(2));
            dao.actualizar(usuProyecto);
            dao.actualizar(this.getProyectoSeleccionado());
            Funciones.quitar((List<PryVeh>)Funciones.sacarAttFaces("proyectos") , proyectoSeleccionado.getId());
            proyectos=(List<PryVeh>) Funciones.sacarAttFaces("proyectos");
            proyectoSeleccionado=proyectos.get(0);
        }
        return "accionesVehiculo";
    }

    public String ver(){
        Funciones.ponerAtributo("proyectosBusqueda", null);
        if (getProyectoSeleccionado() != null) {
            UsuPryVeh usuProyecto = obtenerUsuPry(log.getUsuario(), proyectoSeleccionado);
            ver=true;
            LlenadorBeansCapturaVehiculo llenador = new LlenadorBeansCapturaVehiculo(this.getProyectoSeleccionado());
            llenador.llenarBeans();
            return "parametricas";
        }
        FacesContext.getCurrentInstance().addMessage("acciones:btnBusqueda", new FacesMessage("Se debe seleccionar un modelo a ver"));
        return "";
    }
    
    public String alta() {
        modificar=false;
        ver=false;
        Funciones.ponerAtributo("proyectosBusqueda", null);
        Bean.limpiaBeans("ventaBean", "titulacionBean", "etapasVehiculo", "escalonesTir", "edificacionBean", "fechasBean",
                "vehiculoInversion", "vehiculoFinancieras", "vehiculoParametricas", "etapasModeloVehiculoBean");
        return "parametricas";
    }

    public String modificar() {
        
        Funciones.ponerAtributo("proyectosBusqueda", null);
        if (getProyectoSeleccionado() != null) {
            UsuPryVeh usuProyecto = obtenerUsuPry(log.getUsuario(), proyectoSeleccionado);
            if (usuProyecto.getEstPryVeh().getId() == 3) {
                FacesContext.getCurrentInstance().addMessage("acciones:btnBusqueda", new FacesMessage("El proyecto no es editable"));
                return "";
            }
            cambioCopia = true;
            modificar = true;
            this.estadoGrabacion = ACTUALIZAR;
            LlenadorBeansCapturaVehiculo llenador = new LlenadorBeansCapturaVehiculo(this.getProyectoSeleccionado());
            llenador.llenarBeans();
            ver=false;
            return "parametricas";
        }
        FacesContext.getCurrentInstance().addMessage("acciones:btnBusqueda", new FacesMessage("Se debe seleccionar un modelo a copiar"));
        return "";
    }

    public String copiar() {
        
        Funciones.ponerAtributo("proyectosBusqueda", null);
        if (getProyectoSeleccionado() != null) {
            cambioCopia = true;
            modificar = false;
            this.estadoGrabacion = GUARDAR;
            LlenadorBeansCapturaVehiculo llenador = new LlenadorBeansCapturaVehiculo(this.getProyectoSeleccionado());
            llenador.llenarBeans();
            ver=false;
            VehiculoFamiliaParametricasBean parametricasBean = (VehiculoFamiliaParametricasBean) Bean.getBean("vehiculoParametricas");
            parametricasBean.setNombreProyecto("");
            Bean.ponerSesion("vehiculoParametricas", parametricasBean);
            return "parametricas";
        }
        
        FacesContext.getCurrentInstance().addMessage("acciones:btnBusqueda", new FacesMessage("Debe seleccionar un proyecto a copiar"));
        return "";
    }

    public String copiar2() {
        
        Funciones.ponerAtributo("proyectosBusqueda", null);
        if (getProyectoSeleccionado() != null) {
            LlenadorBeansCapturaVehiculo llenador = new LlenadorBeansCapturaVehiculo(this.getProyectoSeleccionado());
            llenador.llenarBeans();
            VehiculoFamiliaParametricasBean parametricasBean = (VehiculoFamiliaParametricasBean) Bean.getBean("vehiculoParametricas");
            parametricasBean.setNombreProyecto("");
            ver=false;
            Bean.ponerSesion("vehiculoParametricas", parametricasBean);
            return "copiadoRapido";
        }
        FacesContext.getCurrentInstance().addMessage("acciones:btnBusqueda", new FacesMessage("Debe seleccionar un proyecto a copiar"));
            
        return "";
    }

    /**
     * @return the proyectoSeleccionado
     */
    public PryVeh getProyectoSeleccionado() {
        return proyectoSeleccionado;
    }

    /**
     * @return the estadoGrabacion
     */
    public int getEstadoGrabacion() {
        return estadoGrabacion;
    }

    /**
     * @return the cambioCopia
     */
    public boolean isCambioCopia() {
        return cambioCopia;
    }

    public String empezarBusqueda() {
        LinkedList<PryVeh> prys = new LinkedList<PryVeh>();
        proyectos=(List<PryVeh>) Funciones.sacarAttFaces("proyectos");
        for (PryVeh pr : proyectos) {
            String cadena = String.valueOf(pr.getId()) + pr.getNomPry();
            System.out.println("evaluando " + pr.getNomPry() + " contra " + cadena);
            if (cadena.toLowerCase().contains(busqueda.toLowerCase())) {
                prys.add(pr);
            }
        }
        if (busqueda.equals("")) {
            FacesContext.getCurrentInstance().addMessage("acciones:btnBusqueda", new FacesMessage("No hay Proyectos"));
            return "accionesVehiculo";
        }
        Funciones.ponerAtributo("proyectosBusqueda",prys);
        return "";
    }

    public String verTodos() {
        Funciones.ponerAtributo("proyectosBusqueda", null);
        return "";
    }

    /**
     * @return the cambioCopiarapida
     */
    public boolean isCambioCopiarapida() {
        return cambioCopiarapida;
    }

    /**
     * @param cambioCopiarapida the cambioCopiarapida to set
     */
    public void setCambioCopiarapida(boolean cambioCopiarapida) {
        this.cambioCopiarapida = cambioCopiarapida;
    }

    private UsuPryVeh obtenerUsuPry(Usu idUsu, PryVeh idPry) {
        return dao.obtenerUsuPryVeh(idUsu, idPry);
    }

    /**
     * @return the ver
     */
    public boolean isVer() {
        return ver;
    }

    /**
     * @param ver the ver to set
     */
    public void setVer(boolean ver) {
        this.ver = ver;
    }
}
