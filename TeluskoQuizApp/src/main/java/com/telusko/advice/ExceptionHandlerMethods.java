package com.telusko.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.telusko.exception.CategoryNotFoundException;
import com.telusko.exception.QuestionNotFoundException;

//rest controller advice routes exception to these controller methods and these methods 
//takes care of exception which arises in the program.
@RestControllerAdvice
public class ExceptionHandlerMethods {

	// this method handles all the illegal argument which does not suits the
	// validation
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException exception) {

		Map<String, String> errorMap = new HashMap<>();
		exception.getBindingResult().getFieldErrors()
				.forEach(entry -> errorMap.put(entry.getField(), entry.getDefaultMessage()));

		return errorMap;
	}

	// controller method for handling question not found exception
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(QuestionNotFoundException.class)
	public Map<String, String> QuestionNotFoundExceptionHandler(QuestionNotFoundException exception) {
		Map<String, String> errorMap = new HashMap<>();

		errorMap.put("errorMessage", exception.getMessage());
		return errorMap;

	}

	// controller method for handling general exception
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public Map<String, String> generalExceptionHandler(Exception exception) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", exception.getMessage());
		return errorMap;
	}

	// exception controller method for category not found
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(CategoryNotFoundException.class)
	public Map<String, String> categoryNotFoundExceptionHandler(CategoryNotFoundException exception) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("message", exception.getMessage());
		return errorMap;
	}
}
