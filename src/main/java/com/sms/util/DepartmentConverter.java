package com.sms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.sms.dto.DepartmentDTO;
import com.sms.entity.Department;

@Component
public class DepartmentConverter {

//	method to convert dto to department entity

	public Department convertDtoToDeptEntity(DepartmentDTO dDto) {
		Department dept = new Department();

		if (dDto != null) {
			BeanUtils.copyProperties(dDto, dept);
		}
		return dept;
	}

//	method to convert department entity to dto

	public DepartmentDTO convertDeptEntityToDto(Department dept) {

		DepartmentDTO dDto = new DepartmentDTO();

		if (dept != null) {
			BeanUtils.copyProperties(dept, dDto);
		}
		return dDto;
	}

}
