package com.Ecommerce.Ecommerce.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
//@EnableJpaRepositories(basePackages = "com.Ecommerce.Ecommerce.Repo")


public class Dbconnection {
   @Bean
   @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource dbConnection(){
//       DynamicPropertyFactory factory = DynamicPropertyFactory.getInstance();
       return DataSourceBuilder.create().driverClassName("com.mysql.cj.jdbc.Driver").url("jdbc:mysql://ecommerce.czy4qak88nc8.us-east-2.rds.amazonaws.com:3306/ECOMMERCE").username("admin").password("Confidence").build();
    }
}
