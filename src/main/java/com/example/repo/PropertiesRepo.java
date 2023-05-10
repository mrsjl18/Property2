package com.example.repo;

import com.example.entities.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Properties;

@Repository
public interface PropertiesRepo extends CrudRepository <Properties, Long> {
    List<Properties> findAll();
}
