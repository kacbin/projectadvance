package com.kachhepati.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kachhepati.entity.VehicleEntity;
import com.kachhepati.vo.VehicleVO;

@Component
public class VehicleMapper {

	public VehicleEntity mapToEntity(final VehicleEntity entity, final VehicleVO vo) {
		entity.setVehicleId(vo.getVehicleId());
		entity.setRegisNum(vo.getRegisNum());
		entity.setVehicleMake(vo.getVehicleMake());
		entity.setVehicleType(vo.getVehicleType());
		entity.setVehicleYear(vo.getVehicleYear());
		entity.setVehicleStatus(vo.getVehicleStatus());
		return entity;

	}

	public VehicleVO mapToVO(final VehicleEntity entity) {
		VehicleVO vo = new VehicleVO();

		vo.setVehicleId(entity.getVehicleId());
		vo.setRegisNum(entity.getRegisNum());
		vo.setVehicleMake(entity.getVehicleMake());
		vo.setVehicleType(entity.getVehicleType());
		vo.setVehicleYear(entity.getVehicleYear());
		vo.setVehicleStatus(entity.getVehicleStatus());

		return vo;
	}

	public List<VehicleVO> mapToVehicleList(final List<VehicleEntity> entities) {
		List<VehicleVO> results = new ArrayList<VehicleVO>();

		for (VehicleEntity entity : entities) {
			results.add(mapToVO(entity));
		}

		return results;
	}

}
