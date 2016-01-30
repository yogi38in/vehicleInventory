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

import org.apache.commons.lang.time.DateUtils;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "vehicle_assignment", catalog = "yogesh", uniqueConstraints = @UniqueConstraint(columnNames = {"vehicle_id" , "assignment_id", "rate_id" }))
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
public class VehicleAssignment {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "vehicle_assignment_id", unique = true, nullable = false)
	private Integer vehicle_assignment_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_id", nullable = false)
	private Vehicles vehicle;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assignment_id", nullable = false)
	private Assignment assignment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rate_id", nullable = false)
	private Rate rate;
	
	@Type(type="timestamp")
	@Column(name = "assignment_start_date", nullable = false)
	private Date assignment_start_date;
	
	
	@Type(type="timestamp")
	@Column(name = "assignment_end_date", nullable = false)
	private Date assignment_end_date;
	
	public VehicleAssignment() {
	}

	public Integer getVehicle_assignment_id() {
		return vehicle_assignment_id;
	}


	public void setVehicle_assignment_id(Integer vehicle_assignment_id) {
		this.vehicle_assignment_id = vehicle_assignment_id;
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


	public Date getAssignment_start_date() {
		return assignment_start_date;
	}

	public void setAssignment_start_date(Date assignment_start_date) {
		this.assignment_start_date = assignment_start_date;
	}

	public Date getAssignment_end_date() {
		return assignment_end_date;
	}

	public void setAssignment_end_date(Date assignment_end_date) {
		this.assignment_end_date = assignment_end_date;
	}

	public Rate getRate() {
		return rate;
	}


	public void setRate(Rate rate) {
		this.rate = rate;
	}

}
