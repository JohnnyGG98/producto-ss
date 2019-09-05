/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.repositorio;

import com.shopshopista.productoss.modelo.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alumno
 */
public interface ProductosRepositorio extends JpaRepository<Productos, Long>{
    
}
