package com.karthik.demo.security.config

import java.util.Collection

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Custom user details service.
 * 
 * 
 * @author Karthik
 *
 */
class AuthenticatedUser implements UserDetails {
	
	String userName

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return userName
	}

	@Override
	public boolean isAccountNonExpired() {
		return true
	}

	@Override
	public boolean isAccountNonLocked() {
		return true
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true
	}

	@Override
	public boolean isEnabled() {
		return true
	}

}
