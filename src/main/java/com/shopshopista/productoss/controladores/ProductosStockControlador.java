/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.controladores;

import com.shopshopista.productoss.modelo.Productos;
import com.shopshopista.productoss.modelo.ProductosStock;
import com.shopshopista.productoss.repositorio.ProductosRepositorio;
import com.shopshopista.productoss.repositorio.ProductosStockRepositorio;
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
@RequestMapping("/api/v1/producto/stock")
public class ProductosStockControlador {
    
    @Autowired
    private ProductosStockRepositorio productosStockRepositorio;

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ProductosStock guardar(@RequestBody @Valid ProductosStock productosStock) {
        return this.productosStockRepositorio.save(productosStock);
    }
      @GetMapping("/")
    @CrossOrigin
    public List<ProductosStock> getAllProductos() {
        return this.productosStockRepositorio.findAll();
    }

    @DeleteMapping("/eliminar/{id_producto_stock}")
    @ResponseBody
    public void borrar(@PathVariable Long id_producto_stock) {
        this.productosStockRepositorio.eliminarProductosStock(id_producto_stock);
    }
    
}
