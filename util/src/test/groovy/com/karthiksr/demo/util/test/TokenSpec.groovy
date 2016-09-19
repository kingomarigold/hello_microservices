package com.karthiksr.demo.util.test

import spock.lang.Specification

import com.karthiksr.demo.util.JwtTokenGenerator
import com.karthiksr.demo.util.JwtTokenValidator

class TokenSpec extends Specification {

	def 'Generate and validate a token for given user'(id,name) {
		given: ' We have a user id, name and secret'
		
		when: ' We generate a token'
		def token = JwtTokenGenerator.generateToken([id:id,name:name],'MySecretKey')
		then: ' We are able to validate the token'
		def user = JwtTokenValidator.parseToken(token,'MySecretKey')
		assert user.id == id
		assert user.name == name
		where: 
		id << ['1','2','3']
		name << ['Garrus','Ashley','Joan']
	}
}
