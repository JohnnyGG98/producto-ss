package com.shopshopista.productoss.repositorio;

import com.shopshopista.productoss.modelo.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alumno
 */
@Repository
public interface ProductosRepositorio extends JpaRepository<Productos, Long>{
    
}
