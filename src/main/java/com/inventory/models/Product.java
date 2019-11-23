package com.inventory.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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


    @ManyToOne (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn (name="productClass_id")
    private ProductClass productClass;

    public Product() { }

    public Product(int product_id, @NotNull String vendor, @NotNull String vendorProductNum,
                   @NotNull @Size(min = 1, message = "Description must not be empty") String name,
                   @NotNull String purchaseUnitMeasure, @NotNull float costPerPurchaseUofM,
                   ProductClass productClass) {
        this.product_id = product_id;
        this.vendor = vendor;
        this.vendorProductNum = vendorProductNum;
        this.name = name;
        this.purchaseUnitMeasure = purchaseUnitMeasure;
        this.costPerPurchaseUofM = costPerPurchaseUofM;
        this.productClass = productClass;
    }


    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
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

    public ProductClass getProductClass() {
        return productClass;
    }

    public void setProductClass(ProductClass productClass) {
        this.productClass = productClass;
    }
}

