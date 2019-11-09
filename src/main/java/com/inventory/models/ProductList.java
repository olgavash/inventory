package com.inventory.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ProductList {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String vendor;

    @NotNull
    private String vendorProductNum;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String name;

    @NotNull
    private String purchaseUnitMesure;

    @NotNull
    private float costPerPurchaseUofM;

    @ManyToOne
    private ProductClass aClass;

    public ProductList(String vendor, String vendorProductNum,
                       String name, String purchaseUnitMesure, float costPerPurchaseUofM,
                       float previousUpdated, ProductClass aClass) {
        this.vendor = vendor;
        this.vendorProductNum = vendorProductNum;
        this.name = name;
        this.purchaseUnitMesure = purchaseUnitMesure;
        this.costPerPurchaseUofM = costPerPurchaseUofM;

        this.aClass = aClass;
    }

    public ProductList() { }

    public int getId() {
        return id;
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

    public String getPurchaseUnitMesure() {
        return purchaseUnitMesure;
    }

    public void setPurchaseUnitMesure(String purchaseUnitMesure) {
        this.purchaseUnitMesure = purchaseUnitMesure;
    }

    public float getCostPerPurchaseUofM() {
        return costPerPurchaseUofM;
    }

    public void setCostPerPurchaseUofM(float costPerPurchaseUofM) {
        this.costPerPurchaseUofM = costPerPurchaseUofM;
    }


    public ProductClass getaClass() {
        return aClass;
    }

    public void setaClass(ProductClass aClass) {
        this.aClass = aClass;
    }
}

