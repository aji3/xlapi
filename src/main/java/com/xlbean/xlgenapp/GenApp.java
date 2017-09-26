package com.xlbean.xlgenapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

/**
 * Hello world!
 *
 */
@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages="com.xlbean.sample.webshop.api")
@ComponentScan(basePackages="com.xlbean.sample.webshop.dao")
@ComponentScan(basePackages="com.xlbean.xlgenapp")
@MapperScan("com.xlbean.sample.webshop.dao")
public class GenApp {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(GenApp.class, args);
	}
}
