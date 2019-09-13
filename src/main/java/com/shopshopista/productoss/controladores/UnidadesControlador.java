/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.controladores;

import com.shopshopista.productoss.modelo.Productos;
import com.shopshopista.productoss.modelo.Unidades;
import com.shopshopista.productoss.repositorio.ProductosRepositorio;
import com.shopshopista.productoss.repositorio.UnidadesRepositorio;
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
@RequestMapping("/api/v1/Unidades")
public class UnidadesControlador {
    
    
    @Autowired
    private UnidadesRepositorio unidadesRepositorio;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Unidades guardar(@RequestBody @Valid Unidades unidades) {
        return this.unidadesRepositorio.save(unidades);
    }
      @GetMapping("/producto")
    @CrossOrigin
    public List<Unidades> getAllProductos() {
        return this.unidadesRepositorio.findAll();
    }

    @DeleteMapping("/{id_unidad}")
    @ResponseBody
    public void borrar(@PathVariable Long id_unidad) {
        this.unidadesRepositorio.eliminarUnidades(id_unidad);
    }
}
