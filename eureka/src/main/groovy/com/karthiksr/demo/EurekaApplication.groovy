package com.karthiksr.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class EurekaApplication {

	static void main(String[] args) {
		SpringApplication.run EurekaApplication, args
	}
}
