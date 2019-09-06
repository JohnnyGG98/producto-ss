/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.controladores;

import com.shopshopista.productoss.modelo.Productos;
import com.shopshopista.productoss.repositorio.ProductosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author alumno
 */
public class ProductosControlador {
   @Autowired
	private ProductosRepositorio productoRepositorio;
	
	@PostMapping("/")
    @ResponseBody
    public Productos guardar(@RequestBody Productos producto) {
        return this.productoRepositorio.save(producto);
    } 
}
