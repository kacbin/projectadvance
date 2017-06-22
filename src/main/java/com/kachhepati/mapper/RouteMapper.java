package com.kachhepati.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kachhepati.entity.RouteEntity;

import com.kachhepati.vo.RouteVO;
@Component
public class RouteMapper {

	public RouteEntity mapToEntity(final RouteEntity entity, final RouteVO vo) {
		entity.setRouteId(vo.getRouteId());
		entity.setStartDest(vo.getStartDest());
		entity.setEndDest(vo.getEndDest());
		entity.setDepartTime(vo.getDepartTime());
		entity.setEstArrivalTime(vo.getEstArrivalTime());
		entity.setRouteName("RT_"+vo.getStartDest()+"_"+vo.getEndDest());
		entity.setStatus(vo.getStatus());;
		return entity;

	}

	public RouteVO mapToVO(final RouteEntity entity) {
		RouteVO vo = new RouteVO();
		vo.setRouteId(entity.getRouteId());
		vo.setStartDest(entity.getStartDest());
		vo.setEndDest(entity.getEndDest());
		vo.setDepartTime(entity.getDepartTime());
		vo.setEstArrivalTime(entity.getEstArrivalTime());
		vo.setRouteName(entity.getRouteName());
		vo.setStatus(entity.getStatus());
		return vo;

	}

	public List<RouteVO> mapToRouteList(final List<RouteEntity> entities) {
		List<RouteVO> results = new ArrayList<RouteVO>();

		for (RouteEntity entity : entities) {
			results.add(mapToVO(entity));
		}

		return results;
	}

}
