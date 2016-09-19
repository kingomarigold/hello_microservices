package com.karthik.demo.security.config

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

class AuthenticationRequestToken extends UsernamePasswordAuthenticationToken {
	String token
	
	public AuthenticationRequestToken() {
		super(null,null)
	}
	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return null;
	}	
}
