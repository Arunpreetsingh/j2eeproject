package com.infy.dao;

import java.util.List;

import com.infy.bean.Product;

public interface ProductDAO
{
	public Product findProduct(Integer productId) throws Exception;
	public Integer addProduct(Product product) throws Exception;
	public void updateProduct(Product product) throws Exception; 
	public void deleteProduct(Integer productId) throws Exception;
	public Product getProductDetails(Integer productId) throws Exception;
	public List<Product> getAllProductDetails() throws Exception ;
	
}
