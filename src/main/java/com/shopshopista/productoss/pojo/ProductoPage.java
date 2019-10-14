package com.shopshopista.productoss.pojo;

/**
 *
 * @author gus
 */
public interface ProductoPage {
    
    /*private int id_producto; 
    private int id_vendedor; 
    private String prod_nombre; 
    private double prod_precio_venta; 
    
    private List<Imagenes> imagenes;*/

    public int getId_producto();

    public int getId_vendedor();
    
    public String getProd_nombre();

    public double getProd_precio_venta();

    public double getCalificacion();
    
    String getIma_url();
}
