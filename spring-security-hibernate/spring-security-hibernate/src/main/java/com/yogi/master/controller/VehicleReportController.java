package com.yogi.master.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yogi.master.dto.VehicleReport;
import com.yogi.master.dto.VehicleReportRequest;
import com.yogi.master.model.Assignment;
import com.yogi.master.model.Vehicles;
import com.yogi.master.service.VehicleReportService;
import com.yogi.master.service.VehicleService;

@Controller
public class VehicleReportController {

	@Autowired
	VehicleReportService vehicleReportService;
	
	@Autowired
	VehicleService vehicleService;
	
	
	
	@RequestMapping(value = "/vehicle/getVehicleReport.json/{vehicleId}/{reportMonth}/{reportYear}", method=RequestMethod.GET)
	public @ResponseBody VehicleReport getVehicleReport(@PathVariable("vehicleId") Long vehicleId,
			@PathVariable("reportMonth") String reportMonth,@PathVariable("reportYear") String reportYear) {

		VehicleReport vehicleReport = vehicleReportService.loadVehicleReport(vehicleId, reportMonth, reportYear);
		return vehicleReport;

	}
	
	

}