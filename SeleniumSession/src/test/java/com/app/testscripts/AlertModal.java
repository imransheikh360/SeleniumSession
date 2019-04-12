package com.app.testscripts;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.utils.DriverTestCase;

public class AlertModal extends DriverTestCase {
	
	//AlertModal alertModel= new AlertModal();

	@Test
	public void TestAlert() throws InterruptedException {

		clickOnDemoWebsite();
		alertModelPageHelper.clickOnAlertModelMenu();
		alertModelPageHelper.clickOnBootstrapAlertSubMenu();
		alertModelPageHelper.clickOnAutoCloseMessageButton();
		
		boolean result = alertModelPageHelper.VerifyMessageIsDisplayed();
		Assert.assertTrue(result, "Message should be displayed...");

	}

}
