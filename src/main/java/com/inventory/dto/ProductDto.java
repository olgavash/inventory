package com.inventory.dto;

import com.inventory.models.Product;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private String productId;
    @NotNull
    @Size(min=1, message = "Name must not be empty")
    private String name;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static ProductDto valueOf(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(String.valueOf(product.getProductId()));
        productDto.setName(String.valueOf(product.getName()));

        return productDto;
    }


    @Override
    public String toString() {
        return this.getClass().getName() + " [productId=" + productId + ", name=" + name + "]";
    }


}


