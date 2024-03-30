package com.studentresult.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.studentdetails.entity.Student;
import com.studentmarksheet.entity.MarkSheet;
import com.studentresult.dao.ResultDao;
import com.studentresult.entity.Result;

@Service
public class ResultService {

	@Autowired
	ResultDao resDao;

	@Autowired
	RestTemplate rest;

	public String insertResult(List<Result> res) {
		String url = "http://localhost:8080/home/getAll";
		String url1 = "http://localhost:8081/marksheet/getAllMarks";
		List<Student> name = rest.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {
		}).getBody();
		List<MarkSheet> mar = rest
				.exchange(url1, HttpMethod.GET, null, new ParameterizedTypeReference<List<MarkSheet>>() {
				}).getBody();
		for (int i = 0; i < name.size(); i++) {
			Result reset = new Result();
			for (int j = 0; j < name.size(); j++) {
				if (mar.get(i).getRollNumber() == name.get(j).getRollNumber()) {
					reset.setId(name.get(i).getId());
					reset.setName(name.get(i).getName());
					reset.setTotal((mar.get(i).getSem1Total() + mar.get(i).getSem2Total()) / 2);
					reset.setRollNumber(name.get(i).getRollNumber());
				}
			}
			if (name.get(i).getAttendance() > 90.0f && reset.getTotal() <= 95) {
				reset.setTotal(reset.getTotal() + 5);
			}
			if (name.get(i).getAttendance() > 90.0f && reset.getTotal() > 95) {
				reset.setTotal(100);
			}
			reset.setPercentage((reset.getTotal()));
			res.add(reset);
		}

		return resDao.insertResult(res);
	}

	public List<Result> getTopper() {
		List<Result> res = resDao.getAllResult();
		Result re = res.stream().max(Comparator.comparing(Result::getPercentage)).get();
		return res.stream().filter(x -> x.getPercentage() == re.getPercentage()).toList();
	}

	public List<Result> getTopThree(int a) {
		List<Result> res = resDao.getAllResult();
		List<Float> re = res.stream().sorted(Comparator.comparing(Result::getPercentage).reversed())
				.map(x -> x.getPercentage()).distinct().limit(a).toList();
		List<Result> r = new ArrayList<>();
		for (int i = 0; i < re.size(); i++) {
			for (int j = 0; j < res.size(); j++) {
				if (res.get(j).getPercentage() == re.get(i)) {
					r.add(res.get(j));
				}
			}
		}
		return r.stream().sorted(Comparator.comparing(Result::getPercentage).reversed()).toList();
	}

	public List<Result> getByRange(float a, float b) {
		List<Result> res = resDao.getAllResult();
		return res.stream().filter(x -> x.getPercentage() > a && x.getPercentage() < b).toList();
	}

}
