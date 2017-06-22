package com.kachhepati.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kachhepati.service.RouteService;
import com.kachhepati.vo.RouteVO;
import com.kachhepati.vo.VehicleVO;

@Service
@Path("/route")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class RouteRest {

	@Autowired
	private RouteService service;

	@GET
	public String getMessage() {
		return "test rest";
	}

	@GET
	@Path("/{id}")
	public Response findRoute(@PathParam("id") final Long pK) {

		RouteVO vo = service.find(pK);
		return Response.ok().entity(vo).build();
	}

	@GET
	@Path("/all")
	public Response getRoute() {
		final List<RouteVO> result = service.getRoutes();
		RouteList list = new RouteList(result);
		System.out.println(list);
		return Response.ok().entity(list).build();
	}

	@GET
	@Path("/routeId")
	public Response searchByRouteId(@QueryParam("routeId") final Long routeId){
		final RouteVO vo =service.searchByRouteId(routeId);
		List <RouteVO> listVO = new ArrayList<RouteVO>();
		listVO.add(vo);
		RouteList VOList = new RouteList();
		VOList.setRoutes(listVO);
		return Response.ok().entity(VOList).build();
	}
	
	@POST
	public Response createRoute(RouteVO vo) {
		RouteVO result = service.create(vo);
		return Response.ok().entity(result).build();
	}

	@PUT
	public Response updateRoute(RouteVO vo) {
		RouteVO result = service.update(vo);
		return Response.ok().entity(result).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteRoute(@PathParam("id") final Long pK) {
		service.delete(pK);
		return Response.noContent().build();
	}

	@GET
	@Path("/routename")
	public Response searchRouteName(@QueryParam("routeName") final String routeName) {
		final List<RouteVO> vo = service.searchByRouteName(routeName);
		RouteList list = new RouteList(vo);
		return Response.ok().entity(list).build();
	}

}
