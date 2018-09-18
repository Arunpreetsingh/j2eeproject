package com.infy.dao;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.infy.bean.Product;
import com.infy.entity.ProductEntity;
import com.infy.resources.HibernateUtility;


public class ProductDAOImpl implements ProductDAO
{
	@Override
	public Product findProduct(Integer productId) throws Exception
	{
		SessionFactory sessionFactory=null;
		Session session= null;
		try
		{
			sessionFactory=HibernateUtility.createSessionFactory();
			session=sessionFactory.openSession();
			Product product=null;
			ProductEntity productEntity= (ProductEntity) session.get(ProductEntity.class, productId);
			if(productEntity!=null)
			{
			product=new Product();
			product.setProductId(productEntity.getProductId());
			product.setName(productEntity.getName());
			product.setBrand(productEntity.getBrand());
			product.setCategory(productEntity.getCategory());
			product.setCost(productEntity.getCost());
			product.setDiscount(productEntity.getDiscount());
			product.setQuantity(productEntity.getQuantity());
			product.setSellingPrice(productEntity.getSellingPrice());
			product.setSpecification(productEntity.getSpecification());
			
			
			product.setSupplierId(productEntity.getSupplierId());
			}
			return product;
		}
		catch (HibernateException e) {
			e.printStackTrace();
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger=Logger.getLogger(this.getClass());
			logger.debug(e.getMessage(),e);
			throw new Exception("DAO.TECHINAL_ERROR");
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
}
		finally {
			if (session.isOpen() || session != null) {
				session.close();
			}
		}
	}
	/**
	 * Adds product to the database
	 * @param product, the product to be added
	 * @return The product ID of the newly added product
	 */
	@Override
	public Integer addProduct(Product product) throws Exception 
	{
		
		SessionFactory sessionFactory=null;
		Session session=null;
				
				try{
					sessionFactory=HibernateUtility.createSessionFactory();
					session=sessionFactory.openSession();
					
					ProductEntity productEntity= new ProductEntity();
					productEntity.setProductId(product.getProductId());
					productEntity.setName(product.getName());
					productEntity.setBrand(product.getBrand());
					productEntity.setCategory(product.getCategory());
					productEntity.setCost(product.getCost());
					productEntity.setDiscount(product.getDiscount());
					productEntity.setQuantity(product.getQuantity());
					productEntity.setSellingPrice(product.getSellingPrice());
					productEntity.setSpecification(product.getSpecification());
					productEntity.setSupplierId(product.getSupplierId());
					
					session.beginTransaction();
					Integer productId=(Integer)session.save(productEntity);
					session.getTransaction().commit();
					return productId;
				
	}
				catch (HibernateException e) {
					e.printStackTrace();
					DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
					Logger logger=Logger.getLogger(this.getClass());
					logger.debug(e.getMessage(),e);
					throw new Exception("DAO.TECHINAL_ERROR");
				} catch (Exception exception) {
					exception.printStackTrace();
					throw exception;
		}
				finally {
					if (session.isOpen() || session != null) {
						session.close();
					}
				}
	}
	
