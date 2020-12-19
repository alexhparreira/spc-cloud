package com.spcbrasil.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends SPCException {
	public EntityNotFoundException(String message) {
		super(message);
	}
}
