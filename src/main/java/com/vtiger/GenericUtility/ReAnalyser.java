package com.vtiger.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class ReAnalyser implements IRetryAnalyzer {

		int count=0;
		int retrycount=5;
		
	@Override
	public boolean retry(ITestResult result) {
		if(count<retrycount) {
			count++;
			return true;
		}
		
		return false;
	}
	


}
