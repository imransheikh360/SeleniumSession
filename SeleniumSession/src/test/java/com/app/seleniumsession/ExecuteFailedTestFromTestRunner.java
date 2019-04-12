package com.app.seleniumsession;

import java.util.ArrayList;

import org.testng.TestNG;

public class ExecuteFailedTestFromTestRunner {
	
	public static void main(String[] args) {
		
		TestNG runner= new TestNG();
		ArrayList<String> suite= new ArrayList<String>();
		suite.add("E:\\AutomationWorkSpace\\SeleniumJava\\JavaTestProject\\test-output\\ImranSuite\\testng-failed.xml");
		runner.setTestSuites(suite);
		runner.run();
	}
}
