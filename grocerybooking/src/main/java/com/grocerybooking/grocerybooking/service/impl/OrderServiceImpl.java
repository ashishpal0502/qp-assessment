package com.grocerybooking.grocerybooking.service.impl;

import com.grocerybooking.grocerybooking.dto.OrderDto;
import com.grocerybooking.grocerybooking.entity.Order;
import com.grocerybooking.grocerybooking.repository.OrderRepository;
import com.grocerybooking.grocerybooking.service.OrderService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    private ModelMapper modelMapper;

    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map((todo) -> modelMapper.map(todo, OrderDto.class)).collect(Collectors.toList());
    }

    public OrderDto getOrderById(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return modelMapper.map(order, OrderDto.class);
    }

    public OrderDto createOrder(Order order) {
        // Additional logic can be added here, e.g., calculating total price, validating items, etc.
        Order savedOrder = orderRepository.save(order);
        return modelMapper.map(savedOrder, OrderDto.class);
    }

    public OrderDto updateOrderStatus(Long orderId, String status) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        optionalOrder.ifPresent(order -> {
            order.setStatus(status);
            orderRepository.save(order);
        });
        return modelMapper.map(optionalOrder, OrderDto.class);
    }
}
