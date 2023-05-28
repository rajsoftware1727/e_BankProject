package com.e_Bank1.UtilitiFiles;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.e_Bank1.PageObjects.Base;

import io.netty.handler.codec.DateFormatter;

public class TakeScreen_Shot extends Base{
	
 	public static File srcFile;
	public static File destFile;
	public static String path;
	public static String takeScreenShot(ITestResult t) throws IOException  
	{
	 
 		TakesScreenshot screenShot=(TakesScreenshot)driver1;
		  srcFile=screenShot.getScreenshotAs(OutputType.FILE);
		  System.out.println("screen shot taken successfully");
		String timestamp=new SimpleDateFormat("dd-MM-yyyy.HH.mm.ss").format(new java.util.Date()); //return timestamp
 		  destFile=new File(System.getProperty("user.dir")+"//screenshot//"+t.getName()+"//"+t.getName()+timestamp+".jpg");
 		  FileUtils.copyFile(srcFile, destFile);
		  path=destFile.getAbsolutePath();
		  return path;
	}

}
