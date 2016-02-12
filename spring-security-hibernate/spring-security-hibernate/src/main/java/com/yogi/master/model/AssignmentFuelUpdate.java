package com.yogi.master.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigInteger;
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
@Table(name = "assignment_fuel_update", catalog = "yogesh", uniqueConstraints = @UniqueConstraint(columnNames = {"assignment_fuel_update_id" }))
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
public class AssignmentFuelUpdate {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "assignment_fuel_update_id", unique = true, nullable = false)
	private Integer assignment_fuel_update_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_id", nullable = false)
	private Vehicles vehicle;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assignment_id", nullable = false)
	private Assignment assignment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rate_id", nullable = false)
	private Rate rate;
	
	@Column(name = "fuel_quantity", nullable = false, length = 45)
	private Double fuel_quantity;

	@Column(name = "fuel_rate", nullable = false, length = 45)
	private Double fuel_rate;
	
	@Column(name = "fuel_bill_amt", nullable = false, length = 45)
	private Double fuel_bill_amt;
	
	@Column(name = "vehicle_km_reading", nullable = false)
	private BigInteger vehicle_km_reading;
	
	@Column(name = "entry_type", nullable = false, length = 1)
	private String entry_type;
	
	@Column(name = "receipt_no", nullable = false, length = 45)
	private String receipt_no;
	
	@Type(type="timestamp")
	@Column(name = "entry_date", nullable = false)
	private Date entry_date;

	public AssignmentFuelUpdate() {
	}

	public Integer getAssignment_fuel_update_id() {
		return assignment_fuel_update_id;
	}

	public void setAssignment_fuel_update_id(Integer assignment_fuel_update_id) {
		this.assignment_fuel_update_id = assignment_fuel_update_id;
	}

	public Vehicles getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicles vehicle) {
		this.vehicle = vehicle;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
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

	public Rate getRate() {
		return rate;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
	}


	

	
}
