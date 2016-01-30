package com.yogi.master.dao;

import java.util.List;

import com.yogi.master.model.VehicleAssignment;

public interface VehicleAssignmentDao {

	
    List<VehicleAssignment> findAllVehicleAssignments();
    
    void addVehicleAssignment(VehicleAssignment vehicleAssignment);
    
    void deleteVehicleAssignmentById(Long id);
	
	void deleteAll();
	
}