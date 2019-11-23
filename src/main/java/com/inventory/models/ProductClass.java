package com.inventory.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductClass  {

    @Id
    @GeneratedValue
    private int productClass_id;

    private ArrayList<String>  productClass = new ArrayList<String>();
    {
        productClass.add("Meat");
        productClass.add("Dairy");
        productClass.add("Produce");
        productClass.add("Bakery");
        productClass.add("Grocery");
        productClass.add("Beverage");
        productClass.add("Paper");
        productClass.add("Janitorial");
    }

    @OneToMany(mappedBy = "productClass", fetch = FetchType.LAZY)
    private List<Product> products;

    public ProductClass() {}

    public ProductClass(int productClass_id, ArrayList<String> productClass, List<Product> products) {
        this.productClass_id = productClass_id;
        this.productClass = productClass;
        this.products = products;
    }

    public int getProductClass_id() {
        return productClass_id;
    }

    public void setProductClass_id(int productClass_id) {
        this.productClass_id = productClass_id;
    }

    public ArrayList<String> getProductClass() {
        return productClass;
    }

    public void setProductClass(ArrayList<String> productClass) {
        this.productClass = productClass;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

