/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.Vehiculo.Pantallas;

import Beans.Bean;


/**
 *
 * @author JOSELUIS
 */
public class BeanLimpiador {

    /**
     * Creates a new instance of BeanLimpiador
     */
    public BeanLimpiador() {
        
    }
    
    public String limpiaPantallasVehiculo(){
       Bean.limpiaBeans("ventaBean","titulacionBean","escalonesTir","edificacionBean","fechasBean",
                        "vehiculoInversion","vehiculoFinancieras","vehiculoParametricas","etapasVehiculo","generalModeloVehiculoBean",
       "etapasModeloVehiculoBean");
        
       return "accionesVehiculo";
    }
    public String limpiaPantallasVehiculoModelo(){
       Bean.limpiaBeans("ventaBean","titulacionBean","escalonesTir","edificacionBean","fechasBean",
                        "vehiculoInversion","vehiculoFinancieras","vehiculoParametricas","etapasVehiculo","generalModeloVehiculoBean",
       "etapasModeloVehiculoBean");
        
       return "menuModelo";
    }
    public String limpiaPantallasAltaModelo(){
       Bean.limpiaBeans("ventaBean","titulacionBean","escalonesTir","edificacionBean","fechasBean",
                        "vehiculoInversion","vehiculoFinancieras","vehiculoParametricas","etapasVehiculo","generalModeloVehiculoBean",
       "etapasModeloVehiculoBean", "altaModelo");
        
       return "menuPrincipal";
    }
   
    
    
    
    
    
}
