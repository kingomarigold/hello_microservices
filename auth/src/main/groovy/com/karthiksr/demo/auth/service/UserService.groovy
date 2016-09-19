package com.karthiksr.demo.auth.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

import com.karthiksr.demo.auth.repository.UserRepository

@Service
class UserService {
	
	
	@Autowired
	UserRepository userRepository
	
	@Autowired
	PasswordEncoder passwordEncoder

	def authenticate(user,pwd) {
		def myUser = userRepository.findByUserId(user)
		myUser?passwordEncoder.matches(pwd,myUser.password):false
	}
	
	def findOne(user) {
		userRepository.findByUserId(user)
	}
}
