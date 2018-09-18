package com.infy.bean;

public enum UserRole
{
	ADMIN ('A'),
	SUPPLIER ('S'),
	CUSTOMER ('C');
	
	private final Character userRoleValue;
	
	UserRole(Character userRoleValue)
	{
		this.userRoleValue = userRoleValue;
	}

	public Character getUserRoleValue() {
		return userRoleValue;
	}
}
