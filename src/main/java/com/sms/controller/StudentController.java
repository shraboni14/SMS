package com.sms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sms.dto.StudentDTO;
import com.sms.entity.Student;
import com.sms.service.StudentService;
import com.sms.util.StudentConverter;

@RestController
public class StudentController {

//	dependency injection
	@Autowired
	StudentService stdService;

	@Autowired
	StudentConverter stdConverter;

	@PostMapping("/createStudent")
	public String createStudent(@Valid @RequestBody StudentDTO stdto) {

		final Student std = stdConverter.convertDtoToStudentEntity(stdto);
		return stdService.createStudent(std);
	}

	@PostMapping("/savestudent")
	public StudentDTO saveStudent(@Valid @RequestBody StudentDTO stdto) {
		final Student std = stdConverter.convertDtoToStudentEntity(stdto);

		return stdService.saveStudent(std);
	}

	@GetMapping("/getStudent/{stdId}")
	public StudentDTO getStudentById(@PathVariable("stdId") String id) {
		return stdService.getStudentById(id);
	}

	@GetMapping("/getAllStudents")
	public List<StudentDTO> getAllStudents() {

		return stdService.getAllStudent();
	}

//	@PatchMapping	// when we want to update particular a single details
	@PutMapping("updateStudent/{id}") // when we want to update every details
	public StudentDTO updateStudent(@PathVariable("id") String stdId, @Valid @RequestBody StudentDTO stdDto) {

		final Student std = stdConverter.convertDtoToStudentEntity(stdDto);
		return stdService.updateStudent(stdId, std);
	}

	@DeleteMapping("/deleteStdById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") String stdId) {
		stdService.deleteStudentById(stdId);
		return new ResponseEntity<String>("Student with id " + stdId + " Deleted successfully", HttpStatus.OK);
	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll() {
		stdService.deleteAll();
		return new ResponseEntity<String>("All student details deleted successfully", HttpStatus.OK);
	}

	@GetMapping("/getStudentByName{name}")
	public List<StudentDTO> findStudentByName(@PathVariable("name") String name) {
		return stdService.getStudentByName(name);
	}

	@GetMapping("/getStudentByEmail/{email}")
	public StudentDTO findStudentByEmail(@PathVariable("email") String email) {
		return stdService.getStudentByEmail(email);
	}

	@GetMapping("/getStudentByDeptId/{deptId}")
	public List<StudentDTO> getStudentsByDeptId(@PathVariable("deptId") String deptId) {
		return stdService.getAllStudentsByDeptId(deptId);
	}


}
