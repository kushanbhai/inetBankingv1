package com.inetbanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name="uid")
	WebElement txtusername;
	
	@FindBy(name="password")
	WebElement txtpassword;
	
	@FindBy(name="btnLogin")
	WebElement btnlogin;
	
	@FindBy(xpath = "//a[text()='Log out']")
	WebElement logout;
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	public void setusername(String uname) {
		txtusername.sendKeys(uname);
	}
	
	public void setpassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void clicksubmit() {
		btnlogin.click();
	}
	
	public void clicklogout() {
		logout.click();
	}
}
