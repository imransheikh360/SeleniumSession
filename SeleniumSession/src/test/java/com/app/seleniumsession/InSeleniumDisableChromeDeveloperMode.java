package com.app.seleniumsession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class InSeleniumDisableChromeDeveloperMode {
	
	
	WebDriver driver;
	@Test
	public void disableChromeDeveloperMode()
	{
		
		String chromePath= "E:\\AutomationWorkSpace\\SeleniumJava\\JavaTestProject\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
			
		ChromeOptions cops= new ChromeOptions();
		cops.addArguments("--disable-extentions");
		driver= new ChromeDriver(cops);
		driver.get("http://www.seleniumeasy.com/test/");
	}

}
