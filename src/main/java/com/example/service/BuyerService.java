package com.example.service;

import com.example.entities.Buyer;
import com.example.repo.BuyerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerService {
    @Autowired
    private BuyerRepo bRepo;

    public BuyerService(BuyerRepo bRepo) {
        this.bRepo = bRepo;
    }

    public BuyerService() {

    }

    public List<Buyer> getAll() {
        return this.bRepo.findAll();
    }


    public Buyer getBuyer(Long id) {
        return this.bRepo.findById(id).get();

    }


    public Buyer createBuyer(Buyer buyer) {
        return this.bRepo.save(buyer);

    }

    public Buyer deleteBuyer(Long id) {
        Buyer removed = this.getBuyer(id);
        this.bRepo.deleteById(id);
        return removed;

    }

    public Buyer updateBuyer(Buyer newBuyer, Long id) {
        Optional<Buyer> buyer = bRepo.findById(id);
        buyer.get().setFirstName(newBuyer.getFirstName());
        buyer.get().setLastName(newBuyer.getLastName());
        buyer.get().setPhone(newBuyer.getPhone());
        buyer.get().setAddress(newBuyer.getAddress());
        buyer.get().setPostcode(newBuyer.getPostcode());
        buyer.get().setBudget(newBuyer.getBudget());
        return this.bRepo.save(buyer.get());
    }

}
