package com.sms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.dto.StudentDTO;
import com.sms.entity.Address;
import com.sms.entity.Role;
import com.sms.entity.Student;
import com.sms.exception.ResourceNotFoundException;
import com.sms.repository.AddressRepository;
import com.sms.repository.RoleRepository;
import com.sms.repository.StudentRepository;
import com.sms.service.StudentService;
import com.sms.util.StudentConverter;

@Service
public class StudentServiceImpl implements StudentService {

//	Injection
	@Autowired
	StudentRepository stdRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	StudentConverter stdConverter;

	@Autowired
	AddressRepository addRepository;

	@Override
	public String createStudent(Student std) {

		String user = std.getEmail().substring(0, std.getEmail().indexOf('@'));
		std.setUserName(user);

		String pass = std.getName().substring(0, 3).toLowerCase();
		std.setPassword(pass + "123");

		addRepository.save(std.getAddress());
		stdRepository.save(std); // saving the student object to the database

		return "Student details saved successfully";
	}

	@Override
	public StudentDTO saveStudent(Student std) {

//		generating username from entered email
		String user = std.getEmail().substring(0, std.getEmail().lastIndexOf('@'));
		std.setUserName(user);

//		generate password from entered password
		String pass = std.getName().substring(0, 3).toLowerCase();
		std.setPassword(pass + "123");

//		setting the role
		Role role = roleRepository.findById(2).get();	// it will return role of index 2 that is user
		std.setRole(role);

		addRepository.save(std.getAddress());

		stdRepository.save(std); // saving the student object to the database

		StudentDTO sDto = stdConverter.convertEntityToDto(std);
		return sDto;
	}

	@Override
	public StudentDTO getStudentById(int stdId) throws ResourceNotFoundException {
//		Persistence layer calling
		Student std = stdRepository.findById(stdId)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "id", stdId));
//		using lambda expression for throwing my custom exception
		return stdConverter.convertEntityToDto(std);
	}

	@Override
	public List<StudentDTO> getAllStudent() {
		List<Student> students = stdRepository.findAll();

		List<StudentDTO> sDtos = new ArrayList<>();

		for (Student s : students) {

			StudentDTO sDto = stdConverter.convertEntityToDto(s);
			sDtos.add(sDto);
		}

		return sDtos;
	}

	@Override
	public StudentDTO updateStudent(int stdId, Student std) throws ResourceNotFoundException {
		// fetch the student detail using the id
		Student existingStudent = stdRepository.findById(stdId)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "id", stdId));

//		updating the existing student details with new updated details
		existingStudent.setName(std.getName());
		existingStudent.setEmail(std.getEmail());
		existingStudent.setAddress(std.getAddress());
		existingStudent.setContact(std.getContact());
		existingStudent.setDateOfBirth(std.getDateOfBirth());
		existingStudent.setDateOfJoining(std.getDateOfJoining());

//		saving the changes made
		stdRepository.save(existingStudent);

		return stdConverter.convertEntityToDto(existingStudent);
	}

	@Override
	public void deleteStudentById(int stdId) throws ResourceNotFoundException{

		Student std = stdRepository.findById(stdId)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "Id", stdId));

		Address add = std.getAddress();

		if (add != null) {
			std.setAddress(null);
			addRepository.delete(add);
		}

//		stdRepository.deleteById(stdId);

		stdRepository.delete(std); // it will delete complete entity which is getting after finding by id
	}

	@Override
	public void deleteAll() {

		stdRepository.deleteAll();

	}

}
