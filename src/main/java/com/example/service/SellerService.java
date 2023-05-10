package com.example.service;


import com.example.entities.Seller;
import com.example.repo.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {
    @Autowired
    private SellerRepo sRepo;

    public SellerService(SellerRepo sRepo){
        this.sRepo = sRepo;
    }
    public SellerService(){

    }

    public List<Seller> getAll() {
        return this.sRepo.findAll();
    }


    public Seller getSeller(Long id) {

        return this.sRepo.findById(id).get();

    }


    public Seller createSeller (Seller seller){

        return this.sRepo.save(seller);

    }

    public Seller deleteSeller (Long id){
        Seller removed = this.getSeller(id);
        this.sRepo.deleteById(id);
        return removed;

    }

}