package com.yogi.master.dao;

import java.util.List;

import com.yogi.master.model.Assignment;

public interface AssignmentDao {

	
    List<Assignment> findAllAssignments();
    
    void addAssignment(Assignment assignment);
    
    void deleteAssignmentById(Long id);
	
	void deleteAll();
	
}