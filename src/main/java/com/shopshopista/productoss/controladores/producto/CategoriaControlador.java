package com.shopshopista.productoss.controladores.producto;

import com.shopshopista.productoss.modelo.producto.Categorias;
import com.shopshopista.productoss.pojo.producto.categoria.CategoriaPage;
import com.shopshopista.productoss.repositorio.producto.CategoriaRepositorio;
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
 * @author Daniel
 */
@RestController
@RequestMapping("/api/v1/categoria")
@CrossOrigin
public class CategoriaControlador {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Categorias guardar(@RequestBody @Valid Categorias categoria) {
        return this.categoriaRepositorio.save(categoria);
    }

    @GetMapping("/")
    @CrossOrigin
    public List<Categorias> getAllProductoCategoria() {
        return this.categoriaRepositorio.findAll();
    }

    @DeleteMapping("/eliminar/{id_categoria}")
    @ResponseBody
    public void borrar(@PathVariable Long id_categoria) {
        this.categoriaRepositorio.eliminarCategoria(id_categoria);
    }

    @GetMapping(path = {"/{idCategoria}"})
    @CrossOrigin
    public Categorias seleccionarId(@PathVariable("idCategoria") Long idCategoria) {
        return this.categoriaRepositorio.getOne(idCategoria);
    }

    @GetMapping(path = "/home")
    public List<CategoriaPage> getHomeAll() {
        return this.categoriaRepositorio.getForHome();
    }
    
    @GetMapping(path = "/page")
    public List<CategoriaPage> getPageAll() {
        return this.categoriaRepositorio.getForPage();
    }

    @GetMapping(path = "/page/{idCliente}")
    public List<CategoriaPage> getPageAll(@PathVariable("idCliente") Long idCliente) {
        return this.categoriaRepositorio.getForPage(idCliente);
    }
    
    @GetMapping(path = "/cliente/{idCliente}")
    public List<CategoriaPage> getForCliente(@PathVariable("idCliente") Long idCliente) {
        return this.categoriaRepositorio.getForCliente(idCliente);
    }
            
}
