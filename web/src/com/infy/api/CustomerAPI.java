package com.infy.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.google.gson.Gson;
import com.infy.bean.User;

import com.infy.business.service.UserService;
import com.infy.resources.Factory;

@Path("customer")
public class CustomerAPI {
	
	
	@GET
	@Path("/allcustomer")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getcustomer()
	{
		Response result;
		Gson gson =new Gson();
		try {
			// CODE TO CALL DAO CLASS METHOD FOR GETTING EMPLOYEE DETAILS
			UserService userService=Factory.createUserService();
			
		List<User> user=userService.getAllCustomerDetails();
		
			// Converting employee object into JSONBean
			
		String userjson= gson.toJson(user);
		
		// Sends the response as JSON string
		
			result=Response.status(Status.OK).entity(userjson).build();
			// Response.status(Status.OK).entity(employeeJson).build();

			// In case of DAO exception, response is sent with status code 503
			// (SERVICE_UNAVAILABLE)
			// Exception other than DAO, response is sent with status code 400
			// BAD_REQUEST

		} catch (Exception e) {
e.printStackTrace();
			if (e.getMessage().contains("DAO")) {
				String error = "{\"message\":\"" + e.getMessage() + "\"}";
				result = Response.status(Status.SERVICE_UNAVAILABLE).entity(error).build();
				DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
				Logger logger = Logger.getLogger(this.getClass());
				logger.error(e.getMessage(), e);
			} else {
				String error = "{\"message\":\"" + e.getMessage() + "\"}";
				result = Response.status(Status.BAD_REQUEST).entity(error).build();
				DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
				Logger logger = Logger.getLogger(this.getClass());
				logger.error(e.getMessage(), e);
			}
		}
		return result;
		
		
	}

	}
	
	


