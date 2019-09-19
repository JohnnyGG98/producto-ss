/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.Table;
/**
 *
 * @author Linis
 */
@Entity
@Table(
        name = "\"Cardex\"",
        schema = "producto"
)
public class Cardex {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_cardex;
    
    @Column(name = "capr_fecha_ingreso ", nullable = false)
    private Date capr_fecha_ingreso;
    @Column(name = "capr_num_producto", nullable = false)
    private int capr_num_producto;
    @Column(name = "capr_activo", nullable = false)
    private boolean capr_activo;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto")
    @JsonBackReference(value = "cardex-producto")
    private Productos producto;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo_transaccion ")
    @JsonBackReference(value = "cardex-tipo-transaccion")
    private TiposTransaccion tipoTransaccion;

    public Cardex() {
    }

    public Cardex(Long id_cardex, Date capr_fecha_ingreso, int capr_num_producto, boolean capr_activo, Productos producto, TiposTransaccion tipoTransaccion) {
        this.id_cardex = id_cardex;
        this.capr_fecha_ingreso = capr_fecha_ingreso;
        this.capr_num_producto = capr_num_producto;
        this.capr_activo = capr_activo;
        this.producto = producto;
        this.tipoTransaccion = tipoTransaccion;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public Long getId_cardex() {
        return id_cardex;
    }

    public void setId_cardex(Long id_cardex) {
        this.id_cardex = id_cardex;
    }

    public Date getCapr_fecha_ingreso() {
        return capr_fecha_ingreso;
    }

    public void setCapr_fecha_ingreso(Date capr_fecha_ingreso) {
        this.capr_fecha_ingreso = capr_fecha_ingreso;
    }

    public int getCapr_num_producto() {
        return capr_num_producto;
    }

    public void setCapr_num_producto(int capr_num_producto) {
        this.capr_num_producto = capr_num_producto;
    }

    public boolean isCapr_activo() {
        return capr_activo;
    }

    public void setCapr_activo(boolean capr_activo) {
        this.capr_activo = capr_activo;
    }

    public TiposTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTrasaccion(TiposTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
    
}

