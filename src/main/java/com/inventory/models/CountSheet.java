package com.inventory.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class CountSheet {

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
    private String unitOfMesure;

    private float previousCount;

    private float count;

    @ManyToOne
    private ProductClass aClass;


    public CountSheet(String vendor, String vendorProductNum,
                      String name, String unitOfMesure, float previousCount,
                      float count) {
        this.vendor = vendor;
        this.vendorProductNum = vendorProductNum;
        this.name = name;
        this.unitOfMesure = unitOfMesure;
        this.previousCount = previousCount;
        this.count = count;

    }


    public CountSheet() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUnitOfMesure() {
        return unitOfMesure;
    }

    public void setUnitOfMesure(String unitOfMesure) {
        this.unitOfMesure = unitOfMesure;
    }

    public float getPreviousCount() {
        return previousCount;
    }

    public void setPreviousCount(float previousCount) {
        this.previousCount = previousCount;
    }

    public float getCount() {
        return count;
    }

    public void setCount(float count) {
        this.count = count;
    }

    public ProductClass getaClass() {
        return aClass;
    }

    public void setaClass(ProductClass aClass) {
        this.aClass = aClass;
    }
}