package com;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = { "com.emenu.*" })
@EnableAutoConfiguration
@EnableSwagger2
@EnableCaching
public class EmenuApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmenuApiApplication.class, args);
    }

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("emenu").apiInfo(apiInfo()).select()
                .paths(regex("/api.*")).build();
        // .securitySchemes(newArrayList(apiKeyBasicAuth()))
        // .securityContexts(newArrayList(securityContext()));
    }

    // private BasicAuth apiKeyBasicAuth() {
    // return new BasicAuth("BasicAuth");
    // }
    //
    // private SecurityContext securityContext() {
    // return
    // SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/.*")).build();
    // }
    //
    // List<SecurityReference> defaultAuth() {
    // AuthorizationScope authorizationScope = new
    // AuthorizationScope("BasicAuth", "basic");
    // AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    // authorizationScopes[0] = authorizationScope;
    // return newArrayList(new SecurityReference("BasicAuth",
    // authorizationScopes));
    // }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("E-Menu Backup API").description("E-Menu Backup API")
                .contact("Simon Ghobreil").version("1.0").build();
    }
}
