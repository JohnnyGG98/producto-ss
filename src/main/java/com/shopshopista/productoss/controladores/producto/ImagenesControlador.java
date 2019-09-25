package com.shopshopista.productoss.controladores.producto;

import com.shopshopista.productoss.modelo.producto.Imagenes;
import com.shopshopista.productoss.repositorio.producto.ImagenesRepositorio;
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
@RequestMapping("/api/v1/producto/imagen")
@CrossOrigin
public class ImagenesControlador {
    
    
    @Autowired
    private ImagenesRepositorio imagenesRepositorio;

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Imagenes guardar(@RequestBody @Valid Imagenes imagenes) {
        return this.imagenesRepositorio.save(imagenes);
    }
      @GetMapping("/")
    @CrossOrigin
    public List<Imagenes> getAllImagenes() {
        return this.imagenesRepositorio.findAll();
    }

    @DeleteMapping("/eliminar/{id_imagen}")
    @ResponseBody
    public void borrar(@PathVariable Long id_imagen) {
        this.imagenesRepositorio.eliminarImagenes(id_imagen);
    }
    
    
}
