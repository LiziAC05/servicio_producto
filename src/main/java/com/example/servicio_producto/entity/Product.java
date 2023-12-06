package com.example.servicio_producto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")

public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productID", nullable = false)
    private Integer id;

    @Column(name = "productname", nullable = false, length = 40)
    private String productName;

    @ManyToOne
    @JoinColumn(name = "supplierID")
    private Supplier supplierID;

    @ManyToOne
    @JoinColumn(name = "categoryID")
    private Category categoryID;

    @Column(name = "quantityperunit", length = 20)
    private String quantityPerUnit;

    @Column(name = "unitprice", precision = 10, scale = 4)
    private BigDecimal unitPrice;

    @Column(name = "unitsinstock")
    private Short unitsInStock;

    @Column(name = "unitsonorder")
    private Short unitsOnOrder;

    @Column(name = "reorderlevel")
    private Short reorderLevel;

    @Column(name = "discontinued", nullable = false)
    private Boolean discontinued = false;

}