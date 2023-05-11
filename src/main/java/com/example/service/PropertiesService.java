package com.example.service;

import com.example.entities.Properties;
import com.example.repo.PropertiesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

    public Properties updateProperty(Properties newProperty, Long id) {
        Optional<Properties> properties = pRepo.findById(id);
        properties.get().setAddress(newProperty.getAddress());
        properties.get().setPostcode(newProperty.getPostcode());
        properties.get().setPrice(newProperty.getPrice());
        properties.get().setStatus(newProperty.getStatus());
        return this.pRepo.save(properties.get());
    }
}
