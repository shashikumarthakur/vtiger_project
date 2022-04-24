package com.vtiger.GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

public class IListenerImplClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName);
		System.out.println(result.getThrowable());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName);
		System.out.println(result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName);
		System.out.println(result.getThrowable());
		
		try {
			String scren = new WebDriverUtility().takeScreenshot(BaseClass.sDriver, methodName);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	public void onTestFailedWithTimeout() {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Execution Starts");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Execution Finished");
	}
	

}
