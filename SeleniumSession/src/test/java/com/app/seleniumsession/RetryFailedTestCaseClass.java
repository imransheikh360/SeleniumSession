package com.app.seleniumsession;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCaseClass implements IRetryAnalyzer {

	int counter= 0;
	int noOftimeNeedToRun=1;
	@Override
	public boolean retry(ITestResult result) {
		
		if(counter<noOftimeNeedToRun)
		{
			counter++;
			return true;
		}
		return false;
	}

}
