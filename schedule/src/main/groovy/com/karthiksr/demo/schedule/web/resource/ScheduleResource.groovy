package com.karthiksr.demo.schedule.web.resource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import com.karthiksr.demo.schedule.service.ScheduleService
import com.karthiksr.demo.schedule.web.transformer.ScheduleTransformer

@RestController
@RequestMapping('/api/schedule')
class ScheduleResource {
	
	@Autowired
	ScheduleService scheduleService
	
	@Autowired
	ScheduleTransformer scheduleTransformer

	@RequestMapping(value='',method=RequestMethod.POST)
	def save(@RequestBody schedule) {
		ResponseEntity.created(new URI("/api/schedule/${scheduleService.save(schedule).id}".toString())).build()
	}
	
	@RequestMapping(value='/{id}',method=RequestMethod.GET)
	def get(@PathVariable('id') Long id) {
		scheduleTransformer.transform(scheduleService.get(id))
	}
}
