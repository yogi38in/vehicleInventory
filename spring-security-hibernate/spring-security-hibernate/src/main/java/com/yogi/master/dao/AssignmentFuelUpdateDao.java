package com.yogi.master.dao;

import java.util.List;

import com.yogi.master.model.AssignmentFuelUpdate;

public interface AssignmentFuelUpdateDao {

	
    List<AssignmentFuelUpdate> findAllAssignmentFuelUpdates();
    
    List<AssignmentFuelUpdate> findAllAssignmentFuelUpdates(Long vehicleId,
			String reportMonth, String reportYear);
	
    
    void addAssignmentFuelUpdate(AssignmentFuelUpdate assignmentFuelUpdate);
    
    void deleteAssignmentFuelUpdateById(Long id);
	
	void deleteAll();

	
}