package com.shopshopista.productoss.modelo;

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

/**
 *
 * @author Linis
 */
@Entity
@Table(
        name = "\"TiposTransaccion\"",
        schema = "producto"
)
public class TiposTransaccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_tipo_transaccion;

    @Column(name = "titr_nombre", nullable = false)
    private String titr_nombre;
    @Column(name = "titr_codigo", nullable = false)
    private String titr_codigo;
    @Column(name = "titr_activo", nullable = false)
    private boolean titr_activo;

    @JsonManagedReference(value = "cardex-tipo-transaccion")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tipoTransaccion")
    private List<Cardex> cardex;

    public TiposTransaccion() {
    }

    public TiposTransaccion(Long id_tipo_transaccion, String titr_nombre, String titr_codigo, boolean titr_activo, List<Cardex> cardex) {
        this.id_tipo_transaccion = id_tipo_transaccion;
        this.titr_nombre = titr_nombre;
        this.titr_codigo = titr_codigo;
        this.titr_activo = titr_activo;
        this.cardex = cardex;
    }

    public Long getId_tipo_transaccion() {
        return id_tipo_transaccion;
    }

    public void setId_tipo_transaccion(Long id_tipo_transaccion) {
        this.id_tipo_transaccion = id_tipo_transaccion;
    }

    public String getTitr_nombre() {
        return titr_nombre;
    }

    public void setTitr_nombre(String titr_nombre) {
        this.titr_nombre = titr_nombre;
    }

    public String getTitr_codigo() {
        return titr_codigo;
    }

    public void setTitr_codigo(String titr_codigo) {
        this.titr_codigo = titr_codigo;
    }

    public boolean isTitr_activo() {
        return titr_activo;
    }

    public void setTitr_activo(boolean titr_activo) {
        this.titr_activo = titr_activo;
    }

    public List<Cardex> getCardex() {
        return cardex;
    }

    public void setCardex(List<Cardex> cardex) {
        this.cardex = cardex;
    }

}
