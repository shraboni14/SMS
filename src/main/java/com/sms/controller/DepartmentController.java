package com.sms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sms.dto.DepartmentDTO;
import com.sms.entity.Department;
import com.sms.service.DepartmentService;
import com.sms.util.DepartmentConverter;

public class DepartmentController {

	@Autowired
	DepartmentService deptService;

	@Autowired
	DepartmentConverter deptConverter;

	@PostMapping("/saveDept")
	public DepartmentDTO saveDepartment(@Valid @RequestBody DepartmentDTO dDto) {
		final Department dept = deptConverter.convertDtoToDeptEntity(dDto);
		return deptService.saveDepartment(dept);

	}

	public ResponseEntity<String> assignedToDept(@PathVariable("sId") int stdId, @PathVariable("dId") int deptId) {
		deptService.assignStudentToDepartment(stdId, deptId);
		return new ResponseEntity<String>("Student with id " + stdId + " assigned to department id " + deptId,
				HttpStatus.OK);
	}

}