/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.Proyecto;

import Beans.Bean;
import Beans.General.LoginBean;
import Beans.SesionBean;
import base.Dao;
import calculador.proyecto.DistribuidorModeloProyectoIndividual;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.model.DualListModel;
import pojos.MdlPryInd;
import pojos.PryPryInd;

/**
 *
 * @author RUMA
 */
@ManagedBean
@SessionScoped
public class GeneralProyecto extends Bean {

  private static int GUARDAR = 1;
  private static int ACTUALIZAR = 2;
  private List<MdlPryInd> proyectos;
  private Dao dao;
  private String busqueda;
  private int proyectoActual;
  private MdlPryInd proyectoSeleccionado;
  private int estadoGrabacion;
  private boolean cambioCopia;
  private boolean modificar;
  private LoginBean log;
  private List<MdlPryInd> copiaProyectos;
  private DistribuidorModeloProyectoIndividual dis;

  public GeneralProyecto() {
    cambioCopia = false;
    modificar = true;
    this.proyectoActual = -1;
    this.estadoGrabacion = GUARDAR;
    dao = new Dao();
    log = (LoginBean) Bean.getBean("loginBean");
    checarProyectos(log);
  }

  public void checarProyectos(LoginBean log) {
        setProyectos(getDao().getModelosPryInd(dao.getUsu(log.getUsuario().getId())));
  }

  public void agregarProyector(MdlPryInd proyecto) {
        getProyectos().add(proyecto);
  }

  public void quitarProyecto(MdlPryInd proyecto) {
        getProyectos().remove(proyecto);
  }

  public List<MdlPryInd> getProyectos() {
    return proyectos;
  }

  
  public void cambioProyecto(AjaxBehaviorEvent vc) {
    UIComponent component = vc.getComponent();
    Object valor = sacarValor(component, "value");
    this.setProyectoActual ( valor == null ? 0 : (Integer) valor);
    System.out.println("El valor del proyecto actual es " + this.getProyectoActual());
    if (getProyectoActual() != 0) {
      this.setProyectoSeleccionado(buscarEnLista());
      return;
    }
        this.setProyectoSeleccionado(null);
    System.out.println("El proyecto seleccionado es" + getProyectoSeleccionado());
  }

  public void busquedaSeleccionada(AjaxBehaviorEvent event) {
    UIComponent component = event.getComponent();
    this.setBusqueda ( (String) sacarValor(component, "value"));
    System.out.println("La busqueda es " + getBusqueda());
  }

  public Object sacarValor(UIComponent component, String atributo) {
    return component.getAttributes().get(atributo);
  }


  private MdlPryInd buscarEnLista() {
    for (MdlPryInd pro : getProyectos()) {
      if (pro.getId() == getProyectoActual()) {
        return pro;
      }
    }
    return null;
  }

  public String alta() {
    Bean.limpiaBeans("cetes", "creditoPuente", "inflacion", "proyectoEtapas", "proyectoFechas",
                                "proyectosGeneradoresBean, ProyectosInfoBasica", "terreno", "titulacion", 
                                "venta"); //Checar que beans pasarle
    return "altaModeloProyecto";
  }

// public String modificar (){
// if(getProyectoSeleccionado() != null){
// cambioCopia = true;
// modificar = true;
// this.estadoGrabacion = ACTUALIZAR;
// 
// }            
// }

  public String empezarBusqueda() {
        setCopiaProyectos(getProyectos());
    for (MdlPryInd pr : getProyectos()) {
      String cadena = String.valueOf(pr.getId()) + pr.getNomMdl();
      System.out.println("evaluando" + pr.getNomMdl() + "contra" + cadena);
      if (!cadena.contains(busqueda)) {
        System.out.println("quitado" + pr.getNomMdl());
       getProyectos().remove(pr);
      }
    }
    return "nombrepantalla";
  }

  public String verTodos() {
    if (this.getCopiaProyectos() != null) {
      setProyectos( getCopiaProyectos());
    }
    return "pantalla";
  }
  
  public String modelar(){
      if(this.proyectoSeleccionado != null){
            this.setDis(new DistribuidorModeloProyectoIndividual(proyectoSeleccionado.getPryPryInd()));
          getDis().modelar();
          getDis().llenarBeans();
          return "modeloelemVenta";
      }
      return "";
  }

    /**
     * @param proyectos the proyectos to set
     */
    public void setProyectos(List<MdlPryInd> proyectos) {
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
     * @return the proyectoSeleccionado
     */
    public MdlPryInd getProyectoSeleccionado() {
        return proyectoSeleccionado;
    }

    /**
     * @param proyectoSeleccionado the proyectoSeleccionado to set
     */
    public void setProyectoSeleccionado(MdlPryInd proyectoSeleccionado) {
        this.proyectoSeleccionado = proyectoSeleccionado;
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
    public List<MdlPryInd> getCopiaProyectos() {
        return copiaProyectos;
    }

    /**
     * @param copiaProyectos the copiaProyectos to set
     */
    public void setCopiaProyectos(List<MdlPryInd> copiaProyectos) {
        this.copiaProyectos = copiaProyectos;
    }

    /**
     * @return the dis
     */
    public DistribuidorModeloProyectoIndividual getDis() {
        return dis;
    }

    /**
     * @param dis the dis to set
     */
    public void setDis(DistribuidorModeloProyectoIndividual dis) {
        this.dis = dis;
    }

    
}