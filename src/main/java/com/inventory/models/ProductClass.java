package com.inventory.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductClass  {

//    MEAT ("Meat"),
//    DAIRY ("Dairy"),
//    PRODUCE ("Produce"),
//    BAKERY ("Bakery"),
//    GROCERY ("Grocery"),
//    BEVERAGE ("Beverage"),
//    PAPER ("Paper"),
//    JANITORIAL ("Janitorial");

    private final String name;

    @Id
    @GeneratedValue
    public int productClass_id;

    @OneToMany
    @JoinColumn(name = "name")
    private List<Product> products = new ArrayList<>();


    ProductClass(String name) {
        this.name = name;
    }

    public int getProductClass_id() {
        return productClass_id;
    }

    public void setProductClass_id(int productClass_id) {
        this.productClass_id = productClass_id;
    }

    public String getName() {
        return name;
    }
}

