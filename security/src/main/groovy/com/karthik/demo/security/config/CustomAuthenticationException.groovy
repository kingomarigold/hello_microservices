package com.karthik.demo.security.config

import org.springframework.security.core.AuthenticationException

class CustomAuthenticationException extends AuthenticationException {
	public CustomAuthenticationException() {
		super('Invalid Authorization')
	}
}
