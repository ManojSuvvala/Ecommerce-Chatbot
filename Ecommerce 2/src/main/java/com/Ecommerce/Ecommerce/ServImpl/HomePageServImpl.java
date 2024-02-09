package com.Ecommerce.Ecommerce.ServImpl;

import com.Ecommerce.Ecommerce.Bean.ProductCategoryBean;
import com.Ecommerce.Ecommerce.Bean.ProductDetailsBean;
import com.Ecommerce.Ecommerce.Bean.CustInformationBean;
import com.Ecommerce.Ecommerce.Repo.HomePageLoginRepo;
import com.Ecommerce.Ecommerce.Repo.HomePageProductSearchRepo;
import com.Ecommerce.Ecommerce.Repo.HomePageRepo;
import com.Ecommerce.Ecommerce.Repo.HomePageSignUpRepo;
import com.Ecommerce.Ecommerce.Service.HomePageService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
@Transactional
public class HomePageServImpl implements HomePageService {
    @Autowired
            private HomePageRepo homePageRepo;
    @Autowired
    private HomePageLoginRepo homePageLoginRepo;
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private HomePageSignUpRepo homePageSignUpRepo;
   @Autowired
 private HomePageProductSearchRepo homePageProductSearchRepo;

    //HomePageDBOperations hp=new HomePageDBOperations();
    @Override
    public List<ProductCategoryBean> productCategory()  {
        List<ProductCategoryBean> productCategoryBeans=homePageRepo.fetchp();
        return productCategoryBeans;
    }

    @Override
    public String getCustLogin(String email, String password) throws SQLException, ClassNotFoundException {
        List<CustInformationBean>custList=homePageLoginRepo.findCustomerByCredentials(email, password);

        if(custList!=null&&!custList.isEmpty()){
            return "Login Successful";

        }
        else{
            return "Login failed, Please try again!!!";
        }
    }

    @Override
    public String signUpCustomer(CustInformationBean customer) throws Exception {

        String email=customer.getEmail();
        List<CustInformationBean> custsignup=homePageSignUpRepo.findCustomerByEmail(email);
        try {
            if (custsignup == null || custsignup.isEmpty()) {
                entityManager.clear();
                homePageSignUpRepo.save(customer);
                return "signup successful";

            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


            return "Email already exists. Please signup with another email.";

        }


    @Override
    public List<ProductDetailsBean> searchProducts(String keywords) throws SQLException, ClassNotFoundException {
        List<ProductDetailsBean> productList = homePageProductSearchRepo.searchProducts(keywords);
        entityManager.clear();
        return productList;
    }


}
