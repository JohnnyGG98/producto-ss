package com.shopshopista.productoss.repositorio.producto;

import com.shopshopista.productoss.modelo.producto.Categorias;
import com.shopshopista.productoss.pojo.producto.categoria.CategoriaPage;
import java.util.List;
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
public interface CategoriaRepositorio extends JpaRepository<Categorias, Long> {

    @Query(value = "SELECT c FROM Categorias c WHERE c.id_categoria = :idCategoria ")
    Categorias buscarCategoriaById(@Param("idCategoria") Long idCategoria);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Categorias c SET c.cat_activo = false WHERE c.id_categoria = :idCategoria ")
    Categorias eliminarCategoria(@Param("idCategoria") Long idCategoria);

    @Query(value = "SELECT "
            + "c.id_categoria AS id_categoria, "
            + "c.cat_nombre AS cat_nombre "
            + "FROM Categorias c ")
    List<CategoriaPage> getForHome();

    @Query(value = "SELECT "
            + "c.id_categoria AS id_categoria, "
            + "c.cat_nombre AS cat_nombre "
            + "FROM producto.\"Categorias\" c "
            + "WHERE c.id_categoria NOT IN ( "
            + " SELECT id_categoria "
            + " FROM human.\"Preferencias\" p "
            + " WHERE p.id_cliente = :idCliente  "
            + ")",
            nativeQuery = true)
    List<CategoriaPage> getForPage(@Param("idCliente") Long idCliente);

    @Query(value = "SELECT "
            + "c.id_categoria AS id_categoria, "
            + "c.cat_nombre AS cat_nombre "
            + "FROM producto.\"Categorias\" c "
            + "WHERE c.id_categoria IN ( "
            + " SELECT id_categoria "
            + " FROM human.\"Preferencias\" p "
            + " WHERE p.id_cliente = :idCliente  "
            + ")",
            nativeQuery = true)
    List<CategoriaPage> getForCliente(@Param("idCliente") Long idCliente);

}
