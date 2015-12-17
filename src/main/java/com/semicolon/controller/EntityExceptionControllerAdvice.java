package com.semicolon.controller;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class EntityExceptionControllerAdvice {

	@ExceptionHandler(MovieNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req,EntityNotFoundException exception, ModelAndView mav) {

	    mav.addObject("exception", exception.getMessage());
	    mav.setViewName("error/entityNotFound");
	     return mav;
	}

}
