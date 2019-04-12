package com.app.seleniumsession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HttpAuthenticationWindow {

	
	WebDriver driver;
	
	@BeforeSuite
	public void SetUpConfiguration()
	{
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//driver.get("https://imran.sheikh:Edgecontract0r@https://inside.edgenuity.com/home/teams/TD/sqag/FQA/FQA%20Automation/Forms/AllItems.aspx?RootFolder=%2Fhome%2Fteams%2FTD%2Fsqag%2FFQA%2FFQA%20Automation%2FGuidelines&FolderCTID=0x012000AA02462ACBE19A44AE808521CC9CB7D9&View={99734BAD-2B35-4441-88DB-B92DD1557249}");
	}
	
	@Test
	public void httpAuthentication()
	{
		driver.get("https://imran.sheikh:Edgecontract0r@inside.edgenuity.com/home/teams/TD/sqag/FQA/FQA%20Automation/Forms/AllItems.aspx?RootFolder=%2Fhome%2Fteams%2FTD%2Fsqag%2FFQA%2FFQA%20Automation%2FGuidelines&FolderCTID=0x012000AA02462ACBE19A44AE808521CC9CB7D9&View={99734BAD-2B35-4441-88DB-B92DD1557249}");

		//We can handle http authentication by passing username & password along with the URL
		//   https://userName:Password@URL
		
	}
	
	@AfterSuite
	public void closeBrowser()
	{
		//driver.quit();
	}

}
