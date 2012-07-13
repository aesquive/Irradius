/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.Vehiculo.Pantallas;

import Beans.Bean;
import Beans.General.LoginBean;
import base.Dao;
import calculador.vehiculo.DistribuidorModeloVehiculo;
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
import pojos.Usu;
import pojos.UsuMdlVeh;
import util.Funciones;

/**
 *
 * @author alberto
 */
public class GeneralModeloVehiculoBean extends Bean {

    public final static int GUARDAR = 1;
    public final static int ACTUALIZAR = 2;
    private List<MdlVeh> modelos;
    private Dao dao;
    private String busqueda;
    private int modeloActual;
    private MdlVeh modeloSeleccionado;
    private int estadoGrabacion;
    private boolean cambioCopia;
    private boolean modificar;
    private LoginBean log;
    private List<MdlVeh> copiaProyectos;
    private boolean estaModificado;
    
    /** Creates a new instance of GeneralModeloVehiculoBean */
    public GeneralModeloVehiculoBean() {
        estaModificado=false;
        cambioCopia = false;
        modificar = true;
        this.modeloActual = -1;
        this.estadoGrabacion = GUARDAR;
        dao = new Dao();
        dao.reiniciarSesion();
        log = (LoginBean) Bean.getBean("loginBean");
        checarModelos(log);
    }

    public void checarModelos(LoginBean log) {
        Object mdls = Funciones.sacarAttFaces("modelos");
        if (mdls == null) {
            System.out.println("los modelos eran nulos , entonces meto los del dao");
            Funciones.ponerAtributo("modelos", dao.getModelos(dao.getUsu(log.getUsuario().getId())));
        }
        modelos = (List<MdlVeh>) Funciones.sacarAttFaces("modelos");
    }

    public void agregarModelo(MdlVeh proyecto) {
        modelos.add(proyecto);
        System.out.println("meti un modelo nuevo y ahora son ");
        Funciones.ponerAtributo("modelos", modelos);

        List<MdlVeh> sacarAttFaces = (List<MdlVeh>) Funciones.sacarAttFaces("modelos");
        for (MdlVeh m : sacarAttFaces) {
            System.out.println("modelo " + m.getId() + " " + m.getNomMdl());
        }
    }

    public void quitarModelo(MdlVeh proyecto) {
        getModelos().remove(proyecto);
    }

    public void cambioModelo(AjaxBehaviorEvent vc) {
        UIComponent component = vc.getComponent();
        Object valor = sacarValor(component, "value");
        this.setModeloActual(valor == null ? 0 : (Integer) valor);
        System.out.println("el valor del proyecto actual es " + this.getModeloActual());
        if (getModeloActual() != 0) {
            this.setModeloSeleccionado(buscarEnLista());
            return;
        }
        this.setModeloSeleccionado(null);
        System.out.println("el proyecto seleccionado es " + getModeloSeleccionado());
    }

    public void busquedaSeleccionada(AjaxBehaviorEvent event) {
        UIComponent component = event.getComponent();

        this.setBusqueda((String) sacarValor(component, "value"));
        System.out.println("la busqueda es " + getBusqueda());
    }

    public Object sacarValor(UIComponent component, String atributo) {
        return component.getAttributes().get(atributo);
    }

    private MdlVeh buscarEnLista() {
        for (MdlVeh veh : getModelos()) {
            if (veh.getId() == getModeloActual()) {
                return veh;
            }
        }
        return null;
    }

    public String alta() {
        setEstaModificado(false);
        Funciones.ponerAtributo("modelosBusqueda", null);
        Bean.limpiaBeans("ventaBean", "titulacionBean", "escalonesTir", "edificacionBean", "fechasBean",
                "vehiculoInversion", "vehiculoFinancieras", "vehiculoParametricas");
        return "altaModelo";
    }

    public String empezarBusqueda() {
        modelos = (List<MdlVeh>) Funciones.sacarAttFaces("modelos");
        List<MdlVeh> lista = new LinkedList<MdlVeh>();
        for (MdlVeh pr : modelos) {
            String cadena = String.valueOf(pr.getId()) + pr.getNomMdl();
            System.out.println("evaluando " + pr.getNomMdl() + " contra " + cadena);
            if (cadena.toLowerCase().contains(busqueda.toLowerCase())) {
                System.out.println("quitado " + pr.getNomMdl());
                lista.add(pr);
            }
        }
        Funciones.ponerAtributo("modelosBusqueda", lista);
        return "";
    }

    public String verTodos() {
        Funciones.ponerAtributo("modelosBusqueda", null);
        return "";
    }

