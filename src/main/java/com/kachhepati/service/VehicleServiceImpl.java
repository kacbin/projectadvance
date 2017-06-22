package com.kachhepati.service;

import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.kachhepati.entity.RouteEntity;
import com.kachhepati.entity.VehicleEntity;
import com.kachhepati.mapper.VehicleMapper;
import com.kachhepati.vo.VehicleVO;

import com.kachhepati.exception.ValidationException;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private VehicleMapper mapper;

	public VehicleVO create(final VehicleVO input) {
		validateVehicle(input);
		VehicleEntity entity = mapper.mapToEntity(new VehicleEntity(), input);
		em.persist(entity);
		input.setVehicleId(entity.getVehicleId());
		return input;

	}

	public VehicleVO update(final VehicleVO input) {
		validateVehicle(input);
		VehicleEntity entity = em.find(VehicleEntity.class, input.getVehicleId());
		if (entity == null) {
			throw new ValidationException(" Cannot find in the database system");
		} else {
		entity = mapper.mapToEntity(entity, input);
		em.persist(entity);
		return input;
		}
	}

	public VehicleVO find(Long id) {
		VehicleEntity entity = em.find(VehicleEntity.class, id);
		if (entity == null) {
			throw new ValidationException(" Cannot find in the database system");
		} else {

			VehicleVO input_vo = mapper.mapToVO(entity);

			return input_vo;
		}
	}

	public void delete(Long id) {
		VehicleEntity entity = em.find(VehicleEntity.class, id);
		em.remove(entity);

	}

	public List<VehicleVO> getVehicles() {
		TypedQuery<VehicleEntity> query = em.createNamedQuery(QueryConstant.VEHICLE_ALL, VehicleEntity.class);
		List<VehicleEntity> result_list = query.getResultList();
		return mapper.mapToVehicleList(result_list);

	}

	private void validateVehicle(final VehicleVO vo) {
		if (StringUtils.isEmpty(vo.getRegisNum()) || StringUtils.isEmpty(vo.getVehicleYear())
				|| StringUtils.isEmpty(vo.getVehicleMake()) || StringUtils.isEmpty(vo.getVehicleStatus())
				|| StringUtils.isEmpty(vo.getVehicleType())) {
			throw new ValidationException("Every inputs must not be left empty !!");
		}

		if (!Pattern.matches("[a-zA-Z]+", vo.getVehicleMake()) || !Pattern.matches("[a-zA-Z]+", vo.getVehicleStatus())
				|| !Pattern.matches("[a-zA-Z]+", vo.getVehicleType())) {

			throw new ValidationException(" VehicleMake or VehicleType or VehicleStatus should not contain intergers");
		}
	}

	@Override
	public List<VehicleVO> searchByVehicleType(String vehicleType) {
		String vName = StringUtils.isEmpty(vehicleType) ? "%" : vehicleType.trim() + "%";

		TypedQuery<VehicleEntity> query = em.createNamedQuery(QueryConstant.VEHICLE_SEARCH_VEHICLETYPE,
				VehicleEntity.class);
		query.setParameter("vehicleType", vName);

		List<VehicleEntity> entityList = query.getResultList();
		return mapper.mapToVehicleList(entityList);
	}

	@Override
	public List<VehicleVO> searchByVehicleMake(String vehicleMake) {
		String vName = StringUtils.isEmpty(vehicleMake) ? "%" : vehicleMake.trim() + "%";

		TypedQuery<VehicleEntity> query = em.createNamedQuery(QueryConstant.VEHICLE_SEARCH_VEHICLEMAKE,
				VehicleEntity.class);
		query.setParameter("vehicleMake", vName);

		List<VehicleEntity> entityList = query.getResultList();
		return mapper.mapToVehicleList(entityList);
	}

	@Override
	public VehicleVO searchByVehicleRegNum(Long vehicleRegNum) {

		TypedQuery<VehicleEntity> query = em.createNamedQuery(QueryConstant.VEHICLE_SEARCH_VEHICLEREGNUM,
				VehicleEntity.class);
		query.setParameter("vehicleRegNum", vehicleRegNum);

		VehicleEntity entityList = query.getSingleResult();
		return mapper.mapToVO(entityList);
		
	}
	
		public VehicleVO searchByVehicleId(Long vehicleId) {

			TypedQuery<VehicleEntity> query = em.createNamedQuery(QueryConstant.VEHICLE_SEARCH_VEHICLE_ID,
					VehicleEntity.class);
			query.setParameter("vehicleId", vehicleId);

			VehicleEntity entityList = query.getSingleResult();
			return mapper.mapToVO(entityList);
	}

}
