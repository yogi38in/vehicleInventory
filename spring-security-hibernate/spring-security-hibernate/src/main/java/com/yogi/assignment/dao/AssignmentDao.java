package com.yogi.assignment.dao;

import java.util.List;

import com.yogi.assignment.model.Assignment;

public interface AssignmentDao {

	
    List<Assignment> findAllAssignments();
    
    void addAssignment(Assignment assignment);
    
    void deleteAssignmentById(Long id);
	
	void deleteAll();
	
}