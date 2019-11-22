package com.inventory.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private int product_id;

    @NotNull
    private String vendor;

    @NotNull
    private String vendorProductNum;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String name;

    @NotNull
    private String purchaseUnitMeasure;

    @NotNull
    private float costPerPurchaseUofM;

    @ManyToOne
//    @JoinColumn (name="className", nullable=false)
    private ArrayList<ProductClass> className;

    public Product(String vendor, String vendorProductNum,
                   String name, String purchaseUnitMeasure, float costPerPurchaseUofM) {

        this.vendor = vendor;
        this.vendorProductNum = vendorProductNum;
        this.name = name;
        this.purchaseUnitMeasure = purchaseUnitMeasure;
        this.costPerPurchaseUofM = costPerPurchaseUofM;

    }

    public Product() { }

    public int getProduct_id() {
        return product_id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendorProductNum() {
        return vendorProductNum;
    }

    public void setVendorProductNum(String vendorProductNum) {
        this.vendorProductNum = vendorProductNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurchaseUnitMeasure() {
        return purchaseUnitMeasure;
    }

    public void setPurchaseUnitMeasure(String purchaseUnitMeasure) {
        this.purchaseUnitMeasure = purchaseUnitMeasure;
    }

    public float getCostPerPurchaseUofM() {
        return costPerPurchaseUofM;
    }

    public void setCostPerPurchaseUofM(float costPerPurchaseUofM) {
        this.costPerPurchaseUofM = costPerPurchaseUofM;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public ArrayList<ProductClass> getClassName() {
        return className;
    }

    public void setClassName(ArrayList<ProductClass> className) {
        this.className = className;
    }
}

