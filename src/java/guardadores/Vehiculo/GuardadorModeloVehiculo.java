package guardadores.Vehiculo;

import base.Dao;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import pojos.MdlVeh;
import pojos.PryVeh;
import pojos.RelMdlVeh;
import pojos.Usu;
import pojos.UsuMdlVeh;

/**
 *
 * @author alberto
 */
public class GuardadorModeloVehiculo {

    private List<PryVeh> proyectos;
    private Usu usuario;
    private String nombreModelo;
    private MdlVeh modelo;
    private Dao dao;
    private boolean estaModificado;
    private int idModeloSeleccionado;
    
    public GuardadorModeloVehiculo(boolean estaModificado , int idModeloSeleccionado ,List<PryVeh> proyectos, Usu usuario, String nombreModelo) {
        this.estaModificado=estaModificado;
        this.idModeloSeleccionado=idModeloSeleccionado;
        this.proyectos = proyectos;
        this.usuario = usuario;
        this.nombreModelo = nombreModelo;
        dao=new Dao();
    }

    public MdlVeh guardar() {
        int id = guardarModelo();
        guardarRelaciones();
        guardarUsuMdl();
        
        return dao.getModeloVehiculo(id);
    }

    private int guardarModelo() {
        modelo=new MdlVeh();
        modelo.setFec(Calendar.getInstance());
        modelo.setNomMdl(nombreModelo);
        modelo.setUsu(usuario);
        modelo.setMesMin(18);
        modelo.setMesPag(12);
        return dao.guardar(modelo);
        
    }

    private void guardarRelaciones() {
        for(PryVeh proyecto:proyectos){
            RelMdlVeh rel=new RelMdlVeh(modelo, proyecto);
            dao.guardar(rel);
        }
    }

    private void guardarUsuMdl() {
        if(estaModificado){
            Set<UsuMdlVeh> usuMdlVehs = dao.getModeloVehiculo(idModeloSeleccionado).getUsuMdlVehs();
            for(UsuMdlVeh rel:usuMdlVehs){
                dao.guardar(new UsuMdlVeh(modelo, rel.getUsu(), rel.getEstPryVeh()));
            }
            dao.remove(dao.getModeloVehiculo(idModeloSeleccionado));
        }
    }
    
}
