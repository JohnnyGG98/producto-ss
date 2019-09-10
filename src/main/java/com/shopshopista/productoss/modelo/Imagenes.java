/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.modelo;

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
@Table(name = "Imagenes")
public class Imagenes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id_imagen", nullable = false)
    private Long id_imagen;

    @Column(name = "id_producto", nullable = false)
    private Long id_producto;

    @Column(name = "prod_descripcion", nullable = false)
    private String prod_descripcion;

    @Column(name = "ima_activo", columnDefinition = "BOOLEAN DEFAULT  'true' ")
    private boolean ima_activo;

    public Imagenes() {
    }

    public Imagenes(Long id_imagen, Long id_producto, String prod_descripcion, boolean ima_activo) {
        this.id_imagen = id_imagen;
        this.id_producto = id_producto;
        this.prod_descripcion = prod_descripcion;
        this.ima_activo = ima_activo;
    }

    public Long getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(Long id_imagen) {
        this.id_imagen = id_imagen;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getProd_descripcion() {
        return prod_descripcion;
    }

    public void setProd_descripcion(String prod_descripcion) {
        this.prod_descripcion = prod_descripcion;
    }

    public boolean isIma_activo() {
        return ima_activo;
    }

    public void setIma_activo(boolean ima_activo) {
        this.ima_activo = ima_activo;
    }

}
