package com.Ecommerce.Ecommerce.Service;

import com.Ecommerce.Ecommerce.Bean.CartBean;

import java.util.List;

public interface CustomerCartService {
List<CartBean> getCart(int custid);
List<CartBean> saveCart(CartBean cartBean);
public  void deleteCart(int cartId);
public void updateCart(int cartId,int qunatity) throws Exception;


    //get list of products from cart table based on customerid
    //save list of products into cart table based on customerid
    //delete list of products into cart table based on customerid
    // update product quantity based on product id and customer id
}
