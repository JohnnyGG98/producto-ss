package com.shopshopista.productoss.modelo.transaccion;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.shopshopista.productoss.modelo.producto.Productos;
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
        name = "Kardex"
)
@Table(
        name = "\"Kardex\"",
        schema = "producto"
)
public class Kardex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_kardex;

    @Column(name = "capr_fecha_ingreso ", nullable = false)
    private LocalDateTime capr_fecha_ingreso = ZonedDateTime.now(ZoneId.of("America/Guayaquil")).toLocalDateTime();
    @Column(name = "capr_num_producto", nullable = false)
    private int capr_num_producto;
    @Column(name = "capr_activo", nullable = false)
    private boolean capr_activo = true;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto")
    @JsonBackReference(value = "kardex-producto")
    private Productos producto;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo_transaccion ")
    @JsonBackReference(value = "kardex-tipo-transaccion")
    private TiposTransaccion tipoTransaccion;

    public Kardex() {
    }

    public Long getId_kardex() {
        return id_kardex;
    }

    public void setId_kardex(Long id_kardex) {
        this.id_kardex = id_kardex;
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
