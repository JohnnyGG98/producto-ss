package com.shopshopista.productoss.controladores.transaccion;


import com.shopshopista.productoss.modelo.transaccion.Kardex;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.shopshopista.productoss.repositorio.transaccion.KardexRepositorio;

/**
 *
 * @author Linis
 */
@RestController
@RequestMapping("/api/v1/kardex")
@CrossOrigin
public class KardexControlador {
    
    @Autowired
    private KardexRepositorio cardexRepositorio;

    @GetMapping("/")
    @CrossOrigin
    public List<Kardex> getAllCardex() {
        return this.cardexRepositorio.findAll();
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Kardex createCardex(@RequestBody Kardex cardex) {
        return this.cardexRepositorio.save(cardex);
    }

    @RequestMapping(value = "/eliminar/{idCardex}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void eliminarCardex(@PathVariable Long idCardex) {
        this.cardexRepositorio.eliminarByIdKardex(idCardex);
    }

    @GetMapping("/get{idCardex}")
    @ResponseBody
    public Kardex getCardexById(@PathVariable Long idCardex) {
        return this.cardexRepositorio.buscarPorIdKardex(idCardex);
    }

    
}
