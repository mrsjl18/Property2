package com.example.controller;

import com.example.entities.Buyer;
import com.example.repo.BuyerRepo;
import com.example.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/buyers")
public class BuyerController {

    @Autowired
    BuyerRepo bRepo;

    @Autowired
    BuyerService bService;

    @GetMapping("/read")
    public List<Buyer> read() {
        return bService.getAll();
    }

    @GetMapping("/readOne/{id}")
    public Buyer readOne(@PathVariable Long id ) {
        return bService.getBuyer(id);
    }

    @PostMapping("/add")
    public Buyer add(@RequestBody Buyer newBuyer){
        return bService.createBuyer(newBuyer);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id ) {
        bService.deleteBuyer(id);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody Buyer newBuyer, @PathVariable Long id) {
        bService.updateBuyer(newBuyer, id);
    }

}
