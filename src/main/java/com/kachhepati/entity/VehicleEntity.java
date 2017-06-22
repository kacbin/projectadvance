package com.kachhepati.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kachhepati.service.QueryConstant;


@Entity
@Table(name = "VEHICLE")
@NamedQueries({
@NamedQuery(name=QueryConstant.VEHICLE_SEARCH_VEHICLEMAKE, query="select c from VehicleEntity c where UPPER(c.vehicleMake) like UPPER(:vehicleMake)"),
@NamedQuery(name=QueryConstant.VEHICLE_SEARCH_VEHICLETYPE, query="select c from VehicleEntity c where UPPER(c.vehicleType) like UPPER(:vehicleType)"),
@NamedQuery(name=QueryConstant.VEHICLE_ALL, query="select c from VehicleEntity c"),
@NamedQuery(name=QueryConstant.VEHICLE_SEARCH_VEHICLEREGNUM, query="select c from VehicleEntity c where c.regisNum = :vehicleRegNum")})
public class VehicleEntity {

	@Id
	@SequenceGenerator(name="vecSeq2", sequenceName="VEHICLE_SEQ_1", allocationSize = 1)
	@GeneratedValue(generator="vecSeq2")
	@Column(name="VEHICLE_ID")
	private Long vehicleId;

	@Column(name="VEHICLE_YEAR")
	private Long vehicleYear;

	@Column(name="REGIS_NUM")
	private Long regisNum;

	@Column(name="VEHICLE_MAKE")
	private String vehicleMake;
	
	@Column(name="VEHICLE_TYPE")
	private String vehicleType;

	@Column(name="VEHICLE_STATUS")
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

	@Override
	public String toString() {
		return "VehicleEntity [vehicleId=" + vehicleId + ", vehicleYear=" + vehicleYear + ", regisNum=" + regisNum
				+ ", vehicleMake=" + vehicleMake + ", vehicleType=" + vehicleType + ", vehicleStatus=" + vehicleStatus
				+ "]";
	}
	


}
