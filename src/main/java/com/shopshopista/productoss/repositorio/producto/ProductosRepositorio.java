package com.shopshopista.productoss.repositorio.producto;

import com.shopshopista.productoss.modelo.producto.Marcas;
import com.shopshopista.productoss.modelo.producto.Productos;
import com.shopshopista.productoss.pojo.ProductoPage;
import java.util.List;
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
    
    // Basequery para productos, solo consultamos lo que mostramos en producto 
    static final String PRODUCTOPAGE_BQ = "SELECT "
            + "p.id_producto AS id_producto, "
            + "p.id_vendedor AS id_vendedor, "
            + "p.prod_nombre AS prod_nombre, "
            + "p.prod_precio_venta AS prod_precio_venta, ("
            + "SELECT COALESCE( SUM(c.calificacion), 0.1 )"
            + "FROM producto.\"Calificaciones\" c "
            + "WHERE c.id_producto = p.id_producto "
            + ") AS calificacion, ("
            + " SELECT COALESCE(ima_url, 'no image') FROM producto.\"Imagenes\" i "
            + " WHERE i.id_producto = p.id_producto AND "
            + " i.ima_principal = true "
            + ") AS ima_url "
            + "FROM producto.\"Productos\" p ";

    static final String PRODCUTOPAGE_EQ = " ORDER BY calificacion DESC LIMIT :limit OFFSET :offset ";

    @Query(value = "SELECT p FROM Productos p WHERE p.id_producto = :idProducto ")
    Productos buscarProductosById(@Param("idProducto") Long idProducto);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Productos p SET p.prod_activo = false WHERE p.id_producto = :idProducto ")
    Productos eliminarProductos(@Param("idProducto") Long idProducto);

    @Query(
            value = PRODUCTOPAGE_BQ + PRODCUTOPAGE_EQ,
            nativeQuery = true
    )
    List<ProductoPage> getForPage(
            @Param("limit") int limit, 
            @Param("offset") int offset
    );
    
    @Query(
            value = PRODUCTOPAGE_BQ 
                    + " WHERE p.id_producto IN ( "
                            + "SELECT pc.id_producto "
                            + "FROM producto.\"ProductosCategorias\" pc "
                            + "WHERE pc.id_categoria = :idCategoria )" 
                    + PRODCUTOPAGE_EQ,
            nativeQuery = true
    )
    List<ProductoPage> getForCategoria(
            @Param("idCategoria") long idCategoria,
            @Param("limit") int limit, 
            @Param("offset") int offset
    );
    
    
    @Query(
            value = PRODUCTOPAGE_BQ 
                    + " WHERE p.id_producto = :idLinea " 
                    + PRODCUTOPAGE_EQ,
            nativeQuery = true
    )
    List<ProductoPage> getForLinea(
            @Param("idLinea") long idLinea,
            @Param("limit") int limit, 
            @Param("offset") int offset
    );
    
    @Query(
            value = PRODUCTOPAGE_BQ 
                    + " WHERE p.id_producto = :idMarca" 
                    + PRODCUTOPAGE_EQ,
            nativeQuery = true
    )
    List<ProductoPage> getForMarca(
            @Param("idMarca") long idMarca,
            @Param("limit") int limit, 
            @Param("offset") int offset
    );

}
