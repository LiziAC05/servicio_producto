package com.example.servicio_producto.controller;

import com.example.servicio_producto.entity.Product;
import com.example.servicio_producto.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    Environment environment;
    @GetMapping("/productos")
    public List<Product> listar(){
        List<Product> list = productRepository.findAll();
        for (int i=0; i<list.size(); i++){
            int port = Integer.parseInt(environment.getProperty("local.server.port"));
            list.get(i).setPort(port);
            //coloco el puerto del servidor que esta sirviendo el servicio.
        }
        return list;
    }
    @GetMapping("/productos/{id}")
    public Product buscarPorId(@PathVariable("id") int id){
        //Quiero forzar un error, que me fallen el 10 y el 20 para que pueda funcionar el Circuit Breaker
        if (id == 10){
            throw new IllegalStateException("Error al buscar el Porducto");
        } if (id == 20){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Optional<Product> optional = productRepository.findById(id);
        return optional.orElse(null);
    }
}
