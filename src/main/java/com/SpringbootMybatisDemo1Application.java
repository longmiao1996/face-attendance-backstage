package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.movie.dao")
@ComponentScan("com.movie")
//@ServletComponentScan("com.movie.controller.filter")
public class SpringbootMybatisDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisDemo1Application.class, args);
	}
}
