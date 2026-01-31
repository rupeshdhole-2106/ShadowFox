package com.bank.system.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.system.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private final JwtUtil jwtUtil;
	
	public AuthController(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}
	
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody Map<String, String> request) {
		String username = request.get("username");
		String token = jwtUtil.generateToken(username);
		return Map.of("token", token, "type", "Bearer");
	}

}
