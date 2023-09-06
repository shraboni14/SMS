package com.sms.dto;

import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sms.entity.Student;

public class DepartmentDTO {

	private String deptId;

	@NotNull(message = "Department name is required")
	@Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 charracter required")
	private String deptName;

	@NotNull(message = "Field is required")
	private int totalStudents;

	@NotNull(message = "Required")
	private int noOfStaff;

	@OneToMany
	private List<Student> students;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getTotalStudents() {
		return totalStudents;
	}

	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}

	public int getNoOfStaff() {
		return noOfStaff;
	}

	public void setNoOfStaff(int noOfStaff) {
		this.noOfStaff = noOfStaff;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
