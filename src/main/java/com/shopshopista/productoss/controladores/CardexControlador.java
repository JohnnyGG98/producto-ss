/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopshopista.productoss.controladores;


import com.shopshopista.productoss.modelo.Cardex;
import com.shopshopista.productoss.repositorio.CardexRepositorio;
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

/**
 *
 * @author Linis
 */
@RestController
@RequestMapping("/api/v1/cardex")
@CrossOrigin
public class CardexControlador {
    
    @Autowired
    private CardexRepositorio cardexRepositorio;

    @GetMapping("/")
    @CrossOrigin
    public List<Cardex> getAllCardex() {
        return this.cardexRepositorio.findAll();
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Cardex createCardex(@RequestBody Cardex cardex) {
        return this.cardexRepositorio.save(cardex);
    }

    @RequestMapping(value = "/eliminar/{idCardex}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void eliminarCardex(@PathVariable Long idCardex) {
        this.cardexRepositorio.eliminarByIdCardex(idCardex);
    }

    @GetMapping("/{idCardex}")
    @ResponseBody
    public Cardex getCardexById(@PathVariable Long idCardex) {
        return this.cardexRepositorio.buscarPorIdCardex(idCardex);
    }

    
}
