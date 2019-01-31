package com.infy.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name="INFYRETAIL_USER")
public class UserEntity 
{
	@Id
	@Column(name="USER_ID")
	private String userId;
	@Column(name="USER_NAME")
	private String userName;
	@Column(name="USER_ROLE")
	private Character userRole;
	@Column(name="USER_PASSWORD")
	private String password;
	@Column(name="USER_EMAIL")
	private String email;
	@Column(name="USER_MOBILE_NO")
	private String mobileNumber;
	
	@Temporal(TemporalType.DATE)
	@Column(name="USER_DOB")
	private Calendar dateOfBirth;
	@Column(name="USER_ADDRESS")
	private String address;
	@Column(name="USER_GENDER")
	private Character gender;
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Column(name="USER_TYPE")
	private String userType;
	@Column(name="USER_STATUS")
	private Character userStatus;
	
	public Character getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Character userStatus) {
		this.userStatus = userStatus;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Character getUserRole() {
		return userRole;
	}
	public void setUserRole(Character userRole) {
		this.userRole=userRole;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
	
}
