/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.repositorio;

import com.shopshopista.productoss.modelo.ProductosStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Linis
 */
@Repository
public interface ProductosStockRepositorio extends JpaRepository<ProductosStock, Long> {

    @Query(value = "SELECT ps FROM ProductosStock ps WHERE ps.id_producto_stock = :idProductosStock ")
    ProductosStock buscarProductosStockById(@Param("idProductosStock") Long idProductosStock);

    @Query(value = "UPDATE ProductosStock ps SET ps.prst_activo = false WHERE ps.id_producto_stock = :idProductosStock ")
    ProductosStock eliminarProductosStock(@Param("idProductosStock") Long idProductosStock);

}
