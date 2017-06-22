package com.kachhepati.service;

import java.util.List;

import com.kachhepati.vo.VehicleVO;

public interface VehicleService {

	VehicleVO create(VehicleVO vo);

	VehicleVO update(VehicleVO vo);

	VehicleVO find(final Long id);

	public void delete(final Long id);

	List<VehicleVO> getVehicles();

	
	VehicleVO searchByVehicleRegNum(final Long vehicleRegNum);
	
	List<VehicleVO> searchByVehicleType(final String vehicleType);

	List<VehicleVO> searchByVehicleMake(final String vehicleType);
}
