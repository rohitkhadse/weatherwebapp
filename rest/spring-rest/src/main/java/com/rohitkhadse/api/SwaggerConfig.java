package com.rohitkhadse.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 
public class SwaggerConfig {

	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.pathMapping("/api/*")
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("Rohit Khadse", "http://rohitkhadse.com", "rkhadse@lamar.edu");
		ApiInfo info = new ApiInfo("Sping-REST API", "A weather REST API with swagger documentation and AWS implementation",
				"1.0.0","TnC", contact, "MIT", "https://opensource.org/licenses/MIT");
		return info;
	}
}
