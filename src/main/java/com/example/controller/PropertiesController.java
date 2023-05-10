package com.example.controller;

import com.example.entities.Seller;
import com.example.repo.PropertiesRepo;
import com.example.repo.SellerRepo;
import com.example.service.PropertiesService;
import com.example.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;

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

    /*@PutMapping("/update/{id}")
    public void update(@RequestBody Seller newSeller, @PathVariable Long id) {
        sService.updateSeller(id);
    }*/

}
