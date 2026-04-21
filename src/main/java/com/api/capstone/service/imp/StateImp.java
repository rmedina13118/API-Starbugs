package com.api.capstone.service.imp;

import com.api.capstone.exception.NotFoundException;
import com.api.capstone.model.State;
import com.api.capstone.repository.StateRepository;
import com.api.capstone.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateImp implements StateService {

    @Autowired
    private StateRepository repository;

    @Override
    public List<State> getAllStates() {
        return repository.findAll();
    }

    @Override
    public State getStateById(int id) {
        State state = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("State not found with id: " + id));

        return state;
    }

    @Override
    public State createNewState(State state) {
        return repository.save(state);
    }

    @Override
    public State updateState(int id, State state) {
        State search = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("State not found with id: " + id));

        search.setName(state.getName());
        search.setDescription(state.getDescription());

        return repository.save(search);
    }

    @Override
    public void deleteState(int id) {
        State search = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("State not found with id: " + id));

        repository.delete(search);
    }
}
