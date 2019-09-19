package com.shopshopista.productoss.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Linis
 */
@Entity
@Table(name = "\"Productos\"")
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_producto", nullable = false)
    private Long id_producto;
    
    @Column(name = "id_vendedor ", nullable = false)
    private Long id_vendedor;

    @JsonManagedReference(value = "rf_productocategoria")
    @OneToMany(mappedBy = "id_producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductosCategorias> categoriasProducto;
    
     @JsonManagedReference(value = "rf_imagenes")
    @OneToMany(mappedBy = "id_producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Imagenes> imagenes;

    @Column(name = "prod_nombre", length = 255, nullable = false)
    private String prod_nombre;

    @JsonBackReference(value="rf_unidad")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_unidad")
    private Unidades id_unidad;

    @JsonBackReference(value="rf_marca")
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_marca")
    private Marcas id_marca;

    @JsonBackReference(value="rf_producto-linea")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_linea")
    private Lineas id_linea;
    
    @Column(name = "prod_fecha_Ingreso", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime prod_fecha_Ingreso;

    @Column(name = "prod_stock_total", nullable = false)
    private int prod_stock_total;

    @JsonManagedReference(value = "rf_productosstock")
    @OneToMany(mappedBy = "id_producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductosStock> stockProducto;

    @Column(name = "prod_marca", length = 50)
    private String prod_marca;

    @Column(name = "prod_precio_venta", nullable = false)
    private double prod_precio_venta;

    @Column(name = "prod_descripcion", nullable = false)
    private String prod_descripcion;

    @Column(name = "prod_restriccion_edad_max", nullable = false)
    private int prod_restriccion_edad_max;

    @Column(name = "prod_restriccion_edad_min", nullable = false)
    private int prod_restriccion_edad_min;

    @Column(name = "prod_activo", columnDefinition = "BOOLEAN DEFAULT  'true' ")
    private boolean prod_activo;

    public Productos() {

    }

    public Productos(Long id_producto, Long id_vendedor, List<ProductosCategorias> categoriasProducto, List<Imagenes> imagenes, String prod_nombre, Unidades id_unidad, Marcas id_marca, Lineas id_linea, LocalDateTime prod_fecha_Ingreso, int prod_stock_total, List<ProductosStock> stockProducto, String prod_marca, double prod_precio_venta, String prod_descripcion, int prod_restriccion_edad_max, int prod_restriccion_edad_min, boolean prod_activo) {
        this.id_producto = id_producto;
        this.id_vendedor = id_vendedor;
        this.categoriasProducto = categoriasProducto;
        this.imagenes = imagenes;
        this.prod_nombre = prod_nombre;
        this.id_unidad = id_unidad;
        this.id_marca = id_marca;
        this.id_linea = id_linea;
        this.prod_fecha_Ingreso = prod_fecha_Ingreso;
        this.prod_stock_total = prod_stock_total;
        this.stockProducto = stockProducto;
        this.prod_marca = prod_marca;
        this.prod_precio_venta = prod_precio_venta;
        this.prod_descripcion = prod_descripcion;
        this.prod_restriccion_edad_max = prod_restriccion_edad_max;
        this.prod_restriccion_edad_min = prod_restriccion_edad_min;
        this.prod_activo = prod_activo;
    }

    public List<Imagenes> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagenes> imagenes) {
        this.imagenes = imagenes;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getProd_nombre() {
        return prod_nombre;
    }

    public void setProd_nombre(String prod_nombre) {
        this.prod_nombre = prod_nombre;
    }

    public LocalDateTime getProd_fecha_Ingreso() {
        return prod_fecha_Ingreso;
    }

    public void setProd_fecha_Ingreso(LocalDateTime prod_fecha_Ingreso) {
        this.prod_fecha_Ingreso = prod_fecha_Ingreso;
    }

    public int getProd_stock_total() {
        return prod_stock_total;
    }

    public void setProd_stock_total(int prod_stock_total) {
        this.prod_stock_total = prod_stock_total;
    }

    public String getProd_marca() {
        return prod_marca;
    }

    public void setProd_marca(String prod_marca) {
        this.prod_marca = prod_marca;
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

    public boolean isProd_activo() {
        return prod_activo;
    }

    public void setProd_activo(boolean prod_activo) {
        this.prod_activo = prod_activo;
    }

    public Long getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(Long id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public List<ProductosCategorias> getCategoriasProducto() {
        return categoriasProducto;
    }

    public void setCategoriasProducto(List<ProductosCategorias> categoriasProducto) {
        this.categoriasProducto = categoriasProducto;
    }

    public Unidades getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(Unidades id_unidad) {
        this.id_unidad = id_unidad;
    }

    public Marcas getId_marca() {
        return id_marca;
    }

    public void setId_marca(Marcas id_marca) {
        this.id_marca = id_marca;
    }

    public Lineas getId_linea() {
        return id_linea;
    }

    public void setId_linea(Lineas id_linea) {
        this.id_linea = id_linea;
    }

    public List<ProductosStock> getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(List<ProductosStock> stockProducto) {
        this.stockProducto = stockProducto;
    }

    
    
    @Override
    public String toString() {
        return "Productos{" + "id_producto=" + id_producto + ", prod_nombre=" + prod_nombre + ", prod_fecha_Ingreso=" + prod_fecha_Ingreso + ", prod_stock_total=" + prod_stock_total + ", prod_marca=" + prod_marca + ", prod_precio_venta=" + prod_precio_venta + ", prod_descripcion=" + prod_descripcion + ", prod_restriccion_edad_max=" + prod_restriccion_edad_max + ", prod_restriccion_edad_min=" + prod_restriccion_edad_min + ", prod_activo=" + prod_activo + '}';
    }

}
