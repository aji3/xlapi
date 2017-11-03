package org.xlbean.xlapi;

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
@ComponentScan(basePackages="org.xlbean.sample.webshop.api")
@ComponentScan(basePackages="org.xlbean.sample.webshop.dao")
@ComponentScan(basePackages="org.xlbean.xlapi")
@MapperScan("org.xlbean.sample.webshop.dao")
public class GenApp {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(GenApp.class, args);
	}
}
