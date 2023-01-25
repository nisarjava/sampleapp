package com.nisar.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Sample Service"))
public class MorphyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MorphyappApplication.class, args);
	}

}
