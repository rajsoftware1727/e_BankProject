package com.e_Bank1_ActionListener;
import org.openqa.selenium.TakesScreenshot;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

 import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.e_Bank1.UtilitiFiles.TakeScreen_Shot;

public class ActionListener implements ITestListener {
	
	public ExtentReports extentReport;
	public ExtentHtmlReporter htmlReport;
	public ExtentTest extentTest;
	public String path;
	public WebDriver driver;
	public String reportname;
	public void onStart(ITestContext context) {
		System.out.println("on start");
		String timestamp=new SimpleDateFormat("dd-MM-yyyy.HH.mm.ss").format(new Date()); //return timestamp
		  reportname="Test-Report"+timestamp+".html";
		  extentReport=new ExtentReports();
		//here i want html report specify type html or spark type
		
		  htmlReport=new ExtentHtmlReporter(System.getProperty("user.dir")+"//test-output//"+reportname);
		extentReport.attachReporter(htmlReport); //html reports are attached to extent report
		
		//set system info
		extentReport.setSystemInfo("Host name","local host");
		extentReport.setSystemInfo("Environment","local");
		extentReport.setSystemInfo("user","Rajesh");
		
		//set report title
		htmlReport.config().setDocumentTitle("e_Bank1 Project");
		htmlReport.config().setReportName("Functional Testing");
		htmlReport.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReport.config().setTheme(Theme.DARK);
		
		
		


		
		 
	}

	public void onTestStart(ITestResult result) {
		System.out.println("test started");
  	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("test success");
		  extentTest=extentReport.createTest(result.getName());
		  extentTest.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
  	}

	public void onTestFailure(ITestResult result) {
		System.out.println("test failed from listener");
		extentTest=extentReport.createTest(result.getName());
		  extentTest.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));

		  try {
			  path=TakeScreen_Shot.takeScreenShot(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			extentTest.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	  
  	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("test skipped");
 	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("test failed with success percentage");
 	}

	 

	 

	public void onFinish(ITestContext context) {
		System.out.println("on finished");
		extentReport.flush();
		try {
			Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"//test-output//"+reportname).toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
