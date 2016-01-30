package com.yogi.master.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yogi.master.dao.VehicleAssignmentDao;
import com.yogi.master.model.VehicleAssignment;
import com.yogi.master.service.VehicleAssignmentService;

@Service("vehicleAssignmentService")
public class VehicleAssignmentServiceImpl implements VehicleAssignmentService{

	
	
	@Autowired
	private VehicleAssignmentDao vehicleAssignmentDao;

	@Transactional(readOnly=true)
	@Override
	public List<VehicleAssignment> loadAllVehicleAssignments() {
		return vehicleAssignmentDao.findAllVehicleAssignments();
	}

	@Transactional(readOnly=false)
	@Override
	public void addVehicleAssignment(VehicleAssignment vehicleAssignment) {
		
		vehicleAssignmentDao.addVehicleAssignment(vehicleAssignment);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteVehicleAssignmentById(Long id) {
		vehicleAssignmentDao.deleteVehicleAssignmentById(id);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteAll() {
		vehicleAssignmentDao.deleteAll();
	}

}
