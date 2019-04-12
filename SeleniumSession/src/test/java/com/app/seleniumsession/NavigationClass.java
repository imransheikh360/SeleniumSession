package com.app.seleniumsession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NavigationClass extends BaseClass {


	
	@Test
	public void webDriverNavigation() throws InterruptedException
	{
		driver.findElement(By.linkText("Selenium Easy")).click();
		Thread.sleep(2000);
		
		//Navigate back
		driver.navigate().back();
		Thread.sleep(2000);
		
		
		//Navigate forward
		driver.navigate().forward();
		Thread.sleep(2000);
		
		//refresh
		driver.navigate().refresh();
		Thread.sleep(2000);
				
		
		//Navigate to
		driver.navigate().to("http://www.seleniumeasy.com/test/");
		Thread.sleep(2000);
		
		
		
		//Note: In general, both get and navigate.to do the same task 
		//when invoking the url.(just small change in the services they both offers).
	}
	
	
	
}
