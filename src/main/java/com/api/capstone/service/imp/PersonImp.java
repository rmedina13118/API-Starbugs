package com.api.capstone.service.imp;

import com.api.capstone.exception.NotFoundException;
import com.api.capstone.model.Person;
import com.api.capstone.model.Role;
import com.api.capstone.repository.PersonRepository;
import com.api.capstone.repository.RoleRepository;
import com.api.capstone.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonImp implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(int id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Person not found with id: " + id));

        return person;
    }

    @Override
    public Person createNewPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(int id, Person person) {
        Person search = personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Person not found with id: " + id));
        Role role = roleRepository.findById(person.getRole().getId())
                .orElseThrow(() -> new NotFoundException("Rol not found with id: " + person.getRole().getId()));


        search.setName(person.getName());
        search.setEmail(person.getEmail());
        search.setPhone(person.getPhone());

        search.setRole(role);

        return personRepository.save(search);
    }

    @Override
    public void deletePerson(int id) {
        Person search = personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Person not found with id: " + id));

        personRepository.delete(search);
    }
}
