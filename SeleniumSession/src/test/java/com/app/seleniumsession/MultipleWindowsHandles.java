package com.app.seleniumsession;

import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.HashAttributeSet;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


/*
 * GU ID:GU ID abbreviation of Globally Unique Identifier,
 * 
 * 
 * 
 * 
 */



public class MultipleWindowsHandles {

	WebDriver driver;

	@Test
	public void multipleWindow() throws InterruptedException {
		System.out.println("launching firefox browser");
		String geckoDriverPath = "E:\\AutomationWorkSpace\\SeleniumJava\\JavaTestProject\\Drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", geckoDriverPath);
		driver = new FirefoxDriver();

		// driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.seleniumeasy.com/test/window-popup-modal-demo.html");

		
		String baseWindow = driver.getWindowHandle();
		System.out.println("My base widnow ID is : " + baseWindow);
		
		driver.findElement(
				By.xpath("//a[contains(text(),'Follow Twitter & Facebook')]"))
				.click();

		

		Set<String> set = new HashSet<String>();

		set.addAll(driver.getWindowHandles());

		for (String str : set) {
			System.out.println("All my window ID's " + str);
			driver.switchTo().window(str);
			Thread.sleep(8000);
			String title = driver.getTitle();
			if (title.equalsIgnoreCase("Selenium Easy (@seleniumeasy) on Twitter")) {
				String sText = driver.findElement(
						By.xpath("//input[@type='submit']")).getText();
				driver.findElement(By.xpath("//input[@type='submit']"))
						.click();
				System.out.println("My Log in text is: " + sText);
				Thread.sleep(5000);
				driver.close();
			}
		}
		
		
	
		
		Thread.sleep(5000);
		driver.switchTo().window(baseWindow);
		driver.findElement(
				By.xpath("//a[contains(text(),'Follow On Twitter')]")).click();

	}

}
