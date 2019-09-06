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
public class Unidades {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_unidad;
    
    private String unid_nombre;
    private String unid_codigo;

    public Long getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(Long id_unidad) {
        this.id_unidad = id_unidad;
    }

    public String getUnid_nombre() {
        return unid_nombre;
    }

    public void setUnid_nombre(String unid_nombre) {
        this.unid_nombre = unid_nombre;
    }

    public String getUnid_codigo() {
        return unid_codigo;
    }

    public void setUnid_codigo(String unid_codigo) {
        this.unid_codigo = unid_codigo;
    }
    
    
    
    
}
