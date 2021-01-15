package com.altimetrik.hall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Hall")
public class Hall {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HallId")
	private int id;
	@Column(name = "HallName")
	private String hallName;
	@Column(name = "HallOwnerName")
	private String hallOwnerName;
	@Column(name = "OwnerEmail")
	private String ownerEmailId;
	@Column(name = "OwnerContact")
	private String ownerMobile;
	@Column(name = "CostPerDay")
	private int hallFare;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHallName() {
		return hallName;
	}

	public void setHallName(String hallName) {
		this.hallName = hallName;
	}

	public String getHallOwnerName() {
		return hallOwnerName;
	}

	public void setHallOwnerName(String hallOwnerName) {
		this.hallOwnerName = hallOwnerName;
	}

	public String getOwnerEmailId() {
		return ownerEmailId;
	}

	public void setOwnerEmailId(String ownerEmailId) {
		this.ownerEmailId = ownerEmailId;
	}

	public String getOwnerMobile() {
		return ownerMobile;
	}

	public void setOwnerMobile(String ownerMobile) {
		this.ownerMobile = ownerMobile;
	}

	public int getHallFare() {
		return hallFare;
	}

	public void setHallFare(int hallFare) {
		this.hallFare = hallFare;
	}

}
