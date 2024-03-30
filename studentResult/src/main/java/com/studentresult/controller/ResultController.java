package com.studentresult.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentresult.entity.Result;
import com.studentresult.service.ResultService;

@RestController
@RequestMapping(value = "/result")
public class ResultController {

	@Autowired
	ResultService resSer;

	@PostMapping(value = "/insertStudentMarksheetviaResult")
	public String insertResult(@RequestBody List<Result> res) {
		return resSer.insertResult(res);
	}

	@GetMapping(value = "/getTopper")
	public List<Result> getTopper() {
		return resSer.getTopper();
	}

	@GetMapping(value = "/getTopThree/{a}")
	public List<Result> getTopThree(@PathVariable int a) {
		return resSer.getTopThree(a);
	}

	@GetMapping(value = "/getByRange")
	public List<Result> getByRange(@RequestParam float a, @RequestParam float b) {
		return resSer.getByRange(a, b);
	}

}
