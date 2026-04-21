package com.api.capstone.service;

import com.api.capstone.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();
    Person getPersonById(int id);
    Person createNewPerson(Person person);
    Person updatePerson(int id, Person person);
    void deletePerson(int id);
}
