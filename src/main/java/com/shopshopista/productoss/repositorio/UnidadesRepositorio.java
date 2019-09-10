/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.repositorio;

import com.shopshopista.productoss.modelo.Imagenes;
import com.shopshopista.productoss.modelo.Unidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Linis
 */
public interface UnidadesRepositorio extends JpaRepository<Unidades, Long> {

    @Query(value = "SELECT u FROM Unidades u WHERE u.id_unidad = :idUnidades ")
    Unidades buscarUnidadesById(@Param("idUnidades") Long idUnidades);

    @Query(value = "UPDATE Unidades SET u.unid_activo = false WHERE u.id_unidad = :idUnidades ")
    Unidades eliminarUnidades(@Param("idUnidades") Long idUnidades);
}
