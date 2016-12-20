package com.karthiksr.demo.gateway

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.cloud.netflix.zuul.EnableZuulProxy
import org.springframework.context.annotation.ComponentScan


@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableFeignClients(basePackages='com.karthiksr.demo')
@ComponentScan(basePackages=['com.karthiksr.demo','com.karthik.demo'])
@EnableCircuitBreaker
@EnableAutoConfiguration(exclude = [DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class])
class GatewayApplication {

	static void main(String[] args) {
		SpringApplication.run GatewayApplication, args
	}
}
