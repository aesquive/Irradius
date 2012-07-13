package pojos;
// Generated 29-mar-2012 18:27:14 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * VarVeh generated by hbm2java
 */
public class VarVeh  implements java.io.Serializable {


     private Integer id;
     private String desTca;
     private String desLar;
     private Set etpVehs = new HashSet(0);
     private Set etpTirVehs = new HashSet(0);
     private Set datVehs = new HashSet(0);

    public VarVeh() {
    }

    public VarVeh(String desTca, String desLar, Set etpVehs, Set etpTirVehs, Set datVehs) {
       this.desTca = desTca;
       this.desLar = desLar;
       this.etpVehs = etpVehs;
       this.etpTirVehs = etpTirVehs;
       this.datVehs = datVehs;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDesTca() {
        return this.desTca;
    }
    
    public void setDesTca(String desTca) {
        this.desTca = desTca;
    }
    public String getDesLar() {
        return this.desLar;
    }
    
    public void setDesLar(String desLar) {
        this.desLar = desLar;
    }
    public Set getEtpVehs() {
        return this.etpVehs;
    }
    
    public void setEtpVehs(Set etpVehs) {
        this.etpVehs = etpVehs;
    }
    public Set getEtpTirVehs() {
        return this.etpTirVehs;
    }
    
    public void setEtpTirVehs(Set etpTirVehs) {
        this.etpTirVehs = etpTirVehs;
    }
    public Set getDatVehs() {
        return this.datVehs;
    }
    
    public void setDatVehs(Set datVehs) {
        this.datVehs = datVehs;
    }




}

