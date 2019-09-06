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
public class Categorias {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_categoria;
    
    private String cat_nombre;
    private String cat_codigo;
    private boolean cat_activo;

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCat_nombre() {
        return cat_nombre;
    }

    public void setCat_nombre(String cat_nombre) {
        this.cat_nombre = cat_nombre;
    }

    public String getCat_codigo() {
        return cat_codigo;
    }

    public void setCat_codigo(String cat_codigo) {
        this.cat_codigo = cat_codigo;
    }

    public boolean isCat_activo() {
        return cat_activo;
    }

    public void setCat_activo(boolean cat_activo) {
        this.cat_activo = cat_activo;
    }
    
    
    
    
}
