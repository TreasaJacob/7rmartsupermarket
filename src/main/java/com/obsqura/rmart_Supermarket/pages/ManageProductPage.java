package com.obsqura.rmart_Supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.rmat_utilities.PageUtility;
import com.obsqura.rmat_utilities.WaitUtility;

public class ManageProductPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();
	public ManageProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@onclick='click_button(2)']") WebElement clickonsearch;
	@FindBy(xpath = "//input[@placeholder='Title']") WebElement entertitle;
	@FindBy(xpath = "//input[@placeholder='Product Code']") WebElement productcode;
	@FindBy(xpath = "//select[@id='cat_id']") WebElement selectcategory;
	@FindBy(xpath = "//select[@name='sb']") WebElement selectsubcategory;
	@FindBy(xpath = "//button[@name='Search']") WebElement clicksearchbutton;
	@FindBy(xpath = "//table/thead/tr") WebElement tableheaderappears;
	
	
	public ManageProductPage clickonSearch() {
		clickonsearch.click();
		return this;
	}
	public ManageProductPage enterTitleAndProductCode(String title,String code) {
		entertitle.sendKeys(title);
		productcode.sendKeys(code);
		return this;
	}
	public ManageProductPage selectCategory(String text) {
		selectcategory.click();
		pageutility.selectByVisibleText(selectcategory, text);
		waitutility.elementToBeClickable(driver, selectcategory);
		return this;
	}
	public ManageProductPage selectSubCategory(String text) {
		waitutility.elementToBeClickable(driver, selectsubcategory);
		selectsubcategory.click();
		pageutility.selectByVisibleText(selectsubcategory, text);
		return this;
	}
	public ManageProductPage clickOnSearchButton() {
		clicksearchbutton.click();
		return this;
	}
	public boolean isTableHeaderAppears() {
		return tableheaderappears.isDisplayed();
	}
	

}
