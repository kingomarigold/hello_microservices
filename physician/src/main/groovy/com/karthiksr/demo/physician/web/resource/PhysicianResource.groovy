package com.karthiksr.demo.physician.web.resource

import javax.validation.Valid

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import com.karthiksr.demo.common.domain.Physician
import com.karthiksr.demo.physician.service.PhysicianService

@RestController
@RequestMapping('/api/physician')
class PhysicianResource {
	
	@Autowired
	PhysicianService physicianService

	@RequestMapping(value='',method=RequestMethod.POST)
	def save(@RequestBody @Valid Physician physician) {
		ResponseEntity.created(new URI("/api/physician/${physicianService.save(physician).id}".toString())).build()
	}
	
	@RequestMapping(value='/{id}',method=RequestMethod.GET)
	def get(@PathVariable('id') Long id) {
		def physician = physicianService.get(id)
		physician?physician:ResponseEntity.notFound().build()
	}
	
	@RequestMapping(value='',method=RequestMethod.GET)
	def all() {
		physicianService.all()
	}
}
