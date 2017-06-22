package com.kachhepati.rest.provider;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.kachhepati.vo.ErrorResponse;
@Provider
@Component
@Produces(MediaType.APPLICATION_JSON)
public class IllegalArgumentHandler implements ExceptionMapper<IllegalArgumentException> {

	public Response toResponse(IllegalArgumentException exception) {
		ErrorResponse error = new ErrorResponse();
		error.setCode("CUST-440");
		error.setError(exception.getMessage());
		return Response.status(515).entity(error).type(MediaType.APPLICATION_JSON).build();
	}

}
