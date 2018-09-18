package com.infy.business.validator;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


/**
 * Validates user
 * @author ETA
 */

public class UserValidator {

	
	/**
	 * Validates the email
	 * @param email, the email to be validated
	 * @return false if the email is not of proper format
	 * @throws Exception 
	 */
	public void isValidEmail(String email) throws Exception
	{
		String regex = "[\\w]+@[\\w]+\\.[\\w]+";
		
		try
		{
			if(!email.matches(regex)) 
			{
			throw new Exception("Validator.INVALID_EMAIL");
			}
		}
		catch(Exception ex)
		{
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");			
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(ex.getMessage(), ex); 
			throw ex;
		}
	}
	
	
	/**
	 * Validates the password
	 * @param password, the password to be validated
	 * @throws Exception 
	 */
	public void isValidPassword(String password) throws Exception
	{
		//String regex = "(?=^.{6,}$)([A-Za-z0-9\\W]*[\\W]{1}[A-Za-z0-9\\W]*)";
	
		String regex = "[A-Za-z0-9\\W]*[\\W_]{1,}[A-Za-z0-9\\W]*";
		try{
			
		
		if(!(password.length() > 6) && (password.matches(regex)))
		{
			throw new Exception("Validator.INVALID_PASSWORD");
		}
		}
		catch(Exception ex)
		{
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");			
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(ex.getMessage(), ex); 
			throw ex;
		}
		
	}
}
