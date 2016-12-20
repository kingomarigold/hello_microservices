package com.karthik.demo.security.config

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter

class StatelessAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	
	public StatelessAuthenticationFilter() {
		super("/api/**")
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
	throws AuthenticationException, IOException, ServletException {

		String authHeader = request.getHeader('Authorization')
		if (authHeader == null || !authHeader.startsWith('Bearer')) {
			throw new CustomAuthenticationException()
		}
		AuthenticationRequestToken authRequest = new AuthenticationRequestToken(token:authHeader.substring('Bearer '.length()))
		getAuthenticationManager().authenticate(authRequest)
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
	throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);

		chain.doFilter(request, response);
	}
}
