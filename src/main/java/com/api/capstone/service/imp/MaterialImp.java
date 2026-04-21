package com.api.capstone.service.imp;

import com.api.capstone.exception.NotFoundException;
import com.api.capstone.model.Material;
import com.api.capstone.repository.MaterialRepository;
import com.api.capstone.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialImp implements MaterialService {

    @Autowired
    private MaterialRepository repository;

    @Override
    public List<Material> getAllMaterial() {
        return repository.findAll();
    }

    @Override
    public Material getMaterialById(int id) {
        Material material = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Material not found with id: " + id));

        return material;
    }

    @Override
    public Material createNewMaterial(Material material) {
        return repository.save(material);
    }

    @Override
    public Material updateMaterial(int id, Material material) {
        Material search = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Material not found with id: " + id));

        search.setName(material.getName());
        search.setStock(material.getStock());
        search.setMinStock(material.getMinStock());
        search.setPrice(material.getPrice());
        search.setUnitMeasurement(material.getUnitMeasurement());

        return repository.save(search);
    }

    @Override
    public void deleteMaterial(int id) {
        Material search = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Material not found with id: " + id));

        repository.delete(search);
    }
}
