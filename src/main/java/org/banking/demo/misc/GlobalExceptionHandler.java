package org.banking.demo.misc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Error> accessDeniedEx(){
		Error error = new Error();
		error.setError(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		error.setMessgae("Soory to see this error! Respective team will be notified and will be resolved soon !");
		return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
