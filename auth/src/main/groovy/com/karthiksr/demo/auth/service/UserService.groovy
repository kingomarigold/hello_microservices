package com.karthiksr.demo.auth.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

import com.karthiksr.demo.auth.repository.UserRepository

@Service
class UserService {
	
	static def encoder = new BCryptPasswordEncoder()
	
	@Autowired
	UserRepository userRepository

	def authenticate(user,pwd) {
		def myUser = userRepository.findByUserId(user)
		myUser?encoder.matches(pwd,myUser.password):false
	}
	
	def findOne(user) {
		userRepository.findByUserId(user)
	}
}
