package com.shopshopista.productoss.modelo.producto;

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
@Where(clause = "ima_activo = true")
@Entity(
        name = "Imagenes"
)
@Table(
        name="\"Imagenes\"",
        schema = "producto"
)
public class Imagenes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name="id_imagen", nullable = false)
    private Long id_imagen;
    
    @Column(name = "ima_url", nullable = false)
    private String ima_url; 
    
    
    @Column(name = "ima_principal", nullable = false, columnDefinition = "boolean DEFAULT false")
    private boolean ima_principal = false;

    @JsonBackReference(value="rf_imagenes")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto")
    private Productos producto;
    
    @Column(name="ima_activo",columnDefinition = "BOOLEAN DEFAULT 'true'")
    private boolean ima_activo = true;

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

    public String getIma_url() {
        return ima_url;
    }

    public void setIma_url(String ima_url) {
        this.ima_url = ima_url;
    }

    public boolean isIma_principal() {
        return ima_principal;
    }

    public void setIma_principal(boolean ima_principal) {
        this.ima_principal = ima_principal;
    }
    
}
