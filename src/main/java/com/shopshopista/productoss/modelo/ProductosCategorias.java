/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.modelo;

import java.io.Serializable;
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
@Table(name="ProductosCategorias")
public class ProductosCategorias  {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    @Column(name="id_producto_categoria", nullable=false)
    private Long id_producto_categoria;
    
    @Column(name="id_producto")
    private Long id_producto;
    
    @Column(name="id_categoria")
    private Long id_categoria;
    
    @Column(name="prca_activo", columnDefinition = "BOOLEAN DEFAUTL 'true'")
    private boolean prca_activo;
    
}
