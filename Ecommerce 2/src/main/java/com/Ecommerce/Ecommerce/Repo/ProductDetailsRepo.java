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
    @Modifying
    @Query(value = "UPDATE PRODUCTDETAILS SET PRODUCT_QUANTITY=:QUANTITY WHERE PRODUCTDETAILS_ID =:pid",nativeQuery = true)
    void updateProductQuantity(int QUANTITY, int pid);
    @Query(value = "select * from PRODUCTDETAILS where PRODUCTDETAILS_ID=(select CART_PRODUCTDETAILS_ID from CART where CART_ID=:cid)",nativeQuery = true)
    ProductDetailsBean findProductByCartId(int cid);
    @Query(value = "SELECT PRODUCTDETAILS_ID FROM PRODUCTDETAILS WHERE PRODUCTDETAILS_ID IS NOT NULL", nativeQuery = true)
    List<Integer> findNonNullProductDetailsIds();
    @Modifying
    @Query(value = "UPDATE PRODUCTDETAILS SET PRODUCT_IMAGE=:imageBytes WHERE PRODUCTDETAILS_ID=:pDetailsId",nativeQuery = true)
    void updateProdImage(byte[] imageBytes , int pDetailsId);

    @Query(value = "SELECT * FROM PRODUCTDETAILS WHERE PO_ID=:poid", nativeQuery = true)
    List<ProductDetailsBean> getProductDetailsById(int poid);

    @Query(value = "SELECT * FROM PRODUCTDETAILS", nativeQuery = true)
    List<ProductDetailsBean> getAllProductDetails();



}

