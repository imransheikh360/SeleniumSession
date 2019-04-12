/*package com.app.seleniumsession;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FindAllBrokenLinksBaseClass {
	
	WebDriver driver;
	
	@Test
	public void findAllLinks() throws IOException
	{
		
		//WebDriver driver
		String geckoDriverPath = "E:\\AutomationWorkSpace\\SeleniumJava\\JavaTestProject\\Drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", geckoDriverPath);
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.seleniumeasy.com/test/");
		
		
		
		//List<WebElement> allLinks= new ArrayList<>();
		allLinks = driver.findElements(By.tagName("a"));
		allLinks.addAll((driver.findElements(By.tagName("img"))));
		
		List<WebElement> finalList= new ArrayList<>();
		
		for(WebElement el: allLinks)
		{
			if(el.getAttribute("href")!=null)
			{
				finalList.add(el);
			}
		}
		
	System.out.println("I am done with adding all links in list");
	
	System.out.println("Printing all the links" + finalList.size());
	
	for(WebElement el: finalList)
	{
		System.out.println("links are : " + el.getAttribute("href"));
	
	System.out.println("Printing all the links1" + finalList.size());
	
	URL url= new URL(el.getAttribute("href"));
	HttpsURLConnection httpUrlConnection= (HttpsURLConnection) url.openConnection();
	
	try{
		httpUrlConnection.connect();
		String response= httpUrlConnection.getResponseMessage();
		
		httpUrlConnection.disconnect();
		System.out.println("Response: " + response);
		System.out.println("Status code: " + httpUrlConnection.getResponseCode());
	}
	catch(Exception e){
		e.getMessage();
	}

	
	}
	
	
		
	}
	
	public void isLinkBroken(URL url) throws IOException
	{
		HttpsURLConnection httpUrlConnection= (HttpsURLConnection) url.openConnection();
		
		try{
			httpUrlConnection.connect();
			String response= httpUrlConnection.getResponseMessage();
			httpUrlConnection.disconnect();
			System.out.println("Response: " + response);
		}
		catch(Exception e){
			e.getMessage();
		}
	}
	
	

}
*/