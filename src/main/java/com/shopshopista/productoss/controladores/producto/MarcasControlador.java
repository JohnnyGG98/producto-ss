package com.shopshopista.productoss.controladores.producto;

import com.shopshopista.productoss.modelo.producto.Marcas;
import com.shopshopista.productoss.repositorio.producto.MarcaRepositorio;
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
@RequestMapping("/api/v1/marca")
public class MarcasControlador {
    
       @Autowired
    private MarcaRepositorio marcaRepositorio;

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Marcas guardar(@RequestBody @Valid Marcas marcas) {
        return this.marcaRepositorio.save(marcas);
    }
      @GetMapping("/")
    @CrossOrigin
    public List<Marcas> getAllMarcas() {
        return this.marcaRepositorio.findAll();
    }

    @DeleteMapping("/eliminar/{id_marca}")
    @ResponseBody
    public void borrar(@PathVariable Long id_marca) {
        this.marcaRepositorio.eliminarMarcas(id_marca);
    }
    
}
