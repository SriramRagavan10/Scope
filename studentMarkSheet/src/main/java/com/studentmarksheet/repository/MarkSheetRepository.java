package com.studentmarksheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmarksheet.entity.MarkSheet;

public interface MarkSheetRepository extends JpaRepository<MarkSheet, Integer> {

}
