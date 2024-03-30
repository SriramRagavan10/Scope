package com.studentdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentdetails.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
