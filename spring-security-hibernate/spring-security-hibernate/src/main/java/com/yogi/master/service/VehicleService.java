package com.yogi.master.service;

import java.util.List;

import com.yogi.master.model.Vehicles;

public interface VehicleService {

	Vehicles loadVehiclesByVehicleNumber(String vehicleNumber);
	
	List<Vehicles> loadAllVehicles();
	
	void addVehicle(Vehicles vehicle);
	
	void deleteVehicleById(Long id);
	
	void deleteAll();
	
}
