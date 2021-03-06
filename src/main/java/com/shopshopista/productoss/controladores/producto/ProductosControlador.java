package com.shopshopista.productoss.controladores.producto;

import com.fasterxml.jackson.databind.JsonNode;
import com.shopshopista.productoss.modelo.producto.Productos;
import com.shopshopista.productoss.pojo.producto.ProductoDetalleRP;
import com.shopshopista.productoss.pojo.producto.ProductoPage;
import com.shopshopista.productoss.repositorio.producto.CategoriaRepositorio;
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
@CrossOrigin("*")
public class ProductosControlador {

    @Autowired
    private ProductosRepositorio productoRepositorio;

    @Autowired
    private CategoriaRepositorio CR;

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Productos guardar(@Valid @RequestBody Productos producto) {
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
    public Productos getProductoById(@PathVariable Long id_producto) {
        return this.productoRepositorio.buscarProductosById(id_producto);
    }

    /**
     * Consultamos productos para el inicio de la pagina WEB
     *
     * @param limit
     * @param offset
     * @return
     */
    @GetMapping("home/all")
    public List<ProductoPage> getForHomeAll(
            @RequestParam(defaultValue = "10", required = false) int limit,
            @RequestParam(defaultValue = "0", required = false) int offset
    ) {
        return this.productoRepositorio.getForPage(limit, offset);
    }

    @GetMapping("categoria/{idCategoria}")
    public List<ProductoPage> getForCategoriaAll(
            @PathVariable Long idCategoria,
            @RequestParam(defaultValue = "10", required = false) int limit,
            @RequestParam(defaultValue = "0", required = false) int offset
    ) {
        return this.productoRepositorio.getForCategoria(idCategoria, limit, offset);
    }

    @GetMapping("marca/{idMarca}")
    public List<ProductoPage> getForMarcaAll(
            @PathVariable Long idMarca,
            @RequestParam(defaultValue = "10", required = false) int limit,
            @RequestParam(defaultValue = "0", required = false) int offset
    ) {
        return this.productoRepositorio.getForMarca(idMarca, limit, offset);
    }

    @GetMapping("linea/{idLinea}")
    public List<ProductoPage> getForLineaAll(
            @PathVariable Long idLinea,
            @RequestParam(defaultValue = "10", required = false) int limit,
            @RequestParam(defaultValue = "0", required = false) int offset
    ) {
        return this.productoRepositorio.getForMarca(idLinea, limit, offset);
    }

    @GetMapping("vendedor/{idVendedor}")
    public List<ProductoPage> getForVendedor(
            @PathVariable Long idVendedor,
            @RequestParam(defaultValue = "10", required = false) int limit,
            @RequestParam(defaultValue = "0", required = false) int offset
    ) {
        return this.productoRepositorio.getForVendedor(idVendedor, limit, offset);
    }

    @GetMapping("buscar/")
    public List<ProductoPage> getForBusquedaAll(
            @RequestParam(defaultValue = "", required = true) String aguja,
            @RequestParam(defaultValue = "10", required = false) int limit,
            @RequestParam(defaultValue = "0", required = false) int offset
    ) {
        return this.productoRepositorio.getForBusqueda(aguja, limit, offset);
    }

    @GetMapping("slide/")
    public List<ProductoPage> getForSlide() {
        return this.productoRepositorio.getForSlide(5, 0);
    }

    @GetMapping("cliente/{idCliente}")
    public List<ProductoPage> getForCliente(
            @PathVariable Long idCliente,
            @RequestParam(defaultValue = "10", required = false) int limit,
            @RequestParam(defaultValue = "0", required = false) int offset
    ) {
        return this.productoRepositorio.getForCliente(limit, offset, idCliente);
    }

    @GetMapping("recomendacion/{idProducto}")
    public List<ProductoPage> getForRecomendacion(
            @PathVariable Long idProducto,
            @RequestParam(defaultValue = "10", required = false) int limit,
            @RequestParam(defaultValue = "0", required = false) int offset
    ) {
        return this.productoRepositorio.getForProducto(limit, offset, idProducto);
    }

    @GetMapping("detalle/{idProducto}")
    public ProductoDetalleRP getForDetalle(@PathVariable Long idProducto) {
        return new ProductoDetalleRP(
                productoRepositorio.getProductoForDescripcion(idProducto),
                CR.getForProducto(idProducto)
        );
    }

    @GetMapping("page/{idProducto}")
    public ProductoPage getOnePorId(@PathVariable Long idProducto) {
        return this.productoRepositorio.getOnePorId(idProducto);
    }

    /**
     * Solo lo cree para pruebas de consultas complejas en JPA
     */
    @GetMapping("json")
    public void getJSON() {
        JsonNode json = this.productoRepositorio.getJSON();
        System.out.println(json);
    }

}
