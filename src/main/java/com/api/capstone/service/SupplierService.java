package com.api.capstone.service;

import com.api.capstone.model.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAllSuppliers();
    Supplier getSupplierById(int id);
    Supplier createNewSupplier(Supplier supplier);
    Supplier updateSupplier(int id, Supplier supplier);
    void deleteSupplier(int id);
}
