package com.karthiksr.demo.gateway.test.auth
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import com.karthiksr.demo.gateway.test.base.TransactionalWebIntegrationTest
import com.karthiksr.demo.gateway.test.base.WebAppIntegrationBaseSpecification

@TransactionalWebIntegrationTest
class LogoutSpec extends WebAppIntegrationBaseSpecification {

	def 'Test the log out'() {
		given: ' We are logged in'
		
		when: ' You log out'
		def res = this.mockMvc.perform(post('/api/logout').header('Authorization',"Bearer ${token}".toString()))
		then: ' You are logged out'
		res.andExpect(status().isOk())
		this.mockMvc.perform(post('/api/logout')).andExpect(status().is(401))
	}
}
