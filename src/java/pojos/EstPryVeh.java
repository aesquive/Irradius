package pojos;
// Generated 29-mar-2012 18:27:14 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * EstPryVeh generated by hbm2java
 */
public class EstPryVeh  implements java.io.Serializable {


     private Integer id;
     private String desEstPry;
     private Set usuPryVehs = new HashSet(0);
     private Set usuMdlVehs = new HashSet(0);

    public EstPryVeh() {
    }

    public EstPryVeh(String desEstPry, Set usuPryVehs, Set usuMdlVehs) {
       this.desEstPry = desEstPry;
       this.usuPryVehs = usuPryVehs;
       this.usuMdlVehs = usuMdlVehs;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDesEstPry() {
        return this.desEstPry;
    }
    
    public void setDesEstPry(String desEstPry) {
        this.desEstPry = desEstPry;
    }
    public Set getUsuPryVehs() {
        return this.usuPryVehs;
    }
    
    public void setUsuPryVehs(Set usuPryVehs) {
        this.usuPryVehs = usuPryVehs;
    }
    public Set getUsuMdlVehs() {
        return this.usuMdlVehs;
    }
    
    public void setUsuMdlVehs(Set usuMdlVehs) {
        this.usuMdlVehs = usuMdlVehs;
    }




}


