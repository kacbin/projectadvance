package com.kachhepati.rest;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import com.kachhepati.vo.RouteVO;
import com.kachhepati.vo.VehicleVO;


@XmlRootElement
public class RouteList {

	private List<RouteVO> routes;

	public RouteList() {

	}

	public RouteList(List<RouteVO> routes) {
		super();
		this.routes = routes;
	}

	public List<RouteVO> getRoutes() {
		return routes;
	}

	public void setRoutes(List<RouteVO> routes) {
		this.routes = routes;
	}

}
