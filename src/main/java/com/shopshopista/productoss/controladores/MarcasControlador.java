/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.controladores;

import com.shopshopista.productoss.modelo.Marcas;
import com.shopshopista.productoss.modelo.Productos;
import com.shopshopista.productoss.repositorio.MarcaRepositorio;
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
 * @author Linis
 */
@RestController
@RequestMapping("/api/v1/Marcas")
public class MarcasControlador {
    
       @Autowired
    private MarcaRepositorio marcaRepositorio;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Marcas guardar(@RequestBody @Valid Marcas marcas) {
        return this.marcaRepositorio.save(marcas);
    }
      @GetMapping("/producto")
    @CrossOrigin
    public List<Marcas> getAllMarcas() {
        return this.marcaRepositorio.findAll();
    }

    @DeleteMapping("/{id_marca}")
    @ResponseBody
    public void borrar(@PathVariable Long id_marca) {
        this.marcaRepositorio.eliminarMarcas(id_marca);
    }
    
}
