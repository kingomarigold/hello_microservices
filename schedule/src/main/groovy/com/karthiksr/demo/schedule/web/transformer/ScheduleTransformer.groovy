package com.karthiksr.demo.schedule.web.transformer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import com.karthiksr.demo.schedule.service.integration.PhysicianService

@Component
class ScheduleTransformer {
	
	@Autowired
	PhysicianService physicianService

	def transform(schedule) {
		def physician = physicianService.findById(schedule.physicianId)
		[id:schedule.id,patientId:schedule.patientId,
			physician:[firstName:physician.firstName,lastName:physician.lastName,id:physician.id]]
	}
}
