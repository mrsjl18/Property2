package com.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Table (name = "buyer")
@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long buyer_id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String postcode;
    private Double budget;

    @OneToMany(mappedBy = "buyer", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Properties> propertiesList;

    public Buyer() {
    }

    public Buyer(Long id, String firstName, String lastName,
                 String phone, String address, String postcode, Double budget) {
        this.buyer_id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.postcode = postcode;
        this.budget = budget;
    }

    public Long getId() {
        return buyer_id;
    }

    public void setId(Long id) {
        this.buyer_id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + buyer_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", budget=" + budget +
                '}';
    }
}
