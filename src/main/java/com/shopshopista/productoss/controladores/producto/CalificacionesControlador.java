package com.shopshopista.productoss.controladores.producto;

import com.shopshopista.productoss.modelo.producto.Calificaciones;
import com.shopshopista.productoss.repositorio.producto.CalificacionesRepositori;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gus
 */
@RestController
@RequestMapping("/api/v1/producto/calificacion")
@CrossOrigin("*")
public class CalificacionesControlador {
    
    @Autowired
    private CalificacionesRepositori CR;
    
    @GetMapping("/")
    public List<Calificaciones> getAll(){
        return this.CR.findAll();
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    public Calificaciones guardar(@Valid @RequestBody Calificaciones c){
        return this.CR.save(c);
    }
    
    @DeleteMapping("/eliminar/{idCalificacion}")
    public void eliminar(@PathVariable long idCalificacion){
        this.CR.eliminarCalificacion(idCalificacion);
    }
    
}
