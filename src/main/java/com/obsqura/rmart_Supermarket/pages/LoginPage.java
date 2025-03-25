package com.obsqura.rmart_Supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username") WebElement enterusername;
	@FindBy(name = "password")  WebElement enterpassword;
	@FindBy(xpath = "//button[@type='submit']") WebElement clickonsignin;
	@FindBy(xpath = "//p[text()= 'Sign in to start your session']") WebElement signintextontop;
	
	
	public LoginPage enterUsernameAndPassword(String username,String password) {
		enterusername.sendKeys(username);
		enterpassword.sendKeys(password);
		return this;
	}
	
	public HomePage clickOnSignin() {
		clickonsignin.click();
		return new HomePage(driver);
	}
	
	public boolean isSignInTextAppearsOnTop() {
		return signintextontop.isDisplayed();
		
	}
	

}
