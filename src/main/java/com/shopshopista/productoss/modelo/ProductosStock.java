/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.modelo;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Linis
 */
@Entity
@Table(name = "ProductosStock")
public class ProductosStock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id_marca", nullable = false)
    private Long id_producto_stock;

    @Column(name = "id_producto", nullable = false)
    private Long id_producto;

    @Column(name = "prst_cantidad", nullable = false)
    private int prst_cantidad;

    @Column(name = "prst_fecha_ingreso", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime prst_fecha_ingreso;

    @Column(name = "prst_activo", columnDefinition = "BOOLEAN DEFAULT  'true' ")
    private boolean prst_activo;

    public ProductosStock() {
    }

    public ProductosStock(Long id_producto_stock, Long id_producto, int prst_cantidad, LocalDateTime prst_fecha_ingreso, boolean prst_activo) {
        this.id_producto_stock = id_producto_stock;
        this.id_producto = id_producto;
        this.prst_cantidad = prst_cantidad;
        this.prst_fecha_ingreso = prst_fecha_ingreso;
        this.prst_activo = prst_activo;
    }

    public Long getId_producto_stock() {
        return id_producto_stock;
    }

    public void setId_producto_stock(Long id_producto_stock) {
        this.id_producto_stock = id_producto_stock;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public int getPrst_cantidad() {
        return prst_cantidad;
    }

    public void setPrst_cantidad(int prst_cantidad) {
        this.prst_cantidad = prst_cantidad;
    }

  

}
