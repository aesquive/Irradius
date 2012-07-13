/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Vehiculo;

import java.util.LinkedList;
import util.MatrizBidimensional;


/**
 *
 * @author JOSELUIS
 */
public class PruebaBean {

    private LinkedList<String> lista;
    private LinkedList<String> lista2;
    private LinkedList<String> lista3;

    public PruebaBean(){

        this.lista = new LinkedList<String>();
        this.lista2 = new LinkedList<String>();
        this.lista3 = new LinkedList<String>();


        for (int i = 0; i < 3; i++) {
            lista.add(miParametro(i));
        }


        for (int j = 0; j < 4; j++) {
            lista2.add(miParametro(j));

//            System.out.println(lista2);
        }
        
        for(String lis: lista2){
            lista3.add(lis);
        }



        }


    private String miParametro(int i) {
    switch (i) {
      case 0:
        return "Parametro 1";
      case 1:
        return "parametro 2";
      case 2:
        return "Parametro 3";
      default:
        System.out.println("error");
        break;
    }
    return "";

  }




    private String mi2Parametro(int j) {
    switch (j) {
      case 0:
        return "Parametro 2.1";
      case 1:
        return "parametro 2.2";
      case 2:
        return "Parametro 2.3";

      case 3:
        return "Parametro 2.4";

        default:
        System.out.println("error");
        break;
    }
    return "";

  }

    /**
     * @return the lista
     */
    public LinkedList<String> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(LinkedList<String> lista) {
        this.setLista(lista);
    }

    /**
     * @return the lista2
     */
    public LinkedList<String> getLista2() {
        return lista2;
    }

    /**
     * @param lista2 the lista2 to set
     */
    public void setLista2(LinkedList<String> lista2) {
        this.setLista2(lista2);
    }

  
    /**
     * @return the lista3
     */
    public LinkedList<String> getLista3() {
        return lista3;
    }

    /**
     * @param lista3 the lista3 to set
     */
    public void setLista3(LinkedList<String> lista3) {
        this.lista3 = lista3;
    }


//    public static void main(String[] args) {
//        System.out.println();
//    }






    }






