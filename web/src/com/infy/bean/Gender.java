package com.infy.bean;

public enum Gender
{
	MALE ('M'),
	FEMALE ('F');
	
	private final Character genderValue;
	
	Gender(Character genderValue)
	{
		this.genderValue = genderValue;
	}

	public Character getGenderValue() {
		return genderValue;
	}
}
