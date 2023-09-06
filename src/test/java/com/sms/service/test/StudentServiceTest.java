package com.sms.service.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sms.entity.Address;
import com.sms.entity.Student;
import com.sms.repository.StudentRepository;
import com.sms.service.StudentService;

@SpringBootTest
class StudentServiceTest {

	@Autowired
	StudentService stdService;

	@MockBean // it means we are working on a copy. not on original student repository
	StudentRepository stdRepository;

	@Test
	void testSaveStudent() {
		Address add = Address.builder().city("Kolkata").locality("New Barrackpur").state("West Bengal").pincode(700131)
				.build();

		Student std = Student.builder().name("Shraboni Sinha").email("shraboni@gmail.com")
				.dateOfJoining(LocalDate.of(2023, 9, 9)).dateOfBirth(LocalDate.of(1996, 8, 5)).contact("8697588053")
				.address(add).build();

		Mockito.when(stdRepository.save(std)).thenReturn(std);

		assertEquals("Shraboni Sinha", stdService.saveStudent(std).getName());
	}

	@Test
	@DisplayName("Negitive Test case")
	void testGetStudentById() {

		Address add = Address.builder().city("Kolkata").locality("New Barrackpur").state("West Bengal").pincode(700131)
				.build();

		Student std = Student.builder().name("Shraboni Sinha").email("shrabonisinha14@gmail.com")
				.dateOfJoining(LocalDate.of(2023, 9, 9)).dateOfBirth(LocalDate.of(1996, 8, 5)).contact("8697588053")
				.address(add).build();

		Optional<Student> opStd = Optional.of(std);
		Mockito.when(stdRepository.findById(std.getId())).thenReturn(opStd);

		String email = stdService.getStudentById(std.getId()).getEmail();
		assertTrue(email.equals("shraboni@gmail.com"));
	}

}
