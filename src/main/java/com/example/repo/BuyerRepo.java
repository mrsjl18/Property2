package com.example.repo;

import com.example.entities.Buyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyerRepo extends CrudRepository <Buyer, Long> {
    List<Buyer> findAll();
}
