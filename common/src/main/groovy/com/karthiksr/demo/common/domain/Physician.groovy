package com.karthiksr.demo.common.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="physician")
class Physician {

	@Id
	@GeneratedValue
	Long id
	
	String firstName
	
	String lastName
	
	String middleName
	
	String speciality
	
	Double yearsOfExp
}
