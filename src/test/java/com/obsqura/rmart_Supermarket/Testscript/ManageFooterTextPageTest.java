package com.obsqura.rmart_Supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart_Supermarket.pages.HomePage;
import com.obsqura.rmart_Supermarket.pages.LoginPage;
import com.obsqura.rmart_Supermarket.pages.ManageFooterTextPage;

public class ManageFooterTextPageTest extends Base {
	public HomePage homepage;
	public ManageFooterTextPage managefootertext;
  @Test
  public void verifyThatUserCanEditFooterTextDetails() {
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin","admin");
	  homepage = loginpage.clickOnSignin();
	  managefootertext = homepage.clickOnManageFooterText();
	  managefootertext.clickOnFirstEditIcon();
	  managefootertext.editFooterTextDetails("Emerald Isle,Kochi","7rmat@gmail.com","9876543210").clickOnUpdateButton();
	  boolean alert = managefootertext.isAlertDisplayed();
	  Assert.assertTrue(alert, Constant.ERRORMESSAGEWHENFOOTERTEXTUPDATIONFAILEDFOOTERTEXTPAGE);
	  
	  
  }
}
