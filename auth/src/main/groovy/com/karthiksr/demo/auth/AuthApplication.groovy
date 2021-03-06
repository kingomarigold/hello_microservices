package com.karthiksr.demo.auth

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = 'com.karthiksr.demo')
@EntityScan(basePackages='com.karthiksr.demo.common.domain')
class AuthApplication {

	static void main(String[] args) {
		SpringApplication.run AuthApplication, args
	}
}
