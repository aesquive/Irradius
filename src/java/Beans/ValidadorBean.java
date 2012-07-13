/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import util.Funciones;



/**
 *
 * @author Alberto
 */
public class ValidadorBean extends Bean{
    
    
   public void valueChangePorcentaje(AjaxBehaviorEvent event){
        UIComponent component = event.getComponent();
        Map<String, Object> attributes = component.getAttributes();
        Set<String> keySet = attributes.keySet();
        Iterator<String> iterator = keySet.iterator();
        while(iterator.hasNext()){
            String llave=iterator.next();
            System.out.println(llave+" "+attributes.get(llave));
        }
        String valor=(String) sacarValor(component,"value");
        valor=valor.contains("%") ? valor.substring(0,valor.length()-1) : valor;
        System.out.println("el valorsin es "+valor);
        try{
            Double.parseDouble(valor);
        }catch(NumberFormatException num){
            System.out.println("cai en exception");
            valor="000";
        }
        valor=valor.trim();
        String[] split = valor.split("\\.");
        String valIzq=agregarLongitud(" ",3,false,split[0]);
        String valDer= split.length==2 ? agregarLongitud("0",split[1].length(),true,split[1]) : "";
        if(valDer.length()>0){
            
        ponerValor(component,valIzq+"."+valDer+"%");
        return;
        }
        
        ponerValor(component,valIzq+"%");
   }
   
   public void valueChangeNumerico(AjaxBehaviorEvent event){
        UIComponent component = event.getComponent();
        
        String valor= sacarValor(component,"value").toString();
        try{
            Double.parseDouble(valor);
        }catch(NumberFormatException num){
            valor="";
        }
        valor=valor.trim();
        Integer longitud=(Integer) sacarValor(component, "maxlength");
        String valIzq=agregarLongitud(" ",longitud,false,valor);
        ponerValor(component, Funciones.ponerComasCantidades(Double.valueOf(valIzq)));
       
   }
   
   
    private String agregarLongitud(String caracter, int longitud,boolean derecha, String valor) {
        valor=valor==null ? "":valor;
        while(valor.length()<longitud){
            valor = derecha ? valor+caracter : caracter+valor;
        }
        return valor;
    }
   
   public void ponerValor(UIComponent component , Object valor){
       component.getAttributes().put("value", valor);
   }
   
   public UIComponent getComponente(String nombre){
         return FacesContext.getCurrentInstance().getViewRoot().findComponent(nombre);
   }
   
   public Object sacarValor(UIComponent component,String atributo){
        return component.getAttributes().get(atributo);
   }

    public static void main(String[] args) {
        String algo="001450.5";
        String replace = algo.replace(",", "");
        System.out.println(replace);
    }

    
}
