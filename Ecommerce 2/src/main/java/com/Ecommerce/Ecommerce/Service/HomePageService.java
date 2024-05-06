package com.Ecommerce.Ecommerce.Service;


import com.Ecommerce.Ecommerce.Bean.CustInformationBean;
import com.Ecommerce.Ecommerce.Bean.ProductCategoryBean;
import com.Ecommerce.Ecommerce.Bean.ProductDetailsBean;
import org.apache.coyote.BadRequestException;

import java.sql.SQLException;
import java.util.List;
    public interface HomePageService {

        List<ProductCategoryBean> productCategory();

        String getCustLogin(String uname, String password) throws SQLException, ClassNotFoundException;

        String signUpCustomer(CustInformationBean customer) throws Exception;
        List<ProductDetailsBean> searchProducts(String keywords)throws SQLException, ClassNotFoundException;
        List<ProductDetailsBean> getAllProductDetails() throws BadRequestException;
        int getCustId(String email);

    }














