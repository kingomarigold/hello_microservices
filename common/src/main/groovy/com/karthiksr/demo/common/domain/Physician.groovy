package com.karthiksr.demo.common.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

import org.hibernate.validator.constraints.NotEmpty

@Entity
@Table(name="physician")
class Physician {

	@Id
	@GeneratedValue
	Long id
	
	@NotEmpty
	String firstName
	
	@NotEmpty
	String lastName
	
	String middleName
	
	String speciality
	
	@NotNull
	Double yearsOfExp
}
