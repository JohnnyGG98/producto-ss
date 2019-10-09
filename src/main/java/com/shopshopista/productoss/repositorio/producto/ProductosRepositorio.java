package com.shopshopista.productoss.repositorio.producto;

import com.fasterxml.jackson.databind.JsonNode;
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

    @Query(
            value = PRODUCTOPAGE_BQ
            + " WHERE p.prod_nombre ILIKE  %:aguja% OR "
            + " p.prod_descripcion ILIKE %:aguja% OR "
            + " p.id_producto IN ( "
            + "  SELECT id_producto  "
            + "  FROM producto.\"ProductosCategorias\" pc "
            + "  WHERE pc.id_categoria IN ( "
            + "   SELECT id_categoria "
            + "   FROM producto.\"Categorias\" c "
            + "   WHERE c.cat_nombre ILIKE %:aguja% )"
            + " ) OR p.id_producto IN ( "
            + "  SELECT id_producto "
            + "  FROM producto.\"Lineas\" l "
            + "  WHERE l.lin_nombre LIKE %:aguja% "
            + " ) OR p.id_producto IN ("
            + "  SELECT id_producto "
            + "  FROM producto.\"Marcas\" m "
            + "  WHERE m.marc_nombre ILIKE %:aguja% "
            + ") "
            + PRODCUTOPAGE_EQ,
            nativeQuery = true
    )
    List<ProductoPage> getForBusqueda(
            @Param("aguja") String aguja,
            @Param("limit") int limit,
            @Param("offset") int offset
    );

    @Query(
            value = PRODUCTOPAGE_BQ
            + " WHERE p.id_producto IN ( "
            + "  SELECT pc.id_producto "
            + "  FROM producto.\"Productos\" pc "
            + "  LEFT JOIN producto.\"Comentarios\" c ON pc.id_producto = c.id_producto "
            + "  GROUP BY pc.id_producto "
            + "  ORDER BY count(pc.id_producto) DESC "
            + " ) "
            + PRODCUTOPAGE_EQ,
            nativeQuery = true
    )
    List<ProductoPage> getForSlide(
            @Param("limit") int limit,
            @Param("offset") int offset
    );

    @Query(
            value = "SELECT array_to_json(\n"
            + "  array_agg(p.*)\n"
            + ") AS productos FROM (\n"
            + "  SELECT\n"
            + "  p.id_producto,\n"
            + "  p.id_vendedor,\n"
            + "  p.prod_nombre,\n"
            + "  p.prod_precio_venta, (\n"
            + "    SELECT array_to_json(\n"
            + "      array_agg(i.*)\n"
            + "    ) AS imagenes FROM (\n"
            + "      SELECT *\n"
            + "      FROM producto.\"Imagenes\" i\n"
            + "      WHERE i.id_producto = p.id_producto\n"
            + "    ) AS i\n"
            + "  )\n"
            + "  FROM producto.\"Productos\" p\n"
            + ") AS p;",
            nativeQuery = true
    )
    JsonNode getJSON();

}
