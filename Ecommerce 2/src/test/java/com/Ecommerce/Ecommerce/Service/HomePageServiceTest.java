package com.Ecommerce.Ecommerce.Service;

import com.Ecommerce.Ecommerce.Bean.CustInformationBean;
import com.Ecommerce.Ecommerce.Bean.ProductCategoryBean;
import com.Ecommerce.Ecommerce.Repo.HomePageLoginRepo;
import com.Ecommerce.Ecommerce.Repo.HomePageProductSearchRepo;
import com.Ecommerce.Ecommerce.Repo.HomePageRepo;
import com.Ecommerce.Ecommerce.Repo.HomePageSignUpRepo;
import com.Ecommerce.Ecommerce.ServImpl.HomePageServImpl;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HomePageServiceTest {
   @InjectMocks
   private HomePageServImpl homePageServimpl;
    @Mock
    private HomePageRepo homePageRepo;
    @Mock
    private HomePageLoginRepo homePageLoginRepo;
    @Mock
    private EntityManager entityManager;

    @Mock
    private HomePageSignUpRepo homePageSignUpRepo;
    @Mock
    private HomePageProductSearchRepo homePageProductSearchRepo;

    @Test
    public void getListOfProductCategories(){
        List<ProductCategoryBean> productCategoryBeansList=new ArrayList<>();
        ProductCategoryBean productCategoryBean=new ProductCategoryBean();
        productCategoryBean.setProduct_id(1);
        productCategoryBean.setCategory("Iphone");
        productCategoryBeansList.add(productCategoryBean);
        when(homePageRepo.fetchp()).thenReturn(productCategoryBeansList);
        homePageServimpl.productCategory();
    }

    @Test
    public void getCusLoginpass() throws SQLException, ClassNotFoundException {
        List<CustInformationBean> custInformationBeanList=new ArrayList<>();
        CustInformationBean custInformationBean=new CustInformationBean();
        custInformationBean.setEmail("suvvalam@gmail.com");
        custInformationBean.setPassword("Manoj@143");
        custInformationBeanList.add(custInformationBean);
        when(homePageLoginRepo.findCustomerByCredentials(Mockito.anyString(),Mockito.anyString())).thenReturn(custInformationBeanList);
        homePageServimpl.getCustLogin("suvvalam@gmail.com","Manoj@143");


    }
    @Test
    public void getCusLoginfail() throws SQLException, ClassNotFoundException {
        List<CustInformationBean> custInformationBeanList=new ArrayList<>();
//        CustInformationBean custInformationBean=new CustInformationBean();
//        custInformationBean.setEmail("suvvalam@gmail.com");
//        custInformationBean.setPassword("Manoj@143");
//        custInformationBeanList.add(custInformationBean);
        when(homePageLoginRepo.findCustomerByCredentials(Mockito.anyString(),Mockito.anyString())).thenReturn(custInformationBeanList);
        homePageServimpl.getCustLogin("suvvalam@gmail.com","Manoj@143");


    }
    
}
