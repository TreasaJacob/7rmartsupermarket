package com.obsqura.rmart_Supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.rmat_utilities.PageUtility;
import com.obsqura.rmat_utilities.WaitUtility;

public class ManageContactPage
{
	public WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	public ManageContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@role='button']") WebElement clickonediticon;
	@FindBy(xpath = "//input[@id='phone']") WebElement phonenumber;
	@FindBy(xpath = "//input[@id='email']") WebElement emailaddress;
	@FindBy(xpath = "//textarea[@name='address']") WebElement addressfield;
	@FindBy(xpath = "//textarea[@name='del_time']") WebElement deliverytimefield;
	@FindBy(xpath = "//input[@id='del_limit']") WebElement deliverychargelimit;
	@FindBy(xpath = "//button[@type='submit']") WebElement clickupdatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertsuccess;
	
	public ManageContactPage clickOnEditIcon() {
		clickonediticon.click();
		return this;
		
	}
	public ManageContactPage enterPhone(String phone) {
		phonenumber.clear();
		phonenumber.sendKeys(phone);
		return this;
	}
	public ManageContactPage enterEmail(String email)
	{
		emailaddress.clear();
		emailaddress.sendKeys(email);
		return this;
	}
	public ManageContactPage enterAddress(String address)
	{
		addressfield.clear();
		addressfield.sendKeys(address);
		return this;
	}
	public ManageContactPage enterDeliveryTime(String deliverytime)
	{
		deliverytimefield.clear();
		deliverytimefield.sendKeys(deliverytime);
		return this;
	}
	public ManageContactPage enterDeliveryCharge(String deliverycharge) {
		deliverychargelimit.clear();
		deliverychargelimit.sendKeys(deliverycharge);
		return this;
	}
	public ManageContactPage clickUpdate() {
		pageutility.javaScriptExceutor(driver,clickupdatebutton);
		waitutility.elementToBeClickable(driver, clickupdatebutton);
		clickupdatebutton.click();
		return this;
	}
    public boolean isUpdatedSuccessfullyMessageDisplayed() {
    	return alertsuccess.isEnabled();
    }
}