    /**
     * @return the modelos
     */
    public List<MdlVeh> getModelos() {
        Object modBsq = Funciones.sacarAttFaces("modelosBusqueda");
        modelos = modBsq == null ? (List<MdlVeh>) Funciones.sacarAttFaces("modelos") : (List<MdlVeh>) Funciones.sacarAttFaces("modelosBusqueda");
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
     * @return the estadoGrabacion
     */
    public int getEstadoGrabacion() {
        return estadoGrabacion;
    }

    /**
     * @param estadoGrabacion the estadoGrabacion to set
     */
    public void setEstadoGrabacion(int estadoGrabacion) {
        this.estadoGrabacion = estadoGrabacion;
    }

    /**
     * @return the cambioCopia
     */
    public boolean isCambioCopia() {
        return cambioCopia;
    }

    /**
     * @param cambioCopia the cambioCopia to set
     */
    public void setCambioCopia(boolean cambioCopia) {
        this.cambioCopia = cambioCopia;
    }

    /**
     * @return the modificar
     */
    public boolean isModificar() {
        return modificar;
    }

    /**
     * @param modificar the modificar to set
     */
    public void setModificar(boolean modificar) {
        this.modificar = modificar;
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
     * @return the copiaProyectos
     */
    public List<MdlVeh> getCopiaProyectos() {
        return copiaProyectos;
    }

    /**
     * @param copiaProyectos the copiaProyectos to set
     */
    public void setCopiaProyectos(List<MdlVeh> copiaProyectos) {
        this.copiaProyectos = copiaProyectos;
    }

    public String modelar() {
        Funciones.ponerAtributo("modelosBusqueda", null);
        Funciones.ponerAtributo("proyectos", dao.getProyectos(dao.getUsu(log.getUsuario().getId())));
        if (this.modeloSeleccionado != null) {
            this.modeloSeleccionado = dao.getModeloVehiculo(modeloSeleccionado.getId());
            List<PryVeh> proyectos = new LinkedList<PryVeh>();
            Set<RelMdlVeh> relMdlVehs = modeloSeleccionado.getRelMdlVehs();
            for (RelMdlVeh relacion : relMdlVehs) {
                System.out.println("los proyectos para modelado son " + relacion.getPryVeh().getNomPry());
                proyectos.add(relacion.getPryVeh());
            }
            AltaModelo alta = new AltaModelo();
            alta.setDistribuidorModeloVehiculo(new DistribuidorModeloVehiculo(proyectos, true,modeloSeleccionado.getMesMin(),modeloSeleccionado.getMesPag()));
            alta.getDistribuidorModeloVehiculo().modelarPrincipal();
            alta.getDistribuidorModeloVehiculo().llenarBeansEtapas(0);
            Bean.ponerSesion("altaModelo", alta);
            return "menuModelo";
        }
        FacesContext.getCurrentInstance().addMessage("seleccionModelos:mensaje", new FacesMessage("Se debe elegir antes algun modelo"));
        return "seleccionProyectos";
    }

    
    public String consolidado() {
        AltaModelo alta = (AltaModelo) Bean.getBean("altaModelo");
        alta.getDistribuidorModeloVehiculo().llenarBeanConsolidado();
        return "estadisticas";
    }

    private void resetearBeans() {
        Bean.limpiaBeans("ventaBean", "titulacionBean", "escalonesTir", "edificacionBean", "fechasBean",
                "vehiculoInversion", "vehiculoFinancieras", "vehiculoParametricas", "etapasVehiculo", "generalModeloVehiculoBean",
                "etapasModeloVehiculoBean", "altaModelo");
    }

    public String bajaModelo() {
        setEstaModificado(false);
        if (this.modeloSeleccionado != null) {
            UsuMdlVeh usuProyecto = obtenerUsuMdl(log.getUsuario(), modeloSeleccionado);
            usuProyecto.setEstPryVeh(dao.getEstatusProyecto(2));
            dao.actualizar(usuProyecto);
            Funciones.quitarModelo((List<MdlVeh>) Funciones.sacarAttFaces("modelos"), modeloSeleccionado.getId());
            modelos = (List<MdlVeh>) Funciones.sacarAttFaces("modelos");
            modeloSeleccionado = modelos.get(0);
        }
        return "accionesVehiculo";

    }

    private UsuMdlVeh obtenerUsuMdl(Usu usuario, MdlVeh modeloSeleccionado) {
        return dao.obtenerUsuMdlVeh(usuario, modeloSeleccionado);
    }

    public String copiarModelo() {
        setEstaModificado(false);
        if (this.modeloSeleccionado != null) {
            List<PryVeh> proyectos=sacarProyectos(modeloSeleccionado);
            BeanCopiador bean=new BeanCopiador();
            bean.setProyectos(proyectos);
            Bean.ponerSesion("beanCopiador", bean);
            return "copiaModelo";
        }
        return "";
    }

    public String modificarModelo() {
        setEstaModificado(true);
        if (this.modeloSeleccionado != null) {
            MdlVeh mod=dao.getModeloVehiculo(modeloSeleccionado.getId());
            List<PryVeh> proyectos=sacarProyectos(mod);
            Funciones.ponerAtributo("proyectos", dao.getProyectos(dao.getUsu(log.getUsuario().getId())));
            List<PryVeh> complemento=Funciones.proyectosComplemento(proyectos ,(List<PryVeh>) Funciones.sacarAttFaces("proyectos"));
            AltaModelo alta=new AltaModelo();
            alta.setNombreModelo(mod.getNomMdl());
            alta.setProyectosDerecha(proyectos);
            alta.setProyectosIzquierda(complemento);
            alta.setProyectoSeleccionadoDerecha(alta.getProyectosDerecha().get(0));
            alta.setProyectoSeleccionadoIzquierda(alta.getProyectosIzquierda().get(0));
            Bean.ponerSesion("altaModelo", alta);
            return "altaModelo";
        }
        return "";
    }

    private List<PryVeh> sacarProyectos(MdlVeh modeloSeleccionado) {
        List<PryVeh> proyectos=new LinkedList<PryVeh>();
        Set<RelMdlVeh> relMdlVehs = modeloSeleccionado.getRelMdlVehs();
        for(RelMdlVeh r:relMdlVehs){
            proyectos.add(r.getPryVeh());
        }
        return proyectos;
    }

    /**
     * @return the estaModificado
     */
    public boolean isEstaModificado() {
        return estaModificado;
    }

    /**
     * @param estaModificado the estaModificado to set
     */
    public void setEstaModificado(boolean estaModificado) {
        this.estaModificado = estaModificado;
    }
}
