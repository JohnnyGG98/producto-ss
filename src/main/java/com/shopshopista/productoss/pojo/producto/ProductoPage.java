package com.shopshopista.productoss.pojo.producto;

/**
 *
 * @author gus
 */
public interface ProductoPage {

    long getId_producto();

    long getId_vendedor();

    String getProd_nombre();

    double getProd_precio_venta();

    double getCalificacion();

    String getIma_url();
}
