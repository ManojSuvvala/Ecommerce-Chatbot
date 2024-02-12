package com.Ecommerce.Ecommerce.ServImpl;

import com.Ecommerce.Ecommerce.Bean.ProductDetailsBean;
import com.Ecommerce.Ecommerce.Bean.ProductOwnerBean;
import com.Ecommerce.Ecommerce.Repo.ProductDetailsRepo;
import com.Ecommerce.Ecommerce.Repo.ProductOwnerSignupRepo;
import com.Ecommerce.Ecommerce.Service.ProductOwnerService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.SQLException;
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


    @Override
    public String signUpOwner(ProductOwnerBean owner) throws SQLException, ClassNotFoundException {

        String email=owner.getEMAIL();
        List<ProductOwnerBean> ownersignup=productOwnerSignupRepo.findOwnerByEmail(email);

        if (ownersignup == null || ownersignup.isEmpty()) {
            entityManager.clear();
            //System.out.println("details saving"+productOwnerSignupRepo);
            productOwnerSignupRepo.save(owner);
            return "signup successful";
        }else{
            return "Email already exists. Please signup with another email.";

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


}


