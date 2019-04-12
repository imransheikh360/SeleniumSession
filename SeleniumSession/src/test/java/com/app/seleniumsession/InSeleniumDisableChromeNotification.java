package com.app.seleniumsession;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class InSeleniumDisableChromeNotification {
	
	WebDriver driver;
	
	@Test
	public void disableNotification()
	{
		
		Map<String, Integer> prefs= new HashMap<String, Integer> ();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions cp= new ChromeOptions();
		// this is the first way to diable the notification in chrome browser
		cp.addArguments("--disable-notifications");
		// this is the second way to diable the notification in chrome browser
		cp.setExperimentalOption("prefs", prefs);
		
		
		String path= "E:\\AutomationWorkSpace\\SeleniumJava\\JavaTestProject\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver(cp);
		//driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//driver.get("http://www.seleniumeasy.com/test");
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("urid");
		driver.findElement(By.id("pass")).sendKeys("urpass");
		driver.findElement(By.id("loginbutton")).click();
	}

}
