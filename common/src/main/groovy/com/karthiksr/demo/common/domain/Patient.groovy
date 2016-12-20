package com.karthiksr.demo.common.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

import org.hibernate.validator.constraints.NotEmpty

@Entity
@Table(name="patient")
class Patient {

	@Id
	@GeneratedValue
	Long id
	
	@NotEmpty
	String firstName
	
	String middleName
	
	@NotEmpty
	String lastName
}
