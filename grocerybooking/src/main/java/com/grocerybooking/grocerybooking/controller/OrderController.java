package com.grocerybooking.grocerybooking.controller;

import com.grocerybooking.grocerybooking.entity.Order;
import com.grocerybooking.grocerybooking.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
//    @PreAuthorize("hasRole('USER')")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
//    @PreAuthorize("hasRole('USER')")
    public Optional<Order> getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping
//    @PreAuthorize("hasRole('USER')")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PatchMapping("/{orderId}/status")
//    @PreAuthorize("hasRole('USER')")
    public Optional<Order> updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
        return orderService.updateOrderStatus(orderId, status);
    }
}
