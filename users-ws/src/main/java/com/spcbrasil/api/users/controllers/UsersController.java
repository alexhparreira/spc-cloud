package com.spcbrasil.api.users.controllers;


import com.spcbrasil.api.shared.UserDTO;
import com.spcbrasil.api.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("users")
public class UsersController {

	@Autowired
	private UsersService userService;

	@GetMapping(value = "/email/{email}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserDTO> getByEmail(@PathVariable String email) {
		UserDTO userDTO = userService.getUserDetailsByEmail(email);
		return ResponseEntity.status(HttpStatus.OK).body(userDTO);
	}



}
