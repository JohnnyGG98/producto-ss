/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.controladores;

import com.shopshopista.productoss.modelo.ProductosStock;
import com.shopshopista.productoss.repositorio.ProductosStockRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/api/v1/ProductosStock")
public class ProductosStockControlador {
      @Autowired
    private ProductosStockRepositorio productosStockRepositorio;
    
    @GetMapping("/productosstock")
    @CrossOrigin
    public List<ProductosStock> getAllAdmins() {
        return this.productosStockRepositorio.findAll();
    }

    @RequestMapping(value = "/productosstock", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ProductosStock createAdmin(@RequestBody ProductosStock admin) {
        return this.productosStockRepositorio.save(admin);
    }
    
    @RequestMapping(value = "/eliminarproductosstock/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void eliminarAdmin(@PathVariable Long id){
        this.productosStockRepositorio.eliminarById(id);
    } 

    @GetMapping("/productosstock/{id}")
    @ResponseBody
    public List<ProductosStock> getAdminsById(@PathVariable String prod) {
        return this.productosStockRepositorio.buscarPorProducto(prod);
    }
    
    
    
}
