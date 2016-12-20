package com.karthiksr.demo.gateway.web.resource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import com.karthiksr.demo.gateway.service.LoginService

@RestController
@RequestMapping('/auth/login')
class LoginResource {

	@Value('auth.secret')
	String secret
	
	@Autowired
	LoginService loginService
	
	@RequestMapping(value='',method=RequestMethod.POST)
	def login(@RequestParam('user') user,@RequestParam('pwd') password) {
		loginService.login(user,password,secret)
	}
}
