package com.example.servicio_producto.controller;

import com.example.servicio_producto.entity.Product;
import com.example.servicio_producto.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/productos")
    public List<Product> listar(){
        return productRepository.findAll();
    }
    @GetMapping("/productos/{id}")
    public Product buscarPorId(@PathVariable("id") int id){
        Optional<Product> optional = productRepository.findById(id);
        return optional.orElse(null);
    }
}
