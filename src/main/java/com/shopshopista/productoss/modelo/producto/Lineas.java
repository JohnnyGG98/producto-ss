package com.shopshopista.productoss.modelo.producto;

import com.shopshopista.productoss.modelo.producto.Productos;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Where;

/**
 *
 * @author Linis
 */
@Where(clause = "lin_activo = true")
@Entity(
        name = "Lineas"
)
@Table(
        name = "\"Lineas\"",
        schema = "producto"
)
public class Lineas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_linea;

    @Column(name = "lin_nombre ", nullable = false)
    private String lin_nombre;
    @Column(name = "lin_codigo", nullable = false)
    private String lin_codigo;
    @Column(name = "lin_activo", nullable = false)
    private boolean lin_activo = true;

    @JsonManagedReference(value = "rf_producto-linea")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "linea")
    private List<Productos> productos;

    public Lineas() {
    }

    public Lineas(Long id_linea, String lin_nombre, String lin_codigo, boolean lin_activo, List<Productos> productos) {
        this.id_linea = id_linea;
        this.lin_nombre = lin_nombre;
        this.lin_codigo = lin_codigo;
        this.lin_activo = lin_activo;
        this.productos = productos;
    }

    public Long getId_linea() {
        return id_linea;
    }

    public void setId_linea(Long id_linea) {
        this.id_linea = id_linea;
    }

    public String getLin_nombre() {
        return lin_nombre;
    }

    public void setLin_nombre(String lin_nombre) {
        this.lin_nombre = lin_nombre;
    }

    public String getLin_codigo() {
        return lin_codigo;
    }

    public void setLin_codigo(String lin_codigo) {
        this.lin_codigo = lin_codigo;
    }

    public boolean isLin_activo() {
        return lin_activo;
    }

    public void setLin_activo(boolean lin_activo) {
        this.lin_activo = lin_activo;
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }

}
