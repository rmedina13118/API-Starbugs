package com.api.capstone.service.imp;

import com.api.capstone.exception.NotFoundException;
import com.api.capstone.model.Supplier;
import com.api.capstone.repository.SupplierRepository;
import com.api.capstone.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierImp implements SupplierService {

    @Autowired
    private SupplierRepository repository;

    @Override
    public List<Supplier> getAllSuppliers() {
        return repository.findAll();
    }

    @Override
    public Supplier getSupplierById(int id) {
        Supplier supplier = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Supplier not found with id: " + id));
        return supplier;
    }

    @Override
    public Supplier createNewSupplier(Supplier supplier) {
        return repository.save(supplier);
    }

    @Override
    public Supplier updateSupplier(int id, Supplier supplier) {
        Supplier search = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Supplier not found with id: " + id));

        search.setName(supplier.getName());
        search.setEmail(supplier.getEmail());
        search.setPhone(supplier.getPhone());
        search.setStreet(supplier.getStreet());
        search.setNumberStreet(supplier.getNumberStreet());
        search.setCity(supplier.getCity());
        search.setZipCode(supplier.getZipCode());

        return repository.save(search);
    }

    @Override
    public void deleteSupplier(int id) {
        Supplier search = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Supplier not found with id: " + id));

        repository.delete(search);
    }
}
