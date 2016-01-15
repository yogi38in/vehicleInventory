package com.yogi.vehicle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yogi.travel.model.Train;
import com.yogi.users.dao.UserDao;
import com.yogi.vehicle.model.Vehicles;
import com.yogi.vehicle.service.VehicleService;

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



}