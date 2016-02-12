package com.yogi.master.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yogi.master.dao.AssignmentFuelUpdateDao;
import com.yogi.master.model.AssignmentFuelUpdate;
import com.yogi.master.service.AssignmentFuelUpdateService;

@Service("assignmentFuelUpdateService")
public class AssignmentFuelUpdateServiceImpl implements AssignmentFuelUpdateService{

	
	
	@Autowired
	private AssignmentFuelUpdateDao assignmentFuelUpdateDao;

	@Transactional(readOnly=true)
	@Override
	public List<AssignmentFuelUpdate> loadAllAssignmentFuelUpdates() {
		return assignmentFuelUpdateDao.findAllAssignmentFuelUpdates();
	}


	
	@Transactional(readOnly=false)
	@Override
	public void addAssignmentFuelUpdate(AssignmentFuelUpdate assignmentFuelUpdate) {
		assignmentFuelUpdate.setRate(assignmentFuelUpdate.getAssignment().getRate());
		assignmentFuelUpdateDao.addAssignmentFuelUpdate(assignmentFuelUpdate);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteAssignmentFuelUpdateById(Long id) {
		assignmentFuelUpdateDao.deleteAssignmentFuelUpdateById(id);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteAll() {
		assignmentFuelUpdateDao.deleteAll();
	}

}
