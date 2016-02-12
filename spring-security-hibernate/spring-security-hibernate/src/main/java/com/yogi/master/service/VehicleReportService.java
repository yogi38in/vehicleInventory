package com.yogi.master.service;


import com.yogi.master.dto.VehicleReport;

public interface VehicleReportService {

	VehicleReport loadVehicleReport(Long vehicleId, String reportMonth, String reportYear);
	
	
	
}
