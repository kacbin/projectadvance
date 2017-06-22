package com.kachhepati.rest.provider;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.kachhepati.exception.DataNotFoundException;
import com.kachhepati.exception.ValidationException;
import com.kachhepati.vo.ErrorResponse;

@Provider
@Component
@Produces(MediaType.APPLICATION_JSON)
public class DataNotFoundExceptionHandler implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();
		error.setCode("CUST-400");
		error.setError(exception.getMessage());
		return Response.status(525).entity(error).type(MediaType.APPLICATION_JSON).build();
	
	}

	

		
}
