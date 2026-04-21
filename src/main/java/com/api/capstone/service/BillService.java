package com.api.capstone.service;

import com.api.capstone.model.Bill;

import java.util.List;

public interface BillService {
    List<Bill> getAllBills();
    Bill getBillById(int id);
    Bill createNewBill(Bill bill);
    Bill updateBill(int id, Bill bill);
    void deleteBill(int id);
}
