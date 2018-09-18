package com.infy.business.service;



import com.infy.bean.User;

public interface UserService
{
	public String addUser(User user) throws Exception;
	public void updateUser(User user) throws Exception;
	public void changePassword(String userId, String oldPassword, String newPassword) throws Exception;
	public User findUser(String userId) throws Exception;
	public void deleteUser(String userId) throws Exception;
}
