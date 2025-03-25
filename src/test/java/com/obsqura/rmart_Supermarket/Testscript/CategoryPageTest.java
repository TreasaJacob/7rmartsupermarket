package com.obsqura.rmart_Supermarket.Testscript;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart_Supermarket.pages.CategoryPage;
import com.obsqura.rmart_Supermarket.pages.HomePage;
import com.obsqura.rmart_Supermarket.pages.LoginPage;

public class CategoryPageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;
	public CategoryPage categorypage;
  @Test
  public void verifyThatUserCanCreateANewCategory() throws AWTException {
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin", "admin");
	  homepage = loginpage.clickOnSignin();
	  categorypage = homepage.clickOnCategory();
	  categorypage.clickOnNew().enterCategoryDetails("Utensils").clickOnSave();
	  boolean alert= categorypage.isAlertDisplayed();
	  Assert.assertTrue(alert,Constant.ERROEMESSAGEWHENCATEGORYCREATIONFAILEDCATEGORYPAGE);
  }
}
