package com.spcbrasil.api.pagamento;


import java.io.IOException;

import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.filter.CharacterEncodingFilter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.Filter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@EnableMongoRepositories(basePackages = "com.spcbrasil.api.pagamento.data")
@EnableAsync
public class ApplicationPagamento {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationPagamento.class, args);
	}


	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Bean
	public Docket pgtoAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.spcbrasil.api.pagamento.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(
						new ApiInfoBuilder()
								.version("2.0")
								.title("Pagamento API")
								.description("Pagamento  API v2.0")
								.build()
				);
	}

	@Bean
	public Filter getCharacterEncodingFilter() {

		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();

		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);

		return encodingFilter;

	}





}
