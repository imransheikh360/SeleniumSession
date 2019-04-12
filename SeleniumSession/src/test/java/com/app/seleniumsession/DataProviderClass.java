package com.app.seleniumsession;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
 * Return type of DataProvider: returns a two-dimensional JAVA object
 */

public class DataProviderClass {
	
	
	@Test(dataProvider="UserInformation")
	public void printUserInfor(String UserName, String Password)
	{
		System.out.println("User name is: " + UserName);
		System.out.println("Password name is: " + Password);
		
	}
	
	
	@DataProvider(name = "UserInformation")
	public Object[][] userInfo()
	{
		Object[][] obj= new Object[2][2];
		obj[0][0]= "Imran";
		obj[0][1]= "Sheikh";
		
		obj[1][0]= "Irfan";
		obj[1][1]= "Khan";
		
		return obj;
	}
	
	
	
}



