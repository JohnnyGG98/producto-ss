package com.shopshopista.productoss.pojo.producto;

/**
 *
 * @author Johnny
 */
public interface ProductoDescripcion {
    
    long getId_producto();

    long getId_vendedor();
    
    long getId_marca();
    
    long getId_linea();

    double getProd_precio_venta();

    double getCalificacion();
    
    String getProd_nombre();
    
    String getIma_url();
    
    String getVendedor();
    
    String getMarc_nombre();
    
    String getLin_nombre();
}
