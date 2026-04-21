package com.api.capstone.service.imp;

import com.api.capstone.exception.NotFoundException;
import com.api.capstone.model.Material;
import com.api.capstone.model.Supplier;
import com.api.capstone.model.SupplierMaterial;
import com.api.capstone.repository.MaterialRepository;
import com.api.capstone.repository.SupplierMaterialRepository;
import com.api.capstone.repository.SupplierRepository;
import com.api.capstone.service.SupplierMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierMaterialImp implements SupplierMaterialService {
    @Autowired
    private SupplierMaterialRepository supplierMaterialRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public List<SupplierMaterial> getAllSupplierMaterial() {
        return supplierMaterialRepository.findAll();
    }

    @Override
    public SupplierMaterial getSupplierMaterialById(int id) {
        SupplierMaterial supplierMaterial = supplierMaterialRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("SupplierMaterial not found with id: " + id));
        return supplierMaterial;
    }

    @Override
    public SupplierMaterial createNewSupplierMaterial(SupplierMaterial supplierMaterial) {
        return supplierMaterialRepository.save(supplierMaterial);
    }

    @Override
    public SupplierMaterial updateSupplierMaterial(int id, SupplierMaterial supplierMaterial) {
        SupplierMaterial search = supplierMaterialRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("SupplierMaterial not found with id: " + id));

        Supplier supplier = supplierRepository.findById(supplierMaterial.getSupplier().getId())
                .orElseThrow(() -> new NotFoundException("Supplier not found with id: " + supplierMaterial.getSupplier().getId()));

        Material material = materialRepository.findById(supplierMaterial.getMaterial().getId())
                .orElseThrow(() -> new NotFoundException("Material not found with id: " + supplierMaterial.getMaterial().getId()));

        search.setSupplier(supplier);
        search.setMaterial(material);
        search.setCostPrice(supplierMaterial.getCostPrice());

        return supplierMaterialRepository.save(search);
    }

    @Override
    public void deleteSupplierMaterial(int id) {
        SupplierMaterial search = supplierMaterialRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("SupplierMaterial not found with id: " + id));

        supplierMaterialRepository.delete(search);
    }
}
