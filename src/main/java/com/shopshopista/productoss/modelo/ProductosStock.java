/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.modelo;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.annotation.CreatedDate;

/**
 *
 * @author Linis
 */
public class ProductosStock {
    
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_producto_stock;
     
    private Productos id_producto;
    private int prst_cantidad ;
    
     @CreatedDate
    private Date prst_fecha_ingreso;

    public Long getId_producto_stock() {
        return id_producto_stock;
    }

    public void setId_producto_stock(Long id_producto_stock) {
        this.id_producto_stock = id_producto_stock;
    }

    public Productos getId_producto() {
        return id_producto;
    }

    public void setId_producto(Productos id_producto) {
        this.id_producto = id_producto;
    }

    public int getPrst_cantidad() {
        return prst_cantidad;
    }

    public void setPrst_cantidad(int prst_cantidad) {
        this.prst_cantidad = prst_cantidad;
    }

    public Date getPrst_fecha_ingreso() {
        return prst_fecha_ingreso;
    }

    public void setPrst_fecha_ingreso(Date prst_fecha_ingreso) {
        this.prst_fecha_ingreso = prst_fecha_ingreso;
    }
     
    
}
