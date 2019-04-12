package com.app.seleniumsession;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;







//import java.io.File;
import java.io.File;
import java.io.IOException;

public class TakeScreenshotClass {
	
	
	WebDriver driver;
	File src;
	@Test
	public void takeScreenShot() throws IOException
	{
		 driver= new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 driver.get("https://www.google.com/");
		 
		 File desc= new File("E:\\AutomationWorkSpace\\SeleniumJava\\JavaTestProject\\ScreenShot\\imran.png");
		// File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 
		 TakesScreenshot tc= (TakesScreenshot)driver;
		 src= tc.getScreenshotAs(OutputType.FILE);
		 
		 FileUtils.copyFile(src, desc);
		 //FileUtils.copyFile(srcFile, destFile);
		 
	}

}
