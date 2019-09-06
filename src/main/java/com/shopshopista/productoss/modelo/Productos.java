/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedDate;

/**
 *
 * @author Linis
 */
@Entity
@Table(name = "Productos")
public class Productos {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_producto;
    @JoinColumn(name = "id_vendedor")
    // private Vendedores id_vendedor;
    @JoinColumn(name = "id_marcar")
    private Marcas id_marcar;
    @Column(name = "prod_nombre", nullable = false)
    private String prod_nombre;

    @CreatedDate

    private Date prod_fecha_inreso;
    private int prod_stock_total;    //Deberia ir Double
    private String prod_marca;
    private int prod_precio_venta;  //Deberia ir Double
    private String prod_descripcion;
    private int prod_restriccion_edad_max;
    private int prod_restriccion_edad_min;
    private boolean prod_activo;

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public Marcas getId_marcar() {
        return id_marcar;
    }

    public void setId_marcar(Marcas id_marcar) {
        this.id_marcar = id_marcar;
    }

    public String getProd_nombre() {
        return prod_nombre;
    }

    public void setProd_nombre(String prod_nombre) {
        this.prod_nombre = prod_nombre;
    }

    public Date getProd_fecha_inreso() {
        return prod_fecha_inreso;
    }

    public void setProd_fecha_inreso(Date prod_fecha_inreso) {
        this.prod_fecha_inreso = prod_fecha_inreso;
    }

    public int getProd_stock_total() {
        return prod_stock_total;
    }

    public void setProd_stock_total(int prod_stock_total) {
        this.prod_stock_total = prod_stock_total;
    }

    public String getProd_marca() {
        return prod_marca;
    }

    public void setProd_marca(String prod_marca) {
        this.prod_marca = prod_marca;
    }

    public int getProd_precio_venta() {
        return prod_precio_venta;
    }

    public void setProd_precio_venta(int prod_precio_venta) {
        this.prod_precio_venta = prod_precio_venta;
    }

    public String getProd_descripcion() {
        return prod_descripcion;
    }

    public void setProd_descripcion(String prod_descripcion) {
        this.prod_descripcion = prod_descripcion;
    }

    public int getProd_restriccion_edad_max() {
        return prod_restriccion_edad_max;
    }

    public void setProd_restriccion_edad_max(int prod_restriccion_edad_max) {
        this.prod_restriccion_edad_max = prod_restriccion_edad_max;
    }

    public int getProd_restriccion_edad_min() {
        return prod_restriccion_edad_min;
    }

    public void setProd_restriccion_edad_min(int prod_restriccion_edad_min) {
        this.prod_restriccion_edad_min = prod_restriccion_edad_min;
    }

    public boolean isProd_activo() {
        return prod_activo;
    }

    public void setProd_activo(boolean prod_activo) {
        this.prod_activo = prod_activo;
    }

}
