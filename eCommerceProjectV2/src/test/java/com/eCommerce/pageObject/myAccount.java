package com.eCommerce.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {
	//1. create object of webdriver
		WebDriver ldriver;
//constructor
		public myAccount(WebDriver rdriver) {
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}

	//identify webelements
		@FindBy(id =  "email_create")
		WebElement createEmailId;
		
		@FindBy(id = "SubmitCreate")
		WebElement SubmitCreate;
	//--------------------------------------//	
		@FindBy(id = "email")
		WebElement registeredUserEmail;
		
		@FindBy(id = "passwd")
		WebElement registeredUserPwd;
		
		@FindBy(id = "SubmitLogin")
		WebElement SubmitLogin ;
		
		
		public void enterCreateEmailAddress(String emailAdd) {
			createEmailId.sendKeys(emailAdd);
		}
		public void clickSubmitCreate()
		{
			SubmitCreate.click();
		}

//---------------------------------------//
		public void enterEmailAddress(String emailAdd) {
			registeredUserEmail.sendKeys(emailAdd);
		}

		public void enterpssword(String pwd) {
			registeredUserPwd.sendKeys(pwd);
		}

		public void clickSubmit()
		{
			SubmitLogin.click();
		}
}
