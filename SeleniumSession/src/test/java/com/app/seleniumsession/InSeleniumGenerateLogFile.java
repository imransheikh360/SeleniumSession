package com.app.seleniumsession;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class InSeleniumGenerateLogFile {
	
	WebDriver driver;
	
	
	@Test
	public void TestGenerateLogFile()
	{
		String geckoDriverPath = "E:\\AutomationWorkSpace\\SeleniumJava\\JavaTestProject\\Drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", geckoDriverPath);
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.seleniumeasy.com/test/");
		
		Logger logger= Logger.getLogger("InSeleniumGenerateLogFile");
		String logFileName= "E:\\AutomationWorkSpace\\SeleniumJava\\JavaTestProject\\LogFolder\\log4j.properties";
		PropertyConfigurator.configure(logFileName);
		
		
		
		
		
		driver.findElement(By.xpath("//a[@class='dropdown-toggle' and contains(text(),'Table')] ")).click();
		logger.info("clicking on table menu link");
		
		driver.findElement(By.xpath("//a[contains(text(),'Table Data Search')]")).click();
		logger.info("clicking on Table Data Search menu link");
		
		driver.findElement(By.xpath("//a[contains(text(),'Input Forms')]")).click();
		logger.info("clicking on Input form");
		
		driver.quit();
		
	}

}
