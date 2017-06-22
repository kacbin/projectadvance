package com.kachhepati.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RouteVO {

	private Long routeId;

	private String startDest;

	private String endDest;

	private String departTime;

	private String estArrivalTime;

	private String routeName;

	private String status;

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public String getStartDest() {
		return startDest;
	}

	public void setStartDest(String startDest) {
		this.startDest = startDest;
	}

	public String getEndDest() {
		return endDest;
	}

	public void setEndDest(String endDest) {
		this.endDest = endDest;
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getEstArrivalTime() {
		return estArrivalTime;
	}

	public void setEstArrivalTime(String estArrivalTime) {
		this.estArrivalTime = estArrivalTime;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
