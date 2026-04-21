package com.api.capstone.service;

import com.api.capstone.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> getAllOrderDetails();
    OrderDetail getOrderDetailById(int id);
    OrderDetail createNewOrderDetail(OrderDetail orderDetail);
    OrderDetail updateOrderDetail(int id, OrderDetail orderDetail);
    void deleteOrderDetail(int id);
}
