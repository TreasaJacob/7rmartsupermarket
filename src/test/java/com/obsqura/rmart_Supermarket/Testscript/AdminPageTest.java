package com.obsqura.rmart_Supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart_Supermarket.pages.AdminPage;
import com.obsqura.rmart_Supermarket.pages.HomePage;
import com.obsqura.rmart_Supermarket.pages.LoginPage;

public class AdminPageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;
	public AdminPage adminpage;
  @Test
  public void verifyThatAdminCanCreateNewUserDetails() {
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin", "admin");
	  homepage=loginpage.clickOnSignin();
	  adminpage =homepage.clickonMoreInfo();
	  adminpage.clickNewButton().enterDetails("johnana", "Password","db").clickOnSave();
	  boolean alert = adminpage.isAlertSuccessShow();
	 Assert.assertTrue(alert, Constant.ERRORMESSAGEWHENUSERCREATIONFAILEDADMINPAGE);
  }
  @Test
  @Parameters({"username","password","usertype"})
  public void verifyThatAdminCannotCreateAlreadyExistingUser(String username,String password,String usertype) {
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin", "admin");
	  homepage=loginpage.clickOnSignin();
	  adminpage =homepage.clickonMoreInfo();
	  adminpage.clickNewButton().enterDetails(username,password,usertype).clickOnSave();
	  boolean alert = adminpage.isFailAlertShow();
	  Assert.assertTrue(alert, Constant.ERRORMESSAGEWHENALREADYEXISTINGUSERISCREATEDADMINPAGE);
  }
}
