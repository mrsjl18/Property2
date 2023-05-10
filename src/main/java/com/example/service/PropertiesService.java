package com.example.service;

import com.example.entities.Properties;
import com.example.repo.PropertiesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PropertiesService {
    @Autowired
    private PropertiesRepo pRepo;

    public PropertiesService(PropertiesRepo pRepo){
        this.pRepo = pRepo;
    }
    public PropertiesService(){

    }

    public List<Properties> getAll() {
        return this.pRepo.findAll();
    }


    public Properties getProperty(Long id) {
        return this.pRepo.findById(id).get();

    }


    public Properties createProperty (Properties properties){
        return this.pRepo.save(properties);

    }

    public Properties deleteProperty (Long id){
        Properties removed = this.getProperty(id);
        this.pRepo.deleteById(id);
        return removed;

    }

    /*public Seller updateSeller (Long id) {
        Optional<Seller> seller = sRepo.findById(id);
        seller.get().setFirstName(newSeller.getFirstName());
        seller.get().setLastName(newSeller.getLastName());
        sRepo.save(seller.get());
    }*/

}
