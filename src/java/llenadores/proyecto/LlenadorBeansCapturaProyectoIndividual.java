/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package llenadores.proyecto;

import Beans.Bean;
import Beans.Proyecto.Cetes;
import Beans.Proyecto.CreditoPuente;
import Beans.Proyecto.Inflacion;
import Beans.Proyecto.ProyectoEtapas;
import Beans.Proyecto.ProyectoFechas;
import Beans.Proyecto.ProyectosGeneradoresBean;
import Beans.Proyecto.ProyectosInfoBasica;
import Beans.Proyecto.Terreno;
import Beans.Proyecto.Titulacion;
import Beans.Proyecto.Venta;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import javax.faces.context.FacesContext;
import pojos.DatPryInd;
import pojos.MatPryInd;
import pojos.MatVeh;
import pojos.PryPryInd;
import util.Funciones;
import util.Parametros;
import util.RegistroFecha;

/**
 *
 * @author daniel
 */
public class LlenadorBeansCapturaProyectoIndividual {

  private final PryPryInd proyecto;
  private Cetes cetes;
  private CreditoPuente creditopuente;
  private Inflacion inflacion;
  private ProyectoEtapas etapas;
  private ProyectoFechas fechas;
  private ProyectosGeneradoresBean generadores;
  private ProyectosInfoBasica info;
  private Terreno terreno;
  private Titulacion titulacion;
  private Venta venta;
  /**
   * mapeo donde guardaremos todos los datos del proyecto
   */
  private Map<String, DatPryInd> mapeoDatos;

  public LlenadorBeansCapturaProyectoIndividual(PryPryInd proyecto) {
    this.cetes = new Cetes();
    this.creditopuente = new CreditoPuente();
    this.inflacion = new Inflacion();
    this.etapas = new ProyectoEtapas();
    this.fechas = new ProyectoFechas();
    this.generadores = new ProyectosGeneradoresBean();
    this.info = new ProyectosInfoBasica();
    this.terreno = new Terreno();
    this.titulacion = new Titulacion();
    this.venta = new Venta();

    this.proyecto = proyecto;

    mapeoDatos = new HashMap<String, DatPryInd>();
  }

  /**
   * nos genera el mapeo de los datos del proyecto teniendo como llave la descripcion tecnica de cada variable
   * @param datos 
   */
  private void generarMapeoDatos(Set<DatPryInd> datos) {
    Iterator<DatPryInd> iterator = datos.iterator();
    while (iterator.hasNext()) {
      DatPryInd dato = iterator.next();
      mapeoDatos.put(dato.getVarPryInd().getDesTca(), dato);
    }
  }

  /**
   * nos ayuda a generar una lista de objetos de tipo parametro para asignarla a los beans
   * @param listaParametricas
   * @return 
   */
  private LinkedList<Parametros> generarLista(String[] listaParametricas) {
    LinkedList<Parametros> lista = new LinkedList<Parametros>();
    for (String llave : listaParametricas) {
      System.out.println("llave " + llave);
      DatPryInd dato = mapeoDatos.get(llave);
      Parametros param = new Parametros(dato.getVarPryInd().getDesLar(), dato.getVal());
      lista.add(param);
    }
    return lista;
  }
  
  /**
     * Nos genera la lista de celdas que traera cada una de las matrices  bidimensionales
     * @param matrices
     * @param tipoDeMatriz
     * @return 
     */
    private LinkedList<RegistroFecha> generarMatriz(Set<MatPryInd> matrices, int tipoDeMatriz) {
        LinkedList<RegistroFecha> lista=new LinkedList<RegistroFecha>();
        for(MatPryInd renglonMatriz:matrices){
            if(renglonMatriz.getTipMatPryInd().getId()==tipoDeMatriz){
                lista.add(new RegistroFecha(Funciones.castearMatrizMes(renglonMatriz.getFch().getTime()),renglonMatriz.getVal()));
            }
        }
        Collections.sort(lista);
        return lista;
    }

  /**
   * mete un bean a la sesion de jsf
   * @param nombre
   * @param bean 
   */
  private void meterAFaces(String nombre, Bean bean) {
    Map<String, Object> sessionMap = FacesContext.getCurrentInstance().
            getExternalContext().getSessionMap();
    sessionMap.put(nombre, bean);
  }

  private void llenarCetes()
  {
    //cetes.setLista(generarLista(listaParametricas));
  }
  
  /**
   * metemos los beans a la sesion de jsf
   */
  private void meterBeans() {
  }
  
  
}
