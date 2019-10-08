package com.shopshopista.productoss.controladores.producto;

import com.shopshopista.productoss.modelo.producto.Productos;
import com.shopshopista.productoss.pojo.ProductoPage;
import com.shopshopista.productoss.repositorio.producto.ProductosRepositorio;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alumno
 */
@RestController
@RequestMapping("/api/v1/producto")
@CrossOrigin
public class ProductosControlador {

    @Autowired
    private ProductosRepositorio productoRepositorio;

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Productos guardar(@RequestBody @Valid Productos producto) {
        return this.productoRepositorio.save(producto);
    }
    
    @GetMapping("/")
    @CrossOrigin
    public List<Productos> getAllProductos() {
        return this.productoRepositorio.findAll();
    }

    @DeleteMapping("/eliminar/{id_producto}")
    @ResponseBody
    public void borrar(@PathVariable Long id_producto) {
        this.productoRepositorio.deleteById(id_producto);
    }
    
    @GetMapping("/productobyid/{id_producto}")
    @CrossOrigin
    public Productos getProductoById(Long id_producto){
        return this.productoRepositorio.buscarProductosById(id_producto);
    }
    
    /**
     * Consultamos productos para el inicio de la pagina WEB
     * @param limit
     * @param offset
     * @return 
     */
    @GetMapping("home/all")
    public List<ProductoPage> getForHomeAll(
            @RequestParam(defaultValue = "10", required = false) int limit, 
            @RequestParam(defaultValue = "0", required = false) int offset
    ){
        return this.productoRepositorio.getForPage(limit, offset);
    }
    
    @GetMapping("categoria/{idCategoria}")
    public List<ProductoPage> getForCategoriaAll(
            @PathVariable Long idCategoria,
            @RequestParam(defaultValue = "10", required = false) int limit, 
            @RequestParam(defaultValue = "0", required = false) int offset
    ){
        return this.productoRepositorio.getForCategoria(idCategoria, limit, offset);
    }
    
    @GetMapping("marca/{idMarca}")
    public List<ProductoPage> getForMarcaAll(
            @PathVariable Long idMarca,
            @RequestParam(defaultValue = "10", required = false) int limit, 
            @RequestParam(defaultValue = "0", required = false) int offset
    ){
        return this.productoRepositorio.getForMarca(idMarca, limit, offset);
    }
    
    @GetMapping("linea/{idLinea}")
    public List<ProductoPage> getForLineaAll(
            @PathVariable Long idLinea,
            @RequestParam(defaultValue = "10", required = false) int limit, 
            @RequestParam(defaultValue = "0", required = false) int offset
    ){
        return this.productoRepositorio.getForMarca(idLinea, limit, offset);
    }
    
}
