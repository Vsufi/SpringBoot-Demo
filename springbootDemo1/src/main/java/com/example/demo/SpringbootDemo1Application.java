package com.example.demo;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringbootDemo1Application {



	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemo1Application.class, args);
	}

}
