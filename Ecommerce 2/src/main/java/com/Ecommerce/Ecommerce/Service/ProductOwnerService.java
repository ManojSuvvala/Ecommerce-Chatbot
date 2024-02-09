package com.Ecommerce.Ecommerce.Service;
import com.Ecommerce.Ecommerce.Bean.ProductDetailsBean;
import com.Ecommerce.Ecommerce.Bean.ProductOwnerBean;
import org.apache.coyote.BadRequestException;
import java.sql.SQLException;
import java.util.List;

public interface ProductOwnerService {

    String signUpOwner(ProductOwnerBean owner) throws SQLException, ClassNotFoundException;
    List<ProductDetailsBean> prodAdd(List<ProductDetailsBean> proddetailslist) throws BadRequestException;
    List<ProductDetailsBean> updateProducts(List<ProductDetailsBean> productDetailsBeanList) throws BadRequestException;


}