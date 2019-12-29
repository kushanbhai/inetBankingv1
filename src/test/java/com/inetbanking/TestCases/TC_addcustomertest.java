package com.inetbanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.Addcustomerpage;
import com.inetbanking.PageObjects.LoginPage;

public class TC_addcustomertest extends BaseClass {

	@Test
	public void addnewcustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setusername(username);
		logger.info("username provided");
		lp.setpassword(password);
		logger.info("password provided");
		lp.clicksubmit();
		logger.info("clicked on submit button");
		Thread.sleep(3000);
		Addcustomerpage addcust = new Addcustomerpage(driver);
		logger.info("Providing the customer details: ");
		addcust.clickAddNewCustomer();
		addcust.custName("kushan");
		addcust.custgender("Male");
		addcust.custdob("21", "09", "1989");
		Thread.sleep(3000);
		addcust.custaddress("India");
		addcust.custcity("Bangalore");
		addcust.custstate("Karnataka");
		addcust.custpinno("562125");
		addcust.custtelephoneno("9007019093");
		String email = randomstring() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		Thread.sleep(3000);
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res == true) {
			Assert.assertTrue(true);
			logger.info("Test case is passed...");
		}

		else {
			captureScreen(driver, "addnewcustomer");
			Assert.assertTrue(false);
			logger.info("Test case failed...");
		}

	}

}
