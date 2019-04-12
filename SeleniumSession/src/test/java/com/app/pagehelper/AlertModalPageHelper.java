package com.app.pagehelper;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utils.DriverHelper;

public class AlertModalPageHelper extends DriverHelper {

	@FindBy(xpath = "(//a[contains(text(),'Alerts & Modals')])[2]")
	private WebElement ActionMenu;

	@FindBy(xpath = "(//a[contains(text(),'Bootstrap Alerts')])[2]")
	private WebElement BootStrapAlertSubMenu;

	@FindBy(id = "autoclosable-btn-success")
	private WebElement autoCloseButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-autocloseable-success' and @style='display: block;']")
	private WebElement autoMessage;

	public AlertModalPageHelper(WebDriver driver) {
		super(driver);
	}

	public AlertModalPageHelper clickOnAlertModelMenu()
			throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) (getWebDriver());
		js.executeScript("window.scrollBy(0,200)", "");
		ActionMenu.click();
		Thread.sleep(2000);
		return PageFactory.initElements(getWebDriver(),
				AlertModalPageHelper.class);
	}

	public void clickOnBootstrapAlertSubMenu() {
		BootStrapAlertSubMenu.click();
	}

	public void clickOnWindowPopUpModalSubMenu() {
		getWebDriver().findElement(
				By.xpath("(//a[contains(text(),'Window Popup Modal')])[2]"))
				.click();

	}

	public void performActionOnFacebookWindow() throws InterruptedException {
		// Get base window ID

		String baseWindowId = getWebDriver().getWindowHandle();
		getWebDriver().findElement(By.linkText("Follow Twitter & Facebook"))
				.click();
		Thread.sleep(10000);
		Set<String> windowIds = getWebDriver().getWindowHandles();
		for (String windowId : windowIds) {
			getWebDriver().switchTo().window(windowId);

			if (getWebDriver().getTitle().equalsIgnoreCase(
					"Selenium Easy - Home | Facebook")) {
				// perform some action and get back to orignal window;
				System.out
						.println("Yes... I am inside the selenium Easy popup : "
								+ windowId);
				this.getMessageFromFacebookPage();

			}
		}

		getWebDriver().switchTo().window(baseWindowId);

		for (String windowId : windowIds) {
			getWebDriver().switchTo().window(windowId);

			if (!(windowId.equals(baseWindowId))) {
				System.out.println("Window ID: " + windowId);
				getWebDriver().close();

			}
		}

		getWebDriver().switchTo().window(baseWindowId);

		getWebDriver().switchTo().window(baseWindowId);

	}

	public void getMessageFromFacebookPage() {
		String str = getWebDriver().findElement(By.xpath("//u[contains(text(),'Facebook')]")).getText();
		System.out.println("String is : " + str);
	}

	public void clickOnAutoCloseMessageButton() {
		autoCloseButton.click();
	}

	public boolean VerifyMessageIsDisplayed() {
		boolean result = autoMessage.isDisplayed();
		return result;
	}

}
