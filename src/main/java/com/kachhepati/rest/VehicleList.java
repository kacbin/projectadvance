package com.kachhepati.rest;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import com.kachhepati.vo.VehicleVO;


@XmlRootElement
public class VehicleList {

	private List<VehicleVO> vehicles;

	public VehicleList() {

	}

	public VehicleList(List<VehicleVO> vehicles) {
		super();
		this.vehicles = vehicles;
	}

	public List<VehicleVO> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<VehicleVO> vehicles) {
		this.vehicles = vehicles;
	}

}
