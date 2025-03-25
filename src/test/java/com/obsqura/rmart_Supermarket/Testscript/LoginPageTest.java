package com.obsqura.rmart_Supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart_Supermarket.pages.HomePage;
import com.obsqura.rmart_Supermarket.pages.LoginPage;

public class LoginPageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;
  @Test
  public void verifyUserCanLoginUsingValidUsernameAndPassword() {
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin", "admin");
	  homepage=loginpage.clickOnSignin();
	  String expected = "Dashboard | 7rmart supermarket";
	  String actual = driver.getTitle();
	  System.out.println(actual);
	  Assert.assertEquals(actual, expected, Constant.ERRORMESSAGEFORLOGIN);
  }
  
  @Test
  public void verifyUserCannotLoginUsingInvalidUsernameAndPassword() {
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin1123", "admi11n");
	  homepage= loginpage.clickOnSignin();
	  boolean text = loginpage.isSignInTextAppearsOnTop();
	  Assert.assertTrue(text, Constant.ERRORMESSAGEWHILELOGINWITHINVALIDCREDENTIALS);
  }
  @Test(dataProvider = "invalid credentials")
  public void verifyUserCannotLoginUsingValidUsernameAndInvalidPassword(String username,String password) {
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUsernameAndPassword(username,password);
	  homepage = loginpage.clickOnSignin();
	  boolean text = loginpage.isSignInTextAppearsOnTop();
	  Assert.assertTrue(text,Constant.ERRORMESSAGEWHILELOGINWITHINVALIDCREDENTIALS);
  }
  @Test
  @Parameters({"username","password"})
  public void verifyUserCannotLoginUsingInValidUsernameAndValidPassword(String username,String password) {
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUsernameAndPassword(username,password);
	  homepage = loginpage.clickOnSignin();
	  boolean text = loginpage.isSignInTextAppearsOnTop();
	  Assert.assertTrue(text, Constant.ERRORMESSAGEWHILELOGINWITHINVALIDCREDENTIALS);
  }
  
  @DataProvider(name = "invalid credentials")
  public Object[][] testData(){
	  Object data[][] = {{"admin","admin11"},{"admin","admin112"}};
	  return data;
  }
  

  }
