package com.inventory.models;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class CountSheet {


    @Id
    @GeneratedValue
    private int countId;
    private static final String DATEFORMAT = "MM/dd/yyyy";
    private Date invDate;
    private double count;

    public static String getCurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
        return sdf.format(new Date(System.currentTimeMillis()));
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", insertable = false, updatable = false)
    private Product product;
    private int productId;

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
//        return count;
    }

//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

//    public ProductClass getProductClass() {
//        return productClass;
//    }
//
//    public void setProductClass(ProductClass productClass) {
//        this.productClass = productClass;
//    }

    //    public void addProduct(Product product) {
//        this.products.add(product);
//    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}



