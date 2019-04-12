package com.app.seleniumsession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DragDropClass  {
	
	
	WebDriver driver;
	
	@BeforeSuite
	public void SetUpConfiguration()
	
	{
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/droppable/");
		
	}
	@Test(priority= 1)
	public void dragDropMethod()
	{
		
	   WebDriverWait wait = new WebDriverWait(driver, 10);
	   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
	   
	   WebElement from = driver.findElement(By.id("draggable"));
	   WebElement to = driver.findElement(By.id("droppable"));
	   
	   
	   Actions action = new Actions(driver);
	   action.dragAndDrop(from, to).perform();
	   //(new Actions(driver)).dragAndDrop(from, to).perform();
		
	}
	
	@Test(priority= 2)
	public void mouseHoverMethod()
	{
		//driver.findElement(By.linkText("Tooltip")).click();
		//div[@id='sidebar']/aside[2]/ul/li[14]/a
		//((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		/*WebElement element= driver.findElement(By.xpath("//div[@id='sidebar']/aside[2]/ul/li[14]/a"));
		((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);*/
		
		driver.findElement(By.xpath("//div[@id='sidebar']/aside[2]/ul/li[14]/a")).click();
		//mouse hover on tooltip link
		WebElement tooltipLink= driver.findElement(By.xpath("//a[contains(text(),'Tooltips')]"));
		
		Actions action= new Actions(driver);
		action.moveToElement(tooltipLink).click().perform();
		
		
		
		//Action class have following fucntions
		/*action.build();
		action.click();
		action.clickAndHold(onElement);
		action.contextClick();
		action.doubleClick();
		action.dragAndDrop(source, target);
		action.keyDown(theKey);
		action.pause(p);
		action.release(onElement);*/
	}
	
	
	
	@AfterSuite
	public void closeBrowser()
	{
		//driver.quit();
	}

}
