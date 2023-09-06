package com.sms.service;


import com.sms.dto.DepartmentDTO;
import com.sms.entity.Department;


public interface DepartmentService {
	
//	method to save record into the database
	DepartmentDTO saveDepartment(Department dept);
	
//	method to assign student to department
	void assignStudentToDepartment(String stdId, String deptId);
}

