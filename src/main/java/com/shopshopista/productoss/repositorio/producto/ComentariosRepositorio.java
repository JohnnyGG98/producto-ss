/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.repositorio.producto;

import com.shopshopista.productoss.modelo.producto.Comentarios;
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
public interface ComentariosRepositorio extends JpaRepository<Comentarios, Long> {

    @Query(value = "SELECT c FROM Comentarios c WHERE c.id_comentario = :idComentario ")
    Comentarios buscarComentarioById(@Param("idComentario") Long idComentario);
 @Transactional
    @Modifying
    @Query(value = "UPDATE Comentarios c SET c.com_activo = false WHERE c.id_comentario = :idComentario ")
    Comentarios eliminarComentarios(@Param("idComentario") Long idComentario);

}
