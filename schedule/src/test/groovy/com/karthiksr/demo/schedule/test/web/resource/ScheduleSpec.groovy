package com.karthiksr.demo.schedule.test.web.resource
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import groovy.json.JsonOutput

import org.joda.time.DateTime
import org.joda.time.format.ISODateTimeFormat
import org.springframework.http.MediaType

import com.karthiksr.demo.schedule.test.base.TransactionalWebIntegrationTest
import com.karthiksr.demo.schedule.test.base.WebAppIntegrationBaseSpecification

@TransactionalWebIntegrationTest
class ScheduleSpec extends WebAppIntegrationBaseSpecification {
	def 'Test adding a schedule'() {
		given: ' We are logged in'
		def currTime = DateTime.now()
		when: 'A new schedule is requested'
		def res = this.mockMvc.perform(post('/api/schedule')
			.content(JsonOutput.toJson([patientId:1,
				date:ISODateTimeFormat.dateTime().print(currTime),
				duration:1.5]))
			.contentType(MediaType.APPLICATION_JSON))
		then: ' A new schedule is created for the physician with greater experience'
		res.andExpect(status().is(201))
		def getRes = this.mockMvc.perform(get("/api/schedule/${getCreatedId(res)}"))
		getRes.andExpect(status().isOk())
		assert getRes.physician.firstName == "Elgar"
		and: ' When you try to add schedule for another patient at the same time'
		def anotherRes = this.mockMvc.perform(post('/api/schedule')
			.content(JsonOutput.toJson([patientId:2,
				date:ISODateTimeFormat.dateTime().print(currTime),
				duration:1.5]))
			.contentType(MediaType.APPLICATION_JSON))
		then: ' A new physician is chosen'
		anotherRes.andExpect(status().is(201))
		def getAnotherRes = this.mockMvc.perform(get("/api/schedule/${getCreatedId(anotherRes)}"))
		getAnotherRes.andExpect(status().isOk())
		assert getAnotherRes.physician.firstName == "Falon"
	}
}
