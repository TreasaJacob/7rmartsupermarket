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
	@FindBy(xpath = "(//a[contains(@onclick,'confirm')])[1]") WebElement deleteicon;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement userdeletealertsuccess;
	@FindBy(xpath = "//a[@onclick='click_button(2)']") WebElement clickonsearchbuttoninthelistpage;
	@FindBy(xpath = "//input[@id='un']") WebElement enterusernametosearch;
	@FindBy(xpath = "//select[@id='ut']") WebElement selectusertypeforsearch;
	@FindBy(xpath = "//button[@value='sr']") WebElement searchafterenteringdata;
	@FindBy (xpath = "//table/tbody/tr/td[1]") WebElement searchedusernameelement;  //treasa
	
	
	
	public AdminPage clickNewButton() {
		clicknewbutton.click();
		return this;
	}
	
	public AdminPage enterDetails(String username,String password,String value) {
		enterusername.sendKeys(username);
		enterpassword.sendKeys(password);
		selectusertype.click();
		pageutility.selectByValue(selectusertype, value);
		return this;
		
	}
	public AdminPage clickOnSave() {
		clicksave.click();
		return this;
	}
	public AdminPage clickDeleteIconOfFirstUserInTheList() {
		deleteicon.click();
		driver.switchTo().alert().accept();
		return this;
	}
	public AdminPage clickOnSearchButtonInTheListPage()
	{
		clickonsearchbuttoninthelistpage.click();
		return this;
	}
	public AdminPage enterUsernameForSearch(String usernamesearch) {
		enterusernametosearch.sendKeys(usernamesearch);
		return this;
	}
	
	public AdminPage selectUsertypeForSearch(String visibletext) {
		selectusertypeforsearch.click();
		pageutility.selectByVisibleText(selectusertypeforsearch,visibletext );
		return this;
	}
	public AdminPage clickOnSearchAfterEnteringDetails()
	{
		searchafterenteringdata.click();
		return this;
	}
	public boolean isAlertSuccessShow() {
		return alertsuccess.isDisplayed();
	}
	
	public boolean isFailAlertShow() {
		return alertfailure.isDisplayed();
	}
	public boolean isUserDeleteAlertAppears()
	{
		return userdeletealertsuccess.isDisplayed();
	}
	public boolean isValidUsernameElementDisplayed() {
		return searchedusernameelement.isDisplayed();
	}

		

}
