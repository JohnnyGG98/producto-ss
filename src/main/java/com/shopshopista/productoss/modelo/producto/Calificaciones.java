package com.shopshopista.productoss.modelo.producto;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import org.hibernate.annotations.Where;

@Where(clause = "cal_activo = true")
@Entity(
        name = "Calificaciones"
)
@Table(
        name = "\"Calificaciones\"",
        schema = "producto"
)
public class Calificaciones implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calificacion")
    private Long id_calificacion;

    @JsonBackReference
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", foreignKey = @ForeignKey(name = "calificacion_producto_fk"))
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Productos producto;

    @Column(name = "id_cliente")
    private Long id_cliente;

    @Column(name = "calificacion", columnDefinition = "NUMERIC(4, 2)")
    private Double calificacion;

    @Column(name = "cal_activo", columnDefinition = "BOOLEAN DEFAULT 'true'")
    private Boolean cal_activo = true;

    public Calificaciones() {
    }

    public Long getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(Long id_calificacion) {
        this.id_calificacion = id_calificacion;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public Boolean getCal_activo() {
        return cal_activo;
    }

    public void setCal_activo(Boolean cal_activo) {
        this.cal_activo = cal_activo;
    }

}
