package com.bank.system.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	private final String SECRET = "my_secure_key_32_characters_long_banking_2026";
	private final SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
	
	public String generateToken(String username) {
		return Jwts.builder().subject(username).issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 3600000))
				.signWith(KEY).compact();
	}
	
	public String validateToken(String token) {
		try {
			return Jwts.parser().verifyWith(KEY).build().parseSignedClaims(token)
					.getPayload().getSubject();
	//		Claims claims = Jwts.parser().verifyWith(KEY).build()
	//				.parseSignedClaims(token).getPayload();
	//		return claims.getSubject();
		}
		catch(Exception e) {
			System.out.println("JWT Validation Error: " + e.getMessage());
			return null;
		}
	}

}
