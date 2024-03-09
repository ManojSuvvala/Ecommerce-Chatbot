package com.Ecommerce.Ecommerce.Repo;

import com.Ecommerce.Ecommerce.Bean.ProductSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductSubCategoryRepo extends JpaRepository<ProductSubCategory,Integer> {
    @Query(value = "SELECT  S_PROD_ID, SUB_CATEGORY FROM PRODUCT_SUBCATEGORY",nativeQuery = true)
    List<ProductSubCategory> fetch();
}
