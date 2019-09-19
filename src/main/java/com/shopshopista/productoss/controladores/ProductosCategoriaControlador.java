package com.shopshopista.productoss.controladores;

import com.shopshopista.productoss.modelo.ProductosCategorias;
import com.shopshopista.productoss.repositorio.ProductosCategoriasRepositorio;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/api/v1/producto/categoria")
@CrossOrigin
public class ProductosCategoriaControlador {

    @Autowired
    private ProductosCategoriasRepositorio productoCategoriaRepositorio;

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ProductosCategorias guardar(@RequestBody @Valid ProductosCategorias productoCategoria) {
        return this.productoCategoriaRepositorio.save(productoCategoria);
    }

    @GetMapping("/")
    @CrossOrigin
    public List<ProductosCategorias> getAllProductoCategoria() {
        return this.productoCategoriaRepositorio.findAll();
    }

    @DeleteMapping("/eliminar/{id_prod_categoria}")
    @ResponseBody
    public void borrar(@PathVariable Long id_producto_categoria) {
        this.productoCategoriaRepositorio.deleteById(id_producto_categoria);
    }
}
