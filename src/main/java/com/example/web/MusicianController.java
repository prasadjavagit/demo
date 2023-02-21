package com.example.web;

import com.example.domain.Musician;
import com.example.repository.MusicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/musician")
public class MusicianController {

    @Autowired
    private MusicianRepository musicianRepository;
    @PostMapping("/addMusician")
    public ResponseEntity<?> saveMusician(@RequestBody Musician musician){
        return new ResponseEntity<>(musicianRepository.save(musician), HttpStatus.CREATED);
    }
}
