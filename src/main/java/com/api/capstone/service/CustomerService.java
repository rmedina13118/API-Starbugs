package com.api.capstone.service;

import com.api.capstone.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);
    Customer createNewCustomer(Customer customer);
    Customer updateCustomer(int id, Customer customer);
    void deleteCustomer(int id);
}
