package com.obsqura.rmart_Supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage
{
	public WebDriver driver;
	public ManageFooterTextPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[1]") WebElement clickonfirstediticon;
	@FindBy(xpath = "//textarea[@name='address']") WebElement addressfield;
	@FindBy(xpath = "//input[@id='email']") WebElement emailfield;
	@FindBy(xpath= "//input[@id='phone']") WebElement phonenumber;
	@FindBy(xpath= "//button[@name='Update']") WebElement clickonupdatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertsuccess;
	
	public ManageFooterTextPage clickOnFirstEditIcon() {
		clickonfirstediticon.click();
		return this;
	}
	public ManageFooterTextPage editFooterTextDetails(String address,String email,String num) {
		addressfield.clear();
		addressfield.sendKeys(address);
		emailfield.clear();
		emailfield.sendKeys(email);
		phonenumber.clear();
		phonenumber.sendKeys(num);
		return this;
	}
	public ManageFooterTextPage clickOnUpdateButton() {
		clickonupdatebutton.click();
		return this;
	}
	public boolean isAlertDisplayed() {
		return alertsuccess.isDisplayed();
	}

}
