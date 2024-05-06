package com.Ecommerce.Ecommerce.ServImpl;

import com.Ecommerce.Ecommerce.Bean.ProductCategoryBean;
import com.Ecommerce.Ecommerce.Bean.ProductDetailsBean;
import com.Ecommerce.Ecommerce.Bean.ProductOwnerBean;
import com.Ecommerce.Ecommerce.Bean.ProductSubCategory;
import com.Ecommerce.Ecommerce.Repo.*;
import com.Ecommerce.Ecommerce.Service.ProductOwnerService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class ProductOwnerServImpl implements ProductOwnerService {
    @Autowired
    private ProductOwnerSignupRepo productOwnerSignupRepo;

    @Autowired
    private ProductDetailsRepo productDetailsRepo;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private HomePageRepo homePageRepo;
    @Autowired
    private ProductSubCategoryRepo productSubCategoryRepo;
    @Autowired
    private HomePageLoginRepo homePageLoginRepo;



    public String signUpOwner(ProductOwnerBean owner) {
        try {
            String email = owner.getEmail();

            // Check if an owner with the same email already exists
            List<ProductOwnerBean> existingOwners = productOwnerSignupRepo.findOwnerByEmail(email);

            // If no existing owner found, proceed with saving the new owner
            if (existingOwners == null || existingOwners.isEmpty()) {
                // Clear the entity manager to ensure fresh data
                entityManager.clear();
                // Save the new owner
                productOwnerSignupRepo.save(owner);
                return "Signup successful";
            } else {
                // Return message indicating that the email already exists
                return "Email already exists. Please sign up with another email!!";
            }
        } catch (Exception ex) {
            // Log any exceptions that occur during the signup process
            ex.printStackTrace();
            // Return a generic error message
            return "An error occurred during signup";
        }
    }


    @Override
    public List<ProductDetailsBean> prodAdd(List<ProductDetailsBean> proddetailslist) throws BadRequestException {
        if(CollectionUtils.isEmpty(proddetailslist)){
            throw new BadRequestException(new Exception("Add atleast one product "));

        }
        List<ProductDetailsBean> productDetailsBeans= productDetailsRepo.saveAll(proddetailslist);
        return productDetailsBeans;
    }

    @Override
    public List<ProductDetailsBean> updateProducts(List<ProductDetailsBean> productDetailsBeanList) throws BadRequestException {
        if(CollectionUtils.isEmpty(productDetailsBeanList)){
            throw new BadRequestException(new Exception("Please update atleast one product "));

        }
        List<ProductDetailsBean> productDetailsBeans= productDetailsRepo.saveAll(productDetailsBeanList);
        return productDetailsBeans;
    }

    @Override
    public String deleteProduct(List<Integer> deletedetails) {
//        List<Integer> productid = deletedetails.stream().map(p ->p.getPDetailsId()).collect(Collectors.toList());
        productDetailsRepo.deleteproductDetails(deletedetails);
        return "Product deleted Successfully";

    }

    @Override
        public List<ProductCategoryBean> prodCategoryDisplay() {
        List<ProductCategoryBean> productCategoryBeans=homePageRepo.fetchp();
        return productCategoryBeans;
    }

    @Override
    public List<ProductSubCategory> prodSubCategoryDisplay() {
        List<ProductSubCategory> productSubCategories= productSubCategoryRepo.fetch();
        return productSubCategories;
    }

    @Override
    public String uploadProdImage(MultipartFile file, int pDetailsId) {
        if(file.isEmpty()){
            return "Please upload a Image file";
        }
        try{
            byte[] imageBytes=file.getBytes();
            productDetailsRepo.updateProdImage(imageBytes,pDetailsId);
            return "Image uploaded successfully";

        }catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    public List<ProductDetailsBean> getProductDetails(int poid) {
        return productDetailsRepo.getProductDetailsById(poid);
    }

    @Override
    public int getProdOwnId(String email) {
        return homePageLoginRepo.findProdOwnerIdByEmail(email);
    }


}


