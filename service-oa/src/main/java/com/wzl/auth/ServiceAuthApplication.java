package com.wzl.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wang
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan("com.wzl")
public class ServiceAuthApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceAuthApplication.class,args);
	}
}
