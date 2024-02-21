package com.eCommerce.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountCreationDetails {
	//1. create object of webdriver
			WebDriver ldriver;
	//constructor
			public accountCreationDetails(WebDriver rdriver) {
				ldriver = rdriver;
				PageFactory.initElements(rdriver, this);
			}

		//identify webelements
			@FindBy(id =  "id_gender2")//title-mrs
			WebElement titleMrs;
			
			@FindBy(id = "customer_firstname")
			WebElement custfirstName;
			
			@FindBy(id = "customer_lastname")
			WebElement custlastName;
			
			@FindBy(id = "passwd")
			WebElement password;
			
			@FindBy(id = "submitAccount")
			WebElement register;
			
			
			
			public void selectTitleMrs() {
				titleMrs.click();
			}
			public void enterCustomerFirstName(String fname)
			{
			custfirstName.sendKeys(fname);;
		
		}

			public void enterCustomerlastName(String lname)
			{
			custlastName.sendKeys(lname);;
			}

			public void enterPassword(String pwd)
			{
			password.sendKeys(pwd);;
			}


			public void clickOnRegister() {
				register.click();
			}





}
