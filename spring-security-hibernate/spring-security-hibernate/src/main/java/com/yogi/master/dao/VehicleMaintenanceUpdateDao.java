package com.yogi.master.dao;

import java.util.List;

import com.yogi.master.model.VehicleMaintenanceUpdate;

public interface VehicleMaintenanceUpdateDao {

	
    List<VehicleMaintenanceUpdate> findAllVehicleMaintenanceUpdates();
    
    List<VehicleMaintenanceUpdate> findAllVehicleMaintenanceUpdates(Long vehicleId,
			String reportMonth, String reportYear);
    
    void addVehicleMaintenanceUpdate(VehicleMaintenanceUpdate vehicleMaintenanceUpdate);
    
    void deleteVehicleMaintenanceUpdateById(Long id);
	
	void deleteAll();
	
}