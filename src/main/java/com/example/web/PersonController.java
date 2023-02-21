package com.example.web;

import com.example.domain.Person;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/addPerson")
    public ResponseEntity<?> addPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED);
    }

    @GetMapping("/{pid}")
    public ResponseEntity<?> getPerson(@PathVariable Long pid) {
        Person per = personRepository.findByPid(pid);
        return new ResponseEntity<>(per, HttpStatus.OK);
    }

    @DeleteMapping("/{pid}")
    public ResponseEntity<?> deletePerson(@PathVariable Long pid) {
        personRepository.deleteById(pid);
        return new ResponseEntity<>("Person with id " + pid + " was deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{pid}")
    public ResponseEntity<?> updatePerson(@PathVariable Long pid, @RequestBody Person person) {
        personRepository.save(person);
        return new ResponseEntity<>(personRepository.findByPid(pid), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
