package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootEmployeeSep20Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEmployeeSep20Application.class, args);
	}

}
