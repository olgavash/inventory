package com.inventory.models.data;

import com.inventory.models.ProductClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProductClassDao extends CrudRepository<ProductClass, Integer> {
}
