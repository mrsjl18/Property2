package com.example.controller;


import com.example.entities.Properties;
import com.example.repo.PropertiesRepo;
import com.example.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertiesController {

    @Autowired
    PropertiesRepo pRepo;

    @Autowired
    PropertiesService pService;

    @GetMapping("/read")
    public List<Properties> read() {
        return pService.getAll();
    }

    @GetMapping("/readOne/{id}")
    public Properties readOne(@PathVariable Long id ) {
        return pService.getProperty(id);
    }

    @PostMapping("/add")
    public Properties add(@RequestBody Properties newProperties){
        return pService.createProperty(newProperties);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id ) {
        pService.deleteProperty(id);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody Properties newProperty, @PathVariable Long id) {
        pService.updateProperty(newProperty, id);
    }

}
