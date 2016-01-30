package com.yogi.master.service;

import java.util.List;

import com.yogi.master.model.VehicleAssignment;

public interface VehicleAssignmentService {

	
	List<VehicleAssignment> loadAllVehicleAssignments();
	
	void addVehicleAssignment(VehicleAssignment vehicleAssignment);
	
	void deleteVehicleAssignmentById(Long id);
	
	void deleteAll();

	
}
