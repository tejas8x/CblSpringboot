package com.cbl.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cbl.app.service")
public class CblAppGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CblAppGradleApplication.class, args);
	}

}
