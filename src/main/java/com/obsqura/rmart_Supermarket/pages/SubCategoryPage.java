package com.obsqura.rmart_Supermarket.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmat_utilities.FileUploadUtility;
import com.obsqura.rmat_utilities.PageUtility;
import com.obsqura.rmat_utilities.WaitUtility;

public class SubCategoryPage {
	public WebDriver driver;
	WaitUtility wait = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	public SubCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement newbutton;
	@FindBy(xpath = "//select[@id='cat_id']") WebElement selectcategorydropdown;
	@FindBy(xpath = "//input[@id='subcategory']") WebElement entersubcategory;
	@FindBy(xpath = "//input[@id='main_img']") WebElement choosefile;
	@FindBy(xpath = "//button[@name='create']") WebElement clicksavebutton;
	@FindBy(xpath= "//div[@class='alert alert-success alert-dismissible']") WebElement alertsuccess;
	
	public SubCategoryPage clickOnNewButton() {
		newbutton.click();
		return this;
	}
	public SubCategoryPage enterSubCategoryDetails(int index,String subcategory) throws AWTException {
		pageutility.selectByIndex(selectcategorydropdown, index);
		entersubcategory.sendKeys(subcategory);
		wait.elementToBeClickable(driver, choosefile);
		FileUploadUtility fileupload = new FileUploadUtility();
		fileupload.sendKeysForFileUpload(choosefile, Constant.IMAGE);
	    //fileupload.roboClassForFileUpload(choosefile, Constant.IMAGE);
	    
		return this;	
	}
	public SubCategoryPage clickOnSaveButton() {
		clicksavebutton.click();
		return this;
	}
	public boolean isAlertDisplayed() {
		return alertsuccess.isDisplayed();
	}

}
