package com.shopshopista.productoss.repositorio;

import com.shopshopista.productoss.modelo.Marcas;
import com.shopshopista.productoss.modelo.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alumno
 */
@Repository
public interface ProductosRepositorio extends JpaRepository<Productos, Long> {

    @Query(value = "SELECT p FROM Productos p WHERE p.id_producto = :idProducto ")
    Productos buscarProductosById(@Param("idProducto") Long idProducto);
 @Transactional
    @Modifying
    @Query(value = "UPDATE Productos p SET p.prod_activo = false WHERE p.id_producto = :idProducto ")
    Productos eliminarProductos(@Param("idProducto") Long idProducto);

}
