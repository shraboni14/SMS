package com.sms.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sms.dto.DepartmentDTO;
import com.sms.entity.Department;
import com.sms.entity.Student;
import com.sms.exception.ResourceNotFoundException;
import com.sms.repository.DepartmentRepository;
import com.sms.repository.StudentRepository;
import com.sms.service.DepartmentService;
import com.sms.util.DepartmentConverter;

public class DepartmentImpl implements DepartmentService {

	@Autowired
	DepartmentRepository deptRepository;

	@Autowired
	DepartmentConverter deptConverter;

	@Autowired
	StudentRepository stdRepository;

	@Override
	public DepartmentDTO saveDepartment(Department dept) {
		deptRepository.save(dept);
		return deptConverter.convertDeptEntityToDto(dept);
	}

	@Override
	public void assignStudentToDepartment(int stdId, int deptId) {
		
		Student std = stdRepository.findById(stdId).orElseThrow(()-> new ResourceNotFoundException("Student", "Id", stdId));
		
		Department dept = deptRepository.findById(deptId).orElseThrow(()-> new ResourceNotFoundException("Department", "Id", deptId));
	}

}
