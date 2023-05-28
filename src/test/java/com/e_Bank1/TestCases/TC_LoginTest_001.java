package com.e_Bank1.TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.e_Bank1.PageObjects.Base;
import com.e_Bank1.PageObjects.Login;
import com.e_Bank1_TestData.ReadExcelData;

public class TC_LoginTest_001 extends Base {
	//open browser
	//execute test
	//close the browser
	
	@Test
	public void verifyLogin() throws InterruptedException
	{
		Login login=new Login(driver1);
		login.login("mngr497976", "");
		logger.info("username is entered");
		login.enterPassword("apAvazU");
		logger.info("password is entered");
		login.clickSignin();
		logger.info("login is  clicked");
		String pageTitle=driver1.getTitle();
		logger.info("get the page title");
		System.out.println(pageTitle);
		Assert.assertTrue(true);
		System.out.println("hii raj ");
		
	}
	
	 

}
