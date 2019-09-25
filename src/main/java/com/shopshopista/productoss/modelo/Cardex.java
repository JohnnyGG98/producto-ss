package com.shopshopista.productoss.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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
@Where(clause = "capr_activo = true")
@Entity(
        name = "Cardex"
)
@Table(
        name = "\"Cardex\"",
        schema = "producto"
)
public class Cardex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cardex;

    @Column(name = "capr_fecha_ingreso ", nullable = false)
    private LocalDateTime capr_fecha_ingreso = ZonedDateTime.now(ZoneId.of("America/Guayaquil")).toLocalDateTime();
    @Column(name = "capr_num_producto", nullable = false)
    private int capr_num_producto;
    @Column(name = "capr_activo", nullable = false)
    private boolean capr_activo = true;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto")
    @JsonBackReference(value = "cardex-producto")
    private Productos producto;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo_transaccion ")
    @JsonBackReference(value = "cardex-tipo-transaccion")
    private TiposTransaccion tipoTransaccion;

    public Cardex() {
    }

    public Long getId_cardex() {
        return id_cardex;
    }

    public void setId_cardex(Long id_cardex) {
        this.id_cardex = id_cardex;
    }

    public LocalDateTime getCapr_fecha_ingreso() {
        return capr_fecha_ingreso;
    }

    public void setCapr_fecha_ingreso(LocalDateTime capr_fecha_ingreso) {
        this.capr_fecha_ingreso = capr_fecha_ingreso;
    }

    public int getCapr_num_producto() {
        return capr_num_producto;
    }

    public void setCapr_num_producto(int capr_num_producto) {
        this.capr_num_producto = capr_num_producto;
    }

    public boolean isCapr_activo() {
        return capr_activo;
    }

    public void setCapr_activo(boolean capr_activo) {
        this.capr_activo = capr_activo;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public TiposTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TiposTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

}
