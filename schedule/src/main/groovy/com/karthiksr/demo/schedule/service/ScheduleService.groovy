package com.karthiksr.demo.schedule.service

import org.joda.time.DateTimeZone
import org.joda.time.format.ISODateTimeFormat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import com.karthiksr.demo.common.domain.Schedule
import com.karthiksr.demo.common.domain.util.CommonUtil
import com.karthiksr.demo.schedule.repository.ScheduleRepository
import com.karthiksr.demo.schedule.service.integration.PhysicianService

@Service
class ScheduleService {
	
	@Autowired
	ScheduleRepository scheduleRepository
	
	@Autowired
	PhysicianService physicianService

	@Transactional
	def save(schedule) {
		def date = ISODateTimeFormat.dateTimeParser().withOffsetParsed().parseDateTime(schedule.date)
		def physicians = physicianService.findAll().toSorted{a,b->b.yearsOfExp <=> a.yearsOfExp}
		def busyPhysicians = scheduleRepository.findSchedulesForDates(CommonUtil.getStartOfDay(date),
			CommonUtil.getEndOfDay(date)).groupBy{it.physicianId}
		def selectedPhysicianId = null
		for (def physician:physicians) {
			if (!busyPhysicians.containsKey(physician.id)) {
				selectedPhysicianId = physician.id
				break
			}
		}
		
		scheduleRepository.save(new Schedule(patientId:schedule.patientId,physicianId:selectedPhysicianId,
			date:date.withZone(DateTimeZone.UTC)))
	}
	
	def get(id) {
		scheduleRepository.findOne(id)
	}
}
