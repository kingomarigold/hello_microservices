package com.karthiksr.demo.physician.test.web.resource

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

import org.springframework.http.MediaType

import com.karthiksr.demo.physician.test.base.TransactionalWebIntegrationTest
import com.karthiksr.demo.physician.test.base.WebAppIntegrationBaseSpecification

@TransactionalWebIntegrationTest
class PhysicianSpec extends WebAppIntegrationBaseSpecification {

	def 'Test adding a physician'(firstName,middleName,lastName,yearsOfExp,speciality,expectedStatus) {
		given: 'We are logged in and have access to add a physician'
		
		when: ' We validate and add a physician'
		def res = this.mockMvc.perform(post('/api/physician')
			.content(JsonOutput.toJson([firstName:firstName,lastName:lastName,middleName:middleName,
				yearsOfExp:yearsOfExp,speciality:speciality]))
			.contentType(MediaType.APPLICATION_JSON))
		then: ' The physician is added, if validation passes'
		res.andExpect(status().is(expectedStatus))
		if (expectedStatus == 201) {
			def getRes = this.mockMvc.perform(get("/api/physician/${getCreatedId(res)}"))
			getRes.andExpect(status().isOk())
			def getJson = new JsonSlurper().parseText(getRes.andReturn().response.contentAsString)
			assert firstName == getJson.firstName
			assert lastName == getJson.lastName
			assert middleName == getJson.middleName
			assert yearsOfExp == getJson.yearsOfExp
			assert speciality == getJson.speciality
		}
		where:
		firstName << ['Ellanaa','Ellanaa','Ellanaa','','Ellanna']
		middleName << ['I','','','','']
		lastName << ['Lavellan','Lavellan','','Lavellan','Lavellan']
		yearsOfExp << [10.5,10.5,11.25,null,12.5]
		speciality << ['Inquisitor','','','','']
		expectedStatus << [201,201,400,400,201]
		
	}
}
