package com.spcbrasil.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PARTIAL_CONTENT)
public class MovimentNotFoundException extends SPCException {
	public MovimentNotFoundException(String message) {
		super(message);
	}
}
