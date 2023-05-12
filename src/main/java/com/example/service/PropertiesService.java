package com.example.service;

import com.example.entities.Properties;
import com.example.entities.Seller;
import com.example.repo.BuyerRepo;
import com.example.repo.PropertiesRepo;
import com.example.repo.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PropertiesService {
    @Autowired
    private PropertiesRepo pRepo;
    @Autowired
    private BuyerRepo bRepo;
    @Autowired
    private SellerRepo sRepo;

    public PropertiesService(PropertiesRepo pRepo,
                             BuyerRepo bRepo, SellerRepo sRepo) {
        this.pRepo = pRepo;
        this.bRepo = bRepo;
        this.sRepo = sRepo;
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
        Optional<Seller> seller = this.sRepo.findById(properties.getSeller().getId());
        properties.setSeller(seller.get());
        return this.pRepo.save(properties);

    }


    public Properties deleteProperty (Long id){
        Properties removed = this.getProperty(id);
        this.pRepo.deleteById(id);
        return removed;

    }

    public Properties updateProperty(Properties newProperty, Long id) {
        Optional<Properties> properties = pRepo.findById(id);
        properties.get().setAddress(newProperty.getAddress());
        properties.get().setPostcode(newProperty.getPostcode());
        properties.get().setPrice(newProperty.getPrice());
        properties.get().setStatus(newProperty.getStatus());
        properties.get().setBedrooms(newProperty.getBedrooms());
        properties.get().setBathrooms(newProperty.getBathrooms());
        properties.get().setGarden(newProperty.getGarden());
        properties.get().setType(newProperty.getType());
        properties.get().setSeller(newProperty.getSeller());


        return this.pRepo.save(properties.get());
    }
}
