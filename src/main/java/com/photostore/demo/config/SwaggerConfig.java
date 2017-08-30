package com.photostore.demo.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Autowired private Environment env;

	@Bean
    public Docket api() { 
		
		List<String> activeProfileList = Arrays.asList(env.getActiveProfiles());
		
        return new Docket(DocumentationType.SWAGGER_2)
          //.enable(!activeProfileList.contains("PROD"))
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.photostore.demo.controller"))
          .paths(PathSelectors.any())                     
          .build()
          .apiInfo(apiInfo());
          //.globalOperationParameters(getHeaderParam());                                    
    }
	
	
	/*
	private List<Parameter> getHeaderParam() { 
		
		List<Parameter> list = new ArrayList<>();
		Parameter p = new ParameterBuilder()
			    .name("client-metadata")
			    .description("request header containing access-log information")
			    .modelRef(new ModelRef("string"))
			    .parameterType("header")
			    .required(false)  //set to true
			    .build();
		list.add(p);
		return list;

	}*/
	
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("DynamoDB Photo Info")
                .description("CRUD Operations for DynamoDB")
                .version("1.0")
                .build();
    }
}
