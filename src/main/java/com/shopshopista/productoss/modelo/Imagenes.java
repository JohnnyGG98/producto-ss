/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name="Imagenes")
public class Imagenes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name="id_imagen", nullable=false)
    private Long id_imagen;

    @JsonBackReference(value="rf_imagenes")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto")
    private Productos id_producto;
    
    
    @Column(name="ima_activo",columnDefinition = "BOOLEAN DEFAULT 'true'")
    private boolean ima_activo;

    public Imagenes() {
    }

    public Imagenes(Long id_imagen, Productos id_producto, boolean ima_activo) {
        this.id_imagen = id_imagen;
        this.id_producto = id_producto;
        this.ima_activo = ima_activo;
    }

    public Long getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(Long id_imagen) {
        this.id_imagen = id_imagen;
    }

    public Productos getId_producto() {
        return id_producto;
    }

    public void setId_producto(Productos id_producto) {
        this.id_producto = id_producto;
    }

    public boolean isIma_activo() {
        return ima_activo;
    }

    public void setIma_activo(boolean ima_activo) {
        this.ima_activo = ima_activo;
    }
    
    

}
