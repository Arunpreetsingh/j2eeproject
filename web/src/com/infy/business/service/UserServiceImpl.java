package com.infy.business.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.infy.bean.Product;
import com.infy.bean.User;
import com.infy.business.validator.UserValidator;
import com.infy.dao.ProductDAO;
import com.infy.dao.UserDAO;
import com.infy.resources.Factory;


/**
 * Service class to execute business logic
 * @author ETA
 */

public class UserServiceImpl implements UserService
{
	/**
	 * Adds user to the database
	 * @param user, the user to be added
	 * @return The user ID of the newly added user
	 * @throws Exception
	 */
	@Override
	public String addUser(User user) throws Exception
	{
	String Id=null;
		try {
			UserValidator userValidator=new UserValidator();
			userValidator.isValidEmail(user.getEmail());
			userValidator.isValidPassword(user.getPassword());
			UserDAO dao=Factory.createUserDAO();
			Id=dao.addUser(user);
			
			
		}
		catch (Exception e) {
			
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger=Logger.getLogger(UserServiceImpl.class);
			logger.error(e.getMessage(),e);
			throw e;
			// TODO: handle exception
		}
		
		return Id;
	}

	/**
	 * Updates existing user in the database
	 * @param user, the user to be updated
	 * @throws Exception
	 */
	@Override
	public void updateUser(User user) throws Exception
	{
		try {
			UserValidator userValidator=new UserValidator();
			userValidator.isValidEmail(user.getEmail());
			
			UserDAO dao=Factory.createUserDAO();
		if(findUser(user.getUserId())!=null)
		{
			dao.updateUser(user);
		}
			
			
		}
		catch (Exception e) {
			
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger=Logger.getLogger(UserServiceImpl.class);
			logger.error(e.getMessage(),e);
			throw e;
			// TODO: handle exception
		}
		
	}

	/**
	 * Changes existing user's password in the database
	 * @param userId, oldPassword, newPassword
	 * @throws Exception
	 */
	@Override
	public void changePassword(String userId, String oldPassword, String newPassword) throws Exception
	{
		String st=null;
		try {
			UserValidator userValidator=new UserValidator();
			
			
			UserDAO dao=Factory.createUserDAO();
			if(oldPassword.equals(newPassword))
			{
				throw new Exception("Service.SAME_NEW_PASSWORD");
			}
			else {
				userValidator.isValidPassword(newPassword);
				if(findUser(userId)!=null)
				{
				st=	dao.changePassword(userId, oldPassword, newPassword);
				}
				if(st==null)
				{
					throw new Exception("Service.INVALIS_OLD_PASSWORD");
				}
			}
			
		}
catch (Exception e) {
			
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger=Logger.getLogger(UserServiceImpl.class);
			logger.error(e.getMessage(),e);
			
			// TODO: handle exception
		}
		
	}

	/**
	 * To get a user's details
	 * @param userId
	 * @return The user details of the specified user
	 * @throws Exception
	 */
	@Override
	public User findUser(String userId) throws Exception
	{
	User user=null;
		try {
		
			UserDAO dao=Factory.createUserDAO();
		 user=	dao.findUser(userId);
		}
		catch (Exception e) {
			
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger=Logger.getLogger(UserServiceImpl.class);
			logger.error(e.getMessage(),e);
			throw new Exception("Service.USER_NOT_FOUND");
			// TODO: handle exception
		}
		
		
		return user;
	}

	
	/**
	 * Removes the user from the database
	 * @param userId, user ID of the user to be removed
	 * @throws Exception
	 */
	@Override
	public void deleteUser(String userId) throws Exception
	{
		try {
			
			
			
			UserDAO dao=Factory.createUserDAO();
		
				if(findUser(userId)!=null)
				{
				dao.deleteUser(userId);
				}
				
			
			
		}
catch (Exception e) {
			
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger=Logger.getLogger(UserServiceImpl.class);
			logger.error(e.getMessage(),e);
			
			// TODO: handle exception
		}
		
	}
	@Override
	public  List<User> getAllCustomerDetails() throws Exception
	{
		try
		{
			UserDAO userDAO= Factory.createUserDAO();
			List<User> user = userDAO.getAllCustomerDetails();
			
			if(user==null)
				throw new Exception("Service.USER_NOT_FOUND");
			return user;
		}
		catch(Exception e)
		{
			
			if(e.getMessage().contains("Service"))
			{
				DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
				Logger logger = Logger.getLogger(this.getClass());
				logger.error(e.getMessage(), e);
			}
			throw e;
		}
	}
}
