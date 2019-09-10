/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.controladores;

import com.shopshopista.productoss.modelo.Categorias;
import com.shopshopista.productoss.modelo.Marcas;
import com.shopshopista.productoss.modelo.ProductosCategorias;
import com.shopshopista.productoss.repositorio.CategoriaRepositorio;
import com.shopshopista.productoss.repositorio.MarcaRepositorio;
import com.shopshopista.productoss.repositorio.ProductosCategoriasRepositorio;
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
 * @author Linis
 */
@RestController
@RequestMapping("/api/v1/Marcas")
public class MarcasControlador {
    
     @Autowired
    private MarcaRepositorio marcaRepositorio;

    //traer todas las marcas
    @GetMapping("/marcas")
    @CrossOrigin
    public List<Marcas> getAllMarcas() {
        return this.marcaRepositorio.findAll();
    }

    //crear una marca
    @RequestMapping(value = "/marca", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Marcas createMarca(@RequestBody Marcas marcas) {
        return this.marcaRepositorio.save(marcas);
    }

    //eliminar marcas
    @RequestMapping(value = "/eliminarmarca/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void eliminarMarca(@PathVariable Long id) {
        this.marcaRepositorio.eliminarMarcas(id);
    }

    //buscar marcas por id
    @GetMapping("/buscarmarca/{id}")
    @ResponseBody
    public Marcas getBuscarById(@PathVariable Long id) {
        return this.marcaRepositorio.buscarMarcasById(id);
    }
    
}

