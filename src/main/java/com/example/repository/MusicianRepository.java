package com.example.repository;

import com.example.domain.Musician;
import org.springframework.data.repository.CrudRepository;

public interface MusicianRepository extends CrudRepository<Musician,Long> {
}
