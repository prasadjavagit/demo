package com.example.repository;

import com.example.domain.CD;
import com.example.domain.Musician;
import org.springframework.data.repository.CrudRepository;

public interface CDRepository extends CrudRepository<CD,Long> {

}
