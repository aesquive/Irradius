package Beans.Proyecto;

import Beans.Bean;
import Beans.General.LoginBean;
import Beans.SesionBean;
import guardadores.Proyecto.GuardadorProyecto;
import java.util.LinkedList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import pojos.PryPryInd;
import util.ParametroGenerador;
import util.Parametros;

/**
 * Clase que es un ManagedBean para el llenado de la familia de parametros 
 * generadores para los proyectos
 * @author Daniel Gonzalez Teran
 * @author Jose Galindo Martinez
 */
@ManagedBean
public class ProyectosGeneradoresBean extends Bean{

  /* Las cadenas van en los titulos
   */
  private LinkedList<Parametros> listaTerrenoEscPor;
  private LinkedList<ParametroGenerador> listaProyecto;
  private LinkedList<ParametroGenerador> listaTramitesLicDer;
  private LinkedList<Parametros> listaVentasPor;
  private LinkedList<ParametroGenerador> listaOtros; //(puede variar las entradas)
  private LinkedList<Parametros> listaSociosGtosAdmonPor;
  private LinkedList<Parametros> listaCreditoPuente;
  private LinkedList<Parametros> listaAdministracionFideicomiso;
  private LinkedList<Parametros> listaDro;
  private final int NUMTERRESC = 2;
  private final int NUMPRO = 3;
  private final int NUMTRAMLICDER = 6;
  private final int NUMVEN = 7;
  private final int NUMOTROS = 3;
  private final int NUMSOCADMON = 3;
  private final int NUMCREPUE = 7;

  public ProyectosGeneradoresBean() {
    listaTerrenoEscPor = new LinkedList<Parametros>();
    listaProyecto = new LinkedList<ParametroGenerador>();
    listaTramitesLicDer = new LinkedList<ParametroGenerador>();
    listaVentasPor = new LinkedList<Parametros>();
    listaOtros = new LinkedList<ParametroGenerador>();
    listaSociosGtosAdmonPor = new LinkedList<Parametros>();
    listaCreditoPuente = new LinkedList<Parametros>();
    listaAdministracionFideicomiso = new LinkedList<Parametros>();
    listaDro = new LinkedList<Parametros>();
    
    for (int i = 0; i < NUMTERRESC; i++) {
      listaTerrenoEscPor.add(new Parametros(nombreTerrPor(i), ""));
    }
    
    for (int i = 0; i < NUMPRO; i++) {
      listaProyecto.add(new ParametroGenerador(nombreProyectoPor(i), "", ""));
    }
    
    for (int i = 0; i < NUMTRAMLICDER; i++) {
      listaTramitesLicDer.add(new ParametroGenerador(nombreTramiLicDerePor(i), "", ""));
    }
    
    for (int i = 0; i < NUMVEN; i++) {
      listaVentasPor.add(new Parametros(nombreVenPor(i), ""));
    }
    
    for (int i = 0; i < NUMOTROS; i++) {
      listaOtros.add(new ParametroGenerador(nombreOtrosPor(i), "", ""));
    }
    
    for (int i = 0; i < NUMSOCADMON; i++) {
      listaSociosGtosAdmonPor.add(new Parametros(nombreSocAdmonPor(i), ""));
    }

    for (int i = 0; i < NUMCREPUE; i++) {
      listaCreditoPuente.add(new Parametros(nombreCreditoPuentePor(i), ""));
    }
    
    listaAdministracionFideicomiso.add(new Parametros(nombreFideicomiso(), ""));
    
    listaDro.add(new Parametros (nombreDro(), ""));
  }

  /**
   * regresa las cadenas que sera ocupadas en los datatable 
   * @param i el indice de la cadena solicitada
   * @return una cadena para el datatable
   */
  private String nombreTerrPor(int i) {
    switch (i) {
    case 0:
        return "Predial, agua y areas comunes, vigilancia";
    case 1:
      return "Escrituras/Avaluo/ constitucion fideicomiso/terreno/ISR";
    default:
      System.out.println("error");
      break;
    }
    return "";
  }
  
  private String nombreFideicomiso(){
      return "Administracion de Fideicomiso";
  }
  
