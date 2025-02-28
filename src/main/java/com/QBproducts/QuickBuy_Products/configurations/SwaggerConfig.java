package com.QBproducts.QuickBuy_Products.configurations;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//In case of JWt or site allow setting : allow "/v3/api-docs", "/v2/api-docs", "/swagger-resources/**"
// "/swagger-ui/**", "/webjars/**"

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("QuickBuy Product Application")
                        .description("This is a product APIs developed by SMT")
                        .version("1.0")
                        .contact(new Contact().name("Shubham").email("smt@gmail.com").url("roronoa.com"))
                        .license(new License().name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                        .url("roronoa.com")
                        .description("This is a external url"));

    }

}
