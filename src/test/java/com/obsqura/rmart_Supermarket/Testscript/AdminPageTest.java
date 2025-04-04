package com.obsqura.rmart_Supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart_Supermarket.pages.AdminPage;
import com.obsqura.rmart_Supermarket.pages.HomePage;
import com.obsqura.rmart_Supermarket.pages.LoginPage;
import com.obsqura.rmat_utilities.ExcelUtility;
import com.obsqura.rmat_utilities.FakerUtility;

public class AdminPageTest extends Base
{
	public LoginPage loginpage;
	public HomePage homepage;
	public AdminPage adminpage;
 FakerUtility faker = new FakerUtility() ;
  @Test
  public void verifyThatAdminCanCreateNewUserDetails() throws Exception {
	  LoginPage loginpage = new LoginPage(driver);
	  String username = ExcelUtility.readName(1, 0,"Adminpage");
	  String password = ExcelUtility.readName(1, 1,"Adminpage");
	  loginpage.enterUsernameAndPassword(username,password);
	  homepage=loginpage.clickOnSignin();
	  adminpage =homepage.clickonMoreInfo();
	  //String name = ExcelUtility.readName(1, 2,"Adminpage");
	  String name = faker.getFakeFirstName();
	  String passwordofuser = ExcelUtility.readName(1, 3,"Adminpage");
	  String usertype = ExcelUtility.readName(1, 4,"Adminpage");
	  adminpage.clickNewButton().enterDetails(name,passwordofuser,usertype).clickOnSave();
	  boolean alert = adminpage.isAlertSuccessShow();
	 Assert.assertTrue(alert, Constant.ERRORMESSAGEWHENUSERCREATIONFAILEDADMINPAGE);
  }
  @Test
  @Parameters({"username","password","usertype"})
  public void verifyThatAdminCannotCreateAlreadyExistingUser(String username,String password,String usertype) throws Exception {
	  LoginPage loginpage = new LoginPage(driver);
	  String username1 = ExcelUtility.readName(1, 0,"Adminpage");
	  String password1 = ExcelUtility.readName(1, 1,"Adminpage");
	  loginpage.enterUsernameAndPassword(username1,password1);
	  homepage=loginpage.clickOnSignin();
	  adminpage =homepage.clickonMoreInfo();
	  adminpage.clickNewButton().enterDetails(username,password,usertype).clickOnSave();
	  boolean alert = adminpage.isFailAlertShow();
	  Assert.assertTrue(alert, Constant.ERRORMESSAGEWHENALREADYEXISTINGUSERISCREATEDADMINPAGE);
  }
  @Test
  public void verifyThatAdminCanDeleteFirstUserInTheList() throws Exception {
	  LoginPage loginpage = new LoginPage(driver);
	  String username = ExcelUtility.readName(1, 0,"Adminpage");
	  String password = ExcelUtility.readName(1, 1,"Adminpage");
	  loginpage.enterUsernameAndPassword(username,password);
	  homepage=loginpage.clickOnSignin();
	  adminpage =homepage.clickonMoreInfo();
	  adminpage.clickDeleteIconOfFirstUserInTheList();
	  boolean alert = adminpage.isUserDeleteAlertAppears();
	  Assert.assertTrue(alert, Constant.ERROEMESSAGEWHENUSERDELETIONFAILED);
  }
  @Test
  public void verifyThatAdminCanSearchForAParticularUserUsingCorrectUsernameAndCorrectUsertype() throws Exception {
	  LoginPage loginpage = new LoginPage(driver);
	  String username = ExcelUtility.readName(1, 0,"Adminpage");
	  String password = ExcelUtility.readName(1, 1,"Adminpage");
	  loginpage.enterUsernameAndPassword(username,password);
	  homepage=loginpage.clickOnSignin();
	  adminpage =homepage.clickonMoreInfo();
	  String usernameforsearch = ExcelUtility.readName(1, 5, "Adminpage");
	  String usertypeforsearch = ExcelUtility.readName(1, 6, "Adminpage");
	  adminpage.clickOnSearchButtonInTheListPage().enterUsernameForSearch(usernameforsearch).selectUsertypeForSearch(usertypeforsearch).clickOnSearchAfterEnteringDetails();
	  boolean searchelementdisplayed = adminpage.isValidUsernameElementDisplayed();
	  Assert.assertTrue(searchelementdisplayed, Constant.ERROEMESSAGEWHENCORRECTUSERNAMEANDUSERTYPESEARCHFAILED);
  }
}
