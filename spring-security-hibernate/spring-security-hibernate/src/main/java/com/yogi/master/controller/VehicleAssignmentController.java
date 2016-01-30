package com.yogi.master.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yogi.master.model.VehicleAssignment;
import com.yogi.master.service.VehicleAssignmentService;

@Controller
public class VehicleAssignmentController {

	@Autowired
	VehicleAssignmentService vehicleAssignmentService;
	
	

	@RequestMapping(value = "/vehicleAssignment/getVehicleAssignmentList.json")
	public @ResponseBody List<VehicleAssignment> getVehicleAssignmentList() {
		return vehicleAssignmentService.loadAllVehicleAssignments();
	}
	
	@RequestMapping(value = "/vehicleAssignment/addVehicleAssignment", method = RequestMethod.POST)
    public @ResponseBody void addVehicleAssignment(@RequestBody VehicleAssignment vehicleAssignment) {
		vehicleAssignmentService.addVehicleAssignment(vehicleAssignment);
    }
	
	@RequestMapping(value = "/vehicleAssignment/removeVehicleAssignment/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void removeVehicleAssignment(@PathVariable("id") Long id) {
		vehicleAssignmentService.deleteVehicleAssignmentById(id);
    }

    @RequestMapping(value = "/vehicleAssignment/removeAllVehicleAssignments", method = RequestMethod.DELETE)
    public @ResponseBody void removeAllVehicleAssignments() {
    	vehicleAssignmentService.deleteAll();
    }



}