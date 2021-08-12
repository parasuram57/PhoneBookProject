package com.hibernet.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PhonbookExceptionHandler {

	@ExceptionHandler(value=PhonebookAppException.class)
	public String PhonebookException() {
		
		
		return "eror";
	}
	
	/*
	 * @ExceptionHandler(value=NullPointerException.class) public String
	 * PException() {
	 * 
	 * 
	 * return "eror"; }
	 */
	
}
