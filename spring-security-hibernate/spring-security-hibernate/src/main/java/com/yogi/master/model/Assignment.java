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
@Table(name = "assignment", catalog = "yogesh", uniqueConstraints = @UniqueConstraint(columnNames = {"assignment_id" }))
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
public class Assignment {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "assignment_id", unique = true, nullable = false)
	private Integer assignment_id;
	
	
	@Column(name = "assignment_name", nullable = false, length = 45)
	private String assignment_name;
	
	@Column(name = "assignment_start_date", nullable = false, length = 45)
	private String assignment_start_date;
	
	@Column(name = "assignment_contact", nullable = false, length = 45)
	private String assignment_contact;
	

	public Assignment() {
	}


	public Integer getAssignment_id() {
		return assignment_id;
	}


	public void setAssignment_id(Integer assignment_id) {
		this.assignment_id = assignment_id;
	}


	public String getAssignment_name() {
		return assignment_name;
	}


	public void setAssignment_name(String assignment_name) {
		this.assignment_name = assignment_name;
	}


	public String getAssignment_start_date() {
		return assignment_start_date;
	}


	public void setAssignment_start_date(String assignment_start_date) {
		this.assignment_start_date = assignment_start_date;
	}


	public String getAssignment_contact() {
		return assignment_contact;
	}


	public void setAssignment_contact(String assignment_contact) {
		this.assignment_contact = assignment_contact;
	}
	
	

	
}
