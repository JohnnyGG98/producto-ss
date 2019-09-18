package com.shopshopista.productoss.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author
 */
@Entity
@Table(name = "Categorias")
public class Categorias implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_categoria", nullable = false)
    private Long id_categoria;
    
    @JsonManagedReference(value = "rf_categoria")
    @OneToMany(mappedBy = "id_categoria", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ProductosCategorias> productosCategoria;
    
    @Column(name = "cat_nombre", length = 50, nullable = false)
    private String cat_nombre;

    @Column(name = "cat_codigo", length = 50, nullable = false)
    private String cat_codigo;

    @Column(name = "cat_activo", columnDefinition = "BOOLEAN DEFAULT 'true' ")
    private boolean cat_activo;

    public Categorias() {
    }

    public Categorias(Long id_categoria, List<ProductosCategorias> productosCategoria, String cat_nombre, String cat_codigo, boolean cat_activo) {
        this.id_categoria = id_categoria;
        this.productosCategoria = productosCategoria;
        this.cat_nombre = cat_nombre;
        this.cat_codigo = cat_codigo;
        this.cat_activo = cat_activo;
    }

    public void setProductosCategoria(List<ProductosCategorias> productosCategoria) {
        this.productosCategoria = productosCategoria;
    }

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

    @Override
    public String toString() {
        return "Categorias{" + "id_categoria=" + id_categoria + ", cat_nombre=" + cat_nombre + ", cat_codigo=" + cat_codigo + ", cat_activo=" + cat_activo + '}';
    }

}
