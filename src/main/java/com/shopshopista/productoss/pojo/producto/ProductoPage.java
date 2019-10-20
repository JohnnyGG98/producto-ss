package com.shopshopista.productoss.pojo.producto;

/**
 *
 * @author gus
 */
public interface ProductoPage {

    public int getId_producto();

    public int getId_vendedor();
    
    public String getProd_nombre();

    public double getProd_precio_venta();

    public double getCalificacion();
    
    String getIma_url();
}
