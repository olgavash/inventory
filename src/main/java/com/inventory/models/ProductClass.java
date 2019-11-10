package com.inventory.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ProductClass {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id")
    private Set<Product> products = new HashSet<>();

    public ProductClass(@NotNull String name, Set<Product> products) {

        this.name = name;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Set<Product> getProducts() {
        return this.products;
    }

    public ProductClass() {
    }


}

