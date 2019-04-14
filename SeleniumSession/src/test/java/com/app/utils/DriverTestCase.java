package com.app.utils;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.app.pagehelper.AlertModalPageHelper;
import com.app.pagehelper.InputFormPageHelper;
import com.app.pagehelper.TablePageHelper;



public abstract class DriverTestCase {
	
	public PropertyReader propertyReader;
	public AlertModalPageHelper alertModelPageHelper;
	public InputFormPageHelper inputFormPageHelper;
	public TablePageHelper tablePageHelper;

	private WebDriver driver;
	
	enum DriverType {
		Firefox, IE, Chrome
	}

	
	@BeforeSuite
	public void setUp() {		
		
		 propertyReader = new PropertyReader();
		
		String driverType = propertyReader.readApplicationFile("BROWSER");		
							
		if (DriverType.Firefox.toString().equals(driverType)) {	
			
			String geckoDriverPath = "F:\\SeleniumSession\\SeleniumSession\\Drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", geckoDriverPath);
				driver = new FirefoxDriver();				
			
		} else if (DriverType.IE.toString().equals(driverType)) {
			driver = new InternetExplorerDriver();
			
		} else if (DriverType.Chrome.toString().equals(driverType)) {
			String chromeDriverPath = "F:\\AutomationWorkspace\\SeleniumSession\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		    driver = new ChromeDriver();
			
		} else {
			driver = new FirefoxDriver();			
		}			
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		openURL();
		//alertModelPageHelper= new AlertModalPageHelper(driver);
		alertModelPageHelper= PageFactory.initElements(driver, AlertModalPageHelper.class);
		inputFormPageHelper= new InputFormPageHelper(driver);
		tablePageHelper = new TablePageHelper(driver);

	}
	
	
	@AfterSuite
	public void afterMainMethod() {	
		alertModelPageHelper= null;
		inputFormPageHelper= null;
		tablePageHelper= null;
		 
		 driver.quit();
	}
	
	public WebDriver getWebDriver(){
		return driver;
	}
	
	public PropertyReader getProperty()
	{
		return propertyReader;
	}
	
	
	public String switchPreviewWindow()
	{
		Set<String> windows = getWebDriver().getWindowHandles();
		Iterator<String> iter = windows.iterator();		
		String parent = iter.next();
		getWebDriver().switchTo().window(iter.next());
		return parent;
	}
	
	public void openURL(){
		//open admin control panel application URL 
		PropertyReader propertyReader = new PropertyReader();	
		String applicationUrl = propertyReader.readApplicationFile("WebURL");
		//getWebDriver().get(applicationUrl+"/en/ControlPanel.html");
		getWebDriver().get(applicationUrl);
		//getWebDriver().get(applicationUrl);
	}
	
	
	public void clickOnDemoWebsite()
	{
		driver.findElement(By.xpath("//a[contains(text(),'Demo Website!')]")).click();
	}
	
	public int getRandomInteger(int aStart, int aEnd, Random aRandom){
	    if ( aStart > aEnd ) {
	      throw new IllegalArgumentException("Start cannot exceed End.");
	    }
	    //get the range, casting to long to avoid overflow problems
	    long range = (long)aEnd - (long)aStart + 1;
	    // compute a fraction of the range, 0 <= frac < range
	    long fraction = (long)(range * aRandom.nextDouble());
	    int randomNumber =  (int)(fraction + aStart);    
	    return randomNumber;
	}
	

	public String randomString( int len ) 
	{
		String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder( len );
		for( int i = 0; i < len; i++ ) 
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();
	}




	
	
	
	
	

}
