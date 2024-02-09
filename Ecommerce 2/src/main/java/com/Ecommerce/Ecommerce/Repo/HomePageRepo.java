package com.Ecommerce.Ecommerce.Repo;

import com.Ecommerce.Ecommerce.Bean.ProductCategoryBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomePageRepo extends JpaRepository<ProductCategoryBean,Integer> {
    @Query(value = "SELECT  PRODUCT_ID, CATEGORY FROM PRODUCT_CATEGORY",nativeQuery = true)
    List<ProductCategoryBean> fetchp();
}
