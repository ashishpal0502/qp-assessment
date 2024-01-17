package com.grocerybooking.grocerybooking.dto;

import com.grocerybooking.grocerybooking.entity.OrderGrocery;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;

    private String customerId;

    private List<OrderGrocery> items;

    private double totalPrice;

    private String deliveryAddress;

    private String status;
}
