package com.infy.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.infy.business.service.UserServiceImpl;

import com.infy.resources.Factory;

public class UserServiceTest {
	@Rule
	public ExpectedException employeetest=ExpectedException.none();
	@Test
	public void ISvalidUserID() throws Exception
	{
		
		employeetest.expectMessage("Service.USER_NOT_FOUND");
		UserServiceImpl impl=Factory.createUserService();
		impl.findUser("C10");
		
		
	}

	
	
}
