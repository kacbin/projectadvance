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

import com.kachhepati.service.VehicleService;
import com.kachhepati.vo.RouteVO;
import com.kachhepati.vo.VehicleVO;



@Service
@Path("/vehicle")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class VehicleRest {

	@Autowired
	private VehicleService service;

		
	@GET
	public String getMessage(){
		return "test rest";
	}
	
	@GET
	@Path("/{id}")
	public Response findVehicle(@PathParam("id") final Long pK) {

		VehicleVO vo = service.find(pK);
		return Response.ok().entity(vo).build();
	}

	@GET
	@Path("/all")
	public Response getVehicle() {
		final List<VehicleVO> result = service.getVehicles();
		VehicleList list = new VehicleList(result);
		System.out.println(list);
		return Response.ok().entity(list).build();
	}
	
	@POST
	public Response createVehicle(VehicleVO vo){
		VehicleVO result = service.create(vo);
		return Response.ok().entity(result).build();
	}
	
	@PUT
	public Response updateVehicle(VehicleVO vo){
		VehicleVO result = service.update(vo);
		return Response.ok().entity(result).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteVehicle(@PathParam("id") final Long pK ){
		service.delete(pK);
		return Response.noContent().build();
	}
	
	@GET
	@Path("/vehiclenumber")
	public Response searchVehicleRegNum(@QueryParam("vehicleRegNum") final Long vehicleRegNum){
		final VehicleVO vo =service.searchByVehicleRegNum(vehicleRegNum);
		
		List <VehicleVO> listVO = new ArrayList<VehicleVO>();
		listVO.add(vo);
		VehicleList VOList = new VehicleList();
		VOList.setVehicles(listVO);
		return Response.ok().entity(VOList).build();
	}
	@GET
	@Path("/vehiclemake")
	public Response searchVehicleMake(@QueryParam("vehicleMake") final String vehicleMake){
		final List<VehicleVO> vo =service.searchByVehicleMake(vehicleMake);
		VehicleList list = new VehicleList(vo);
		return Response.ok().entity(list).build();
	}
	@GET
	@Path("/vehicletype")
	public Response searchVehicleType(@QueryParam("vehicleType") final String vehicleType){
		final List<VehicleVO> vo =service.searchByVehicleType(vehicleType);
		VehicleList list = new VehicleList(vo);
		return Response.ok().entity(list).build();
	}

}
