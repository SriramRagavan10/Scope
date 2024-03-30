package com.studentdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentdetails.entity.Student;
import com.studentdetails.exception.AgeException;
import com.studentdetails.service.StudentService;

@RestController
@RequestMapping(value = "/home")
public class StudentController {

	@Autowired
	StudentService studSer;

	@PostMapping(value = "/insertAll")
	public String insertAll(@RequestBody List<Student> stud) throws Exception {
		return studSer.insertAll(stud);
	}

	@GetMapping(value = "/getById")
	public Student getById(@RequestParam int id) {
		return studSer.getById(id);
	}

	@PutMapping(value = "/update")
	public String update(@RequestBody Student stu) throws AgeException {
		return studSer.update(stu);
	}

	@DeleteMapping(value = "/deleteById/{id}")
	public String delete(@PathVariable int id) {
		return studSer.delete(id);
	}

	@GetMapping(value = "/getAll")
	public List<Student> getAll() {
		return studSer.getAll();
	}

}
