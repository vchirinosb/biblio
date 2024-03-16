package com.biblio.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
* @author vchirinosb
* @since 18/10/2016
*/
@ControllerAdvice
public class GeneralExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex) {
		System.out.println(ex.toString());
		return "error";
	}

}
