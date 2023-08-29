package com.example.online_shop.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
//NOTE: clarify what relationship type it is and draw an erd diagram
    @ManyToMany
    @JsonIgnoreProperties({"orders"})
    @JoinTable(
            name = "orders_items",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")}
    )
    private List<Item> items;
    @Column
    private BigDecimal totalPrice;

    @Column
    private Boolean orderPlaced;

//    constructor
    public Order (){
        this.items = new ArrayList<>();
        this.totalPrice = BigDecimal.valueOf(0.00);
        this.orderPlaced = false;
    }

//    getters and setters

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getOrderPlaced() {
        return orderPlaced;
    }

    public void setOrderPlaced(Boolean orderPlaced) {
        this.orderPlaced = orderPlaced;
    }

    //    methods
    public int getItemCount() {
        return this.items.size();

    }

}
