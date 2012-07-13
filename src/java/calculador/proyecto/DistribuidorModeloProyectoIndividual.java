package calculador.proyecto;

import Beans.Bean;
import Beans.Proyecto.Pantallas.modeloElemVenta;
import Beans.Proyecto.Pantallas.modeloEstadoResultados;
import Beans.Proyecto.Pantallas.modeloGeneradores;
import Beans.Proyecto.Pantallas.modeloInfoBasica;
import base.Dao;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.PryPryInd;
import util.CeldaFechaValor;
import util.Espejo;
import util.MatrizBidimensional;
import variables.ManejadorVariablesProyectos;

/**
 *
 * @author daniel
 */
public class DistribuidorModeloProyectoIndividual {

  //private int redondeo;
  private PryPryInd proyecto;
  ManejadorVariablesProyectos m;

  public DistribuidorModeloProyectoIndividual(PryPryInd proyecto) {
    this.proyecto = proyecto;
    this.m = new ManejadorVariablesProyectos(proyecto);
  }

//  private double redondeo(double valor, int redondeo)
//  {
//    String val = valor + "";
//    BigDecimal big = new BigDecimal(val);
//    big = big.setScale(redondeo, RoundingMode.HALF_UP);
//    return Double.parseDouble(big.toPlainString());
//  }
  /**
   * metodo que mandara a hacer todos los metodos de proyecto
   */
  public void modelar() {
    System.out.println("ELEMENTOS DE VENTA");
    ElementosVentas venta = new ElementosVentas(m);
    venta.procesar();

    System.out.println("INFORMACION BASICA");
    InformacionBasica info = new InformacionBasica(m);
    info.procesar();

    System.out.println("GENERADORES");
    Generadores generadores = new Generadores(m);
    generadores.procesar();

    System.out.println("ESTADOS DE RESULTADO");
    EstadosResultados resultados = new EstadosResultados(m);
    resultados.procesar();
  }

  /**
   * metodo que llena en beans los resultados de calculo de la pantalla de modeloElemVenta
   * @throws IllegalAccessException
   * @throws IllegalArgumentException
   * @throws InvocationTargetException 
   */
  public void llenarBeanModeloElemVenta() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    modeloElemVenta bean = new modeloElemVenta();
    List<Method> getters = Espejo.getGetters(bean.getClass());
    for (Method o : getters) {
      System.out.println("en elementos de venta: " + o.getName());
      if (o.getReturnType().equals(String.class)) {
        Double cadena = (Double) m.obtenerVariable(o.getName().substring(3, o.getName().length()).toLowerCase());
        Espejo.invocaSetterProyectoCadena(o.getName().substring(3, o.getName().length()), bean, String.valueOf(cadena));
      } else {
        if (o.getName().equals("getCelda")) {
          //NO SE QUE HACER XQ NO SE QUE SEA ESTA VARIABLE
        } else {
          LinkedList lista = (LinkedList) m.obtenerVariable(o.getName().substring(3, o.getName().length()).toLowerCase());
          Espejo.invocaSetterProyectoLista(o.getName().substring(3, o.getName().length()), bean, lista);
        }
      }
    }
    Bean.ponerSesion("modeloElemVenta", bean);
  }

  /**
   * metodo que llena en beans los resultados de calculo de la pantalla de modeloInfoBasica
   * @throws IllegalAccessException
   * @throws IllegalArgumentException
   * @throws InvocationTargetException 
   */
  public void llenarBeanModeloInfoBasica() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    modeloInfoBasica bean = new modeloInfoBasica();
    String nombre;
    List<Method> getters = Espejo.getGetters(bean.getClass());
    for (Method o : getters) {
      System.out.println("en info basica: " + o.getName());
      if (o.getReturnType().equals(String.class)) {
        Double cadena = (Double) m.obtenerVariable(o.getName().substring(3, o.getName().length()).toLowerCase());
        Espejo.invocaSetterProyectoCadena(o.getName().substring(3, o.getName().length()), bean, String.valueOf(cadena));
      } else {
        if (preguntar(o.getName().substring(3, o.getName().length()).toLowerCase()) == -1) {
          LinkedList<CeldaFechaValor> lista = (LinkedList<CeldaFechaValor>) m.obtenerVariable(o.getName().substring(3, o.getName().length()).toLowerCase());
          Espejo.invocaSetterProyectoLista(o.getName().substring(3, o.getName().length()), bean, lista);
        } else if (preguntar(o.getName().substring(3, o.getName().length()).toLowerCase()) == 0) {
          LinkedList lista = (LinkedList) m.obtenerVariable(o.getName().substring(3, o.getName().length()).toLowerCase());
          Espejo.invocaSetterProyectoLista(o.getName().substring(3, o.getName().length()), bean, lista);
        } else {
          LinkedList<MatrizBidimensional> lista = (LinkedList<MatrizBidimensional>) m.obtenerVariable(o.getName().substring(3, o.getName().length()).toLowerCase());
          Espejo.invocaSetterVehiculoLista(o.getName().substring(3, o.getName().length()), bean, lista);
        }
      }
    }
      System.out.println("ttttttttttttttttttttttttttttttttttttttttttttt");
      System.out.println(bean.getPry_inf());
    Bean.ponerSesion("modeloInfoBasica", bean);
  }

  private int preguntar(String nombre) {
    //si es LinkedList<CeldaFechaValor>
    if (nombre.equals("pry_arr_vnt_tot") || nombre.equals("pry_arr_tit_tot")) {
      return -1;
    } //si es LinkedList<Double>
    else if (nombre.equals("pry_tas_int_cre_pue") || nombre.equals("pry_inf") || nombre.equals("pry_tas_cet")) {
      return 0;
    } //si es LinkedList<MatrizBidimencional>
    else {
      return 1;
    }
  }

