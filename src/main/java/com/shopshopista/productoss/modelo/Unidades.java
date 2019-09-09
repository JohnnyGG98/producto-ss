package com.shopshopista.productoss.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Linis
 */
@Entity
@Table(name="Unidades")
public class Unidades {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name="id_unidad")
    private Long id_unidad;
    
    @Column(name="unid_nombre")
    private String unid_nombre;
    
    @Column(name="unid_codigo",columnDefinition = "BOOLEAN DEFAULT 'true'")
    private String unid_codigo;

    public Unidades(){}
    
    public Unidades(Long id_unidad, String unid_nombre, String unid_codigo) {
        this.id_unidad = id_unidad;
        this.unid_nombre = unid_nombre;
        this.unid_codigo = unid_codigo;
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
