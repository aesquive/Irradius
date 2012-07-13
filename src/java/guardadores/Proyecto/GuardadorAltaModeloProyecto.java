/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guardadores.Proyecto;

import base.Dao;
import java.util.Calendar;
import pojos.MdlPryInd;
import pojos.PryPryInd;
import pojos.Usu;

/**
 *
 * @author RUMA
 */
public class GuardadorAltaModeloProyecto {
    private String Nombre;
    private Usu usuario;
    private PryPryInd proyecto;
    private Dao dao;

    public GuardadorAltaModeloProyecto(String Nombre, Usu usuario, PryPryInd proyecto) {
        this.Nombre = Nombre;
        this.usuario = usuario;
        this.proyecto = proyecto;
        dao = new Dao();
    }
    
    public MdlPryInd guadarProyectoInd (){
        MdlPryInd modeloProyectoInd = new MdlPryInd();
        modeloProyectoInd.setFec(Calendar.getInstance());
        modeloProyectoInd.setNomMdl(Nombre);
        modeloProyectoInd.setPryPryInd(proyecto);
        modeloProyectoInd.setUsu(usuario);
        dao.guardar(modeloProyectoInd);
        return modeloProyectoInd;
    }
    
}
