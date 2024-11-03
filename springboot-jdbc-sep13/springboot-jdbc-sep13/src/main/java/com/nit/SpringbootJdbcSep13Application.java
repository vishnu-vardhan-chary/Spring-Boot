package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootJdbcSep13Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJdbcSep13Application.class, args);
	}

}
