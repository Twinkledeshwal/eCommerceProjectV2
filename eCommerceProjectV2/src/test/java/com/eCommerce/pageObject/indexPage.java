package com.eCommerce.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
//1. create object of webdriver
	WebDriver ldriver;

	public indexPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

//identify webelements
	@FindBy(linkText = "Sign in")
	WebElement signIn;
	
	
	public void clickOnSignIn()
	{
		signIn.click();
	}
}
