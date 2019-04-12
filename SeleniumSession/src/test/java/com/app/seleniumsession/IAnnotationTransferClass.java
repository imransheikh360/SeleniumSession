package com.app.seleniumsession;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class IAnnotationTransferClass implements IAnnotationTransformer {


	@Override
	public void transform(ITestAnnotation annotation, Class cclass, Constructor cons,
			Method method) {
		annotation.setRetryAnalyzer(RetryFailedTestCaseClass.class);
		
		
	}

}
