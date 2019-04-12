package com.app.seleniumsession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectDropDownClass extends BaseClass {

	
	
	@Test
	public void selectDropDown() throws InterruptedException
	{
		
		WebElement inputForm= driver.findElement(By.xpath("(//a[contains(text(),'Input Forms')])[2]"));
		inputForm.click();
		
		
		WebElement selectDropDown= driver.findElement(By.xpath("(//a[contains(text(),'Select Dropdown List')])[2]"));
		selectDropDown.click();
		
		
		WebElement el= driver.findElement(By.id("select-demo"));
		Select select = new Select(el);
		//Select by visible text
		select.selectByVisibleText("Monday");
		Thread.sleep(2000);
		
		//Select by value
		select.selectByValue("Wednesday");
		Thread.sleep(2000);
		
		//Select by index
		select.selectByIndex(0);
		Thread.sleep(2000);
		
		
		
		//Perform multiselct operation
		WebElement el1= driver.findElement(By.id("multi-select"));
		Select select1 = new Select(el1);
		select1.selectByIndex(1);
		select1.selectByIndex(2);
		select1.selectByIndex(3);
		Thread.sleep(5000);
		
		
				
	}
	
}
