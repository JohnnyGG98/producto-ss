package com.shopshopista.productoss.modelo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Linis
 */
@Entity
@Table(
        name="\"Unidades\"",
        schema = "producto"
)
public class Unidades {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_unidad")
    private Long id_unidad;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Productos> unidades;
    
    @Column(name="unid_nombre")
    private String unid_nombre;
    
    @Column(name="unid_codigo")
    private String unid_codigo;

    @Column(name="unid_activo",columnDefinition = "BOOLEAN DEFAULT 'true'" )
    private boolean unid_activo;
    
    public Unidades(){}

    public Unidades(Long id_unidad, List<Productos> unidades, String unid_nombre, String unid_codigo, boolean unid_activo) {
        this.id_unidad = id_unidad;
        this.unidades = unidades;
        this.unid_nombre = unid_nombre;
        this.unid_codigo = unid_codigo;
        this.unid_activo = unid_activo;
    }

    public List<Productos> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Productos> unidades) {
        this.unidades = unidades;
    }

    public boolean isUnid_activo() {
        return unid_activo;
    }

    public void setUnid_activo(boolean unid_activo) {
        this.unid_activo = unid_activo;
    }

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

    @Override
    public String toString() {
        return "Unidades{" + "id_unidad=" + id_unidad + ", unid_nombre=" + unid_nombre + ", unid_codigo=" + unid_codigo + '}';
    }

   
    
}
