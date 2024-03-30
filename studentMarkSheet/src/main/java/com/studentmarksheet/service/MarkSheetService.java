package com.studentmarksheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmarksheet.dao.MarkSheetDao;
import com.studentmarksheet.entity.MarkSheet;

@Service
public class MarkSheetService {

	@Autowired
	MarkSheetDao markDao;

	public String insert(MarkSheet mark) {
		mark.setSem1Total(mark.getSem1Theory() + mark.getSem1Practicals());
		mark.setSem2Total(mark.getSem2Theory() + mark.getSem2Practicals());
		return markDao.insert(mark);
	}

	public String inserAll(List<MarkSheet> mark) {
		mark.forEach(x -> {
			x.setSem1Total(x.getSem1Theory() + x.getSem1Practicals());
			x.setSem2Total(x.getSem2Theory() + x.getSem2Practicals());
		});
		return markDao.inserAll(mark);
	}

	public List<MarkSheet> getAll() {
		return markDao.getAll();
	}

}
