package com.shopshopista.productoss.controladores;

import com.shopshopista.productoss.modelo.Productos;
import com.shopshopista.productoss.repositorio.ProductosRepositorio;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alumno
 */
@RestController
@RequestMapping("/api/v1/Productos")
public class ProductosControlador {

    @Autowired
    private ProductosRepositorio productoRepositorio;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Productos guardar(@RequestBody @Valid Productos producto) {
        return this.productoRepositorio.save(producto);
    }
}
