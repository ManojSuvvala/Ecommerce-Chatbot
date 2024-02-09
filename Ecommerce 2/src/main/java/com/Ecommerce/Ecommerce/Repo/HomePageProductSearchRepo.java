package com.Ecommerce.Ecommerce.Repo;

import com.Ecommerce.Ecommerce.Bean.ProductDetailsBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomePageProductSearchRepo extends JpaRepository<ProductDetailsBean,String> {
      @Query(value = "SELECT * FROM PRODUCTDETAILS WHERE PRODUCT_NAME LIKE %:keywords% OR DESCRIPTION LIKE %:keywords%",nativeQuery = true)

    List<ProductDetailsBean> searchProducts(@Param("keywords") String keywords);
}

