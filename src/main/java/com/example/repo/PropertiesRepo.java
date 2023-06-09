package com.example.repo;

import com.example.entities.Properties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface PropertiesRepo extends CrudRepository <Properties, Long> {
    List<Properties> findAll();
}
