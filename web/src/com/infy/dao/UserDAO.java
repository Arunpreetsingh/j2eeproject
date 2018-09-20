package com.infy.dao;

import java.util.List;

import com.infy.bean.Product;
import com.infy.bean.User;

public interface UserDAO
{
	public String addUser(User user) throws Exception;
	public void updateUser(User user) throws Exception;
	public String changePassword(String userId, String oldPassword, String newPassword) throws Exception;
	public User findUser(String userId) throws Exception;
	
	public void deleteUser(String userId) throws Exception;
	public  List<User> getAllCustomerDetails() throws Exception; 
}
