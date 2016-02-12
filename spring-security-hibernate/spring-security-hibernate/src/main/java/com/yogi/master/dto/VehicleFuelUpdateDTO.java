package com.yogi.master.dto;

import java.math.BigInteger;
import java.util.Date;


public class VehicleFuelUpdateDTO {
	
	
	private String assignment_name;
	
	private Double fuel_quantity;

	private Double fuel_rate;
	
	private Double fuel_bill_amt;
	
	private BigInteger vehicle_km_reading;
	
	private String entry_type;
	
	private String receipt_no;
	
	private Date entry_date;

	public String getAssignment_name() {
		return assignment_name;
	}

	public void setAssignment_name(String assignment_name) {
		this.assignment_name = assignment_name;
	}

	public Double getFuel_quantity() {
		return fuel_quantity;
	}

	public void setFuel_quantity(Double fuel_quantity) {
		this.fuel_quantity = fuel_quantity;
	}

	public Double getFuel_rate() {
		return fuel_rate;
	}

	public void setFuel_rate(Double fuel_rate) {
		this.fuel_rate = fuel_rate;
	}

	public Double getFuel_bill_amt() {
		return fuel_bill_amt;
	}

	public void setFuel_bill_amt(Double fuel_bill_amt) {
		this.fuel_bill_amt = fuel_bill_amt;
	}

	public BigInteger getVehicle_km_reading() {
		return vehicle_km_reading;
	}

	public void setVehicle_km_reading(BigInteger vehicle_km_reading) {
		this.vehicle_km_reading = vehicle_km_reading;
	}

	public String getEntry_type() {
		return entry_type;
	}

	public void setEntry_type(String entry_type) {
		this.entry_type = entry_type;
	}

	public String getReceipt_no() {
		return receipt_no;
	}

	public void setReceipt_no(String receipt_no) {
		this.receipt_no = receipt_no;
	}

	public Date getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}

}
