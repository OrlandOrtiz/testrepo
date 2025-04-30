package com.personal.rest_server.exception;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.personal.rest_server.utility.ErrorInfo;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@Autowired
	private Environment environmnet;
	
	@ExceptionHandler(ServerException.class)
	public ResponseEntity<ErrorInfo> serverExceptionHandler(ServerException e) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorcode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setErrorMesage(environmnet.getProperty(e.getMessage()));
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
