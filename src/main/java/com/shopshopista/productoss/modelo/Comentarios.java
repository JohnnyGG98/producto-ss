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
@Table(name="Comentarios")
public class Comentarios {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    @Column(name="id_comentario", nullable=false)
    private Long id_comentario;
    
    @Column(name="id_producto",nullable=false)
    private Long id_producto;
    
    @Column(name="comentario", nullable=false)
    private String comentario;
   
    @Column (name="com_activo", columnDefinition="BOOLEAN DEFAULT 'true'")
    private boolean com_activo;

    public Comentarios() {
    }

    public Comentarios(Long id_comentario, Long id_producto, String comentario, boolean com_activo) {
        this.id_comentario = id_comentario;
        this.id_producto = id_producto;
        this.comentario = comentario;
        this.com_activo = com_activo;
    }
    
    public Long getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(Long id_comentario) {
        this.id_comentario = id_comentario;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
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

    @Override
    public String toString() {
        return "Comentarios{" + "id_comentario=" + id_comentario + ", id_producto=" + id_producto + ", comentario=" + comentario + ", com_activo=" + com_activo + '}';
    }

    
    
    
}
