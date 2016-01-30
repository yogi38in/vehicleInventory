package com.yogi.master.service;

import java.util.List;

import com.yogi.master.model.VehicleMaintenanceUpdate;

public interface VehicleMaintenanceUpdateService {

	
	List<VehicleMaintenanceUpdate> loadAllVehicleMaintenanceUpdates();
	
	void addVehicleMaintenanceUpdate(VehicleMaintenanceUpdate vehicleMaintenanceUpdate);
	
	void deleteVehicleMaintenanceUpdateById(Long id);
	
	void deleteAll();

	
}
