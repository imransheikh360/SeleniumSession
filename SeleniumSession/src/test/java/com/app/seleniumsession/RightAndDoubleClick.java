package com.app.seleniumsession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RightAndDoubleClick {
	
	WebDriver driver;
	
	@BeforeSuite
	public void SetUpConfiguration()
	{
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
	}
	
	@Test(priority=1)
	public void rightClick() throws InterruptedException
	{
		
		WebElement el= driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
		Actions action= new Actions(driver);
		action.contextClick(el);
		action.build().perform();
		System.out.println("Sucessfully Right clicked on the element");
		Thread.sleep(5000);
	}

	@Test(priority=2)
	public void doubleClick()
	{
		
		WebElement el= driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
		Actions action= new Actions(driver);
		action.doubleClick(el);
	}
	
	@AfterSuite
	public void closeBrowser()
	{
		//driver.quit();
	}
}
