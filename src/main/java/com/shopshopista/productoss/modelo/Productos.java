package com.shopshopista.productoss.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Linis
 */

@Entity
@Table(name="Productos")

public class Productos implements Serializable {
        
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    @Column(name="id_producto",nullable=false)
    @OneToMany(mappedBy="id_producto" ,cascade = CascadeType.ALL)
    private Long id_producto;
    
    @Column(name="id_vendedor",nullable=false)
    private Long id_vendedor;
    
    @Column(name="id_marca", nullable=false)
    private Long id_marca;
   
    @Column(name="prod_nombre", length = 255, nullable = false )
    private String prod_nombre;
    
    @Column(name="prod_fecha_Ingreso",columnDefinition = "timestamp DEFAULT now()") 
    private LocalDateTime prod_fecha_Ingreso;

    @Column(name="prod_stock_total", nullable=false )
    private int prod_stock_total;
    
    @Column(name="prod_marca", length=50)
    private String prod_marca;
    
    @Column(name="prod_precio_venta",nullable=false)
    private double prod_precio_venta;
    
    @Column(name="prod_descripcion",nullable=false)
    private String prod_descripcion;
    
    @Column(name="prod_restriccion_edad_max",nullable=false)
    private int prod_restriccion_edad_max;
    
    @Column(name="prod_restriccion_edad_min",nullable=false)
    private int prod_restriccion_edad_min;
    
    @Column(name="prod_activo", columnDefinition="BOOLEAN DEFAULT  'true' ")
    private boolean prod_activo;
 
    public Productos(){
    
    }

    public Productos(Long id_producto, Long id_vendedor, Long id_marca, String prod_nombre, LocalDateTime prod_fecha_Ingreso, int prod_stock_total, String prod_marca, double prod_precio_venta, String prod_descripcion, int prod_restriccion_edad_max, int prod_restriccion_edad_min, boolean prod_activo) {
        this.id_producto = id_producto;
        this.id_vendedor = id_vendedor;
        this.id_marca = id_marca;
        this.prod_nombre = prod_nombre;
        this.prod_fecha_Ingreso = prod_fecha_Ingreso;
        this.prod_stock_total = prod_stock_total;
        this.prod_marca = prod_marca;
        this.prod_precio_venta = prod_precio_venta;
        this.prod_descripcion = prod_descripcion;
        this.prod_restriccion_edad_max = prod_restriccion_edad_max;
        this.prod_restriccion_edad_min = prod_restriccion_edad_min;
        this.prod_activo = prod_activo;
    }

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

    public Long getId_marca() {
        return id_marca;
    }

    public void setId_marca(Long id_marca) {
        this.id_marca = id_marca;
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

    @Override
    public String toString() {
        return "Productos{" + "id_producto=" + id_producto + ", id_vendedor=" + id_vendedor + ", id_marca=" + id_marca + ", prod_nombre=" + prod_nombre + ", prod_fecha_Ingreso=" + prod_fecha_Ingreso + ", prod_stock_total=" + prod_stock_total + ", prod_marca=" + prod_marca + ", prod_precio_venta=" + prod_precio_venta + ", prod_descripcion=" + prod_descripcion + ", prod_restriccion_edad_max=" + prod_restriccion_edad_max + ", prod_restriccion_edad_min=" + prod_restriccion_edad_min + ", prod_activo=" + prod_activo + '}';
    }

  

}
