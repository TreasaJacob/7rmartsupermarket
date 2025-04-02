package com.obsqura.rmart_Supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart_Supermarket.pages.HomePage;
import com.obsqura.rmart_Supermarket.pages.LoginPage;
import com.obsqura.rmart_Supermarket.pages.ManageNewsPage;
import com.obsqura.rmat_utilities.ExcelUtility;

public class ManageNewsPageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;
	public ManageNewsPage managenews;
  @Test
  public void verifyThatUserCanSaveNewsDetails() throws Exception {
	  LoginPage loginpage = new LoginPage(driver);
	  String username = ExcelUtility.readName(1, 0, "Newspage");
	  String password = ExcelUtility.readName(1, 1, "Newspage");
	  loginpage.enterUsernameAndPassword(username,password);
	  homepage = loginpage.clickOnSignin();
	  managenews =  homepage.clickOnManageNews();
	  String news = ExcelUtility.readName(1, 2, "Newspage");
	  managenews.clickOnNewButton().enterNews(news).clickOnSave();
	  boolean alert= managenews.isAlertDisplayed();
	  Assert.assertTrue(alert, Constant.ERRORMESSAGEWHENNEWSCREATIONFAILEDNEWSPAGE);
  }
}
