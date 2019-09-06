/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.controladores;

import com.shopshopista.productoss.modelo.Productos;
import com.shopshopista.productoss.modelo.ProductosCategorias;
import com.shopshopista.productoss.repositorio.ProductosCategoriasRepositorio;
import com.shopshopista.productoss.repositorio.ProductosRepositorio;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class ProductosCategoriaControlador {
    @Autowired
    private ProductosCategoriasRepositorio productoCategoriaRepositorio;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ProductosCategorias guardar(@RequestBody @Valid ProductosCategorias productoCategoria) {
        return this.productoCategoriaRepositorio.save(productoCategoria);
    }
}
