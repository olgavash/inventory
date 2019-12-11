package com.inventory.models;

import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class CountSheet {

    @Id
    @GeneratedValue
    public int countId;
    private static final String DATEFORMAT = "MM/dd/yyyy";
    //    @CreatedDate
//    @Temporal(TemporalType.TIMESTAMP)
    public Date invDate;

    @Min(0)
    @Max(1000)
    private double count;

    public static String getCurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
        return sdf.format(new Date(System.currentTimeMillis()));
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private Product product;
//    private int productId;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn (name="productClassId", insertable = false, updatable = false)
//    private ProductClass productClass;


    public CountSheet() {
    }

    public CountSheet(double count) {
        this.count = count;
    }
//    public CountSheet(@Min(0) @Max(1000) double count) {
//        this.count = count;
//        this.invDate = null;
//        this.countId = 100;
//        this.product=null;
//    }

    public int getCountId() {
        return countId;
    }

    public void setCountId(int countId) {
        this.countId = countId;
    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }

    public double getCount() {
        return count;
    }
    public void setCount(double count) {
        this.count = count;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

//    public int getProductId() {
//        return productId;
//    }
//
//    public void setProductId(int productId) {
//        this.productId = productId;
//    }


}



