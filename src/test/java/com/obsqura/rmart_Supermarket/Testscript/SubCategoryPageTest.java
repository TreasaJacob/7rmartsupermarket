package com.obsqura.rmart_Supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart_Supermarket.pages.HomePage;
import com.obsqura.rmart_Supermarket.pages.LoginPage;
import com.obsqura.rmart_Supermarket.pages.SubCategoryPage;
import com.obsqura.rmat_utilities.ExcelUtility;
import com.obsqura.rmat_utilities.FakerUtility;

public class SubCategoryPageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;
	public SubCategoryPage subcategorypage;
	FakerUtility faker = new FakerUtility() ;
  @Test(retryAnalyzer = com.obsqura.rmart.retry.Retry.class)
  public void verifyUserCanSaveSubCategoryDetails() throws Exception {
	  LoginPage loginpage = new LoginPage(driver);
	  String username = ExcelUtility.readName(1, 0,"Subcategory");
	  String password = ExcelUtility.readName(1, 1,"Subcategory");
	  loginpage.enterUsernameAndPassword(username,password);
	  homepage = loginpage.clickOnSignin();
	  subcategorypage=homepage.clickOnSubCategory();
	  //String subcategoryitem = faker.getFakeCategoryName();
	  String subcategoryitem = ExcelUtility.readName(1, 3,"Subcategory");
	  subcategorypage.clickOnNewButton().enterSubCategoryDetails(2, subcategoryitem).clickOnSaveButton();
	  boolean alert = subcategorypage.isAlertDisplayed();
	  Assert.assertTrue(alert, Constant.ERRORMESSAGEWHENSUBCATEGORYNOTCREATEDSUCCESSFULLYSUBCATEGORYPAGE);
	  
	  
  }
}
