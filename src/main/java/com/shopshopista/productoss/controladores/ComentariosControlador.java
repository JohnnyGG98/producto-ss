/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.controladores;

import com.shopshopista.productoss.modelo.Categorias;
import com.shopshopista.productoss.modelo.Comentarios;
import com.shopshopista.productoss.modelo.Productos;
import com.shopshopista.productoss.repositorio.ComentariosRepositorio;
import com.shopshopista.productoss.repositorio.ProductosRepositorio;
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
public class ComentariosControlador {
    
    @Autowired
    private ComentariosRepositorio comentarioRepositorio;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Comentarios guardar(@RequestBody @Valid Comentarios comentario) {
        return this.comentarioRepositorio.save(comentario);
    }
    
     @GetMapping("/comentarios")
    @CrossOrigin
    public List<Comentarios> getAllComentarios() {
        return this.comentarioRepositorio.findAll();
    }

    @DeleteMapping("/eliminarcomentario/{id_comentario}")
    @ResponseBody
    public void borrar(@PathVariable Long id_comentario) {
        this.comentarioRepositorio.eliminarComentarios(id_comentario);
    }
}
