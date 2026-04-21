package com.api.capstone.service.imp;

import com.api.capstone.exception.NotFoundException;
import com.api.capstone.model.Bill;
import com.api.capstone.model.Order;
import com.api.capstone.repository.BillRepository;
import com.api.capstone.repository.OrderRepository;
import com.api.capstone.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillImp implements BillService {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public Bill getBillById(int id) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Bill not found with id: " + id));

        return bill;
    }

    @Override
    public Bill createNewBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Bill updateBill(int id, Bill bill) {
        Bill search = billRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Bill not found with id: " + id));

        Order order = orderRepository.findById(bill.getOrder().getId())
                .orElseThrow(() -> new NotFoundException("Order not found with id: " + id));

        search.setOrder(order);
        search.setPaymentMethod(bill.getPaymentMethod());
        search.setIssueDate(bill.getIssueDate());

        return billRepository.save(search);
    }

    @Override
    public void deleteBill(int id) {
        Bill search = billRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Bill not found with id: " + id));

        billRepository.delete(search);
    }
}
