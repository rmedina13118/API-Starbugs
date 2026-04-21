package com.api.capstone.service.imp;

import com.api.capstone.exception.NotFoundException;
import com.api.capstone.model.Customer;
import com.api.capstone.model.Order;
import com.api.capstone.model.State;
import com.api.capstone.repository.CustomerRepository;
import com.api.capstone.repository.OrderRepository;
import com.api.capstone.repository.StateRepository;
import com.api.capstone.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderImp implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private StateRepository stateRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(int id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order not found with id: " + id));

        return order;
    }

    @Override
    public Order createNewOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(int id, Order order) {
        Order search = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order not found with id: " + id));
        Customer customer = customerRepository.findById(order.getCustomer().getId())
                .orElseThrow(() -> new NotFoundException("Customer not found with id: " + order.getCustomer().getId()));
        State state = stateRepository.findById(order.getState().getId())
                .orElseThrow(() -> new NotFoundException("State not found with id: " + order.getState().getId()));

        search.setCustomer(customer);
        search.setState(state);
        search.setTotal(order.getTotal());
        search.setDeliveryAddress(order.getDeliveryAddress());
        //search.setPersonId(order.getPersonId());

        return orderRepository.save(search);
    }

    @Override
    public void deleteOrder(int id) {
        Order search = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order not found with id: " + id));

        orderRepository.delete(search);
    }
}
