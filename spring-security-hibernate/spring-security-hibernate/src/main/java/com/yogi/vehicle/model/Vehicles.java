package com.yogi.vehicle.model;

import static javax.persistence.GenerationType.IDENTITY;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yogi.users.model.User;

@Entity
@Table(name = "vehicles", catalog = "yogesh", uniqueConstraints = @UniqueConstraint(columnNames = {"vehicle_id" }))
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
public class Vehicles {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "vehicle_id", unique = true, nullable = false)
	private Integer vehicleId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Column(name = "vehicle_name", nullable = false, length = 45)
	private String vehicle_name;
	
	@Column(name = "vehicle_number", nullable = false, length = 45)
	private String vehicle_number;
	
	@Column(name = "vehicle_make", nullable = false, length = 45)
	private String vehicle_make;
	
	@Column(name = "vehicle_model", nullable = false, length = 45)
	private String vehicle_model;

	public Vehicles() {
	}
	
	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getVehicle_name() {
		return vehicle_name;
	}

	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}

	public String getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public String getVehicle_make() {
		return vehicle_make;
	}

	public void setVehicle_make(String vehicle_make) {
		this.vehicle_make = vehicle_make;
	}

	public String getVehicle_model() {
		return vehicle_model;
	}

	public void setVehicle_model(String vehicle_model) {
		this.vehicle_model = vehicle_model;
	}

	
}
