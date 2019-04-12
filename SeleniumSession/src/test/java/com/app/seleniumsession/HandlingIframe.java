package com.app.seleniumsession;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

	public class HandlingIframe {

		WebDriver driver;
		
		@BeforeSuite
		public void SetUpConfiguration()
		{
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get("http://toolsqa.com/iframe-practice-page/");
			
		}
		
		
		@Test
		public void handleiFrame() throws InterruptedException
		{
			List<WebElement> iFrame= driver.findElements(By.tagName("iframe"));
			System.out.println("Number of iFrame in this page: "+iFrame.size() );
			
			WebElement frameOneElement= driver.findElement(By.id("IF2"));
			driver.switchTo().frame(frameOneElement);
			
			//get the text
			String homeText=	driver.findElement(By.xpath("//h1[contains(text(),'Home')]")).getText();
			System.out.println("In Frame 2 getting the home text: "+ homeText);
			
			//click on tab 2
			
			driver.findElement(By.id("ui-id-2")).click();
			
			//Switch back to the default frame
			driver.switchTo().defaultContent();
			//switching into second frame 
			WebElement frameSecondElement= driver.findElement(By.id("IF1"));
			driver.switchTo().frame(frameSecondElement);
			//check the Male check box
			driver.findElement(By.xpath("//input[@value='Male']")).click();
			Thread.sleep(2000);
			boolean sexCheckbox= driver.findElement(By.xpath("//input[@value='Male']")).isSelected();
			System.out.println("Is male sex radio button selected: "+sexCheckbox );
			
			
			driver.switchTo().defaultContent();
			String mainFrameText=	driver.findElement(By.xpath("//h1[contains(text(),'Sample Iframe page')]")).getText();
			System.out.println("Main Frame text: "+ mainFrameText);
		
			
			//********************************Notes************************************************
			//If you try to access main frame element without switching then exception error is shown 
			//org.openqa.selenium.NoSuchElementException
			//You can switch into frame by using a numebr (index), name or ID
			
			//If there are multiple frames in screen and you want to switch frame 1 to frame 2. You first switch into 
			//first frame then come back to defaultcontent (Default frame). Now you cam move to frame 2
			
			//Switch can be performed on alert, iFrame, window
		}
		@AfterSuite
		public void closeBrowser()
		{
			//driver.quit();
		}
	}

	
	
	

