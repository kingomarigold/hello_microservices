package com.karthiksr.demo.patient

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages="com.karthiksr.demo")
@EntityScan(basePackages="com.karthiksr.demo.common.domain")
class PatientApplication {

	static void main(String[] args) {
		SpringApplication.run PatientApplication, args
	}
}
