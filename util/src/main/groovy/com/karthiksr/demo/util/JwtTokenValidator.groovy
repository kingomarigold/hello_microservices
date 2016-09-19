package com.karthiksr.demo.util;

import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts

/**
 * Class validates a given token.
 *
 */
public class JwtTokenValidator {


	public static def parseToken(String token,String secret) {
		Claims body = Jwts.parser()
				.setSigningKey(secret)
				.parseClaimsJws(token)
				.getBody();

		[id:body.get('id'),name:body.get('name'),expiration:body.expiration]
	}
}
