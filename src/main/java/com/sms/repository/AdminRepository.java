package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
