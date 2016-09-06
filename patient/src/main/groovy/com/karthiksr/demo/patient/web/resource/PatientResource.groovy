package com.karthiksr.demo.patient.web.resource

import javax.validation.Valid

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import com.karthiksr.demo.common.domain.Patient
import com.karthiksr.demo.patient.service.PatientService

@RestController
@RequestMapping('/api/patient')
class PatientResource {
	
	@Autowired
	PatientService patientService

	@RequestMapping(value='',method=RequestMethod.POST)
	def save(@RequestBody @Valid Patient patient) {
		ResponseEntity.created(new URI("/api/patient/${patientService.save(patient).id}".toString())).build()
	}
	
	@RequestMapping(value='/{id}',method=RequestMethod.GET)
	def get(@PathVariable('id') Long id) {
		def patient = patientService.get(id)
		patient?patient:ResponseEntity.notFound().build()
	}
}
