package com.Ecommerce.Ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class EcommerceApplication {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

				SpringApplication.run(EcommerceApplication.class, args);
	}

}







//@ComponentScan(basePackages = {"com.Ecommerce.Ecommerce.Service"})
//@EnableJpa

//		HomePageController hp = new HomePageController();
//		hp.homePage();
