package com.bank.system.exception;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class GlobalExceptionHandler {
	
	public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex) {
		var errors = ex.getBindingResult().getFieldErrors().stream().collect(
				Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
		return ResponseEntity.badRequest().body(errors);
	}
	
	public ResponseEntity<?> handleLogic(RuntimeException ex) {
		return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
	}

}
