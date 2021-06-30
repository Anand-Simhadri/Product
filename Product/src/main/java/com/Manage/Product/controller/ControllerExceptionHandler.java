package com.Manage.Product.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.Manage.Product.exception.ProductnotSavedException;
import com.Manage.Product.exception.Productnotfoundexception;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<Object> handleProductNotFound(Productnotfoundexception ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("status", "failure");
		body.put("message", "No Products found");
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<Object> handleProductNotSaved(ProductnotSavedException ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("status", "failure");
		body.put("message", "Product not saved");

		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

	}
}
