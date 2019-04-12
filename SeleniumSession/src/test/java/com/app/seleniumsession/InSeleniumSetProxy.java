package com.app.seleniumsession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



public class InSeleniumSetProxy {
	
	WebDriver driver;
	public void setProxy()
	{
		Proxy p = new Proxy();
		p.setHttpProxy("localhost:8080");
		DesiredCapabilities cp=  new DesiredCapabilities();
		cp.setCapability(CapabilityType.PROXY, p);
		driver = new FirefoxDriver(cp);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("http://www.seleniumeasy.com/test/table-sort-search-demo.html");
		
	}

}
