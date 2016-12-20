/**
 *
 */
package com.karthiksr.demo.schedule.test.base


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import spock.lang.Specification

import com.karthiksr.demo.schedule.service.ScheduleService
import com.karthiksr.demo.schedule.service.integration.PhysicianService
import com.karthiksr.demo.schedule.web.transformer.ScheduleTransformer

/**
 * Common functionalities required for all tests go here.
 * 
 */
class WebAppIntegrationBaseSpecification extends Specification {
	MockMvc mockMvc
	
	@Autowired
	WebApplicationContext wac
	

	/**
	 * Sets up the mock web application context.
	 */
	def setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build()
		mockFeignClients()
	}
	
	def getCreatedId(response) {
		def createdEntityLocation =response.andReturn().getResponse().getHeader("Location")
		createdEntityLocation.substring(createdEntityLocation.lastIndexOf('/') + 1)
	}
	
	def mockFeignClients() {
		def mockPhysicianService = [
			findAll : {return [[firstName:'Elgar',id:1L,yearsOfExp:12.5],[firstName:'Falon',id:2L,yearsOfExp:10.5]]},
			findById: {id->return id==1?[firstName:'Elgar']:[firstName:'Falon']}
		] as PhysicianService
		wac.getBean(ScheduleService.class).physicianService = mockPhysicianService
		wac.getBean(ScheduleTransformer.class).physicianService = mockPhysicianService
	}
	
}
