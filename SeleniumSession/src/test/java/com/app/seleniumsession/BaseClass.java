package com.app.seleniumsession;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	WebDriver driver;

	
	@BeforeSuite
	public void SetUpConfiguration() throws MalformedURLException
	{
		String geckoDriverPath = "E:\\AutomationWorkSpace\\SeleniumJava\\JavaTestProject\\Drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", geckoDriverPath);
	//	driver = new FirefoxDriver();
		
	/*
		//String URL = "http://www.DemoQA.com";
 		String Node = "http://10.148.0.229:4444/wd/hub";
 		DesiredCapabilities caps = new DesiredCapabilities();
 		caps.setBrowserName("firefox");
 		//FirefoxOptions options = new FirefoxOptions();
 		//options.addCapabilities(capabilities.)
 		//options.BrowserExecutableLocation = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
 		driver = new RemoteWebDriver(new URL(Node), caps);
		//driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.seleniumeasy.com/test/");
		
		*/
		
		
	/*	String Node = "http://localhost:4444/wd/hub";
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
       WebDriver driver = new RemoteWebDriver(new URL(Node) ,capabilities);
       driver.get("http://www.seleniumeasy.com/test/");
		
		cs = new CommonClass(driver);*/
	}
	
	
	@AfterSuite
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
	
	
}
