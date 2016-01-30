package com.yogi.master.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yogi.master.model.Vehicles;
import com.yogi.master.service.VehicleService;

@Controller
public class VehicleController {

	@Autowired
	VehicleService vehicleService;
	
	
	@RequestMapping(value = { "/", "/getVehicleWithNumber**" }, method = RequestMethod.GET)
	public ModelAndView getVehicleWithNumber(@RequestParam(value = "vehicleNumber", required = false) String vehicleNumber,HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		
		model.addObject("vehicle", vehicleService.loadVehiclesByVehicleNumber(vehicleNumber));
		model.setViewName("admin");
		return model;

	}

	@RequestMapping(value = "/vehicle/getVehicleList.json")
	public @ResponseBody List<Vehicles> getVehicleList() {

		return vehicleService.loadAllVehicles();

	}
	
	@RequestMapping(value = "/vehicle/addVehicle", method = RequestMethod.POST)
    public @ResponseBody void addVehicle(@RequestBody Vehicles vehicle) {
		vehicleService.addVehicle(vehicle);
    }
	
	@RequestMapping(value = "/vehicle/removeVehicle/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void removeVehicle(@PathVariable("id") Long id) {
		vehicleService.deleteVehicleById(id);
    }

    @RequestMapping(value = "/vehicle/removeAllTrains", method = RequestMethod.DELETE)
    public @ResponseBody void removeAllVehicles() {
    	vehicleService.deleteAll();
    }

    @RequestMapping("/cars/layout")
    public String getCarPartialPage() {
        return "cars/layout";
    }

}