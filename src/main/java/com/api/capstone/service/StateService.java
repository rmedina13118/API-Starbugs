package com.api.capstone.service;

import com.api.capstone.model.Role;
import com.api.capstone.model.State;

import java.util.List;

public interface StateService {
    List<State> getAllStates();
    State getStateById(int id);
    State createNewState(State state);
    State updateState(int id, State state);
    void deleteState(int id);
}
