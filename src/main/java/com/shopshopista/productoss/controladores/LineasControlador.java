package com.shopshopista.productoss.controladores;

import com.shopshopista.productoss.modelo.Lineas;
import com.shopshopista.productoss.repositorio.LineasRepositorio;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/api/v1/linea")
@CrossOrigin
public class LineasControlador {

    @Autowired
    private LineasRepositorio lineasRepositorio;

    @GetMapping("/")
    @CrossOrigin
    public List<Lineas> getAllLineas() {
        return this.lineasRepositorio.findAll();
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Lineas createLinea(@Valid @RequestBody Lineas lineas) {
        return this.lineasRepositorio.save(lineas);
    }

    @RequestMapping(value = "/eliminar/{idLinea}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void eliminarLinea(@PathVariable Long idLinea) {
        this.lineasRepositorio.eliminarByIdLineas(idLinea);
    }
    
    @GetMapping("/{idLinea}")
    @ResponseBody
    public Lineas getLineaById(@PathVariable Long idLinea) {
        return this.lineasRepositorio.buscarPorIdLineas(idLinea);
    }
}
