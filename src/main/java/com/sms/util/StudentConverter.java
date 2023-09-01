package com.sms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.sms.dto.StudentDTO;
import com.sms.entity.Student;

@Component
public class StudentConverter {

//	method to convert dto to student entity

	public Student convertDtoToStudentEntity(StudentDTO sDto) {
		Student std = new Student();

		if (sDto != null) {
			BeanUtils.copyProperties(sDto, std);
		}
		return std;
	}

//	method to convert student entity to dto

	public StudentDTO convertEntityToDto(Student std) {

		StudentDTO sDto = new StudentDTO();

		if (std != null) {
			BeanUtils.copyProperties(std, sDto);
		}
		return sDto;
	}

}
