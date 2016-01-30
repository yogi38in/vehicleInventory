package com.yogi.master.service;

import java.util.List;

import com.yogi.master.model.Assignment;

public interface AssignmentService {

	
	List<Assignment> loadAllAssignments();
	
	void addAssignment(Assignment assignment);
	
	void deleteAssignmentById(Long id);
	
	void deleteAll();

	
}
