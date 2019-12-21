package com.inventory.models.data;

import com.inventory.models.CountSheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CountSheetDao extends CrudRepository<CountSheet, Integer> {

}
