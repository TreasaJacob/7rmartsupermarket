package com.obsqura.rmart_Supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart_Supermarket.pages.CategoryPage;
import com.obsqura.rmart_Supermarket.pages.HomePage;
import com.obsqura.rmart_Supermarket.pages.LoginPage;
import com.obsqura.rmat_utilities.ExcelUtility;
import com.obsqura.rmat_utilities.FakerUtility;

public class CategoryPageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;
	public CategoryPage categorypage;
	FakerUtility faker = new FakerUtility() ;
  @Test(retryAnalyzer = com.obsqura.rmart.retry.Retry.class )
  public void verifyThatUserCanCreateANewCategory() throws Exception {
	  LoginPage loginpage = new LoginPage(driver);
	  String username = ExcelUtility.readName(1, 0, "Categorypage");
	  String password = ExcelUtility.readName(1, 1, "Categorypage");
	  loginpage.enterUsernameAndPassword(username,password);
	  homepage = loginpage.clickOnSignin();
	  categorypage = homepage.clickOnCategory();
	  //String categoryname = ExcelUtility.readName(1, 2, "Categorypage");
	  String categoryname=faker.getFakeCategoryName();
	  categorypage.clickOnNew().enterCategoryDetails(categoryname).clickOnSave();
	  boolean alert= categorypage.isAlertDisplayed();
	  Assert.assertTrue(alert,Constant.ERROEMESSAGEWHENCATEGORYCREATIONFAILEDCATEGORYPAGE);
  }
}
