package com.yogi.master.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "vehicle_maintenance_update", catalog = "yogesh", uniqueConstraints = @UniqueConstraint(columnNames = {"vehicle_maintenance_update_id" }))
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
public class VehicleMaintenanceUpdate {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "vehicle_maintenance_update_id", unique = true, nullable = false)
	private Integer vehicle_maintenance_update_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_id", nullable = false)
	private Vehicles vehicle;
	
	@Column(name = "maintenance_desc", nullable = false, length = 45)
	private String maintenance_desc;
	
	@Column(name = "receipt_no", nullable = false, length = 45)
	private String receipt_no;
	
	@Type(type="timestamp")
	@Column(name = "maintenance_date", nullable = false)
	private Date maintenance_date;
	
	@Column(name = "maintenance_amt", nullable = false, length = 45)
	private Double maintenance_amt;

	
	public VehicleMaintenanceUpdate() {
	}


	public Integer getVehicle_maintenance_update_id() {
		return vehicle_maintenance_update_id;
	}


	public void setVehicle_maintenance_update_id(
			Integer vehicle_maintenance_update_id) {
		this.vehicle_maintenance_update_id = vehicle_maintenance_update_id;
	}


	public Vehicles getVehicle() {
		return vehicle;
	}


	public void setVehicle(Vehicles vehicle) {
		this.vehicle = vehicle;
	}


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
