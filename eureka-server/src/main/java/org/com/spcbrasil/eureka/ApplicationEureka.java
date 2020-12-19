package org.com.spcbrasil.eureka;

		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ApplicationEureka {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationEureka.class, args);
	}

}
