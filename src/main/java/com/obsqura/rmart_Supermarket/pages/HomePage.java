package com.obsqura.rmart_Supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="(//img[@alt='User Image'])[1]") WebElement clickonadmin;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/logout'])[1]") WebElement clickonlogout;
	@FindBy (xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]") WebElement clickonadminusersmoreinfo;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'])[2]") WebElement clickoncategory;
	@FindBy(xpath = "(//p[text()='Manage News'])[1]") WebElement clickonmanagenews;
	@FindBy(xpath = "//p[text()='Sub Category']") WebElement clickonsubcategory;
	@FindBy(xpath = "//p[text()='Manage Footer Text']") WebElement clickonmanagefootertext;
	
	
	public HomePage clickOnAdminUser()
	{
		clickonadmin.click();
		return this;
	}
	
	public HomePage clickOnLogOut() {
		clickonlogout.click();	
		return this;
	}
	
	public AdminPage clickonMoreInfo() {
		clickonadminusersmoreinfo.click();
		return new AdminPage(driver);
	}
	
	public CategoryPage clickOnCategory() {
		clickoncategory.click();
		return new CategoryPage(driver);
		
	}
	public ManageNewsPage clickOnManageNews() {
		clickonmanagenews.click();
		return new ManageNewsPage(driver);
	}
	public SubCategoryPage clickOnSubCategory() {
		clickonsubcategory.click();
		return new SubCategoryPage(driver);
	}
	public ManageFooterTextPage clickOnManageFooterText() {
		clickonmanagefootertext.click();
		return new ManageFooterTextPage(driver);
	}
	
	
	

}
