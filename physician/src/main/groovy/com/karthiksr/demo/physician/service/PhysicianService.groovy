package com.karthiksr.demo.physician.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.karthiksr.demo.physician.repository.PhysicianRepository

@Service
class PhysicianService {

	@Autowired
	PhysicianRepository physicianRepository
	
	def save(physician) {
		physicianRepository.save(physician)
	}
	
	def get(id) {
		physicianRepository.findOne(id)
	}
}
