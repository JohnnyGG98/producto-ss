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
public class Comentarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_comentario;
    
    private Productos id_producto;
    private String comentario;
    private boolean com_activo;

    public Long getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(Long id_comentario) {
        this.id_comentario = id_comentario;
    }

    public Productos getId_producto() {
        return id_producto;
    }

    public void setId_producto(Productos id_producto) {
        this.id_producto = id_producto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public boolean isCom_activo() {
        return com_activo;
    }

    public void setCom_activo(boolean com_activo) {
        this.com_activo = com_activo;
    }
    
    
    
}
