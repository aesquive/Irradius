package Beans.Proyecto;

import Beans.Bean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import util.EtapaProyecto;
import util.Parametros;
import util.RegistroFecha;

/**
 * Clase que es un ManagedBean para el llenado de los parametros de las etapas
 * @author Daniel Gonzalez Teran
 * @version 1.2
 * @author Galindo Martinez Jose Cruz
 */
public class ProyectoEtapas extends Bean {

  /**
   * variable donde guardaremos cada una de las etapas 
   */
  private LinkedList<EtapaProyecto> etapas;
  /**
   * variable donde guardamos el numero de etapa que estamos guardando
   */
  private int etapaActual;
  /**
   * lista de parametros de la etapa (porcentajes)
   */
  private LinkedList<Parametros> listaParametrosPorcentajes;
  /**
   * lista de parametros de la etapa
   */
  private LinkedList<Parametros> listaParametros;
  private LinkedList<RegistroFecha> fechasVentas;
  private LinkedList<RegistroFecha> fechasTitulacion;
  /**
   * nombre de la etapa
   */
  private String nomEta;
  /**
   * tamaño de la listaParametros
   */
  private final int NUMPAR = 4;
  /**
   * tamaño de la listaParametrosPorcentajes
   */
  private final int NUMPARPOR = 1;

  /******/
  public ProyectoEtapas() {
    this.etapas = new LinkedList<EtapaProyecto>();
    this.fechasVentas = new LinkedList<RegistroFecha>();
    this.fechasTitulacion = new LinkedList<RegistroFecha>();
    etapaActual = 1;
    llenarListas();
  }

  //el llenar las listas otra vez las limpia
  private void llenarListas() {
    this.nomEta = "";
    listaParametrosPorcentajes = new LinkedList<Parametros>();
    listaParametros = new LinkedList<Parametros>();
//    setListaParametrosFinancierosPor(new LinkedList<Parametros>());
    for (int j = 0; j < NUMPAR; j++) {
      getListaParametros().add(new Parametros(nombreParametros(j), ""));
    }

    for (int i = 0; i < NUMPARPOR; i++) {
      getListaParametrosPorcentajes().add(new Parametros(nombreParametrosPorcentajes(i), ""));
    }

    setFechasVentas(new LinkedList<RegistroFecha>());
    setFechasTitulacion(new LinkedList<RegistroFecha>());

  }

  /**
   * regresa las cadenas que sera ocupadas en la tabla de parametros de las etapas 
   * @param i el indice de la cadena solicitada
   * @return una cadena para el tabla
   */
  private String nombreParametros(int i) {
    switch (i) {
      case 0:
        return "Numero de viviendas";
      case 1:
        return "Precio por m2";
      case 2:
        return "m2 por unidad";
      case 3:
        return "Sobreprecio";
      default:
        System.out.println("error");
        break;
    }
    return "";
  }

  /**
   * regresa las cadenas que sera ocupadas en la tabla de parametros de las etapas (porcentajes)
   * @param i el indice de la cadena solicitada
   * @return una cadena para el tabla
   */
  private String nombreParametrosPorcentajes(int i) {
    switch (i) {
      case 0:
        return "Enganche";
      default:
        System.out.println("error");
        break;
    }
    return "";
  }

  /****/
  public String guardarEtapa() {
    ProyectosInfoBasica bean = (ProyectosInfoBasica) Bean.getBean("proyectosInfoBasica");
    String numEtapaCadena = bean.getNumEtapas();
    String etapa = numEtapaCadena.trim();
    int etapasReales = Integer.parseInt(etapa);
    guardarBean();
    if (this.etapaActual != etapasReales) {
      ++etapaActual;
      llenarBean(etapaActual);
      llenarListaFechaVenta();
      llenarListaFechaTitulacion();
      System.out.println("fui acabe y regreso etapas");
      return "etapas";
    } else {
      System.out.println("fui regreso fechas");
      return "generadores";
    }
  }

