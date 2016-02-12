package com.yogi.master.dto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = false)
public class VehicleReport {

	private String vehicle_name;
	
	private String monthYear;
	
	private BigInteger totalKmsCovered = new BigInteger("0");
	
	private Double totalMaintenanceCost = 0.0;
	
	private Double totalFuelUsed = 0.0;
	
	private Double totalCost = 0.0;
	
	private Double totalRateCharged = 0.0;
	
	private Double avgFuelRate = 0.0;
	
	private List<VehicleFuelUpdateDTO> vehicleFuelUpdateDTOs = new ArrayList<VehicleFuelUpdateDTO>();
	
	private List<VehicleMaintenanceUpdateDTO> vehicleMaintenanceUpdateDTOs = new ArrayList<VehicleMaintenanceUpdateDTO>();

	public String getVehicle_name() {
		return vehicle_name;
	}

	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	public BigInteger getTotalKmsCovered() {
		return totalKmsCovered;
	}

	public void setTotalKmsCovered(BigInteger totalKmsCovered) {
		this.totalKmsCovered = totalKmsCovered;
	}

	public Double getTotalMaintenanceCost() {
		return totalMaintenanceCost;
	}

	public void setTotalMaintenanceCost(Double totalMaintenanceCost) {
		this.totalMaintenanceCost = totalMaintenanceCost;
	}

	public Double getTotalFuelUsed() {
		return totalFuelUsed;
	}

	public void setTotalFuelUsed(Double totalFuelUsed) {
		this.totalFuelUsed = totalFuelUsed;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Double getTotalRateCharged() {
		return totalRateCharged;
	}

	public void setTotalRateCharged(Double totalRateCharged) {
		this.totalRateCharged = totalRateCharged;
	}

	public List<VehicleFuelUpdateDTO> getVehicleFuelUpdateDTOs() {
		return vehicleFuelUpdateDTOs;
	}

	public void addVehicleFuelUpdateDTO(VehicleFuelUpdateDTO vehicleFuelUpdateDTO) {
		this.vehicleFuelUpdateDTOs.add(vehicleFuelUpdateDTO) ;
	}

	public List<VehicleMaintenanceUpdateDTO> getVehicleMaintenanceUpdateDTOs() {
		return vehicleMaintenanceUpdateDTOs;
	}

	public void addVehicleMaintenanceUpdateDTO(VehicleMaintenanceUpdateDTO vehicleMaintenanceUpdateDTO) {
		this.vehicleMaintenanceUpdateDTOs.add(vehicleMaintenanceUpdateDTO);
	}

	public void setVehicleFuelUpdateDTOs(
			List<VehicleFuelUpdateDTO> vehicleFuelUpdateDTOs) {
		this.vehicleFuelUpdateDTOs = vehicleFuelUpdateDTOs;
	}

	public void setVehicleMaintenanceUpdateDTOs(
			List<VehicleMaintenanceUpdateDTO> vehicleMaintenanceUpdateDTOs) {
		this.vehicleMaintenanceUpdateDTOs = vehicleMaintenanceUpdateDTOs;
	}

	public Double getAvgFuelRate() {
		return avgFuelRate;
	}

	public void setAvgFuelRate(Double avgFuelRate) {
		this.avgFuelRate = avgFuelRate;
	}

	
	
	
	
}
