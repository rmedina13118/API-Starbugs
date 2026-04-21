package com.api.capstone.service;

import com.api.capstone.model.Order;


import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(int id);
    Order createNewOrder(Order order);
    Order updateOrder(int id, Order order);
    void deleteOrder(int id);
}
