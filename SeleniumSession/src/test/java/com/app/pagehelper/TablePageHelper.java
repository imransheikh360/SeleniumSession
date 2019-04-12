package com.app.pagehelper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.app.utils.DriverHelper;

public class TablePageHelper extends DriverHelper {
	
	WebDriver driver;
	
	
	public TablePageHelper(WebDriver driver) {
			super(driver);	
		}
	
	public void clickOnTableMenu() throws InterruptedException
	{
		JavascriptExecutor js=  (JavascriptExecutor) (driver);
		js.executeScript("window.scrollBy(0,200)", "");
		driver.findElement(By.xpath("(//a[contains(text(),'Table')])[1]")).click();
		//driver.findElement(By.xpath("(//a[contains(text(),'Input Forms')])[2]")).click();
		Thread.sleep(2000);
	}
	
	public void clickOnTableDataSearchSubMenu()
	{
		driver.findElement(By.xpath("(//a[contains(text(),'Table Data Search')])[1]")).click();
	}
	
	
	public void enterSearchKeyword(String searchKeyword)
	{
		WebElement el= driver.findElement(By.xpath("//input[@id='task-table-filter']"));
		el.clear();
		el.click();
	}
	
	
	public boolean isSsearchElementDisplayed(String searchKeyword)
	{
		WebElement el= driver.findElement(By.xpath("//table[@id='task-table']/tbody/tr//td[contains(text(),'"+searchKeyword+"')]"));
		boolean result=	el.isDisplayed();
		return result;
		
	}
	
}
