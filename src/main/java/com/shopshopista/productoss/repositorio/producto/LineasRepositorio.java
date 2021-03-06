/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.repositorio.producto;

import com.shopshopista.productoss.modelo.producto.Lineas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Linis
 */
public interface LineasRepositorio extends JpaRepository<Lineas, Long>{
    
    @Query(value = "SELECT l FROM Lineas l WHERE l.id_linea = :idLinea")
    Lineas buscarPorIdLineas(@Param("idLinea") Long idLinea);
    @Transactional
    @Modifying
    @Query(value = "UPDATE Lineas l SET l.lin_activo = false WHERE l.id_linea = :idLinea")
    void eliminarByIdLineas(@Param("idLinea") Long idLinea);
    
    
}
