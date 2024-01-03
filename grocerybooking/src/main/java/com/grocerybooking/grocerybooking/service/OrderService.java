package com.grocerybooking.grocerybooking.service;

import com.grocerybooking.grocerybooking.entity.Order;
import com.grocerybooking.grocerybooking.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public Order createOrder(Order order) {
        // Additional logic can be added here, e.g., calculating total price, validating items, etc.
        return orderRepository.save(order);
    }

    public Optional<Order> updateOrderStatus(Long orderId, String status) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        optionalOrder.ifPresent(order -> {
            order.setStatus(status);
            orderRepository.save(order);
        });
        return optionalOrder;
    }
}
