package com.eCommerce.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccount {
	//1. create object of webdriver
		WebDriver ldriver;

		public RegisteredUserAccount(WebDriver rdriver) {
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}

	//identify webelements
		@FindBy(xpath =  "//a[@title='View my customer account']")
		WebElement username;
		
		
		public String getUserName()
		{
			String text= username.getText();
			return text;
		}
}
