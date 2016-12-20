/**
 *
 */
package com.karthiksr.demo.gateway.test.base


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


import javax.servlet.Filter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import spock.lang.Shared
import spock.lang.Specification

import com.karthiksr.demo.gateway.service.LoginService
import com.karthiksr.demo.gateway.web.resource.LoginResource
import com.karthiksr.demo.util.JwtTokenGenerator;

/**
 * Common functionalities required for all tests go here.
 * 
 */
class WebAppIntegrationBaseSpecification extends Specification {
	MockMvc mockMvc
	
	@Autowired
	WebApplicationContext wac
	
	@Autowired
	Filter springSecurityFilterChain;

	@Shared
	String token
	

	/**
	 * Sets up the mock web application context.
	 */
	def setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).addFilters(springSecurityFilterChain).build()
		mockFeignClients()
		def authRes = this.mockMvc.perform(post('/auth/login').param('user','garrusv').param('pwd','xyz'))
		authRes.andExpect(status().is(200))
		token = authRes.andReturn().response.contentAsString
	}
	
	def mockFeignClients() {
		def mockLoginService = [
			login : {user,pwd,secret->return user=='garrusv'?JwtTokenGenerator.generateToken([id:user,name:user],secret):ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()}
		] as LoginService
		wac.getBean(LoginResource.class).loginService = mockLoginService
	}
	
}
