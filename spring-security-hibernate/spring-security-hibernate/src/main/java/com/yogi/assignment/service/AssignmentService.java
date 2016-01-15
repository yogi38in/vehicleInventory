package com.yogi.assignment.service;

import java.util.List;

import com.yogi.assignment.model.Assignment;
import com.yogi.vehicle.model.Vehicles;

public interface AssignmentService {

	
	List<Assignment> loadAllAssignments();
	
	void addAssignment(Assignment assignment);
	
	void deleteAssignmentById(Long id);
	
	void deleteAll();

	
}
