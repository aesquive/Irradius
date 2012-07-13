/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.primefaces.model.chart.CartesianChartModel;

/**
 *
 * @author JOSELUIS
 */
public class Grafica {
    
    private String nombre;
    private int min;
    private int max;
    private CartesianChartModel categoryModel;
    private String xLabel;
    private String yLabel;

    public Grafica(String nombre, int min, int max, CartesianChartModel categoryModel, String xLabel, String yLabel) {
        this.nombre = nombre;
        this.min = min;
        this.max = max;
        this.categoryModel = categoryModel;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
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

    /**
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * @return the categoryModel
     */
    public CartesianChartModel getCategoryModel() {
        return categoryModel;
    }

    /**
     * @param categoryModel the categoryModel to set
     */
    public void setCategoryModel(CartesianChartModel categoryModel) {
        this.categoryModel = categoryModel;
    }

    /**
     * @return the xLabel
     */
    public String getxLabel() {
        return xLabel;
    }

    /**
     * @param xLabel the xLabel to set
     */
    public void setxLabel(String xLabel) {
        this.xLabel = xLabel;
    }

    /**
     * @return the yLabel
     */
    public String getyLabel() {
        return yLabel;
    }

    /**
     * @param yLabel the yLabel to set
     */
    public void setyLabel(String yLabel) {
        this.yLabel = yLabel;
    }
    
}
