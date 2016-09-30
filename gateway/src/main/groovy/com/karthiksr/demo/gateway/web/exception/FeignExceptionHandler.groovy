package com.karthiksr.demo.gateway.web.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

import feign.FeignException

@ControllerAdvice
class FeignExceptionHandler {

	@ExceptionHandler(FeignException.class)
	def handleException(FeignException f) {
		ResponseEntity.status(f.status).build()
	}
}
