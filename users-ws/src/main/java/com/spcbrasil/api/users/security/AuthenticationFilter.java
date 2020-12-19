package com.spcbrasil.api.users.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spcbrasil.api.shared.AddressDTO;
import com.spcbrasil.api.shared.UserDTO;
import com.spcbrasil.api.users.model.LoginRequestModel;
import com.spcbrasil.api.users.service.UsersService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private UsersService usersService;
	private Environment environment;
	
	public AuthenticationFilter(UsersService usersService,
                                Environment environment,
                                AuthenticationManager authenticationManager) {
		this.usersService = usersService;
		this.environment = environment;
		super.setAuthenticationManager(authenticationManager);
	}
	
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {

            LoginRequestModel creds = new ObjectMapper()
                    .readValue(req.getInputStream(), LoginRequestModel.class);



            Authentication auth = getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getEmail(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
                return auth;


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    @SneakyThrows
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

    	String userName = ((User) auth.getPrincipal()).getUsername();
    	UserDTO userDetails = usersService.getUserDetailsByEmail(userName);

        AddressDTO addressDTO = userDetails.getAddress();

        res.setContentType("application/json");

        String token = Jwts.builder()
                .setSubject(userDetails.getId())
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(environment.getProperty("token.expiration_time"))))
                .signWith(SignatureAlgorithm.HS512, environment.getProperty("token.secret") )
                .compact();
        
        res.addHeader("token", token);

        res.addHeader("userId", userDetails.getId());

        LoginData loginData = new LoginData(userDetails.getName(),userDetails.getProfileImage(),addressDTO.getLatitude(),addressDTO.getLongitude());

          ObjectMapper Obj = new ObjectMapper();
          String jsonStr = Obj.writeValueAsString(loginData);

          res.getWriter().append(jsonStr);

    }


    @Data
    @AllArgsConstructor
    class LoginData{
	    private String name;
	    private byte[] profileImage;
	    private Double latitude;
	    private Double longitude;
    }


    
	
}	