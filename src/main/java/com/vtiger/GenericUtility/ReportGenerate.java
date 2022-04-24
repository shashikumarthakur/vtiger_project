package com.vtiger.GenericUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportGenerate implements ITestListener {
    ExtentReports report=null;
    ExtentTest test=null;

    @Override
    public void onTestStart(ITestResult result) {
        /*Step 3: Create a Test Method During The Test Execution Starts*/
        test=report.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
    /*Step 4: Log The Pass Method*/
        test.log(Status.PASS,result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
    /*Step 6: Log Fail Method,Take ScreenShot,Attach Screenshot to Log*/
    /*Add Execution Log*/
    	 String methodName=result.getMethod().getMethodName();
        test.log(Status.FAIL,result.getMethod().getMethodName());
        test.log(Status.FAIL,result.getThrowable());
        String path=null;
        try {
            path = new WebDriverUtility().takeScreenshot(BaseClass.sDriver, methodName);
       } catch (Throwable e) {

           e.printStackTrace();
       }
       test.addScreenCaptureFromPath(path);
   }
    

    @Override
    public void onTestSkipped(ITestResult result) {
    /*Step 5: Log The Skip Method*/
      
       
        test.log(Status.SKIP,result.getMethod().getMethodName());
        test.log(Status.SKIP,result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        /*Step 1: Extend Report Configuration*/

        ExtentSparkReporter htmlReport= new ExtentSparkReporter("./Extent_Report/report"+new JavaUtility().getCurrentDate()+".html");
        htmlReport.config().setReportName("Smoke Testing Report");
        htmlReport.config().setDocumentTitle("Comcast Automation Execution Report");
        htmlReport.config().setTheme(Theme.STANDARD);

        /*Step 2: Attach The Physical Report And Do The System Configuration*/

        report=new ExtentReports();
        report.attachReporter(htmlReport);
        report.setSystemInfo("OS","Windows 10");
        report.setSystemInfo("Enviroment","Testing Enviroment");
        report.setSystemInfo("URL","http://localhost:8888/");
        report.setSystemInfo("Report Name","Shashi");

    }

    @Override
    public void onFinish(ITestContext context) {
    	report.flush();

    }
}
