package com.karthiksr.demo.gateway.web.resource

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/api/logout')
class LogoutResource {

	@RequestMapping(value='',method=RequestMethod.POST)
	def logout() {
		// Do nothing for now.
		ResponseEntity.ok().build()
	}
}
