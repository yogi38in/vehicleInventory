package com.yogi.master.dto;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;

import org.hibernate.annotations.Type;

import com.yogi.master.model.Vehicles;


public class VehicleMaintenanceUpdateDTO {
	
	
	private String maintenance_desc;
	
	private String receipt_no;
	
	private Date maintenance_date;
	
	private Double maintenance_amt;

	public String getMaintenance_desc() {
		return maintenance_desc;
	}

	public void setMaintenance_desc(String maintenance_desc) {
		this.maintenance_desc = maintenance_desc;
	}

	public String getReceipt_no() {
		return receipt_no;
	}

	public void setReceipt_no(String receipt_no) {
		this.receipt_no = receipt_no;
	}

	public Date getMaintenance_date() {
		return maintenance_date;
	}

	public void setMaintenance_date(Date maintenance_date) {
		this.maintenance_date = maintenance_date;
	}

	public Double getMaintenance_amt() {
		return maintenance_amt;
	}

	public void setMaintenance_amt(Double maintenance_amt) {
		this.maintenance_amt = maintenance_amt;
	}
}