//    /**
//     * metodo que llena en beans los resultados de calculo de la pantalla de modeloGeneradores
//     * @throws IllegalAccessException
//     * @throws IllegalArgumentException
//     * @throws InvocationTargetException 
//     */
//    public void llenarBeanModeloGeneradores() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//        modeloGeneradores bean = new modeloGeneradores();
//        List<Method> getters = Espejo.getGetters(bean.getClass());
//        for (Method o : getters) {
//
//            String cadena = (String) m.obtenerVariable(o.getName().substring(3, o.getName().length()).toLowerCase());
//            Espejo.invocaSetterProyectoCadena(o.getName().substring(3, o.getName().length()), bean, cadena);
//
//        }
//        Bean.ponerSesion("modeloInfoBasica", bean);
//    }
  /**
   * metodo que llena en beans los resultados de calculo de la pantalla de modeloGeneradores
   * @throws IllegalAccessException
   * @throws IllegalArgumentException
   * @throws InvocationTargetException 
   */
  public void llenarBeanGeneradores() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    modeloGeneradores bean = new modeloGeneradores();
    List<Method> getters = Espejo.getGetters(bean.getClass());
    for (Method o : getters) {
      System.out.println("el metodo en generadores: " + o.getName());
      if (o.getReturnType().equals(String.class)) {
        Double cadena = (Double) m.obtenerVariable(o.getName().substring(3, o.getName().length()).toLowerCase());
        Espejo.invocaSetterProyectoCadena(o.getName().substring(3, o.getName().length()), bean, String.valueOf(cadena));
      } else {
        LinkedList<String> lista = (LinkedList<String>) m.obtenerVariable(o.getName().substring(3, o.getName().length()).toLowerCase());
        Espejo.invocaSetterProyectoLista(o.getName().substring(3, o.getName().length()), bean, lista);
      }
    }

    Bean.ponerSesion("modeloGeneradores", bean);
  }

  public void llenarBeanEstadosResultados() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    modeloEstadoResultados bean = new modeloEstadoResultados();
    List<Method> getters = Espejo.getGetters(bean.getClass());
    System.out.println("\n\n\n\n\n      ESTOY VIENDO LAS VARIABLES DE ESTADOS DE RESULTADOS");
    for (Method o : getters) {
      System.out.println("el nombre: " + o.getName());
    }
    System.out.println("\n\n\n      TERMINO DE IMPRIMIR LOS METODOS QUE SE ESTAN MANDANDO A LLAMAR");
      
    for (Method o : getters) {
        System.out.println("el metodo en EstadosResultados: " + o.getName());
        if (o.getReturnType().equals(String.class)) {
          Double cadena = (Double) m.obtenerVariable(o.getName().substring(3, o.getName().length()).toLowerCase());
          System.out.println("El valor de la cadena es: " + cadena);
          Espejo.invocaSetterProyectoCadena(o.getName().substring(3, o.getName().length()), bean, String.valueOf(cadena));
        }
      }
      Bean.ponerSesion("modeloEstadoResultados", bean);
    }

  

  public static void main(String[] args) {
    Dao dao = new Dao();
    PryPryInd pryInd = new PryPryInd();
//    DistribuidorModeloProyectoIndividual distribuidor = new DistribuidorModeloProyectoIndividual(pryInd);
//    distribuidor.modelar();
  }

  public void llenarBeans() {
    try {
      llenarBeanModeloInfoBasica();
      llenarBeanGeneradores();
      llenarBeanModeloElemVenta();
      llenarBeanEstadosResultados();
    } catch (IllegalAccessException ex) {
      Logger.getLogger(DistribuidorModeloProyectoIndividual.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalArgumentException ex) {
      Logger.getLogger(DistribuidorModeloProyectoIndividual.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InvocationTargetException ex) {
      Logger.getLogger(DistribuidorModeloProyectoIndividual.class.getName()).log(Level.SEVERE, null, ex);
    }

  }
}
