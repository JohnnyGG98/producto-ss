package com.shopshopista.productoss.controladores.producto;

import com.shopshopista.productoss.modelo.producto.Comentarios;
import com.shopshopista.productoss.pojo.ComentarioProductoRQ;
import com.shopshopista.productoss.repositorio.producto.ComentariosRepositorio;
import com.shopshopista.productoss.repositorio.producto.ProductosRepositorio;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/api/v1/comentario")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class ComentariosControlador {

    @Autowired
    private ComentariosRepositorio comentarioRepositorio;
    
    @Autowired ProductosRepositorio pr;

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Comentarios guardar(@RequestBody @Valid ComentarioProductoRQ comentario) {
        Comentarios com = new Comentarios();
        com.setId_comentario(comentario.getId_comentario());
        com.setComentario(comentario.getComentario());
        com.setId_cliente(comentario.getId_cliente());
        com.setProducto(pr.findById(comentario.getId_producto()).get());
        return this.comentarioRepositorio.save(com);
    }

    @GetMapping("/")
    @CrossOrigin
    public List<Comentarios> getAllComentarios() {
        return this.comentarioRepositorio.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Comentarios seleccionarId(@Valid @PathVariable Long id) {
        System.out.println("Le pasamos: " + id);
        return this.comentarioRepositorio.findById(id).get();
    }
 @RequestMapping(value = "/comentarioPro/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Comentarios> seleccionarIdPro(@Valid @PathVariable Long id) {
        System.out.println("Le pasamos: " + id);
        return this.comentarioRepositorio.buscarComentarioByIdPro(id);
    }

    @PutMapping(path = {"/actualizar/{id_comentario}"})
    public Comentarios actualizar(@RequestBody Comentarios v, @PathVariable("id_comentario") Long id_comentario) {
        return this.comentarioRepositorio.save(v);
    }

    @DeleteMapping("/eliminar/{id_comentario}")
    @ResponseBody
    public void borrar(@PathVariable Long id_comentario) {
        this.comentarioRepositorio.deleteById(id_comentario);
    }
    
}
