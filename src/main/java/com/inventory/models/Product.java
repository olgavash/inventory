package com.inventory.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private int productId;

    @NotNull
    @Size(min=1, message = "Name must not be empty")
    private String name;

    @NotNull
    private String vendor;

    @NotNull
    private String vendorProductNum;


    @NotNull
    private String purchaseUnitMeasure;

    @NotNull
    private float costPerPurchaseUofM;


//    @ManyToOne (cascade = {CascadeType.DETACH, CascadeType.MERGE,
//            CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
//    @JoinColumn (name="productClassId")
    private int productClassId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn (name="productClassId", insertable = false, updatable = false)
    private ProductClass productClass;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn (name="countId", insertable = false, updatable = false)
    private CountSheet countSheet;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public int getProductClassId() {
        return productClassId;
    }

    public void setProductClassId(int productClassId) {
        this.productClassId = productClassId;
    }


    public ProductClass getProductClass() {
        return productClass;
    }

    public void setProductClass(com.inventory.models.ProductClass productClass) {
        this.productClass = productClass;
    }

    public CountSheet getCountSheet() {
        return countSheet;
    }

    public void setCountSheet(CountSheet countSheet) {
        this.countSheet = countSheet;
    }
}

