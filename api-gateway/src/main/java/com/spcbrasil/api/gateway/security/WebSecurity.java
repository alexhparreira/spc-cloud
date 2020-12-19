package com.spcbrasil.api.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private final Environment environment;

	@Autowired
	public WebSecurity(Environment environment) {
		this.environment = environment;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		///address/{address}   /token/regenerate/{email}  /token/verify
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.authorizeRequests()
				.antMatchers(environment.getProperty("api.users.actuator.url.path")).permitAll()
				.antMatchers(HttpMethod.GET, "/users-ws/swagger-ui.html").permitAll()
				.antMatchers(HttpMethod.GET, "/users-ws/swagger-resources/**").permitAll()
				.antMatchers(HttpMethod.GET, "/users-ws/configuration/**").permitAll()
				.antMatchers(HttpMethod.GET, "/users-ws/v2/api-docs").permitAll()
				.antMatchers(HttpMethod.GET, "/users-ws/v2/api-docs/**").permitAll()
				.antMatchers(HttpMethod.GET, "/consumidor-ws/swagger-ui.html").permitAll()
				.antMatchers(HttpMethod.GET, "/consumidor-ws/swagger-resources/**").permitAll()
				.antMatchers(HttpMethod.GET, "/consumidor-ws/configuration/**").permitAll()
				.antMatchers(HttpMethod.GET, "/consumidor-ws/v2/api-docs").permitAll()
				.antMatchers(HttpMethod.GET, "/consumidor-ws/v2/api-docs/**").permitAll()
				.antMatchers(HttpMethod.GET, "/pagamento-ws/swagger-ui.html").permitAll()
				.antMatchers(HttpMethod.GET, "/pagamento-ws/swagger-resources/**").permitAll()
				.antMatchers(HttpMethod.GET, "/pagamento-ws/configuration/**").permitAll()
				.antMatchers(HttpMethod.GET, "/pagamento-ws/v2/api-docs").permitAll()
				.antMatchers(HttpMethod.GET, "/pagamento-ws/v2/api-docs/**").permitAll()
				.antMatchers(HttpMethod.GET, "**/v2/api-docs").permitAll()
				.antMatchers(HttpMethod.POST, environment.getProperty("api.registration.url.path")).permitAll()
				.antMatchers(HttpMethod.POST, environment.getProperty("api.login.url.path")).permitAll()
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
				.anyRequest().authenticated()
				.and()
				.addFilter(new AuthorizationFilter(authenticationManager(), environment));

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Bean
	public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
		StrictHttpFirewall fireWall = new StrictHttpFirewall();
		fireWall.setAllowUrlEncodedSlash(true);
		return fireWall;
	}




}