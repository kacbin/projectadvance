package com.kachhepati.service;

import java.util.List;

import com.kachhepati.vo.RouteVO;
import com.kachhepati.vo.VehicleVO;

public interface RouteService {
	RouteVO create(RouteVO vo);

	RouteVO update(RouteVO vo);

	RouteVO find(final Long id);

	void delete(final Long id);
	RouteVO searchByRouteId(final Long routeId);

	List<RouteVO> getRoutes();

	List<RouteVO> searchByRouteName(final String routeName);



}
