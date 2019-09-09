package com.shopshopista.productoss.controladores;

import com.shopshopista.productoss.modelo.Comentarios;
import com.shopshopista.productoss.modelo.Productos;
import com.shopshopista.productoss.repositorio.ProductosRepositorio;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
      @GetMapping("/producto")
    @CrossOrigin
    public List<Productos> getAllProductos() {
        return this.productoRepositorio.findAll();
    }

    @DeleteMapping("/{id_producto}")
    @ResponseBody
    public void borrar(@PathVariable Long id_producto) {
        this.productoRepositorio.deleteById(id_producto);
    }
}
