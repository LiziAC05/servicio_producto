package com.example.servicio_producto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter

@Entity
@Table(name = "categories")
@JsonIgnoreProperties({"picture"})
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryID", nullable = false)
    private Integer id;

    @Column(name = "categoryname", nullable = false, length = 15)
    private String categoryName;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "picture")
    private byte[] picture;

}