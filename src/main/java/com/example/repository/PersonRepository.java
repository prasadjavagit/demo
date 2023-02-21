package com.example.repository;

import com.example.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {
    Person findByPid(Long pid);
    List<Person> findAll();
}
