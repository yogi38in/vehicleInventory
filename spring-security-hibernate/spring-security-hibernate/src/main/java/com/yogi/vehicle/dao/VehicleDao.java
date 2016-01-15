package com.yogi.vehicle.dao;

import java.util.List;

import com.yogi.vehicle.model.Vehicles;

public interface VehicleDao {

	Vehicles findByVehicleNumber(String vehicleNumber);
	
    List<Vehicles> findAllVehicles();
    
    void addVehicle(Vehicles vehicle);
    
    void deleteVehicleById(Long id);
	
	void deleteAll();
	
}