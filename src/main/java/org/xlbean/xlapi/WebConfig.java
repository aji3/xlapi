package org.xlbean.xlapi;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import org.xlbean.xlapi.log.LogInterceptor;
import org.xlbean.xlapi.log.LoggableMappingJackson2HttpMessageConverter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor());
    }
    
//    @Override
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(0, new LoggableMappingJackson2HttpMessageConverter());
//        super.extendMessageConverters(converters);
//    }
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/v2/api-docs")
            .allowedOrigins("*")
            .allowedMethods("GET");
//        registry.addMapping("/customers/**")
//            .allowedOrigins("*");
//            .allowedHeaders("header1", "header2", "header3")
//            .exposedHeaders("header1", "header2")
//            .allowCredentials(false).maxAge(3600);
    }
}
