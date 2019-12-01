package com.inventory.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "ProductClass")
public class ProductClass  {

    @Id
    @GeneratedValue
    private int productClassId;

    private String description;


//    private ArrayList<String> productClass = new ArrayList<>();
//    {
//        productClass.add("Meat");
//        productClass.add("Dairy");
//        productClass.add("Produce");
//        productClass.add("Bakery");
//        productClass.add("Grocery");
//        productClass.add("Beverage");
//        productClass.add("Paper");
//        productClass.add("Janitorial");
//    }

//    @OneToMany(mappedBy = "productClass", cascade = CascadeType.ALL)
//    private List<Product> products;


    public int getProductClassId() {
        return productClassId;
    }

    public void setProductClassId(int productClassId) {
        this.productClassId = productClassId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

