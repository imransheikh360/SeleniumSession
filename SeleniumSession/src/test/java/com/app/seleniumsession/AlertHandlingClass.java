package com.app.seleniumsession;

import org.openqa.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class AlertHandlingClass extends BaseClass {

	
	@Test(priority=1)
	public void AlertBox()
	{
		WebElement alertModel= driver.findElement(By.xpath("//li[@class='dropdown']/a[contains(text(),'Alerts & Modals')]"));
		alertModel.click();
		
		WebElement javaAlert= driver.findElement(By.linkText("Javascript Alerts"));
		javaAlert.click();
		
		WebElement simpleAlert= driver.findElement(By.xpath("(//button[contains(text(),'Click me!')])[1]"));
		simpleAlert.click();
		//driver.switchTo().alert()
		Alert alert= driver.switchTo().alert();
		String alertText= alert.getText();
		System.out.println("My Simple alert text is: " +alertText );
		alert.accept();
	}
	
	
	
	@Test(priority=2)
	public void ConfirmAlertBox()
	{
			
		WebElement simpleAlert= driver.findElement(By.xpath("(//button[contains(text(),'Click me!')])[2]"));
		simpleAlert.click();
		//driver.switchTo().alert()
		Alert alert= driver.switchTo().alert();
		String alertText= alert.getText();
		System.out.println("My Confirm alert text is: " +alertText );
		
		alert.dismiss();
		WebElement simpleAlert1= driver.findElement(By.xpath("(//button[contains(text(),'Click me!')])[2]"));
		simpleAlert1.click();
		Alert alert1= driver.switchTo().alert();
		alert1.accept();
	}
	

	@Test(priority=3)
	public void PromptAlertBox()
	{
			
		WebElement prompt= driver.findElement(By.xpath("//button[contains(text(),'Click for Prompt Box')]"));
		prompt.click();
		Alert alert= driver.switchTo().alert();
		String alertText= alert.getText();
		System.out.println("My Prompt alert text is: " +alertText );
	
		alert.sendKeys("Imran Sheikh");
		alert.accept();
		
	}
}
