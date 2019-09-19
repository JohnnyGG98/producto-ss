/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.repositorio;

import com.shopshopista.productoss.modelo.Imagenes;
import com.shopshopista.productoss.modelo.Marcas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Linis
 */
@Repository
public interface ImagenesRepositorio extends JpaRepository<Imagenes, Long> {

    @Query(value = "SELECT i FROM Imagenes i WHERE i.id_imagen = :idImagen ")
    Imagenes buscarImagenesById(@Param("idImagen") Long idImagen);
    @Transactional
    @Modifying

    @Query(value = "UPDATE Imagenes i SET i.ima_activo = false WHERE i.id_imagen = :idImagen ")
    Imagenes eliminarImagenes(@Param("idImagen") Long idImagen);

}
