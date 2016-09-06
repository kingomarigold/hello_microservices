package com.karthiksr.demo.common.domain


import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

import org.hibernate.annotations.Type
import org.joda.time.DateTime

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.karthiksr.demo.common.domain.util.CustomDateTimeDeserializer
import com.karthiksr.demo.common.domain.util.CustomDateTimeSerializer

@Entity
@Table(name="schedule")
class Schedule {
	@Id
	@GeneratedValue
	Long id
	
	Long patientId
	
	Long physicianId
	
	@Column(name="created_date")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	DateTime date
}
