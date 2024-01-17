package com.grocerybooking.grocerybooking.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "order_items")
public class OrderGrocery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "quantity")
    private int quantity;

}
