package com.karthiksr.demo.common.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="patient")
class Patient {

	@Id
	@GeneratedValue
	Long id
	
	String firstName
	
	String middleName
	
	String lastName
}
