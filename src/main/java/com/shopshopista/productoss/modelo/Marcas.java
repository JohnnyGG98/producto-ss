/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Linis
 */
public class Marcas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id_marca")
    private Long id_marca;

    @JsonManagedReference(value="rf_marcas")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Productos> marcas;

    @Column(name = "marc_nombre")
    private String marc_nombre;

    @Column(name = "marc_codigo")
    private String marc_codigo;

    @Column(name = "marc_activo", columnDefinition = "BOOLEAN DEFAULT 'true'")
    private boolean marc_activo;

    public Long getId_marca() {
        return id_marca;
    }

    public void setId_marca(Long id_marca) {
        this.id_marca = id_marca;
    }

    public String getMarc_nombre() {
        return marc_nombre;
    }

    public void setMarc_nombre(String marc_nombre) {
        this.marc_nombre = marc_nombre;
    }

    public String getMarc_codigo() {
        return marc_codigo;
    }

    public void setMarc_codigo(String marc_codigo) {
        this.marc_codigo = marc_codigo;
    }

    public boolean isMarc_activo() {
        return marc_activo;
    }

    public void setMarc_activo(boolean marc_activo) {
        this.marc_activo = marc_activo;
    }

}
