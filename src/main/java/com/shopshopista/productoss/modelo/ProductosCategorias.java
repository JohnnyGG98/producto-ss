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
public class ProductosCategorias {
    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_producto_categoria;
    
    private Productos id_produto;
    private Categorias id_categoria;
    private boolean prca_activo;

    public Long getId_producto_categoria() {
        return id_producto_categoria;
    }

    public void setId_producto_categoria(Long id_producto_categoria) {
        this.id_producto_categoria = id_producto_categoria;
    }

    public Productos getId_produto() {
        return id_produto;
    }

    public void setId_produto(Productos id_produto) {
        this.id_produto = id_produto;
    }

    public Categorias getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Categorias id_categoria) {
        this.id_categoria = id_categoria;
    }

    public boolean isPrca_activo() {
        return prca_activo;
    }

    public void setPrca_activo(boolean prca_activo) {
        this.prca_activo = prca_activo;
    }
    
    
    
}
