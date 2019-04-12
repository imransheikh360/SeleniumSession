package com.app.pagehelper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.app.utils.DriverHelper;


public class InputFormPageHelper extends DriverHelper {
	
	//@FindBy(xpath="(//a[contains(text(),'Input Forms')])[2]")
	//private WebElement inputform;
	
	WebDriver driver;
	
	
	public InputFormPageHelper(WebDriver driver) {
			super(driver);	
		}
		
	
	public void inputFormDropDown() throws InterruptedException
	{
		JavascriptExecutor js=  (JavascriptExecutor) (getWebDriver());
		js.executeScript("window.scrollBy(0,200)", "");
		getWebDriver().findElement(By.xpath("(//a[contains(text(),'Input Forms')])[2]")).click();
		//inputform.click();
		Thread.sleep(2000);
	}
	
	public void SimpleFormDemoMenu()
	{
		getWebDriver().findElement(By.xpath("(//a[contains(text(),'Simple Form Demo')])[2]")).click();
	}
	
	
	public void enterMessage(String inputKeyword)
	{
		getWebDriver().findElement(By.xpath("//input[@id='user-message']")).sendKeys(inputKeyword);
	}
	
	public void clickOnShowMessageButton()
	{
		getWebDriver().findElement(By.xpath("//button[contains(text(),'Show Message')]")).click();
	}
	
	
	public String getSimpleInputMessage()
	{
		String str= getWebDriver().findElement(By.xpath("//span[@id='display']")).getText();
		return str;
	}

}
