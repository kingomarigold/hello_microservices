package com.karthiksr.demo.schedule

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages='com.karthiksr.demo')
@EntityScan(basePackages='com.karthiksr.demo.common.domain')
class ScheduleApplication {

	static void main(String[] args) {
		SpringApplication.run ScheduleApplication, args
	}
}
