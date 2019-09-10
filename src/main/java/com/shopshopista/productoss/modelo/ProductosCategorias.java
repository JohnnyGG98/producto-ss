package com.shopshopista.productoss.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
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
@Table(name = "ProductosCategorias")
public class ProductosCategorias implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_producto_categoria", nullable = false)
    private Long id_producto_categoria;

    @JsonBackReference
    @JoinColumn(name = "id_categoria", foreignKey = @ForeignKey(name = "fk_producto_categoria", foreignKeyDefinition = "FOREIGN KEY (id_categoria) REFERENCES \"Categorias\" ON UPDATE CASCADE ON DELETE CASCADE"))
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Categorias id_categoria;

    @JsonBackReference
    @JoinColumn(name = "id_producto")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Productos id_producto;

    @Column(name = "prca_activo", columnDefinition = "BOOLEAN DEFAULT 'true'")
    private boolean prca_activo;

    public ProductosCategorias() {
    }

    public ProductosCategorias(Long id_producto_categoria, Categorias id_categoria, Productos id_producto, boolean prca_activo) {
        this.id_producto_categoria = id_producto_categoria;
        this.id_categoria = id_categoria;
        this.id_producto = id_producto;
        this.prca_activo = prca_activo;
    }

    public Long getId_producto_categoria() {
        return id_producto_categoria;
    }

    public void setId_producto_categoria(Long id_producto_categoria) {
        this.id_producto_categoria = id_producto_categoria;
    }

    public boolean isPrca_activo() {
        return prca_activo;
    }

    public void setPrca_activo(boolean prca_activo) {
        this.prca_activo = prca_activo;
    }

    public Categorias getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Categorias id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Productos getId_producto() {
        return id_producto;
    }

    public void setId_producto(Productos id_producto) {
        this.id_producto = id_producto;
    }

}
