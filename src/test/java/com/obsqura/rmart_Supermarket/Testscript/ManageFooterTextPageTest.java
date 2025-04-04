package com.obsqura.rmart_Supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart_Supermarket.pages.HomePage;
import com.obsqura.rmart_Supermarket.pages.LoginPage;
import com.obsqura.rmart_Supermarket.pages.ManageFooterTextPage;
import com.obsqura.rmat_utilities.ExcelUtility;
import com.obsqura.rmat_utilities.FakerUtility;

public class ManageFooterTextPageTest extends Base
{
	public HomePage homepage;
	public ManageFooterTextPage managefootertext;
	 FakerUtility faker = new FakerUtility() ;
  @Test
  public void verifyThatUserCanEditFooterTextDetails() throws Exception {
	  LoginPage loginpage = new LoginPage(driver);
	  String username = ExcelUtility.readName(1, 0,"Footertextpage");
	  String password = ExcelUtility.readName(1, 1,"Footertextpage");
	  loginpage.enterUsernameAndPassword(username,password);
	  homepage = loginpage.clickOnSignin();
	  managefootertext = homepage.clickOnManageFooterText();
	  managefootertext.clickOnFirstEditIcon();
	  String address = ExcelUtility.readName(1, 2,"Footertextpage");
	  String email = ExcelUtility.readName(1, 3,"Footertextpage");
	  String phone = ExcelUtility.getId(1, 4,"Footertextpage");
	  //String phone = faker.getPhoneNumber();
	  managefootertext.editFooterTextDetails(address,email,phone).clickOnUpdateButton();
	  boolean alert = managefootertext.isAlertDisplayed();
	  Assert.assertTrue(alert, Constant.ERRORMESSAGEWHENFOOTERTEXTUPDATIONFAILEDFOOTERTEXTPAGE);
	  
	  
  }
}
