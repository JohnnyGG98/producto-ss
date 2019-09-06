/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Linis
 */
public class Imagenes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_imagen;

    private Productos id_producto;
    private boolean ima_activo;

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
