package com.karthiksr.demo.patient.test.web.resource

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

import org.springframework.http.MediaType

import com.karthiksr.demo.patient.test.base.TransactionalWebIntegrationTest
import com.karthiksr.demo.patient.test.base.WebAppIntegrationBaseSpecification

@TransactionalWebIntegrationTest
class PatientSpec extends WebAppIntegrationBaseSpecification {

	def "Test adding a patient"(firstName,middleName,lastName,expectedStatus) {
		given: 'We are logged in'
		
		when: 'We add a patient with the input values'
		def res = this.mockMvc.perform(post('/api/patient')
			.content(JsonOutput.toJson([firstName:firstName,middleName:middleName,lastName:lastName]))
			.contentType(MediaType.APPLICATION_JSON))
		then: 'The patient is validated and added if the validation is successful'
		res.andExpect(status().is(expectedStatus))
		if (expectedStatus == 201) {
			def getResponse = this.mockMvc.perform(get("/api/patient/${getCreatedId(res)}"))
			getResponse.andExpect(status().isOk())
			def getJson = new JsonSlurper().parseText(getResponse.andReturn().response.contentAsString)
			assert getJson.firstName == firstName
			assert getJson.middleName == middleName
			assert getJson.lastName == lastName
		}
		where:
		firstName << ['Garrus','','Joan','Joan']
		middleName << ['T','','','']
		lastName << ['Varkarian','Shephard','Shephard','']
		expectedStatus << [201,400,201,400]
	}
}
