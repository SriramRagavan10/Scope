package com.studentdetails.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studentdetails.entity.Student;
import com.studentdetails.repository.StudentRepository;

@Repository
public class StudentDao {

	@Autowired
	StudentRepository studRep;

	public String insertAll(List<Student> stud) {
		studRep.saveAll(stud);
		return "All Students Details Save Successfully";
	}

	public Student getById(int id) {
		return studRep.findById(id).get();
	}

	public String update(Student stu) {
		studRep.save(stu);
		return "Update Detail Successfully Saved";
	}

	public String delete(int id) {
		studRep.deleteById(id);
		return "Deleted Successfully";
	}

	public List<Student> getAll() {
		return studRep.findAll();
	}

	public String mod(int id, Student stu) {
		Student s = studRep.findById(id).get();
		s.setAge(stu.getAge());
		s.setCourse(stu.getCourse());
		studRep.save(s);
		return "Data Changed";
	}

}
