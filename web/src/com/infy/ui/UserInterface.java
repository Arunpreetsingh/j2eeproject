package com.infy.ui;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import com.infy.bean.Gender;
import com.infy.bean.Product;
import com.infy.bean.User;
import com.infy.bean.UserRole;
import com.infy.bean.UserType;
import com.infy.business.service.ProductService;
import com.infy.business.service.UserService;
import com.infy.resources.AppConfig;
import com.infy.resources.Factory;
import com.infy.resources.HibernateUtility;

/**
 * Creates the bean object and calls the methods in the Service classes. This is a
 * temporary class and will be replaced once the client tier is developed
 * 
 * @author ETA
 */

public class UserInterface
{
	private static UserService userService = Factory.createUserService();
	private static ProductService productService = Factory.createProductService();

	public static void main(String[] args)
	{
		
		try{
		// USER MODULES
		//addUser();
		//updateUser();
		//changePassword();
		//findUser();
		//deleteUser();
		
		// PRODUCT MODULES
		//addProduct();
		//updateProduct();
		//deleteProduct();
			
		//getProductDetails();
			getAllProductDetails();
		}
		finally{
			
			HibernateUtility.closeSessionFactory();
		}
	}

	// User Modules Begin
	
	public static void addUser()
	{
		User user = new User();
		user.setUserRole(String.valueOf(UserRole.ADMIN));
		user.setUserType(String.valueOf(UserType.GOLD));
		user.setGender(String.valueOf(Gender.FEMALE));
		user.setUserId("A101");
		
		user.setUserName("Sunnu");
		user.setEmail("sunnu12343@infy.com");
		user.setMobileNumber("9876543210");
		user.setDateOfBirth(new GregorianCalendar(1997, 10, 6));
		user.setAddress("12, Lakshmikanth Nagar, Mysore, Karnataka, 570027");
		user.setPassword("@sunnu_");
		user.setUserStatus('A');
		try
		{
			
			System.out.println(AppConfig.PROPERTIES.getProperty("UserInterface.ADD_USER_SUCCESS") + userService.addUser(user));
		}
		catch (Exception e)
		{
			
			System.out.println(AppConfig.PROPERTIES.getProperty(e.getMessage()));
		}
	}
	
	public static void updateUser()
	{
		User user = new User();
		user.setUserType(String.valueOf(UserType.SILVER));
		user.setGender(String.valueOf(Gender.FEMALE));
		user.setUserId("A101");
		user.setUserName("Sunnoo");
		user.setEmail("sunnoo@infy.com");
		user.setMobileNumber("9876543210");
		user.setDateOfBirth(new GregorianCalendar(1997, 10, 6));
		user.setAddress("12, Lakshmikanth Nagar, Mysore, Karnataka, 570027");
		
		try
		{
			userService.updateUser(user);
			System.out.println(AppConfig.PROPERTIES.getProperty("UserInterface.UPDATE_USER_SUCCESS"));
		}
		catch (Exception e)
		{
			
			System.out.println(AppConfig.PROPERTIES.getProperty(e.getMessage()));
		}
	}
	
	public static void changePassword()
	{
		String userId = "C101";
		String oldPassword = "Saleem@123";
		String newPassword = "Saleem@1";
		try
		{
			userService.changePassword(userId, oldPassword, newPassword);
			System.out.println(AppConfig.PROPERTIES.getProperty("UserInterface.PASSWORD_CHANGE_SUCCESS"));
		}
		catch (Exception e)
		{
			System.out.println(AppConfig.PROPERTIES.getProperty(e.getMessage()));
		}
	}
	
	public static void findUser()
	{
		String userId = "S101";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		try
		{
			User user = userService.findUser(userId);
			System.out.println("User Details:\n=============");
			System.out.println("User ID: " + user.getUserId());
			System.out.println("Username: " + user.getUserName());
			System.out.println("e-mail: " + user.getEmail());
			System.out.println("Mobile: " + user.getMobileNumber());
			System.out.println("DOB: " + sdf.format(user.getDateOfBirth().getTime()));
			System.out.println("Gender: " + user.getGender());
			System.out.println("Type: " + user.getUserType());
			System.out.println("Role: " + user.getUserRole());
			System.out.println("Status: " + user.getUserStatus());
			System.out.println("Address: " + user.getAddress());
		}
		catch (Exception e)
		{
			System.out.println(AppConfig.PROPERTIES.getProperty(e.getMessage()));
		}
	}

	
	
