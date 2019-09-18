/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.repositorio;

import com.shopshopista.productoss.modelo.TiposTransaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Linis
 */
public interface TipoTransaccionRepositorio extends JpaRepository<TiposTransaccion, Long>{
        
    @Query(value = "SELECT tt FROM TiposTransaccion tt WHERE tt.id_tipo_transaccion = :idTipoTransaccion")
    TiposTransaccion buscarPorIdTipoTransaccion(@Param("idTipoTransaccion") Long idTipoTransaccion);
    
    @Query(value = "UPDATE TiposTransaccion tt SET tt.titr_activo  = false WHERE tt.id_tipo_transaccion = :idTipoTransaccion")
    void eliminarByIdTipoTransaccion(@Param("idTipoTransaccion") Long idTipoTransaccion);
}
