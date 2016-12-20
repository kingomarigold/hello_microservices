package com.karthiksr.demo.common.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name='user')
class User {
	@Id
	@GeneratedValue
	Long id
	
	String firstName
	
	String lastName
	
	String userId
	
	String email
	
	String password
	
	@Column(name='is_active')
	boolean active
}
