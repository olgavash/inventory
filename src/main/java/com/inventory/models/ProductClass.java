package com.inventory.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductClass  {

    @Id
    @GeneratedValue
    public int productClass_id;

    private ArrayList<String>  className = new ArrayList<String>();
    {
        className.add("Meat");
        className.add("Dairy");
        className.add("Produce");
        className.add("Bakery");
        className.add("Grocery");
        className.add("Beverage");
        className.add("Paper");
        className.add("Janitorial");
    }

    @OneToMany
    @JoinColumn(name = "name")
    private List<Product> products = new ArrayList<>();

    public ProductClass() {}

    public ProductClass(int productClass_id, ArrayList<String> className, List<Product> products) {
        this.productClass_id = productClass_id;
        this.className = className;
        this.products = products;
    }

    public int getProductClass_id() {
        return productClass_id;
    }

    public void setProductClass_id(int productClass_id) {
        this.productClass_id = productClass_id;
    }

    public ArrayList<String> getClassName() {
        return className;
    }

    public void setClassName(ArrayList<String> className) {
        this.className = className;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

