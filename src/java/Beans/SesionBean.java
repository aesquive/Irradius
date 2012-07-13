/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.Map;
import javax.faces.context.FacesContext;

/**
 *
 * @author alberto
 */
public class SesionBean {

    
    public SesionBean() {
    }

    public static String cerrarSesion() {
        Map<String, Object> sessionMap=FacesContext.getCurrentInstance().
                                        getExternalContext().getSessionMap();
        sessionMap.clear();
        return "index";
    }

    
}
