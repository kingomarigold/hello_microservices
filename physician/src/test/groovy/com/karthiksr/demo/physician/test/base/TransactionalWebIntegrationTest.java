package com.karthiksr.demo.physician.test.base;


import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.karthiksr.demo.physician.PhysicianApplication;



@ContextConfiguration(classes = PhysicianApplication.class)
@WebAppConfiguration
@Transactional
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TransactionalWebIntegrationTest {

}

