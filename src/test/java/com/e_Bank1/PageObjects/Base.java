package com.e_Bank1.PageObjects;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

 import com.e_Bank1.UtilitiFiles.ReadDataFromPropertyFile;

 
public class Base {
	
	public static WebDriver driver1;
	 public Logger logger;
	
	@BeforeTest
	public void openBrowser() throws IOException
	{
		String browserName=(String)ReadDataFromPropertyFile.dataReadFromPropertyFile("browserName");
		if(browserName.equalsIgnoreCase("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//BrowserDrivers//chromedriver.exe");
		driver1=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"//BrowserDrivers//msedgedriver.exe");
			driver1=new EdgeDriver();
		}
		driver1.manage().window().maximize();

		driver1.get((String)ReadDataFromPropertyFile.dataReadFromPropertyFile("applicationURL"));
		    logger=Logger.getLogger("e_Bank1");
  		  //BasicConfigurator.configure();
		    PropertyConfigurator.configure("Log4j.properties");
 		  logger.info("browser opened");

		  }
	
	@AfterTest
	public void tearDown()
	{
		driver1.close();
		logger.info("browser closed");
	}

}
