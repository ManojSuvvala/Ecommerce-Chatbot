package com.Ecommerce.Ecommerce.Repo;

import com.Ecommerce.Ecommerce.Bean.ProductDetailsBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailsRepo extends JpaRepository<ProductDetailsBean,Integer> {
    @Modifying
    @Query(value = "delete from PRODUCTDETAILS where PRODUCTDETAILS_ID in (:pids)",nativeQuery = true)
    void deleteproductDetails(List<Integer> pids);

}

