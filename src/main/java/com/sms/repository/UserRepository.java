package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.User;

//@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	
}
