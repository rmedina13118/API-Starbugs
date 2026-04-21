package com.api.capstone.service.imp;

import com.api.capstone.exception.NotFoundException;
import com.api.capstone.model.MaterialMovement;
import com.api.capstone.model.Order;
import com.api.capstone.model.Person;
import com.api.capstone.repository.MaterialMovementRepository;
import com.api.capstone.repository.OrderRepository;
import com.api.capstone.repository.PersonRepository;
import com.api.capstone.service.MaterialMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialMovementImp implements MaterialMovementService {
    @Autowired
    private MaterialMovementRepository materialMovementRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<MaterialMovement> getAllMaterialMovement() {
        return materialMovementRepository.findAll();
    }

    @Override
    public MaterialMovement getMaterialMovementById(int id) {
        MaterialMovement search = materialMovementRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("MaterialMovement not found with id: " + id));

        return search;
    }

    @Override
    public MaterialMovement createNewMaterialMovement(MaterialMovement materialMovement) {
        return materialMovementRepository.save(materialMovement);
    }

    @Override
    public MaterialMovement updateMaterialMovement(int id, MaterialMovement materialMovement) {
        MaterialMovement search = materialMovementRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("MaterialMovement not found with id: " + id));

        Person person = personRepository.findById(materialMovement.getPerson().getId())
                .orElseThrow(() -> new NotFoundException("Person not found with id: " + materialMovement.getPerson().getId()));

        Order order = orderRepository.findById(materialMovement.getOrder().getId())
                .orElseThrow(() -> new NotFoundException("Order not found with id: " + materialMovement.getOrder().getId()));

        search.setPerson(person);
        search.setOrder(order);
        search.setDate(materialMovement.getDate());
        search.setType(materialMovement.getType());
        search.setStock(materialMovement.getStock());

        return materialMovementRepository.save(search);
    }

    @Override
    public void deleteMaterialMovement(int id) {
        MaterialMovement search = materialMovementRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("MaterialMovement not found with id: " + id));

        materialMovementRepository.delete(search);
    }
}
