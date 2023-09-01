package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.Student;

// <Class name, DataType of primary key in database>
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
