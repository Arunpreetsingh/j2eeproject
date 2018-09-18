package com.infy.api;



import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.infy.bean.Product;
import com.infy.business.service.ProductService;
import com.infy.resources.Factory;
import com.infy.resources.JSONParser;




@Path("Products")
public class ProductAPI {
	
	
	@GET
	@Path("/{productid}")
	
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduct(@PathParam("productid") Integer i) {
		Response result;
		try {
			// CODE TO CALL DAO CLASS METHOD FOR GETTING EMPLOYEE DETAILS
			ProductService productService=Factory.createProductService();
			
		Product product=productService.getProductDetails(i);
		
			// Converting employee object into JSONBean
			
		String Productjson= JSONParser.beanToJson(product);
		
		// Sends the response as JSON string
		
			result=Response.status(Status.OK).entity(Productjson).build();
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
	
	@GET
	@Path("/getallproduct")
	
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduct() {
		Response result;
		try {
			// CODE TO CALL DAO CLASS METHOD FOR GETTING EMPLOYEE DETAILS
			ProductService productService=Factory.createProductService();
			
		List<Product> product=productService.getAllProductDetails();
		
			// Converting employee object into JSONBean
			
		String Productjson= JSONParser.beanToJson(product);
		
		// Sends the response as JSON string
		
			result=Response.status(Status.OK).entity(Productjson).build();
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
