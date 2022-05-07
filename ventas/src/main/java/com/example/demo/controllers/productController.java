package com.example.demo.controllers;

import com.example.demo.models.detalleVenModel;
import com.example.demo.services.servicePro.proService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class productController {

    @Autowired
    proService pService;

    @RequestMapping("/welcome2")
    public String welcomepage2() {
        return "Bienvenido a mi api";
    }

    @GetMapping(value = "/productos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<detalleVenModel> getAllProductos() {
        return pService.getAllProduct();
    }

    @GetMapping(value = "/productos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public detalleVenModel getProId(@PathVariable("id") int id) {
        return pService.getProduct(id);
    }

    @PostMapping(value = "/loadProducto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String loadProducto(@RequestBody detalleVenModel newPro) {
        return String.valueOf(pService.createProduct(newPro));
    }

    @PutMapping(value = "/updateProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateProduct(@RequestBody detalleVenModel proCreated) {
        pService.updateProduct(proCreated);
    }

    @DeleteMapping(value = "/delPro/{id}")
    public void delPro(@PathVariable("id") int idPro) {
        pService.delProduct(idPro);
    }

}
