package com.karthiksr.demo.util;

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm

/**
 * Generates a Token.
 * 
 * 
 * @author Karthik
 *
 */
public class JwtTokenGenerator {

	/**
	 * Generate a Token.
	 * 
	 * @param user Map - A map containing the id and name.
	 * @param secret String - The secret key.
	 * @return String.
	 */
	public static String generateToken(user, String secret) {
		Claims claims = Jwts.claims()
		claims.put('id',user.id)
		claims.put("name", user.name)
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
}
