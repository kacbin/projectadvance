package com.kachhepati.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kachhepati.service.QueryConstant;

@Entity
@Table(name="ROUTE")
@NamedQueries({
@NamedQuery(name=QueryConstant.ROUTE_SEARCH_ROUTENAME, query="select c from RouteEntity c where UPPER(c.routeName) like UPPER(:routeName)"),
@NamedQuery(name=QueryConstant.ROUTE_ALL, query="select c from RouteEntity c"),
@NamedQuery(name=QueryConstant.ROUTE_SEARCH_ROUTE_ID, query="select c from RouteEntity c where c.routeId = :routeId")
})

public class RouteEntity {
	@Id
	@SequenceGenerator(name="routeSeq2", sequenceName="VEHICLE_SEQ_1", allocationSize = 1)
	@GeneratedValue(generator="routeSeq2")
	@Column(name="ROUTE_ID")
	private Long routeId;
	
	@Column(name="START_DEST")
	private String startDest;
	
	@Column(name="END_DEST")
	private String endDest;
	
	@Column(name="DEPARTURE_TIME")
	private String departTime; 
	
	@Column(name="EST_ARV_TIME")
	private String estArrivalTime; 
	
	@Column(name="ROUTE_NAME")
	private String routeName;
	
	@Column(name="STATUS")
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
