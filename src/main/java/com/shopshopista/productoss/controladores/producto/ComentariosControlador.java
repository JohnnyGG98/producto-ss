package com.shopshopista.productoss.controladores.producto;

import com.shopshopista.productoss.modelo.producto.Comentarios;
import com.shopshopista.productoss.repositorio.producto.ComentariosRepositorio;
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
 * @author Daniel
 */
@RestController
@RequestMapping("/api/v1/comentario")
@CrossOrigin
public class ComentariosControlador {
    
     @Autowired
    private ComentariosRepositorio comentarioRepositorio;

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Comentarios guardar(@RequestBody @Valid Comentarios comentario) {
        return this.comentarioRepositorio.save(comentario);
    }
    
     @GetMapping("/")
    @CrossOrigin
    public List<Comentarios> getAllComentarios() {
        return this.comentarioRepositorio.findAll();
    }

    @DeleteMapping("/eliminar/{id_comentario}")
    @ResponseBody
    public void borrar(@PathVariable Long id_comentario) {
        this.comentarioRepositorio.deleteById(id_comentario);
    }
}
