package com.sms.service;

import com.sms.dto.DepartmentDTO;
import com.sms.entity.Department;

public interface DepartmentService {
	
	
	DepartmentDTO saveDepartment(Department dept);
	
//	method to assign student to department
	void assignStudentToDepartment(int stdId, int deptId);
}

