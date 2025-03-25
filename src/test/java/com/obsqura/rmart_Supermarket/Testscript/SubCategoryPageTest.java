package com.obsqura.rmart_Supermarket.Testscript;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart_Supermarket.pages.HomePage;
import com.obsqura.rmart_Supermarket.pages.LoginPage;
import com.obsqura.rmart_Supermarket.pages.SubCategoryPage;

public class SubCategoryPageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;
	public SubCategoryPage subcategorypage;
  @Test
  public void verifyUserCanSaveSubCategoryDetails() throws AWTException {
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin", "admin");
	  homepage = loginpage.clickOnSignin();
	  subcategorypage=homepage.clickOnSubCategory();
	  subcategorypage.clickOnNewButton().enterSubCategoryDetails(4, "flowers").clickOnSaveButton();
	  boolean alert = subcategorypage.isAlertDisplayed();
	  Assert.assertTrue(alert, Constant.ERRORMESSAGEWHENSUBCATEGORYNOTCREATEDSUCCESSFULLYSUBCATEGORYPAGE);
	  
	  
  }
}
