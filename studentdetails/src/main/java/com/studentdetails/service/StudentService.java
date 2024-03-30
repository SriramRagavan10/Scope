package com.studentdetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentdetails.dao.StudentDao;
import com.studentdetails.entity.Student;
import com.studentdetails.exception.AgeException;

@Service
public class StudentService {

	@Autowired
	StudentDao studDao;

	public String insertAll(List<Student> stud) throws AgeException {
		int count = 0;
		for (Student x : stud) {
			if (x.getAge() >= 18) {
				count++;
			} else {
				count--;
			}
		}
		if (count == stud.size()) {
			return studDao.insertAll(stud);
		} else if (count == stud.size() - 2) {
			throw new AgeException("One Student Age is below 18");
		} else {
			throw new AgeException("Age is below 18");
		}
	}

	public Student getById(int id) {
		return studDao.getById(id);
	}

	public String update(Student stu) throws AgeException {
		if (stu.getAge() >= 18) {
			return studDao.update(stu);
		} else {
			throw new AgeException("Age is below 18");
		}
	}

	public String delete(int id) {
		return studDao.delete(id);
	}

	public List<Student> getAll() {
		return studDao.getAll();
	}

}
