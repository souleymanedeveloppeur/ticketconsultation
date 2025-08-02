package com.medical;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "E-MEDICAL",
				version = "1.0",
				description = "API de gestion du système médical"
		)
)
@SpringBootApplication
public class EMedicalApplication {

	public static void main(String[] args) {
		SpringApplication.run(EMedicalApplication.class, args);
	}

}
