package com.shopshopista.productoss.repositorio.producto;

import com.shopshopista.productoss.modelo.producto.Calificaciones;
import com.shopshopista.productoss.modelo.producto.Categorias;
import com.shopshopista.productoss.modelo.producto.Comentarios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gus
 */
@Repository
public interface CalificacionesRepositori extends JpaRepository<Calificaciones, Long>{
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE Calificaciones c SET c.cal_activo = false WHERE c.id_calificacion = :idCalificacion")
    Categorias eliminarCalificacion(@Param("idCalificacion") Long idCalificacion);
     @Query(value = "SELECT c FROM Calificaciones c WHERE c.producto.id_producto = :idProducto")
    List<Comentarios> buscarComentarioByIdPro(@Param("idProducto") Long idProducto);
}
