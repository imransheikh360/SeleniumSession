package com.app.seleniumsession;

public class TestClassA {
	
	
	public void testMethod()
	{
		String x= "Selenium";
		String y= new String("Testing");
		String z =new String("Automation");
		System.out.println(x==y);
		System.out.println(x.equals(y));
		System.out.println(x.compareTo(y));
		System.out.println(x.compareTo(z));
		
	}
	
	public static void main(String[] args) {
		TestClassA obj= new TestClassA();
		obj.testMethod();
	}

}