  /**
   * Se encarga de llenar los data table de las matrices de venta
   */
  private void llenarListaFechaVenta() {
    ProyectoFechas bean = (ProyectoFechas) Bean.getBean("proyectoFechas");
    Date original1 = bean.getFechaInicioVenta();
    Date original2 = bean.getFechaFinVenta();
    Date fechaInicioEdificacion = original1;
    Date fechaFinEdificacion = original2;
    SimpleDateFormat sdf = new SimpleDateFormat("MMMMM-yyyy");
    if (fechaInicioEdificacion.equals(fechaFinEdificacion)) {
      String cad = sdf.format(fechaInicioEdificacion);
      RegistroFecha registro = new RegistroFecha(cad);
      fechasVentas.add(registro);
    } else {
      while (fechaInicioEdificacion.compareTo(fechaFinEdificacion) < 0) {
        String cad = sdf.format(fechaInicioEdificacion);
        RegistroFecha registro = new RegistroFecha(cad);
        fechasVentas.add(registro);
        fechaInicioEdificacion.setMonth(fechaInicioEdificacion.getMonth() + 1);
      }
      fechasVentas.add(new RegistroFecha(sdf.format(fechaFinEdificacion)));
      fechaInicioEdificacion.setMonth(original1.getMonth());
      fechaFinEdificacion.setYear(original1.getYear());
    }
  }

  
  /**
   * Se encarga de llenar los data table de las matrices de titulacion
   */
  private void llenarListaFechaTitulacion() {
    ProyectoFechas bean = (ProyectoFechas) Bean.getBean("proyectoFechas");
    Date original1 = bean.getFechaInicioTitulacion();
    Date original2 = bean.getFechaFinTitulacion();
    Date fechaInicioEdificacion = original1;
    Date fechaFinEdificacion = original2;
    SimpleDateFormat sdf = new SimpleDateFormat("MMMMM-yyyy");
    if (fechaInicioEdificacion.equals(fechaFinEdificacion)) {
      String cad = sdf.format(fechaInicioEdificacion);
      RegistroFecha registro = new RegistroFecha(cad);
      fechasTitulacion.add(registro);
    } else {
      while (fechaInicioEdificacion.compareTo(fechaFinEdificacion) < 0) {
        String cad = sdf.format(fechaInicioEdificacion);
        RegistroFecha registro = new RegistroFecha(cad);
        fechasTitulacion.add(registro);
        fechaInicioEdificacion.setMonth(fechaInicioEdificacion.getMonth() + 1);
      }
      fechasTitulacion.add(new RegistroFecha(sdf.format(fechaFinEdificacion)));
      fechaInicioEdificacion.setMonth(original1.getMonth());
      fechaFinEdificacion.setYear(original1.getYear());
    }
  }

  
  /*****/
  public String regresarEtapa() {
    guardarBean();
    if (this.etapaActual == 1) {
      System.out.println("vengo regreso informacion");
      return "informacion";
    } else {
      etapaActual--;
      llenarBean(etapaActual);
      System.out.println("vengo regreso etapas");
      return "etapas";
    }
  }

  /**
   * @return the etapas
   */
  public LinkedList<EtapaProyecto> getEtapas() {
    return etapas;
  }

  /**
   * @param etapas the etapas to set
   */
  public void setEtapas(LinkedList<EtapaProyecto> etapas) {
    this.setEtapas(etapas);
  }

  /**
   * @return the etapaActual
   */
  public int getEtapaActual() {
    return etapaActual;
  }

  /**
   * @param etapaActual the etapaActual to set
   */
  public void setEtapaActual(int etapaActual) {
    this.etapaActual = etapaActual;
  }

  /**
   * @return the listaParametrosPorcentajes
   */
  public LinkedList<Parametros> getListaParametrosPorcentajes() {
    return listaParametrosPorcentajes;
  }

  /**
   * @param listaParametrosPorcentajes the listaParametrosPorcentajes to set
   */
  public void setListaParametrosPorcentajes(LinkedList<Parametros> listaParametrosPorcentajes) {
    this.listaParametrosPorcentajes = listaParametrosPorcentajes;
  }

  /**
   * @return the listaParametros
   */
  public LinkedList<Parametros> getListaParametros() {
    return listaParametros;
  }

