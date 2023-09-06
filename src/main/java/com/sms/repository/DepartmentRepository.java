package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {
	
	Department findByDeptName(String deptName);
	
	@Query("select max(deptId) from Department")
	String getLastAddedId();

}
