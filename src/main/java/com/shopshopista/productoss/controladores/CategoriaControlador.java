/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.controladores;

import com.shopshopista.productoss.modelo.Categorias;
import com.shopshopista.productoss.modelo.Productos;
import com.shopshopista.productoss.repositorio.CategoriaRepositorio;
import com.shopshopista.productoss.repositorio.ProductosRepositorio;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api/vi")
public class CategoriaControlador {
    
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @GetMapping("/producto")
    @CrossOrigin
    public List<Categorias> getAllProductoCategoria(){
    return this.categoriaRepositorio.findAll();
    }
    
    @RequestMapping(value="/Categorias", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Categorias crear (@RequestBody Categorias categoria){
    return this.categoriaRepositorio.save(categoria);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Categorias guardar(@RequestBody @Valid Categorias categoria) {
        return this.categoriaRepositorio.save(categoria);
    }

}
