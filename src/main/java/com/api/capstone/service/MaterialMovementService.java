package com.api.capstone.service;

import com.api.capstone.model.MaterialMovement;

import java.util.List;

public interface MaterialMovementService {
    List<MaterialMovement> getAllMaterialMovement();
    MaterialMovement getMaterialMovementById(int id);
    MaterialMovement createNewMaterialMovement(MaterialMovement materialMovement);
    MaterialMovement updateMaterialMovement(int id, MaterialMovement materialMovement);
    void deleteMaterialMovement(int id);
}
