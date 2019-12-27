package com.inventory.models.data;

import com.inventory.models.CountSheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CountSheetDao extends CrudRepository<CountSheet, Integer> {
    @Query(value = "SELECT * FROM COUNT_SHEET a WHERE INV_DATE IN (SELECT MAX(INV_DATE) FROM COUNT_SHEET WHERE PRODUCT_ID=a.PRODUCT_ID)", nativeQuery = true)
//        ArrayList<CountSheet> findByInvDate();
////    Optional<CountSheet> findByLastInvDate(Date invDate);
//    List<CountSheet> findTopByOrderByInvDateDesc();
    ArrayList<CountSheet> findAllByOrderByInvDateDesc();
}
