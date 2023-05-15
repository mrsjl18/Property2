package com.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Table (name = "seller")
@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long seller_id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String postcode;

    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Properties> propertiesList;

    public Seller() {
    }

    public Seller(Long id, String firstName, String lastName,
                  String phone, String address, String postcode) {
        this.seller_id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.postcode = postcode;
    }

    public Long getId() {
        return seller_id;
    }

    public void setId(Long id) {
        this.seller_id = id;
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
        return "Seller{" +
                "id=" + seller_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
