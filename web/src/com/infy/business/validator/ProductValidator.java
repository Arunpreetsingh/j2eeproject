package com.infy.business.validator;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.infy.bean.Product;

/**
 * Validates product
 * @author ETA
 */
public class ProductValidator {
	
	/**
	 * Validates the product
	 * @param product
	 * @return None
	 * @throws Exception
	 */
	public void validate(Product product) throws Exception
	{
		try
		{
			if(!isValidProductName(product.getName()))
				throw new Exception("Validator.INVALID_PRODUCT_NAME");
			else if(!isValidProductQuantity(product.getQuantity()))
				throw new Exception("Validator.INVALID_PRODUCT_QUANTITY");
			else if(!isValidProductDiscount(product.getDiscount()))
				throw new Exception("Validator.INVALID_DISCOUNT");
			
					
		}
		catch(Exception e)
		{
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	
	
	/**
	 * Validates the product name
	 * @param product name, the product name to be validated
	 * @return true if product name is given and is not more than 100 characters long
	 */
	public Boolean isValidProductName(String productName)
	{
		Boolean isValid=false;
		if(productName!=null && productName.trim().length()>0 && productName.trim().length()<=100)
			isValid=true;
		return isValid;
	}
	
	/**
	 * Validates the product quantity
	 * @param quantity, the quantity to be validated
	 * @return true if quantity is a positive value and it cannot be zero
	 */
	public Boolean isValidProductQuantity(Integer quantity)
	{	Boolean isValid=false;
		if(quantity>0)
			isValid=true;
		return isValid;
	}
	
	/**
	 * Validates the product discount
	 * @param discount, the discount to be validated
	 * @return true if discount is a non-negative value
	 */
	public Boolean isValidProductDiscount(Double discount)
	{
		Boolean isValid=false;
		if(discount>=0)
			isValid=true;
		return isValid;
	}
	
	
}
