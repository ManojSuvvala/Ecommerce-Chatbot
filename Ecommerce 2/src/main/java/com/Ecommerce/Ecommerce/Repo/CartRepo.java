package com.Ecommerce.Ecommerce.Repo;

import com.Ecommerce.Ecommerce.Bean.CartBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<CartBean,Integer> {
    @Query(value = "SELECT * FROM CART  WHERE CART_CUSTOMER_ID=:custid",nativeQuery = true)
    List<CartBean> fetchp(int custid);
    @Modifying
    @Query(value = "UPDATE CART SET QUANTITY =QUANTITY+(:QUVT) WHERE CART_ID=:custid",nativeQuery = true)
    void updateCart(int custid, int QUVT);

    @Modifying
    @Query(value="DELETE FROM CART WHERE CART_CUSTOMER_ID=:cartcustid",nativeQuery = true)
    void allclearCart(int cartcustid);
}

