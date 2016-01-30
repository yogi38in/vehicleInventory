package com.yogi.master.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yogi.master.model.VehicleMaintenanceUpdate;
import com.yogi.master.service.VehicleMaintenanceUpdateService;

@Controller
public class VehicleMaintenanceUpdateController {

	@Autowired
	VehicleMaintenanceUpdateService vehicleMaintenanceUpdateService;
	
	

	@RequestMapping(value = "/vehicleMaintenanceUpdate/getVehicleMaintenanceUpdateList.json")
	public @ResponseBody List<VehicleMaintenanceUpdate> getVehicleMaintenanceUpdateList() {
		return vehicleMaintenanceUpdateService.loadAllVehicleMaintenanceUpdates();
	}
	
	@RequestMapping(value = "/vehicleMaintenanceUpdate/addVehicleMaintenanceUpdate", method = RequestMethod.POST)
    public @ResponseBody void addVehicleMaintenanceUpdate(@RequestBody VehicleMaintenanceUpdate vehicleMaintenanceUpdate) {
		vehicleMaintenanceUpdateService.addVehicleMaintenanceUpdate(vehicleMaintenanceUpdate);
    }
	
	@RequestMapping(value = "/vehicleMaintenanceUpdate/removeVehicleMaintenanceUpdate/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void removeVehicleMaintenanceUpdate(@PathVariable("id") Long id) {
		vehicleMaintenanceUpdateService.deleteVehicleMaintenanceUpdateById(id);
    }

    @RequestMapping(value = "/vehicleMaintenanceUpdate/removeAllVehicleMaintenanceUpdates", method = RequestMethod.DELETE)
    public @ResponseBody void removeAllVehicleMaintenanceUpdates() {
    	vehicleMaintenanceUpdateService.deleteAll();
    }



}