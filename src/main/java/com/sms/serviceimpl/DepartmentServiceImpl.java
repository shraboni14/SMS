package com.sms.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sms.dto.DepartmentDTO;
import com.sms.entity.Department;
import com.sms.entity.Student;
import com.sms.exception.ResourceNotFoundException;
import com.sms.repository.DepartmentRepository;
import com.sms.repository.StudentRepository;
import com.sms.service.DepartmentService;
import com.sms.util.DepartmentConverter;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository deptRepository;

	@Autowired
	DepartmentConverter deptConverter;

	@Autowired
	StudentRepository stdRepository;

	@Override
	public DepartmentDTO saveDepartment(Department dept) {

		Department existDept = deptRepository.findByDeptName(dept.getDeptName());

		if (existDept != null) {
			throw new DataIntegrityViolationException("Department already exist");
		}

		String lastAdded = deptRepository.getLastAddedId();

		if (lastAdded == null) {
			lastAdded = "D00";
		}

		String initial = lastAdded.substring(0, 2);	//D0
		int num = Integer.parseInt(lastAdded.substring(2));	//0
		lastAdded = initial+(num+1);	//D01

		dept.setDeptId(lastAdded);

		deptRepository.save(dept);

		return deptConverter.convertDeptEntityToDto(dept);
	}

	@Override
	public void assignStudentToDepartment(String stdId, String deptId) {

		Student std = stdRepository.findById(stdId)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "Id", stdId));

		Department dept = deptRepository.findById(deptId)
				.orElseThrow(() -> new ResourceNotFoundException("Department", "Id", deptId));

		std.setDept(dept);

//		update the total student (previous total student + new 1)
		dept.setTotalStudents(dept.getTotalStudents() + 1);

		stdRepository.save(std);
	}

	

}
