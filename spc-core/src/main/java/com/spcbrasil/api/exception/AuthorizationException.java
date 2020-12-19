package com.spcbrasil.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class AuthorizationException extends SPCException {
	public AuthorizationException(String message) {
		super(message);
	}
}
