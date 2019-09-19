/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.controladores;

import com.shopshopista.productoss.modelo.Categorias;
import com.shopshopista.productoss.repositorio.CategoriaRepositorio;
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
@RequestMapping("/api/v1/categoria")
@CrossOrigin
public class CategoriaControlador {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Categorias guardar(@RequestBody @Valid Categorias categoria) {
        return this.categoriaRepositorio.save(categoria);
    }
    
    @GetMapping("/")
    @CrossOrigin
    public List<Categorias> getAllProductoCategoria() {
        return this.categoriaRepositorio.findAll();
    }

    @DeleteMapping("/eliminar/{id_categoria}")
    @ResponseBody
    public void borrar(@PathVariable Long id_categoria) {
        this.categoriaRepositorio.eliminarCategoria(id_categoria);
    }
}
