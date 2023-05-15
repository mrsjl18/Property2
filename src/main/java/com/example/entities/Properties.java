package com.example.entities;

import jakarta.persistence.*;

@Table (name = "properties")
@Entity
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer property_id;
    private String address;
    private String postcode;
    private String type;
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer garden;
    private Double price;
    private String status;

    @JoinColumn (name = "seller_id_fk")
    @ManyToOne
    private Seller seller;

    @ManyToOne
    private Buyer buyer;

    public Properties() {
    }

    public Properties(Integer id, String address, String postcode, String type, Integer bedrooms,
                      Integer bathrooms, Integer garden, Double price, String status, Seller seller) {
//        this.properties_id = id;
        this.address = address;
        this.postcode = postcode;
        this.type = type;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.garden = garden;
        this.price = price;
        this.status = status;
        this.seller = seller;
    }

//    public Integer getId() {
//        return properties_id;
//    }
//
//    public void setId(Integer id) {
//        this.properties_id = id;
//    }


    public Integer getProperty_id() {
        return property_id;
    }

    public void setProperty_id(Integer property_id) {
        this.property_id = property_id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Integer getGarden() {
        return garden;
    }

    public void setGarden(Integer garden) {
        this.garden = garden;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Properties{" +
//                "id=" + properties_id +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", type='" + type + '\'' +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                ", garden=" + garden +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", seller=" + seller +
                '}';
    }
}