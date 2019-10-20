package com.shopshopista.productoss.pojo.producto;

import com.shopshopista.productoss.pojo.producto.categoria.CategoriaPage;
import java.util.List;

/**
 *
 * @author gus
 */
public class ProductoDetalleRP {
    
    private final ProductoDescripcion producto;
    private final List<CategoriaPage> categorias;

    public ProductoDetalleRP(ProductoDescripcion producto, List<CategoriaPage> categorias) {
        this.producto = producto;
        this.categorias = categorias;
    }

    public ProductoDescripcion getProducto() {
        return producto;
    }

    public List<CategoriaPage> getCategorias() {
        return categorias;
    }
    /*
    private long id_producto;
    private long id_vendedor;
    private long id_marca;
    private long id_linea;
    private String prod_nombre;
    private String marc_nombre;
    private String lin_nombre;
    private String vendedor;
    private String ima_url;
    private double prod_precio_venta;
    private double calificacion;
    private List<CategoriaPage> categorias;

    public ProductoDetalleRP(ProductoDescripcion producto, List<CategoriaPage> categorias) {
        this.id_producto = producto.getId_producto();
        this.categorias = categorias;
    }

    public long getId_producto() {
        return id_producto;
    }

    public long getId_vendedor() {
        return id_vendedor;
    }

    public long getId_marca() {
        return id_marca;
    }

    public long getId_linea() {
        return id_linea;
    }

    public String getProd_nombre() {
        return prod_nombre;
    }

    public String getMarc_nombre() {
        return marc_nombre;
    }

    public String getLin_nombre() {
        return lin_nombre;
    }

    public String getVendedor() {
        return vendedor;
    }

    public String getIma_url() {
        return ima_url;
    }

    public double getProd_precio_venta() {
        return prod_precio_venta;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public List<CategoriaPage> getCategorias() {
        return categorias;
    }*/

}

/*
private final ProductoDescripcion producto;
    private final List<CategoriaPage> categorias;

    public ProductoDetalleRP(ProductoDescripcion producto, List<CategoriaPage> categorias) {
        this.producto = producto;
        this.categorias = categorias;
    }

    public ProductoDescripcion getProducto() {
        return producto;
    }

    public List<CategoriaPage> getCategorias() {
        return categorias;
    }
*/