package com.yogi.master.dao;

import java.util.List;

import com.yogi.master.model.VehicleMaintenanceUpdate;

public interface VehicleMaintenanceUpdateDao {

	
    List<VehicleMaintenanceUpdate> findAllVehicleMaintenanceUpdates();
    
    void addVehicleMaintenanceUpdate(VehicleMaintenanceUpdate vehicleMaintenanceUpdate);
    
    void deleteVehicleMaintenanceUpdateById(Long id);
	
	void deleteAll();
	
}