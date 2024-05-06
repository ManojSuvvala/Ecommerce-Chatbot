package com.Ecommerce.Ecommerce.Repo;

import com.Ecommerce.Ecommerce.Bean.CustInformationBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomePageLoginRepo extends JpaRepository<CustInformationBean,Integer> {
    @Query(value = "select * from CUSTOMERINFORMATION where EMAIL= ?1 and PASSWORD= ?2", nativeQuery = true)
    List<CustInformationBean> findCustomerByCredentials(String email, String password);

    @Query(value="select c_id from CUSTOMERINFORMATION where EMAIL=:email", nativeQuery = true)
    int  findCustomerIdByEmail(String email);

    @Query(value="select PO_ID from PRODUCTOWNER where EMAIL=:email", nativeQuery = true)
    int  findProdOwnerIdByEmail(String email);
}

