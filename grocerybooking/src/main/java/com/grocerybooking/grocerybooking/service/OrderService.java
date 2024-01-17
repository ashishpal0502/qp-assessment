package com.grocerybooking.grocerybooking.service;

import com.grocerybooking.grocerybooking.dto.OrderDto;
import com.grocerybooking.grocerybooking.entity.Order;

import java.util.List;


public interface OrderService {

    public List<OrderDto> getAllOrders();

    public OrderDto getOrderById(Long orderId);

    public OrderDto createOrder(Order order);

    public OrderDto updateOrderStatus(Long orderId, String status);
}
