/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.pojo;

/**
 *
 * @author HP
 */
public class CalificacionesProductoRQ {
     private long id_calificacion = 0;
    private long id_cliente;
    private double calificacion;
    private long id_producto;

    public long getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(long id_calificacion) {
        this.id_calificacion = id_calificacion;
    }

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
        this.id_producto = id_producto;
    }
    
}
