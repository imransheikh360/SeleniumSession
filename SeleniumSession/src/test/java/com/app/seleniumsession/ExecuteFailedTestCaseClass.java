package com.app.seleniumsession;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/*
 * There are two ways we can execute failed test cases in Test NG
 * 1) By implementing "IRetryAnalyzer" interface which have only one method. Just need to pass implemented
 * class in @Test annotation
 * 2) By implementing "IAnnotationTransformer". After implementing this interface you can define at TestNG.xml file
 * level
 * 
 * 
 * 
 */

public class ExecuteFailedTestCaseClass {

	@Test(retryAnalyzer = RetryFailedTestCaseClass.class)
	//@Test
	public void Method1()
	{
		System.out.println("My first method 1");
	}
	
	//@Test(retryAnalyzer = RetryFailedTestCaseClass.class)
	@Test
	public void Method2()
	{
		System.out.println("My first method 2");
	}
	//@Test(retryAnalyzer = RetryFailedTestCaseClass.class)
	@Test
	public void Method3()
	{
		Assert.assertTrue(false);
	}
}
