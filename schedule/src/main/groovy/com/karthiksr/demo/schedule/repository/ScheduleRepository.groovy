package com.karthiksr.demo.schedule.repository;


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

import com.karthiksr.demo.common.domain.Schedule

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
	
	@Query('select s from Schedule s where s.date >= :startDate and s.date <= :endDate ')
	List<Schedule> findSchedulesForDates(@Param('startDate') startDate,@Param('endDate') endDate)
}
