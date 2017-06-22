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
import com.kachhepati.exception.DataNotFoundException;
import com.kachhepati.exception.ValidationException;
import com.kachhepati.mapper.RouteMapper;
import com.kachhepati.vo.RouteVO;
import com.kachhepati.vo.VehicleVO;

@Service
@Transactional
public class RouteServiceImpl implements RouteService {
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private RouteMapper mapper;

	@Override
	public RouteVO create(RouteVO vo) {
		validateRoute(vo);
		RouteEntity entity = mapper.mapToEntity(new RouteEntity(), vo);
		em.persist(entity);
		vo.setRouteId(entity.getRouteId());
		return vo;

	}

	@Override
	public RouteVO update(final RouteVO input) {
		validateRoute(input);
		RouteEntity entity = em.find(RouteEntity.class, input.getRouteId());
		if (entity == null) {
			throw new ValidationException(" Cannot find in the database system");
		} else {
		entity = mapper.mapToEntity(entity, input);
		em.persist(entity);
		return input;
		}
	}

	@Override
	public RouteVO find(Long id) {
		RouteEntity entity = em.find(RouteEntity.class, id);
		System.out.println(entity);
		if (entity == null) {
			throw new ValidationException(" Cannot find in the database system");
		} else {

			RouteVO input_vo = mapper.mapToVO(entity);

			return input_vo;
		}
	}

	@Override
	public void delete(Long id) {
		RouteEntity entity = em.find(RouteEntity.class, id);
		em.remove(entity);

	}

	@Override
	public List<RouteVO> getRoutes() {
		TypedQuery<RouteEntity> query = em.createNamedQuery(QueryConstant.ROUTE_ALL, RouteEntity.class);
		List<RouteEntity> result_list = query.getResultList();
		return mapper.mapToRouteList(result_list);
	}
	

	private void validateRoute(final RouteVO vo) {
		if (StringUtils.isEmpty(vo.getStartDest()) || StringUtils.isEmpty(vo.getEndDest())
				|| StringUtils.isEmpty(vo.getStatus()) || StringUtils.isEmpty(vo.getDepartTime())
				|| StringUtils.isEmpty(vo.getEstArrivalTime())) {

			throw new ValidationException("Every inputs must not be empty !!");
		}

		if (Pattern.matches("[1,2,3,4,5,6,7,8,9,0,:,a,m,p]", vo.getDepartTime())
				|| Pattern.matches("[1,2,3,4,5,6,7,8,9,0,:,h,r,s]", vo.getEstArrivalTime())) {
			System.out.println(!Pattern.matches("[1,2,3,4,5,6,7,8,9,0,:,a,m,p]+", vo.getDepartTime()));
			System.out.println(!Pattern.matches("[1,2,3,4,5,6,7,8,9,0,:,a,m,p]+", vo.getEstArrivalTime()));
			throw new DataNotFoundException(
					
					" EstimatedHours or DepartureTime should not be in the Standard format form 00:00 pm/am or 00:00 hrs");

		}

	}

	@Override
	public List<RouteVO> searchByRouteName(String routeName) {
		String rName = StringUtils.isEmpty(routeName) ? "%" : routeName.trim() + "%";

				TypedQuery<RouteEntity> query = em.createNamedQuery(QueryConstant.ROUTE_SEARCH_ROUTENAME, RouteEntity.class);
				query.setParameter("routeName", rName);

				List<RouteEntity> entityList = query.getResultList();
				return mapper.mapToRouteList(entityList);
	}
	
	public RouteVO searchByRouteId(Long routeId) {

		TypedQuery<RouteEntity> query = em.createNamedQuery(QueryConstant.ROUTE_SEARCH_ROUTE_ID,
				RouteEntity.class);
		query.setParameter("routeId", routeId);

		RouteEntity entityList = query.getSingleResult();
		return mapper.mapToVO(entityList);
}

	



}
