package com.yogi.master.dao;

import java.util.List;

import com.yogi.master.model.Vehicles;

public interface VehicleDao {

	Vehicles findByVehicleNumber(String vehicleNumber);
	
    List<Vehicles> findAllVehicles();
    
    void addVehicle(Vehicles vehicle);
    
    void deleteVehicleById(Long id);
	
	void deleteAll();
	
}