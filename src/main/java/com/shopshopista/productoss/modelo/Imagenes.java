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

/**
 *
 * @author Linis
 */
@Entity
@Table(
        name="\"Imagenes\"",
        schema = "producto"
)
public class Imagenes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name="id_imagen", nullable=false)
    private Long id_imagen;

    @JsonBackReference(value="rf_imagenes")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto")
    private Productos producto;
    
    @Column(name="ima_activo",columnDefinition = "BOOLEAN DEFAULT 'true'")
    private boolean ima_activo;

    public Imagenes() {
    }

    public Long getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(Long id_imagen) {
        this.id_imagen = id_imagen;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public boolean isIma_activo() {
        return ima_activo;
    }

    public void setIma_activo(boolean ima_activo) {
        this.ima_activo = ima_activo;
    }
    
}
