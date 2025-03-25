package com.obsqura.rmart_Supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.rmat_utilities.PageUtility;

public class AdminPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
		public AdminPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement clicknewbutton;
	@FindBy(xpath = "//input[@name='username']") WebElement enterusername;
	@FindBy(xpath = "//input[@name='password']") WebElement enterpassword;
	@FindBy(xpath = "//select[@id='user_type']") WebElement selectusertype;
	@FindBy(xpath = "//button[@name='Create']") WebElement clicksave;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertsuccess;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") WebElement alertfailure;
	
	public AdminPage clickNewButton() {
		clicknewbutton.click();
		return this;
	}
	
	public AdminPage enterDetails(String username,String password,String value) {
		enterusername.sendKeys(username);
		enterpassword.sendKeys(password);
		selectusertype.click();
		/*Select select = new Select(selectusertype);
		select.selectByVisibleText(value);*/  //actual select before using page utility
		//pageutility.selectByVisibleText(selectusertype, value);   
		//pageutility.selectByIndex(selectusertype, value);
		pageutility.selectByValue(selectusertype, value);
		return this;
		
	}
	public AdminPage clickOnSave() {
		clicksave.click();
		return this;
	}
	public boolean isAlertSuccessShow() {
		return alertsuccess.isDisplayed();
	}
	
	public boolean isFailAlertShow() {
		return alertfailure.isDisplayed();
	}
		

}
