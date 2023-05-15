package com.example.controller;


import com.example.entities.Properties;
import com.example.repo.PropertiesRepo;
import com.example.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/properties")
public class PropertiesController {

    @Autowired
    PropertiesRepo pRepo;

    @Autowired
    PropertiesService pService;

    // A ResponseEntity<T> represents a HTTP response message where T is the type of
    //   data in the body
    // - controller methods return a ResponseEntity by default, even if we set the return type to
    //   void - on a void return, Spring Boot will just generate the response object

    @GetMapping("/read")
    public ResponseEntity<List<Properties>> read() {
        return new ResponseEntity<>(pService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/readOne/{id}")
    public Properties readOne(@PathVariable Long id ) {
        return pService.getProperty(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Properties> add(@RequestBody Properties newProperties){
        return new ResponseEntity<>(pService.createProperty(newProperties), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id ) {
        pService.deleteProperty(id);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody Properties newProperty, @PathVariable Long id) {
        pService.updateProperty(newProperty, id);
    }

    @PatchMapping("/update/{id}")
    public void updateStatus(@RequestBody Properties newProperty, @PathVariable("id") Long id) {
        pService.updatePartialProperty(newProperty, id);
    }

}
