package com.Ecommerce.Ecommerce.Controller;

import com.Ecommerce.Ecommerce.Bean.ProductCategoryBean;
import com.Ecommerce.Ecommerce.Bean.ProductDetailsBean;
import com.Ecommerce.Ecommerce.Bean.CustInformationBean;
import com.Ecommerce.Ecommerce.Service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class HomePageController {
    @Autowired
    private HomePageService homePageService;

    @GetMapping("/homePage")
    public ResponseEntity<List<ProductCategoryBean>> homePage() throws SQLException, ClassNotFoundException {
        return ResponseEntity.ok().body(homePageService.productCategory());
    }

    @PostMapping("/Login")
    public ResponseEntity<String> CustomerLogin(@RequestParam String email, @RequestParam String password) throws SQLException, ClassNotFoundException {
        return ResponseEntity.ok().body(homePageService.getCustLogin(email, password));
    }
    @PostMapping("/register")
    public ResponseEntity<String> customerRegister(@RequestBody CustInformationBean customer) throws Exception {
        //System.out.println("Received payload: " + customer);

        //String signupResult = homePageService.signUpCustomer(customer);
        return ResponseEntity.ok().body(homePageService.signUpCustomer(customer));

    }

    @GetMapping("/searchProducts")
    public ResponseEntity<List<ProductDetailsBean>> searchProducts(@RequestParam String keywords) throws SQLException, ClassNotFoundException {
        return ResponseEntity.ok().body(homePageService.searchProducts(keywords));
    }
}
