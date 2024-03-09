package com.Ecommerce.Ecommerce.ServImpl;

import com.Ecommerce.Ecommerce.Bean.CartBean;
import com.Ecommerce.Ecommerce.Bean.ProductDetailsBean;
import com.Ecommerce.Ecommerce.Repo.CartRepo;
import com.Ecommerce.Ecommerce.Repo.ProductDetailsRepo;
import com.Ecommerce.Ecommerce.Service.CustomerCartService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class CartImpl implements CustomerCartService {

    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private ProductDetailsRepo productDetailsRepo;
    @Override
    public List<CartBean> getCart(int custid) {
        List<CartBean> cartBeanList =cartRepo.fetchp(custid);
        return cartBeanList;
    }

    @Override
    public List<CartBean> saveCart(CartBean cartBean) {
        ProductDetailsBean productDetails = cartBean.getCartPdetailsId();
        productDetailsRepo.save(productDetails);
        cartRepo.save(cartBean);
        List<CartBean> cartBeanList = new ArrayList<>();
        cartBeanList.add(cartBean);
        return getCart(cartBean.getCartCustId().getCid());
    }

    @Override
    public void deleteCart(int cartId) {
        cartRepo.deleteById(cartId);
    }

    @Override
    public void updateCart(int cartId, int quantity) throws Exception {
        ProductDetailsBean productDetailsBean=productDetailsRepo.findProductByCartId(cartId);
        int pQuantity=productDetailsBean.getQuantity();
        if(pQuantity>0 && (pQuantity-quantity)>=0){
            productDetailsRepo.updateProductQuantity(pQuantity-quantity,productDetailsBean.getPDetailsId());
            cartRepo.updateCart(cartId,quantity);
        }else{
            throw new Exception("Sorry Product is Out of Stock");
        }
    }


}

