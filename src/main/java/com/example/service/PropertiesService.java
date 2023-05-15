package com.example.service;

import com.example.entities.Properties;
import com.example.entities.Seller;
import com.example.repo.BuyerRepo;
import com.example.repo.PropertiesRepo;
import com.example.repo.SellerRepo;
import jakarta.persistence.EntityNotFoundException;
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
        Optional<Properties> propertyOpt = this.pRepo.findById(id);
        if (propertyOpt.isPresent()) return propertyOpt.get();
        throw new EntityNotFoundException("Property with ID" + id + " not found in database.");
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
//        Optional<Properties> properties = pRepo.findById(id);
        Properties property = this.getProperty(id);
        property.setAddress(newProperty.getAddress());
        property.setPostcode(newProperty.getPostcode());
        property.setPrice(newProperty.getPrice());
        property.setStatus(newProperty.getStatus());
        property.setBedrooms(newProperty.getBedrooms());
        property.setBathrooms(newProperty.getBathrooms());
        property.setGarden(newProperty.getGarden());
        property.setType(newProperty.getType());
        property.setSeller(newProperty.getSeller());


        return this.pRepo.save(property);
    }

    public Properties updatePartialProperty (Properties newUpdatedProperty, Long id) {
       Properties toUpdate = this.getProperty(id);
       toUpdate.setStatus(newUpdatedProperty.getStatus());
       return this.pRepo.save(toUpdate);
   }
}