	/**
	 * Updates existing product in the database
	 * @param product, the product to be updated
	 */
	@Override
	public void updateProduct(Product product) throws Exception 
	{
		SessionFactory sessionFactory=null;
		Session session=null;
				
				try{
					sessionFactory=HibernateUtility.createSessionFactory();
					session=sessionFactory.openSession();
					
					
					
					ProductEntity productEntity= (ProductEntity) session.get(ProductEntity.class, product.getProductId());
					
					productEntity.setName(product.getName());
					productEntity.setBrand(product.getBrand());
					productEntity.setCategory(product.getCategory());
					productEntity.setCost(product.getCost());
					productEntity.setDiscount(product.getDiscount());
					productEntity.setQuantity(product.getQuantity());
					productEntity.setSellingPrice(product.getSellingPrice());
					productEntity.setSpecification(product.getSpecification());
					
					
					session.beginTransaction();
					
					session.getTransaction().commit();
				
				
	}
				catch (HibernateException e) {
					e.printStackTrace();
					DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
					Logger logger=Logger.getLogger(this.getClass());
					logger.debug(e.getMessage(),e);
					throw new Exception("DAO.TECHINAL_ERROR");
				} catch (Exception exception) {
					exception.printStackTrace();
					throw exception;
		}
				finally {
					if (session.isOpen() || session != null) {
						session.close();
					}
				}
	}

	
	/**
	 * Removes the product from the database
	 * @param productId, product ID of the product to be removed
	 */
	@Override
	public void deleteProduct(Integer productId) throws Exception 
	{
		SessionFactory sessionFactory=null;
		Session session=null;
				
				try{
					sessionFactory=HibernateUtility.createSessionFactory();
					session=sessionFactory.openSession();
					
					ProductEntity productEntity= (ProductEntity)session.get(ProductEntity.class, productId);
					
					
					session.beginTransaction();
					session.delete(productEntity);
					session.getTransaction().commit();
				
	}
				catch (HibernateException e) {
					DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
					Logger logger=Logger.getLogger(this.getClass());
					logger.debug(e.getMessage(),e);
					throw new Exception("DAO.TECHINAL_ERROR");
				} catch (Exception exception) {
					exception.printStackTrace();
					throw exception;
		}
				finally {
					if (session.isOpen() || session != null) {
						session.close();
					}
				}
			}
	
	/**
	 * To get a product's details
	 * @param productId
	 * @return The product details of the specified product
	 */
	@Override
	public Product getProductDetails(Integer productId) throws Exception 
	{

			SessionFactory sessionFactory=null;
			Session session=null;
			Product product=null;
			try{
				
				sessionFactory=HibernateUtility.createSessionFactory();
			
				session=sessionFactory.openSession();
				
				ProductEntity productEntity= (ProductEntity) session.get(ProductEntity.class, productId);
				if(productEntity!=null)
				{		
				product=new Product();
			product.setProductId(productEntity.getProductId());
			product.setName(productEntity.getName());
			product.setCost(productEntity.getCost());
			product.setSellingPrice(productEntity.getSellingPrice());
			product.setQuantity(productEntity.getQuantity());			
			product.setSpecification(productEntity.getSpecification());	
				}

		} catch (HibernateException e) {
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger=Logger.getLogger(this.getClass());
			logger.debug(e.getMessage(),e);
			throw new Exception("DAO.TECHINAL_ERROR");
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
}
		finally {
			
			if (session.isOpen() || session != null) {
				session.close();
			}
		}
			return product;
}
	@Override
	public  List<Product> getAllProductDetails() throws Exception 
	{

			SessionFactory sessionFactory=null;
			Session session=null;
			List<Product> productslist = new LinkedList<>();
			
			try{
				
				sessionFactory=HibernateUtility.createSessionFactory();
			
				session=sessionFactory.openSession();
				
				String hql="select pe from ProductEntity pe";
				
				Query query=session.createQuery(hql);
				
			
				List<ProductEntity> productEntities=query.list();
				

				
				
				for (int i = 0; i < productEntities.size(); i++) 
				{
					Product product=new Product();
					product.setProductId(productEntities.get(i).getProductId());
				 product.setName(productEntities.get(i).getName());
				 product.setCost(productEntities.get(i).getCost());
				 product.setSellingPrice(productEntities.get(i).getSellingPrice());
				 product.setQuantity(productEntities.get(i).getQuantity());
				 product.setSpecification(productEntities.get(i).getSpecification());
					
				 productslist.add(product);
					
					
					
					
				}
				
				
				
			
				

		} catch (HibernateException e) {
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger=Logger.getLogger(this.getClass());
			logger.debug(e.getMessage(),e);
			throw new Exception("DAO.TECHINAL_ERROR");
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
}
		finally {
			
			if (session.isOpen() || session != null) {
				session.close();
			}
		}
			return productslist;
}
	
}
