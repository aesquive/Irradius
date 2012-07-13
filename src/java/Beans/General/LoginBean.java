package Beans.General;

import Beans.Bean;
import Beans.SesionBean;
import base.DaoUsuario;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import pojos.Usu;

/**
 *
 * @author Daniel Gonzalez Teran
 * @author Jose Galindo Martinez
 */
public class LoginBean extends Bean{
  
  /**
   * nombre del usuario
   */
  private String usr;
  /**
   * contraseña del usuario
   */
  private String psw;
    private Usu usuario;
  

  /** Creates a new instance of LoginBean */
  public LoginBean() {
  }

  /**
   * @return the usr
   */
  public String getUsr() {
    return usr;
  }

  /**
   * @param usr the usr to set
   */
  public void setUsr(String usr) {
    this.usr = usr;
  }

  /**
   * @return the psw
   */
  public String getPsw() {
    return psw;
  }

  /**
   * @param psw the psw to set
   */
  public void setPsw(String psw) {
    this.psw = psw;
  }
  
  
  
  public String validarUsuario(){
      DaoUsuario dao=new DaoUsuario();
        Usu verificarUsuario = dao.verificarUsuario(usr, psw);
        System.out.println(verificarUsuario);
        if(verificarUsuario!=null){
            this.usuario=verificarUsuario;
            return "menu";
      
        }
        
        FacesContext.getCurrentInstance().addMessage("login:sub",new FacesMessage("Usuario o Password Incorrecto"));
      return "index";
  }

    /**
     * @return the usuario
     */
    public Usu getUsuario() {
        return usuario;
    }
   
  
}
