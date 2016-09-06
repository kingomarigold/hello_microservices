package com.karthiksr.demo.physician.repository;

import org.springframework.data.jpa.repository.JpaRepository

import com.karthiksr.demo.common.domain.Physician

public interface PhysicianRepository extends JpaRepository<Physician, Long> {

}
