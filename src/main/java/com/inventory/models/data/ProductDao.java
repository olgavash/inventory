package com.inventory.models.data;

import com.inventory.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public interface ProductDao extends CrudRepository<Product, Integer> {
//    ArrayList<Product> products = new ArrayList<>();
//
//    static ArrayList<Product> getAll() {
//        return products;
//    }

}
