package com.sms.service.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sms.entity.Address;
import com.sms.entity.Department;
import com.sms.entity.Student;
import com.sms.repository.DepartmentRepository;
import com.sms.repository.StudentRepository;
import com.sms.service.DepartmentService;
import com.sms.service.StudentService;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	DepartmentService deptService;

	@Autowired
	StudentService stdService;

	@MockBean
	DepartmentRepository deptRepository;

	@MockBean
	StudentRepository stdRepository;

	@Test
	void testAssignStudentToDept() {
		Address add = Address.builder().city("Kolkata").locality("New Barrackpur").state("West Bengal").pincode(700131)
				.build();

		Student std = Student.builder().name("Shraboni Sinha").email("shraboni@gmail.com")
				.dateOfJoining(LocalDate.of(2023, 9, 9)).dateOfBirth(LocalDate.of(1996, 8, 5)).contact("8697588053")
				.address(add).build();

		Department dept = Department.builder().deptName("BCA").noOfStaff(5).totalStudents(30).build();

		Optional<Department> opDept = Optional.of(dept);

		Mockito.when(deptRepository.findById(dept.getDeptId())).thenReturn(opDept);

		Mockito.when(stdRepository.findById(std.getId())).thenReturn(Optional.of(std));

		deptService.assignStudentToDepartment(std.getId(), dept.getDeptId());

		assertEquals(dept.getDeptName(), stdService.getStudentById(std.getId()).getDept().getDeptName());
	}

}
