package com.yogi.master.service;

import java.util.List;

import com.yogi.master.model.AssignmentFuelUpdate;

public interface AssignmentFuelUpdateService {

	
	List<AssignmentFuelUpdate> loadAllAssignmentFuelUpdates();
	
	void addAssignmentFuelUpdate(AssignmentFuelUpdate assignmentFuelUpdate);
	
	void deleteAssignmentFuelUpdateById(Long id);
	
	void deleteAll();


	
}
