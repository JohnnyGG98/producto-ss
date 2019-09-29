package com.shopshopista.productoss.modelo.producto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Where;

/**
 *
 * @author Linis
 */
@Where(clause = "prod_activo = true")
@Entity(
        name = "Productos"
)
@Table(
        name = "\"Productos\"",
        schema = "producto"
)
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", nullable = false)
    private Long id_producto;

    @Column(name = "id_vendedor ", nullable = false)
    private Long id_vendedor;

    @JsonManagedReference(value = "rf_productocategoria")
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<ProductosCategorias> categorias;

    @JsonManagedReference(value = "rf_imagenes")
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Imagenes> imagenes;

    @JsonManagedReference(value = "rf_comentario")
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Comentarios> comentarios;

    @Column(name = "prod_nombre", length = 255, nullable = false)
    private String prod_nombre;

    @JsonBackReference(value = "rf_unidad")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidad")
    private Unidades unidad;

    @JsonBackReference(value = "rf_marca")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca")
    private Marcas marca;

    @JsonBackReference(value = "rf_producto-linea")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_linea")
    private Lineas linea;

    @Column(name = "prod_fecha_Ingreso", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime prod_fecha_Ingreso = ZonedDateTime.now(ZoneId.of("America/Guayaquil")).toLocalDateTime();;

    @Column(name = "prod_stock_max", nullable = false)
    private int prod_stock_max;

    @Column(name = "prod_stock_min", nullable = false)
    private int prod_stock_min;

    @Column(name = "prod_stock_total", nullable = false)
    private int prod_stock_total;

    @Column(name = "prod_precio_venta", nullable = false)
    private double prod_precio_venta;

    @Column(name = "prod_descripcion", nullable = false)
    private String prod_descripcion;

    @Column(name = "prod_restriccion_edad_max", nullable = false)
    private int prod_restriccion_edad_max;

    @Column(name = "prod_restriccion_edad_min", nullable = false)
    private int prod_restriccion_edad_min;

    @Column(name = "prod_tiene_iva", columnDefinition = "BOOLEAN DEFAULT  'true' ")
    private boolean prod_tiene_iva = true;

    @Column(name = "prod_activo", columnDefinition = "BOOLEAN DEFAULT  'true' ")
    private boolean prod_activo = true;

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public Long getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(Long id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public List<ProductosCategorias> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<ProductosCategorias> categorias) {
        this.categorias = categorias;
    }

    public List<Imagenes> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagenes> imagenes) {
        this.imagenes = imagenes;
    }

    public String getProd_nombre() {
        return prod_nombre;
    }

    public void setProd_nombre(String prod_nombre) {
        this.prod_nombre = prod_nombre;
    }

    public Unidades getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidades unidad) {
        this.unidad = unidad;
    }

    public Marcas getMarca() {
        return marca;
    }

    public void setMarca(Marcas marca) {
        this.marca = marca;
    }

    public Lineas getLinea() {
        return linea;
    }

    public void setLinea(Lineas linea) {
        this.linea = linea;
    }

    public LocalDateTime getProd_fecha_Ingreso() {
        return prod_fecha_Ingreso;
    }

    public void setProd_fecha_Ingreso(LocalDateTime prod_fecha_Ingreso) {
        this.prod_fecha_Ingreso = prod_fecha_Ingreso;
    }

    public int getProd_stock_max() {
        return prod_stock_max;
    }

    public void setProd_stock_max(int prod_stock_max) {
        this.prod_stock_max = prod_stock_max;
    }

    public int getProd_stock_min() {
        return prod_stock_min;
    }

    public void setProd_stock_min(int prod_stock_min) {
        this.prod_stock_min = prod_stock_min;
    }

    public int getProd_stock_total() {
        return prod_stock_total;
    }

    public void setProd_stock_total(int prod_stock_total) {
        this.prod_stock_total = prod_stock_total;
    }

    public double getProd_precio_venta() {
        return prod_precio_venta;
    }

    public void setProd_precio_venta(double prod_precio_venta) {
        this.prod_precio_venta = prod_precio_venta;
    }

    public String getProd_descripcion() {
        return prod_descripcion;
    }

    public void setProd_descripcion(String prod_descripcion) {
        this.prod_descripcion = prod_descripcion;
    }

    public int getProd_restriccion_edad_max() {
        return prod_restriccion_edad_max;
    }

    public void setProd_restriccion_edad_max(int prod_restriccion_edad_max) {
        this.prod_restriccion_edad_max = prod_restriccion_edad_max;
    }

    public int getProd_restriccion_edad_min() {
        return prod_restriccion_edad_min;
    }

    public void setProd_restriccion_edad_min(int prod_restriccion_edad_min) {
        this.prod_restriccion_edad_min = prod_restriccion_edad_min;
    }

    public boolean isProd_tiene_iva() {
        return prod_tiene_iva;
    }

    public void setProd_tiene_iva(boolean prod_tiene_iva) {
        this.prod_tiene_iva = prod_tiene_iva;
    }

    public boolean isProd_activo() {
        return prod_activo;
    }

    public void setProd_activo(boolean prod_activo) {
        this.prod_activo = prod_activo;
    }

    public List<Comentarios> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentarios> comentarios) {
        this.comentarios = comentarios;
    }

}
