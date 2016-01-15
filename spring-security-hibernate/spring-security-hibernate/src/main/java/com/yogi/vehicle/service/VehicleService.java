package com.yogi.vehicle.service;

import java.util.List;

import com.yogi.vehicle.model.Vehicles;

public interface VehicleService {

	Vehicles loadVehiclesByVehicleNumber(String vehicleNumber);
	
	List<Vehicles> loadAllVehicles();
	
	void addVehicle(Vehicles vehicle);
	
	void deleteVehicleById(Long id);
	
	void deleteAll();
	
}
