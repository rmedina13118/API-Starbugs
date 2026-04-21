package com.api.capstone.service;

import com.api.capstone.model.SupplierMaterial;

import java.util.List;

public interface SupplierMaterialService {
    List<SupplierMaterial> getAllSupplierMaterial();
    SupplierMaterial getSupplierMaterialById(int id);
    SupplierMaterial createNewSupplierMaterial(SupplierMaterial supplierMaterial);
    SupplierMaterial updateSupplierMaterial(int id, SupplierMaterial supplierMaterial);
    void deleteSupplierMaterial(int id);
}
