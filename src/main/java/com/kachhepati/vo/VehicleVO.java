package com.kachhepati.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VehicleVO {
	private Long vehicleId;
	
	private Long vehicleYear;
	
	private Long regisNum;
	
	private String vehicleMake;
	
	private String vehicleType;
	
	private String vehicleStatus;

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Long getVehicleYear() {
		return vehicleYear;
	}

	public void setVehicleYear(Long vehicleYear) {
		this.vehicleYear = vehicleYear;
	}

	public Long getRegisNum() {
		return regisNum;
	}

	public void setRegisNum(Long regisNum) {
		this.regisNum = regisNum;
	}

	public String getVehicleMake() {
		return vehicleMake;
	}

	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleStatus() {
		return vehicleStatus;
	}

	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	
}
