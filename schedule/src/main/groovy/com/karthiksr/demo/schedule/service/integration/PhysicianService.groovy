package com.karthiksr.demo.schedule.service.integration

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@FeignClient('http://physician')
interface PhysicianService {
	@RequestMapping(value='/api/physician',method=RequestMethod.GET)
	@ResponseBody def findAll()
	
	@RequestMapping(value='/api/physician/{id}',method=RequestMethod.GET)
	@ResponseBody def findById(@PathVariable('id') id)
}