  /**
   *Se encarga de convertir la opcion a cadena, la cual estara en el dataTable.
   * @param i El indice de la cadena solicitada.
   * @return La cadena que se colocara en el dataTable
   */
  private String nombreProyectoPor(int i) {
    switch(i) {
    case 0:
      return "Proyecto arquitectonico";
    case 1:
      return "Calculo estructural, instalaciones";
    case 2:
      return "Mecanica de Suelos, Topografia";
    default:
      System.out.println("Error");
      return null;
    }
  }
  
  private String nombreDro (){
      return "DROs y Firmas";
  }
  
  /**
   *Se encarga de convertir la opcion a cadena, la cual estara en el dataTable.
   * @param i El indice de la cadena solicitada.
   * @return La cadena que se colocara en el dataTable
   */
  private String nombreTramiLicDerePor(int i) {
    switch(i) {
    case 0:
      return "Gestiones vecinales y terceros";
    case 1:
      return "Tramites y licencias";
    case 2:
      return "Concertaciones Vecinales";
    case 3:
      return "Pozo de Agua";
    case 4:
      return "Solicitud presupuesto Luz";
    case 5:
      return "Regimen de Propiedad en Condominio";
    default:
      System.out.println("Error");
      return null;
    }
  }
  
  
  /**
   * regresa las cadenas que sera ocupadas en los datatable 
   * @param i el indice de la cadena solicitada
   * @return una cadena para el datatable
   */
  private String nombreVenPor(int i) {
    switch (i) {
    case 0:
      return "Comisiones de venta valor (total de venta)";
    case 1:
      return "Comisiones de venta [contrato] (sobre comisiones)";
    case 2:
      return "Comisiones de venta [titulacion] (sobre comisiones)";
    case 3:
      return "Publicidad [Coorporativo] (valor total de venta)";
    case 4:
      return "Publicidad, promocion, [UNE]";
    case 5:
      return "Escenario provisional/manto/vigilancia (valor total de venta)";
    case 6:
      return "Amueblado y decorado de departamento y oficinas";
    default:
      System.out.println("error");
      break;
    }
    return "";
  }
  
  /**
   *Se encarga de convertir la opcion a cadena, la cual estara en el dataTable.
   * @param i El indice de la cadena solicitada.
   * @return La cadena que se colocara en el dataTable
   */
  private String nombreOtrosPor(int i) {
    switch(i) {
    case 0:
      return "Amenidades";
    case 1:
      return "Otros 2";
    case 2:
      return "Otros 3";
    default:
      System.out.println("Error");
      return null;
    }
  }
  
  /**
   * regresa las cadenas que sera ocupadas en los datatable 
   * @param i el indice de la cadena solicitada
   * @return una cadena para el datatable
   */
  private String nombreSocAdmonPor(int i) {
    switch (i) {
    case 0:
      return "G. Operacion y admon (UNE) (valor total de venta)";
    case 1:
      return "G. Operacion y admon (Coorporativo) (valor total de venta)";
    case 2:
      return "Participacion de socios en las utilidades (resultado del negocio)";
    default:
      System.out.println("error");
      break;
    }
    return "";
  }
  
  /**
   * regresa las cadenas que sera ocupadas en los datatable 
   * @param i el indice de la cadena solicitada
   * @return una cadena para el datatable
   */
  private String nombreCreditoPuentePor(int i) {
    switch (i) {
    case 0:
      return "Credito Puente Solicitado (valor total de venta)";
    case 1:
      return "Apertura de credito (valor total de venta)";
    case 2:
      return "Seguros, Fianzas, Gastos notariales (credito solicitado)";
    case 3:
      return "Supervision de obra / Admon. Recursos (credito solicitado)";
    case 4:
      return "Anticipo (credito solicitado)" ;
    case 5:
      return "Disposicion de Recursos";
    case 6:  
      return "Amortizacion del credito(credito solicitado)";  
    default:
      System.out.println("error");
      break;
    }
    return "";
  }
  
  /**
   * @return the listaTerrenoEsc
   */
  public LinkedList<Parametros> getListaTerrenoEscPor() {
    return listaTerrenoEscPor;
  }
  
  /**
   * @param listaTerrenoEsc the listaTerrenoEsc to set
   */
  public void setListaTerrenoEscPor(LinkedList<Parametros> listaTerrenoEscPor) {
    this.listaTerrenoEscPor = listaTerrenoEscPor;
  }
  
