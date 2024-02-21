package com.eCommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eCommerce.pageObject.RegisteredUserAccount;
import com.eCommerce.pageObject.accountCreationDetails;
import com.eCommerce.pageObject.indexPage;
import com.eCommerce.pageObject.myAccount;
import com.eCommerce.utilities.ReadExcelFile;

public class TC_MyAccountPageTestDataDrivenTesting extends BaseClass{
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
	
	@Test(dataProvider="LoginDataProvider")
	public void verifylogin(String userEmail, String userpwd, String expectedUsername) throws IOException {
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
	
	
	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\eCommerceProjectV2TestData.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");


		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
			}

		}
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
