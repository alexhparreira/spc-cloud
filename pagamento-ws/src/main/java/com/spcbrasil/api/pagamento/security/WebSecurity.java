package com.spcbrasil.api.pagamento.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	private Environment environment;
	

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public WebSecurity(Environment environment)
	{
		this.environment = environment;

	}

	///swagger-resources/**", "/configuration/**", "/swagger-ui.html"

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.formLogin().successHandler(successHandler());
		http.authorizeRequests().antMatchers("/**").hasIpAddress(environment.getProperty("gateway.ip")).antMatchers(HttpMethod.POST, "/users/**").permitAll();
		http.authorizeRequests().antMatchers("/**").hasIpAddress(environment.getProperty("gateway.ip")).antMatchers(HttpMethod.PUT, "/users/**").permitAll();
		http.authorizeRequests().antMatchers("/**").hasIpAddress(environment.getProperty("gateway.ip")).antMatchers(HttpMethod.DELETE, "/users/**").permitAll();
				http.authorizeRequests().antMatchers("/**").hasIpAddress(environment.getProperty("gateway.ip")).antMatchers(HttpMethod.GET, "/users/**").permitAll()
				.antMatchers(HttpMethod.GET, "/swagger-ui.html").permitAll()
				.antMatchers(HttpMethod.GET, "/swagger-resources/**").permitAll()
				.antMatchers(HttpMethod.GET, "/users-ws/swagger-ui.html").permitAll()
				.antMatchers(HttpMethod.GET, "/users-ws/swagger-resources/**").permitAll()
				.antMatchers(HttpMethod.GET, "/users-ws/configuration/**").permitAll()
				.antMatchers(HttpMethod.GET, "/users-ws/v2/api-docs").permitAll()
						.antMatchers(HttpMethod.GET, "/consumidor-ws/swagger-ui.html").permitAll()
						.antMatchers(HttpMethod.GET, "/consumidor-ws/swagger-resources/**").permitAll()
						.antMatchers(HttpMethod.GET, "/consumidor-ws/configuration/**").permitAll()
						.antMatchers(HttpMethod.GET, "/consumidor-ws/v2/api-docs").permitAll()
						.antMatchers(HttpMethod.GET, "/consumidor-ws/v2/api-docs/**").permitAll()
						.antMatchers(HttpMethod.GET, "/consumidor-ws/swagger-ui.html").permitAll()
						.antMatchers(HttpMethod.GET, "/consumidor-ws/swagger-resources/**").permitAll()
						.antMatchers(HttpMethod.GET, "/consumidor-ws/configuration/**").permitAll()
						.antMatchers(HttpMethod.GET, "/consumidor-ws/v2/api-docs").permitAll()
						.antMatchers(HttpMethod.GET, "/consumidor-ws/v2/api-docs/**").permitAll()


				.antMatchers(HttpMethod.GET, "/configuration/**").permitAll()

				.antMatchers("/",
						"/v2/api-docs",
						"/configuration/ui", "/swagger-resources/**", "/configuration/**", "/swagger-ui.html", "/webjars/**",
						"/favicon.ico",
						"/**/*.png",
						"/**/*.gif",
						"/**/*.svg",
						"/**/*.jpg",
						"/**/*.html",
						"/**/*.css",
						"/**/*.js")
				.permitAll()
				.antMatchers(HttpMethod.GET, "/users/**").permitAll();
		http.headers().frameOptions().disable();
	}

	


	private AuthenticationSuccessHandler successHandler() {
		return new AuthenticationSuccessHandler() {
			@Override
			public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
				String id = httpServletResponse.getHeader("id");
				httpServletResponse.getWriter().append("OK");
				httpServletResponse.setStatus(200);
			}


		};
	}

}
