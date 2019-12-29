package com.inetbanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_loginDDT_002 extends BaseClass{

	@Test(dataProvider = "LoginData")
	public void loginDDT(String uid,String pwd) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setusername(uid);
		logger.info("username provided");
		lp.setpassword(pwd);
		logger.info("password provided");
		lp.clicksubmit();
		Thread.sleep(3000);
		if(isAlertpresent()==true) {
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.clicklogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close d logout alert
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertpresent() { //user defined method created
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) {
			return false;		
		}	
	}
	
	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/TestData/logindata.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int columnnum = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][] = new String[rownum][columnnum];
		for(int i=1; i<=rownum; i++) {
			for(int j=0; j<columnnum; j++) {
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return logindata;
	}
}
