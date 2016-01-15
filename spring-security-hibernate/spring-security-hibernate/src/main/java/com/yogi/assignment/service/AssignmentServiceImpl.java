package com.yogi.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yogi.assignment.dao.AssignmentDao;
import com.yogi.assignment.model.Assignment;
import com.yogi.users.dao.UserDao;
import com.yogi.vehicle.dao.VehicleDao;
import com.yogi.vehicle.model.Vehicles;

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
