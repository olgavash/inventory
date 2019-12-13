package com.inventory.dto;


import com.inventory.models.CountSheet;
import com.inventory.models.Product;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class CountSheetDto implements Serializable {

    private static final long serialVersionUID = 1L;

//    private List<CountSheet> counts;
//
//    public CountSheetListDto() {
//        this.counts = new ArrayList<>();
//    }
//
//    public CountSheetListDto(List<CountSheet> counts) {
//        this.counts = counts;
//    }
////    for (CountSheet item : counts) {
////        item.setInvDate(new Date(System.currentTimeMillis()));
////    }
//    public List<CountSheet> getCounts() {
//        return counts;
//    }
//
//    public void setCounts(List<CountSheet> counts) {
//        this.counts = counts;
//    }
//
//    public void addCount(CountSheet count) {
//        this.counts.add(count);
//    }
//
//    public int size() {
//        int size = counts.size();
//        return size;
//    }

    private int countId;
    private int productId;
//    private List<Product> products;
    private Date invDate;
    private double count;


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public int getCountId() {
        return countId;
    }

    public void setCountId(int countId) {
        this.countId = countId;
    }

    //    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }


}