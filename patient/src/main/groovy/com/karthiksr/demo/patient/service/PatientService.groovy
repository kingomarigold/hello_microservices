package com.karthiksr.demo.patient.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import com.karthiksr.demo.patient.repository.PatientRepository

@Service
class PatientService {
	
	@Autowired
	PatientRepository patientRepository

	@Transactional
	def save(patient) {
		patientRepository.save(patient)
	}
	
	def get(id) {
		patientRepository.findOne(id)
	}
}
