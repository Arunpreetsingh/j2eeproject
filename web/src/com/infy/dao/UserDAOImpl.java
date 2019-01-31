package com.infy.dao;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.infy.bean.User;
import com.infy.entity.UserEntity;
import com.infy.resources.HibernateUtility;

/**
 * DAO class to perform database operations
 * 
 * @author ETA
 */

public class UserDAOImpl implements UserDAO {
	/**
	 * Adds user to the database
	 * 
	 * @param user,
	 *            the user to be added
	 * @return The user ID of the newly added user
	 */
	@Override
	public String addUser(User user) throws Exception {
		String Id = null;
		Session session = null;

		try {
			SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
			session = sessionFactory.openSession();

			UserEntity entity = new UserEntity();
			session.getTransaction().begin();
			entity.setUserId(user.getUserId());
			entity.setGender(user.getGender().getGenderValue());
			entity.setAddress(user.getAddress());
			entity.setDateOfBirth(user.getDateOfBirth());
			entity.setEmail(user.getEmail());
			entity.setMobileNumber(user.getMobileNumber());
			entity.setPassword(user.getPassword());

			entity.setUserRole(user.getUserRole().getUserRoleValue());
			entity.setUserStatus(user.getUserStatus());
			entity.setUserType(user.getUserType().name());
			entity.setUserName(user.getUserName());

			Id = (String) session.save(entity);

			session.getTransaction().commit();

		} catch (Exception e) {
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger = Logger.getLogger(UserDAOImpl.class);
			logger.error(e.getMessage(), e);
			throw e;
			// TODO: handle exception
		} finally {
			if (session.isOpen() || session != null) {
				session.close();
			}
		}

		return Id;
	}

	/**
	 * Updates existing user in the database
	 * 
	 * @param user,
	 *            the user to be updated
	 */
	@Override
	public void updateUser(User user) throws Exception {
		SessionFactory sessionFactory1 = null;
		Session session1 = null;

		try {
			sessionFactory1 = HibernateUtility.createSessionFactory();
			session1 = sessionFactory1.openSession();

			UserEntity entity = (UserEntity) session1.get(UserEntity.class, user.getUserId());
			if (entity != null) {
				session1.getTransaction().begin();
				entity.setUserType(user.getUserType().name());
				entity.setGender(user.getGender().getGenderValue());

				entity.setUserName(user.getUserName());
				entity.setEmail(user.getEmail());
				entity.setMobileNumber(user.getMobileNumber());
				entity.setDateOfBirth(user.getDateOfBirth());
				entity.setAddress(user.getAddress());

				session1.getTransaction().commit();
			}

		} catch (Exception e) {

			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger = Logger.getLogger(UserDAOImpl.class);
			logger.error(e.getMessage(), e);
			throw e;
			// TODO: handle exception
		} finally {

			if (session1.isOpen() || session1 != null) {
				session1.close();
			}
		}

	}

	/**
	 * Changes existing user's password in the database
	 * 
	 * @param userId,
	 *            oldPassword, newPassword
	 */
	@Override
	public String changePassword(String userId, String oldPassword, String newPassword) throws Exception {
		Session session = null;
String st=null;
		try {
			SessionFactory factory = HibernateUtility.createSessionFactory();
			session = factory.openSession();
			
			
			UserEntity entity=(UserEntity)session.get(UserEntity.class, userId);
			session.getTransaction().begin();
			if(entity.getPassword().equals(oldPassword))
			{
				entity.setPassword(newPassword);
			}
			session.getTransaction().commit();
			 st="success";
		}
		
		
		catch (Exception e) {

			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger = Logger.getLogger(UserDAOImpl.class);
			logger.error(e.getMessage(), e);
			throw e;
			// TODO: handle exception
		} finally {

			if (session.isOpen() || session != null) {
				session.close();
			}
		}

		return st;
	}

	/**
	 * To get a user's details
	 * 
	 * @param userId
	 * @return The user details of the specified user
	 */
	@Override
	public User findUser(String userId) throws Exception {

		Session session = null;
		User user = new User();
		try {
			SessionFactory factory = HibernateUtility.createSessionFactory();
			session = factory.openSession();

			UserEntity entity = (UserEntity) session.get(UserEntity.class, userId);

			user.setUserId(entity.getUserId());
			user.setGender(entity.getGender().toString());
			user.setAddress(entity.getAddress());
			user.setDateOfBirth(entity.getDateOfBirth());
			user.setEmail(entity.getEmail());
			user.setMobileNumber(entity.getMobileNumber());
			user.setPassword(entity.getPassword());

			user.setUserRole(entity.getUserRole().toString());

			user.setUserStatus(entity.getUserStatus());
			user.setUserType(entity.getUserType().toString());
			user.setUserName(entity.getUserName());

		} catch (Exception e) {
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger = Logger.getLogger(UserDAOImpl.class);
			logger.error(e.getMessage(), e);
			throw e;
			// TODO: handle exception
		} finally {
			if (session.isOpen() || session != null) {
				session.close();
			}
		}
		return user;
	}

	/**
	 * Removes the user from the database
	 * 
	 * @param userId,
	 *            user ID of the user to be removed
	 */
	@Override
	public void deleteUser(String userId) throws Exception {
		Session session = null;
	
				try {
					SessionFactory factory = HibernateUtility.createSessionFactory();
					session = factory.openSession();
					
					
					UserEntity entity=(UserEntity)session.get(UserEntity.class, userId);
					session.getTransaction().begin();
					entity.setUserStatus(Character.valueOf('D'));
					session.getTransaction().commit();
					 
				}
				
				
				catch (Exception e) {

					DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
					Logger logger = Logger.getLogger(UserDAOImpl.class);
					logger.error(e.getMessage(), e);
					throw e;
					// TODO: handle exception
				} finally {

					if (session.isOpen() || session != null) {
						session.close();
					}
				}
		

	}
	
	@Override
	public  List<User> getAllCustomerDetails() throws Exception 
	{

			SessionFactory sessionFactory=null;
			Session session=null;
			List<User>userlist = new LinkedList<>();
			
			try{
				
				sessionFactory=HibernateUtility.createSessionFactory();
			
				session=sessionFactory.openSession();
				
				String hql="select ce from UserEntity ce where ce.userRole=?";
				
			
				
				Query query=session.createQuery(hql);
				
				query.setString(0,"C");
				
				
				List<UserEntity> userEntities=query.list();
				

				
				
				for (int i = 0; i <userEntities.size(); i++) 
				{
					User user= new User();
			user.setUserId(userEntities.get(i).getUserId());
			user.setEmail(userEntities.get(i).getEmail());
			user.setUserName(userEntities.get(i).getUserName());
			user.setAddress(userEntities.get(i).getAddress());
			user.setGender(userEntities.get(i).getGender().toString());
			user.setMobileNumber(userEntities.get(i).getMobileNumber());
			user.setDateOfBirth(userEntities.get(i).getDateOfBirth());
			
				 userlist.add(user);
					
					
					
					
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
			return userlist;
}
	
}


