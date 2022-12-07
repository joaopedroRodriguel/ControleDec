package br.edu.ifpb.pweb2.controledecmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableOpenApi
@SpringBootApplication
public class ControledecmasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControledecmasterApplication.class, args);
	}

}
