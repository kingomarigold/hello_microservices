package com.karthiksr.demo.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository

import com.karthiksr.demo.common.domain.User

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserId(userId)
}
