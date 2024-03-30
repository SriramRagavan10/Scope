package com.studentresult.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studentresult.entity.Result;
import com.studentresult.repository.ResultRepository;

@Repository
public class ResultDao {

	@Autowired
	ResultRepository resRep;

	public String insertResult(List<Result> res) {
		resRep.saveAll(res);
		return "All Details Save Successfully";
	}

	public List<Result> getAllResult() {
		return resRep.findAll();
	}

}
