package com.karthiksr.demo.auth.test.login

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import groovy.json.JsonSlurper

import com.karthiksr.demo.auth.test.base.TransactionalWebIntegrationTest
import com.karthiksr.demo.auth.test.base.WebAppIntegrationBaseSpecification
import com.karthiksr.demo.util.JwtTokenValidator

@TransactionalWebIntegrationTest
class LoginSpec extends WebAppIntegrationBaseSpecification {
	
	

	def 'Validate the login mechanism'(user,pwd,expectedStatus) {
		given: 'We have the incoming user and pwd'
		when: ' We attempt to authenticate'
		def res = this.mockMvc.perform(post("/api/login?user=${user}&pwd=${pwd}&secret=MySecret"))
		then: ' We expect the status'
		res.andExpect(status().is(expectedStatus))
		if (expectedStatus == 200) {
			def resJson = new JsonSlurper().parseText(res.andReturn().response.contentAsString)
			def validUser = JwtTokenValidator.parseToken(resJson.token,'MySecret')
			assert validUser.id == user
		}
		where: 
		user << ['garrusv','garrusv','unknown']
		pwd << ['test','test1','test2']
		expectedStatus << [200,401,401]
	}
}
