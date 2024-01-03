package com.grocerybooking.grocerybooking.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GroceryDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private Long inventory;
}
