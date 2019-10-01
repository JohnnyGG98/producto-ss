package com.shopshopista.productoss.repositorio.transaccion;

import com.shopshopista.productoss.modelo.transaccion.Kardex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Linis
 */
public interface KardexRepositorio extends JpaRepository<Kardex, Long> {
    
       @Query(value = "SELECT c FROM Kardex c WHERE c.id_kardex = :idKardex")
    Kardex buscarPorIdKardex(@Param("idKardex") Long idKardex);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE Kardex c SET c.capr_activo = false WHERE c.id_kardex = :idKardex")
    void eliminarByIdKardex(@Param("idKardex") Long idKardex);
    
}
