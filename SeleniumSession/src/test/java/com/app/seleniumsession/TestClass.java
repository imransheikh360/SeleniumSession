package com.app.seleniumsession;

import org.openqa.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class TestClass
{
	
	WebDriver driver;
	@Test
	public void testMethod()
	{
		String filePath= "E:\\AutomationWorkSpace\\SeleniumJava\\JavaTestProject\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filePath);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://www.msn.com/en-in/?AR=1");
		
		List<WebElement> element= driver.findElements(By.xpath("//div[@class='sectioncontent']/div[@class='stripenav']/ul/li"));
		System.out.println("all rows : " +element.size() );
		int count= 0;
		for(WebElement el: element){
			if(el.isDisplayed())
			{
				count++;
			}
			
		}
		
		
		System.out.println("my only displyed & enabled rows count: " + count);
	
	//table/tbody/tr[not(contains(@style,'display: none;'))]
	List<WebElement> element1= driver.findElements(By.xpath("//div[@class='sectioncontent']/div[@class='stripenav']/ul/li[contains(@style,'display:none')]"));
	System.out.println("Only enabled rows : " +element1.size() );
	WebElement el1= driver.findElement(By.xpath("//div[@class='sectioncontent']/div[@class='stripenav']/ul/li[@class='entertainment']"));
	System.out.println("entertainment: " + el1.getCssValue("display"));
	
	
	WebElement el= driver.findElement(By.xpath("//div[@class='sectioncontent']/div[@class='stripenav']/ul/li[@class='weatoday weather']"));
	System.out.println("weatoday weather: " + el.getCssValue("display"));
	
	//div[@class='sectioncontent']/div[@class='stripenav']/ul/li
	}
	
}