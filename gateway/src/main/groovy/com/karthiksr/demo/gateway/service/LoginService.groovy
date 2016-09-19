package com.karthiksr.demo.gateway.service

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody



@FeignClient('http://auth')
interface LoginService {
	
	@RequestMapping(value='/api/login',method=RequestMethod.POST)
	@ResponseBody def login(@RequestParam('user') user,@RequestParam('pwd') pwd,@RequestParam('secret') secret)
	
}
