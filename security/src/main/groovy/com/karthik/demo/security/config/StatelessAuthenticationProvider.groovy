package com.karthik.demo.security.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

import com.karthiksr.demo.util.JwtTokenValidator
@Component
class StatelessAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	
	@Value('auth.secret')
	String secret
	
	public StatelessAuthenticationProvider() {
		
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		AuthenticationRequestToken authRequestToken = (AuthenticationRequestToken)authentication
		def user = JwtTokenValidator.parseToken(authRequestToken.token,secret)
		new AuthenticatedUser(userName:user.name)
	}

}
