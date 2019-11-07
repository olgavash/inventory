package com.inventory.models.data;

import com.inventory.models.ProductList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProductListDao extends CrudRepository<ProductList, Integer> {
}
