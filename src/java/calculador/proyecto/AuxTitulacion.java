/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculador.proyecto;

import base.Dao;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import util.CeldaFechaValor;
import util.MatrizBidimensional;
import variables.ManejadorVariablesProyectos;

/**
 *
 * @author daniel
 */
public class AuxTitulacion {

  private double ingresoTotalTitulacion;
  private double numUni;
  private double mesesTitulacion;
  private LinkedList<CeldaFechaValor> lista;
  private ManejadorVariablesProyectos m;

  public AuxTitulacion(ManejadorVariablesProyectos m) {
    this.m = m;
    consigueNumUni();
    consigueMesesTitulacion();
    consigueLista();
    consigueIngresoTotalTitulacion();
  }

  public void procesar() {
    listaTotalesTitulacionEtapasPor();
    agregaPrimero();
    matrizAuxCobranzaTit();
  }

  //se calcula de elementoventa
  private void consigueNumUni() {
    numUni = (Double) m.obtenerVariable("pry_uni_viv");
  }

  //consigue el valor total de las titulaciones de todo el proyecto
  private void consigueIngresoTotalTitulacion() {
    ingresoTotalTitulacion = (Double) m.obtenerVariable("pry_ing_tit_viv");
  }

  //consigue el numero de meses para la conformacion de la titulacion 
  private void consigueMesesTitulacion() {
    mesesTitulacion = (Double) m.obtenerVariable("pry_mes_tit");
  }

  //consigue la lista de totales de titulacion por etapas
  private void consigueLista() {
    lista = (LinkedList<CeldaFechaValor>) m.obtenerVariable("pry_arr_tit_tot");
  }

  /**
   * metodo que regresa una lista de porcentajes de totales de titulacion por etapas
   * @return lista de porcentajes de totales de titulacion por etapas
   */
  public LinkedList<CeldaFechaValor> listaTotalesTitulacionEtapasPor() {
    LinkedList<CeldaFechaValor> aux = new LinkedList<CeldaFechaValor>();
    Calendar cal;
    Double valor;
    System.out.println(">>>>>>>Estoy en listaTotalesTitulacionEtapasPor()");
    for (CeldaFechaValor c : lista) {
      cal = c.getFecha();
      if (numUni != 0.0) {
        valor = c.getValor() / numUni;
      } else {
        valor = 0.0;
      }
      aux.add(new CeldaFechaValor(cal, valor));
    }
    m.guardarVariable("pry_por_arr_tit_tot", aux);
    System.out.println("\n\n\n\n");
    return aux;

  }

  public LinkedList<MatrizBidimensional> matrizAuxCobranzaTit() {
    LinkedList<MatrizBidimensional> aux = new LinkedList<MatrizBidimensional>();
    //se agrega primero todo el renglon de arriba de la matriz en forma de MatrizBidimencional
    aux.add(agregaPrimero());

    System.out.println(">>>>>>>Estoy en matrizAuxCobranzaTit()");
    MatrizBidimensional aux_matriz = aux.get(0);
    MatrizBidimensional aux_matriz1;
    MatrizBidimensional aux_matriz2;
    aux_matriz1 = aux_matriz;
    int conteo = 0;
    int size = aux_matriz.getCeldas().size();
    //empezamos las comparaciones con el segundo mes
    for (int i = 0; i < mesesTitulacion - 1; i++) {
      aux_matriz2 = new MatrizBidimensional();
      System.out.println("matriz #" + i);
      for (int j = 1; j < size; j++) {
        System.out.println("fecha: " + aux_matriz1.getCeldas().get(j).getFechaTexto().toString());
        System.out.println("valor: " + aux_matriz1.getCeldas().get(j - 1).getValor());
        aux_matriz2.getCeldas().add(new CeldaFechaValor(aux_matriz1.getCeldas().get(j).getFecha(), aux_matriz1.getCeldas().get(j - 1).getValor()));
      }
      aux.add(aux_matriz2);
      aux_matriz1 = aux_matriz2;
    }

    m.guardarVariable("pry_mat_aux_cob_tit", aux);
    return aux;
  }

  private MatrizBidimensional agregaPrimero() {
    MatrizBidimensional mat = new MatrizBidimensional();
    LinkedList<CeldaFechaValor> aux = (LinkedList<CeldaFechaValor>) m.obtenerVariable("pry_por_arr_tit_tot");
    if (aux == null) {
      System.out.println("es nulo");
    }
    Calendar cal;
    Double valor;
    for (CeldaFechaValor c : aux) {
      cal = c.getFecha();
      valor = (c.getValor() * ingresoTotalTitulacion) / mesesTitulacion;
      mat.getCeldas().add(new CeldaFechaValor(cal, valor));
    }
    System.out.println("\n\n\n\n");
    return mat;
  }

  public static void main(String[] args) {
    Dao dao = new Dao();
    ManejadorVariablesProyectos m = new ManejadorVariablesProyectos(dao.getPryInd(46));
    ElementosVentas elementos = new ElementosVentas(m);
    InformacionBasica info = new InformacionBasica(m);

    LinkedList<Double> aux;
    Double auxiliar;

    System.out.println("PROCESO ELEMENTOS DE VENTA");
    elementos.procesar();

    System.out.println("PROCESOS INFORMACION BASICA");
    info.procesar();

    System.out.println("imprimir: " + m.obtenerVariable("pry_ing_tit_viv"));

    System.out.println("PROCESO AUX TITULACION");
    AuxTitulacion tit = new AuxTitulacion(m);

    tit.listaTotalesTitulacionEtapasPor();
    LinkedList<CeldaFechaValor> mat = (LinkedList<CeldaFechaValor>) tit.agregaPrimero().getCeldas();

    for (CeldaFechaValor cel : mat) {
      System.out.println("fecha: " + cel.getFechaTexto().toString());
      System.out.println("valor: " + cel.getValorRedondeado().toString());
    }
    int j = 0;
    tit.matrizAuxCobranzaTit();
    LinkedList<MatrizBidimensional> mbid = new LinkedList<MatrizBidimensional>();
    mbid = (LinkedList<MatrizBidimensional>) m.obtenerVariable("pry_mat_aux_cob_tit");
//    if (mbid != null) {
//      for (MatrizBidimensional a : mbid) {
//        mat = (LinkedList<CeldaFechaValor>) a.getCeldas();
//        System.out.println(">>>>>>>>>>>>MATRIZ BIDIMENCIONAL = " + j);
//        for (int i = 0; i < mat.size(); i++) {
//          System.out.println("fecha " + mat.get(i).getFechaTexto().toString());
//          System.out.println("valor " + mat.get(i).getValor());
//        }
//        j++;
//      }
//    } else {
//      System.out.println("si es nulo");
//    }
  }
}
