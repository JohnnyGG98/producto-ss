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
    
    
    private String comentario;
    private boolean com_activo;
}
