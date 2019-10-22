package com.shopshopista.productoss.controladores.producto;

import com.shopshopista.productoss.modelo.producto.Categorias;
import com.shopshopista.productoss.modelo.producto.Productos;
import com.shopshopista.productoss.modelo.producto.ProductosCategorias;
import com.shopshopista.productoss.pojo.ProductoCategoriaRQ;
import com.shopshopista.productoss.repositorio.producto.CategoriaRepositorio;
import com.shopshopista.productoss.repositorio.producto.ProductosCategoriasRepositorio;
import com.shopshopista.productoss.repositorio.producto.ProductosRepositorio;
import java.util.ArrayList;
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

    @Autowired
    private CategoriaRepositorio categoriaRepo;

    @Autowired
    private ProductosRepositorio productoRepo;

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ProductosCategorias guardar(@RequestBody @Valid ProductosCategorias productoCategoria) {
        return this.productoCategoriaRepositorio.save(productoCategoria);
    }

    @RequestMapping(value = "/solo", method = RequestMethod.POST)
    @ResponseBody
    public ProductosCategorias guardar(
            @RequestBody ProductoCategoriaRQ pc
    ) throws Exception {
        ProductosCategorias pcm = new ProductosCategorias();
        Categorias c = categoriaRepo.buscarCategoriaById(pc.getId_categoria());
        pcm.setCategoria(c);
        pcm.setProducto(productoRepo.buscarProductosById(pc.getId_producto()));

        return productoCategoriaRepositorio.save(pcm);
    }
    
    @RequestMapping(value = "/lista", method = RequestMethod.POST)
    @ResponseBody
    public List<ProductosCategorias> guardartodos(
            @RequestBody List<ProductoCategoriaRQ> pca
    ) throws Exception {
        
        List<ProductosCategorias> ps = new ArrayList<>();
        if(pca.size() > 1){
            Productos p = productoRepo.buscarProductosById(pca.get(0).getId_producto());
            
            // 
            pca.forEach(pc -> {
                Categorias c = categoriaRepo.buscarCategoriaById(pc.getId_categoria());
                ProductosCategorias pcm = new ProductosCategorias();
                pcm.setCategoria(c);
                pcm.setProducto(p);
                //this.productoCategoriaRepositorio.save(pcm);
                // Agregar a un iterable 
                ps.add(pcm);
            });
        }
        
        return productoCategoriaRepositorio.saveAll(ps);
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
