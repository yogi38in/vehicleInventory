package com.yogi.master.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "rate", catalog = "yogesh", uniqueConstraints = @UniqueConstraint(columnNames = {"rate_name","energy_source_name","rate_charged" }))
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
public class Rate {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "rate_id", unique = true, nullable = false)
	private Integer rate_id;
	
	
	@Column(name = "rate_name", nullable = false, length = 45)
	private String rate_name;
	
	@Column(name = "energy_source_name", nullable = false, length = 1)
	private String energy_source_name;
	
	@Column(name = "rate_charged", nullable = false, length = 45)
	private Double rate_charged;
	

	public Rate() {
	}


	public Integer getRate_id() {
		return rate_id;
	}


	public void setRate_id(Integer rate_id) {
		this.rate_id = rate_id;
	}


	public String getRate_name() {
		return rate_name;
	}


	public void setRate_name(String rate_name) {
		this.rate_name = rate_name;
	}


	public String getEnergy_source_name() {
		return energy_source_name;
	}


	public void setEnergy_source_name(String energy_source_name) {
		this.energy_source_name = energy_source_name;
	}


	public Double getRate_charged() {
		return rate_charged;
	}


	public void setRate_charged(Double rate_charged) {
		this.rate_charged = rate_charged;
	}


	
}
