package com.infy.business.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.infy.bean.Product;
import com.infy.business.validator.ProductValidator;
import com.infy.dao.ProductDAO;
import com.infy.resources.Factory;

/**
 * Service class to execute business logic
 * @author ETA
 */

public class ProductServiceImpl implements ProductService
{
	/**
	 * To get a product's details
	 * @param productId
	 * @return The product details of the specified product
	 * @throws Exception
	 */
	@Override
	public Product findProduct(Integer productId) throws Exception
	{
		ProductDAO productDAO=Factory.createProductDAO();
		try
		{
			Product product = productDAO.findProduct(productId);
		
			if(product==null)
				throw new Exception("Service.PRODUCT_NOT_FOUND");
			return product;
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
	/**
	 * Adds product to the database
	 * @param product, the product to be added
	 * @return The product ID of the newly added product
	 * @throws Exception
	 */
	@Override
	public Integer addProduct(Product product) throws Exception
	{
		try
		{
			//if validator is made, invoke it
		
			ProductValidator productValidator=new ProductValidator();
			productValidator.validate(product);
			ProductDAO productDAO=Factory.createProductDAO();
			return productDAO.addProduct(product);
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
	
	/**
	 * Updates existing product in the database
	 * @param product, the product to be updated
	 * @throws Exception
	 */
	@Override
	public void updateProduct(Product product) throws Exception
	{
		try
		{
			ProductDAO productDAO=Factory.createProductDAO();
			productDAO.updateProduct(product);
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
	
	/**
	 * Removes the product from the database
	 * @param productId, product ID of the product to be removed
	 * @throws Exception
	 */
	@Override
	public void deleteProduct(Integer productId) throws Exception
	{
		try
		{
			ProductDAO productDAO=Factory.createProductDAO();
			productDAO.deleteProduct(productId);
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
	
	/**
	 * To get a product's details
	 * @param productId
	 * @return The product details of the specified product
	 * @throws Exception
	 */
	@Override
	public Product getProductDetails(Integer productId) throws Exception
	{
		try
		{
			ProductDAO productDAO=Factory.createProductDAO();
			Product product = productDAO.getProductDetails(productId);
			if(product==null)
				throw new Exception("Service.PRODUCT_NOT_FOUND");
			return product;
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
	@Override
	public List<Product> getAllProductDetails() throws Exception
	{
		try
		{
			ProductDAO productDAO=Factory.createProductDAO();
			List<Product> product = productDAO.getAllProductDetails();
			
			if(product==null)
				throw new Exception("Service.PRODUCT_NOT_FOUND");
			return product;
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
