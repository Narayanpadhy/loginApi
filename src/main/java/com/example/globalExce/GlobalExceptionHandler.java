package com.example.globalExce;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exception.userAlreadyExist;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// Handles @Valid validation exceptions
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> validationException(MethodArgumentNotValidException ex) {
		Map<String, String> error = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(erro -> {
			error.put(erro.getField(), erro.getDefaultMessage());
		});
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(userAlreadyExist.class)
	public ResponseEntity<Map<String, Object>> userAlreadyExist(userAlreadyExist ex) {
		Map<String, Object> map = new HashMap<>();
		map.put("status", 409);
		map.put("message", ex.getMessage());
		return new ResponseEntity<>(map, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<Map<String, Object>> usernamemismatchExc(BadCredentialsException us) {
		Map<String, Object> map = new HashMap<>();
		map.put("status", 401);
		map.put("message", "Invalid Username or Password");
		return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
	}

	// handle NullPointerException, SQLException
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleException(Exception ex) {
		Map<String, Object> map = new HashMap<>();
		map.put("status", 500);
		map.put("message", "something went wrong");
		return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
