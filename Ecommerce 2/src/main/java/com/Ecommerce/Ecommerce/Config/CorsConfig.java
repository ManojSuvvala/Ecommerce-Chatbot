package com.Ecommerce.Ecommerce.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
        corsRegistry.addMapping("/**").allowedOriginPatterns("*").allowedMethods("GET","POST","PUT","DELETE").allowedHeaders("Content-Type","Authorization").allowCredentials(true);
    }
}
