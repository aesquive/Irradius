package pojos;
// Generated 29-mar-2012 18:27:14 by Hibernate Tools 3.2.1.GA



/**
 * EtpVeh generated by hbm2java
 */
public class EtpVeh  implements java.io.Serializable {


     private Integer id;
     private VarVeh varVeh;
     private PryVeh pryVeh;
     private Integer numEta;
     private String val;

    public EtpVeh() {
    }

    public EtpVeh(VarVeh varVeh, PryVeh pryVeh, Integer numEta, String val) {
       this.varVeh = varVeh;
       this.pryVeh = pryVeh;
       this.numEta = numEta;
       this.val = val;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public VarVeh getVarVeh() {
        return this.varVeh;
    }
    
    public void setVarVeh(VarVeh varVeh) {
        this.varVeh = varVeh;
    }
    public PryVeh getPryVeh() {
        return this.pryVeh;
    }
    
    public void setPryVeh(PryVeh pryVeh) {
        this.pryVeh = pryVeh;
    }
    public Integer getNumEta() {
        return this.numEta;
    }
    
    public void setNumEta(Integer numEta) {
        this.numEta = numEta;
    }
    public String getVal() {
        return this.val;
    }
    
    public void setVal(String val) {
        this.val = val;
    }




}


