package Beans.Proyecto;

import Beans.Bean;
import java.util.Date;
import util.Parametros;
import java.util.LinkedList;
import util.ParametroGenerador;

/**
 * Clase que es un ManagedBean para el llenado de la familia de info basica
 * para los vehiculos
 * @author Luis Takisawa
 */
public class ProyectosInfoBasica extends Bean {

  //modificacion de prueba =)
  private LinkedList<Parametros> listaTerreno;
  private LinkedList<ParametroGenerador> listaConstruccion;
  private LinkedList<Parametros> listaMeses;
  private String nombre;
  private String numEtapas;
  private Date fechaInicioTerrenos;
  private Date fechaFinTerrenos;
  private Date fechaDeElaboracion;
  private Date cifraAlMesDe;
  private final int NUMPARTERR = 2;
  private final int NUMPARCONS = 12;
  private final int NUMMESES = 2;

  public ProyectosInfoBasica() {
    this.listaTerreno = new LinkedList<Parametros>();
    this.listaConstruccion = new LinkedList<ParametroGenerador>();
    this.listaMeses = new LinkedList<Parametros>();


    for (int i = 0; i < NUMPARTERR; i++) {
      listaTerreno.add(new Parametros(ParametrosTerreno(i), ""));
    }

    for (int j = 0; j < NUMPARCONS; j++) {
      listaConstruccion.add(new ParametroGenerador(ParametrosConstruccion(j), "", ""));
    }

    for (int k = 0; k < NUMMESES; k++) {
      listaMeses.add(new Parametros(ParametrosMeses(k), ""));
    }

  }

  public ProyectosInfoBasica(Object object) {
  }

  /**
   * regresa las cadenas que sera ocupadas en los datatable 
   * @param i el indice de la cadena solicitada
   * @return una cadena para el datatable
   */
  private String ParametrosTerreno(int i) {
    switch (i) {
      case 0:
        return "Superficie del terreno en m2";
      case 1:
        return "Costo del m2";
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
  private String ParametrosConstruccion(int j) {
    switch (j) {
      case 0:
        return "Edificacion de Casas";
      case 1:
        return "Urbanizacion";
      case 2:
        return "Urbanizacion Acceso";
      case 3:
        return "Edificacion de departamentos";
      case 4:
        return "Ornato";
      case 5:
        return "Gastos Generales";
      case 6:
        return "Imprevistos";
      case 7:
        return "Obligaciones Patronales";
      case 8:
        return "Paquete de acabados";
      case 9:
        return "Mantenimiento y Vigilancia";
      case 10:
        return "Supervision de Obra";
      case 11:
        return "Infraestructura";
      default:
        System.out.println("error");
        break;

    }
    return "";

  }

  private String ParametrosMeses(int k) {
    switch (k) {
      case 0:
        return "Meses para conformacion de Enganche";
      case 1:
        return "Meses para conformacion de Titulacion";
      default:
        System.out.println("error");
        break;
    }
    return "";
  }

  public void ponerFechas(Date inicioTerrenos, Date finTerrenos) {
    this.setFechaInicioTerrenos(inicioTerrenos);
    this.setFechaFinTerrenos(finTerrenos);
  }

  /**
   * @return the fechaInicioTerrenos
   */
  public Date getFechaInicioTerrenos() {
    return fechaInicioTerrenos;
  }

  /**
   * @param fechaInicioTerrenos the fechaInicioTerrenos to set
   */
  public void setFechaInicioTerrenos(Date fechaInicioTerrenos) {
    this.fechaInicioTerrenos = fechaInicioTerrenos;
  }

  /**
   * @return the fechaFinTerrenos
   */
  public Date getFechaFinTerrenos() {
    return fechaFinTerrenos;
  }

  /**
   * @param fechaFinTerrenos the fechaFinTerrenos to set
   */
  public void setFechaFinTerrenos(Date fechaFinTerrenos) {
    this.fechaFinTerrenos = fechaFinTerrenos;
  }

  /**
   * @return the listaTerreno
   */
  public LinkedList<Parametros> getListaTerreno() {
    return listaTerreno;
  }

  /**
   * @param listaTerreno the listaTerreno to set
   */
  public void setListaTerreno(LinkedList<Parametros> listaTerreno) {
    this.setListaTerreno(listaTerreno);
  }

  /**
   * @return the listaConstruccion
   */
  public LinkedList<ParametroGenerador> getListaConstruccion() {
    return listaConstruccion;
  }

  /**
   * @param listaConstruccion the listaConstruccion to set
   */
  public void setListaConstruccion(LinkedList<Parametros> listaConstruccion) {
    this.setListaConstruccion(listaConstruccion);
  }

  /**
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @param nombre the nombre to set
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Date getCifraAlMesDe() {
    return cifraAlMesDe;
  }

  /**
   * @param fechaDeElaboracion the fechaDeElaboracion to set
   */
  public void setCifraAlMesDe(Date CifraAlMesDe) {
    this.cifraAlMesDe = CifraAlMesDe;
  }

  /**
   * @return the fechaDeElaboracion
   */
  public Date getFechaDeElaboracion() {
    return fechaDeElaboracion;
  }

  /**
   * @param fechaDeElaboracion the fechaDeElaboracion to set
   */
  public void setFechaDeElaboracion(Date fechaDeElaboracion) {
    this.fechaDeElaboracion = fechaDeElaboracion;
  }

  /**
   * @return the numEtapas
   */
  public String getNumEtapas() {
    return numEtapas;
  }

  /**
   * @param numEtapas the numEtapas to set
   */
  public void setNumEtapas(String numEtapas) {
    this.numEtapas = numEtapas;
  }

  public String pasarEtapas() {
    if (Integer.parseInt(numEtapas) > 0) {
      return "etapas";
    }
    return "";
  }

  /**
   * @return the listaMeses
   */
  public LinkedList<Parametros> getListaMeses() {
    return listaMeses;
  }

  /**
   * @param listaMeses the listaMeses to set
   */
  public void setListaMeses(LinkedList<Parametros> listaMeses) {
    this.listaMeses = listaMeses;
  }
}
