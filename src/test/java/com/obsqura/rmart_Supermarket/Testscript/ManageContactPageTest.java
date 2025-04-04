package com.obsqura.rmart_Supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart_Supermarket.pages.HomePage;
import com.obsqura.rmart_Supermarket.pages.LoginPage;
import com.obsqura.rmart_Supermarket.pages.ManageContactPage;
import com.obsqura.rmat_utilities.ExcelUtility;

public class ManageContactPageTest extends Base
{
	public LoginPage loginpage;
	public HomePage homepage;
	public ManageContactPage contactpage;
  @Test
  public void verifyThatUserCanEditContactDetails() throws Exception {
	  LoginPage loginpage = new LoginPage(driver);
	  String username = ExcelUtility.readName(1, 0, "Contactpage");
	  String password = ExcelUtility.readName(1, 1, "Contactpage");
	  loginpage.enterUsernameAndPassword(username,password);
	  homepage = loginpage.clickOnSignin();
	  contactpage = homepage.clickonManageContact();
	  String enterphone = ExcelUtility.getId(1, 2, "Contactpage");
	  String enteremail = ExcelUtility.readName(1, 3, "Contactpage");
	  String enteraddress = ExcelUtility.readName(1, 4, "Contactpage");
	  String enterdeliverytime = ExcelUtility.getId(1, 5, "Contactpage");
	  String enterdeliverycharge = ExcelUtility.getId(1, 6, "Contactpage");
	  contactpage.clickOnEditIcon().enterPhone(enterphone).enterEmail(enteremail).enterAddress(enteraddress).enterDeliveryTime(enterdeliverytime).enterDeliveryCharge(enterdeliverycharge).clickUpdate();
	  boolean alert = contactpage.isUpdatedSuccessfullyMessageDisplayed();
	  Assert.assertTrue(alert, Constant.ERROEMESSAGEWHENCONTACTDETAILUPDATIONFAILED);
	  
  }
}
