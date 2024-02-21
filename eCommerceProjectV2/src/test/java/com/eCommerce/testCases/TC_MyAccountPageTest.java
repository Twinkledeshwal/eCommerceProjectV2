package com.eCommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eCommerce.pageObject.RegisteredUserAccount;
import com.eCommerce.pageObject.accountCreationDetails;
import com.eCommerce.pageObject.indexPage;
import com.eCommerce.pageObject.myAccount;

public class TC_MyAccountPageTest extends BaseClass{
@Test(enabled = false)
	public void VerifyRegistrationAndLogin() {
		
		
		indexPage pg = new indexPage(driver);
		pg.clickOnSignIn();
		logger.info("clicked on sign in link");
		
		myAccount myAcpg =new myAccount(driver);
		myAcpg.enterCreateEmailAddress("twinklepragyan602@gmail.com");
		logger.info("email address entered in create account section");
		myAcpg.clickSubmitCreate();
		logger.info("clicked on create an account button");

accountCreationDetails accCreationpg = new accountCreationDetails(driver);
accCreationpg.selectTitleMrs();
accCreationpg.enterCustomerFirstName("Pragyan");
accCreationpg.enterCustomerlastName("singh");
accCreationpg.enterPassword("pragyan21");
logger.info("entered user details on account creation pag");
accCreationpg.clickOnRegister();
logger.info("clicked on register button");
RegisteredUserAccount regUser = new RegisteredUserAccount(driver);
String UserName = regUser.getUserName();

Assert.assertEquals("Pragyan singh", UserName);
}
	
	@Test
	public void verifylogin() throws IOException {
		logger.info("verify login test execution strted....");
		indexPage pg = new indexPage(driver);
		pg.clickOnSignIn();
		logger.info("clicked on sign in link again to verify");
		
		myAccount myAcpg =new myAccount(driver);	
		myAcpg.enterEmailAddress("twinklepragyan602@gmail.com");
		logger.info("entered registered email");
		myAcpg.enterpssword("pragyan21");
		logger.info("entered registered password");
		myAcpg.clickSubmit();
		logger.info("clicked on sign in link..");
		RegisteredUserAccount regUser = new RegisteredUserAccount(driver);
		String UserName = regUser.getUserName();
		if(UserName.equals("Pragyan singh1")) 
		{
			logger.info("verifylogin - passed");	
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("verifylogin - failed");
			captureScreenShot(driver,"verifylogin");
			Assert.assertTrue(false);
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
