package com.karthiksr.demo.auth.web.resource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import com.karthiksr.demo.auth.service.UserService
import com.karthiksr.demo.util.GenUtil
import com.karthiksr.demo.util.JwtTokenGenerator


@RestController
@RequestMapping('/api/login')
class LoginResource {
	
	@Autowired
	UserService userService

	@RequestMapping(value='',method=RequestMethod.POST)
	def login(@RequestParam('user') user,@RequestParam('pwd') pwd,@RequestParam('secret') secret) {
		def retVal = ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
		if (userService.authenticate(user,pwd)) {
			def myUser = userService.findOne(user)
			retVal = [token:JwtTokenGenerator.generateToken([id:myUser.userId,
				name:GenUtil.concatNames(myUser.firstName,'',myUser.lastName)],secret)]
		}
		retVal
	}
}
