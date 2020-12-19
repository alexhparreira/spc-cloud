package com.spcbrasil.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends SPCException {
	public UserNotFoundException(String message) {
		super(message);
	}
}
