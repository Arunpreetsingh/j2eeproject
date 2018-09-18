package com.infy.resources;

import com.infy.business.service.ProductServiceImpl;
import com.infy.business.service.UserServiceImpl;
import com.infy.dao.ProductDAOImpl;
import com.infy.dao.UserDAOImpl;

public class Factory
{
	public static UserServiceImpl createUserService()
	{
		return new UserServiceImpl();
	}
	
	public static UserDAOImpl createUserDAO()
	{
		return new UserDAOImpl();
	}
	
	public static ProductServiceImpl createProductService()
	{
		return new ProductServiceImpl();
	}
	
	public static ProductDAOImpl createProductDAO()
	{
		return new ProductDAOImpl();
	}
}