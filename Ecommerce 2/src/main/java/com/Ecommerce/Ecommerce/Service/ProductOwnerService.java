package com.Ecommerce.Ecommerce.Service;

import com.Ecommerce.Ecommerce.Bean.ProductCategoryBean;
import com.Ecommerce.Ecommerce.Bean.ProductDetailsBean;
import com.Ecommerce.Ecommerce.Bean.ProductOwnerBean;
import com.Ecommerce.Ecommerce.Bean.ProductSubCategory;
import org.apache.coyote.BadRequestException;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.util.List;

public interface ProductOwnerService {

    String signUpOwner(ProductOwnerBean owner) throws SQLException, ClassNotFoundException;
    List<ProductDetailsBean> prodAdd(List<ProductDetailsBean> proddetailslist) throws BadRequestException;
    List<ProductDetailsBean> updateProducts(List<ProductDetailsBean> productDetailsBeanList) throws BadRequestException;
    String deleteProduct(List<Integer> deletedetails);
    List<ProductCategoryBean> prodCategoryDisplay();
    List<ProductSubCategory> prodSubCategoryDisplay();

    String uploadProdImage(MultipartFile file, int pDetailsId);
//    String uploadProdCategoryImage(MultipartFile file,int Product_id);
List<ProductDetailsBean> getProductDetails(int poid) throws BadRequestException;
    int getProdOwnId(String email);




}
