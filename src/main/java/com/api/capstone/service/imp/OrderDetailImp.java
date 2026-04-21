package com.api.capstone.service.imp;

import com.api.capstone.exception.NotFoundException;
import com.api.capstone.model.Order;
import com.api.capstone.model.OrderDetail;
import com.api.capstone.model.Product;
import com.api.capstone.model.Role;
import com.api.capstone.repository.OrderDetailRepository;
import com.api.capstone.repository.OrderRepository;
import com.api.capstone.repository.ProductRepository;
import com.api.capstone.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailImp implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail getOrderDetailById(int id) {
        return null;
    }

    @Override
    public OrderDetail createNewOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail updateOrderDetail(int id, OrderDetail orderDetail) {
        OrderDetail search = orderDetailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("OrderDetail not found with id: " + id));

        Order order = orderRepository.findById(orderDetail.getOrder().getId())
                .orElseThrow(() -> new NotFoundException("Order not found with id: " + orderDetail.getOrder().getId()));

        Product product = productRepository.findById(orderDetail.getProduct().getId())
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + orderDetail.getProduct().getId()));

        search.setOrder(order);
        search.setProduct(product);
        search.setQuantity(orderDetail.getQuantity());
        search.setUnitPrice(orderDetail.getUnitPrice());

        return orderDetailRepository.save(search);
    }

    @Override
    public void deleteOrderDetail(int id) {
        OrderDetail search = orderDetailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("OrderDetail not found with id: " + id));

        orderDetailRepository.delete(search);
    }
}
