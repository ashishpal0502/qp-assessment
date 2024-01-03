package com.grocerybooking.grocerybooking.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private String customerId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderGrocery> items;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "status")
    private String status;

    // getters and setters
}

