package com.inetbanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.LoginPage;

public class TC_logintest extends BaseClass {

	@Test
	public void logintest() throws IOException {
		driver.get(baseurl);
		logger.info("url is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setusername(username);
		logger.info("entered username");
		lp.setpassword(password);
		logger.info("entered password");
		lp.clicksubmit();
		logger.info("clicked on submit button");
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		
		else {
			captureScreen(driver, "logintest");
			Assert.assertTrue(false);
			logger.info("Logger test failed");
		}
	}

}
