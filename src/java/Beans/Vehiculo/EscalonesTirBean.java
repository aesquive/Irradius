/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.Vehiculo;

import Beans.Bean;
import Beans.General.LoginBean;
import Beans.Vehiculo.Pantallas.AltaModelo;
import guardadores.Vehiculo.GuardadorVehiculo;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import pojos.PryVeh;
import util.Espejo;
import util.vehiculo.EscalonTir;
import util.Parametros;

/**
 *
 * @author Alberto
 */
public class EscalonesTirBean extends Bean {

    private String nombreBoton;
    private List<EscalonTir> escalones;
    private List<Parametros> valores;
    private int escalonActual;

    public EscalonesTirBean() {
        escalonActual = 1;
        escalones = new LinkedList<EscalonTir>();
        llenarListas();
        this.nombreBoton = asignarBoton();
    }

    public EscalonesTirBean(Object object) {
        escalonActual = 1;
    }

    private void llenarListas() {

        setValores(new LinkedList<Parametros>());

        getValores().add(new Parametros("TIR de escalon", ""));
        getValores().add(new Parametros("% de Distribucion al Inversionista", ""));
    }

    public String guardarEtapa() {
        VehiculoFamiliaPremisasInversion bean = (VehiculoFamiliaPremisasInversion) Bean.getBean("vehiculoInversion");
        int etapasReales = (bean.getNumeroEscalonesTIR());
        guardarBean();
        if (this.getEscalonActual() != etapasReales) {
            setEscalonActual(getEscalonActual() + 1);
            llenarBean(getEscalonActual());
            this.nombreBoton = asignarBoton();
            return "escalonesTir";
        } else {
            guardarTodoVehiculo();
            return "menu";
        }
    }

    public String guardarEtapa2() {

        guardarTodoVehiculo();
        return "accionesVehiculo";

    }

    public String regresarEtapa() {

        guardarBean();

        if (this.getEscalonActual() == 1) {
            System.out.println("vengo regreso informacion");
            return "inversion";
        } else {
            setEscalonActual(getEscalonActual() - 1);
            llenarBean(getEscalonActual());
            System.out.println("vengo regreso etapas");
            this.nombreBoton = asignarBoton();
            return "escalonesTir";
        }

    }

    private void llenarBean(int numeroBean) {
        EscalonTir etapa = null;
        System.out.println("saque el bean " + numeroBean);
        try {
            etapa = getEscalones().get(numeroBean - 1);

        } catch (IndexOutOfBoundsException out) {
            System.out.println("cai en el out of bounds");
            llenarListas();
            return;
        }
        System.out.println("cai en el no out");
        this.setValores(etapa.getValores());
    }

    private void guardarBean() {
        EscalonTir etapa = new EscalonTir(this.getValores());
        int tmp = getEscalonActual() - 1;
        try {

            this.getEscalones().get(tmp);
        } catch (IndexOutOfBoundsException out) {
            getEscalones().add(tmp, etapa);
            return;
        }
        getEscalones().set(tmp, etapa);
    }

    private void guardarTodoVehiculo() {
        GeneralVehiculoBean general = (GeneralVehiculoBean) Bean.getBean("generalVehiculoBean");
        if (general.isVer()){
            resetearBeans();
            return;
        }
        imprimirFechas();
        PryVeh nuevo = guardarInformacion();
        resetearBeans();
        if (general.modificar) {
            general.quitarProyecto(general.getProyectoSeleccionado());
        }
        general.agregarProyecto(nuevo);
        return;

    }

    public String asignarBoton() {
        VehiculoFamiliaPremisasInversion bean = (VehiculoFamiliaPremisasInversion) Bean.getBean("vehiculoInversion");
        int etapasReales = (bean.getNumeroEscalonesTIR());
        if (this.getEscalonActual() == etapasReales) {
            this.nombreBoton = "Terminar";
            return "Terminar";
        }
        this.nombreBoton = "Siguiente";
        return "Siguiente";
    }

    /**
     * @return the escalones
     */
    public List<EscalonTir> getEscalones() {
        return escalones;
    }

    /**
     * @param escalones the escalones to set
     */
    public void setEscalones(List<EscalonTir> escalones) {
        this.escalones = escalones;
    }

    /**
     * @return the valores
     */
    public List<Parametros> getValores() {
        return valores;
    }

    /**
     * @param valores the valores to set
     */
    public void setValores(List<Parametros> valores) {
        this.valores = valores;
    }

    /**
     * @return the escalonActual
     */
    public int getEscalonActual() {
        return escalonActual;
    }

    /**
     * @param escalonActual the escalonActual to set
     */
    public void setEscalonActual(int escalonActual) {
        this.escalonActual = escalonActual;
    }

    /**
     * @return the nombreBoton
     */
    public String getNombreBoton() {
        return nombreBoton;
    }

    private PryVeh guardarInformacion() {
        LoginBean login = (LoginBean) Bean.getBean("loginBean");
        GeneralVehiculoBean general = (GeneralVehiculoBean) Bean.getBean("generalVehiculoBean");
        VehiculoFamiliaParametricasBean parametricas = (VehiculoFamiliaParametricasBean) Bean.getBean("vehiculoParametricas");
        VehiculoFamiliaPremisasFinancieras financieras = (VehiculoFamiliaPremisasFinancieras) Bean.getBean("vehiculoFinancieras");
        VehiculoFamiliaPremisasInversion inversion = (VehiculoFamiliaPremisasInversion) Bean.getBean("vehiculoInversion");
        EtapasVehiculo etapas = (EtapasVehiculo) Bean.getBean("etapasVehiculo");
        FechasBean fechas = (FechasBean) Bean.getBean("fechasBean");
        EdificacionBean edificacion = (EdificacionBean) Bean.getBean("edificacionBean");
        EscalonesTirBean escalonesTir = (EscalonesTirBean) Bean.getBean("escalonesTir");
        TitulacionBean titulacion = (TitulacionBean) Bean.getBean("titulacionBean");
        VentaBean ventaBean = (VentaBean) Bean.getBean("ventaBean");
        int id=general.getProyectoSeleccionado()==null ? -1 :general.getProyectoSeleccionado().getId();
        GuardadorVehiculo guardadorVehiculo = new GuardadorVehiculo(general.modificar,id,login, general, parametricas, financieras, etapas, fechas, edificacion, ventaBean, titulacion, inversion, escalonesTir);
        return guardadorVehiculo.guardar();
    }

    private void resetearBeans() {
        Bean.limpiaBeans("ventaBean", "titulacionBean", "escalonesTir", "edificacionBean", "fechasBean",
                "vehiculoInversion", "vehiculoFinancieras", "vehiculoParametricas", "etapasVehiculo", "generalModeloVehiculoBean",
                "etapasModeloVehiculoBean", "altaModelo");
    }

    private void imprimirFechas() {
        FechasBean fechas = (FechasBean) Bean.getBean("fechasBean");
        List<Method> ters = Espejo.getGetters(FechasBean.class);
        for (Method m : ters) {
            System.out.println(m.getName() + " " + Espejo.invocarGetter(fechas, m));
        }
    }

    private void agregarProyectoModelo(PryVeh nuevo) {
        AltaModelo alta = (AltaModelo) Bean.getBean("altaModelo");
        alta.agregarProyecto(nuevo);
    }
}
