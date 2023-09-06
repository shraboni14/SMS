package com.sms.service;

import java.util.List;

import com.sms.dto.StudentDTO;

//import org.springframework.stereotype.Service;

import com.sms.entity.Student;

public interface StudentService {

//	method used to save student details into the database
	String createStudent(Student student);

//	Method to save student details into the database
	StudentDTO saveStudent(Student student);

//	Method to fetch student details
	StudentDTO getStudentById(String stdId);

	List<StudentDTO> getAllStudent();

//	method to update saved student details which is present in the database

	StudentDTO updateStudent(String stdId, Student student);

//	method to delete one student details
	void deleteStudentById(String stdId);

//	method to delete all the student
	void deleteAll();

//	method to fetch studentDetails using name

	List<StudentDTO> getStudentByName(String name);

	StudentDTO getStudentByEmail(String email);

	List<StudentDTO> getAllStudentsByDeptId(String deptId);

}
