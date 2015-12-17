package com.semicolon.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Movie found")
public class MovieNotFoundException extends RuntimeException{
	
	public MovieNotFoundException(Long productId) {
		super("Movie not found for Id: " + productId);
	}

}
