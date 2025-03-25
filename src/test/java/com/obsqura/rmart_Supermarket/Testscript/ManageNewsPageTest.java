package com.obsqura.rmart_Supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart_Supermarket.pages.HomePage;
import com.obsqura.rmart_Supermarket.pages.LoginPage;
import com.obsqura.rmart_Supermarket.pages.ManageNewsPage;

public class ManageNewsPageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;
	public ManageNewsPage managenews;
  @Test
  public void verifyThatUserCanSaveNewsDetails() {
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin", "admin");
	  homepage = loginpage.clickOnSignin();
	  managenews =  homepage.clickOnManageNews();
	  managenews.clickOnNewButton().enterNews("Discount sale upto 50%").clickOnSave();
	  boolean alert= managenews.isAlertDisplayed();
	  Assert.assertTrue(alert, Constant.ERRORMESSAGEWHENNEWSCREATIONFAILEDNEWSPAGE);
  }
}