	public static void deleteUser()
	{
		String userId = "A104";
		try
		{
			userService.deleteUser(userId);
			System.out.println(AppConfig.PROPERTIES.getProperty("UserInterface.DELETE_USER_SUCCESS"));
		}
		catch (Exception e)
		{
			System.out.println(AppConfig.PROPERTIES.getProperty(e.getMessage()));
		}
	}
	
	// Product Modules Begin
	
	public static void addProduct()
	{
		Product product=new Product();
		product.setProductId(1004);
		product.setName("Iphone6+");
		product.setCategory("Mobile");
		product.setBrand("Apple");
		product.setCost(62599.00);
		product.setQuantity(5);
		product.setDiscount(10.0);
		product.setSellingPrice(54599.00);
		product.setSpecification("Color:Space Grey;ROM:64GB");
		product.setSupplierId("S101");
				
		try
		{
			System.out.println(AppConfig.PROPERTIES.getProperty("UserInterface.ADD_PRODUCT_SUCCESS") + productService.addProduct(product));
					} 
		catch (Exception e)
		{
			System.out.println(AppConfig.PROPERTIES.getProperty(e.getMessage()));
		}
	}

	public static void updateProduct()
	{
		Product product=new Product();
		product.setProductId(1000);
		product.setName("Iphone6");
		product.setCategory("Mobile");
		product.setBrand("Apple");
		product.setCost(53599.00);
		product.setQuantity(5);
		product.setDiscount(10.0);
		product.setSellingPrice(55599.00);
		product.setSpecification("Color:Space Grey;ROM:64GB");
		try
		{
			productService.updateProduct(product);
			System.out.println(AppConfig.PROPERTIES.getProperty("UserInterface.UPDATE_PRODUCT_SUCCESS"));	
		}
		catch (Exception e)
		{
			System.out.println(AppConfig.PROPERTIES.getProperty(e.getMessage()));
		}
	}
	
	public static void deleteProduct()
	{
		Integer productId = 1004;
		try
		{
			productService.deleteProduct(productId);
			System.out.println(AppConfig.PROPERTIES.getProperty("UserInterface.DELETE_PRODUCT_SUCCESS"));
		}
		catch(Exception e)
		{
			System.out.println(AppConfig.PROPERTIES.getProperty(e.getMessage()));
		}
	}
	
	public static void getProductDetails()
	{
		Integer productId = 1003;
		try
		{
			Product product=productService.getProductDetails(productId);
			System.out.println("Product Details:");
			System.out.println("-----------------");
			System.out.println("Product ID: " + product.getProductId());
			System.out.println("Name: " + product.getName());
			System.out.println("Cost Price: " + product.getCost());
			System.out.println("Selling Price: " + product.getSellingPrice());
			System.out.println("Quantity: " + product.getQuantity());			
			System.out.println("Specification: " + product.getSpecification());			
		}
		catch(Exception e)
		{
			
			System.out.println(AppConfig.PROPERTIES.getProperty(e.getMessage()));
		}
	}
	public static void getAllProductDetails()
	{
		
		try
		{
			List<Product> product=productService.getAllProductDetails();
			
			for (int i = 0; i < product.size(); i++) {
				
			
				
			
			System.out.println("Product Details:");
			System.out.println("-----------------");
			System.out.println("Product ID: " + product.get(i).getProductId());
			System.out.println("Name: " + product.get(i).getName());
			System.out.println("Cost Price: " + product.get(i).getCost());
			System.out.println("Selling Price: " +product.get(i).getSellingPrice());
			System.out.println("Quantity: " + product.get(i).getQuantity());			
			System.out.println("Specification: " + product.get(i).getSpecification());	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(AppConfig.PROPERTIES.getProperty(e.getMessage()));
		}
	}
}