  /**
   * @param listaParametros the listaParametros to set
   */
  public void setListaParametros(LinkedList<Parametros> listaParametros) {
    this.listaParametros = listaParametros;
  }

  /**
   * @return the nomEta
   */
  public String getNomEta() {
    return nomEta;
  }

  /**
   * @param nomEta the nomEta to set
   */
  public void setNomEta(String nomEta) {
    this.nomEta = nomEta;
  }

  /*****/
  private void llenarBean(int numeroBean) {
    EtapaProyecto etapa = null;
    System.out.println("saque el bean " + numeroBean);
    try {
      etapa = etapas.get(numeroBean - 1);
    } catch (IndexOutOfBoundsException out) {
      System.out.println("cai en el out of bounds");
      //
      llenarListas();
      return;
    }
    System.out.println("cai en el no out");
    this.listaParametros = etapa.getListaParametrosNo();
    this.listaParametrosPorcentajes = etapa.getListaParametrosPorcentajes();
    this.nomEta = etapa.getNomEta();
  }

  //Se agregaraon parametros y se pusieron las fechas
  private void guardarBean() {
    EtapaProyecto etapa = new EtapaProyecto(listaParametrosPorcentajes,
            listaParametros, getFechasVentas(), getFechasTitulacion(), nomEta);
    int tmp = etapaActual - 1;
    try {
      etapas.get(tmp);
    } catch (IndexOutOfBoundsException out) {
      etapas.add(tmp, etapa);
      return;
    }
    etapas.set(tmp, etapa);
  }

  /*
   *>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
   */
  private void imprimeGuardados() {
    for (EtapaProyecto et : etapas) {
      sacarDatos(et);
    }
  }

  //Lo unico que hace es imprimir los datos de una etapa 
  private void sacarDatos(EtapaProyecto e) {
    String nomEta1 = e.getNomEta();
    LinkedList<Parametros> listaParametros1 = e.getListaParametrosNo();
    LinkedList<Parametros> listaParametrosPorcentajes1 = e.getListaParametrosPorcentajes();
    LinkedList<RegistroFecha> listaFechasVenta = e.getListaFechasVenta();
    LinkedList<RegistroFecha> listaFechasTitulacion = e.getListaFechasTitulacion();
    System.out.println("Parametros");
    for (Parametros p : listaParametros1) {
      System.out.println(p.getRegistroDescripcion());
      System.out.println(p.getRegistroIngreso());
    }
    System.out.println("Porcentaje");
    for (Parametros p : listaParametrosPorcentajes1) {
      System.out.println(p.getRegistroDescripcion());
      System.out.println(p.getRegistroIngreso());
    }
    System.out.println("Matriz de Ventas");
    for (RegistroFecha p : listaFechasVenta) {
      System.out.println(p.getFecha());
      if (p.getPorcentaje() != null) {
        System.out.println(p.getPorcentaje());
      } else {
        String q = p.getPorcentaje() + "esta vacio";
        System.out.println(q);
      }
    }
    System.out.println("Matriz de Titulacion");
    for (RegistroFecha p : listaFechasTitulacion) {
      System.out.println(p.getFecha());
      System.out.println(p.getPorcentaje());
    }

  }

  /**
   * @return the fechasVentas
   */
  public LinkedList<RegistroFecha> getFechasVentas() {
    llenarListaFechaVenta();
    return fechasVentas;
  }

  /**
   * @param fechasVentas the fechasVentas to set
   */
  public void setFechasVentas(LinkedList<RegistroFecha> fechasVentas) {
    this.fechasVentas = fechasVentas;
  }

  /**
   * @return the fechasTitulacion
   */
  public LinkedList<RegistroFecha> getFechasTitulacion() {
    llenarListaFechaTitulacion();
    return fechasTitulacion;
  }

  /**
   * @param fechasTitulacion the fechasTitulacion to set
   */
  public void setFechasTitulacion(LinkedList<RegistroFecha> fechasTitulacion) {
    this.fechasTitulacion = fechasTitulacion;
  }
}//end class 