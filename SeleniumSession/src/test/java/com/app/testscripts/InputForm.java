package com.app.testscripts;

import org.testng.annotations.Test;

import com.app.utils.DriverTestCase;

public class InputForm extends DriverTestCase {
	
	String inputKeyword= "TestLogica";

	@Test
	public void TestInputForm() throws InterruptedException {

		clickOnDemoWebsite();
		inputFormPageHelper.inputFormDropDown();
		inputFormPageHelper.SimpleFormDemoMenu();
		inputFormPageHelper.enterMessage(inputKeyword);
		inputFormPageHelper.clickOnShowMessageButton();
		inputFormPageHelper.getSimpleInputMessage();

	}

}