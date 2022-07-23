package com.andersonhelder.gerenciador.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	 public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.andersonhelder.gerenciador"))
	                .paths(PathSelectors.any())
	                .build()
	                .apiInfo(metaInfo());
	}
	        
	        private ApiInfo metaInfo() {

	            ApiInfo apiInfo = new ApiInfo(
	                    "API REST",
	                    "API REST de cadastro de pessoas e emdereços.",
	                    "1.0",
	                    "Terms of Service",
	                    null, "Apache License Version 2.0",
	                    "https://www.apache.org/licesen.html"
	            );

	            return apiInfo;
	        }
	
}
