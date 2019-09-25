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
@Where(clause = "com_activo = true")
@Entity(
        name = "Comentarios"
)
@Table(
        name = "\"Comentarios\"",
        schema = "producto"
)
public class Comentarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_comentario", nullable = false)
    private Long id_comentario;

    @Column(name = "id_cliente", nullable = false)
    private Long id_cliente;

    @Column(name = "comentario", nullable = false)
    private String comentario;

    @Column(name = "com_activo", columnDefinition = "BOOLEAN DEFAULT 'true'")
    private boolean com_activo = true;

    // Referencias  
    @JsonBackReference(value = "rf_comentario")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto")
    private Productos producto;

    public Comentarios() {
    }

    public Long getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(Long id_comentario) {
        this.id_comentario = id_comentario;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public boolean isCom_activo() {
        return com_activo;
    }

    public void setCom_activo(boolean com_activo) {
        this.com_activo = com_activo;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Comentarios{" + "id_comentario=" + id_comentario + ", id_cliente=" + id_cliente + ", comentario=" + comentario + ", com_activo=" + com_activo + ", producto=" + producto + '}';
    }

}
