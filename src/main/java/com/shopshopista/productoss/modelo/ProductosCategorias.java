package com.shopshopista.productoss.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
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
import org.hibernate.annotations.Where;

/**
 *
 * @author Linis
 */
@Where(clause = "prca_activo = true")
@Entity(
        name = "ProductosCategorias"
)
@Table(
        name = "\"ProductosCategorias\"",
        schema = "producto"
)
public class ProductosCategorias implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto_categoria", nullable = false)
    private Long id_producto_categoria;
    
    @JoinColumn(name = "id_producto")
    @JsonBackReference(value="rf_productocategoria")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Productos producto;

    @JoinColumn(name = "id_categoria")
    @JsonBackReference(value="rf_categoria")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Categorias categoria;

    @Column(name = "prca_activo", columnDefinition = "BOOLEAN DEFAULT 'true'")
    private boolean prca_activo = true;

    public ProductosCategorias() {
    }

    public Long getId_producto_categoria() {
        return id_producto_categoria;
    }

    public void setId_producto_categoria(Long id_producto_categoria) {
        this.id_producto_categoria = id_producto_categoria;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public boolean isPrca_activo() {
        return prca_activo;
    }

    public void setPrca_activo(boolean prca_activo) {
        this.prca_activo = prca_activo;
    }

    @Override
    public String toString() {
        return "ProductosCategorias{" + "id_producto_categoria=" + id_producto_categoria + ", producto=" + producto + ", categoria=" + categoria + ", prca_activo=" + prca_activo + '}';
    }

}
