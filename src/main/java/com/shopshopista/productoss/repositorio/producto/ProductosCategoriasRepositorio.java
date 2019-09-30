/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.repositorio.producto;

import com.shopshopista.productoss.modelo.producto.Marcas;
import com.shopshopista.productoss.modelo.producto.Productos;
import com.shopshopista.productoss.modelo.producto.ProductosCategorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Daniel
 */
@Repository
public interface ProductosCategoriasRepositorio extends JpaRepository<ProductosCategorias, Long> {

    @Query(value = "SELECT pc FROM ProductosCategorias pc WHERE pc.id_producto_categoria = :idProductosCategoria ")
    ProductosCategorias buscarProductosCategoriaById(@Param("idProductosCategoria") Long idProductosCategoria);
@Transactional
    @Modifying
    @Query(value = "UPDATE ProductosCategorias pc SET pc.prca_activo = false WHERE pc.id_producto_categoria = :idProductosCategoria ")
    ProductosCategorias eliminarProductosCategoria(@Param("idProductosCategoria") Long idProductosCategoria);

}
