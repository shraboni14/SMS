package com.sms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sms.entity.Student;

// <Class name, DataType of primary key in database>
public interface StudentRepository extends JpaRepository<Student, String> {

	@Query("from Student where name=:e")
	List<Student> findStudentByName(@Param("e") String name);

	Optional<Student> findByEmail(String email);

	@Query("from Student where dept=(from Department where deptId =:id)")
	List<Student> getStudentsByDeptId(@Param("id") String deptId);

//	SELECT D.DEPT_ID, U.NAME FROM USER_DETAILS U INNER JOIN STUDENT S ON S.ID = U.ID INNER JOIN DEPARTMENT D ON D.DEPT_ID = S.DEPT_DEPT_ID WHERE D.DEPT_ID =1;

}
