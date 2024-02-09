package com.Ecommerce.Ecommerce.Repo;

import com.Ecommerce.Ecommerce.Bean.CustInformationBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HomePageSignUpRepo extends JpaRepository<CustInformationBean,Integer> {
    @Query(value = "select * from CUSTOMERINFORMATION where EMAIL=:email", nativeQuery = true)
    List<CustInformationBean> findCustomerByEmail(String email);
}
