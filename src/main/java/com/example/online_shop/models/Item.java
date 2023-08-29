package com.example.online_shop.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity(name="items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private BigDecimal price; // test the precision of price calculation (TDD)

    @ManyToMany(mappedBy ="items")
    @JsonIgnoreProperties({"items"})
    private List<Order> orders;

//    @Column
//    private int inventory;   //extension
    
//    constructor
    public Item(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
//        this.orders = new ArrayList<>();
    }
//    empty constructor
    public Item(){}

//    getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
