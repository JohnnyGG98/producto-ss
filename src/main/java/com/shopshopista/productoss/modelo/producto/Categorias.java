package com.shopshopista.productoss.modelo.producto;

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

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Where;
import org.hibernate.Session;
/**
 *
 * @author
 */
@Where(clause = "cat_activo = true")
@Entity(
        name = "Categorias"
)
@Table(
        name = "\"Categorias\"",
        schema = "producto"
)


public class Categorias implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id_categoria;

    @JsonManagedReference(value = "rf_categoria")
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<ProductosCategorias> productos;

    @Column(name = "cat_nombre", length = 50, nullable = false)
    private String cat_nombre;

    @Column(name = "cat_codigo", length = 50, nullable = false)
    private String cat_codigo;

    @Column(name = "cat_activo", columnDefinition = "BOOLEAN DEFAULT 'true' ")
    private boolean cat_activo = true;

    public Categorias() {
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public List<ProductosCategorias> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductosCategorias> productos) {
        this.productos = productos;
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
