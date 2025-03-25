package com.obsqura.rmart_Supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement clickonnewbutton;
	@FindBy(xpath = "//textarea[@id='news']") WebElement textarea;
	@FindBy(xpath = "//button[@type='submit']") WebElement clickonsave;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertsuccess;
	
	public ManageNewsPage clickOnNewButton() {
		 clickonnewbutton.click();
		 return this;
	}
	public ManageNewsPage enterNews(String news) {
		textarea.sendKeys(news);
		return this;
	}
	public ManageNewsPage clickOnSave()
	{
		clickonsave.click();
		return this;
	}
	public boolean isAlertDisplayed()
	{
		return alertsuccess.isDisplayed();
	}
	

}
