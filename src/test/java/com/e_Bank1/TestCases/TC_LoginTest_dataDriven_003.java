package com.e_Bank1.TestCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.e_Bank1.PageObjects.Base;
import com.e_Bank1.PageObjects.Login;
import com.e_Bank1_TestData.ReadExcelData;

public class TC_LoginTest_dataDriven_003 extends Base {
	
	@Test(dataProvider="raj",dataProviderClass=ReadExcelData.class)
	public void verifyLogin(String uname,String pwd) throws InterruptedException
	{
		Login login=new Login(driver1);
		login.login(uname, pwd);
		logger.info("username is entered");
		login.enterPassword(pwd);
		logger.info("password is entered");

		login.clickSignin();
		logger.info("signin is clicked");

		
		//based on the alert box open decide wether login successful done or not
		if(isAlertBoxIsOPen()==true)
		{
			driver1.switchTo().alert().accept();
			logger.info("accept the alert box");
			driver1.switchTo().defaultContent();   //after click alert ok driver come to normal work
			Assert.assertTrue(false);
		}
		else
		{
			System.out.println("alert box not open successfully logged in ");
			Assert.assertTrue(true);

			driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Thread.sleep(3000);
			login.clickLogOut();
			logger.info("logout is clicked");
			driver1.switchTo().alert().accept();
			logger.info("accept the alertbox");
			driver1.switchTo().defaultContent();
 		}
		
	}
	
	
	//method check wether alert box is open or not 
	
	public boolean isAlertBoxIsOPen()
	{
		try
		{
			driver1.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		 
	}

}
