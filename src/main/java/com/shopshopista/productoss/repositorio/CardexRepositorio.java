/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.repositorio;

import com.shopshopista.productoss.modelo.Cardex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Linis
 */
public interface CardexRepositorio extends JpaRepository<Cardex, Long> {
    
       @Query(value = "SELECT c FROM Cardex c WHERE c.id_cardex = :idCardex")
    Cardex buscarPorIdCardex(@Param("idCardex") Long idCardex);
    
    @Query(value = "UPDATE Cardex c SET c.capr_activo = false WHERE c.id_cardex = :idCardex")
    void eliminarByIdCardex(@Param("idCardex") Long idCardex);
    
}
