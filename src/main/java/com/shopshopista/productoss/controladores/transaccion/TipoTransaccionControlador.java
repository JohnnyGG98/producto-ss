package com.shopshopista.productoss.controladores.transaccion;

import com.shopshopista.productoss.modelo.transaccion.TiposTransaccion;
import com.shopshopista.productoss.repositorio.transaccion.TipoTransaccionRepositorio;
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
@RequestMapping("/api/v1/tipo/transaccion")
public class TipoTransaccionControlador {

    @Autowired
    private TipoTransaccionRepositorio tipoTransaccionRep;

    @GetMapping("/")
    @CrossOrigin
    public List<TiposTransaccion> getAllTiposTransaccion() {
        return this.tipoTransaccionRep.findAll();
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public TiposTransaccion createCardex(@Valid @RequestBody TiposTransaccion tipoTrasaccion) {
        return this.tipoTransaccionRep.save(tipoTrasaccion);
    }

    @RequestMapping(value = "/eliminar/{idTipoTransaccion}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void eliminarTipoTransaccion(@PathVariable Long idTipoTransaccion) {
        this.tipoTransaccionRep.eliminarByIdTipoTransaccion(idTipoTransaccion);
    }

    @GetMapping("/{idTipoTransaccion}")
    @ResponseBody
    public TiposTransaccion getTipoTransaccionById(@PathVariable Long idTipoTransaccion) {
        return this.tipoTransaccionRep.buscarPorIdTipoTransaccion(idTipoTransaccion);
    }

}
