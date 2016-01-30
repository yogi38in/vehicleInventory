package com.yogi.master.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yogi.master.dao.AssignmentDao;
import com.yogi.master.model.Assignment;
import com.yogi.master.service.AssignmentService;

@Service("assignmentService")
public class AssignmentServiceImpl implements AssignmentService{

	
	
	@Autowired
	private AssignmentDao assignmentDao;

	@Transactional(readOnly=true)
	@Override
	public List<Assignment> loadAllAssignments() {
		return assignmentDao.findAllAssignments();
	}

	@Transactional(readOnly=false)
	@Override
	public void addAssignment(Assignment assignment) {
		
		assignmentDao.addAssignment(assignment);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteAssignmentById(Long id) {
		assignmentDao.deleteAssignmentById(id);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteAll() {
		assignmentDao.deleteAll();
	}

}
