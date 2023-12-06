package com.example.servicio_producto.repository;

import com.example.servicio_producto.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "product")
public interface ProductRepository extends JpaRepository<Product, Integer> {

}