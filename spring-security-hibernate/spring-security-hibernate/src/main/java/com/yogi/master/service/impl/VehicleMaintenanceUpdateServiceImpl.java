package com.yogi.master.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yogi.master.dao.VehicleMaintenanceUpdateDao;
import com.yogi.master.model.VehicleMaintenanceUpdate;
import com.yogi.master.service.VehicleMaintenanceUpdateService;

@Service("vehicleMaintenanceUpdateService")
public class VehicleMaintenanceUpdateServiceImpl implements VehicleMaintenanceUpdateService{

	
	
	@Autowired
	private VehicleMaintenanceUpdateDao vehicleMaintenanceUpdateDao;

	@Transactional(readOnly=true)
	@Override
	public List<VehicleMaintenanceUpdate> loadAllVehicleMaintenanceUpdates() {
		return vehicleMaintenanceUpdateDao.findAllVehicleMaintenanceUpdates();
	}

	@Transactional(readOnly=false)
	@Override
	public void addVehicleMaintenanceUpdate(VehicleMaintenanceUpdate vehicleMaintenanceUpdate) {
		
		vehicleMaintenanceUpdateDao.addVehicleMaintenanceUpdate(vehicleMaintenanceUpdate);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteVehicleMaintenanceUpdateById(Long id) {
		vehicleMaintenanceUpdateDao.deleteVehicleMaintenanceUpdateById(id);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteAll() {
		vehicleMaintenanceUpdateDao.deleteAll();
	}

}
