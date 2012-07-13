/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.Configuracion;

import Beans.Bean;
import Beans.SesionBean;
import base.DaoUsuario;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author alberto
 */
public class AltaUsuariosBean {

    private String nombreUsuario;
    
    private String password;
    
    private String rectificarPassword;
    
    private int tipoUsuario;
    
    public AltaUsuariosBean() {
        tipoUsuario=-1;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the tipoUsuario
     */
    public int getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * @param tipoUsuario the tipoUsuario to set
     */
    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the rectificarPassword
     */
    public String getRectificarPassword() {
        return rectificarPassword;
    }

    /**
     * @param rectificarPassword the rectificarPassword to set
     */
    public void setRectificarPassword(String rectificarPassword) {
        this.rectificarPassword = rectificarPassword;
    }
    
    public String guardarUsuario(){
        if(this.nombreUsuario.equals("")){
            FacesContext.getCurrentInstance().addMessage("altaUsuarios:sub", new FacesMessage("El usuario no puede ser vacio"));
            return "altaUsuarios";
        }
        if(!this.password.equals(this.rectificarPassword) && !this.password.equals("")){
            FacesContext.getCurrentInstance().addMessage("altaUsuarios:sub", new FacesMessage("Los password no coinciden o estan vacios"));
            return "altaUsuarios";
        }
        if(this.tipoUsuario==-1){
            FacesContext.getCurrentInstance().addMessage("altaUsuarios:sub", new FacesMessage("Debe elegir un tipo de usuario"));
            return "altaUsuarios";
        }
        DaoUsuario dao=new DaoUsuario();
        dao.guardarUsuario(this.nombreUsuario,this.password,this.tipoUsuario);
        Bean.limpiaBeans("altaUsuariosBean");
        return "accionesConfiguracion";
    }
}
