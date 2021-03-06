package org.xlbean.xlapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.google.common.base.Predicate;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@Import({BeanValidatorPluginsConfiguration.class, })
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
//                        .groupName("webshop-api")
                        .select()
                        .apis(RequestHandlerSelectors.basePackage("org.xlbean.sample.webshop.api"))
                        .paths(paths())
                        .build()
                        .apiInfo(apiInfo());
    }

    private Predicate<String> paths() {
//        return Predicates.not(PathSelectors.regex("/basic-error-controller.*"));
    	return PathSelectors.any();
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "WebShop API",              // title
                "API for WebShop",    // description
                "0.0.1",                                // version
                "",                                     // terms of service url
                new Contact("name", "url", "email"),                             // created by
                "License",                     // license
                "http://test");                                    // license url
        return apiInfo;
    }
}
