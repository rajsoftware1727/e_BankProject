package com.e_Bank1.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	public WebDriver driver;
	//find the elements and do actions
	
	@FindBy(how=How.NAME,using="uid")
	WebElement username;
	@FindBy(how=How.NAME,using="password")
	WebElement password;
	@FindBy(how=How.XPATH,using="//input[@name='btnLogin']")
	WebElement loginbutton;
	@FindBy(how=How.CSS,using="a[href='Logout.php']")
	WebElement logout;
	
	//create constructor to initiate driver
	
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//lets do actions
	
	public void login(String userNamevalue, String passwordValue) throws InterruptedException
	{
		username.sendKeys(userNamevalue);
		password.sendKeys(passwordValue);
		loginbutton.click();
		
		Thread.sleep(3000);
	}
	public void enterPassword(String passwordValue) throws InterruptedException
	{
		password.sendKeys(passwordValue);
		Thread.sleep(3000);

	}
	public void clickSignin()
	{
		loginbutton.click();
	}
	public void clickLogOut()
	{
		logout.click();
	}

}
