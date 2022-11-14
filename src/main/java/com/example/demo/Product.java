package com.example.demo;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    @ManyToOne
    Wisher wisher;

    public Product() {
    }

    public Product(Long id, String title, Integer price) {
        this.id = id;
        this.name = title;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Wisher getWisher() {
        return wisher;
    }

    public void setWisher(Wisher wisher) {
        this.wisher = wisher;
    }
}
