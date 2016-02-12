package com.yogi.master.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yogi.users.dao.UserDao;
import com.yogi.master.dao.AssignmentFuelUpdateDao;
import com.yogi.master.dao.VehicleDao;
import com.yogi.master.dao.VehicleMaintenanceUpdateDao;
import com.yogi.master.dto.VehicleFuelUpdateDTO;
import com.yogi.master.dto.VehicleMaintenanceUpdateDTO;
import com.yogi.master.dto.VehicleReport;
import com.yogi.master.model.AssignmentFuelUpdate;
import com.yogi.master.model.VehicleMaintenanceUpdate;
import com.yogi.master.model.Vehicles;
import com.yogi.master.service.VehicleReportService;
import com.yogi.master.service.VehicleService;

@Service("vehicleReportService")
public class VehicleReportServiceImpl implements VehicleReportService{

	
	@Autowired
	private AssignmentFuelUpdateDao assignmentFuelUpdateDao;

	@Autowired
	private VehicleMaintenanceUpdateDao vehicleMaintenanceUpdateDao;

	@Transactional(readOnly=true)
	@Override
	public VehicleReport loadVehicleReport(Long vehicleId, String reportMonth, String reportYear) {

		VehicleReport vehicleReport = new VehicleReport();
		
		VehicleFuelUpdateDTO vehicleFuelUpdateDTO = null;
		
		double rateCharged = 0;
		
		VehicleMaintenanceUpdateDTO vehicleMaintenanceUpdateDTO = null;
		
		List<AssignmentFuelUpdate> assignmentFuelUpdates = assignmentFuelUpdateDao.findAllAssignmentFuelUpdates(vehicleId, reportMonth, reportYear);
		
		List<VehicleMaintenanceUpdate> vehicleMaintenanceUpdates = vehicleMaintenanceUpdateDao.findAllVehicleMaintenanceUpdates(vehicleId, reportMonth, reportYear);
		
		for(AssignmentFuelUpdate assignmentFuelUpdate:assignmentFuelUpdates){
			vehicleFuelUpdateDTO = new VehicleFuelUpdateDTO();
			vehicleFuelUpdateDTO.setAssignment_name(assignmentFuelUpdate.getAssignment().getAssignment_name());
			vehicleFuelUpdateDTO.setEntry_date(assignmentFuelUpdate.getEntry_date());
			vehicleFuelUpdateDTO.setEntry_type(assignmentFuelUpdate.getEntry_type());
			vehicleFuelUpdateDTO.setFuel_bill_amt(assignmentFuelUpdate.getFuel_bill_amt());
			vehicleFuelUpdateDTO.setFuel_quantity(assignmentFuelUpdate.getFuel_quantity());
			vehicleFuelUpdateDTO.setFuel_rate(assignmentFuelUpdate.getFuel_rate());
			vehicleFuelUpdateDTO.setReceipt_no(assignmentFuelUpdate.getReceipt_no());
			vehicleFuelUpdateDTO.setVehicle_km_reading(assignmentFuelUpdate.getVehicle_km_reading());
			
			vehicleReport.setTotalRateCharged(assignmentFuelUpdate.getRate().getRate_charged());
			vehicleReport.addVehicleFuelUpdateDTO(vehicleFuelUpdateDTO);
			vehicleReport.setTotalKmsCovered(assignmentFuelUpdate.getVehicle_km_reading().subtract(assignmentFuelUpdates.get(0).getVehicle_km_reading()));
			vehicleReport.setTotalFuelUsed(vehicleReport.getTotalFuelUsed() + assignmentFuelUpdate.getFuel_quantity());
			vehicleReport.setAvgFuelRate(vehicleReport.getAvgFuelRate() + assignmentFuelUpdate.getFuel_rate());
		}
		if(assignmentFuelUpdates!=null && assignmentFuelUpdates.size()>0){
			vehicleReport.setAvgFuelRate(vehicleReport.getAvgFuelRate()/assignmentFuelUpdates.size());
			
		}
		for(VehicleMaintenanceUpdate vehicleMaintenanceUpdate:vehicleMaintenanceUpdates){
			vehicleMaintenanceUpdateDTO = new VehicleMaintenanceUpdateDTO();
			vehicleMaintenanceUpdateDTO.setMaintenance_amt(vehicleMaintenanceUpdate.getMaintenance_amt());
			vehicleMaintenanceUpdateDTO.setMaintenance_date(vehicleMaintenanceUpdate.getMaintenance_date());
			vehicleMaintenanceUpdateDTO.setMaintenance_desc(vehicleMaintenanceUpdate.getMaintenance_desc());
			vehicleMaintenanceUpdateDTO.setReceipt_no(vehicleMaintenanceUpdate.getReceipt_no());
			
			vehicleReport.addVehicleMaintenanceUpdateDTO(vehicleMaintenanceUpdateDTO);
			vehicleReport.setTotalMaintenanceCost(vehicleReport.getTotalMaintenanceCost()+vehicleMaintenanceUpdate.getMaintenance_amt());
		}
		
		return vehicleReport;
	}

	
	

}
