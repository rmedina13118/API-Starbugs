package com.api.capstone.service.imp;

import com.api.capstone.exception.NotFoundException;
import com.api.capstone.model.Customer;
import com.api.capstone.repository.CustomerRepository;
import com.api.capstone.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerImp implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found with id: " + id));

        return customer;
    }

    @Override
    public Customer createNewCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer updateCustomer(int id, Customer customer) {
        Customer search = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found with id: " + id));

        search.setName(customer.getName());
        search.setEmail(customer.getEmail());
        search.setPhone(customer.getPhone());

        return repository.save(search);
    }

    @Override
    public void deleteCustomer(int id) {
        Customer search = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found with id: " + id));

        repository.delete(search);
    }
}
