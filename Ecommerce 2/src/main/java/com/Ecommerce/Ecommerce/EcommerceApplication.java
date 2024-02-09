package com.Ecommerce.Ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.Ecommerce.Ecommerce.Service"})
//@EnableJpaRepositories("domain.repository-com.Ecommerce.Ecommerce.Repo")
public class EcommerceApplication {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		HomePageController hp = new HomePageController();
//		hp.homePage();

				SpringApplication.run(EcommerceApplication.class, args);
	}

}
