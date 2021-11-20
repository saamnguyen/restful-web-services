package com.spring.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Config
@Configuration
//Enable Swagger
@EnableSwagger2
public class SwaggerConfig {
    //Create bean
    @Bean
    public Docket api(){
        //creating constructor of Docket class that accepts parameter DocumentationType
        return new Docket(DocumentationType.SWAGGER_2);
    }
}
