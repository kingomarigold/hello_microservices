package com.karthiksr.demo.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository

import com.karthiksr.demo.common.domain.Patient

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
