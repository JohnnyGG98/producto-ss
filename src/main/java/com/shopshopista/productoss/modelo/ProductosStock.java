/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedDate;

/**
 *
 * @author Linis
 */
@Entity
@Table(name = "ProductosStock")
public class ProductosStock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_producto_stock")
    private Long id_producto_stock;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto")
    private Productos id_producto;

    @Column(name = "prst_cantidad")
    private int prst_cantidad;

    @Column(name = "prst_fecha_ingreso", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime prst_fecha_ingreso;

    @Column(name = "prst_activo", columnDefinition = "BOOLEAN DEFAULT 'true'")
    private boolean prst_activo;

    public ProductosStock() {
    }

    public ProductosStock(Long id_producto_stock, Productos id_producto, int prst_cantidad, LocalDateTime prst_fecha_ingreso) {
        this.id_producto_stock = id_producto_stock;
        this.id_producto = id_producto;
        this.prst_cantidad = prst_cantidad;
        this.prst_fecha_ingreso = prst_fecha_ingreso;
    }

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

    public LocalDateTime getPrst_fecha_ingreso() {
        return prst_fecha_ingreso;
    }

    public void setPrst_fecha_ingreso(LocalDateTime prst_fecha_ingreso) {
        this.prst_fecha_ingreso = prst_fecha_ingreso;
    }

    @Override
    public String toString() {
        return "ProductosStock{" + "id_producto_stock=" + id_producto_stock + ", id_producto=" + id_producto + ", prst_cantidad=" + prst_cantidad + ", prst_fecha_ingreso=" + prst_fecha_ingreso + '}';
    }

}
