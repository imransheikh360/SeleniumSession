package com.app.seleniumsession;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class InvokeChromeBrowser {
	
	WebDriver driver;
	@Test
	public void InvokeChrome() throws MalformedURLException
	{
		String chromeDriverPath= "E:\\AutomationWorkSpace\\SeleniumJava\\JavaTestProject\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		String Node = "http://192.168.0.3:4444/wd/hub";
		//ChromeOptions options = new ChromeOptions();
		//options.CAPABILITY
 		//options.addCapabilities(capabilities.)
 		//options.BrowserExecutableLocation = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
		
		
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		
		
		
 		driver = new RemoteWebDriver(new URL(Node), caps);
		//driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("http://www.seleniumeasy.com/test/");
	}

}
