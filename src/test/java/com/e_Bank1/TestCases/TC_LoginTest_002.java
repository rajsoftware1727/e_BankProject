package com.e_Bank1.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.e_Bank1.PageObjects.Base;
import com.e_Bank1.PageObjects.Login;

public class TC_LoginTest_002 extends Base{
	
	@Test
	public void openGoogle()
	{
		Login login=new Login(driver1);
		String A_Title=driver1.getTitle();
		String E_Title="Google123";
		if(E_Title.equalsIgnoreCase(A_Title))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
	}
	
	

}
