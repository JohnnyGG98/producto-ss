package com.shopshopista.productoss.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Linis
 */
@Entity
@Table(
        name = "\"Unidades\"",
        schema = "producto"
)
public class Unidades implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_unidad")
    private Long id_unidad;

    @JsonManagedReference(value = "rf_unidad")
    @OneToMany(mappedBy = "unidad", cascade = CascadeType.ALL)
    private List<Productos> productos;

    @Column(name = "unid_nombre")
    private String unid_nombre;

    @Column(name = "unid_codigo")
    private String unid_codigo;

    @Column(name = "unid_activo", columnDefinition = "BOOLEAN DEFAULT 'true'")
    private boolean unid_activo;

    public Unidades() {
    }

    public Unidades(Long id_unidad, List<Productos> unidades, String unid_nombre, String unid_codigo, boolean unid_activo) {
        this.id_unidad = id_unidad;
        this.productos = unidades;
        this.unid_nombre = unid_nombre;
        this.unid_codigo = unid_codigo;
        this.unid_activo = unid_activo;
    }

    public Long getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(Long id_unidad) {
        this.id_unidad = id_unidad;
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
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

    public boolean isUnid_activo() {
        return unid_activo;
    }

    public void setUnid_activo(boolean unid_activo) {
        this.unid_activo = unid_activo;
    }

    @Override
    public String toString() {
        return "Unidades{" + "id_unidad=" + id_unidad + ", unid_nombre=" + unid_nombre + ", unid_codigo=" + unid_codigo + '}';
    }

}
