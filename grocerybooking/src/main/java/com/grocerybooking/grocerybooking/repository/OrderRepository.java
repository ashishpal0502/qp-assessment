package com.grocerybooking.grocerybooking.repository;

import com.grocerybooking.grocerybooking.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

