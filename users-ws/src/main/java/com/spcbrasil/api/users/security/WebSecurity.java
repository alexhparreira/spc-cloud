package com.spcbrasil.api.users.security;

import com.spcbrasil.api.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
	
	private UsersService usersService;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public WebSecurity(Environment environment, UsersService usersService, BCryptPasswordEncoder bCryptPasswordEncoder)
	{
		this.environment = environment;
		this.usersService = usersService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
						.antMatchers(HttpMethod.GET, "/users-ws/v2/api-docs/**").permitAll()
						.antMatchers(HttpMethod.POST, "/users-ws/users/address/find").permitAll()
						.antMatchers(HttpMethod.POST, "/users-ws/users/address/find/**").permitAll()

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
				.antMatchers(HttpMethod.GET, "/users/**").permitAll()
						.antMatchers(HttpMethod.GET, "/users/password/reset/**").permitAll()
						.antMatchers(HttpMethod.GET, "/users-ws/users/password/reset/**").permitAll()
						.antMatchers(HttpMethod.GET, "users-ws/users/password/reset/**").permitAll().and()
		.addFilter(getAuthenticationFilter());
		http.headers().frameOptions().disable();
	}
	
	private AuthenticationFilter getAuthenticationFilter() throws Exception
	{
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(usersService, environment, authenticationManager());
		authenticationFilter.setAuthenticationManager(authenticationManager()); 
		authenticationFilter.setFilterProcessesUrl(environment.getProperty("login.url.path"));
		return authenticationFilter;
	}
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usersService).passwordEncoder(bCryptPasswordEncoder);
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
