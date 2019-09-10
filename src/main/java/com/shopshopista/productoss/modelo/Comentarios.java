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
@Table(name = "Comentarios")
public class Comentarios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id_comentario", nullable = false)
    private Long id_comentario;

    @Column(name = "comentario", nullable = false)
    private String comentario;

    @Column(name = "com_activo", columnDefinition = "BOOLEAN DEFAULT 'true'")
    private boolean com_activo;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto")
    private Productos id_producto;

    public Comentarios() {
    }

    public Comentarios(Long id_comentario, String comentario, boolean com_activo) {
        this.id_comentario = id_comentario;
        this.comentario = comentario;
        this.com_activo = com_activo;
    }

    public Long getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(Long id_comentario) {
        this.id_comentario = id_comentario;
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

    public Productos getId_producto() {
        return id_producto;
    }

    public void setId_producto(Productos id_producto) {
        this.id_producto = id_producto;
    }

    
    @Override
    public String toString() {
        return "Comentarios{" + "id_comentario=" + id_comentario + ", id_producto=" + id_producto + ", comentario=" + comentario + ", com_activo=" + com_activo + '}';
    }

}