  /**
   * @return the listaProyecto
   */
  public LinkedList<ParametroGenerador> getListaProyecto() {
    return listaProyecto;
  }
  
  /**
   * @param listaProyecto the listaProyecto to set
   */
  public void setListaProyecto(LinkedList<ParametroGenerador> listaProyecto) {
    this.listaProyecto = listaProyecto;
  }

  /**
   * @return the listaTramitesLicDer
   */
  public LinkedList<ParametroGenerador> getListaTramitesLicDer() {
    return listaTramitesLicDer;
  }
  
  /**
   * @param listaTramitesLicDer the listaTramitesLicDer to set
   */
  public void setListaTramitesLicDer(LinkedList<ParametroGenerador> listaTramitesLicDer) {
    this.listaTramitesLicDer = listaTramitesLicDer;
  }
  
  /**
   * @return the listaVentasPor
   */
  public LinkedList<Parametros> getListaVentasPor() {
    return listaVentasPor;
  }

  /**
   * @param listaVentasPor the listaVentasPor to set
   */
  public void setListaVentasPor(LinkedList<Parametros> listaVentasPor) {
    this.listaVentasPor = listaVentasPor;
  }
  
  /**
   * @return the listaOtros
   */
  public LinkedList<ParametroGenerador> getListaOtros() {
    return listaOtros;
  }

  /**
   * @param listaOtros the listaOtros to set
   */
  public void setListaOtros(LinkedList<ParametroGenerador> listaOtros) {
    this.listaOtros = listaOtros;
  }
  
  /**
   * @return the listaSociosGtosAdmonPor
   */
  public LinkedList<Parametros> getListaSociosGtosAdmonPor() {
    return listaSociosGtosAdmonPor;
  }
  
  /**
   * @param listaSociosGtosAdmonPor the listaSociosGtosAdmonPor to set
   */
  public void setListaSociosGtosAdmonPor(LinkedList<Parametros> listaSociosGtosAdmonPor) {
    this.listaSociosGtosAdmonPor = listaSociosGtosAdmonPor;
  }
  
  /**
   * @return the listaCreditoPuente
   */
  public LinkedList<Parametros> getListaCreditoPuente() {
    return listaCreditoPuente;
  }
  
  /**
   * @param listaCreditoPuente the listaCreditoPuente to set
   */
  public void setListaCreditoPuente(LinkedList<Parametros> listaCreditoPuente) {
    this.listaCreditoPuente = listaCreditoPuente;
  }
  
  /**
   * metodo que manda a guaradar el proyecto individual a base
   * @return la caadena menu para jsf
   */
  public String guardarProyectoInd() {
    PryPryInd proyectoInd = guardarInformacion();
    return "menuPrincipal";
  }
  
  
  private PryPryInd guardarInformacion() {
    LoginBean login = (LoginBean) Bean.getBean("loginBean");
    ProyectoEtapas etapas = (ProyectoEtapas) Bean.getBean("proyectosEtapasBean");
    ProyectoFechas fecha = (ProyectoFechas) Bean.getBean("proyectoFechas");
    ProyectosGeneradoresBean generadores = (ProyectosGeneradoresBean) Bean.getBean("proyectosGeneradoresBean");
    ProyectosInfoBasica infoBasica = (ProyectosInfoBasica) Bean.getBean("proyectosInfoBasica");
    Terreno terreno = (Terreno) Bean.getBean("terreno");
    Cetes cetes = (Cetes)Bean.getBean("cetes");
    CreditoPuente credPuente = (CreditoPuente)Bean.getBean("creditoPuente");
    Inflacion inflacion = (Inflacion)Bean.getBean("inflacion");
    GuardadorProyecto guardadorProyecto;
    guardadorProyecto = new GuardadorProyecto(login, etapas, fecha, generadores,
            infoBasica, cetes, credPuente, inflacion, terreno);
    return guardadorProyecto.guardar();
  }

    /**
     * @return the listaAdministracionFideicomiso
     */
    public LinkedList<Parametros> getListaAdministracionFideicomiso() {
        return listaAdministracionFideicomiso;
    }
  
}
