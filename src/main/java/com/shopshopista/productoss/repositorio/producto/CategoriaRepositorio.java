/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    List<CategoriaPage> getForPage();

}
