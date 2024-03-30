package com.studentmarksheet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studentmarksheet.entity.MarkSheet;
import com.studentmarksheet.repository.MarkSheetRepository;

@Repository
public class MarkSheetDao {

	@Autowired
	MarkSheetRepository markRep;

	public String insert(MarkSheet mark) {
		markRep.save(mark);
		return "Student Marks Save Successfully";
	}

	public String inserAll(List<MarkSheet> mark) {
		markRep.saveAll(mark);
		return "All Students Marks Save Successfully";
	}

	public List<MarkSheet> getAll() {
		return markRep.findAll();
	}
	

}
