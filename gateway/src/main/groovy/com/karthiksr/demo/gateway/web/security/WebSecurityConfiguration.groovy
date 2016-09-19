package com.karthiksr.demo.gateway.web.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

import com.karthik.demo.security.config.StatelessAuthenticationFilter
import com.karthik.demo.security.config.StatelessAuthenticationProvider
import com.karthik.demo.security.config.StatelessAuthenticationSuccessHandler

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private StatelessAuthenticationProvider authenticationProvider
	
	
	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		List<AuthenticationProvider> providers = new ArrayList<AuthenticationProvider>();
		providers.add(authenticationProvider);
		return new ProviderManager(providers);
	}

	@Bean
	public StatelessAuthenticationFilter authenticationTokenFilterBean() throws Exception {
		StatelessAuthenticationFilter authenticationTokenFilter = new StatelessAuthenticationFilter();
		authenticationTokenFilter.setAuthenticationManager(authenticationManager());
		authenticationTokenFilter.setAuthenticationSuccessHandler(new StatelessAuthenticationSuccessHandler());
		return authenticationTokenFilter;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		/* Allow access to static resources and login uri without authentication */
		web.ignoring().antMatchers("/js/**/*.{js,html}")
				.antMatchers("/assets/**").antMatchers('/auth/**')
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				/* Everything else is authenticated */
				.antMatchers('/api/patient').authenticated()
				.antMatchers('/api/physician').authenticated()
				.antMatchers('/api/schedule').authenticated()
		
		http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class)
			
		/* general stateless defaults */
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)		
		http.csrf().disable()
		http.headers().cacheControl()
	}
}