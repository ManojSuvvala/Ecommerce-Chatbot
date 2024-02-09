package com.Ecommerce.Ecommerce.Repo;

import com.Ecommerce.Ecommerce.Bean.ProductOwnerBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOwnerSignupRepo extends JpaRepository<ProductOwnerBean,Integer> {
    @Query(value = "select * from PRODUCTOWNER where EMAIL=:email", nativeQuery = true)
    List<ProductOwnerBean> findOwnerByEmail(String email);
}

