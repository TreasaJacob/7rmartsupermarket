package com.obsqura.rmart_Supermarket.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SubCategoryPage {
	public WebDriver driver;
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
		selectcategorydropdown.click();
		Select select = new Select(selectcategorydropdown);
		select.selectByIndex(index);
		entersubcategory.sendKeys(subcategory);
		choosefile.sendKeys("C:\\Users\\treas\\OneDrive\\Pictures\\1.1.1.png");
		/*choosefile.click();
		StringSelection selection = new StringSelection("C:\\Users\\treas\\OneDrive\\Pictures\\1.1.1.png");//File upload using robot class
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
		Robot robo = new Robot();
		robo.delay(2000);
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyPress(KeyEvent.VK_ENTER);                                                        
		robo.keyRelease(KeyEvent.VK_ENTER);*/
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
