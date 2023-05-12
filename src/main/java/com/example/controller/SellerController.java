package com.example.controller;

import com.example.entities.Seller;
import com.example.repo.SellerRepo;
import com.example.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    SellerRepo sRepo;

    @Autowired
    SellerService sService;

    @GetMapping("/read")
    public List<Seller> read() {
        return sService.getAll();
    }

    @GetMapping("/readOne/{id}")
    public Seller readOne(@PathVariable Long id ) {
        return sService.getSeller(id);
    }

    @PostMapping("/add")
    public Seller add(@RequestBody Seller newSeller){
        return sService.createSeller(newSeller);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id ) {
        sService.deleteSeller(id);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody Seller newSeller, @PathVariable Long id) {
        sService.updateSeller(newSeller, id);
    }

}
