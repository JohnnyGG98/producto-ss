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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Linis
 */
@Entity
@Table(
        name="\"Marcas\"",
        schema = "producto"
)
public class Marcas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_marca")
    private Long id_marca;

    @JsonManagedReference(value="rf_marca")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marca")
    private List<Productos> productos;

    @Column(name = "marc_nombre")
    private String marc_nombre;

    @Column(name = "marc_codigo")
    private String marc_codigo;

    @Column(name = "marc_activo", columnDefinition = "BOOLEAN DEFAULT 'true'")
    private boolean marc_activo;

    public Marcas() {
    }

    public Marcas(Long id_marca, List<Productos> productos, String marc_nombre, String marc_codigo, boolean marc_activo) {
        this.id_marca = id_marca;
        this.productos = productos;
        this.marc_nombre = marc_nombre;
        this.marc_codigo = marc_codigo;
        this.marc_activo = marc_activo;
    }

    public Long getId_marca() {
        return id_marca;
    }

    public void setId_marca(Long id_marca) {
        this.id_marca = id_marca;
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
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
