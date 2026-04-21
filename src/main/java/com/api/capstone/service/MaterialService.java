package com.api.capstone.service;

import com.api.capstone.model.Material;

import java.util.List;

public interface MaterialService {
    List<Material> getAllMaterial();
    Material getMaterialById(int id);
    Material createNewMaterial(Material material);
    Material updateMaterial(int id, Material material);
    void deleteMaterial(int id);
}
