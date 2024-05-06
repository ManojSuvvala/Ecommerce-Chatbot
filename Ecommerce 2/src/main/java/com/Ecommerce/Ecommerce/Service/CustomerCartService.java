package com.Ecommerce.Ecommerce.Service;

import com.Ecommerce.Ecommerce.Bean.CartBean;

import java.util.List;

public interface CustomerCartService {
List<CartBean> getCart(int custid);
List<CartBean> saveCart(CartBean cartBean);
public  void deleteCart(int cartId);
public void updateCart(int cartId,int qunatity) throws Exception;

public void clearCart (int custid);



}
