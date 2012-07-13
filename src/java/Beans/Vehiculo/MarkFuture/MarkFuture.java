/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.Vehiculo.MarkFuture;

import Beans.Bean;
import Beans.General.LoginBean;
import base.Dao;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import pojos.MdlVeh;
import util.Funciones;
import util.vehiculo.EncapsuladorMarkFuture;

/**
 *
 * @author alberto
 */
public class MarkFuture {

    public final static String sufijo="/home/alberto/apache-tomcat-7.0.14/webapps/Irradius/";
    
    private int numeroEscenarios;
    private List<EncapsuladorMarkFuture> escenarios;
    private String mensaje;
    
    public MarkFuture() {
        escenarios=new LinkedList<EncapsuladorMarkFuture>();
    }

    /**
     * @return the numeroEscenarios
     */
    public int getNumeroEscenarios() {
        return numeroEscenarios;
    }

    /**
     * @param numeroEscenarios the numeroEscenarios to set
     */
    public void setNumeroEscenarios(int numeroEscenarios) {
        this.numeroEscenarios = numeroEscenarios;
    }

    /**
     * @return the escenarios
     */
    public List<EncapsuladorMarkFuture> getEscenarios() {
        return escenarios;
    }

    /**
     * @param escenarios the escenarios to set
     */
    public void setEscenarios(List<EncapsuladorMarkFuture> escenarios) {
        this.escenarios = escenarios;
    }
    
    public String llenarEscenarios(){
        Dao dao=new Dao();
        LoginBean bean = (LoginBean) Bean.getBean("loginBean");
        List<MdlVeh> modelos = dao.getModelos(dao.getUsu(bean.getUsuario().getId()));
        int indice=1;
        for(int t=0;t<numeroEscenarios;t++){
            EncapsuladorMarkFuture enc=new EncapsuladorMarkFuture();
            enc.setIndiceEscenario(indice++);
            enc.setModelosDisponibles(modelos);
            escenarios.add(enc);
            
        }
        return "datosMarkFuture";
    }
    
    
    public String comenzar(){
        this.setMensaje("");
        double suma=0.0;
        boolean pasa=true;
        for(EncapsuladorMarkFuture enc:escenarios){
            suma+=enc.getWOE();
            System.out.println("el seleccionado "+enc.getModeloSeleccionado());
            if(enc.getModeloSeleccionado()==0){
                pasa=false;
            }
        }
        String total = Funciones.redondear(String.valueOf(suma), 2);
        double val=Double.valueOf(total);
        if(val==100.0 && pasa){
            escribirArchivo();
            return "comenzarMarkFuture";
        }
        this.setMensaje("Las WOE deben sumar 100 y debe haber modelos seleccionados");
        return "";
    }

    private String generarCadenaModelos(){
        LoginBean bean = (LoginBean) Bean.getBean("loginBean");
        StringBuilder builder=new StringBuilder();
        for(EncapsuladorMarkFuture enc:escenarios){
            builder.append(String.valueOf(enc.getModeloSeleccionado()) +"-"+String.valueOf(enc.getWOE()/100)+"-"+bean.getUsuario().getId()+",");
        }
        String toString = builder.toString();
        System.out.println("la cadena escrita es "+toString);
        return toString.substring(0,toString.length()-1);
    }
    
    private void escribirArchivo() {
        BufferedWriter writer = null;
        try {
            String rutaSimulacion=sufijo+"MarkFuture/mark.conf";
            writer = new BufferedWriter(new FileWriter(rutaSimulacion));
            writer.write(generarCadenaModelos());
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(MarkFuture.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
