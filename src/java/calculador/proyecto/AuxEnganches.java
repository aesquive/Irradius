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
public class AuxEnganches {

  private double ingresoTotalEnganche;
  private double numUni;
  private double mesesEnganche;
  private LinkedList<CeldaFechaValor> lista;
  private ManejadorVariablesProyectos m;

  public AuxEnganches(ManejadorVariablesProyectos m) {
    this.m = m;
    consigueNumUni();
    consigueMesesEnganche();
    consigueLista();
    consigueIngresoTotalEnganche();
  }

  public void procesar() {
    listaTotalesEnganchesEtapasPor();
    agregaPrimero();
    matrizAuxCobranzaEng();
  }

  //se calcula de elementoventa
  private void consigueNumUni() {
    numUni = (Double) m.obtenerVariable("pry_uni_viv");
  }

  //consigue el valor total de las titulaciones de todo el proyecto
  private void consigueIngresoTotalEnganche() {
    ingresoTotalEnganche = (Double) m.obtenerVariable("pry_ing_eng_viv");
  }

  //consigue el numero de meses para la conformacion de la titulacion 
  private void consigueMesesEnganche() {
    mesesEnganche = (Double) m.obtenerVariable("pry_mes_tit");
  }

  //consigue la lista de totales de titulacion por etapas
  private void consigueLista() {
    lista = (LinkedList<CeldaFechaValor>) m.obtenerVariable("pry_arr_vnt_tot");
  }

  /**
   * metodo que regresa una lista de porcentajes de totales de titulacion por etapas
   * @return lista de porcentajes de totales de titulacion por etapas
   */
  public LinkedList<CeldaFechaValor> listaTotalesEnganchesEtapasPor() {
    LinkedList<CeldaFechaValor> aux = new LinkedList<CeldaFechaValor>();
    Calendar cal;
    Double valor;
    System.out.println(">>>>>>>Estoy en listaTotalesEnganchesEtapasPor()");
    for (CeldaFechaValor c : lista) {
      cal = c.getFecha();
      if (numUni != 0.0) {
        valor = c.getValor() / numUni;
        System.out.println("valor: " + valor);
      } else {
        valor = 0.0;
      }
      aux.add(new CeldaFechaValor(cal, valor));
    }
    m.guardarVariable("pry_por_arr_eng_tot", aux);
    System.out.println("\n\n\n\n");
    return aux;

  }

  public LinkedList<MatrizBidimensional> matrizAuxCobranzaEng() {
    LinkedList<MatrizBidimensional> aux = new LinkedList<MatrizBidimensional>();
    //se agrega primero todo el renglon de arriba de la matriz en forma de MatrizBidimencional
    aux.add(agregaPrimero());

    System.out.println(">>>>>>>Estoy en matrizAuxCobranzaEng()");
    MatrizBidimensional aux_matriz = aux.get(0);
    MatrizBidimensional aux_matriz1;
    MatrizBidimensional aux_matriz2;
    aux_matriz1 = aux_matriz;
    int conteo = 0;
    int size = aux_matriz.getCeldas().size();
    //empezamos las comparaciones con el segundo mes
    for (int i = 0; i < mesesEnganche - 1; i++) {
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

    m.guardarVariable("pry_mat_aux_cob_eng", aux);
    return aux;
  }

  private MatrizBidimensional agregaPrimero() {
    MatrizBidimensional mat = new MatrizBidimensional();
    LinkedList<CeldaFechaValor> aux = (LinkedList<CeldaFechaValor>) m.obtenerVariable("pry_por_arr_eng_tot");
    if (aux == null) {
      System.out.println("es nulo");
    }
    Calendar cal;
    Double valor;
    for (CeldaFechaValor c : aux) {
      cal = c.getFecha();
      valor = (c.getValor() * ingresoTotalEnganche) / mesesEnganche;
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

    System.out.println("imprimir: " + m.obtenerVariable("pry_ing_eng_viv"));

    System.out.println("PROCESO AUXENGANCHES");
    AuxEnganches eng = new AuxEnganches(m);

    eng.listaTotalesEnganchesEtapasPor();
    LinkedList<CeldaFechaValor> mat = (LinkedList<CeldaFechaValor>) eng.agregaPrimero().getCeldas();

    for (CeldaFechaValor cel : mat) {
      System.out.println("fecha: " + cel.getFechaTexto().toString());
      System.out.println("valor: " + cel.getValorRedondeado().toString());
    }
    int j = 0;
    eng.matrizAuxCobranzaEng();
    LinkedList<MatrizBidimensional> mbid = new LinkedList<MatrizBidimensional>();
    mbid = (LinkedList<MatrizBidimensional>) m.obtenerVariable("pry_mat_aux_cob_eng");
  }
}
