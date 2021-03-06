/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.repositorio.producto;

import com.shopshopista.productoss.modelo.producto.Marcas;
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
public interface MarcaRepositorio extends JpaRepository<Marcas, Long> {

    @Query(value = "SELECT m FROM Marcas m WHERE m.id_marca = :idMarca")
    Marcas buscarMarcasById(@Param("idMarca") Long idMarca);
   
    
     @Transactional
    @Modifying
    @Query(value = "UPDATE Marcas m SET m.marc_activo = false WHERE m.id_marca = :idMarca")
    Marcas eliminarMarcas(@Param("idMarca") Long idMarca);

}
