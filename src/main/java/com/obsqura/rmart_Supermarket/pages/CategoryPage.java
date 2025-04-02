package com.obsqura.rmart_Supermarket.pages;

import java.awt.AWTException;
//import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmat_utilities.FileUploadUtility;
import com.obsqura.rmat_utilities.PageUtility;
import com.obsqura.rmat_utilities.WaitUtility;

public class CategoryPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility(); 
	public CategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement clickonnew;
	@FindBy(xpath = "//input[@id='category']") WebElement entercategory;
	@FindBy(xpath= "//li[@id='134-selectable']") WebElement clickondiscount;
	@FindBy(xpath= "//input[@id='main_img']") WebElement clickonchoosefile;
	@FindBy(xpath= "(//input[@name='show_home'])[2]") WebElement radioclickonnoofleftmenu;
	@FindBy(xpath= "//button[text()='Save']") WebElement clickonsave;
	@FindBy(xpath= "//div[@class='alert alert-success alert-dismissible']") WebElement alertsuccess;
	
	public CategoryPage clickOnNew() {
		clickonnew.click();
		return this;
		
	}
	public CategoryPage enterCategoryDetails(String category) throws AWTException {
		entercategory.sendKeys(category);
		clickondiscount.click();
		FileUploadUtility fileupload = new FileUploadUtility();    //for uploading files using sendkeys method
		fileupload.sendKeysForFileUpload(clickonchoosefile, Constant.IMAGE);
		pageutility.javaScriptExceutor(driver, radioclickonnoofleftmenu);
		waitutility.elementToBeClickable(driver, radioclickonnoofleftmenu);
		radioclickonnoofleftmenu.click();
		return this;
	}
	
	public CategoryPage clickOnSave() {
		
		pageutility.javaScriptExceutor(driver, clickonsave);
		waitutility.elementToBeClickable(driver, clickonsave);
		clickonsave.click();
		return this;
		
	}
	
	public boolean isAlertDisplayed()
	{
		return alertsuccess.isDisplayed();
		
	}

}
