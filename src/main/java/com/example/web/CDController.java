package com.example.web;

import com.example.domain.CD;
import com.example.repository.CDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cd")
public class CDController {

    @Autowired
    private CDRepository cdRepository;

    @PostMapping("/addCd")
    public ResponseEntity<?> saveCd(@RequestBody CD cd){
        return new ResponseEntity<>(cdRepository.save(cd), HttpStatus.CREATED);
    }

    @RequestMapping("/")
    public String home(){
        return "Welcome to home page";
    }


}
