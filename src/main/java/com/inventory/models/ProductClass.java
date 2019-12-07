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

