package com.app.seleniumsession;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
	String value;
	
	public String  getPropertyValue(String key) throws IOException
	{
		String filePath= "E:\\AutomationWorkSpace\\SeleniumJava\\JavaTestProject\\Files\\Irman.properties";
		//File file = new File(filePath);
		Properties prop= new Properties();
		FileInputStream fileinputStream= new FileInputStream(filePath);
		prop.load(fileinputStream);
		
		if(fileinputStream !=null)
		{
			value= prop.getProperty(key);
		}
		
		return value;
	}
	
	public static void main(String[] args) throws IOException {
		ReadPropertiesFile obj= new ReadPropertiesFile();
		String usetName= obj.getPropertyValue("username");
		String password= obj.getPropertyValue("Password");
		
		System.out.println("My user name and password are as : " + usetName+ " And Password " + password);
	}
	
}
