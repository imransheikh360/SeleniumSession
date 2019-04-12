package com.app.seleniumsession;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;



import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InSeleniumWaitCommands {
	
	
	/*
	 * Type of Waits in selenium webdriver
		
		Sleep : Sleep() is a method present in thread class
		
		Timeouts interface has three abstract methods, which are :
				implicitlyWait
				setScriptTimeout
				pageLoadTimeout
		
		pageLoadTimeout : Page load timeout in selenium requests/set the time limit for a page to load, 
						  If the page is not loaded within the given time frame selenium throws
						  TimeOutException exception 
						  --It is only applicable for driver.get() and driver.navigate().to()
		setScriptTimeout: The setScriptTimeout method affects only JavaScript code executed with executeAsyncScript
		 					and nothing else. for Ex: 
	driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	((JavascriptExecutor) driver).executeAsyncScript("document.getElementById('dummy')");
	
	
		ImplicitlyWait : 
		Due following reasons application element may take a while to load.
				Poor Server Response time
				Ajax Loading
				Size of the page
				Internet Speed
				System hardware
				Browser slowness / less responsive ness
				Element created using javascript
		- Default wait time of the selenium is 500 milli-seconds, implicitly wait overrides the default
		  wait time of the selenium webdriver.
		- Implicitly Wait is applicable only to findElement and findElements no other statement in selenium.
				
				
Wait interface : Wait interface present under org.openqa.selenium.support.ui package,
 				 FluentWait and WebdriverWait implements Wait interface.
 				 
		ExplicitWait or WebdriverWait
		
		- FluentWait and WebdriverWait implements Wait interface.
		Wait Interface
			|
		FluentWait Class
			|
		WebdriverWait Class
		
		
		
		
		
		
		
		FluentWait: Default polling time in FluentWait is 500 Milli-seconds
		
	 */

	WebDriver driver;
	@Test(priority=1)
	public void ImplicitWait()
	{
		String geckoDriverPath = "E:\\AutomationWorkSpace\\SeleniumJava\\JavaTestProject\\Drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", geckoDriverPath);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		//This is implicit wait condition
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.seleniumeasy.com/test/table-sort-search-demo.html");
		
		//This is page load condition
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
	
	
	@Test(priority=2)
	public void FluentWait()
	{

		driver.findElement(By.xpath("//a[@class='dropdown-toggle' and contains(text(),'Table')] ")).click();
		
		//a[@class='dropdown-toggle' and contains(text(),'Table')] 		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)

				.withTimeout(60, TimeUnit.SECONDS)

				.pollingEvery(2, TimeUnit.SECONDS)

				.ignoring(NoSuchElementException.class);

		WebElement element= wait.until(new Function<WebDriver, WebElement>() {

		@Override
		public WebElement apply(WebDriver t) {
			// TODO Auto-generated method stub
			return driver.findElement(By.xpath("//a[contains(text(),'Table Data Search')]"));
		}});

	}
	

	
	@Test
	public void ExplicitWait()
	{
		WebElement el= driver.findElement(By.xpath("//a[contains(text(),'Table Data Search')]"));
		WebDriverWait wait= new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(el));
		//Set the script timeout 
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}
	
	
	
	
	
	@Test
	public void setScriptWaitTimeout()
	{
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		((JavascriptExecutor) driver).executeAsyncScript("document.getElementById('dummy')");
		
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Table Data Search')]")); 
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		FluentWait fw = new FluentWait(driver);
		fw.withTimeout(30, TimeUnit.SECONDS);
		fw.pollingEvery(5, TimeUnit.SECONDS);
		fw.ignoring(NoSuchElementException.class);
		fw.withMessage("Test Message");
		
		
	}
	
	
	
}
	
	
	
	